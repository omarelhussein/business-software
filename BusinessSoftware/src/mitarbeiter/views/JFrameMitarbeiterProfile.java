package mitarbeiter.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import general.code.Utils;
import general.design.Colors;
import general.design.Fonts;
import general.design.Unicodes;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

/**
 * Created by Mohammad 20.01.2020
 */
public class JFrameMitarbeiterProfile extends JFrame {

	private JPanel contentPane;
	private String name;
	private JPanel panel;
	private JTextField textFieldName;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JTextField textFieldNachname;
	private JTextField textFieldLohn;
	private JButton button;
	private JSeparator separator;
	private JButton zurueck;
	private JLabel lblNewLabel;
	private JLabel lblPassWied;
	private JLabel lblEmail;
	private JTextField textFieldEmail;
	private JLabel lblNewLabelAnschrift;
	private JLabel lblNewLabelOrt;
	private JLabel lblNewLabelPLZ;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblNewLabel_1;
	private JTextField textFieldStrasse;
	private JLabel lblNewLabel_2;
	private JTextField textFieldHausNr;
	private JLabel lblNewLabelTelefonnummer;
	private JTextField textFieldTelefonnummer;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JLabel lblNewLabelMAProfil;

	public JFrameMitarbeiterProfile(String name) {
		this.name = name;
		initGUI();
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameMitarbeiterProfile frame = new JFrameMitarbeiterProfile();
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
	public JFrameMitarbeiterProfile() {
		initGUI();
	}

	private void initGUI() {

		Utils.setMiddleFrameOptions(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Colors.parseColor(Colors.LIGHT_GREY));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			panel = new JPanel();
			panel.setBorder(new LineBorder(new Color(0, 0, 0)));
			panel.setBounds(28, 69, 578, 472);
			panel.setBackground(Colors.parseColor(Colors.LIGHT_PINK));
			contentPane.add(panel);
			panel.setLayout(null);
			{
				textFieldName = new JTextField();
				textFieldName.setText((String) null);
				textFieldName.setColumns(10);
				textFieldName.setBounds(106, 90, 155, 27);
				panel.add(textFieldName);
			}
			{
				label = new JLabel("Name");
				label.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 13));
				label.setBounds(10, 90, 106, 27);
				panel.add(label);
			}
			{
				label_1 = new JLabel("Nachname");
				label_1.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 13));
				label_1.setBounds(10, 140, 70, 27);
				panel.add(label_1);
			}
			{
				label_2 = new JLabel("Lohn");
				label_2.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 13));
				label_2.setBounds(10, 408, 70, 27);
				panel.add(label_2);
			}
			{
				label_3 = new JLabel("Pass");
				label_3.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 13));
				label_3.setBounds(10, 244, 70, 27);
				panel.add(label_3);
			}
			{
				textFieldNachname = new JTextField();
				textFieldNachname.setColumns(10);
				textFieldNachname.setBounds(106, 141, 155, 27);
				panel.add(textFieldNachname);
			}
			{
				textFieldLohn = new JTextField();
				textFieldLohn.setColumns(10);
				textFieldLohn.setBounds(106, 409, 155, 27);
				panel.add(textFieldLohn);
			}
			{
				separator = new JSeparator();
				separator.setOrientation(SwingConstants.VERTICAL);
				separator.setBounds(281, 11, 2, 450);
				panel.add(separator);
			}
			{
				lblNewLabel = new JLabel("Pers\u00F6nliche Daten");
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setBackground(new Color(255, 0, 0));
				Fonts.setCenturySchoolbookFont(lblNewLabel, 16);
				lblNewLabel.setBounds(10, 23, 251, 38);
				lblNewLabel.setForeground(Colors.parseColor(Colors.SEXY_BLUE));
				panel.add(lblNewLabel);
			}
			{
				lblPassWied = new JLabel("Pass Wied.");
				lblPassWied.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 13));
				lblPassWied.setBounds(10, 299, 70, 27);
				panel.add(lblPassWied);
			}
			{
				lblEmail = new JLabel("E-Mail");
				lblEmail.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 13));
				lblEmail.setBounds(10, 194, 70, 27);
				panel.add(lblEmail);
			}
			
			{
				
				textFieldEmail = new JTextField();
				textFieldEmail.setColumns(10);
				textFieldEmail.setBounds(106, 195, 155, 27);
				panel.add(textFieldEmail);
			}
			
			{
				
				lblNewLabelAnschrift = new JLabel("Anschrift");
				lblNewLabelAnschrift.setHorizontalAlignment(SwingConstants.CENTER);
				Fonts.setCenturySchoolbookFont(lblNewLabelAnschrift, 16);
				lblNewLabelAnschrift.setBounds(304, 23, 264, 38);
				lblNewLabelAnschrift.setForeground(Colors.parseColor(Colors.SEXY_BLUE));
				panel.add(lblNewLabelAnschrift);
			}
			
			{
				
				
				lblNewLabelOrt = new JLabel("Ort");
				lblNewLabelOrt.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 13));
				lblNewLabelOrt.setBounds(293, 244, 70, 27);
				panel.add(lblNewLabelOrt);
			}
			{
				lblNewLabelPLZ = new JLabel("Plz");
				lblNewLabelPLZ.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 13));
				lblNewLabelPLZ.setBounds(293, 314, 68, 29);
				panel.add(lblNewLabelPLZ);
			}
			{
				JLabel lblNewLabelGeburtsatg = new JLabel("Geb.");
				lblNewLabelGeburtsatg.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 13));
				lblNewLabelGeburtsatg.setBounds(10, 354, 98, 26);
				panel.add(lblNewLabelGeburtsatg);
			}
			{
				textField = new JTextField();
				textField.setBounds(380, 233, 163, 38);
				panel.add(textField);
				textField.setColumns(10);
			}
			{
				textField_1 = new JTextField();
				textField_1.setBounds(380, 310, 82, 38);
				panel.add(textField_1);
				textField_1.setColumns(10);
			}
			{
				textField_2 = new JTextField();
				textField_2.setBounds(106, 355, 155, 27);
				panel.add(textField_2);
				textField_2.setColumns(10);
			}
			{
				lblNewLabel_1 = new JLabel("Str.");
				lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.ITALIC, 13));
				lblNewLabel_1.setBounds(293, 100, 70, 29);
				panel.add(lblNewLabel_1);
			}
			{
				textFieldStrasse = new JTextField();
				textFieldStrasse.setBounds(380, 96, 165, 38);
				panel.add(textFieldStrasse);
				textFieldStrasse.setColumns(10);
			}
			{
				lblNewLabel_2 = new JLabel("HausNr.");
				lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 13));
				lblNewLabel_2.setBounds(293, 170, 70, 27);
				panel.add(lblNewLabel_2);
			}
			{
				textFieldHausNr = new JTextField();
				textFieldHausNr.setBounds(380, 165, 45, 38);
				panel.add(textFieldHausNr);
				textFieldHausNr.setColumns(10);
			}
			{
				lblNewLabelTelefonnummer = new JLabel("Tel:");
				lblNewLabelTelefonnummer.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 13));
				lblNewLabelTelefonnummer.setBounds(293, 397, 68, 27);
				panel.add(lblNewLabelTelefonnummer);
			}
			{
				textFieldTelefonnummer = new JTextField();
				textFieldTelefonnummer.setBounds(380, 383, 163, 38);
				panel.add(textFieldTelefonnummer);
				textFieldTelefonnummer.setColumns(10);
			}
			{
				passwordField = new JPasswordField();
				passwordField.setBounds(106, 246, 155, 24);
				panel.add(passwordField);
			}
			{
				passwordField_1 = new JPasswordField();
				passwordField_1.setBounds(106, 300, 155, 27);
				panel.add(passwordField_1);
			}
		}
		{
			button = new JButton(Unicodes.CHECK);
			button.setBounds(535, 577, 89, 23);
			Utils.setStandardButtonOptions(button);
			contentPane.add(button);
		}
		{
			zurueck = new JButton(Unicodes.BACK_ARROW);
			zurueck.setBounds(28, 577, 89, 23);
			Utils.setStandardButtonOptions(zurueck);
			contentPane.add(zurueck);
		}
		{
			lblNewLabelMAProfil = new JLabel("Mitarbeiter Profil");
			lblNewLabelMAProfil.setHorizontalAlignment(SwingConstants.CENTER);
			Fonts.setCenturySchoolbookFont(lblNewLabelMAProfil, 24);
			lblNewLabelMAProfil.setBounds(28, 11, 578, 43);
			lblNewLabelMAProfil.setForeground(Colors.parseColor(Colors.SEXY_BLUE));
			contentPane.add(lblNewLabelMAProfil);
		}
	}
}
