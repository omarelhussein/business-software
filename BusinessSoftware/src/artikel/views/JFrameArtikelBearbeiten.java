package artikel.views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import abteilungen.DaoAbteilung;
import abteilungen.business_classes.Abteilung;
import artikel.DaoArtikel;
import artikel.business_classes.Artikel;
import general.code.GeschaeftDB;
import general.code.JComboBoxAdapter;
import general.code.Utils;
import general.design.Colors;
import general.design.Fonts;
import general.design.Unicodes;
import kategorie.business_classes.Kategorie;
import kategorie.dao.DaoKategorie;
import start.views.JFrameStart;

@SuppressWarnings("serial")
public class JFrameArtikelBearbeiten extends JFrame {

	private JPanel contentPane;
	private JLabel labelArtikelBearbeiten;
	private JTextField nameArtikel;
	private JTextField preisArtikel;
	private JButton buttonSpeichern;
	private JLabel lblArtikelBearbeiten;
	private JPanel panel;
	private JButton weiter;
	private JList<Object> list;
	private JTextField textFieldName;
	private JTextField textFieldPreis;
	private JTextField textFieldAnzahl;
	private JComboBox<Kategorie> comboBoxKategorie;
	private JComboBox<Abteilung> comboBoxAbteilung;
	private JLabel name;
	private JLabel preis;
	private JLabel anzahl;
	private JSeparator separator;
	private JScrollPane scrollPane;
	private JButton aktuallisieren;
	private JButton loeschen;
	private JSeparator separator_1;
	private JLabel labelGewicht;
	private JTextField textFieldGewicht;
	private JLabel labelMarke;
	private JTextField textFieldMarke;
	private JLabel labelDatum;
	private JTextField textFieldDatum;
	// DB
	private DaoArtikel daoArtikel;
	private DaoAbteilung daoAbteilung;
	private DaoKategorie daoKategorie;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameArtikelBearbeiten frame = new JFrameArtikelBearbeiten();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Created by Mohammad on 11.02.2020 Create the frame.
	 * 
	 * @throws ClassNotFoundException
	 */

	public JFrameArtikelBearbeiten() {
		daoAbteilung = new DaoAbteilung();
		daoArtikel = new DaoArtikel();
		daoKategorie = new DaoKategorie();
		initGUI();
		loadArticles(true, true);
	}

	private void initGUI() {
		Utils.setMiddleFrameOptions(this);

		contentPane = new JPanel();
		contentPane.setBackground(Colors.parseColor(Colors.LIGHT_GREY));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		{
			if (!JFrameStart.wegRegistierung) {
				// comboBox.setModel(new
				// DefaultComboBoxModel(abteilung.Abteilungen(frameRegistrieren.nameGeascheaft)));
			}
		}
		contentPane.setLayout(null);
		{
			lblArtikelBearbeiten = new JLabel("Artikel Bearbeiten");
			lblArtikelBearbeiten.setForeground(Colors.parseColor(Colors.SEXY_BLUE));
			Fonts.setCenturySchoolbookFont(lblArtikelBearbeiten, 18);
			lblArtikelBearbeiten.setHorizontalAlignment(SwingConstants.CENTER);
			lblArtikelBearbeiten.setBounds(87, 11, 408, 30);
			contentPane.add(lblArtikelBearbeiten);
		}
		{
			panel = new JPanel();
			panel.setBorder(new LineBorder(new Color(0, 0, 0)));
			panel.setBackground(Colors.parseColor(Colors.LIGHT_PINK));
			panel.setBounds(10, 43, 614, 523);
			contentPane.add(panel);
			panel.setLayout(null);
			{
				scrollPane = new JScrollPane();
				scrollPane.setBounds(360, 11, 244, 501);
				panel.add(scrollPane);
				{
					list = new JList<>();
					list.addListSelectionListener(new ListSelectionListener() {

						@Override
						public void valueChanged(ListSelectionEvent e) {
							if (list.isSelectedIndex(list.getSelectedIndex())) {
								fillFields();
							} else {
								clearFields();
							}
						}
					});
					scrollPane.setViewportView(list);
				}
			}
			{
				textFieldName = new JTextField();
				textFieldName.setBounds(125, 20, 194, 25);
				panel.add(textFieldName);
				textFieldName.setColumns(10);
			}
			{
				textFieldPreis = new JTextField();
				textFieldPreis.setBounds(125, 70, 194, 25);
				panel.add(textFieldPreis);
				textFieldPreis.setColumns(10);
			}
			{
				textFieldAnzahl = new JTextField();
				textFieldAnzahl.setBounds(125, 120, 194, 25);
				panel.add(textFieldAnzahl);
				textFieldAnzahl.setColumns(10);
			}
			{
				comboBoxKategorie = new JComboBox<>(loadCategories(getCurrentAbteilungFromIndex(0)));
				comboBoxKategorie.setRenderer(new JComboBoxAdapter(new Kategorie()));
				comboBoxKategorie.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						onKategorieSelected(e);
					}
				});
				comboBoxKategorie.setBounds(20, 418, 330, 38);
				comboBoxKategorie.setBackground(Colors.parseColor(Colors.LIGHT_PINK));
				panel.add(comboBoxKategorie);
			}
			{
				comboBoxAbteilung = new JComboBox<>(
						daoAbteilung.Abteilungen(GeschaeftDB.getInstance().getCurrentAccountName()));
				comboBoxAbteilung.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						onAbteilungSelected(arg0);
					}
				});
				comboBoxAbteilung.setRenderer(new JComboBoxAdapter(new Abteilung()));
				comboBoxAbteilung.setBounds(20, 369, 330, 38);
				comboBoxAbteilung.setBackground(Colors.parseColor(Colors.LIGHT_PINK));
				panel.add(comboBoxAbteilung);
			}
			{
				name = new JLabel("Name");
				name.setFont(new Font("Trebuchet MS", Font.ITALIC, 15));
				name.setBounds(48, 20, 60, 25);
				panel.add(name);
			}
			{
				preis = new JLabel("Preis");
				preis.setFont(new Font("Trebuchet MS", Font.ITALIC, 15));
				preis.setBounds(48, 70, 60, 25);
				panel.add(preis);
			}
			{
				anzahl = new JLabel("Anzahl");
				anzahl.setFont(new Font("Trebuchet MS", Font.ITALIC, 15));
				anzahl.setBounds(48, 120, 60, 25);
				panel.add(anzahl);
			}
			{
				separator = new JSeparator();
				separator.setBounds(10, 296, 359, 1);
				panel.add(separator);
			}
			{
				aktuallisieren = new JButton("Aktuallisieren");
				aktuallisieren.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						onUpdateClicked(e);
					}
				});
				aktuallisieren.setBounds(20, 308, 160, 38);
				Utils.setStandardButtonOptions(aktuallisieren);
				panel.add(aktuallisieren);
			}
			{
				loeschen = new JButton("L\u00F6schen");
				loeschen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						onDeleteClicked(e);
					}
				});
				Utils.setStandardButtonOptions(loeschen);
				loeschen.setBounds(185, 308, 160, 38);
				panel.add(loeschen);
			}
			{
				separator_1 = new JSeparator();
				separator_1.setBounds(10, 357, 359, 1);
				panel.add(separator_1);
			}
			{
				labelGewicht = new JLabel("Gewicht");
				labelGewicht.setFont(new Font("Trebuchet MS", Font.ITALIC, 15));
				labelGewicht.setBounds(48, 168, 60, 25);
				panel.add(labelGewicht);
			}
			{
				textFieldGewicht = new JTextField();
				textFieldGewicht.setColumns(10);
				textFieldGewicht.setBounds(125, 168, 194, 25);
				panel.add(textFieldGewicht);
			}
			{
				labelMarke = new JLabel("Marke");
				labelMarke.setFont(new Font("Trebuchet MS", Font.ITALIC, 15));
				labelMarke.setBounds(48, 215, 60, 25);
				panel.add(labelMarke);
			}
			{
				textFieldMarke = new JTextField();
				textFieldMarke.setColumns(10);
				textFieldMarke.setBounds(125, 215, 194, 25);
				panel.add(textFieldMarke);
			}
			{
				labelDatum = new JLabel("Datum");
				labelDatum.setFont(new Font("Trebuchet MS", Font.ITALIC, 15));
				labelDatum.setBounds(48, 260, 60, 25);
				panel.add(labelDatum);
			}
			{
				textFieldDatum = new JTextField();
				textFieldDatum.setColumns(10);
				textFieldDatum.setBounds(125, 260, 194, 25);
				panel.add(textFieldDatum);
			}
		}
		{
			weiter = new JButton(Unicodes.CHECK);
			weiter.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					onCheckClicked(e);
				}
			});
			Utils.setStandardButtonOptions(weiter);
			weiter.setBounds(535, 577, 89, 23);
			contentPane.add(weiter);
		}
	}

	protected void onSaveClicked(ActionEvent e) {
		// TODO continue method
	}

	protected void onAbteilungSelected(ActionEvent arg0) {
		loadArticles(true, true);
		Abteilung abteilung = daoAbteilung
				.Abteilungen(GeschaeftDB.getInstance().getCurrentAccountName())[comboBoxAbteilung.getSelectedIndex()];
		System.out.println("ABTEILUNG ID: " + abteilung.getId());
	}

	/**
	 * Created by Omar 14.02.2020 if there is no Category for the Abteilung, all the
	 * items will be listed otherwise it will update the categories list to show in
	 * the comboBox the articles will be loaded in both cases
	 */
	private List<Artikel> loadArticles(boolean refreshComboBox, boolean reloadList) {
		String[] values;
		ArrayList<String> valuesList;
		List<Artikel> artikelnList;

		if (refreshComboBox) {
			comboBoxKategorie.setModel(new DefaultComboBoxModel<Kategorie>(
					loadCategories(getCurrentAbteilungFromIndex(comboBoxAbteilung.getSelectedIndex()))));
		}
		if (loadCategories(getCurrentAbteilungFromIndex(comboBoxAbteilung.getSelectedIndex())).length == 0) {
			values = loadArtikelNames(arrayListToArrayArtikel(
					daoArtikel.loadAbteilungArtikeln(comboBoxAbteilung.getSelectedItem().toString())));
			valuesList = arrayToArrayList(values);
			artikelnList = daoArtikel.loadAbteilungArtikeln(comboBoxAbteilung.getSelectedItem().toString());
			if (reloadList) {
				Utils.updateList(list, true, scrollPane, valuesList);
			}
		} else {
			Kategorie currentKat = loadCategories(
					getCurrentAbteilungFromIndex(comboBoxAbteilung.getSelectedIndex()))[comboBoxKategorie
							.getSelectedIndex()];
			values = loadArtikelNames(arrayListToArrayArtikel(daoArtikel.loadKategorienArtikeln(currentKat.getId())));
			valuesList = arrayToArrayList(values);
			artikelnList = daoArtikel.loadKategorienArtikeln(currentKat.getId());
			if (reloadList) {
				Utils.updateList(list, true, scrollPane, valuesList);
			}
		}
		return artikelnList;
	}

	/**
	 * created by Omar on 14.02.2020.
	 * 
	 * @param abteilung the current abteilung
	 * @return all the categories for this abteilung
	 */
	private Kategorie[] loadCategories(Abteilung abteilung) {
		Kategorie[] categories = Utils.arrayListToArray(Kategorie.class,
				daoKategorie.loadKategorien(abteilung.getId()));
		return categories;
	}

	private String[] loadArtikelNames(Artikel[] artikels) {
		String[] artikelNames = new String[artikels.length];
		for (int i = 0; i < artikels.length; i++) {
			artikelNames[i] = artikels[i].getNameArtikel();
		}
		return artikelNames;
	}

	private Artikel[] arrayListToArrayArtikel(List<Artikel> artikelList) {
		Artikel[] artikelArray = new Artikel[artikelList.size()];
		for (int i = 0; i < artikelList.size(); i++) {
			artikelArray[i] = artikelList.get(i);
		}
		return artikelArray;
	}

	private ArrayList<String> arrayToArrayList(String[] array) {
		ArrayList<String> listNames = new ArrayList<>();
		for (int i = 0; i < array.length; i++) {
			listNames.add(array[i]);
		}
		return listNames;
	}

	protected void onKategorieSelected(ActionEvent e) {
		loadArticles(false, true);
	}

	private void fillFields() {
		int selectedIndex = list.getSelectedIndex();
		Artikel artikel = loadArticles(false, false).get(selectedIndex);
		textFieldName.setText(artikel.getNameArtikel());
		textFieldPreis.setText(artikel.getPreis());
		textFieldDatum.setText(artikel.getDatum());
		textFieldGewicht.setText(String.valueOf(artikel.getGewicht()));
		textFieldMarke.setText(artikel.getMarke());
		textFieldAnzahl.setText(String.valueOf(artikel.getAnzahl()));
	}

	private void clearFields() {
		textFieldName.setText("");
		textFieldPreis.setText("");
		textFieldAnzahl.setText("");
		textFieldMarke.setText("");
		textFieldGewicht.setText("");
		textFieldDatum.setText("");
	}

	protected void onCheckClicked(ActionEvent e) {
		this.setVisible(false);
	}

	protected void onDeleteClicked(ActionEvent e) {
		if (list.isSelectionEmpty()) {
			JOptionPane.showMessageDialog(this, "Bitte einen Artikel auswählen");
			return;
		}
		int currentId = loadArticles(false, false).get(list.getSelectedIndex()).getId();
		daoArtikel.deleteArtikel(currentId);
		loadArticles(false, true);
	}

	private Abteilung getCurrentAbteilungFromIndex(int index) {
		return daoAbteilung.Abteilungen(GeschaeftDB.getInstance().getCurrentAccountName())[index];
	}

	protected void onUpdateClicked(ActionEvent e) {
		if (list.isSelectionEmpty()) {
			JOptionPane.showMessageDialog(this, "Bitte einen Artikel auswählen");
			return;
		}
		if (textFieldName.getText().isEmpty() || textFieldPreis.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Bitte alle Felder ausfüllen");
		}
		Artikel currentArtikel = loadArticles(false, false).get(list.getSelectedIndex());
		// set new object data here to update
		currentArtikel.setNameArtikel(textFieldName.getText());
		currentArtikel.setPreis(textFieldPreis.getText());
		daoArtikel.updateArtikel(currentArtikel);
		loadArticles(false, true);
	}
}
