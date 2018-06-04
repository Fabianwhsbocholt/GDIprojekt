package wm.gui;

import java.io.IOException;
import java.util.List;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import wm.gui.view.ControllerEingabe;
import wm.gui.view.ControllerKOSpiele;
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
			mainapp.getDialogStage().setTitle("Verbindung");
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
	
	public void showEingabe(WM2018 mainapp, TextArea ausgabe) {
		try
        {
            FXMLLoader loader=new FXMLLoader();
            loader.setLocation(WM2018.class.getResource("view/Eingabe.fxml"));	         
			mainapp.setEingabeLayout((BorderPane)loader.load());
			mainapp.getEingabeStage().setTitle("Eingabe Spielergebnisse");
            ControllerEingabe ConEing = loader.getController();
            ConEing.setMainapp(mainapp);
            ConEing.setTextArea(ausgabe);
            
            TextField datetime = ConEing.getDatetime();
            TextField gruppe = ConEing.getGruppe();
            TextField heim = ConEing.getHeimmannschaft();
            TextField gast = ConEing.getGastmannschaft();
            ConEing.festeWerte(mainapp, ausgabe, gruppe, datetime, heim, gast);
            
          /*  TextField heimverlängerung = ConEing.getHeimverlängerung();
            TextField gastverlängerung = ConEing.getGastverlängerung();
            TextField heimelfmeter = ConEing.getHeimelfmeter();
            TextField gastelfmeter = ConEing.getGastelfmeter();
            
            ConEing.kospieleprüfen(mainapp, ausgabe, heimverlängerung, gastverlängerung, heimelfmeter, gastelfmeter);*/
            
            Scene scene=new Scene(mainapp.getEingabeLayout());
            mainapp.getEingabeStage().setScene(scene);
            mainapp.getEingabeStage().show();
         
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
	}
	
	public void showKOSpiele(WM2018 mainapp, TextArea ausgabe) {
		try
        {
            FXMLLoader loader=new FXMLLoader();
            loader.setLocation(WM2018.class.getResource("view/KOSpiele.fxml"));	         
			mainapp.setKospieleLayout((BorderPane)loader.load());
			mainapp.getKospieleStage().setTitle("KO-Spiele");
			
            ControllerKOSpiele kospiele = loader.getController();
            kospiele.setMainapp(mainapp);
            kospiele.setTextArea(ausgabe);
            
            Scene scene=new Scene(mainapp.getKospieleLayout());
            mainapp.getKospieleStage().setScene(scene);
            mainapp.getKospieleStage().show();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
	}
	
	
	
}
