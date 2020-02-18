package general.code;

import java.awt.Component;

import javax.swing.JList;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

import abteilungen.business_classes.Abteilung;
import artikel.business_classes.Artikel;
import kategorie.business_classes.Kategorie;
import mitarbeiter.business_classes.Mitarbeiter;

@SuppressWarnings("serial")
public class JComboBoxAdapter extends BasicComboBoxRenderer {
	
	private Abteilung abteilung;
	private Kategorie kategorie;
	private Mitarbeiter mitarbeiter;
	private Artikel artikel;
	private int selectedIndex = -1;
	
	public JComboBoxAdapter(Object object) {
		if(object instanceof Abteilung) {
			selectedIndex = 0;
		} else if(object instanceof Kategorie) {
			selectedIndex = 1;
		} else if(object instanceof Mitarbeiter) {
			selectedIndex = 2;
		} else if(object instanceof Artikel) {
			selectedIndex = 3;
		}
	}

	@Override
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {
		super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		switch (selectedIndex) {
		case -1:
			setText("");
			break;
		case 0:
			abteilung = (Abteilung) value;
			setText(abteilung != null ? abteilung.getNameAbteilung() : "");
			break;
		case 1:
			kategorie = (Kategorie) value;
			setText(kategorie != null ? kategorie.getNamekategorie() : "");
			break;
		case 2:
			mitarbeiter = (Mitarbeiter) value;
			setText(mitarbeiter != null ? mitarbeiter.getNamemitarbeiter() : "");
			break;
		case 3:
			artikel = (Artikel) value;
			setText(artikel.getNameArtikel());
		default:
			break;
		}
		return this;
		
	}

}
