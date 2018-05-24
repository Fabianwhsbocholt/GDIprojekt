package wm.objekte;

import java.util.Date;

public class Ranking
{
	Date date = new Date();
	
	private Date datum;
	private int benutzerid;
	private int punkte;
	private int platz;
	
	public Ranking(Date date, Date datum, int benutzerid, int punkte, int platz)
	{
		this.date = date;
		this.datum = datum;
		this.benutzerid = benutzerid;
		this.punkte = punkte;
		this.platz = platz;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getDatum() {
		return datum;
	}
	public void setDatum(Date datum) {
		this.datum = datum;
	}
	public int getBenutzerid() {
		return benutzerid;
	}
	public void setBenutzerid(int benutzerid) {
		this.benutzerid = benutzerid;
	}
	public int getPunkte() {
		return punkte;
	}
	public void setPunkte(int punkte) {
		this.punkte = punkte;
	}
	public int getPlatz() {
		return platz;
	}
	public void setPlatz(int platz) {
		this.platz = platz;
	}
	
	
}
