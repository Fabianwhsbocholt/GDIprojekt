package wm.controller;

import java.util.ArrayList;
import java.util.List;

import wm.objekte.Benutzer;
import wm.objekte.DBConnector;
import wm.objekte.Rank;
import wm.objekte.Spielergebnis;
import wm.objekte.Tipp;

public class Objektefuellen 
{
	public static void fuellen() {
		
/*	ArrayList<Benutzer> benutzerliste = new ArrayList<Benutzer>();
	
	for(int i = 0 ; i<5;i++) 
	{
		Benutzer benutzer = new Benutzer();
		benutzer.setBenutzerid(i);
		benutzer.setBenutzername("Benutzer"+i+1);
		benutzer.setGruppe("Gruppe"+i+1);
	}*/	
	
	
	
/*	ArrayList<Spielergebnis> ergebnisse = new ArrayList<Spielergebnis>(); 
	
	for(int i = 0 ; i<5;i++) 
	{
		Spielergebnis ergebnis = new Spielergebnis();
		ergebnis.setElfmeterschiessenGastmannschaft(5);
	
	}
*/	

	//Liste von Objekten
	// ArrayList<Tipp> tipps = new ArrayList<Tipp>();

	
	//Liste von Objekten aus DB
	ArrayList<Tipp> tippsAusDBAlsObjekte = new ArrayList<Tipp>(); 
	
	DBConnector datenbank = new DBConnector();

	List<String[]> tippsAusDBAlsStringArray = datenbank.tippsFuerRankingSammeln();
	
	
	//Gehe Liste von String[] durch bis Ende (.size() )
	for(int i = 0; i < tippsAusDBAlsStringArray.size()  ; i++) 
	{
		
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
}
}
