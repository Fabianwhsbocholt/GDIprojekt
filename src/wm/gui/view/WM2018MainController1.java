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
import wm.main.WM2018main;
import wm.objekte.Configuration;
import wm.objekte.Preparation;
import wm.controller.Hilfsfunktionen;
import wm.objekte.Configuration;
import wm.objekte.DBConnector;
import java.sql.Connection;


public class WM2018MainController1 {
	
	
	
	private WMHandler handler = new WMHandler();
	@FXML Button absenden;
	@FXML RadioButton radio1;
	@FXML RadioButton radio2;
	

	
	@FXML
	// Diese Funktion wird ausgef�hrt, wenn sich das Formular �ffnet
	private void initialize () throws IOException
	{	
		System.out.println("Test");
		
		
		if(radio2.isSelected()) {
			handler.verbindungLive();
		}
		else {
			handler.verbindungManuelle();
		}
	}

}
