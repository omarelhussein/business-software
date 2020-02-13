package artikel.views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
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
import javax.swing.border.LineBorder;

import abteilungen.DaoAbteilung;
import general.code.GeschaeftDB;
import general.code.Utils;
import general.design.Colors;
import general.design.Fonts;
import general.design.Unicodes;

@SuppressWarnings("serial")
public class JFrameArtikelHinzufuegen extends JFrame {
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JComboBox<String> comboBoxAbteilung;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblNewLabel_3;
	private JButton btnCheck;
	private JComboBox<String> comboBoxKategorie;
	private JButton btnSpeichern;
	private JSeparator separator_1;
	private JTextField textField_3;
	private JLabel labelGewicht;
	private JLabel labelNewLabel;
	private JLabel labelAbteilung;
	private JLabel labelMarke;
	private JTextField textField_4;
	private JLabel labelDatum;
	private JTextField textField_5;
	private JButton btnAbteilungHinzufuegen;
	private JButton btnKategorieHinzufuegen;
	private JList<Object> list;
	private JScrollPane scrollPane;
	private JLabel labelNeuGespeicherteArtikeln;
	private JButton btnNeuLaden;
	private DaoAbteilung daoAbteilung;

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
				comboBoxAbteilung = new JComboBox<>();
				comboBoxAbteilung.setModel(new DefaultComboBoxModel<>(daoAbteilung.Abteilungen(GeschaeftDB.getInstance().getCurrentAccountName())));
				comboBoxAbteilung.setBounds(81, 330, 140, 25);
				comboBoxAbteilung.setBackground(Colors.parseColor(Colors.LIGHT_PINK));
				panel.add(comboBoxAbteilung);
			}
			{
				textField = new JTextField();
				textField.setBounds(81, 25, 140, 25);
				panel.add(textField);
				textField.setColumns(10);
			}
			{
				textField_1 = new JTextField();
				textField_1.setBounds(81, 72, 140, 25);
				panel.add(textField_1);
				textField_1.setColumns(10);
			}
			{
				textField_2 = new JTextField();
				textField_2.setBounds(81, 127, 140, 25);
				panel.add(textField_2);
				textField_2.setColumns(10);
			}
			{
				comboBoxKategorie = new JComboBox<>();
				comboBoxKategorie.setModel(new DefaultComboBoxModel<>());
				comboBoxKategorie.setBackground(Colors.parseColor(Colors.LIGHT_PINK));
				comboBoxKategorie.setBounds(81, 389, 140, 25);
				panel.add(comboBoxKategorie);
			}
			{
				btnSpeichern = new JButton("Speichern");
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
				textField_3 = new JTextField();
				textField_3.setColumns(10);
				textField_3.setBounds(81, 180, 140, 25);
				panel.add(textField_3);
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
				textField_4 = new JTextField();
				textField_4.setColumns(10);
				textField_4.setBounds(81, 229, 140, 25);
				panel.add(textField_4);
			}
			{
				labelDatum = new JLabel("Datum");
				labelDatum.setFont(new Font("Trebuchet MS", Font.ITALIC, 15));
				labelDatum.setBounds(10, 276, 61, 25);
				panel.add(labelDatum);
			}
			{
				textField_5 = new JTextField();
				textField_5.setColumns(10);
				textField_5.setBounds(81, 276, 140, 25);
				panel.add(textField_5);
			}
			{
				btnAbteilungHinzufuegen = new JButton("+");
				btnAbteilungHinzufuegen.setToolTipText("Abteilung hinzuf\u00FCgen");
				Utils.setStandardButtonOptions(btnAbteilungHinzufuegen);
				btnAbteilungHinzufuegen.setBounds(30, 330, 41, 25);
				panel.add(btnAbteilungHinzufuegen);
			}
			{
				btnKategorieHinzufuegen = new JButton("+");
				btnKategorieHinzufuegen.setToolTipText("Kategorie hinzuf\u00FCgen");
				Utils.setStandardButtonOptions(btnKategorieHinzufuegen);
				btnKategorieHinzufuegen.setBounds(30, 390, 41, 25);
				panel.add(btnKategorieHinzufuegen);
			}
			{
				scrollPane = new JScrollPane();
				scrollPane.setBounds(256, 56, 317, 425);
				panel.add(scrollPane);
				{
					list = new JList();
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
					btnNewButtonActionPerformed(e);
				}
			});
			btnCheck.setBounds(521, 575, 89, 23);
			getContentPane().add(btnCheck);
		}
	}

	protected void btnNewButtonActionPerformed(ActionEvent e) {
	}
}
