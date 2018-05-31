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
import wm.controller.WMHandler;
import wm.gui.WM2018;
import wm.interfaces.DBConnectorI;
 
public class ControllerEingabe implements Initializable  {
 
   @FXML private Button speichern = new Button();
   @FXML TextArea ausgabe = new TextArea();
   private WMHandler WMHandler = new WMHandler();
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
   public void Spielergebnisse(ActionEvent Event)
	{
	   WMHandler.spielergebnisseEingabe(mainapp);
	   
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
