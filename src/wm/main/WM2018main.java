package wm.main;

import java.util.ArrayList;
import java.util.List;

import wm.controller.Hilfsfunktionen;
import wm.controller.RankingCalculator;
import wm.controller.WMHandler;
import wm.objekte.Configuration;
import wm.objekte.DBConnector;
import wm.objekte.*;

// Diese Klasse dient nur Testzwecken, die hier dargestellte Funktionalität soll
// über eine graphische Benutzungsoberfläche realisiert werden
// Gestartet wird das Programm dann über die Klasse "WM2018mainGUI.java"

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
			// Die Konfigurationsdaten konnten gelesen werden, wir können das
			// Configurations-Objekt erstellen
			Configuration config=new Configuration(configDaten);
			
			System.out.println("Konfiguration erstellt...");
			
			System.out.println("Verbinde mich mit der Datenbank...");
			
			// Verbinden mit Datenbank
			//DBConnector datenbank=new DBConnector();
			System.out.println(datenbank.connect(config));
			
			// Anlegen der benötigten Tabellen
			System.out.println(datenbank.tabellenAnlegen());
			
			// Einlesen der Echt- oder Testdaten
			boolean testdaten=false;
			System.out.println(datenbank.datenEinlesen(testdaten));
			
			wm.controller.WMHandler.spielplanAusgabe(datenbank);
			
			ArrayList<Benutzer> benutzerliste = new ArrayList<Benutzer>(); 
			for(int i = 0 ; i<5;i++) {
				Benutzer benutzer = new Benutzer();
				benutzer.setBenutzerid(i);
				benutzer.setBenutzername("Benutzer"+i+1);
				benutzer.setGruppe("Gruppe"+i+1);
			}
			
			ArrayList<Spielergebnis> ergebnisse = new ArrayList<Spielergebnis>(); 
			for(int i = 0 ; i<5;i++) {
				Spielergebnis ergebnis = new Spielergebnis();
				ergebnis.setElfmeterschiessenGastmannschaft(5);
			
			}
		
			//Liste von Objekten
			ArrayList<Tipp> tipps = new ArrayList<Tipp>(); 
			for(int i = 0 ; i<5;i++) {
				Tipp tipp = new Tipp();
				
				
			}
			
			//Liste von Objekten aus DB
			ArrayList<Tipp> tippsAusDBAlsObjekte = new ArrayList<Tipp>(); 
			
			List<String[]> tippsAusDBAlsStringArray = datenbank.tippsFuerRankingSammeln();
			
			
			//Gehe Liste von String[] durch bis Ende (.size() )
			for(int i = 0; i < tippsAusDBAlsStringArray.size()  ; i++) {
				
				//neues Objekt
				Tipp tipp = new Tipp();
				
				//Objekt fuellen
				tipp.setBenutzerid(Integer.parseInt(tippsAusDBAlsStringArray.get(i)[1]));
				tipp.setElfmeterschiessenGastmannschaft(Integer.parseInt(tippsAusDBAlsStringArray.get(i)[11]));
				//...
				//...
				//...
				
				//Objekt in Liste einfuegen (tippsAusDBAlsObjekte)
				tippsAusDBAlsObjekte.add(tipp);
			}
			
			List<Rank> rankinglist = RankingCalculator.getNeuesRanking(ergebnisse, tippsAusDBAlsObjekte, benutzerliste);
			
			System.out.println(rankinglist.get(0).getPlatz());
			System.out.println(rankinglist.get(0).getBenutzerid());
			System.out.println(rankinglist.get(1).getBenutzerid());
			System.out.println(rankinglist.get(1).getPlatz());
			
			// Verbindung zur Datenbank trennen
			System.out.println(datenbank.close());
			
			
		}
	}
}
