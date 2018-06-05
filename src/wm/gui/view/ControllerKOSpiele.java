package wm.gui.view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import wm.controller.WMHandler;
import wm.gui.WM2018;

	public class ControllerKOSpiele implements Initializable{
		
	@FXML private Button speichern = new Button();
	@FXML TextArea ausgabe = new TextArea();
	private WMHandler WMHandler = new WMHandler();
	WM2018 mainapp;
	
	@FXML TextField achtelfinaleheim1 = new TextField();
	@FXML TextField achtelfinalegast1 = new TextField();
	@FXML TextField achtelfinaleheim2 = new TextField();
	@FXML TextField achtelfinalegast2 = new TextField();
	@FXML TextField achtelfinaleheim3 = new TextField();
	@FXML TextField achtelfinalegast3 = new TextField();
	@FXML TextField achtelfinaleheim4 = new TextField();
	@FXML TextField achtelfinalegast4 = new TextField();
	@FXML TextField achtelfinaleheim5 = new TextField();
	@FXML TextField achtelfinalegast5 = new TextField();
	@FXML TextField achtelfinaleheim6 = new TextField();
	@FXML TextField achtelfinalegast6 = new TextField();
	@FXML TextField achtelfinaleheim7 = new TextField();
	@FXML TextField achtelfinalegast7 = new TextField();
	@FXML TextField achtelfinaleheim8 = new TextField();
	@FXML TextField achtelfinalegast8 = new TextField();
	@FXML TextField viertelfinaleheim1 = new TextField();
	@FXML TextField viertelfinalegast1 = new TextField();
	@FXML TextField viertelfinaleheim2 = new TextField();
	@FXML TextField viertelfinalegast2 = new TextField();
	@FXML TextField viertelfinaleheim3 = new TextField();
	@FXML TextField viertelfinalegast3 = new TextField();
	@FXML TextField viertelfinaleheim4 = new TextField();
	@FXML TextField viertelfinalegast4 = new TextField();
	@FXML TextField halbfinaleheim1 = new TextField();
	@FXML TextField halbfinalegast1 = new TextField();
	@FXML TextField halbfinaleheim2 = new TextField();
	@FXML TextField halbfinalegast2 = new TextField();
	@FXML TextField platz3heim = new TextField();
	@FXML TextField platz3gast = new TextField();
	@FXML TextField finaleheim = new TextField();
	@FXML TextField finalegast = new TextField();
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	@FXML
	public void speichern () {
		WMHandler.koSpieleEingeben(mainapp, ausgabe, achtelfinaleheim1, achtelfinaleheim2,
					achtelfinaleheim3, achtelfinaleheim4, achtelfinaleheim5, achtelfinaleheim6,
					achtelfinaleheim7, achtelfinaleheim8, achtelfinalegast1, achtelfinalegast2,
					achtelfinalegast3, achtelfinalegast4, achtelfinalegast5, achtelfinalegast6,
					achtelfinalegast7, achtelfinalegast8, viertelfinaleheim1,viertelfinaleheim2,
					viertelfinaleheim3, viertelfinaleheim4, viertelfinalegast1, viertelfinalegast2,
					viertelfinalegast3, viertelfinalegast4, halbfinaleheim1, halbfinaleheim2,
					halbfinalegast1, halbfinalegast2, platz3heim, platz3gast, finaleheim,
					finalegast);
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
