package artikel.views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
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
import javax.swing.border.LineBorder;

import abteilungen.DaoAbteilung;
import abteilungen.business_classes.Abteilung;
import abteilungen.views.JFrameAbteilunghinzufuegen;
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
import kategorie.views.JFrameKategorieHinzufuegen;

@SuppressWarnings("serial")
public class JFrameArtikelHinzufuegen extends JFrame {
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JComboBox<Abteilung> comboBoxAbteilung;
	private JTextField textFieldName;
	private JTextField textFieldPreis;
	private JTextField textFieldAnzahl;
	private JLabel lblNewLabel_3;
	private JButton btnCheck;
	private JComboBox<Kategorie> comboBoxKategorie;
	private JButton btnSpeichern;
	private JSeparator separator_1;
	private JTextField textFieldGewicht;
	private JLabel labelGewicht;
	private JLabel labelNewLabel;
	private JLabel labelAbteilung;
	private JLabel labelMarke;
	private JTextField textFieldMarke;
	private JLabel labelDatum;
	private JTextField textFieldDate;
	private JButton btnAbteilungHinzufuegen;
	private JButton btnKategorieHinzufuegen;
	private JList<Object> list;
	private JScrollPane scrollPane;
	private JLabel labelNeuGespeicherteArtikeln;
	private JButton btnNeuLaden;
	private ArrayList<String> values;

	// DB Variables
	private DaoAbteilung daoAbteilung;
	private DaoKategorie daoKategorie;
	private DaoArtikel daoArtikel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameArtikelHinzufuegen frame = new JFrameArtikelHinzufuegen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Created by Mohammad on 10.02.2020
	 */
	public JFrameArtikelHinzufuegen() {
		daoAbteilung = new DaoAbteilung();
		daoKategorie = new DaoKategorie();
		daoArtikel = new DaoArtikel();
		values = new ArrayList<>();
		initGUI();
	}

	private void initGUI() {
		getContentPane().setLayout(null);

		Utils.setMiddleFrameOptions(this);
		getContentPane().setBackground(Colors.parseColor(Colors.LIGHT_GREY));

		{
			panel = new JPanel();
			panel.setBorder(new LineBorder(new Color(0, 0, 0)));
			panel.setBackground(Colors.parseColor(Colors.LIGHT_PINK));
			panel.setBounds(22, 43, 583, 521);
			getContentPane().add(panel);
			panel.setLayout(null);
			{
				lblNewLabel = new JLabel("Name");
				lblNewLabel.setFont(new Font("Trebuchet MS", Font.ITALIC, 15));
				lblNewLabel.setBounds(10, 25, 61, 25);
				panel.add(lblNewLabel);
			}
			{
				lblNewLabel_1 = new JLabel("Preis");
				lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.ITALIC, 15));
				lblNewLabel_1.setBounds(10, 72, 61, 25);
				panel.add(lblNewLabel_1);
			}
			{
				lblNewLabel_2 = new JLabel("Anzahl");
				lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.ITALIC, 15));
				lblNewLabel_2.setBounds(10, 127, 61, 25);
				panel.add(lblNewLabel_2);
			}
			{
				comboBoxAbteilung = new JComboBox<>(loadAbteilungen());
				comboBoxAbteilung.setRenderer(new JComboBoxAdapter(new Abteilung()));
				comboBoxAbteilung.setBounds(81, 330, 140, 25);
				comboBoxAbteilung.setBackground(Colors.parseColor(Colors.LIGHT_PINK));
				comboBoxAbteilung.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						onAbteilungSelected(e);
					}
				});
				panel.add(comboBoxAbteilung);
			}
			{
				textFieldName = new JTextField();
				textFieldName.setBounds(81, 25, 140, 25);
				panel.add(textFieldName);
				textFieldName.setColumns(10);
			}
			{
				textFieldPreis = new JTextField();
				textFieldPreis.setBounds(81, 72, 140, 25);
				panel.add(textFieldPreis);
				textFieldPreis.setColumns(10);
			}
			{
				textFieldAnzahl = new JTextField();
				textFieldAnzahl.setBounds(81, 127, 140, 25);
				panel.add(textFieldAnzahl);
				textFieldAnzahl.setColumns(10);
			}
			{
				comboBoxKategorie = new JComboBox<>(loadCategories());
				comboBoxKategorie.setRenderer(new JComboBoxAdapter(new Kategorie()));
				comboBoxKategorie.setBackground(Colors.parseColor(Colors.LIGHT_PINK));
				comboBoxKategorie.setBounds(81, 389, 140, 25);
				panel.add(comboBoxKategorie);
			}
			{
				btnSpeichern = new JButton("Speichern");
				btnSpeichern.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						onSaveClicked(e);
					}
				});
				Utils.setStandardButtonOptions(btnSpeichern);
				btnSpeichern.setBounds(10, 487, 210, 23);
				panel.add(btnSpeichern);
			}
			{
				separator_1 = new JSeparator();
				separator_1.setOrientation(SwingConstants.VERTICAL);
				separator_1.setBounds(244, 11, 2, 499);
				panel.add(separator_1);
			}
			{
				textFieldGewicht = new JTextField();
				textFieldGewicht.setColumns(10);
				textFieldGewicht.setBounds(81, 180, 140, 25);
				panel.add(textFieldGewicht);
			}
			{
				labelGewicht = new JLabel("Gewicht");
				labelGewicht.setFont(new Font("Trebuchet MS", Font.ITALIC, 15));
				labelGewicht.setBounds(10, 180, 61, 25);
				panel.add(labelGewicht);
			}
			{
				labelNewLabel = new JLabel("Kategorie");
				labelNewLabel.setForeground(Colors.parseColor(Colors.SEXY_BLUE));
				labelNewLabel.setBounds(90, 370, 130, 14);
				panel.add(labelNewLabel);
			}
			{
				labelAbteilung = new JLabel("Abteilung");
				labelAbteilung.setForeground(SystemColor.textHighlight);
				labelAbteilung.setBounds(90, 312, 130, 14);
				panel.add(labelAbteilung);
			}
			{
				labelMarke = new JLabel("Marke");
				labelMarke.setFont(new Font("Trebuchet MS", Font.ITALIC, 15));
				labelMarke.setBounds(10, 229, 61, 25);
				panel.add(labelMarke);
			}
			{
				textFieldMarke = new JTextField();
				textFieldMarke.setColumns(10);
				textFieldMarke.setBounds(81, 229, 140, 25);
				panel.add(textFieldMarke);
			}
			{
				labelDatum = new JLabel("Datum");
				labelDatum.setFont(new Font("Trebuchet MS", Font.ITALIC, 15));
				labelDatum.setBounds(10, 276, 61, 25);
				panel.add(labelDatum);
			}
			{
				textFieldDate = new JTextField();
				textFieldDate.setColumns(10);
				textFieldDate.setBounds(81, 276, 140, 25);
				panel.add(textFieldDate);
			}
			{
				btnAbteilungHinzufuegen = new JButton("+");
				btnAbteilungHinzufuegen.setToolTipText("Abteilung hinzuf\u00FCgen");
				Utils.setStandardButtonOptions(btnAbteilungHinzufuegen);
				btnAbteilungHinzufuegen.setBounds(30, 330, 41, 25);
				btnAbteilungHinzufuegen.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						onAddAbteilungClicked(e);
					}
				});
				panel.add(btnAbteilungHinzufuegen);
			}
			{
				btnKategorieHinzufuegen = new JButton("+");
				btnKategorieHinzufuegen.setToolTipText("Kategorie hinzuf\u00FCgen");
				Utils.setStandardButtonOptions(btnKategorieHinzufuegen);
				btnKategorieHinzufuegen.setBounds(30, 390, 41, 25);
				btnKategorieHinzufuegen.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						onAddCategoryClicked(e);
					}
				});
				panel.add(btnKategorieHinzufuegen);
			}
			{
				scrollPane = new JScrollPane();
				scrollPane.setBounds(256, 56, 317, 425);
				panel.add(scrollPane);
				{
					list = new JList<>();
					scrollPane.setViewportView(list);
				}
			}
			{
				labelNeuGespeicherteArtikeln = new JLabel("Neu gespeicherte Artikeln");
				labelNeuGespeicherteArtikeln.setHorizontalAlignment(SwingConstants.CENTER);
				labelNeuGespeicherteArtikeln.setForeground(SystemColor.textHighlight);
				labelNeuGespeicherteArtikeln.setBounds(256, 25, 317, 25);
				panel.add(labelNeuGespeicherteArtikeln);
			}
			{
				btnNeuLaden = new JButton("Neu laden");
				btnNeuLaden.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						onRefreshClicked(e);
					}
				});
				btnNeuLaden.setBounds(10, 458, 211, 23);
				panel.add(btnNeuLaden);
				btnNeuLaden.setToolTipText("Daten von der Datenbank neu Laden");
				Utils.setStandardButtonOptions(btnNeuLaden);
			}
		}
		{
			lblNewLabel_3 = new JLabel("Artkel Hinzuf\u00FCgen");
			Fonts.setCenturySchoolbookFont(lblNewLabel_3, 18);
			lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_3.setForeground(Colors.parseColor(Colors.SEXY_BLUE));
			lblNewLabel_3.setBounds(100, 11, 423, 25);
			getContentPane().add(lblNewLabel_3);
		}
		{
			btnCheck = new JButton(Unicodes.CHECK);
			Utils.setStandardButtonOptions(btnCheck);
			btnCheck.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					onCheckClicked(e);
				}
			});
			btnCheck.setBounds(521, 575, 89, 23);
			getContentPane().add(btnCheck);
		}
	}

	/**
	 * load all categories that are ordered to the Abteilung
	 * 
	 * @return list of categories
	 */
	private Kategorie[] loadCategories() {
		Abteilung currentAbteilung = daoAbteilung.Abteilungen(GeschaeftDB.getInstance().getCurrentAccountName())[comboBoxAbteilung.getSelectedIndex()];
		List<Kategorie> kategorienList = daoKategorie.loadKategorien(currentAbteilung.getId());
		return Utils.arrayListToArray(Kategorie.class, kategorienList);
	}

	/**
	 * load all Abteilungen for the current Account
	 * 
	 * @return list of Abteilungen
	 */
	private Abteilung[] loadAbteilungen() {
		return daoAbteilung.Abteilungen(GeschaeftDB.getInstance().getCurrentAccountName());
	}

	/**
	 * done from this window
	 * 
	 * @param e
	 */
	protected void onCheckClicked(ActionEvent e) {
		this.setVisible(false);
	}

	/**
	 * Refresh the list to check if new content available is (Abteilung and
	 * Categories List)
	 * 
	 * @param e
	 */
	protected void onRefreshClicked(ActionEvent e) {
		int currentIndex = comboBoxAbteilung.getSelectedIndex();
		refreshAbteilungComboBox();
		refreshKategorieComboBox();
		comboBoxAbteilung.setSelectedIndex(currentIndex);
	}

	/**
	 * Save the inserted Data in the DB
	 * 
	 * @param e
	 */
	protected void onSaveClicked(ActionEvent e) {
		Artikel currentArtikel = new Artikel();
		List<JTextField> fillFields = new ArrayList<>();
		boolean allFilled = false;
		Kategorie currentKat = new Kategorie();

		fillFields.add(textFieldName);
		fillFields.add(textFieldPreis);
		fillFields.add(textFieldDate);
		fillFields.add(textFieldGewicht);
		fillFields.add(textFieldMarke);
		fillFields.add(textFieldAnzahl);
		for (JTextField jTextField : fillFields) {
			if (jTextField.getText().trim().isEmpty()) {
				showErrorPane("Bitte alle Felder vervollständigen");
				allFilled = false;
				return;
			}
			allFilled = true;
		}
		if (allFilled) {
			if (comboBoxKategorie.getItemCount() == 0) {
				showErrorPane("Bitte Mind. Eine Kategorie zu der Abteilung hinzufügen");
			} else {
				try {
					currentArtikel.setNameArtikel(textFieldName.getText());
					currentArtikel.setPreis(textFieldPreis.getText());
					currentArtikel.setDatum(new Date().toString());
					currentArtikel.setAnzahl(Integer.valueOf(textFieldAnzahl.getText()));
					currentArtikel.setGewicht(Double.valueOf(textFieldGewicht.getText()));
					currentArtikel.setMarke(textFieldMarke.getText());
				} catch (NumberFormatException error) {
					showErrorPane("Bitte Felder mit richtige Daten ausfüllen");
					return;
				}
				values.add(currentArtikel.getNameArtikel());
				Utils.updateList(list, true, scrollPane, values);

				Abteilung currentAbteilung = loadAbteilungen()[comboBoxAbteilung.getSelectedIndex()];
				currentKat.setNamekategorie(comboBoxKategorie.getSelectedItem().toString());
				currentKat.setId(loadCategories()[comboBoxKategorie.getSelectedIndex()].getId());
				daoArtikel.insertArtkel(currentArtikel, currentKat, currentAbteilung.getId());
				for (JTextField jTextField : fillFields) {
					jTextField.setText("");
				}
				fillFields.get(0).requestFocus();
			}
		} else {
			showErrorPane("Bitte alle Felder vollständig ausfüllen");
		}
	}

	/**
	 * Load categories when an item in Abteilungen is selected
	 * 
	 * @param e
	 */
	protected void onAbteilungSelected(ActionEvent e) {
		refreshKategorieComboBox();
	}
	
	private void refreshAbteilungComboBox() {
		comboBoxAbteilung.setModel(new DefaultComboBoxModel<Abteilung>(loadAbteilungen()));
	}
	
	private void refreshKategorieComboBox() {
		comboBoxKategorie.setModel(new DefaultComboBoxModel<Kategorie>(loadCategories()));
	}

	/**
	 * Open Add Abteilung Page
	 * 
	 * @param e
	 */
	protected void onAddAbteilungClicked(ActionEvent e) {
		JFrameAbteilunghinzufuegen addAbteilung = new JFrameAbteilunghinzufuegen();
		addAbteilung.setVisible(true);
		addAbteilung.setAlwaysOnTop(true);
	}

	/**
	 * Open Add Categories Page
	 * 
	 * @param e
	 */
	protected void onAddCategoryClicked(ActionEvent e) {
		Abteilung selectedAbteilung = loadAbteilungen()[comboBoxAbteilung.getSelectedIndex()];
		JFrameKategorieHinzufuegen addCategory = new JFrameKategorieHinzufuegen(selectedAbteilung);
		addCategory.setVisible(true);
		addCategory.setAlwaysOnTop(true);
	}

	/**
	 * show an output message to the user
	 * 
	 * @param msg the output
	 */
	private void showErrorPane(String msg) {
		JOptionPane.showMessageDialog(this, msg);
	}

}
