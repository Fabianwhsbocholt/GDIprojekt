package wm.interfaces;

// Dieses Interface gibt die Funktionen vor, die in der Klasse DBConnector ausprogrammiert werden müssen

import wm.objekte.Configuration;

public interface DBConnectorI
{
	public String connect (Configuration config);
	
	public String tabellenAnlegen ();
	
	public String datenEinlesen (boolean testdaten);
	
	public String spielplan ();
	
	public String close ();
}
