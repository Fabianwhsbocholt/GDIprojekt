package wm.gui.view;
 
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import wm.objekte.Configuration;
import wm.objekte.DBConnector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import wm.controller.Hilfsfunktionen;
import wm.gui.WM2018;
import wm.interfaces.DBConnectorI;
 
public class ControllerEingabe implements Initializable  {
 
   @FXML private Button myButton;
   @FXML private Button speichern;
   @FXML TextArea ausgabe = new TextArea();
   WM2018 mainapp;
  


@FXML //Textfelder aus denen später die Daten übernommen werden.
   static TextField toreheimhz;
   static TextField toregasthz;
   static TextField toreheimende;
   static TextField toregastende;
   static TextField gelbekartenheim;
   static TextField gelbekartengast;
   static TextField rotekartenheim;
   static TextField rotekartengast;
   static TextField toreelfheim;
   static TextField toreelfgast;
   static TextField toreverlheim;
   static TextField toreverlgast;
   
   //Check
   static TextField verlaengerung;
   static TextField spieleid;
   static boolean hzcheck;
   static boolean endecheck;
   static boolean verlcheck;
   static boolean elfcheck;
   
  
   @Override
   public void initialize(URL location, ResourceBundle resources) {
 
       // TODO (don't really need to do anything here).
      
   }
   @FXML
   public void ausgabe(ActionEvent Event)
	{

	   
	}

    private static Statement		statement;
   	private static Connection	connection;
	private static String			sql;
	private static ResultSet		rs;
	
	public ControllerEingabe ()
	{
		this.statement=null;
		this.connection=null;
		this.sql=null;
		this.rs=null;
	}
	
	//DB Verbindung
   
	String ipAdresse = "localhost";
	String db= "wm2018";
	String port= "3306";
	String benutzerName = "Seb";
	String passwort = "Seb";

	
	 public static String connect (String ipAdresse, String db, String port, String benutzerName, String passwort)
	    {
	        try
	        {
	            connection=DriverManager.getConnection(
	                    "jdbc:mysql://"+ipAdresse+":"+port + "/" + db +"?useSSL=false", benutzerName, passwort);
	        statement = connection.createStatement();
	         
	         
	        }
	        catch (Exception e)
	        {
	            return "Verbindung konnte nicht hergestellt werden!";
	            //throw new IllegalStateException(e);
	        }
	        return "Verbindung hergestellt!";
	    }
	
   

  //Funktion zum überprüfen der ID
   public static String idCheck(String id)
   {
       if(id.length() == 11)
           return id.substring(id.length()-2);
       else return id.substring(id.length()-1);  
   }
   
   
    //Eingabe der Spielergebnisse welche an die Datenbank übergeben werden. 
	@FXML
	public static String Eingabe()
	{
	    String toreheimhz = "";
	       String toregasthz = "";
	       String toreheimende = "";
	       String toregastende = "";
	       String rotekartenheim = "";
	       String rotekartengast = "";
	       String gelbekartenheim = "";
	       String gelbekartengast = "";
	       String toreelfheim = "";
	       String toreelfgast = "";
	       String toreverlheim = "";
	       String toreverlgast = "";
	       String verlaengerung = "";
	       
	       String spieleid ="";
	       
	       toreheimhz = ControllerEingabe.toreheimhz.getText();
	       toregasthz = ControllerEingabe.toreheimhz.getText();
	       toregastende =ControllerEingabe.toregastende.getText();
	       toreheimende =ControllerEingabe.toreheimende.getText();
	       gelbekartenheim = ControllerEingabe.gelbekartenheim.getText();
	       rotekartenheim = ControllerEingabe.rotekartenheim.getText();
	       gelbekartengast = ControllerEingabe.gelbekartengast.getText();
	       rotekartengast = ControllerEingabe.rotekartengast.getText();
	       toreverlheim = ControllerEingabe.toreverlheim.getText();
	       toreverlgast = ControllerEingabe.toreverlgast.getText();
	       
	       //Felder fehlen noch
	       toreelfheim =ControllerEingabe.toreelfheim.getText();
	       toreelfgast =ControllerEingabe.toreelfgast.getText();
	       verlaengerung =ControllerEingabe.verlaengerung.getText();	   
	       
	       //überprüfen
	       spieleid = ControllerEingabe.spieleid.getText();
	       hzcheck = true;
	       endecheck = true;
	       verlcheck = true;
	       
	       
	       if (!hzcheck == true && endecheck == true && verlcheck == true && elfcheck == true)
	       { 
	       toreheimhz = ControllerEingabe.toreheimhz.getText();
	       toregasthz = ControllerEingabe.toreheimhz.getText();
	       gelbekartenheim = ControllerEingabe.gelbekartenheim.getText();
	       rotekartenheim = ControllerEingabe.rotekartenheim.getText();
	       gelbekartengast = ControllerEingabe.gelbekartengast.getText();
	       rotekartengast = ControllerEingabe.rotekartengast.getText();
	      
           sql = "UPDATE spiele "
               + "SET heimmannschafthz = " + toreheimhz
               + ", gastmannschafthz = " + toregasthz
               + ", gelbekartenheim = " + gelbekartenheim
               + ", gelbekartengast = " + gelbekartengast
               + ", rotekartenheim = " + rotekartenheim
               + ", rotekartengast = " + rotekartengast
               + " WHERE spieleid = " + spieleid
               + ";";      
       }       
	       if (!hzcheck == true && !endecheck == true && verlcheck == true && elfcheck == true)
	       {
	    	   toreheimhz = ControllerEingabe.toreheimhz.getText();
		       toregasthz = ControllerEingabe.toreheimhz.getText();
		       toregastende =ControllerEingabe.toregastende.getText();
		       toreheimende =ControllerEingabe.toreheimende.getText();
		       gelbekartenheim = ControllerEingabe.gelbekartenheim.getText();
		       rotekartenheim = ControllerEingabe.rotekartenheim.getText();
		       gelbekartengast = ControllerEingabe.gelbekartengast.getText();
		       rotekartengast = ControllerEingabe.rotekartengast.getText();
	            
	            
	       sql = "UPDATE spiele "
	                   + "SET heimmannschafthz = " + toreheimhz
	                   + ", gastmannschafthz = " + toregasthz
	                   + ", heimmannschaftende = " + toreheimende
	                   + ", gastmannschaftende = " + toregastende
	                   + ", gelbekartenheim = " + gelbekartenheim
	                   + ", gelbekartengast = " + gelbekartengast
	                   + ", rotekartenheim = " + rotekartenheim
	                   + ", rotekartengast = " + rotekartengast
	                   + " WHERE spieleid = " + spieleid
	                   + ";";      
	       }
	       if (!hzcheck == true && !endecheck == true && !verlcheck == true && elfcheck == true)

	       {
	    	   toreheimhz = ControllerEingabe.toreheimhz.getText();
		       toregasthz = ControllerEingabe.toreheimhz.getText();
		       toregastende =ControllerEingabe.toregastende.getText();
		       toreheimende =ControllerEingabe.toreheimende.getText();
		       gelbekartenheim = ControllerEingabe.gelbekartenheim.getText();
		       rotekartenheim = ControllerEingabe.rotekartenheim.getText();
		       gelbekartengast = ControllerEingabe.gelbekartengast.getText();
		       rotekartengast = ControllerEingabe.rotekartengast.getText();
		       toreverlheim = ControllerEingabe.toreverlheim.getText();
		       toreverlgast = ControllerEingabe.toreverlgast.getText();
		       //vermutlich falsch --  verlaengerung = ErgebnisFrame.getVerl();

	           verlaengerung = ControllerEingabe.verlaengerung.getText();
	            
	           sql = "UPDATE spiele "
	                   + "SET heimmannschafthz = " + toreheimhz
	                   + ", gastmannschafthz = " + toregasthz
	                   + ", heimmannschaftende = " + toreheimende
	                   + ", gastmannschaftende = " + toregastende
	                   + ", verlaengerung = 1 "
	                   + ", heimmannschaftverl = " + toreverlheim
	                   + ", gastmannschaftverl = " + toreverlgast
	                   + ", gelbekartenheim = " + gelbekartenheim
	                   + ", gelbekartengast = " + gelbekartengast
	                   + ", rotekartenheim = " + rotekartenheim
	                   + ", rotekartengast = " + rotekartengast
	                   + " WHERE spieleid = " + spieleid
	                   + ";";      
	       }
	       
	       try {
	           statement.executeUpdate(sql);
	           }
	        
	       catch (SQLException e)
	       {
	           e.printStackTrace();
	           return "Spielergebnisse konnten nicht gespeichert werden.";
	       }
	        
	       return  "Ergebnis erfolgreich gespeichert";
	}


   public WM2018 getMainapp() {
		return mainapp;
   }
   
   public void setMainapp(WM2018 mainapp) {
		this.mainapp = mainapp;
   }
	
   public void setTextArea(TextArea ausgabe) {
		this.ausgabe = ausgabe;
		
	}

	public TextArea getAusgabeVerb() {
		return ausgabe;
	}
  

}
