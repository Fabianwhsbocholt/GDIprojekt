package wm.gui.view;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import wm.objekte.DBConnector;
import wm.controller.Hilfsfunktionen;
import wm.controller.WMHandler;
import wm.gui.WM2018;
import wm.main.WM2018main;
import wm.objekte.Configuration;
import wm.objekte.Preparation;
import wm.controller.Hilfsfunktionen;
import wm.objekte.Configuration;
import wm.objekte.DBConnector;
import java.sql.Connection;


public class ControllerVerbindung {
	
	
	
	//private WMHandler handler = new WMHandler();
	@FXML Button absenden = new Button();
	@FXML RadioButton radio1 = new RadioButton();
	@FXML RadioButton radio2 = new RadioButton();
	@FXML TextArea ausgabeVerb = new TextArea();
	@FXML TextField ip = new TextField();
	@FXML TextField datenbank = new TextField();
	@FXML TextField port = new TextField();
	@FXML TextField benutzer = new TextField();
	@FXML PasswordField passwort = new PasswordField();

	WM2018 mainapp;
	Preparation prep;
	
	private WMHandler WMHandler = new WMHandler();

	@FXML
	// Diese Funktion wird ausgef�hrt, wenn sich das Formular �ffnet
	private void initialize () 
	{	
		
	}
	
	public void absenden () throws IOException {

		if(radio2.isSelected()) {
			WMHandler.verbindungLive(mainapp, ausgabeVerb);
			//mainapp.getDialogStage().close();
		}
		else {
			WMHandler.verbindungManuelle(mainapp, ausgabeVerb, ip, datenbank, port, benutzer ,passwort);
			//mainapp.getDialogStage().close();
		}
	}

	public Preparation getPrep() {
		return prep;
	}

	public void setPrep(Preparation prep) {
		this.prep = prep;
	}

	public WM2018 getMainapp() {
		return mainapp;
	}

	public void setMainapp(WM2018 mainapp) {
		this.mainapp = mainapp;
	}

	public void setTextArea(TextArea ausgabeVerb) {
		this.ausgabeVerb = ausgabeVerb;
		
	}

	public TextArea getAusgabeVerb() {
		return ausgabeVerb;
	}

	public void setAusgabeVerb(TextArea ausgabeVerb) {
		this.ausgabeVerb = ausgabeVerb;
	}

	

}
