package main.business_classes;

public class Anschrift {
	
	private int id;
	private String adressse;
	private String tel;
	private String stadt;

	public void setAdressse(String adressse) {
		this.adressse = adressse;
	}

	public String getAdressse() {
		return adressse;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setStadt(String stadt) {
		this.stadt = stadt;
	}

	public String getStadt() {
		return stadt;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getTel() {
		return tel;
	}
}
