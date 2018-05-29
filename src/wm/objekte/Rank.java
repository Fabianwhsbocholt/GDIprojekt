package wm.objekte;

public class Rank {


    private int benutzerid;
    private String tipper;
    private int platz;
    private int punkte;
    private String gruppe;

    public Rank() {

    }

    public Rank(int benutzerid, String benutzername, String gruppe, int punkte){
        this.benutzerid = benutzerid;
        this.tipper = benutzername;
        this.gruppe = gruppe;
        this.punkte = punkte;
    }

    public int getBenutzerid() {
        return benutzerid;
    }

    public void setBenutzerid(int benutzerid) {
        this.benutzerid = benutzerid;
    }

    public String getTipper() {
        return tipper;
    }

    public void setTipper(String tipper) {
        this.tipper = tipper;
    }

    public int getPlatz() {
        return platz;
    }

    public void setPlatz(int platz) {
        this.platz = platz;
    }

    public int getPunkte() {
        return punkte;
    }

    public void setPunkte(int punkte) {
        this.punkte = punkte;
    }

    public String getGruppe() {
        return gruppe;
    }

    public void setGruppe(String gruppe) {
        this.gruppe = gruppe;
    }


}
