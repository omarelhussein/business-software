package start;


/**
 * Created on 10.12.2019
 * @author alkazah
 *
 */
public class Geschaeft {
	private int id;
	private String namegeschaeft;
	private String Bezeichnung;
	private String pass;

	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setNamegeschaeft(String namegeschaeft) {
		this.namegeschaeft = namegeschaeft;
	}
	public String getNamegeschaeft() {
		return namegeschaeft;
	}
	public void setBezeichnung(String bezeichnung) {
		Bezeichnung = bezeichnung;
	}
	public String getBezeichnung() {
		return Bezeichnung;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getPass() {
		return pass;
	}

}
