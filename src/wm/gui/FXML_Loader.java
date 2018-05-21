package wm.gui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

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
	
	
	
}
