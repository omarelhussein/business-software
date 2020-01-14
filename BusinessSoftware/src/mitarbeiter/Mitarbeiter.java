package mitarbeiter;

public class Mitarbeiter {
	private String name;
	private String lohn;
	private String pass;
	private String nachname;
	public void setLohn(String lohn) {
		this.lohn = lohn;
	}
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getLohn() {
		return lohn;
	}
	public String getNachname() {
		return nachname;
	}
	public String getName() {
		return name;
	}
	public String getPass() {
		return pass;
	}

}
