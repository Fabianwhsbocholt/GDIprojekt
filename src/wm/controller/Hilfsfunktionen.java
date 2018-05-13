package wm.controller;

// An den Funktionen dieser Klasse sollten keine Änderungen vorgenommen werden
// Es ist möglich - sofern erforderlich - weitere Funktionen zu ergänzen

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Hilfsfunktionen
{
	public static String leerzeichen (int anzahl, String text)
	{
		String ergebnis="";
		for (int space=0; space<(anzahl-text.length()); space++)
			ergebnis+=" ";
		return ergebnis;
	}
	
	public static String datumWandeln (Date datum) throws ParseException
	{
		return new SimpleDateFormat("dd.MM.yyyy HH:mm").format(datum);
	}	
	
	public static String[] leseConfig (String datei)
	{
		File file=new File(datei);
		String[] configDaten=new String[5];
		int index=0;
		
		if (!file.canRead()||!file.isFile())
		{
			configDaten[0]="Fehler - Datei nicht lesbar!";
		}
		
		BufferedReader in=null;
		try
		{
			in=new BufferedReader(new FileReader(datei));
			
			String zeile=null;
			while ((zeile=in.readLine())!=null)
			{
				configDaten[index++]=(zeile.substring(zeile.indexOf(":")+1));
			}
		}
		catch (IOException e)
		{
			configDaten[0]="Fehler beim Einlesen der Datei!";
		}
		finally
		{
			if (in!=null)
				try
				{
					in.close();
				}
				catch (IOException e)
				{
					configDaten[0]="Fehler beim Schließen des Readers!";
				}
		}
		return configDaten;
	}
	
}
