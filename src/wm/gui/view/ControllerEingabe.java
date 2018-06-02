package wm.gui.view;
 
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
import wm.controller.WMHandler;
import wm.gui.WM2018;
import wm.interfaces.DBConnectorI;
 
public class ControllerEingabe implements Initializable  {
 
   @FXML private Button speichern = new Button();
   @FXML TextArea ausgabe = new TextArea();
   private WMHandler WMHandler = new WMHandler();
   WM2018 mainapp;
  
   //Textfelder für die Spielergebniseingabe
   @FXML TextField gruppe = new TextField();
   @FXML TextField datetime = new TextField();
   @FXML TextField heimmannschaft = new TextField();
   @FXML TextField gastmannschaft = new TextField();
   @FXML TextField toreheimhz = new TextField();
   @FXML TextField toregasthz = new TextField();
   @FXML TextField toreheimende = new TextField();
   @FXML TextField toregastende = new TextField();
   @FXML TextField heimgelb = new TextField();
   @FXML TextField gastgelb = new TextField();
   @FXML TextField heimrot = new TextField();
   @FXML TextField gastrot = new TextField();
   @FXML TextField heimgelbrot = new TextField();
   @FXML TextField gastgelbrot = new TextField();

   String id;
  
   
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
   public void speichern ()
	{
	   WMHandler.spielergebnisseEingabe(mainapp, ausgabe, getId(), toreheimhz, toregasthz, toreheimende, toregastende, heimgelb, gastgelb, heimrot, 
			   gastrot, heimgelbrot, gastgelbrot);
	   festeWerte(mainapp, ausgabe, gruppe, datetime, heimmannschaft, gastmannschaft);
	   
	}
 
	public void festeWerte(WM2018 mainapp, TextArea ausgabe, TextField gruppe, TextField datetime, TextField heimmannschaft, TextField gastmannschaft) {
	  // Stage stage = mainapp.getEingabeStage();
	List<String []> spieleSammeln = mainapp.getPrep().getDbConnect().spieleSammeln();
	   
		for(String [] spiele : spieleSammeln) {
		//ausgabe.appendText(spiele[1] + spiele[3] + spiele[4] + spiele[5] + "\n");
		
		
			setId(spiele[0]);
			gruppe.setText(spiele[1]);
			datetime.setText(spiele[3]);
			heimmannschaft.setText(spiele[4]);
			gastmannschaft.setText(spiele[5]);
		}
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
		
   public TextField getGruppe() {
		return gruppe;
	}
	public void setGruppe(TextField gruppe) {
		this.gruppe = gruppe;
	}
	public TextField getDatetime() {
		return datetime;
	}
	public void setDatetime(TextField datetime) {
		this.datetime = datetime;
	}
	public TextField getHeimmannschaft() {
		return heimmannschaft;
	}
	public void setHeimmannschaft(TextField heimmannschaft) {
		this.heimmannschaft = heimmannschaft;
	}
	public TextField getGastmannschaft() {
		return gastmannschaft;
	}
	public void setGastmannschaft(TextField gastmannschaft) {
		this.gastmannschaft = gastmannschaft;
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
