package wm.objekte;

import java.util.Date;

public class Spiele 
{
	Date date = new Date();
	
	private int spieleid;
	private String spielbezeichnung;
	private String spielort;
	private Date datumuhrzeit;
	private String heimmanschaft;
	private String gastmanschaft;
	private int heimmanschafthz;
	private int gastmannschafthz;
	private int heimmannschaftende;
	private int gastmannschaftende;
	private boolean verlaengerung;
	private int heimmannschaftverl;
	private int gastmannschaftverl;
	private boolean elfmeter; 
	private int heimmannschaftelf;
	private int gastmannschaftelf;
	private int gelbekartenheim;
	private int gelbekartengast;
	private int rotekartenheim;
	private int rotekartengast;
	
	
	public Spiele(Date date, int spieleid, String spielbezeichnung, String spielort, Date datumuhrzeit,
			String heimmanschaft, String gastmanschaft, int heimmanschafthz, int gastmannschafthz,
			int heimmannschaftende, int gastmannschaftende, boolean verlaengerung, int heimmannschaftverl,
			int gastmannschaftverl, boolean elfmeter, int heimmannschaftelf, int gastmannschaftelf, int gelbekartenheim,
			int gelbekartengast, int rotekartenheim, int rotekartengast) 
	{
		this.date = date;
		this.spieleid = spieleid;
		this.spielbezeichnung = spielbezeichnung;
		this.spielort = spielort;
		this.datumuhrzeit = datumuhrzeit;
		this.heimmanschaft = heimmanschaft;
		this.gastmanschaft = gastmanschaft;
		this.heimmanschafthz = heimmanschafthz;
		this.gastmannschafthz = gastmannschafthz;
		this.heimmannschaftende = heimmannschaftende;
		this.gastmannschaftende = gastmannschaftende;
		this.verlaengerung = verlaengerung;
		this.heimmannschaftverl = heimmannschaftverl;
		this.gastmannschaftverl = gastmannschaftverl;
		this.elfmeter = elfmeter;
		this.heimmannschaftelf = heimmannschaftelf;
		this.gastmannschaftelf = gastmannschaftelf;
		this.gelbekartenheim = gelbekartenheim;
		this.gelbekartengast = gelbekartengast;
		this.rotekartenheim = rotekartenheim;
		this.rotekartengast = rotekartengast;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getSpieleid() {
		return spieleid;
	}

	public void setSpieleid(int spieleid) {
		this.spieleid = spieleid;
	}

	public String getSpielbezeichnung() {
		return spielbezeichnung;
	}

	public void setSpielbezeichnung(String spielbezeichnung) {
		this.spielbezeichnung = spielbezeichnung;
	}

	public String getSpielort() {
		return spielort;
	}

	public void setSpielort(String spielort) {
		this.spielort = spielort;
	}

	public Date getDatumuhrzeit() {
		return datumuhrzeit;
	}

	public void setDatumuhrzeit(Date datumuhrzeit) {
		this.datumuhrzeit = datumuhrzeit;
	}

	public String getHeimmanschaft() {
		return heimmanschaft;
	}

	public void setHeimmanschaft(String heimmanschaft) {
		this.heimmanschaft = heimmanschaft;
	}

	public String getGastmanschaft() {
		return gastmanschaft;
	}

	public void setGastmanschaft(String gastmanschaft) {
		this.gastmanschaft = gastmanschaft;
	}

	public int getHeimmanschafthz() {
		return heimmanschafthz;
	}

	public void setHeimmanschafthz(int heimmanschafthz) {
		this.heimmanschafthz = heimmanschafthz;
	}

	public int getGastmannschafthz() {
		return gastmannschafthz;
	}

	public void setGastmannschafthz(int gastmannschafthz) {
		this.gastmannschafthz = gastmannschafthz;
	}

	public int getHeimmannschaftende() {
		return heimmannschaftende;
	}

	public void setHeimmannschaftende(int heimmannschaftende) {
		this.heimmannschaftende = heimmannschaftende;
	}

	public int getGastmannschaftende() {
		return gastmannschaftende;
	}

	public void setGastmannschaftende(int gastmannschaftende) {
		this.gastmannschaftende = gastmannschaftende;
	}

	public boolean isVerlaengerung() {
		return verlaengerung;
	}

	public void setVerlaengerung(boolean verlaengerung) {
		this.verlaengerung = verlaengerung;
	}

	public int getHeimmannschaftverl() {
		return heimmannschaftverl;
	}

	public void setHeimmannschaftverl(int heimmannschaftverl) {
		this.heimmannschaftverl = heimmannschaftverl;
	}

	public int getGastmannschaftverl() {
		return gastmannschaftverl;
	}

	public void setGastmannschaftverl(int gastmannschaftverl) {
		this.gastmannschaftverl = gastmannschaftverl;
	}

	public boolean isElfmeter() {
		return elfmeter;
	}

	public void setElfmeter(boolean elfmeter) {
		this.elfmeter = elfmeter;
	}

	public int getHeimmannschaftelf() {
		return heimmannschaftelf;
	}

	public void setHeimmannschaftelf(int heimmannschaftelf) {
		this.heimmannschaftelf = heimmannschaftelf;
	}

	public int getGastmannschaftelf() {
		return gastmannschaftelf;
	}

	public void setGastmannschaftelf(int gastmannschaftelf) {
		this.gastmannschaftelf = gastmannschaftelf;
	}

	public int getGelbekartenheim() {
		return gelbekartenheim;
	}

	public void setGelbekartenheim(int gelbekartenheim) {
		this.gelbekartenheim = gelbekartenheim;
	}

	public int getGelbekartengast() {
		return gelbekartengast;
	}

	public void setGelbekartengast(int gelbekartengast) {
		this.gelbekartengast = gelbekartengast;
	}
	
	public int getRotekartenheim() {
		return rotekartenheim;
	}

	public void setRotekartenheim(int rotekartenheim) {
		this.rotekartenheim = rotekartenheim;
	}

	public int getRotekartengast() {
		return rotekartengast;
	}

	public void setRotekartengast(int rotekartengast) {
		this.rotekartengast = rotekartengast;
	}
	

	
	
}
