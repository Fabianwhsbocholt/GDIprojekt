package wm.controller;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import wm.objekte.*;
import java.util.Date;

public class RankingCalculator {

    /**
     * Holt aus der Datenbank die Spielergebnisse, die Benutzer und die Tipps und ermittelt damit die erspielten
     * Punkte und traegt diese dann in der Rangliste (ranking Tabelle) der Datenbank ein.
     *
     * Bei Erfolg wird TRUE zurueckgegeben bei einem Fehler wird FALSE zurueckgegeben
     *
     * @param dbConnector
     * @return boolean Erfolg oder Miserfolg
     */
    public static boolean neuesRankingErstellen(DBConnector dbConnector){

        try {
            List<String[]> benutzerliste = dbConnector.benutzerSammeln();
            List<String[]> spiele = dbConnector.spieleFuerRankingSammeln();
            List<String[]> tipps = dbConnector.tippsFuerRankingSammeln();

            List<WM2018Benutzer> rankingList = new ArrayList<WM2018Benutzer>();

            //geht alle Benutzer in der Benutzerliste durch
            for (String[] benutzer : benutzerliste) {

                //Punkte fuer den aktuellen Benutzer
                int punkteDesBenutzers = 0;

                //geht alle Tipps durch
                for (String[] tipp : tipps) {

                    //gehoert der aktuelle tipp zu dem aktuellen Benutzer
                    if (benutzer[0] == tipp[0]) {

                        String[] aktuellesSpielergebnis = getSpielergebnisById(Integer.parseInt(tipp[0]), spiele);
                        if (aktuellesSpielergebnis != null) {
                            //addiert die Punkte fuer diesen tipp zu dem Benutzer dazu
                            punkteDesBenutzers = punkteDesBenutzers + berechnePunkteFuerTipp(tipp, aktuellesSpielergebnis);
                        }
                    }
                }
                rankingList.add(new WM2018Benutzer(benutzer[0], benutzer[1], benutzer[2]));
            }

            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String s = formatter.format(date);

            dbConnector.rankingEintragen(s, rankingList);

            return true;
        }catch (Exception e){

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
            if(Integer.parseInt(tipp[5]) == Integer.parseInt(spielergebnis[7]) &&
                    Integer.parseInt(tipp[4]) == Integer.parseInt(spielergebnis[6])){
                erreichtePunkte = erreichtePunkte+6;
            }
            // 3 Punkte fuer Halbzeitergebnis korrekte Tendenz  (Differenz oder Tendenz ???? )
            else if (Integer.parseInt(tipp[5])-Integer.parseInt(tipp[4]) ==
                    Integer.parseInt(spielergebnis[7])-Integer.parseInt(spielergebnis[6])){
                erreichtePunkte = erreichtePunkte + 3;
            }

        //Endergebis!
            // 11 Punkte fuer Endergbnis korrekt
            if(Integer.parseInt(tipp[7]) == Integer.parseInt(spielergebnis[9]) &&
                    Integer.parseInt(tipp[6]) == Integer.parseInt(spielergebnis[8])){
                erreichtePunkte = erreichtePunkte+11;
            }
            // 3 Punkte fuer Endergebnis korrekte Tendenz  (Differenz oder Tendenz ???? )
            else if (Integer.parseInt(tipp[7])-Integer.parseInt(tipp[6]) ==
                    Integer.parseInt(spielergebnis[9])-Integer.parseInt(spielergebnis[8])){
                erreichtePunkte = erreichtePunkte + 5;
            }

        //Verlaengerung!
            if(Integer.parseInt(spielergebnis[10])==1) {

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
        //Elfmeterschiessen!
        if (Integer.parseInt(spielergebnis[13])==1){
            // 11 Punkte fuer Elfmeterschiessen korrekt
            if(Integer.parseInt(tipp[11]) == Integer.parseInt(spielergebnis[15]) &&
                    tipp[10] == spielergebnis[14]){
                erreichtePunkte = erreichtePunkte+11;
            }
            // 3 Punkte fuer Elfmeterschiessen korrekte Tendenz  (Differenz oder Tendenz ???? )
            else if (Integer.parseInt(tipp[11])-Integer.parseInt(tipp[10]) ==
                    Integer.parseInt(spielergebnis[15])-Integer.parseInt(spielergebnis[14])){
                erreichtePunkte = erreichtePunkte + 5;
            }
        }

        //Gelbe Karten
        if (Integer.parseInt(tipp[13]) == Integer.parseInt(spielergebnis[17])){
            erreichtePunkte = erreichtePunkte + 3;
        }
        if (Integer.parseInt(tipp[12]) == Integer.parseInt(spielergebnis[16])){
            erreichtePunkte = erreichtePunkte + 3;
        }

        //Gelb-Rote Karten
        if (Integer.parseInt(tipp[15]) == Integer.parseInt(spielergebnis[19])){
            erreichtePunkte = erreichtePunkte + 4;
        }
        if (Integer.parseInt(tipp[14]) == Integer.parseInt(spielergebnis[18])){
            erreichtePunkte = erreichtePunkte + 4;
        }

        //Rote Karten
        if (Integer.parseInt(tipp[17]) == Integer.parseInt(spielergebnis[21])){
            erreichtePunkte = erreichtePunkte + 5;
        }
        if (Integer.parseInt(tipp[16]) == Integer.parseInt(spielergebnis[20])){
            erreichtePunkte = erreichtePunkte + 5;
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
