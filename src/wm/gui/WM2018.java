package wm.gui;


// Startklasse, hier sind jetzt Sie gefragt

import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import wm.objekte.Preparation;

public class WM2018 extends Application
{	
    private Stage primaryStage;
	private BorderPane	rootLayout;
	private Stage DialogStage;
	private BorderPane DialogLayout;
	private Stage eingabeStage;
	private BorderPane eingabeLayout;
	private Stage kospieleStage;
	private BorderPane kospieleLayout;
	private FXML_Loader fxml;
	private Preparation prep;




	@Override
	public void start (Stage primaryStage)
	{
		this.primaryStage.setTitle("WM2018");
		fxml.showWM2018(this);
		fxml.initRootLayout(this);
		
	}
	
	
	//Konstruktor
	public WM2018() {
		this.rootLayout = new BorderPane();
		this.primaryStage = new Stage();
		this.DialogStage = new Stage();
		this.DialogLayout = new BorderPane();
		this.eingabeStage = new Stage();
		this.eingabeLayout = new BorderPane();
		this.kospieleStage = new Stage();
		this.kospieleLayout = new BorderPane();
		this.fxml = new FXML_Loader();
		this.prep = new Preparation();
	}
	
	
	
	public Stage getKospieleStage() {
		return kospieleStage;
	}


	public void setKospieleStage(Stage kospieleStage) {
		this.kospieleStage = kospieleStage;
	}


	public BorderPane getKospieleLayout() {
		return kospieleLayout;
	}


	public void setKospieleLayout(BorderPane kospieleLayout) {
		this.kospieleLayout = kospieleLayout;
	}


	public Stage getEingabeStage() {
		return eingabeStage;
	}


	public void setEingabeStage(Stage eingabeStage) {
		this.eingabeStage = eingabeStage;
	}


	public BorderPane getEingabeLayout() {
		return eingabeLayout;
	}


	public void setEingabeLayout(BorderPane eingabeLayout) {
		this.eingabeLayout = eingabeLayout;
	}
	
	public Stage getDialogStage() {
		return DialogStage;
	}


	public void setDialogStage(Stage dialogStage) {
		DialogStage = dialogStage;
	}


	public BorderPane getDialogLayout() {
		return DialogLayout;
	}


	public void setDialogLayout(BorderPane dialogLayout) {
		DialogLayout = dialogLayout;
	}
	
	
	
	public Preparation getPrep() {
		return prep;
	}


	public void setPrep(Preparation prep) {
		this.prep = prep;
	}

	
	public BorderPane getRootLayout ()
	{
		return rootLayout;
	}
	
	public void setRootLayout (BorderPane rootLayout)
	{
		this.rootLayout=rootLayout;
	}
	
	public Stage getPrimaryStage ()
	{
		return primaryStage;
	}
	
	public void setPrimaryStage (Stage primaryStage)
	{
		this.primaryStage=primaryStage;
	}	
	
	public FXML_Loader getFxml() {
		return fxml;
	}

	public void setFxml(FXML_Loader fxml) {
		this.fxml = fxml;
	}
	
	public static void losGehts ()
	{
		launch();
	}


	
}
