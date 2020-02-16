package artikel.business_classes;

/**
 * Created by Mohammad on 10.12.2019
 */
public class Artikel {
	
	private int id;
	private String nameArtikel;
	private String preis;
	private int anzahl;
	private String marke;
	private String datum;
	private double gewicht;

	public void setId(int id) {
		this.id = id;
	}

	public int getAnzahl() {
		return anzahl;
	}

	public void setAnzahl(int anzahl) {
		this.anzahl = anzahl;
	}

	public String getMarke() {
		return marke;
	}

	public void setMarke(String marke) {
		this.marke = marke;
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	public double getGewicht() {
		return gewicht;
	}

	public void setGewicht(double gewicht) {
		this.gewicht = gewicht;
	}

	public int getId() {
		return id;
	}

	public void setNameArtikel(String nameArtikel) {
		this.nameArtikel = nameArtikel;
	}

	public String getNameArtikel() {
		return nameArtikel;
	}

	public void setPreis(String preis) {
		this.preis = preis;
	}

	public String getPreis() {
		return preis;
	}

}
