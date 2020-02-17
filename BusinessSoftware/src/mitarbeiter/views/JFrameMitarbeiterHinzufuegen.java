package mitarbeiter.views;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import abteilungen.DaoAbteilung;
import abteilungen.views.JFrameAbteilunghinzufuegen;
import general.code.GeschaeftDB;
import general.code.Utils;
import general.design.Colors;
import general.design.Unicodes;
import main.business_classes.Anschrift;
import mitarbeiter.business_classes.Mitarbeiter;
import mitarbeiter.dao.DaoMitarbeiter;
import start.register.views.JFrameRegistrieren;
import start.views.JFrameStart;

@SuppressWarnings("serial")
public class JFrameMitarbeiterHinzufuegen extends JFrame {

	private JPanel contentPane;
	private JLabel labelNewLabel;
	private JTextField name;
	private JLabel labelGeburtsdatum;
	private JTextField nachname;
	private JLabel labelEmail;
	private JTextField Lohn;
	private JLabel labelGehalt;
	private JTextField pass;
	private JButton buttonSpeichern;
	private JTextField Stadt;
	private JTextField Adresse;
	private JTextField Tel;
	private JLabel lblStadt;
	private JLabel lblAdresse;
	private JLabel lblTel;
	private JButton btnNewButton;
	private boolean textnutz;
	Mitarbeiter mitarbeiter;
	DaoMitarbeiter daoMitarbeiter;
	private JComboBox<String> comboBox;
	JFrameRegistrieren frameRegistrieren;
	DaoAbteilung abteilung;
	Anschrift anschrift;
	JFrameAbteilunghinzufuegen abteilunghinzufuegen;
	private JList<String> list;
	private JScrollPane scrollPane;
	private JTextField plz;
	private JLabel lblNewLabel;

	private JPanel panel;
	private JButton btnNewButtonWeiter;
	private JButton btnNewButtonZurueck;
	private JLabel lblNewLabel_1;

	private JButton btnNewButton_1;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameMitarbeiterHinzufuegen frame = new JFrameMitarbeiterHinzufuegen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Created by Mohammad on 06.02.2020
	 * 
	 * @throws ClassNotFoundException
	 */
	public JFrameMitarbeiterHinzufuegen() throws ClassNotFoundException {
		abteilung = new DaoAbteilung();
		frameRegistrieren = new JFrameRegistrieren();
		initGUI();
		anschrift = new Anschrift();
		mitarbeiter = new Mitarbeiter();
		daoMitarbeiter = new DaoMitarbeiter();
	}

	private void initGUI() {

		setBounds(100, 100, 651, 650);
		contentPane = new JPanel();
		contentPane.setBackground(Colors.parseColor(Colors.LIGHT_GREY));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			buttonSpeichern = new JButton("speichern");
			buttonSpeichern.setFont(new Font("Century Schoolbook", Font.PLAIN, 21));
			buttonSpeichern.setBounds(692, 215, 141, 58);
			contentPane.add(buttonSpeichern);
		}
		{
			Stadt = new JTextField();
			Stadt.setBounds(480, 45, 86, 20);
			contentPane.add(Stadt);
			Stadt.setColumns(10);
		}
		{
			Adresse = new JTextField();
			Adresse.setBounds(480, 129, 86, 20);
			contentPane.add(Adresse);
			Adresse.setColumns(10);
		}
		{
			Tel = new JTextField();
			Tel.setBounds(480, 215, 86, 20);
			contentPane.add(Tel);
			Tel.setColumns(10);
		}
		{
			lblStadt = new JLabel("stadt");
			lblStadt.setBounds(393, 48, 46, 14);
			contentPane.add(lblStadt);
		}
		{
			lblAdresse = new JLabel("Adresse");
			lblAdresse.setBounds(393, 132, 46, 14);
			contentPane.add(lblAdresse);
		}
		{
			lblTel = new JLabel("Tel");
			lblTel.setBounds(393, 218, 46, 14);
			contentPane.add(lblTel);
		}
		{
			btnNewButton = new JButton("New button");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					do_btnNewButton_actionPerformed(arg0);
				}
			});
			btnNewButton.setBounds(420, 284, 89, 23);
			contentPane.add(btnNewButton);
		}
		{
			comboBox = new JComboBox<String>();
			if (!JFrameStart.wegRegistierung) {
				comboBox.setModel(new DefaultComboBoxModel<String>(
						abteilung.Abteilungen(GeschaeftDB.getInstance().getCurrentAccountName())));
			}
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(666, 47, 1, 1);
			contentPane.add(scrollPane);
		}
		{
			panel = new JPanel();
			panel.setBorder(new LineBorder(new Color(0, 0, 0)));
			panel.setBounds(21, 47, 589, 526);
			panel.setBackground(Colors.parseColor(Colors.LIGHT_PINK));
			contentPane.add(panel);
			panel.setLayout(null);
			{
				labelNewLabel = new JLabel("Vorname");
				labelNewLabel.setBounds(10, 107, 97, 19);
				panel.add(labelNewLabel);
				labelNewLabel.setFont(new Font("Calisto MT", Font.ITALIC, 20));
			}
			{
				name = new JTextField();
				name.setBounds(126, 96, 143, 30);
				panel.add(name);
				name.setColumns(10);
			}
			{
				labelGeburtsdatum = new JLabel("Name");
				labelGeburtsdatum.setBounds(10, 30, 143, 22);
				panel.add(labelGeburtsdatum);
				labelGeburtsdatum.setFont(new Font("Calisto MT", Font.ITALIC, 20));
			}
			{
				nachname = new JTextField();
				nachname.setBounds(126, 33, 143, 32);
				panel.add(nachname);
				nachname.setColumns(10);
			}
			{
				labelEmail = new JLabel("Lohn");
				labelEmail.setBounds(10, 419, 110, 19);
				panel.add(labelEmail);
				labelEmail.setFont(new Font("Calisto MT", Font.ITALIC, 20));
			}
			{
				Lohn = new JTextField();
				Lohn.setBounds(126, 416, 143, 30);
				panel.add(Lohn);
				Lohn.setColumns(10);
			}
			{
				labelGehalt = new JLabel("pass");
				labelGehalt.setBounds(10, 477, 137, 38);
				panel.add(labelGehalt);
				labelGehalt.setFont(new Font("Calisto MT", Font.ITALIC, 20));
			}
			{
				pass = new JTextField();
				pass.setBounds(126, 483, 143, 33);
				panel.add(pass);
				pass.setColumns(10);
			}
			{
				lblStadt = new JLabel("Stadt");
				lblStadt.setFont(new Font("Calisto MT", Font.ITALIC, 20));
				lblStadt.setBounds(10, 172, 82, 22);
				panel.add(lblStadt);
			}
			{
				Stadt = new JTextField();
				Stadt.setBounds(126, 166, 143, 30);
				panel.add(Stadt);
				Stadt.setColumns(10);
			}
			{
				lblAdresse = new JLabel("Stra\u00DFe");
				lblAdresse.setFont(new Font("Calisto MT", Font.ITALIC, 20));
				lblAdresse.setBounds(10, 236, 97, 14);
				panel.add(lblAdresse);
			}
			{
				Adresse = new JTextField();
				Adresse.setBounds(126, 226, 143, 30);
				panel.add(Adresse);
				Adresse.setColumns(10);
			}
			{
				lblNewLabel = new JLabel("PLZ");
				lblNewLabel.setFont(new Font("Calisto MT", Font.ITALIC, 20));
				lblNewLabel.setBounds(10, 298, 82, 14);
				panel.add(lblNewLabel);
			}
			{
				plz = new JTextField();
				plz.setBounds(126, 288, 143, 30);
				panel.add(plz);
				plz.setColumns(10);
			}
			{
				lblTel = new JLabel("Tel");
				lblTel.setFont(new Font("Calisto MT", Font.ITALIC, 20));
				lblTel.setBounds(10, 363, 82, 14);
				panel.add(lblTel);
			}
			{
				Tel = new JTextField();
				Tel.setBounds(126, 353, 143, 30);
				panel.add(Tel);
				Tel.setColumns(10);
			}
			{
				btnNewButton = new JButton("Ok");
				btnNewButton.setBounds(490, 488, 89, 23);
				panel.add(btnNewButton);
				{
					btnNewButtonWeiter = new JButton(Unicodes.CHECK);
				
					Utils.setStandardButtonOptions(btnNewButtonWeiter);
					btnNewButtonWeiter.setBounds(521, 584, 89, 23);
					contentPane.add(btnNewButtonWeiter);
				}
				{
					btnNewButtonZurueck = new JButton(Unicodes.BACK_ARROW);
			
					Utils.setStandardButtonOptions(btnNewButtonZurueck);
					btnNewButtonZurueck.setBounds(21, 584, 89, 23);
					contentPane.add(btnNewButtonZurueck);
				}
				{
					lblNewLabel_1 = new JLabel("Hinzuf\u00FCgen");
					lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
					lblNewLabel_1.setForeground(Colors.parseColor(Colors.SEXY_BLUE));
					lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);

					lblNewLabel_1.setBounds(123, 11, 335, 25);
					contentPane.add(lblNewLabel_1);
				}
				{
		
			
		
			
		
			btnNewButton_1 = new JButton("New button");
			btnNewButton_1.setBounds(628, 128, 89, 23);
			contentPane.add(btnNewButton_1);
		}
				
			

	

	protected void do_btnNewButton_actionPerformed(ActionEvent arg0) {
		boolean[] textBenutzung = new boolean[7];
		boolean textnutz;
		textBenutzung[0] = Utils.textFullen(name);
		textBenutzung[1] = Utils.textFullen(nachname);
		textBenutzung[2] = Utils.textFullen(Lohn);
		textBenutzung[3] = Utils.textFullen(pass);
		textBenutzung[4] = Utils.textFullen(Stadt);
		textBenutzung[5] = Utils.textFullen(Adresse);
		textBenutzung[6] = Utils.textFullen(Tel);
		textnutz = texteprüfen(textBenutzung);
		if (textnutz == false) {
			JOptionPane.showMessageDialog(null, "Bitte alle Pflicht Felder ausfüllen!");

		} else if (textnutz == true) {
			mitarbeiter.setNamemitarbeiter(name.getText());
			mitarbeiter.setLohn(Lohn.getText());
			mitarbeiter.setNachname(nachname.getText());
			mitarbeiter.setPass(pass.getText());
			anschrift.setStadt(Stadt.getText());
			anschrift.setAdressse(Adresse.getText());
			anschrift.setTel(Tel.getText());
			anschrift.setPlz(plz.getText());
			daoMitarbeiter.insert(mitarbeiter, comboBox.getSelectedItem().toString(), anschrift);

		}

	}

	private boolean texteprüfen(boolean[] textBenutzung) {
		for (boolean b : textBenutzung) {
			if (b == false) {
				textnutz = b;
			} else {
				textnutz = true;
			}
		}
		return textnutz;
	}

	protected void onBackPressed(ActionEvent arg0) throws ClassNotFoundException {
		Utils.reviewOldJFrame(this, new JFrameStart());
	}


	

	


	protected void do_btnNewButton_1_actionPerformed(ActionEvent e) {
		Mitarbeiterkundigen1 mitarbeiterkundigen1=new Mitarbeiterkundigen1();
		Utils.startNewJFrame(this, mitarbeiterkundigen1);
	}
}

