package wm.gui.view;


// Jedes Formular ben�tigt einen Controller f�r die in ihm enthaltenen Elemente

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import wm.controller.WMHandler;
import wm.gui.FXML_Loader;
import wm.gui.WM2018;
import java.io.IOException;




public class WM2018MainController
{
	
	private FXMLLoader loader;
	private Stage primaryStage;
	private BorderPane	rootLayout;
	private WM2018	mainApp;
	
	@FXML private ChoiceBox<String> StatusBox;	
	@FXML private Button ok;
	//Verbindungsaufbau herstellen
	@FXML private Button absenden;
	@FXML private TextArea ausgabe;
	@FXML private BorderPane pane;
	@FXML RadioButton radio1;
	@FXML RadioButton radio2;
	@FXML ToggleGroup verbindungsart;
	
	@FXML
	// Diese Funktion wird ausgef�hrt, wenn sich das Formular �ffnet
	private void initialize ()
	{
		ok.setOnAction(ae -> {
			
			try {
				neuesFenster();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			beenden();
				
		});
		
	}
	
	@FXML
	private void neuesFenster () throws IOException {
		//Die gesetzte Wahl der Choice Box		
		String auswahl = StatusBox.getValue();
		
		if(auswahl.toString().equals("Verbindung zu Datenbank aufbauen")){
			
			//Neues Fenster öffnen
			loader = new FXMLLoader(getClass().getResource("Verbindung.fxml"));
			Scene scene = new Scene(loader.load());
			Stage stage = new Stage();
			
		     stage.setTitle("New Window");
		        stage.setScene(scene);
		        stage.show();

			/*loader = new FXMLLoader(getClass().getResource("Verbindung.fxml"));
			rootLayout = loader.load();
			primaryStage = new Stage();
			primaryStage.setTitle("Verbindung");
			primaryStage.setScene(new Scene (rootLayout));
			primaryStage.show();*/
		}
		        if(auswahl.toString().equals("Spielergebnisse eingeben")){
					
					//Neues Fenster öffnen
					loader = new FXMLLoader(getClass().getResource("Eingabe.fxml"));
					Scene scene1 = new Scene(loader.load());
					Stage stage1 = new Stage();
					
				     stage1.setTitle("New Window");
				        stage1.setScene(scene1);
				        stage1.show();
		        }
		        
		
		
	}
	@FXML
	/*private void verbindung() throws IOException {
		
		absenden.setOnAction(ae -> {
			if(radio1.isSelected()) {
				System.out.println("Test bestanden");
			}
		});
		
		
	}*/

	
	private void beenden() {
		//Die gesetzte Wahl der Choice Box
		String auswahl = StatusBox.getValue();
		
		if(auswahl.toString().equals("Programm beenden")){
			System.exit(0);
			
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