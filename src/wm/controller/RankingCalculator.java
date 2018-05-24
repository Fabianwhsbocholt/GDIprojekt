package wm.controller;

import java.util.ArrayList;
import java.util.List;

import wm.objekte.*;

public class RankingCalculator {

    /**
     * Erwartet eine Liste mit Spielergebis-Objekten, eine Liste mit Tipp-Objekten und eine Liste mit Benutzer-Objekten
     * und gibt eine Liste mit Rank-Objekten zurueck (Ranking-Tabelle)
     * @param spielergebnisse
     * @param tipps
     * @param benutzerliste
     * @return List<Rank>
     */
    public static List<Rank> getNeuesRanking(List<Spielergebnis> spielergebnisse, List<Tipp> tipps,
                                             List<Benutzer> benutzerliste){

        ArrayList<Rank> rankingList = new ArrayList<Rank>();

        //geht alle Benutzer in der Benutzerliste durch
        for (Benutzer benutzer: benutzerliste){

            //Punkte fuer den aktuellen Benutzer
            int punkteDesBenutzers=0;

            //geht alle Tipps durch
            for (Tipp tipp : tipps){

                //gehoert der aktuelle tipp zu dem aktuellen Benutzer
                if (benutzer.getBenutzerid() == tipp.getBenutzerid()){

                    Spielergebnis aktuellesSpielergebniss = getSpielergebnisById(tipp.getSpielid(),spielergebnisse);
                    if (aktuellesSpielergebniss != null ){
                        //addiert die Punkte fuer diesen tipp zu dem Benutzer dazu
                        punkteDesBenutzers = punkteDesBenutzers+berechnePunkteFuerTipp(tipp,aktuellesSpielergebniss);
                    }
                }
            }
            rankingList.add(new Rank(benutzer.getBenutzerid(),benutzer.getBenutzername(),benutzer.getGruppe(),
                    punkteDesBenutzers));
        }


        //Platz des Benutzers in der Ranking-Tabelle hinzufuegen
        for (Rank rank : rankingList){
                rank.setPlatz(getRank(rank.getPunkte(),rankingList));
        }


        return rankingList;
    }

    /**
     * Berechnet die Punkte die ein Tipp dem Benutzer eingebracht hat
     * @param tipp
     * @param spielergebnis
     * @return Integer
     */
    private static int berechnePunkteFuerTipp(Tipp tipp, Spielergebnis spielergebnis){

        int erreichtePunkte = 0;

        // Halbzeitergebis!
            // 6 Punkte fuer Halbzeitergbnis korrekt
            if(tipp.getHalbzeitGastmannschaft() == spielergebnis.getHalbzeitGastmannschaft() &&
                    tipp.getHalbzeitHeimmannschaft() == spielergebnis.getHalbzeitHeimmannschaft()){
                erreichtePunkte = erreichtePunkte+6;
            }
            // 3 Punkte fuer Halbzeitergebnis korrekte Tendenz  (Differenz oder Tendenz ???? )
            else if (tipp.getHalbzeitGastmannschaft()-tipp.getHalbzeitHeimmannschaft() ==
                    spielergebnis.getHalbzeitGastmannschaft()-spielergebnis.getHalbzeitHeimmannschaft()){
                erreichtePunkte = erreichtePunkte + 3;
            }

        //Endergebis!
            // 11 Punkte fuer Endergbnis korrekt
            if(tipp.getEndeGastmannschaft() == spielergebnis.getEndeGastmannschaft() &&
                    tipp.getEndeHeimmannschaft() == spielergebnis.getEndeHeimmannschaft()){
                erreichtePunkte = erreichtePunkte+11;
            }
            // 3 Punkte fuer Endergebnis korrekte Tendenz  (Differenz oder Tendenz ???? )
            else if (tipp.getEndeGastmannschaft()-tipp.getEndeHeimmannschaft() ==
                    spielergebnis.getEndeGastmannschaft()-spielergebnis.getEndeHeimmannschaft()){
                erreichtePunkte = erreichtePunkte + 5;
            }

        //Verlaengerung!
            if (spielergebnis.isVerlaengerung()){
                // 11 Punkte fuer Verlaengerung korrekt
                if(tipp.getVerlaengerungGastmannschaft() == spielergebnis.getVerlaengerungGastmannschaft() &&
                        tipp.getVerlaengerungHeimmannschaft() == spielergebnis.getVerlaengerungHeimmannschaft()){
                    erreichtePunkte = erreichtePunkte+11;
                }
                // 3 Punkte fuer Verlaengerung korrekte Tendenz  (Differenz oder Tendenz ???? )
                else if (tipp.getVerlaengerungGastmannschaft()-tipp.getVerlaengerungHeimmannschaft() ==
                        spielergebnis.getVerlaengerungGastmannschaft()-spielergebnis.getVerlaengerungHeimmannschaft()){
                    erreichtePunkte = erreichtePunkte + 5;
                }
            }

        //Elfmeterschiessen!
        if (spielergebnis.isElfmeterschiessen()){
            // 11 Punkte fuer Elfmeterschiessen korrekt
            if(tipp.getElfmeterschiessenGastmannschaft() == spielergebnis.getElfmeterschiessenGastmannschaft() &&
                    tipp.getElfmeterschiessenHeimmannschaft() == spielergebnis.getElfmeterschiessenHeimmannschaft()){
                erreichtePunkte = erreichtePunkte+11;
            }
            // 3 Punkte fuer Elfmeterschiessen korrekte Tendenz  (Differenz oder Tendenz ???? )
            else if (tipp.getElfmeterschiessenGastmannschaft()-tipp.getElfmeterschiessenHeimmannschaft() ==
                    spielergebnis.getElfmeterschiessenGastmannschaft()-spielergebnis.getElfmeterschiessenHeimmannschaft()){
                erreichtePunkte = erreichtePunkte + 5;
            }
        }

        //Gelbe Karten
        if (tipp.getGelbeKartenGastmannschaft() == spielergebnis.getGelbeKartenGastmannschaft()){
            erreichtePunkte = erreichtePunkte + 3;
        }
        if (tipp.getGelbeKartenHeimmannschaft() == spielergebnis.getGelbeKartenHeimmannschaft()){
            erreichtePunkte = erreichtePunkte + 3;
        }

        //Gelb-Rote Karten
        if (tipp.getGelbRoteKartenGastmannschaft() == spielergebnis.getGelbRoteKartenGastmannschaft()){
            erreichtePunkte = erreichtePunkte + 4;
        }
        if (tipp.getGelbRoteKartenHeimmannschaft() == spielergebnis.getGelbRoteKartenHeimmannschaft()){
            erreichtePunkte = erreichtePunkte + 4;
        }

        //Rote Karten
        if (tipp.getRoteKartenGastmannschaft() == spielergebnis.getRoteKartenGastmannschaft()){
            erreichtePunkte = erreichtePunkte + 5;
        }
        if (tipp.getRoteKartenHeimmannschaft() == spielergebnis.getRoteKartenHeimmannschaft()){
            erreichtePunkte = erreichtePunkte + 5;
        }


        return erreichtePunkte;
    }

    /**
     * Ermittelt das Spielergebnis Objekt zu einer Id in der Liste von Spielergebnissen
     * @param spielid
     * @param spielergebnisse
     * @return Spielergebnis
     */
    private static Spielergebnis getSpielergebnisById(int spielid, List<Spielergebnis> spielergebnisse){
        for (Spielergebnis spielergebnis : spielergebnisse){
            if(spielergebnis.getSpielid() == spielid){
                return spielergebnis;
            }
        }
        return null;
    }

    /**
     * Ermittelt den Platz des Bentuzers anhand der erspielten Punkte
     * @param punkte
     * @param rankList
     * @return Integer
     */
    private static int getRank(int punkte, List<Rank> rankList){

        int platz = 1;
        for (Rank rank : rankList){
            if (rank.getPunkte() > punkte){
                platz++;
            }
        }
        return platz;
    }

}
