package wm.gui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import wm.gui.view.ControllerEingabe;
import wm.gui.view.ControllerVerbindung;
import wm.gui.view.WM2018MainController;

// Aus Gr�nden der Programmstrukturierung gibt es eine eigene Klasse f�r die FXML_Loader
// Hier sind jetzt wieder Sie am Zug


public class FXML_Loader
{

	public void initRootLayout (WM2018 mainapp)
	{
		
		try
		{
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(WM2018.class.getResource("view/RootLayout.fxml"));
			mainapp.setRootLayout((BorderPane)loader.load());

            WM2018MainController Con = loader.getController();
            Con.setMainapp(mainapp);
            
            
			Scene scene=new Scene(mainapp.getRootLayout());
			mainapp.getPrimaryStage().setScene(scene);
			mainapp.getPrimaryStage().show();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
	   
	}
	
	
	public void showWM2018 (WM2018 mainapp)
	{

	}
	
	public void showVerbindung(WM2018 mainapp, TextArea ausgabeVerb) {

		try
        {
            FXMLLoader loader=new FXMLLoader();
            loader.setLocation(WM2018.class.getResource("view/Verbindung.fxml"));	         
			mainapp.setDialogLayout((BorderPane)loader.load());
			
            ControllerVerbindung ConVerb = loader.getController();
            ConVerb.setMainapp(mainapp);
            ConVerb.setTextArea(ausgabeVerb);
            
            Scene scene=new Scene(mainapp.getDialogLayout());
            mainapp.getDialogStage().setScene(scene);
            mainapp.getDialogStage().show();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
		
	}
	
	public void showEingabe(WM2018 mainapp) {
		try
        {
            FXMLLoader loader=new FXMLLoader();
            loader.setLocation(WM2018.class.getResource("view/Eingabe.fxml"));	         
			mainapp.setEingabeLayout((BorderPane)loader.load());
			
            ControllerEingabe ConEing = loader.getController();
            ConEing.setMainapp(mainapp);
           // ConEing.setTextArea(ausgabe);
            
            Scene scene=new Scene(mainapp.getDialogLayout());
            mainapp.getDialogStage().setScene(scene);
            mainapp.getDialogStage().show();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
	}
	
	
	
}
