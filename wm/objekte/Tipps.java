package wm.objekte;

import java.util.Date;

public class Tipps 
{
	Date date = new Date(); 
	
	private int tippid;
	private int benutzerid;
	private int spieleid;
	private Date tippdatum;
	private int tippheimhz;
	private int tippgasthz;
	private int tippheimende;
	private int tippgastende;
	private int tippheimverl;
	private int tippgastverl;
	private int tippheimelf;
	private int tippgastelf;
	private int tippgelbeheim;
	private int tippgelbegast;
	private int tipproteheim;
	private int tipprotegast;
	
	public Tipps(Date date, int tippid, int benutzerid, int spieleid, Date tippdatum, int tippheimhz, int tippgasthz,
			int tippheimende, int tippgastende, int tippheimverl, int tippgastverl, int tippheimelf, int tippgastelf,
			int tippgelbeheim, int tippgelbegast, int tipproteheim, int tipprotegast) {
		this.date = date;
		this.tippid = tippid;
		this.benutzerid = benutzerid;
		this.spieleid = spieleid;
		this.tippdatum = tippdatum;
		this.tippheimhz = tippheimhz;
		this.tippgasthz = tippgasthz;
		this.tippheimende = tippheimende;
		this.tippgastende = tippgastende;
		this.tippheimverl = tippheimverl;
		this.tippgastverl = tippgastverl;
		this.tippheimelf = tippheimelf;
		this.tippgastelf = tippgastelf;
		this.tippgelbeheim = tippgelbeheim;
		this.tippgelbegast = tippgelbegast;
		this.tipproteheim = tipproteheim;
		this.tipprotegast = tipprotegast;
	}

	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getTippid() {
		return tippid;
	}

	public void setTippid(int tippid) {
		this.tippid = tippid;
	}

	public int getBenutzerid() {
		return benutzerid;
	}

	public void setBenutzerid(int benutzerid) {
		this.benutzerid = benutzerid;
	}

	public int getSpieleid() {
		return spieleid;
	}

	public void setSpieleid(int spieleid) {
		this.spieleid = spieleid;
	}

	public Date getTippdatum() {
		return tippdatum;
	}

	public void setTippdatum(Date tippdatum) {
		this.tippdatum = tippdatum;
	}

	public int getTippheimhz() {
		return tippheimhz;
	}

	public void setTippheimhz(int tippheimhz) {
		this.tippheimhz = tippheimhz;
	}

	public int getTippgasthz() {
		return tippgasthz;
	}

	public void setTippgasthz(int tippgasthz) {
		this.tippgasthz = tippgasthz;
	}

	public int getTippheimende() {
		return tippheimende;
	}

	public void setTippheimende(int tippheimende) {
		this.tippheimende = tippheimende;
	}

	public int getTippgastende() {
		return tippgastende;
	}

	public void setTippgastende(int tippgastende) {
		this.tippgastende = tippgastende;
	}

	public int getTippheimverl() {
		return tippheimverl;
	}

	public void setTippheimverl(int tippheimverl) {
		this.tippheimverl = tippheimverl;
	}

	public int getTippgastverl() {
		return tippgastverl;
	}

	public void setTippgastverl(int tippgastverl) {
		this.tippgastverl = tippgastverl;
	}

	public int getTippheimelf() {
		return tippheimelf;
	}

	public void setTippheimelf(int tippheimelf) {
		this.tippheimelf = tippheimelf;
	}

	public int getTippgastelf() {
		return tippgastelf;
	}

	public void setTippgastelf(int tippgastelf) {
		this.tippgastelf = tippgastelf;
	}

	public int getTippgelbeheim() {
		return tippgelbeheim;
	}

	public void setTippgelbeheim(int tippgelbeheim) {
		this.tippgelbeheim = tippgelbeheim;
	}

	public int getTippgelbegast() {
		return tippgelbegast;
	}

	public void setTippgelbegast(int tippgelbegast) {
		this.tippgelbegast = tippgelbegast;
	}

	public int getTipproteheim() {
		return tipproteheim;
	}

	public void setTipproteheim(int tipproteheim) {
		this.tipproteheim = tipproteheim;
	}

	public int getTipprotegast() {
		return tipprotegast;
	}

	public void setTipprotegast(int tipprotegast) {
		this.tipprotegast = tipprotegast;
	}
	
	
	
	
}
