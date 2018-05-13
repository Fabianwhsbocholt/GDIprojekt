package wm.gui;


// Startklasse, hier sind jetzt Sie gefragt

import javafx.application.Application;

import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class WM2018 extends Application
{	
    private Stage primaryStage;
	private BorderPane	rootLayout;
	private FXML_Loader fxml;
	


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
		this.fxml = new FXML_Loader();
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
