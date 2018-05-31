package wm.main;

import java.util.ArrayList;
import java.util.List;

import wm.controller.Hilfsfunktionen;
import wm.controller.RankingCalculator;
import wm.controller.WMHandler;
import wm.objekte.Configuration;
import wm.objekte.DBConnector;
import wm.objekte.*;

// Diese Klasse dient nur Testzwecken, die hier dargestellte Funktionalitï¿½t soll
// ï¿½ber eine graphische Benutzungsoberflï¿½che realisiert werden
// Gestartet wird das Programm dann ï¿½ber die Klasse "WM2018mainGUI.java"

public class WM2018main
{
	public static void main (String[] args)
	{
		System.out.println("Konfigurationsdaten aus Datei lesen...\n");
		
		String[] configDaten=Hilfsfunktionen.leseConfig("config.txt");
		
		System.out.println("Server-IP\t|Datenbank\t|Port\t|Benutzer\t\t|Passwort\t|");
		
		for (String wert: configDaten)
			System.out.print(wert+"\t|");
		System.out.println("\n");
		
		DBConnector datenbank = new DBConnector();
		
		if (!configDaten[0].startsWith("Fehler"))
		{
			// Die Konfigurationsdaten konnten gelesen werden, wir kï¿½nnen das
			// Configurations-Objekt erstellen
			Configuration config=new Configuration(configDaten);
			
			System.out.println("Konfiguration erstellt...");
			
			System.out.println("Verbinde mich mit der Datenbank...");
			
			// Verbinden mit Datenbank
			//DBConnector datenbank=new DBConnector();
			System.out.println(datenbank.connect(config));
			
			// Anlegen der benï¿½tigten Tabellen
			System.out.println(datenbank.tabellenAnlegen());
			
			// Einlesen der Echt- oder Testdaten
			boolean testdaten=false;
			System.out.println(datenbank.datenEinlesen(testdaten));
			
			//wm.controller.WMHandler.spielplanAusgabe(datenbank);



			//Ausführen des RankingCalculator 
		if(RankingCalculator.neuesRankingErstellen(datenbank)){
				System.out.println("Ranking erfolgreich erstellt!");
			}else {
				System.out.println("Ranking erstellen ist fehlgeschlagen!");
			}

			
			// Verbindung zur Datenbank trennen
			System.out.println(datenbank.close());
			
			
		}
	}
}
