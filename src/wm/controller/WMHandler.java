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
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import wm.objekte.DBConnector;
import wm.objekte.Preparation;


// In dieser Klasse k�nnen die Funktionen ausprogrammiert werden, die beim Ausl�sen von Events
// (z.B. Dr�cken eines Buttons) ausgef�hrt werden sollen



public class WMHandler implements EventHandler
{

	private Stage primaryStage;
	private BorderPane	rootLayout;
	
	//GUI Button
		
	@FXML TextArea ausgabe;
	@FXML ToggleGroup verbindungsart;

	
	//GUI Button
	@FXML private Button absenden;
	@FXML RadioButton radio1;
	@FXML RadioButton radio2;
	@FXML TextField ip;
	@FXML TextField datenbank;
	@FXML TextField port;
	@FXML TextField benutzer;
	@FXML PasswordField passwort;
	@FXML TextArea ausgabeVerb;
	
	
	DBConnector connect = new DBConnector();
	Preparation preparation = new Preparation();
	Connection connection;
	@FXML FXMLLoader loader;
	
	//Konstruktor
	public WMHandler()
	{
		
	}
	
	@Override
	public void handle(Event event) {
		// TODO Auto-generated method stub
		
	}
		
	
	
	@FXML
	public void neuesFenster () throws IOException {

		
		//Versuch 1
		//loader = new FXMLLoader(getClass().getResource("../gui/view/Verbindung.fxml"));
		loader = FXMLLoader.load(getClass().getResource("../gui/view/Verbindung.fxml"));
		primaryStage = new Stage();

		primaryStage.setTitle("Verbindung");
		
		Scene scene = new Scene(rootLayout);
		//rootLayout = loader.load();
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	@FXML
	public void verbindungManuelle() throws IOException {
		//manuelle Verbindung

		//Prüfen ob alle Felder gefüllt wurden
		if(ip.getText().equals("")) {
			ip.setText("Bitte IP Adresse angeben.");
		}if(datenbank.getText().equals("")) {
			datenbank.setText("Bitte Datenbank angeben.");
		}if(port.getText().equals("")) {
			port.setText("Bitte Port angeben.");
		}if(benutzer.getText().equals("")) {
			benutzer.setText("Bitte Benutzer angeben.");
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
	
	public void verbindungLive() throws IOException{
		
		ausgabeVerb.appendText("Konfigurationsdaten aus Datei lesen...\n");
		preparation.erstelleKonfiguration();
		ausgabeVerb.appendText("Konfiguration erstellt...\n");
		ausgabeVerb.appendText("Verbinde mich mit der Datenbank...\n");
		ausgabeVerb.appendText(connect.connect(preparation.getConfig()));

	}
	
	public void tabellenAnlegen () {
		ausgabe.setText("Test");
		System.out.println("Test");

		ausgabeVerb.appendText("Konfigurationsdaten aus Datei lesen...\n");
		preparation.erstelleKonfiguration();
		ausgabeVerb.appendText("Konfiguration erstellt...\n");
		ausgabeVerb.appendText("Verbinde mich mit der Datenbank...\n");
		ausgabe.appendText(connect.connect(preparation.getConfig()));
		ausgabe.appendText(connect.tabellenAnlegen());

	}

	public void beenden() {
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

