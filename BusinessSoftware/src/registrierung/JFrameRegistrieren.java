package registrierung;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import general.Colors;
import general.Fonts;
import general.Unicodes;
import general.Utils;
import main.Anschrift;
import start.Daomelden;
import start.Gescheaft;
import start.JFrameStart;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.SystemColor;
import javax.swing.JPasswordField;
import javax.swing.JLayeredPane;
import javax.swing.JCheckBox;

@SuppressWarnings("serial")
public class JFrameRegistrieren extends JFrame {

	private JPanel contentPane;

	private JTextField namedergeschaeft;
	private JButton btnNewButton;
	private Daomelden daomelden;
	private Anschrift anschrift;
	private Gescheaft gescheaft;
	private JLabel label_register;
	private boolean textnutz = true;
	private JButton buttonNewButton;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPanel panel;
	private JLabel label;
	private JPanel panel_step1;
	private JLabel label_1;
	private JLabel labelBesttigungNameDes;
	private JLabel labelBezeichnung;
	private JLabel labelPasswortWiederholen;
	private JTextField text_field_name;
	private JPasswordField textField_pass;
	private JTextField textField_Bezeichnung;
	private JTextField textField_nameWiederholen;
	private JPanel panel_2;
	private JLabel label_7;
	private JLabel label_steps_counter;
	private JRadioButton radioButton;
	private JRadioButton radioButton_1;
	private JRadioButton radioButton_2;

	ArrayList<JRadioButton> radioButtonsGroup = new ArrayList<JRadioButton>();
	private JLabel labelPasswortWiederholen_1;
	private JPasswordField textField_passWiederholen;
	private JLayeredPane layeredPane;
	private JPanel panel_step2;
	private JTextField textField_1;
	private JLabel label_2;
	private JTextField textField_strasse;
	private JLabel labelOrt;
	private JLabel labelPlz;
	private JTextField textField_ort;
	private JTextField textField_plz;
	private JLabel labelTelefonnummer;
	private JLabel labelEmailadresse;
	private JTextField textField_Tel;
	private JTextField textField_email;
	private JPanel panel_step3;
	private JLabel labelNewLabel;
	private JCheckBox checkBoxNewCheckBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameRegistrieren frame = new JFrameRegistrieren();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws ClassNotFoundException
	 */
	public JFrameRegistrieren() throws ClassNotFoundException {
		initGUI();
		daomelden = new Daomelden();
		gescheaft = new Gescheaft();
		anschrift = new Anschrift();
	}

	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		Utils.setMainFrameOptions(this);
		contentPane.setLayout(null);
		{
			{
				{
					label_register = new JLabel("Registrierung");
					label_register.setForeground(Colors.parseColor(Colors.SEXY_BLUE));
					label_register.setHorizontalAlignment(SwingConstants.CENTER);
					Fonts.setCenturySchoolbookFont(label_register, 24);
					label_register.setBounds(42, 11, 784, 55);
					contentPane.add(label_register);
				}
				btnNewButton = new JButton(Unicodes.CHECK);
				Utils.setStandardButtonOptions(btnNewButton);
				btnNewButton.setBounds(706, 520, 178, 41);
				contentPane.add(btnNewButton);
				{
					buttonNewButton = new JButton(Unicodes.BACK_ARROW);
					buttonNewButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							onBackPressed(arg0);
						}
					});
					buttonNewButton.setBounds(10, 520, 178, 41);
					Utils.setStandardButtonOptions(buttonNewButton);
					contentPane.add(buttonNewButton);
				}
				{
					panel = new JPanel();
					panel.setBorder(new LineBorder(new Color(0, 0, 0)));
					panel.setBounds(10, 77, 874, 421);
					panel.setBackground(Colors.parseColor(Colors.LIGHT_PINK));
					contentPane.add(panel);
					panel.setLayout(null);
					{
						label = new JLabel("Allgemeine Daten des Gesch\u00E4fts (Schritt Titel)");
						label.setVerticalAlignment(SwingConstants.BOTTOM);
						label.setForeground(SystemColor.textHighlight);
						Fonts.setCenturySchoolbookFont(label, 18);
						label.setBounds(28, 21, 486, 41);
						panel.add(label);
					}
					{
						panel_2 = new JPanel();
						panel_2.setLayout(null);
						panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
						panel_2.setBackground(Colors.parseColor(Colors.LIGHT_ORANGE));
						panel_2.setBounds(524, 63, 295, 153);
						panel.add(panel_2);
						{
							label_7 = new JLabel("Beschreibung des Schrittes");
							label_7.setBounds(10, 11, 275, 14);
							panel_2.add(label_7);
						}
						{
							label_steps_counter = new JLabel("Schritt 1 von 3");
							label_steps_counter.setBounds(20, 102, 265, 14);
							panel_2.add(label_steps_counter);
						}
						{
							radioButton = new JRadioButton("");
							buttonGroup.add(radioButton);
							radioButton.setSelected(true);
							radioButton.setRequestFocusEnabled(false);
							radioButton.setForeground(Color.ORANGE);
							radioButton.setEnabled(false);
							radioButton.setBackground(Color.PINK);
							radioButton.setBounds(30, 123, 25, 23);
							panel_2.add(radioButton);
						}
						{
							radioButton_1 = new JRadioButton("");
							buttonGroup.add(radioButton_1);
							radioButton_1.setRequestFocusEnabled(false);
							radioButton_1.setForeground(Color.ORANGE);
							radioButton_1.setEnabled(false);
							radioButton_1.setBackground(Color.PINK);
							radioButton_1.setBounds(53, 123, 25, 23);
							panel_2.add(radioButton_1);
						}
						{
							radioButton_2 = new JRadioButton("");
							buttonGroup.add(radioButton_2);
							radioButton_2.setRequestFocusEnabled(false);
							radioButton_2.setForeground(Color.ORANGE);
							radioButton_2.setEnabled(false);
							radioButton_2.setBackground(Color.PINK);
							radioButton_2.setBounds(76, 123, 21, 23);
							panel_2.add(radioButton_2);
						}
						radioButtonsGroup.add(radioButton);
						radioButtonsGroup.add(radioButton_1);
						radioButtonsGroup.add(radioButton_2);
					}
					{
						layeredPane = new JLayeredPane();
						layeredPane.setBounds(28, 73, 480, 320);
						panel.add(layeredPane);
						{
							{
								panel_step1 = new JPanel();
								panel_step2 = new JPanel();
								panel_step2.setVisible(false);
								panel_step2.setBorder(new LineBorder(new Color(0, 0, 0)));
								panel_step2.setBounds(0, 0, 480, 320);
								panel_step2.setBackground(Colors.parseColor(Colors.LIGHT_ORANGE));
								layeredPane.add(panel_step2);
								panel_step2.setLayout(null);
								{
									label_2 = new JLabel("Strasse/ Hausnummer");
									label_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
									label_2.setBounds(21, 30, 220, 25);
									panel_step2.add(label_2);
								}
								{
									textField_strasse = new JTextField();
									textField_strasse.setBounds(250, 30, 175, 25);
									panel_step2.add(textField_strasse);
								}
								{
									labelOrt = new JLabel("Ort");
									labelOrt.setFont(new Font("Tahoma", Font.PLAIN, 15));
									labelOrt.setBounds(21, 80, 220, 25);
									panel_step2.add(labelOrt);
								}
								{
									labelPlz = new JLabel("PLZ");
									labelPlz.setFont(new Font("Tahoma", Font.PLAIN, 15));
									labelPlz.setBounds(21, 130, 220, 25);
									panel_step2.add(labelPlz);
								}
								{
									textField_ort = new JTextField();
									textField_ort.setBounds(251, 80, 175, 25);
									panel_step2.add(textField_ort);
								}
								{
									textField_plz = new JTextField();
									textField_plz.setBounds(251, 130, 175, 25);
									panel_step2.add(textField_plz);
								}
								{
									labelTelefonnummer = new JLabel("Telefonnummer");
									labelTelefonnummer.setFont(new Font("Tahoma", Font.PLAIN, 15));
									labelTelefonnummer.setBounds(21, 180, 220, 25);
									panel_step2.add(labelTelefonnummer);
								}
								{
									labelEmailadresse = new JLabel("E-Mail-Adresse");
									labelEmailadresse.setFont(new Font("Tahoma", Font.PLAIN, 15));
									labelEmailadresse.setBounds(21, 230, 220, 25);
									panel_step2.add(labelEmailadresse);
								}
								{
									textField_Tel = new JTextField();
									textField_Tel.setBounds(251, 180, 175, 25);
									panel_step2.add(textField_Tel);
								}
								{
									textField_email = new JTextField();
									textField_email.setBounds(251, 230, 175, 25);
									panel_step2.add(textField_email);
								}
								panel_step1.setBounds(0, 0, 480, 320);
								layeredPane.add(panel_step1);
								panel_step1.setLayout(null);
								panel_step1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
								panel_step1.setBackground(new Color(255, 250, 240));
								{
									label_1 = new JLabel("Name des Gesch\u00E4fts");
									label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
									label_1.setBounds(21, 30, 220, 25);
									panel_step1.add(label_1);
								}
								{
									labelBesttigungNameDes = new JLabel("Name des Gesch\u00E4fts wiederholen");
									labelBesttigungNameDes.setFont(new Font("Tahoma", Font.PLAIN, 15));
									labelBesttigungNameDes.setBounds(21, 80, 219, 25);
									panel_step1.add(labelBesttigungNameDes);
								}
								{
									labelBezeichnung = new JLabel("Bezeichnung");
									labelBezeichnung.setFont(new Font("Tahoma", Font.PLAIN, 15));
									labelBezeichnung.setBounds(21, 130, 219, 25);
									panel_step1.add(labelBezeichnung);
								}
								{
									labelPasswortWiederholen = new JLabel("Passwort ");
									labelPasswortWiederholen.setFont(new Font("Tahoma", Font.PLAIN, 15));
									labelPasswortWiederholen.setBounds(21, 180, 219, 20);
									panel_step1.add(labelPasswortWiederholen);
								}
								{
									text_field_name = new JTextField();
									text_field_name.setBounds(250, 30, 175, 25);
									panel_step1.add(text_field_name);
								}
								{
									textField_pass = new JPasswordField();
									textField_pass.setColumns(10);
									textField_pass.setBounds(250, 180, 177, 25);
									panel_step1.add(textField_pass);
								}
								{
									textField_Bezeichnung = new JTextField();
									textField_Bezeichnung.setColumns(10);
									textField_Bezeichnung.setBounds(250, 130, 175, 25);
									panel_step1.add(textField_Bezeichnung);
								}
								{
									textField_nameWiederholen = new JTextField();
									textField_nameWiederholen.setColumns(10);
									textField_nameWiederholen.setBounds(250, 80, 175, 25);
									panel_step1.add(textField_nameWiederholen);
								}
								{
									labelPasswortWiederholen_1 = new JLabel("Passwort wiederholen");
									labelPasswortWiederholen_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
									labelPasswortWiederholen_1.setBounds(21, 230, 219, 25);
									panel_step1.add(labelPasswortWiederholen_1);
								}
								{
									textField_passWiederholen = new JPasswordField();
									textField_passWiederholen.setColumns(10);
									textField_passWiederholen.setBounds(250, 230, 177, 25);
									panel_step1.add(textField_passWiederholen);
								}
								{
									textField_1 = new JTextField();
									textField_1.setBounds(250, 30, 175, 25);
									panel_step1.add(textField_1);
									textField_1.setColumns(10);
								}
								{
									panel_step3 = new JPanel();
									panel_step3.setVisible(false);
									panel_step3.setBorder(new LineBorder(new Color(0, 0, 0)));
									panel_step3.setBounds(0, 0, 480, 320);
									panel_step3.setBackground(Colors.parseColor(Colors.LIGHT_ORANGE));
									layeredPane.add(panel_step3);
									panel_step3.setLayout(null);
									{
										labelNewLabel = new JLabel(
												"<HTML>Die eingegebene Daten k\u00F6nnen aus Sicherheitsgr\u00FCnden Sp\u00E4ter nicht mehr ge\u00E4ndert werden. Wenn Sie damit einverstanden sind, clicken Sie auf den Hacken unten. Ansonsten k\u00F6nnen Sie noch zur\u00FCch gehen und die Daten \u00E4ndern.");
										labelNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
										labelNewLabel.setBounds(10, 11, 460, 91);
										panel_step3.add(labelNewLabel);
									}
									{
										checkBoxNewCheckBox = new JCheckBox("Ich bin damit einverstanden");
										checkBoxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
										checkBoxNewCheckBox.setBounds(10, 290, 460, 23);
										panel_step3.add(checkBoxNewCheckBox);
									}
								}
							}
						}
					}
				}
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						do_btnNewButton_actionPerformed(arg0);
					}
				});
			}
		}
	}

	protected void do_btnNewButton_actionPerformed(ActionEvent arg0) {
		for (int i = 0; i < radioButtonsGroup.size(); i++) {
			if (radioButtonsGroup.get(i).isSelected()) {
				manageRegisterSteps(i, radioButtonsGroup.size());
				break;
			}
		}
//		boolean genutzt;
//		boolean[] textBenutzung = new boolean[6];
//		textBenutzung[0] = textFullen(text_field_name);
//		textBenutzung[1] = textFullen(textField_Bezeichnung);
//		textBenutzung[2] = textFullen(textField_nameWiederholen);
//		textBenutzung[3] = textFullen(textField_pass);
//		textBenutzung[4] = textFullen(textField_Tel);
//		textBenutzung[5] = textFullen(textField_strasse);
//		genutzt = texteprüfen(textBenutzung);
//
//		if (genutzt == false) {
//			JOptionPane.showMessageDialog(null, "Bitte alle Pflicht Felder ausfüllen!");
//		} else if (genutzt == true) {
//			gescheaft.setNamegeascheaft(namedergeschaeft.getText());
//			gescheaft.setBezeichnung(textField_nameWiederholen.getText());
//			gescheaft.setPass(String.valueOf(textField_pass.getPassword()));
//			anschrift.setStadt(String.valueOf(textField_pass.getPassword()));
//			anschrift.setTel(textField_Tel.getText());
//			anschrift.setAdressse(textField_strasse.getText());
//			System.out.println("das ist die" + gescheaft.getBezeichnung());
//
//			daomelden.insert(anschrift, gescheaft);
//		}
	}

	private boolean textFullen(JTextField field) {
		boolean textnichtleher;
		if (field.getText().equals("")) {
			textnichtleher = false;
			field.setBorder(new LineBorder(Colors.parseColor("#FF0000")));
		} else {
			textnichtleher = true;
		}
		return textnichtleher;

	}

	private boolean texteprüfen(boolean[] textBenutzung) {

		for (boolean b : textBenutzung) {
			System.out.println(b);
			if (b == false) {
				textnutz = b;
			} else {
				textnutz = true;
			}

		}
		return textnutz;
	}

	/**
	 * Created On 04.01.2020 by Omar
	 * Manage onBackPressed in case it was in the middle of
	 * the registration or in the start
	 * 
	 * @param arg0
	 */
	protected void onBackPressed(ActionEvent arg0) {
		for (int i = 0; i < radioButtonsGroup.size(); i++) {
			if (radioButtonsGroup.get(0).isSelected()) {
				Utils.reviewOldJFrame(this, new JFrameStart());
				break;
			} else {
				if (radioButtonsGroup.get(i).isSelected()) {
					radioButtonsGroup.get(i).setSelected(false);
					radioButtonsGroup.get(i - 1).setSelected(true);
					manageBackwardSteps(i - 1);
					break;
				}
			}
		}
	}

	/**
	 * Created by Omar Created On 05.01.2020
	 * 
	 * @param currentPosition the currentPostition of the selected radio button
	 * @param size            the length of the steps
	 * 
	 *                        this method manages the steps and the screens to show
	 *                        and activate
	 */
	private void manageRegisterSteps(int currentPosition, int size) {
		if (currentPosition < size - 1) {
			radioButtonsGroup.get(currentPosition + 1).setSelected(true);
			radioButtonsGroup.get(currentPosition).setSelected(false);
			switch (currentPosition + 1) {
			case 1:
				panel_step1.setVisible(false);
				panel_step2.setVisible(true);
				break;
			case 2:
				panel_step2.setVisible(false);
				panel_step3.setVisible(true);
				break;
			}
			label_steps_counter.setText("Schritt " + (currentPosition + 2) + " von " + size);
		}
	}

	/**
	 * Created by Omar Created On 05.01.2020
	 * 
	 * this method manages the backwards steps and the screens to show and activate
	 * 
	 * @param currentPosition the currentPostition of the selected radio button
	 */
	private void manageBackwardSteps(int currentPosition) {
		switch (currentPosition) {
		case 1:
			panel_step3.setVisible(false);
			panel_step2.setVisible(true);
			break;
		case 0:
			panel_step2.setVisible(false);
			panel_step1.setVisible(true);
			break;
		}
		label_steps_counter.setText("Schritt " + (currentPosition + 1) + " von " + radioButtonsGroup.size());
	}

}
