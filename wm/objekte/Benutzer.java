package wm.objekte;

import java.util.Date;

public class Benutzer 
{
	Date date = new Date();
	
	private String benutzerName;
	private String autologin;
	private String IP;
	private String sessionID;
	private String nickname;
	private String passwort;
	private String gruppenname;
	private String email;
	private Date registrierungsdatum;
	
	public Benutzer(Date date, String benutzerName, String autologin, String iP, String sessionID, String nickname,
			String passwort, String gruppenname, String email, Date registrierungsdatum) 
	{
		this.date = date;
		this.benutzerName = benutzerName;
		this.autologin = autologin;
		this.IP = iP;
		this.sessionID = sessionID;
		this.nickname = nickname;
		this.passwort = passwort;
		this.gruppenname = gruppenname;
		this.email = email;
		this.registrierungsdatum = registrierungsdatum;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getBenutzerName() {
		return benutzerName;
	}
	public void setBenutzerName(String benutzerName) {
		this.benutzerName = benutzerName;
	}
	public String getAutologin() {
		return autologin;
	}
	public void setAutologin(String autologin) {
		this.autologin = autologin;
	}
	public String getIP() {
		return IP;
	}
	public void setIP(String iP) {
		IP = iP;
	}
	public String getSessionID() {
		return sessionID;
	}
	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPasswort() {
		return passwort;
	}
	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}
	public String getGruppenname() {
		return gruppenname;
	}
	public void setGruppenname(String gruppenname) {
		this.gruppenname = gruppenname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getRegistrierungsdatum() {
		return registrierungsdatum;
	}
	public void setRegistrierungsdatum(Date registrierungsdatum) {
		this.registrierungsdatum = registrierungsdatum;
	}
	
	
}
