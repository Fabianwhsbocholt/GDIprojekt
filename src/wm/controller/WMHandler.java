package wm.controller;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javafx.event.*;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import wm.gui.WM2018;
import wm.objekte.DBConnector;
import wm.objekte.WM2018Benutzer;



// In dieser Klasse k�nnen die Funktionen ausprogrammiert werden, die beim Ausl�sen von Events
// (z.B. Dr�cken eines Buttons) ausgef�hrt werden sollen



public class WMHandler implements EventHandler
{

	DBConnector connect = new DBConnector();
	Connection connection;

	public WMHandler() {
		
	}	
	
	@Override
	public void handle(Event event) {
		// TODO Auto-generated method stub

	}
	
	
	public void wahl(WM2018 mainapp, ChoiceBox<String> StatusBox, TextArea ausgabe) {
		
		String auswahl = StatusBox.getValue();
		switch(auswahl) {
		
		case "Verbindung zur Datenbank aufbauen" : 
			mainapp.getFxml().showVerbindung(mainapp, ausgabe);
			break;
		case "Tabellen löschen und neu anlegen" :
			tabellenAnlegen(mainapp, ausgabe);
			break;
		case "Echtdaten einlesen" :
			ausgabe.appendText(mainapp.getPrep().getDbConnect().datenEinlesen(false));	
			break;
		case "Testdaten einlesen" : 
			ausgabe.appendText(mainapp.getPrep().getDbConnect().datenEinlesen(true));	
			break;
		case "Spielplan ausgeben" :
			spielplanAusgabe(mainapp, ausgabe);
			break;
		case "Spielergebnisse eingeben" : 
			mainapp.getFxml().showEingabe(mainapp, ausgabe);
			break;
		case "Ergebnisse ausgeben" :
			ergebnisseAusgeben(mainapp, ausgabe);
			break;
		case "Tipps auswerten - Ranking speichern" : 
			neuesRankingErstellen(mainapp, ausgabe);
			break;
		case "Aktuelles Ranking ansehen" : 
			rankingAusgeben(mainapp, ausgabe);
			break;
		case "Tabellen berechnen und anzeigen" :

			break;
		case "Verbindung trennen" :
			ausgabe.appendText(mainapp.getPrep().getDbConnect().close());
			break;
		case "Programm beenden" :
			beenden(mainapp);
			break;
		
			
		}	
		
		
	}
		
	
	
	public void verbindungManuelle(WM2018 mainapp, TextArea ausgabeVerb, TextField ip, TextField datenbank, TextField port, TextField benutzer, TextField passwort) throws IOException {
		//manuelle Verbindung

		//Prüfen ob alle Felder gefüllt wurden
		if(ip.getText().equals("") | datenbank.getText().equals("") | port.getText().equals("") | benutzer.getText().equals("") | passwort.getText().equals("")) {
			ausgabeVerb.appendText("Bitte alle Felder ausfüllen. \n");
		}
		else {
			
			ausgabeVerb.appendText("Verbinde mich mit der Datenbank...\n");
			try {
				connection=DriverManager.getConnection(
					    "jdbc:mariadb://"+ip.getText()+":"+port.getText()+"/"+datenbank.getText()+"?useSSL=false",
					    benutzer.getText(), passwort.getText());

				if(connection.isValid(3)){
					ausgabeVerb.appendText("Verbindung zur Datenbank "+datenbank.getText()+" hergestellt!\n");
				}
				else {
					ausgabeVerb.appendText("Verbindung zur Datenbank "+datenbank.getText()+" konnte mit \nBenutzername: "
						    +benutzer.getText()+" und\nPasswort: "+passwort.getText()+"\nnicht hergestellt werden!\n");		
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
				 
		}
		
	}
	
	public void verbindungLive(WM2018 mainapp, TextArea ausgabeVerb) throws IOException{
		ausgabeVerb.appendText("Konfigurationsdaten aus Datei lesen...\n");
		mainapp.getPrep().erstelleKonfiguration();
		ausgabeVerb.appendText("Konfiguration erstellt...\n");
		ausgabeVerb.appendText("Verbinde mich mit der Datenbank...\n");
		ausgabeVerb.appendText(mainapp.getPrep().getDbConnect().connect(mainapp.getPrep().getConfig()));
	}
	
	public void tabellenAnlegen (WM2018 mainapp, TextArea ausgabe) {

		ausgabe.appendText(mainapp.getPrep().getDbConnect().tabellenAnlegen());	
	}
	
	//Spielplan ausgeben (Fabian)
	public static void spielplanAusgabe(WM2018 mainapp, TextArea ausgabe)
	{
	
		
		List<String[]> spielplan = mainapp.getPrep().getDbConnect().spielplanAusgeben();
		
	//	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		  
		
		ausgabe.appendText("| Spielbezeichnung \t | DatumUhrzeit \t \t \t \t | Heimmannschaft \t | Gastmannschaft \t \t | Spielort| \n");
		
		//Jedes Spiel aus der Liste spielplan durchlaufen
		for(String[] spiel : spielplan) {
			ausgabe.appendText("| "+spiel[0]+" \t \t \t | "+spiel[1]+" \t \t | "+spiel[2]+" \t \t \t | "+spiel[3]+" \t \t| "+spiel[4]+" | \n");
		}
	}

	
	public static void ergebnisseAusgeben(WM2018 mainapp, TextArea ausgabe) 
	{
		List<String[]> ergebnisse = mainapp.getPrep().getDbConnect().ergebnisseAusgeben();
		
		ausgabe.appendText(" Spielmodus \t  Heimmanschaft - Gastmanschaft \t Halbzeit \t Regul. Spielz. \t Verl�ngerung \t Elfmeter \t Gelbe Karten \t Rote Katen \n");
		//System.out.println(" Spielmodus \t  Heimmanschaft - Gastmanschaft \t Halbzeit \t Regul. Spielz. \t Verl�ngerung \t Elfmeter \t Gelbe Karten \t Rote Katen");;
		
		
		for(String[] ergebnis : ergebnisse) {
			ausgabe.appendText(ergebnis[0]+" \t "+ergebnis[4]+" - "+ergebnis[5]+" \t "+ergebnis[6] +":" +ergebnis[7]+" \t "+ergebnis[8]+":"+ergebnis[9]+"\t"+ergebnis[11]+":"+ergebnis[12]+ "\t"+
					ergebnis[14]+":"+ergebnis[15]+"\t"+ergebnis[16]+" - "+ergebnis[17]+"\t"+ergebnis[20]+" - "+ergebnis[21] +"\n");
		//System.out.println(ergebnis[0]+" \t "+ergebnis[4]+" - "+ergebnis[5]+" \t "+ergebnis[6] +":" +ergebnis[7]+" \t "+ergebnis[8]+":"+ergebnis[9]+"\t"+ergebnis[11]+":"+ergebnis[12]+ "\t"+
		//		ergebnis[14]+":"+ergebnis[15]+"\t"+ergebnis[16]+" - "+ergebnis[17]+"\t"+ergebnis[20]+" - "+ergebnis[21]);;
		
		}
	}
	
	public static void rankingAusgeben(WM2018 mainapp, TextArea ausgabe)
	{
		List<String[]> ranking = mainapp.getPrep().getDbConnect().rankingAusgeben();
		
		ausgabe.appendText(" Platz \t Tipper \t Punkte \t Gruppe \n");
		//System.out.println(" Platz \t Tipper \t Punkte \t Gruppe");
		
		for (String[] rank : ranking)
		{
			ausgabe.appendText(rank[1]+" \t "+rank[2]+ " \t "+rank[3]+" \t" +rank[4] + "\n");
			//System.out.println(rank[1]+" \t "+rank[2]+ " \t "+rank[3]+" \t" +rank[4]);
		}
	}
	
	
	
	public void beenden(WM2018 mainapp) {
			System.exit(0);	
	}
	
	
	public void spielergebnisseEingabe(WM2018 mainapp) {
		
		
	}

	    /**
	     * Holt aus der Datenbank die Spielergebnisse, die Benutzer und die Tipps und ermittelt damit die erspielten
	     * Punkte und traegt diese dann in der Rangliste (ranking Tabelle) der Datenbank ein.
	     *
	     * Bei Erfolg wird TRUE zurueckgegeben bei einem Fehler wird FALSE zurueckgegeben
	     *
	     * @param dbConnector
	     * @return boolean Erfolg oder Miserfolg
	     */
	    public static boolean neuesRankingErstellen(WM2018 mainapp, TextArea ausgabe){

	        try {
	            List<String[]> benutzerliste = mainapp.getPrep().getDbConnect().benutzerSammeln();
	            List<String[]> spiele = mainapp.getPrep().getDbConnect().spieleFuerRankingSammeln();
	            List<String[]> tipps = mainapp.getPrep().getDbConnect().tippsFuerRankingSammeln();

	            List<WM2018Benutzer> rankingList = new ArrayList<WM2018Benutzer>();

	            //geht alle Benutzer in der Benutzerliste durch
	            for (String[] benutzer : benutzerliste) {

	                //Punkte fuer den aktuellen Benutzer
	                int punkteDesBenutzers = 0;

	                //geht alle Tipps durch
	                for (String[] tipp : tipps) {

	                    //gehoert der aktuelle tipp zu dem aktuellen Benutzer
	                    if (Integer.parseInt(benutzer[0]) == Integer.parseInt(tipp[0])) {

	                        String[] aktuellesSpielergebnis = getSpielergebnisById(Integer.parseInt(tipp[0]), spiele);
	                        if (aktuellesSpielergebnis != null) {
	                            //addiert die Punkte fuer diesen tipp zu dem Benutzer dazu
	                            punkteDesBenutzers = punkteDesBenutzers + berechnePunkteFuerTipp(tipp, aktuellesSpielergebnis);
	                        }
	                    }
	                }
	                WM2018Benutzer wm2018Benutzer = new WM2018Benutzer(benutzer[0], benutzer[1], benutzer[2]);
	                wm2018Benutzer.setPunkte(punkteDesBenutzers);
	                rankingList.add(wm2018Benutzer);
	            }

	            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	            Date date = new Date();
	            Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	            String s = formatter.format(date);

	            mainapp.getPrep().getDbConnect().rankingEintragen(s, rankingList);

	            return true;
	        }catch (Exception e){
	            e.printStackTrace();
	            return false;

	        }


	    }

	    /**
	     * Berechnet die Punkte die ein Tipp dem Benutzer eingebracht hat
	     * @param tipp
	     * @param spielergebnis
	     * @return Integer
	     */
	    private static int berechnePunkteFuerTipp(String[] tipp, String[] spielergebnis){

	        int erreichtePunkte = 0;

	        // Halbzeitergebis!
	            // 6 Punkte fuer Halbzeitergbnis korrekt
	        if(tipp[4]!=null && tipp[5] != null && spielergebnis[6] !=null && spielergebnis[7] !=null) {
	            if (Integer.parseInt(tipp[5]) == Integer.parseInt(spielergebnis[7]) &&
	                    Integer.parseInt(tipp[4]) == Integer.parseInt(spielergebnis[6])) {
	                erreichtePunkte = erreichtePunkte + 6;
	            }
	            // 3 Punkte fuer Halbzeitergebnis korrekte Tendenz  (Differenz oder Tendenz ???? )
	            else if (Integer.parseInt(tipp[5]) - Integer.parseInt(tipp[4]) ==
	                    Integer.parseInt(spielergebnis[7]) - Integer.parseInt(spielergebnis[6])) {
	                erreichtePunkte = erreichtePunkte + 3;
	            }
	        }
	        //Endergebis!
	            // 11 Punkte fuer Endergbnis korrekt
	        if(tipp[6]!=null && tipp[7] != null && spielergebnis[8] !=null && spielergebnis[9] !=null) {
	            if (Integer.parseInt(tipp[7]) == Integer.parseInt(spielergebnis[9]) &&
	                    Integer.parseInt(tipp[6]) == Integer.parseInt(spielergebnis[8])) {
	                erreichtePunkte = erreichtePunkte + 11;
	            }
	            // 3 Punkte fuer Endergebnis korrekte Tendenz  (Differenz oder Tendenz ???? )
	            else if (Integer.parseInt(tipp[7]) - Integer.parseInt(tipp[6]) ==
	                    Integer.parseInt(spielergebnis[9]) - Integer.parseInt(spielergebnis[8])) {
	                erreichtePunkte = erreichtePunkte + 5;
	            }
	        }
	        //Verlaengerung!
	        if(tipp[8]!=null && tipp[9] != null && spielergebnis[11] !=null && spielergebnis[12] !=null) {
	            if (Integer.parseInt(spielergebnis[10]) == 1) {

	                // 11 Punkte fuer Verlaengerung korrekt
	                if (Integer.parseInt(tipp[9]) == Integer.parseInt(spielergebnis[12]) &&
	                        Integer.parseInt(tipp[8]) == Integer.parseInt(spielergebnis[11])) {
	                    erreichtePunkte = erreichtePunkte + 11;
	                }
	                // 3 Punkte fuer Verlaengerung korrekte Tendenz  (Differenz oder Tendenz ???? )
	                else if (Integer.parseInt(tipp[9]) - Integer.parseInt(tipp[8]) ==
	                        Integer.parseInt(spielergebnis[12]) - Integer.parseInt(spielergebnis[11])) {
	                    erreichtePunkte = erreichtePunkte + 5;
	                }

	            }
	        }
	        //Elfmeterschiessen!
	        if(tipp[10]!=null && tipp[11] != null && spielergebnis[14] !=null && spielergebnis[15] !=null) {
	            if (Integer.parseInt(spielergebnis[13]) == 1) {
	                // 11 Punkte fuer Elfmeterschiessen korrekt
	                if (Integer.parseInt(tipp[11]) == Integer.parseInt(spielergebnis[15]) &&
	                        tipp[10] == spielergebnis[14]) {
	                    erreichtePunkte = erreichtePunkte + 11;
	                }
	                // 3 Punkte fuer Elfmeterschiessen korrekte Tendenz  (Differenz oder Tendenz ???? )
	                else if (Integer.parseInt(tipp[11]) - Integer.parseInt(tipp[10]) ==
	                        Integer.parseInt(spielergebnis[15]) - Integer.parseInt(spielergebnis[14])) {
	                    erreichtePunkte = erreichtePunkte + 5;
	                }
	            }
	        }
	        //Gelbe Karten
	        if(tipp[12]!=null && tipp[13] != null && spielergebnis[16] !=null && spielergebnis[17] !=null) {
	            if (Integer.parseInt(tipp[13]) == Integer.parseInt(spielergebnis[17])) {
	                erreichtePunkte = erreichtePunkte + 3;
	            }
	            if (Integer.parseInt(tipp[12]) == Integer.parseInt(spielergebnis[16])) {
	                erreichtePunkte = erreichtePunkte + 3;
	            }
	        }
	        //Gelb-Rote Karten
	        if(tipp[14]!=null && tipp[15] != null && spielergebnis[18] !=null && spielergebnis[19] !=null) {
	            if (Integer.parseInt(tipp[15]) == Integer.parseInt(spielergebnis[19])) {
	                erreichtePunkte = erreichtePunkte + 4;
	            }
	            if (Integer.parseInt(tipp[14]) == Integer.parseInt(spielergebnis[18])) {
	                erreichtePunkte = erreichtePunkte + 4;
	            }
	        }
	        //Rote Karten
	        if(tipp[16]!=null && tipp[17] != null && spielergebnis[20] !=null && spielergebnis[21] !=null) {
	            if (Integer.parseInt(tipp[17]) == Integer.parseInt(spielergebnis[21])) {
	                erreichtePunkte = erreichtePunkte + 5;
	            }
	            if (Integer.parseInt(tipp[16]) == Integer.parseInt(spielergebnis[20])) {
	                erreichtePunkte = erreichtePunkte + 5;
	            }
	        }

	        return erreichtePunkte;
	    }

	    /**
	     * Ermittelt das Spielergebnis zu einer Id in der Liste von Spielergebnissen
	     * @param spielid
	     * @param spielergebnisse
	     * @return String[]
	     */
	    private static String[] getSpielergebnisById(int spielid, List<String[]> spielergebnisse){
	        for (String[] spielergebnis : spielergebnisse){
	            if(Integer.parseInt(spielergebnis[0]) == spielid){
	                return spielergebnis;
	            }
	        }
	        return null;
	    }

	}
