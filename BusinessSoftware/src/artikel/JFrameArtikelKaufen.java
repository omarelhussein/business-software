package artikel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import general.Utils;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class JFrameArtikelKaufen extends JFrame {

	private JPanel contentPane;
	private JLabel labelAnzahl;
	private JLabel labelBezeichnung;
	private JLabel labelGewicht;
	private JLabel labelPreis;
	private JLabel labelArt;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JButton buttonSpeichern;
	private JButton buttonFertig;
	private JButton buttonWeiter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameArtikelKaufen frame = new JFrameArtikelKaufen();
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
	public JFrameArtikelKaufen() {
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Utils.setMainFrameOptions(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			labelAnzahl = new JLabel("Anzahl ");
			labelAnzahl.setFont(new Font("Century Schoolbook", Font.PLAIN, 20));
			labelAnzahl.setBounds(47, 48, 98, 37);
			contentPane.add(labelAnzahl);
		}
		{
			labelBezeichnung = new JLabel("Bezeichnung");
			labelBezeichnung.setFont(new Font("Century Schoolbook", Font.PLAIN, 20));
			labelBezeichnung.setBounds(47, 87, 146, 51);
			contentPane.add(labelBezeichnung);
		}
		{
			labelGewicht = new JLabel("Gewicht");
			labelGewicht.setFont(new Font("Century Schoolbook", Font.PLAIN, 20));
			labelGewicht.setBounds(47, 151, 114, 40);
			contentPane.add(labelGewicht);
		}
		{
			labelPreis = new JLabel("Preis");
			labelPreis.setFont(new Font("Century Schoolbook", Font.PLAIN, 20));
			labelPreis.setBounds(57, 204, 56, 16);
			contentPane.add(labelPreis);
		}
		{
			labelArt = new JLabel("Art");
			labelArt.setFont(new Font("Century Schoolbook", Font.PLAIN, 20));
			labelArt.setBounds(57, 233, 56, 16);
			contentPane.add(labelArt);
		}
		{
			textField = new JTextField();
			textField.setBounds(234, 58, 116, 22);
			contentPane.add(textField);
			textField.setColumns(10);
		}
		{
			textField_1 = new JTextField();
			textField_1.setBounds(234, 104, 116, 22);
			contentPane.add(textField_1);
			textField_1.setColumns(10);
		}
		{
			textField_2 = new JTextField();
			textField_2.setBounds(234, 163, 116, 22);
			contentPane.add(textField_2);
			textField_2.setColumns(10);
		}
		{
			textField_3 = new JTextField();
			textField_3.setBounds(234, 204, 116, 22);
			contentPane.add(textField_3);
			textField_3.setColumns(10);
		}
		{
			textField_4 = new JTextField();
			textField_4.setBounds(234, 251, 116, 22);
			contentPane.add(textField_4);
			textField_4.setColumns(10);
		}
		{
			buttonSpeichern = new JButton("Speichern");
			buttonSpeichern.setFont(new Font("Century Schoolbook", Font.PLAIN, 20));
			buttonSpeichern.setBounds(234, 317, 137, 25);
			contentPane.add(buttonSpeichern);
		}
		{
			buttonFertig = new JButton("Fertig");
			buttonFertig.setFont(new Font("Century Schoolbook", Font.PLAIN, 20));
			buttonFertig.setBounds(669, 317, 97, 25);
			contentPane.add(buttonFertig);
		}
		{
			buttonWeiter = new JButton("Weiter");
			buttonWeiter.setFont(new Font("Century Schoolbook", Font.PLAIN, 20));
			buttonWeiter.setBounds(26, 317, 97, 25);
			contentPane.add(buttonWeiter);
		}
	}

}
