package wm.objekte;

// Diese Klasse erstellt ein Objekt DBConnector, das in der Lage ist, die benötigten Informationen aus der Datenbank zu holen,
// damit sie im Programm dann weiterverarbeitet werden können.

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import wm.controller.Hilfsfunktionen;
import wm.interfaces.DBConnectorI;

public class DBConnector implements DBConnectorI
{
	private Statement		statement;
	private Connection	connection;
	private String			sql;
	private ResultSet		rs;
	
	public DBConnector ()
	{
		this.statement=null;
		this.connection=null;
		this.sql=null;
		this.rs=null;
	}
	
	@Override
	public String connect (Configuration config)
	{
		try
		{
			connection=DriverManager.getConnection(
			    "jdbc:mariadb://"+config.getIp()+":"+config.getPort()+"/"+config.getDb()+"?useSSL=false",
			    config.getUser(), config.getPass());
		}
		catch (Exception e)
		{
			return "Verbindung zur Datenbank "+config.getDb()+" konnte mit \nBenutzername: "
			    +config.getUser()+" und\nPasswort: "+config.getPass()+"\nnicht hergestellt werden!\n";
		}
		return "Verbindung zur Datenbank "+config.getDb()+" hergestellt!\n";
	}
	
	public String tabellenAnlegen ()
	{
		if (this.connection!=null)
		{
			try
			{
				this.statement=connection.createStatement();
				
				this.statement.addBatch("DROP TABLE IF EXISTS ranking");
				this.statement.addBatch("DROP TABLE IF EXISTS tipps");
				this.statement.addBatch("DROP TABLE IF EXISTS benutzer");
				this.statement.addBatch("DROP TABLE IF EXISTS spiele");
				this.statement.executeBatch();
				
				sql="CREATE TABLE benutzer"+"(benutzerid INT AUTO_INCREMENT NOT NULL,"
				    +"benutzerName VARCHAR(20),"+"autologin VARCHAR(32),"+"IP VARCHAR(15) NOT NULL,"
				    +"sessionID VARCHAR(32) NOT NULL,"+"nickname VARCHAR(30) NOT NULL,"
				    +"passwort VARCHAR(32) NOT NULL,"+"gruppenname VARCHAR(32),"
				    +"email VARCHAR(70) NOT NULL,"+"show_Email BIT(1),"+"registrierungsdatum DATE,"
				    +"PRIMARY KEY (benutzerid),"+"UNIQUE (nickname, email))";
				
				this.statement.addBatch(sql);
				
				sql="CREATE TABLE spiele "+"(spieleid INT (10) AUTO_INCREMENT NOT NULL,"
				    +"spielbezeichnung VARCHAR(20),"+"spielort VARCHAR(20),"+"datumuhrzeit DATETIME(0),"
				    +"heimmannschaft VARCHAR(20),"+"gastmannschaft VARCHAR(20),"
				    +"heimmannschafthz INT(2) DEFAULT NULL,"+"gastmannschafthz INT(2) DEFAULT NULL,"
				    +"heimmannschaftende INT(2) DEFAULT NULL,"+"gastmannschaftende INT(2) DEFAULT NULL,"
				    +"verlaengerung BIT(1) DEFAULT 0,"+"heimmannschaftverl INT(2) DEFAULT NULL,"
				    +"gastmannschaftverl INT(2) DEFAULT NULL,"+"elfmeter BIT(1) DEFAULT 0,"
				    +"heimmannschaftelf INT(2) DEFAULT NULL,"+"gastmannschaftelf INT(2) DEFAULT NULL,"
				    +"gelbekartenheim INT(2) DEFAULT NULL,"+"gelbekartengast INT(2) DEFAULT NULL,"
				    +"rotekartenheim INT(2) DEFAULT NULL,"+"rotekartengast INT(2) DEFAULT NULL,"
				    +"PRIMARY KEY (spieleid))";
				
				this.statement.addBatch(sql);
				
				sql="CREATE TABLE tipps "+"(tippid INT(10) NOT NULL AUTO_INCREMENT,"+"benutzerid INT(10),"
				    +"spieleid INT(10),"+"tippdatum DATETIME(0),"+"tippheimhz INT(4),"+"tippgasthz INT(4),"
				    +"tippheimende INT(4),"+"tippgastende INT(4),"+"tippheimverl INT(4),"
				    +"tippgastverl INT(4),"+"tippheimelf INT(4),"+"tippgastelf INT(4),"
				    +"tippgelbeheim INT(4),"+"tippgelbegast INT(4),"+"tipproteheim INT(4),"
				    +"tipprotegast INT(4),"+"PRIMARY KEY (tippid),"+"INDEX FK_tipps_benutzer (benutzerid),"
				    +"INDEX FK_tipps_spiele (spieleid),"
				    +"CONSTRAINT FK_tipps_benutzer FOREIGN KEY (benutzerid) REFERENCES benutzer (benutzerid),"
				    +"CONSTRAINT FK_tipps_spiele FOREIGN KEY (spieleid) REFERENCES spiele (spieleid))";
				
				this.statement.addBatch(sql);
				
				sql="CREATE TABLE ranking "+"(datum DATETIME(0),"+"benutzerid INT(11),"+"punkte INT(10),"
				    +"platz INT(10),"+"INDEX FK_ranking_benutzer (benutzerid),"
				    +"CONSTRAINT FK_ranking_benutzer FOREIGN KEY (benutzerid) REFERENCES benutzer (benutzerid))";
				
				this.statement.addBatch(sql);
				
				this.statement.executeBatch();
				
			}
			catch (SQLException e)
			{
				return "Vorgang fehlgeschlagen!\n";
			}
			return "Tabellen gelöscht.\n"+"Tabellen benutzer, spiele, tipps und ranking neu erstellt!\n";
		}
		else
			return "Bitte erst eine Verbindung herstellen!\n";
	}
	
	public String datenEinlesen (boolean testdaten)
	{
		String datei=testdaten==true? "spiele_wm2018_test.txt": "spiele_wm2018.txt";
		String meldung="Spieldaten eingelesen!\n";
		
		if (this.connection!=null)
		{
			try
			{
				if (this.statement==null)
					this.statement=connection.createStatement();
				
				sql="LOAD DATA LOCAL INFILE './tabellen/"+datei
				    +"' INTO TABLE spiele FIELDS TERMINATED BY ';' LINES TERMINATED BY 'endOfLine'";
				this.statement.execute(sql);
				
				if (testdaten)
				{
					sql="LOAD DATA LOCAL INFILE './tabellen/benutzer.txt' INTO TABLE benutzer FIELDS TERMINATED BY ';'";
					this.statement.execute(sql);
					
					sql="LOAD DATA LOCAL INFILE './tabellen/tipps.txt' INTO TABLE tipps FIELDS TERMINATED BY ';'";
					this.statement.execute(sql);
					meldung="Benutzer-, Testspiel- und Testtippdaten eingelesen!\n";
				}
			}
			catch (SQLException e)
			{
				return "Fehler beim Einlesen der Daten!\n";
			}
			
			return meldung;
		}
		else
			return "Bitte erst eine Verbindung herstellen!\n";
	}
	
	public String spielplan ()
	{			
			String ergebnis="=======================================================================================================================\n";
			ergebnis+=			"Gruppe\t\tDatum\t\tAnstoss\t\tHeimmannschaft\t       -\t Gastmannschaft\t\tSpielort\n";
			ergebnis+=			"=======================================================================================================================\n";
			
			try
			{
				if (statement==null)
					statement=connection.createStatement();
				
				sql	=	"select spielbezeichnung, datumuhrzeit, heimmannschaft, gastmannschaft, spielort "
				    +	"from spiele "
				    +	"order by datumuhrzeit";
				
				rs=statement.executeQuery(sql);
				
				while (rs.next())
				{					
					ergebnis+=rs.getString("spielbezeichnung")+"\t"
					    +new SimpleDateFormat("dd.MM.yyyy").format(new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("datumuhrzeit")))
					    +"\t"+rs.getString("datumuhrzeit").substring(11,16)+"\t"
					    +"\t"+rs.getString("Heimmannschaft")+Hilfsfunktionen.leerzeichen(22,rs.getString("heimmannschaft"))+" - "
					    + Hilfsfunktionen.leerzeichen(22,rs.getString("gastmannschaft"))+rs.getString("gastmannschaft")+"\t\t"+rs.getString("spielort")+"\n";
				}			
							
				rs.close();
			}
			catch (Exception e)
			{
				return "Fehler - Spielplanausgabe nicht möglich!";
			}
			return ergebnis;
	}
		
		@Override
		public String close ()
		{
			if (connection!=null)
			{
				try
				{
					connection.close();
					if (statement!=null)
						statement.close();
				}
				catch (SQLException e)
				{
					System.out.println("Fehler beim Beenden der Verbindung!\n");
				}
				return "Verbindung getrennt!\n";
			}
			else
				return "Es ist keine Verbindung vorhanden!\n";
		
	}
	
	
	
	public Statement getStatement ()
	{
		return statement;
	}
	
	public void setStatement (Statement statement)
	{
		this.statement=statement;
	}
	
	public Connection getConnection ()
	{
		return connection;
	}
	
	public void setConnection (Connection connection)
	{
		this.connection=connection;
	}
	
	public String getSql ()
	{
		return sql;
	}
	
	public void setSql (String sql)
	{
		this.sql=sql;
	}
	
	public ResultSet getRs ()
	{
		return rs;
	}
	
	public void setRs (ResultSet rs)
	{
		this.rs=rs;
	}
}
