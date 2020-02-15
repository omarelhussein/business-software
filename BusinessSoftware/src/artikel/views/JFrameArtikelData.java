package artikel.views;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import artikel.business_classes.Artikel;
import general.code.Utils;
import general.design.Colors;
import general.design.Fonts;
import general.design.Unicodes;

@SuppressWarnings("serial")
public class JFrameArtikelData extends JFrame {

	private JPanel contentPane;
	private JLabel labelTitle;
	private JLabel labelNewLabel;
	private JTextField textFieldName;
	private JLabel labelPreis;
	private JTextField textFieldPreis;
	private JLabel labelGewicht;
	private JTextField textFieldGewicht;
	private JLabel labelMarke;
	private JTextField textFieldMarke;
	private JLabel labelAnzahl;
	private JTextField textFieldAnzahl;
	private JLabel labelDatum;
	private JTextField textFieldDatum;
	private JButton btnCheck;
	
	private Artikel currentArtikel;

	/**
	 * Create the frame.
	 */
	public JFrameArtikelData(Artikel artikel) {
		currentArtikel = artikel;
		initGUI();
		fillData();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Utils.setSmallFrameOptions(this);
		contentPane = new JPanel();
		contentPane.setBackground(Colors.parseColor(Colors.LIGHT_GREY));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			labelTitle = new JLabel("Produkt Daten");
			labelTitle.setHorizontalAlignment(SwingConstants.CENTER);
			labelTitle.setForeground(Colors.parseColor(Colors.SEXY_BLUE));
			Fonts.setCenturySchoolbookFont(labelTitle, 18);
			labelTitle.setBounds(10, 11, 364, 33);
			contentPane.add(labelTitle);
		}
		{
			labelNewLabel = new JLabel("Name");
			labelNewLabel.setBounds(21, 72, 106, 14);
			contentPane.add(labelNewLabel);
		}
		{
			textFieldName = new JTextField();
			textFieldName.setForeground(Color.DARK_GRAY);
			textFieldName.setBackground(Color.WHITE);
			textFieldName.setEditable(false);
			textFieldName.setBounds(31, 97, 106, 20);
			contentPane.add(textFieldName);
			textFieldName.setColumns(10);
		}
		{
			labelPreis = new JLabel("Preis");
			labelPreis.setBounds(21, 153, 106, 14);
			contentPane.add(labelPreis);
		}
		{
			textFieldPreis = new JTextField();
			textFieldPreis.setForeground(Color.DARK_GRAY);
			textFieldPreis.setEditable(false);
			textFieldPreis.setColumns(10);
			textFieldPreis.setBackground(Color.WHITE);
			textFieldPreis.setBounds(31, 178, 106, 20);
			contentPane.add(textFieldPreis);
		}
		{
			labelGewicht = new JLabel("Gewicht");
			labelGewicht.setBounds(21, 235, 106, 14);
			contentPane.add(labelGewicht);
		}
		{
			textFieldGewicht = new JTextField();
			textFieldGewicht.setForeground(Color.DARK_GRAY);
			textFieldGewicht.setEditable(false);
			textFieldGewicht.setColumns(10);
			textFieldGewicht.setBackground(Color.WHITE);
			textFieldGewicht.setBounds(31, 260, 106, 20);
			contentPane.add(textFieldGewicht);
		}
		{
			labelMarke = new JLabel("Marke");
			labelMarke.setBounds(210, 72, 106, 14);
			contentPane.add(labelMarke);
		}
		{
			textFieldMarke = new JTextField();
			textFieldMarke.setForeground(Color.DARK_GRAY);
			textFieldMarke.setEditable(false);
			textFieldMarke.setColumns(10);
			textFieldMarke.setBackground(Color.WHITE);
			textFieldMarke.setBounds(220, 97, 106, 20);
			contentPane.add(textFieldMarke);
		}
		{
			labelAnzahl = new JLabel("Anzahl");
			labelAnzahl.setBounds(210, 153, 106, 14);
			contentPane.add(labelAnzahl);
		}
		{
			textFieldAnzahl = new JTextField();
			textFieldAnzahl.setForeground(Color.DARK_GRAY);
			textFieldAnzahl.setEditable(false);
			textFieldAnzahl.setColumns(10);
			textFieldAnzahl.setBackground(Color.WHITE);
			textFieldAnzahl.setBounds(220, 178, 106, 20);
			contentPane.add(textFieldAnzahl);
		}
		{
			labelDatum = new JLabel("Datum");
			labelDatum.setBounds(210, 235, 106, 14);
			contentPane.add(labelDatum);
		}
		{
			textFieldDatum = new JTextField();
			textFieldDatum.setForeground(Color.DARK_GRAY);
			textFieldDatum.setEditable(false);
			textFieldDatum.setColumns(10);
			textFieldDatum.setBackground(Color.WHITE);
			textFieldDatum.setBounds(220, 260, 106, 20);
			contentPane.add(textFieldDatum);
		}
		{
			btnCheck = new JButton(Unicodes.CHECK);
			Utils.setStandardButtonOptions(btnCheck);
			btnCheck.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					onCheckClicked(e);
				}
			});
			btnCheck.setBounds(285, 327, 89, 23);
			contentPane.add(btnCheck);
		}
	}
	
	private void fillData() {
		textFieldName.setText(currentArtikel.getNameArtikel());
		textFieldPreis.setText(currentArtikel.getPreis());
	}

	protected void onCheckClicked(ActionEvent e) {
		this.setVisible(false);
	}
}
