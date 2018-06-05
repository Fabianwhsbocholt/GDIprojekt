package wm.controller;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
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
	Hilfsfunktionen hf = new Hilfsfunktionen();

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
		case "KO-Spiele eintragen" :
			mainapp.getFxml().showKOSpiele(mainapp, ausgabe);
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

		String ip1 = Hilfsfunktionen.nullTest(ip.getText());
		String db = Hilfsfunktionen.nullTest(datenbank.getText());
		String po = Hilfsfunktionen.nullTest(port.getText());
		String bn = Hilfsfunktionen.nullTest(benutzer.getText());
		String pw = Hilfsfunktionen.nullTest(passwort.getText());
		
		if(ip1 != "null" && db != "null" && po != "null" && bn != "null" && pw != "null") {
			
			ausgabeVerb.appendText("Verbinde mich mit der Datenbank...\n");
			try {
				connection=DriverManager.getConnection(
					    "jdbc:mariadb://"+ip.getText()+":"+port.getText()+"/"+datenbank.getText()+"?useSSL=false",
					    benutzer.getText(), passwort.getText());
		
				
			ausgabeVerb.appendText("Verbindung zur Datenbank "+datenbank.getText()+" hergestellt!\n");
			mainapp.getDialogStage().close();
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				ausgabeVerb.appendText("Verbindung zur Datenbank "+datenbank.getText()+" konnte mit \nBenutzername: "
			    +benutzer.getText()+" und\nPasswort: "+passwort.getText()+"\nnicht hergestellt werden!\n");
			}	
			 
		}
		else {
			ausgabeVerb.appendText("Bitte alle Felder ausfüllen. \n");
		}				
	}
	
	public void verbindungLive(WM2018 mainapp, TextArea ausgabeVerb) throws IOException{
		ausgabeVerb.appendText("Konfigurationsdaten aus Datei lesen...\n");
		mainapp.getPrep().erstelleKonfiguration();
		ausgabeVerb.appendText("Konfiguration erstellt...\n");
		ausgabeVerb.appendText("Verbinde mich mit der Datenbank...\n");
		ausgabeVerb.appendText(mainapp.getPrep().getDbConnect().connect(mainapp.getPrep().getConfig()));
		mainapp.getDialogStage().close();
	}
	
	public void tabellenAnlegen (WM2018 mainapp, TextArea ausgabe) {

		ausgabe.appendText(mainapp.getPrep().getDbConnect().tabellenAnlegen());	
	}
	
	//Spielplan ausgeben (Fabian)
	public static void spielplanAusgabe(WM2018 mainapp, TextArea ausgabe)
	{

		List<String[]> spielplan = mainapp.getPrep().getDbConnect().spielplanAusgeben();
		
		//Funktion für datum umwandeln aus der Klasse Hilfsfunktionen
		
		ausgabe.appendText("|Spielbezeichnung"+Hilfsfunktionen.leerzeichen(17, "Spielbezeichnung")+"|DatumUhrzeit"+Hilfsfunktionen.leerzeichen(22, "DatumUhrzeit")+"|Heimmannschaft" +Hilfsfunktionen.leerzeichen(17, "Heimmannschaft")+"|Gastmannschaft"+Hilfsfunktionen.leerzeichen(17, "Gastmannschaft")+ "|Spielort" +Hilfsfunktionen.leerzeichen(17, "Spielort")+"| \n");
		//Jedes Spiel aus der Liste spielplan durchlaufen
		for(String[] spiel : spielplan) {
			
			ausgabe.appendText("|"+spiel[0]+Hilfsfunktionen.leerzeichen(17, spiel[0])+"|"+Hilfsfunktionen.datumWandeln(spiel[1])+Hilfsfunktionen.leerzeichen(22, spiel[1])+"|"+spiel[2]+""+Hilfsfunktionen.leerzeichen(17, spiel[2])+"|"+spiel[3]+""+Hilfsfunktionen.leerzeichen(17, spiel[3])+"|"+spiel[4]+""+Hilfsfunktionen.leerzeichen(17, spiel[4])+"|\n");
		}
	}

	
	public static void ergebnisseAusgeben(WM2018 mainapp, TextArea ausgabe) 
	{
		List<String[]> ergebnisse = mainapp.getPrep().getDbConnect().ergebnisseAusgeben();
		
		ausgabe.appendText(" Spielmodus \t  Heimmanschaft - Gastmanschaft \t Halbzeit \t Regul. Spielz. \t Verl�ngerung \t Elfmeter \t Gelbe Karten \t Rote Katen \n");
		
		
		for(String[] ergebnis : ergebnisse) {
			ausgabe.appendText(ergebnis[0]+" \t "+ergebnis[4]+" - "+ergebnis[5]+" \t "+ergebnis[6] +":" +ergebnis[7]+" \t "+ergebnis[8]+":"+ergebnis[9]+"\t"+ergebnis[11]+":"+ergebnis[12]+ "\t"+
					ergebnis[14]+":"+ergebnis[15]+"\t"+ergebnis[16]+" - "+ergebnis[17]+"\t"+ergebnis[20]+" - "+ergebnis[21] +"\n");
		}
	}
	
	
	
	public static void rankingAusgeben(WM2018 mainapp, TextArea ausgabe)
	{
		List<String[]> ranking = mainapp.getPrep().getDbConnect().rankingAusgeben();
		
		ausgabe.appendText("Platz Tipper Punkte Gruppe \n");
		
		for (String[] rank : ranking)
		{
			ausgabe.appendText(rank[1]+" \t "+rank[2]+ " \t "+rank[3]+" \t" +rank[4] + "\n");
		}
	}
	
	
	
	public void beenden(WM2018 mainapp) {
			System.exit(0);	
	}
	
	
	public void koSpieleEingeben(WM2018 mainapp, TextArea ausgabe, TextField achtelfinaleheim1, TextField achtelfinaleheim2, 
			TextField achtelfinaleheim3, TextField achtelfinaleheim4, TextField achtelfinaleheim5, TextField achtelfinaleheim6, 
			TextField achtelfinaleheim7, TextField achtelfinaleheim8, TextField achtelfinalegast1,  TextField achtelfinalegast2,  
			TextField achtelfinalegast3,  TextField achtelfinalegast4,  TextField achtelfinalegast5,  TextField achtelfinalegast6,  
			TextField achtelfinalegast7,  TextField achtelfinalegast8, TextField viertelfinaleheim1, TextField viertelfinaleheim2, 
			TextField viertelfinaleheim3, TextField viertelfinaleheim4, TextField viertelfinalegast1, TextField viertelfinalegast2, 
			TextField viertelfinalegast3, TextField viertelfinalegast4, TextField halbfinaleheim1, TextField halbfinaleheim2, 
			TextField halbfinalegast1, TextField halbfinalegast2, TextField platz3heim, TextField platz3gast, TextField finaleheim, 
			TextField finalegast) {
		
			String [] kospiele = new String[32];
			
	}
	
	public void spielergebnisseEingabe(WM2018 mainapp, TextArea ausgabe, String id, TextField toreheimhz, TextField toregasthz, 		
		TextField toreheimende, TextField toregastende, TextField heimverlängerung, TextField gastverlängerung, TextField heimelf, TextField gastelf, TextField heimgelb, TextField gastgelb, 
		TextField heimrot, TextField gastrot, TextField heimgelbrot, TextField  gastgelbrot) 
	{
	
		String [] eingetrageneErgebnisse = new String [22];

		eingetrageneErgebnisse[6] = toreheimhz.getText();
		eingetrageneErgebnisse[7] = toregasthz.getText();
		eingetrageneErgebnisse[8] = toreheimende.getText();
		eingetrageneErgebnisse[9] = toregastende.getText();	
		
		eingetrageneErgebnisse[11] = heimverlängerung.getText();	
		eingetrageneErgebnisse[12] = gastverlängerung.getText();	
		eingetrageneErgebnisse[14] = heimelf.getText();	
		eingetrageneErgebnisse[15] = gastelf.getText();	
		
		eingetrageneErgebnisse[16] = heimgelb.getText();
		eingetrageneErgebnisse[17] = gastgelb.getText();	
		eingetrageneErgebnisse[20] = heimrot.getText();
		eingetrageneErgebnisse[21] = gastrot.getText();
		eingetrageneErgebnisse[18] = heimgelbrot.getText();
		eingetrageneErgebnisse[19] = gastgelbrot.getText();
		eingetrageneErgebnisse[0] =  id;
		
		ausgabe.appendText(mainapp.getPrep().getDbConnect().ergebnisseEintragen(eingetrageneErgebnisse));
		
		toreheimhz.clear();
		toregasthz.clear();
		toreheimende.clear();
		toregastende.clear();
		heimverlängerung.clear();
		gastverlängerung.clear();
		heimelf.clear();
		gastelf.clear();
		heimgelb.clear();
		gastgelb.clear();
		heimrot.clear();
		gastrot.clear();
		heimgelbrot.clear();
		gastgelbrot.clear();
		
	}

	    /**
	     * Holt aus der Datenbank die Spielergebnisse, die Benutzer und die Tipps und ermittelt damit die erspielten
	     * Punkte und traegt diese dann in der Rangliste (ranking Tabelle) der Datenbank ein.
	     *
	     * Bei Erfolg wird TRUE zurueckgegeben bei einem Fehler wird FALSE zurueckgegeben
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

                if (Integer.parseInt(benutzer[0]) == Integer.parseInt(tipp[1])) {


                    String[] aktuellesSpielergebnis = getSpielergebnisById(Integer.parseInt(tipp[2]), spiele);
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

        Date date = new Date();
        Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = formatter.format(date);

        Collections.sort(rankingList);

        mainapp.getPrep().getDbConnect().rankingEintragen(s, rankingList);
        ausgabe.appendText("Ranking wurde erfolgreich erstellt! \n");

        return true;
        
    }catch (Exception e){
    	    
	    e.printStackTrace();
	    ausgabe.appendText("Ranking erstellen ist fehlgeschlagen! \n");
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

        if(tipp[13] != null && spielergebnis[17] !=null) {
            if (Integer.parseInt(tipp[13]) == Integer.parseInt(spielergebnis[17])) {
                erreichtePunkte = erreichtePunkte + 3;
            }
        }
        if(tipp[12]!=null && spielergebnis[16] !=null) {
            if (Integer.parseInt(tipp[12]) == Integer.parseInt(spielergebnis[16])) {
                erreichtePunkte = erreichtePunkte + 3;
            }
        }
        //Gelb-Rote Karten

        if(tipp[15] != null && spielergebnis[19] !=null) {
            if (Integer.parseInt(tipp[15]) == Integer.parseInt(spielergebnis[19])) {
                erreichtePunkte = erreichtePunkte + 4;
            }
        }
        if(tipp[14]!=null && spielergebnis[18] !=null) {
            if (Integer.parseInt(tipp[14]) == Integer.parseInt(spielergebnis[18])) {
                erreichtePunkte = erreichtePunkte + 4;
            }
        }
        //Rote Karten

        if(tipp[17] != null && spielergebnis[21] !=null) {
            if (Integer.parseInt(tipp[17]) == Integer.parseInt(spielergebnis[21])) {
                erreichtePunkte = erreichtePunkte + 5;
            }
        }
        if(tipp[16]!=null && spielergebnis[20] !=null) {
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

