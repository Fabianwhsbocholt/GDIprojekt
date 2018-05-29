package wm.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import wm.gui.FXML_Loader;
import wm.gui.WM2018;
import wm.objekte.DBConnector;
import wm.objekte.Preparation;


// In dieser Klasse k�nnen die Funktionen ausprogrammiert werden, die beim Ausl�sen von Events
// (z.B. Dr�cken eines Buttons) ausgef�hrt werden sollen



public class WMHandler implements EventHandler
{

	//GUI Button
	

	
	
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
		case "Testdaten einlesen" : 
			ausgabe.appendText(mainapp.getPrep().getDbConnect().datenEinlesen(true));	
			break;
		case "Spielergebnisse eingeben" : 
			mainapp.getFxml().showEingabe(mainapp);
			break;
		case "Programm beenden" :
			beenden(mainapp);
			break;
		
			
		}	
		
		
	}
		
	
	
	public void verbindungManuelle(WM2018 mainapp, TextArea ausgabeVerb, TextField ip, TextField datenbank, TextField port, TextField benutzer, TextField passwort) throws IOException {
		//manuelle Verbindung

		//Prüfen ob alle Felder gefüllt wurden
		if(ip.getText().equals("")) {
			ausgabeVerb.appendText("Bitte IP Adresse angeben. \n");
		}if(datenbank.getText().equals("")) {
			ausgabeVerb.appendText("Bitte Datenbank angeben. \n");
		}if(port.getText().equals("")) {
			ausgabeVerb.appendText("Bitte Port angeben. \n");
		}if(benutzer.getText().equals("")) {
			ausgabeVerb.appendText("Bitte Benutzer angeben. \n");
		}
		else {
			
			ausgabeVerb.appendText("Verbinde mich mit der Datenbank...\n");
			ausgabeVerb.appendText(passwort.getText());
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

	public void beenden(WM2018 mainapp) {
			System.exit(0);	
	}


	
	
	
	//Sebastian 
	/*public void spielergebnisse() {
	   // if(auswahl.toString().equals("Spielergebnisse eingeben"))
	    						
		//Neues Fenster öffnen
		loader = new FXMLLoader(getClass().getResource("Eingabe.fxml"));
		Scene scene1 = new Scene(loader.load());
		Stage stage1 = new Stage();
		
	    stage1.setTitle("New Window");
	    stage1.setScene(scene1);
	    stage1.show();
	    			        
	}*/
	
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

