package artikel.views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import abteilungen.DaoAbteilung;
import artikel.DaoArtikel;
import artikel.business_classes.Artikel;
import general.code.GeschaeftDB;
import general.code.Utils;
import general.design.Colors;
import general.design.Fonts;
import general.design.Unicodes;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import kategorie.dao.DaoKategorie;


import java.awt.Font;
import java.awt.Color;


@SuppressWarnings("serial")
public class JFrameArtikelAnzeigen extends JFrame {

	private JPanel contentPane;
	private JLabel labelArtikelAnzeigen;
	private JScrollPane scrollPane;

	private Artikel[] artikelList;
	private DaoArtikel daoArtikel;
	private DaoKategorie daoKategorie;
	private JComboBox<String> comboBoxAbteilung;
	private DaoAbteilung daoAbteilung;

	private JButton buttonAnzeigen;
	private JButton buttonSpeichern;
	private JList<Object> list;
	private JLabel labelNewLabel;
	private JLabel labelKategorieAuswhlen;
	private JComboBox<String> comboBoxKategorie;
	private JTextField textFieldSuchen;
	private JButton button;
	private Artikel[] value = new Artikel[] {};
	Artikel artikel;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameArtikelAnzeigen frame = new JFrameArtikelAnzeigen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFrameArtikelAnzeigen() {
		artikel=new Artikel();
		daoArtikel = new DaoArtikel();
		daoAbteilung = new DaoAbteilung();
		daoKategorie = new DaoKategorie();
		initGUI();
		loadArticles(true);
	}

	/**
	 * Created by Mohammad 28.01.2020
	 */
	private void initGUI() {

		Utils.setSmallFrameOptions(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Colors.parseColor(Colors.LIGHT_GREY));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			labelArtikelAnzeigen = new JLabel("Liste Artikeln");
			labelArtikelAnzeigen.setHorizontalAlignment(SwingConstants.CENTER);
			labelArtikelAnzeigen.setBounds(10, 11, 350, 31);
			Fonts.setCenturySchoolbookFont(labelArtikelAnzeigen, 18);
			labelArtikelAnzeigen.setForeground(Colors.parseColor(Colors.SEXY_BLUE));
			contentPane.add(labelArtikelAnzeigen);
		}
		{


			comboBoxAbteilung = new JComboBox<>();
			comboBoxAbteilung.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					onAbteilungSelected(e);
				}
			});
			comboBoxAbteilung.setBackground(Colors.parseColor(Colors.LIGHT_PINK));
			comboBoxAbteilung.setModel(new DefaultComboBoxModel<>(
					daoAbteilung.Abteilungen(GeschaeftDB.getInstance().getCurrentAccountName())));
			comboBoxAbteilung.setBounds(240, 121, 135, 21);
			contentPane.add(comboBoxAbteilung);

		}

		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 93, 220, 258);
			contentPane.add(scrollPane);
			{
				list = new JList<>();
				scrollPane.setViewportView(list);
				List<Artikel> artikeln = daoArtikel
						.loadAbteilungArtikeln(comboBoxAbteilung.getSelectedItem().toString());
				artikelList = arrayListToArrayArtikel(artikeln);
				list.setModel(new AbstractListModel<Object>() {
					String[] values = loadArtikelNames(artikelList);

					public int getSize() {
						return value.length;
					}

					public Object getElementAt(int index) {
						return value[index];
					}
				});
			}
		}
		{
			buttonAnzeigen = new JButton("Anzeigen");
			buttonAnzeigen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					onAnzeigenClicked(e);
				}
			});
			buttonAnzeigen.setBounds(240, 289, 134, 25);
			Utils.setStandardButtonOptions(buttonAnzeigen);
			contentPane.add(buttonAnzeigen);
		}
		{
			buttonSpeichern = new JButton(Unicodes.CHECK);
			buttonSpeichern.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					onCheckClicked(e);
				}
			});
			buttonSpeichern.setBounds(240, 325, 134, 25);
			Utils.setStandardButtonOptions(buttonSpeichern);
			contentPane.add(buttonSpeichern);
		}
		{
<<<<<<< HEAD
			labelNewLabel = new JLabel("Abteilung ausw\u00E4hlen");
			labelNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			labelNewLabel.setBounds(240, 96, 135, 14);
			contentPane.add(labelNewLabel);
		}
		{
			labelKategorieAuswhlen = new JLabel("Kategorie ausw\u00E4hlen");
			labelKategorieAuswhlen.setHorizontalAlignment(SwingConstants.CENTER);
			labelKategorieAuswhlen.setBounds(240, 153, 135, 14);
			contentPane.add(labelKategorieAuswhlen);
		}
		{
			comboBoxKategorie = new JComboBox<String>();
			comboBoxKategorie.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					onCategorySelected(e);
				}
			});
			comboBoxKategorie.setModel(new DefaultComboBoxModel<>(arrayListToArrayString(
					daoKategorie.loadKategorien(comboBoxAbteilung.getSelectedItem().toString()))));
			comboBoxKategorie.setBackground(new Color(255, 250, 250));
			comboBoxKategorie.setBounds(240, 172, 135, 21);
			contentPane.add(comboBoxKategorie);
		}
		{
			textFieldSuchen = new JTextField();
			textFieldSuchen.setColumns(10);
			textFieldSuchen.setBounds(10, 57, 125, 25);
			contentPane.add(textFieldSuchen);
		}
		{
			button = new JButton("Suchen");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					onSearchClicked(e);
				}
			});
			Utils.setStandardButtonOptions(button);
			button.setBounds(145, 57, 89, 25);
			contentPane.add(button);
		}
	}



	private String[] loadArtikelNames(Artikel[] artikels) {
		String[] artikelNames = new String[artikels.length];
		for (int i = 0; i < artikels.length; i++) {
			artikelNames[i] = artikels[i].getNameArtikel();
		}
		return artikelNames;
	}


	private Artikel[] arrayListToArray(List<Artikel> artikelList) {

		Artikel[] artikelArray = new Artikel[artikelList.size()];
		for (int i = 0; i < artikelList.size(); i++) {
			artikelArray[i] = artikelList.get(i);
		}
		return artikelArray;
}
	private ArrayList<String> arrayToArrayList1(String[] artikeln) {
		ArrayList<String> liste = new ArrayList<String>();
		for (int i = 0; i < artikeln.length; i++) {
			liste.add(artikeln[i]);
		}
		return liste;
	}
	
	protected void comboBoxActionPerformed(ActionEvent e) {
		String[] values = loadArtikelNames(artikelList);
		Utils.updateList(list, true, scrollPane, arrayToArrayList(values));
	}

	private String[] arrayListToArrayString(List<String> list) {
		String[] array = new String[daoKategorie.loadKategorien(comboBoxAbteilung.getSelectedItem().toString()).size()];
		for (int i = 0; i < array.length; i++) {
			array[i] = list.get(i);
		}
		return array;
	}

	private ArrayList<String> arrayToArrayList(String[] array) {
		ArrayList<String> listNames = new ArrayList<>();
		for (int i = 0; i < array.length; i++) {
			listNames.add(array[i]);
		}
		return listNames;
	}

	/**
	 * Created by Omar on 14.02.2020
	 */
	protected void onAbteilungSelected(ActionEvent e) {
		loadArticles(true);
	}

	/**
	 * Created by Omar 14.02.2020 if there is no Category for the Abteilung, all the
	 * items will be listed otherwise it will update the categories list to show in
	 * the comboBox the articles will be loaded in both cases
	 */
	private List<Artikel> loadArticles(boolean refreshComboBox) {
		String[] values;
		ArrayList<String> valuesList;
		List<Artikel> artikelnList;

		if (refreshComboBox) {
			comboBoxKategorie.setModel(
					new DefaultComboBoxModel<>(loadCategories(comboBoxAbteilung.getSelectedItem().toString())));
		}
		if (loadCategories(comboBoxAbteilung.getSelectedItem().toString()).length == 0) {
			values = loadArtikelNames(arrayListToArrayArtikel(
					daoArtikel.loadAbteilungArtikeln(comboBoxAbteilung.getSelectedItem().toString())));
			valuesList = arrayToArrayList1(values);
			artikelnList = daoArtikel.loadAbteilungArtikeln(comboBoxAbteilung.getSelectedItem().toString());
			Utils.updateList(list, true, scrollPane, valuesList);
		} else {
			values = loadArtikelNames(arrayListToArrayArtikel(
					daoArtikel.loadKategorienArtikeln(comboBoxKategorie.getSelectedItem().toString())));
			valuesList = arrayToArrayList1(values);
			artikelnList = daoArtikel.loadKategorienArtikeln(comboBoxKategorie.getSelectedItem().toString());
			Utils.updateList(list, true, scrollPane, valuesList);
		}
		return artikelnList;
	}

	/**
	 * created by Omar on 14.02.2020.
	 * 
	 * @param abteilung the current abteilung
	 * @return all the categories for this abteilung
	 */
	private String[] loadCategories(String abteilung) {
		String[] categories = arrayListToArrayString(daoKategorie.loadKategorien(abteilung));
		return categories;
	}

	protected void onCategorySelected(ActionEvent e) {
		loadArticles(false);
	}

	protected void onSearchClicked(ActionEvent e) {
		artikelList = arrayListToArrayArtikel(loadArticles(false));
		Utils.searchWord(arrayToArrayList1(loadArtikelNames(artikelList)), textFieldSuchen, list, this);
	}

	protected void onCheckClicked(ActionEvent e) {
		this.setVisible(false);
>>>>>>> 1508884fb3e2640e8fbc945e451d309502b4fbe7
=======
	protected void do_comboBox_actionPerformed(ActionEvent arg0) {
		onItemSelected();
		
	}
	private ArrayList<String> arrayToArrayList(Object[] array) {
		ArrayList<String> arrayList = new ArrayList<String>();
		for (int i = 0; i < value.length; i++) {
			arrayList.add(value[i].getNameArtikel());
		}
		return arrayList;
	}
	/**
	 * @author Aref
	 */
	private void onItemSelected() {
		String abteilungName = String.valueOf(comboBox.getSelectedItem());
		artikel.setNameArtikel(daoArtikel.nameKategorie(comboBox.getSelectedItem().toString()));
		lblNewLabel.setText(daoArtikel.nameKategorie(comboBox.getSelectedItem().toString()));
		
		value =arrayListToArray(daoArtikel.artikelLaden(abteilungName)) ;
		Utils.updateList(list, true, scrollPane, arrayToArrayList(value));
>>>>>>> aref-v1
	}
}
