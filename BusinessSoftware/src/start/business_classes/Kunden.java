package start.business_classes;


/**
 * Created on 10.12.2019
 * @author alkazah
 *
 */
public class Kunden {

	private int id;
	private String name;
	private String nachname;

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getNachname() {
		return nachname;
	}

}
