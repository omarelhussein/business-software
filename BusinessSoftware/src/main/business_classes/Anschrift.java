package main.business_classes;

/**

 *Created by Mohammad 10.12.2019
 */
public class Anschrift {
	
	private int id;
	private String adressse;
	private String tel;
	private String stadt;
	private String ort;
	private String plz;

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
	public String getOrt() {
		return ort;
	}
	public void setOrt(String ort) {
		this.ort = ort;
	}
	public String getPlz() {
		return plz;
	}
	public void setPlz(String plz) {
		this.plz = plz;
	}
}
