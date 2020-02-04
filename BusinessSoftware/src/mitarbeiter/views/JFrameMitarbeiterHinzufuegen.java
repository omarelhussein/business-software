package mitarbeiter.views;

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
import javax.swing.border.EmptyBorder;

import abteilungen.DaoAbteilung;
import abteilungen.views.JFrameAbteilunghinzufuegen;
import general.code.GeschaeftDB;
import general.code.Utils;
import main.business_classes.Anschrift;
import mitarbeiter.business_classes.Mitarbeiter;
import mitarbeiter.dao.DaoMitarbeiter;
import start.register.views.JFrameRegistrieren;
import start.views.JFrameStart;

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
	private JComboBox comboBox;
	JFrameRegistrieren frameRegistrieren;
	DaoAbteilung abteilung;
	Anschrift anschrift;
	JFrameAbteilunghinzufuegen abteilunghinzufuegen;
	private JList list;
	private JScrollPane scrollPane;
	private JTextField plz;
	private JLabel lblNewLabel;

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
	 * Create the frame.
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
		setBounds(100, 100, 863, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			labelNewLabel = new JLabel("Name");
			labelNewLabel.setFont(new Font("Century Schoolbook", Font.PLAIN, 21));
			labelNewLabel.setBounds(39, 42, 97, 19);
			contentPane.add(labelNewLabel);
		}
		{
			name = new JTextField();
			name.setBounds(209, 39, 116, 22);
			contentPane.add(name);
			name.setColumns(10);
		}
		{
			labelGeburtsdatum = new JLabel("nACHNAME");
			labelGeburtsdatum.setFont(new Font("Century Schoolbook", Font.PLAIN, 21));
			labelGeburtsdatum.setBounds(33, 96, 143, 22);
			contentPane.add(labelGeburtsdatum);
		}
		{
			nachname = new JTextField();
			nachname.setBounds(209, 96, 116, 22);
			contentPane.add(nachname);
			nachname.setColumns(10);
		}
		{
			labelEmail = new JLabel("Lohn");
			labelEmail.setFont(new Font("Century Schoolbook", Font.PLAIN, 21));
			labelEmail.setBounds(39, 151, 110, 19);
			contentPane.add(labelEmail);
		}
		{
			Lohn = new JTextField();
			Lohn.setBounds(209, 148, 116, 22);
			contentPane.add(Lohn);
			Lohn.setColumns(10);
		}
		{
			labelGehalt = new JLabel("pass");
			labelGehalt.setFont(new Font("Century Schoolbook", Font.PLAIN, 21));
			labelGehalt.setBounds(39, 186, 137, 38);
			contentPane.add(labelGehalt);
		}
		{
			pass = new JTextField();
			pass.setBounds(209, 197, 116, 22);
			contentPane.add(pass);
			pass.setColumns(10);
		}
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
			comboBox = new JComboBox();
			if (!JFrameStart.wegRegistierung) {
				comboBox.setModel(new DefaultComboBoxModel(abteilung.Abteilungen(GeschaeftDB.getInstance().getCurrentAccountName())));
			}

			comboBox.setBounds(197, 248, 191, 59);

			contentPane.add(comboBox);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(666, 47, 1, 1);
			contentPane.add(scrollPane);
		}
		{
			plz = new JTextField();
			plz.setBounds(480, 160, 86, 20);
			contentPane.add(plz);
			plz.setColumns(10);
		}
		{
			lblNewLabel = new JLabel("plz");
			lblNewLabel.setBounds(393, 166, 46, 14);
			contentPane.add(lblNewLabel);
		}

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
}
