package main.business_classes;

public class Geschaeft {
	
	private int id;
	private String namegeascheaft;
	private String bezeichnung;
	private String pass;
	private String tel;
	private String email;
	private int gaf;

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setGaf(int gaf) {
		this.gaf = gaf;
	}

	public int getGaf() {
		return gaf;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPass() {
		return pass;
	}

	public void setNamegeascheaft(String namegeascheaft) {
		this.namegeascheaft = namegeascheaft;
	}

	public String getNamegeascheaft() {
		return namegeascheaft;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}

}
