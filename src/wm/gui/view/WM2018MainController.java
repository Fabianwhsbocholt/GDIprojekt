package wm.gui.view;


import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// Jedes Formular ben�tigt einen Controller f�r die in ihm enthaltenen Elemente

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;

import wm.controller.WMHandler;
import wm.gui.WM2018;


public class WM2018MainController
{
	
	private WM2018	mainApp;
	private WMHandler handler = new WMHandler();
	@FXML private Button ok;
	@FXML TextArea ausgabeVerb;
	
	
	@FXML public ChoiceBox<String> StatusBox = new ChoiceBox<String>();


	@FXML
	// Diese Funktion wird ausgef�hrt, wenn sich das Formular �ffnet
	private void initialize ()
	{
		
		String auswahl = StatusBox.getValue();
		
		switch(auswahl) {
		
		case "Verbindung zur Datenbank aufbauen" : 
		
			
			try {
				handler.neuesFenster();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		break;
		
		
		case "Tabellen löschen und neu anlegen" :
			handler.tabellenAnlegen();
			break;
		
		case "Programm beenden" :
			handler.beenden();
			break;
		
			
		}	
		
		
	}
	


	public void setMainApp (WM2018 mainApp)
	{
		this.mainApp=mainApp;
	}
	
	public WM2018 getMainApp ()
	{
		return mainApp;
	}

	
}