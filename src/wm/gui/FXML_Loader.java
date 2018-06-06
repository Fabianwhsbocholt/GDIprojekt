package wm.gui;

import java.io.IOException;
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
            
            TextField achtelfinalegast1=kospiele.getAchtelfinalegast1();
            TextField achtelfinalegast2=kospiele.getAchtelfinalegast2();
            TextField achtelfinalegast3=kospiele.getAchtelfinalegast3();
            TextField achtelfinalegast4=kospiele.getAchtelfinalegast4();
            TextField achtelfinalegast5=kospiele.getAchtelfinalegast5();
            TextField achtelfinalegast6=kospiele.getAchtelfinalegast6();
            TextField achtelfinalegast7=kospiele.getAchtelfinalegast7();
            TextField achtelfinalegast8=kospiele.getAchtelfinalegast8();
            TextField achtelfinaleheim1 = kospiele.getAchtelfinaleheim1();
            TextField achtelfinaleheim2 = kospiele.getAchtelfinaleheim2();
            TextField achtelfinaleheim3 = kospiele.getAchtelfinaleheim3();
            TextField achtelfinaleheim4 = kospiele.getAchtelfinaleheim4();
            TextField achtelfinaleheim5 = kospiele.getAchtelfinaleheim5();
            TextField achtelfinaleheim6 = kospiele.getAchtelfinaleheim6();
            TextField achtelfinaleheim7 = kospiele.getAchtelfinaleheim7();
            TextField achtelfinaleheim8 = kospiele.getAchtelfinaleheim8();
            TextField viertelfinaleheim1 = kospiele.getViertelfinaleheim1();
            TextField viertelfinaleheim2 = kospiele.getViertelfinaleheim2();
            TextField viertelfinaleheim3 = kospiele.getViertelfinaleheim3();
            TextField viertelfinaleheim4 = kospiele.getViertelfinaleheim4();
            TextField viertelfinalegast1 = kospiele.getViertelfinalegast1();
            TextField viertelfinalegast2 = kospiele.getViertelfinalegast2();
            TextField viertelfinalegast3 = kospiele.getViertelfinalegast3();
            TextField viertelfinalegast4 = kospiele.getViertelfinalegast4();
            TextField halbfinaleheim1 = kospiele.getHalbfinaleheim1();
        	TextField halbfinalegast1 =  kospiele.getHalbfinalegast1();
        	TextField halbfinaleheim2 =  kospiele.getHalbfinaleheim2();
        	TextField halbfinalegast2 =  kospiele.getHalbfinalegast2();
        	TextField platz3heim = kospiele.getPlatz3heim();
        	TextField platz3gast = kospiele.getPlatz3gast();
        	TextField finaleheim = kospiele.getFinaleheim();
        	TextField finalegast = kospiele.getFinalegast();
        	
        	kospiele.festeWerte(mainapp, ausgabe, achtelfinaleheim1, achtelfinaleheim2, achtelfinaleheim3, achtelfinaleheim4, 
			achtelfinaleheim5, achtelfinaleheim6, achtelfinaleheim7, achtelfinaleheim8, achtelfinalegast1, 
			achtelfinalegast2, achtelfinalegast3, achtelfinalegast4, achtelfinalegast5, achtelfinalegast6, 
			achtelfinalegast7, achtelfinalegast8, viertelfinaleheim1, viertelfinaleheim2, viertelfinaleheim3, 
			viertelfinaleheim4, viertelfinalegast1, viertelfinalegast2, viertelfinalegast3, viertelfinalegast4, 
			halbfinaleheim1, halbfinaleheim2, halbfinalegast1, halbfinalegast2, platz3heim, platz3gast, finaleheim, 
			finalegast);
        	
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
