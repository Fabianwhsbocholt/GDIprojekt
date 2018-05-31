package wm.controller;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import javafx.event.*;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import wm.gui.WM2018;
import wm.objekte.DBConnector;



// In dieser Klasse k�nnen die Funktionen ausprogrammiert werden, die beim Ausl�sen von Events
// (z.B. Dr�cken eines Buttons) ausgef�hrt werden sollen



public class WMHandler implements EventHandler
{

	DBConnector connect = new DBConnector();
	Connection connection;

	public WMHandler() {
		
	}	
	
	@Override
	public void handle(Event event) {
		// TODO Auto-generated method stub

	}
	
	
	public void wahl(WM2018 mainapp, ChoiceBox<String> StatusBox, TextArea ausgabe) {
		
		String auswahl = StatusBox.getValue();
		switch(auswahl) {
		
		case "Verbindung zur Datenbank aufbauen" : 
			mainapp.getFxml().showVerbindung(mainapp, ausgabe);
			break;
		case "Tabellen löschen und neu anlegen" :
			tabellenAnlegen(mainapp, ausgabe);
			break;
		case "Echtdaten einlesen" :
			ausgabe.appendText(mainapp.getPrep().getDbConnect().datenEinlesen(false));	
			break;
		case "Testdaten einlesen" : 
			ausgabe.appendText(mainapp.getPrep().getDbConnect().datenEinlesen(true));	
			break;
		case "Spielplan ausgeben" :
			spielplanAusgabe(mainapp, mainapp.getPrep().getDbConnect(), ausgabe);
			break;
		case "Spielergebnisse eingeben" : 
			mainapp.getFxml().showEingabe(mainapp, ausgabe);
			break;
		case "Tipps auswerten - Ranking speichern" : 
			mainapp.getFxml().showEingabe(mainapp, ausgabe);
			break;
		case "Aktuelles Ranking ansehen" : 
			mainapp.getFxml().showEingabe(mainapp, ausgabe);
			break;
		case "Verbindung trennen" :
			ausgabe.appendText(mainapp.getPrep().getDbConnect().close());
			break;
		case "Programm beenden" :
			beenden(mainapp);
			break;
		
			
		}	
		
		
	}
		
	
	
	public void verbindungManuelle(WM2018 mainapp, TextArea ausgabeVerb, TextField ip, TextField datenbank, TextField port, TextField benutzer, TextField passwort) throws IOException {
		//manuelle Verbindung

		//Prüfen ob alle Felder gefüllt wurden
		if(ip.getText().equals("") | datenbank.getText().equals("") | port.getText().equals("") | benutzer.getText().equals("") | passwort.getText().equals("")) {
			ausgabeVerb.appendText("Bitte alle Felder ausfüllen. \n");
		}
		else {
			
			ausgabeVerb.appendText("Verbinde mich mit der Datenbank...\n");
			try {
				connection=DriverManager.getConnection(
					    "jdbc:mariadb://"+ip.getText()+":"+port.getText()+"/"+datenbank.getText()+"?useSSL=false",
					    benutzer.getText(), passwort.getText());

				if(connection.isValid(3)){
					ausgabeVerb.appendText("Verbindung zur Datenbank "+datenbank.getText()+" hergestellt!\n");
				}
				else {
					ausgabeVerb.appendText("Verbindung zur Datenbank "+datenbank.getText()+" konnte mit \nBenutzername: "
						    +benutzer.getText()+" und\nPasswort: "+passwort.getText()+"\nnicht hergestellt werden!\n");		
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
				 
		}
		
	}
	
	public void verbindungLive(WM2018 mainapp, TextArea ausgabeVerb) throws IOException{
		ausgabeVerb.appendText("Konfigurationsdaten aus Datei lesen...\n");
		mainapp.getPrep().erstelleKonfiguration();
		ausgabeVerb.appendText("Konfiguration erstellt...\n");
		ausgabeVerb.appendText("Verbinde mich mit der Datenbank...\n");
		ausgabeVerb.appendText(mainapp.getPrep().getDbConnect().connect(mainapp.getPrep().getConfig()));
	}
	
	public void tabellenAnlegen (WM2018 mainapp, TextArea ausgabe) {

		ausgabe.appendText(mainapp.getPrep().getDbConnect().tabellenAnlegen());	
	}
	
	//Spielplan ausgeben (Fabian)
	public static void spielplanAusgabe(WM2018 mainapp, DBConnector dbcon, TextArea ausgabe)
	{
	
		
		List<String[]> spielplan = dbcon.spielplanAusgeben();
		
	//	SimpleDateFormat sdf = new SimpleDateFormat("jjjj:MM:dd" + "HH:mm:ss");
		
		ausgabe.appendText("| Spielbezeichnung \t | DatumUhrzeit \t \t \t \t | Heimmannschaft \t | Gastmannschaft \t \t | Spielort| \n");
		
		for(String[] spiel : spielplan) {
			ausgabe.appendText("| "+spiel[0]+" \t \t \t | "+spiel[1]+" \t \t | "+spiel[2]+" \t \t \t | "+spiel[3]+" \t \t| "+spiel[4]+" | \n");
		}

	}

	public void beenden(WM2018 mainapp) {
			System.exit(0);	
	}
	
	public void spielergebnisseEingabe(WM2018 mainapp) {
		
		
	}

	//Anzeige der Spielgruppe
	/*public void ausgabe() {  
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql ="Select * From spiele where spielort = Moskau";
		
		
		try {
			rs = stmt.executeQuery(sql);
			System.out.println(rs);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}*/
	
	
}

	
