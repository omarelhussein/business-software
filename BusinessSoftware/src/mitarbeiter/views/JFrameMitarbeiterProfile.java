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
import main.business_classes.Anschrift;
import main.dao.DaoAnschrift;
import mitarbeiter.business_classes.Mitarbeiter;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 */
public class JFrameMitarbeiterProfile extends JFrame {

	private JPanel contentPane;
	private Mitarbeiter mitarbeiter;
	private JPanel panel;
	private JTextField textFieldName;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JTextField textFieldNachname;
	private JTextField textFieldLohn;
	private JSeparator separator;
	private JButton zurueck;
	private JLabel lblNewLabel;
	private JLabel lblEmail;
	private JTextField textFieldEmail;
	private JLabel lblNewLabelAnschrift;
	private JLabel lblNewLabelOrt;
	private JLabel lblNewLabelPLZ;
	private JTextField textFieldOrt;
	private JTextField textFieldPlz;
	private JTextField textField_2;
	private JLabel lblNewLabel_1;
	private JTextField textFieldStrasse;
	private JLabel lblNewLabel_2;
	private JTextField textFieldHausNr;
	private JLabel lblNewLabelTelefonnummer;
	private JTextField textFieldTelefonnummer;
	private JLabel lblNewLabelMAProfil;

	public JFrameMitarbeiterProfile(Mitarbeiter mitarbeiter) {
		this.mitarbeiter = mitarbeiter;
		initGUI();
	}

	/**
	 * Created by Mohammad 20.01.2020
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
				textFieldName.setBackground(Color.WHITE);
				textFieldName.setEditable(false);
				textFieldName.setText((String) null);
				textFieldName.setColumns(10);
				textFieldName.setBounds(106, 102, 155, 27);
				panel.add(textFieldName);
			}
			{
				label = new JLabel("Name");
				label.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 13));
				label.setBounds(10, 101, 106, 27);
				panel.add(label);
			}
			{
				label_1 = new JLabel("Nachname");
				label_1.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 13));
				label_1.setBounds(10, 170, 70, 27);
				panel.add(label_1);
			}
			{
				label_2 = new JLabel("Lohn");
				label_2.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 13));
				label_2.setBounds(10, 396, 70, 27);
				panel.add(label_2);
			}
			{
				textFieldNachname = new JTextField();
				textFieldNachname.setBackground(Color.WHITE);
				textFieldNachname.setEditable(false);
				textFieldNachname.setColumns(10);
				textFieldNachname.setBounds(106, 171, 155, 27);
				panel.add(textFieldNachname);
			}
			{
				textFieldLohn = new JTextField();
				textFieldLohn.setBackground(Color.WHITE);
				textFieldLohn.setEditable(false);
				textFieldLohn.setColumns(10);
				textFieldLohn.setBounds(106, 397, 155, 27);
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
				lblEmail = new JLabel("E-Mail");
				lblEmail.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 13));
				lblEmail.setBounds(10, 244, 70, 27);
				panel.add(lblEmail);
			}
			
			{
				
				textFieldEmail = new JTextField();
				textFieldEmail.setBackground(Color.WHITE);
				textFieldEmail.setEditable(false);
				textFieldEmail.setColumns(10);
				textFieldEmail.setBounds(106, 245, 155, 27);
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
				lblNewLabelGeburtsatg.setBounds(10, 315, 98, 26);
				panel.add(lblNewLabelGeburtsatg);
			}
			{
				textFieldOrt = new JTextField();
				textFieldOrt.setBackground(Color.WHITE);
				textFieldOrt.setEditable(false);
				textFieldOrt.setBounds(380, 245, 163, 27);
				panel.add(textFieldOrt);
				textFieldOrt.setColumns(10);
			}
			{
				textFieldPlz = new JTextField();
				textFieldPlz.setBackground(Color.WHITE);
				textFieldPlz.setEditable(false);
				textFieldPlz.setBounds(380, 316, 82, 27);
				panel.add(textFieldPlz);
				textFieldPlz.setColumns(10);
			}
			{
				textField_2 = new JTextField();
				textField_2.setBackground(Color.WHITE);
				textField_2.setEditable(false);
				textField_2.setBounds(106, 316, 155, 27);
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
				textFieldStrasse.setBackground(Color.WHITE);
				textFieldStrasse.setEditable(false);
				textFieldStrasse.setBounds(380, 102, 165, 27);
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
				textFieldHausNr.setBackground(Color.WHITE);
				textFieldHausNr.setEditable(false);
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
				textFieldTelefonnummer.setBackground(Color.WHITE);
				textFieldTelefonnummer.setEditable(false);
				textFieldTelefonnummer.setBounds(380, 397, 163, 27);
				panel.add(textFieldTelefonnummer);
				textFieldTelefonnummer.setColumns(10);
			}
		}
		{
			zurueck = new JButton(Unicodes.BACK_ARROW);
			zurueck.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					onBackPressed(arg0);
				}
			});
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
		fillProfile();
	}
	
	/**
	 * Created by Omar 09.02.2020
	 */
	private void fillProfile() {
		textFieldName.setText(mitarbeiter.getNamemitarbeiter());
		textFieldNachname.setText(mitarbeiter.getNachname());
		textFieldLohn.setText(mitarbeiter.getLohn());
		
		DaoAnschrift dao = new DaoAnschrift();
		Anschrift anschrift = dao.getMitarbeiterAnschrift(mitarbeiter.getId());
		if(anschrift != null) {
			mitarbeiter.setAnschrift(anschrift);
			
			textFieldStrasse.setText(mitarbeiter.getAnschrift().getAdressse());
			textFieldTelefonnummer.setText(mitarbeiter.getAnschrift().getTel());
			textFieldPlz.setText(mitarbeiter.getAnschrift().getPlz());
			textFieldOrt.setText(mitarbeiter.getAnschrift().getOrt());
			textFieldHausNr.setText(getHomeNumber(mitarbeiter.getAnschrift().getAdressse()));
			//TODO fill email and birthdate
		} else {
			JOptionPane.showMessageDialog(this, "Einige Daten konnten nicht geladen werden");
		}
	}
	
	/**
	 * Checks if there are numbers in the address and adds them
	 * In case it found at least a number it checks for 3 Alphabets after the numbers
	 * Like ExampleStreet 34A
	 * @param completeStreet the street name with the number
	 * @return the number as a string (incase including alphabets)
	 */
	private String getHomeNumber(String completeStreet) {
		char[] numbers = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
		char[] chars = {'A', 'a', 'B', 'b', 'C', 'c'};
		String streetNumber = "";
		for (char c : completeStreet.toCharArray()) {
			for (int i = 0; i < numbers.length; i++) {
				if(c == numbers[i]) {
					streetNumber += c;
				}
			}
			if(streetNumber.length() > 0) {
				for (char d : chars) {
					if(c == d) {
						streetNumber += d;
					}
				}
			}
		}
		return streetNumber;
	}
	
	protected void onBackPressed(ActionEvent arg0) {
		this.setVisible(false);
	}
}
