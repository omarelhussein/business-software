package abteilungen.business_classes;

public class Abteilung {
	
	private int id;
	private String nameAbteilung;
	private String agf;

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setNameAbteilung(String nameAbteilung) {
		this.nameAbteilung = nameAbteilung;
	}

	public String getNameAbteilung() {
		return nameAbteilung;
	}
	public void setAgf(String agf) {
		this.agf = agf;
	}
	public String getAgf() {
		return agf;
	}

}
