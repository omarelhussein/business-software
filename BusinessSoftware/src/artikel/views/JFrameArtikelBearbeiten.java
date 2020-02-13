package artikel.views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import abteilungen.DaoAbteilung;
import artikel.DaoArtikel;
import artikel.business_classes.Artikel;
import general.code.GeschaeftDB;
import general.code.Utils;
import general.design.Colors;
import general.design.Unicodes;
import registrierung.JFrameRegistrieren;
import start.views.JFrameStart;

@SuppressWarnings("serial")
public class JFrameArtikelBearbeiten extends JFrame {

	private JPanel contentPane;
	private JLabel labelArtikelBearbeiten;
	private JTextField nameArtikel;
	private JTextField preisArtikel;
	private JButton buttonSpeichern;
	DaoAbteilung abteilung;
	Artikel artikel;
	DaoArtikel daoArtikel;
	JFrameRegistrieren frameRegistrieren;
	private JLabel lblArtikelBearbeiten;
	private JPanel panel;
	private JButton weiter;
	private JButton zurück;
	private JList list;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JComboBox comboBoxKategorie;
	private JComboBox comboBoxAbteilung;
	private JLabel name;
	private JLabel preis;
	private JLabel anzahl;
	private JSeparator separator;
	private JScrollPane scrollPane;
	private JButton aktuallisieren;
	private JButton loeschen;
	private JSeparator separator_1;

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

	public JFrameArtikelBearbeiten() throws ClassNotFoundException {
		abteilung = new DaoAbteilung();
		artikel = new Artikel();
		daoArtikel = new DaoArtikel();
		frameRegistrieren = new JFrameRegistrieren();
		initGUI();

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
				System.out.println(frameRegistrieren.nameGeascheaft);
			}
		}
		contentPane.setLayout(null);
		{
			lblArtikelBearbeiten = new JLabel("Artikel Bearbeiten");
			lblArtikelBearbeiten.setForeground(Colors.parseColor(Colors.SEXY_BLUE));
			lblArtikelBearbeiten.setFont(new Font("Verdana Pro Cond Semibold", Font.ITALIC, 16));
			lblArtikelBearbeiten.setHorizontalAlignment(SwingConstants.CENTER);
			lblArtikelBearbeiten.setBounds(87, 11, 408, 30);
			contentPane.add(lblArtikelBearbeiten);
		}
		{
			panel = new JPanel();
			panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			panel.setBackground(Colors.parseColor(Colors.LIGHT_PINK));
			panel.setBounds(10, 43, 614, 523);
			contentPane.add(panel);
			panel.setLayout(null);
			{
				scrollPane = new JScrollPane();
				scrollPane.setBounds(379, 11, 225, 501);
				panel.add(scrollPane);
				{
					list = new JList();
					scrollPane.setViewportView(list);
				}
			}
			{
				textField = new JTextField();
				textField.setBounds(157, 32, 144, 25);
				panel.add(textField);
				textField.setColumns(10);
			}
			{
				textField_1 = new JTextField();
				textField_1.setBounds(157, 102, 144, 25);
				panel.add(textField_1);
				textField_1.setColumns(10);
			}
			{
				textField_2 = new JTextField();
				textField_2.setBounds(157, 172, 144, 25);
				panel.add(textField_2);
				textField_2.setColumns(10);
			}
			{
				comboBoxKategorie = new JComboBox();
				comboBoxKategorie.setModel(new DefaultComboBoxModel(
						new String[] { "Obst", "Gem\u00FCse", "Getr\u00E4nke", "Handys", "Laptops" }));
				comboBoxKategorie.setBounds(20, 329, 330, 38);
				comboBoxKategorie.setBackground(Colors.parseColor(Colors.LIGHT_PINK));
				panel.add(comboBoxKategorie);
			}
			{
				comboBoxAbteilung = new JComboBox();
				comboBoxAbteilung.setModel(new DefaultComboBoxModel(new String[] { "Lebensmittel", "Elktro" }));
				comboBoxAbteilung.setBounds(20, 373, 330, 38);
				comboBoxAbteilung.setBackground(Colors.parseColor(Colors.LIGHT_PINK));
				panel.add(comboBoxAbteilung);
			}
			{
				name = new JLabel("Name");
				name.setFont(new Font("Trebuchet MS", Font.ITALIC, 15));
				name.setBounds(58, 32, 66, 25);
				panel.add(name);
			}
			{
				preis = new JLabel("Preis");
				preis.setFont(new Font("Trebuchet MS", Font.ITALIC, 15));
				preis.setBounds(58, 102, 66, 25);
				panel.add(preis);
			}
			{
				anzahl = new JLabel("Anzahl");
				anzahl.setFont(new Font("Trebuchet MS", Font.ITALIC, 15));
				anzahl.setBounds(58, 172, 66, 25);
				panel.add(anzahl);
			}
			{
				separator = new JSeparator();
				separator.setBounds(10, 230, 359, 1);
				panel.add(separator);
			}
			{
				aktuallisieren = new JButton("Aktuallisieren");
				aktuallisieren.setBounds(20, 253, 160, 38);
				Utils.setStandardButtonOptions(aktuallisieren);
				panel.add(aktuallisieren);
			}
			{
				loeschen = new JButton("L\u00F6schen");
				Utils.setStandardButtonOptions(loeschen);
				loeschen.setBounds(185, 253, 160, 38);
				panel.add(loeschen);
			}
			{
				separator_1 = new JSeparator();
				separator_1.setBounds(10, 306, 359, 1);
				panel.add(separator_1);
			}
		}
		{
			weiter = new JButton(Unicodes.CHECK);
			Utils.setStandardButtonOptions(weiter);
			weiter.setBounds(535, 577, 89, 23);
			contentPane.add(weiter);
		}
		{
			zurück = new JButton(Unicodes.BACK_ARROW);
			Utils.setStandardButtonOptions(zurück);
			zurück.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					onBackClicked(e);
				}
			});
			zurück.setBounds(10, 577, 89, 23);
			contentPane.add(zurück);
		}
	}

	protected void onBackClicked(ActionEvent e) {
		
	}
	
	protected void onSaveClicked(ActionEvent e) {
		artikel.setNameArtikel(nameArtikel.getText());
		artikel.setPreis(preisArtikel.getText());
		//TODO continue method
	}
}
