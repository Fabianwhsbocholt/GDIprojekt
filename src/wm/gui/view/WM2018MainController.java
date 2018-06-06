package wm.gui.view;


// Jedes Formular ben�tigt einen Controller f�r die in ihm enthaltenen Elemente

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import wm.controller.WMHandler;
import wm.gui.WM2018;


public class WM2018MainController
{
	
	private WMHandler WMHandler = new WMHandler();
	WM2018 mainapp;
	@FXML ChoiceBox <String> StatusBox = new ChoiceBox <String>();
	@FXML TextArea ausgabe = new TextArea();
	@FXML Button ok = new Button();

	@FXML
	// Diese Funktion wird ausgef�hrt, wenn sich das Formular �ffnet
	private void initialize ()
	{	
		
	}
	
	public void ok() {			
		WMHandler.wahl(mainapp, StatusBox, ausgabe);		
	}
	
	
	public WM2018 getMainapp() {
		return mainapp;
	}

	public void setMainapp(WM2018 mainapp) {
		this.mainapp = mainapp;
	}
	
}