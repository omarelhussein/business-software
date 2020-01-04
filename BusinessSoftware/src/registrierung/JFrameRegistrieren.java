package registrierung;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.Anschrift;
import start.Daomelden;
import start.Gescheaft;
import start.JFrameStart;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

import general.Colors;
import general.Fonts;
import general.TextErrorField;
import general.Unicodes;
import general.Utils;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class JFrameRegistrieren extends JFrame {

	private JPanel contentPane;
	private TextErrorField namedergeschaeft;
	private TextErrorField textField_bezeichnung;
	private JLabel lblNameDerGschaeft;
	private TextErrorField textField_pass;
	private JLabel lblNewLabel;
	private JLabel lblPass;
	private TextErrorField textField_stadt;
	private JLabel lblNewLabel_1;
	private TextErrorField textField_Tel;
	private JLabel lblTel;
	private TextErrorField textField_anschrift;
	private JLabel lblNewLabel_2;
	private JButton btnNewButton;
	private Daomelden daomelden;
	private Anschrift anschrift;
	private Gescheaft gescheaft;
	private JPanel panel;
	private JLabel label_register;
	private boolean textnutz = true;
	private JButton buttonNewButton;
	private TextErrorField errorField;

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
		Utils.setMainFrameOptions(this);
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
			panel = new JPanel();
			panel.setBackground(new Color(255, 250, 240));
			panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			panel.setBounds(42, 75, 802, 423);
			contentPane.add(panel);
			panel.setLayout(null);
			{
				{
					lblNameDerGschaeft = new JLabel("Name des Gesch\u00E4fts");
					lblNameDerGschaeft.setFont(new Font("Tahoma", Font.PLAIN, 15));
					lblNameDerGschaeft.setBounds(21, 30, 219, 25);
					panel.add(lblNameDerGschaeft);
				}
				{
					lblNewLabel = new JLabel("Bezeichnung");
					lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
					lblNewLabel.setBounds(21, 80, 219, 25);
					panel.add(lblNewLabel);
				}
				{
					lblPass = new JLabel("Passwort ");
					lblPass.setFont(new Font("Tahoma", Font.PLAIN, 15));
					lblPass.setBounds(21, 130, 219, 25);
					panel.add(lblPass);
				}
				{
					lblNewLabel_1 = new JLabel("Stadt");
					lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
					lblNewLabel_1.setBounds(21, 180, 219, 20);
					panel.add(lblNewLabel_1);
				}
				{
					lblTel = new JLabel("Telefonnummer");
					lblTel.setFont(new Font("Tahoma", Font.PLAIN, 15));
					lblTel.setBounds(21, 230, 219, 14);
					panel.add(lblTel);
				}
				{
					lblNewLabel_2 = new JLabel("Stra\u00DFe");
					lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
					lblNewLabel_2.setBounds(21, 280, 219, 20);
					panel.add(lblNewLabel_2);
				}
				{
					errorField = new TextErrorField(panel);
					errorField.setBounds(250, 30, 175, 25);
					errorField.setErrorMessage("Ihre eingabe stimmt leider nicht, versuchen Sie es bitte erneut.");
					errorField.setErrorVisibility(false);
					panel.add(errorField);
				}
				{
					textField_stadt = new TextErrorField(panel);
					textField_stadt.setBounds(250, 180, 177, 25);
					panel.add(textField_stadt);
					textField_stadt.setColumns(10);
				}
				{
					textField_Tel = new TextErrorField(panel);
					textField_Tel.setBounds(250, 230, 175, 25);
					panel.add(textField_Tel);

					textField_Tel.setColumns(10);
				}
				{
					textField_anschrift = new TextErrorField(panel);
					textField_anschrift.setBackground(new Color(255, 255, 255));
					textField_anschrift.setBounds(250, 280, 175, 25);
					panel.add(textField_anschrift);
					textField_anschrift.setColumns(10);
				}
				{
					textField_pass = new TextErrorField(panel);
					textField_pass.setBounds(250, 130, 175, 25);
					textField_pass.setErrorMessage("Irgendwas stimmt nicht");
					panel.add(textField_pass);
					textField_pass.setColumns(10);
				}
				{
					textField_bezeichnung = new TextErrorField(panel);
					textField_bezeichnung.setBounds(250, 80, 175, 25);
					panel.add(textField_bezeichnung);
					textField_bezeichnung.setColumns(10);
				}
				{
					label_register = new JLabel("Registrierung");
					label_register.setForeground(Colors.parseColor(Colors.SEXY_BLUE));
					label_register.setHorizontalAlignment(SwingConstants.CENTER);
					Fonts.setCenturySchoolbookFont(label_register, 24);
					label_register.setBounds(42, 11, 784, 55);
					contentPane.add(label_register);
				}
				btnNewButton = new JButton(Unicodes.CHECK);
				Utils.standardButtonOptions(btnNewButton);
				btnNewButton.setBounds(696, 509, 178, 41);
				contentPane.add(btnNewButton);
				{
					buttonNewButton = new JButton(Unicodes.BACK_ARROW);
					buttonNewButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							onBackPressed(arg0);
						}
					});
					buttonNewButton.setBounds(10, 509, 178, 41);
					Utils.standardButtonOptions(buttonNewButton);
					contentPane.add(buttonNewButton);
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
		boolean genutzt;
		boolean[] textBenutzung = new boolean[6];
		textBenutzung[0] = textFullen(errorField);
		textBenutzung[1] = textFullen(textField_pass);
		textBenutzung[2] = textFullen(textField_bezeichnung);
		textBenutzung[3] = textFullen(textField_stadt);
		textBenutzung[4] = textFullen(textField_Tel);
		textBenutzung[5] = textFullen(textField_anschrift);
		genutzt = textepr�fen(textBenutzung);

		if (genutzt == false) {
			JOptionPane.showMessageDialog(null, "Bitte alle Pflicht Felder ausf�llen!");
		} else if (genutzt == true) {
			gescheaft.setNamegeascheaft(namedergeschaeft.getText());
			gescheaft.setBezeichnung(textField_bezeichnung.getText());
			gescheaft.setPass(textField_pass.getText());
			anschrift.setStadt(textField_stadt.getText());
			anschrift.setTel(textField_Tel.getText());
			anschrift.setAdressse(textField_anschrift.getText());
			System.out.println("das ist die" + gescheaft.getBezeichnung());

			daomelden.insert(anschrift, gescheaft);
		}

	}

	private boolean textFullen(JTextField field) {
		boolean textnichtleher;
		if (field.getText().equals("")) {
			textnichtleher = false;
			field.setBorder(new LineBorder(Colors.parseColor("#FF0000")));
			
			if (field == errorField) {
				errorField.setErrorVisibility(true);
				
				
			}
			

		} else {
			textnichtleher = true;
		}
		return textnichtleher;

	}

	private boolean textepr�fen(boolean[] textBenutzung) {

		for (boolean b : textBenutzung) {
			
			if (b == false) {
				textnutz = b;
			} else {
				textnutz = true;
			}

		}
		return textnutz;
	}

	protected void onBackPressed(ActionEvent arg0) {
		Utils.reviewOldJFrame(this, new JFrameStart());
	}
}
