package mitarbeiter.business_classes;

import main.business_classes.Anschrift;

/**
 * Created on 10.12.2019
 * @author alkazah
 *
 */
public class Mitarbeiter {

	private int id;
	private String namemitarbeiter;
	private String nachname;
	private String lohn;
	private String pass;
	private Anschrift anschrift;

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setAnschrift(Anschrift anschrift) {
		this.anschrift = anschrift;
	}
	
	public void setNamemitarbeiter(String namemitarbeiter) {
		this.namemitarbeiter = namemitarbeiter;
	}

	public String getNamemitarbeiter() {
		return namemitarbeiter;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setLohn(String lohn) {
		this.lohn = lohn;
	}

	public String getLohn() {
		return lohn;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPass() {
		return pass;
	}
	
	public Anschrift getAnschrift() {
		return anschrift;
	}

}
