package mitarbeiter.views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import abteilungen.DaoAbteilung;
import abteilungen.business_classes.Abteilung;
import abteilungen.views.JFrameAbteilunghinzufuegen;
import general.code.GeschaeftDB;
import general.code.JComboBoxAdapter;
import general.code.Utils;
import general.design.Colors;
import general.design.Fonts;
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
	private JPasswordField pass;
	private JButton buttonSpeichern;
	private JTextField Stadt;
	private JTextField Adresse;
	private JTextField Tel;
	private JLabel lblStadt;
	private JLabel lblAdresse;
	private JLabel lblTel;
	private JButton btnCheck;
	private boolean textnutz;
	private Mitarbeiter mitarbeiter;
	private DaoMitarbeiter daoMitarbeiter;
	private JFrameRegistrieren frameRegistrieren;
	private DaoAbteilung daoAbteilung;
	private Anschrift anschrift;
	private JFrameAbteilunghinzufuegen abteilunghinzufuegen;
	private JList<Object> list;
	private JTextField plz;
	private JLabel lblNewLabel;
	private JPanel panel;
	private JLabel lblNewLabel_1;
	private JSeparator separator;
	private JLabel label;
	private JTextField textField;
	private JLabel labelPasswortWied;
	private JPasswordField passWied;
	private JComboBox<Abteilung> comboBoxAbteilungen;
	private JButton btnAddMitarbeiter;
	private ArrayList<String> values;
	private JScrollPane scrollPane;

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
	public JFrameMitarbeiterHinzufuegen() {
		values = new ArrayList<>();
		daoAbteilung = new DaoAbteilung();
		frameRegistrieren = new JFrameRegistrieren();
		anschrift = new Anschrift();
		mitarbeiter = new Mitarbeiter();
		daoMitarbeiter = new DaoMitarbeiter();
		initGUI();
	}

	private void initGUI() {

		Utils.setMiddleFrameOptions(this);
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
			panel = new JPanel();
			panel.setBorder(new LineBorder(new Color(0, 0, 0)));
			panel.setBounds(21, 47, 603, 526);
			panel.setBackground(Colors.parseColor(Colors.LIGHT_PINK));
			contentPane.add(panel);
			panel.setLayout(null);
			{
				labelNewLabel = new JLabel("Vorname");
				labelNewLabel.setBounds(10, 67, 106, 25);
				panel.add(labelNewLabel);
				labelNewLabel.setFont(new Font("Calibri", Font.PLAIN, 15));
			}
			{
				name = new JTextField();
				name.setBounds(126, 67, 143, 25);
				panel.add(name);
				name.setColumns(10);
			}
			{
				labelGeburtsdatum = new JLabel("Nachname");
				labelGeburtsdatum.setBounds(10, 31, 106, 25);
				panel.add(labelGeburtsdatum);
				labelGeburtsdatum.setFont(new Font("Calibri", Font.PLAIN, 15));
			}
			{
				nachname = new JTextField();
				nachname.setBounds(126, 31, 143, 25);
				panel.add(nachname);
				nachname.setColumns(10);
			}
			{
				labelEmail = new JLabel("Lohn");
				labelEmail.setBounds(10, 298, 106, 25);
				panel.add(labelEmail);
				labelEmail.setFont(new Font("Calibri", Font.PLAIN, 15));
			}
			{
				Lohn = new JTextField();
				Lohn.setBounds(126, 298, 143, 25);
				panel.add(Lohn);
				Lohn.setColumns(10);
			}
			{
				labelGehalt = new JLabel("Passwort");
				labelGehalt.setBounds(10, 334, 106, 25);
				panel.add(labelGehalt);
				labelGehalt.setFont(new Font("Calibri", Font.PLAIN, 15));
			}
			{
				pass = new JPasswordField();
				pass.setBounds(126, 334, 143, 25);
				panel.add(pass);
				pass.setColumns(10);
			}
			{
				lblStadt = new JLabel("Ort");
				lblStadt.setFont(new Font("Calibri", Font.PLAIN, 15));
				lblStadt.setBounds(10, 103, 106, 25);
				panel.add(lblStadt);
			}
			{
				Stadt = new JTextField();
				Stadt.setBounds(126, 103, 143, 25);
				panel.add(Stadt);
				Stadt.setColumns(10);
			}
			{
				lblAdresse = new JLabel("Stra\u00DFe / HausNr.");
				lblAdresse.setFont(new Font("Calibri", Font.PLAIN, 15));
				lblAdresse.setBounds(10, 139, 106, 25);
				panel.add(lblAdresse);
			}
			{
				Adresse = new JTextField();
				Adresse.setBounds(126, 139, 143, 25);
				panel.add(Adresse);
				Adresse.setColumns(10);
			}
			{
				lblNewLabel = new JLabel("PLZ");
				lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 15));
				lblNewLabel.setBounds(10, 175, 106, 25);
				panel.add(lblNewLabel);
			}
			{
				plz = new JTextField();
				plz.setBounds(126, 175, 143, 25);
				panel.add(plz);
				plz.setColumns(10);
			}
			{
				lblTel = new JLabel("Tel");
				lblTel.setFont(new Font("Calibri", Font.PLAIN, 15));
				lblTel.setBounds(10, 211, 106, 25);
				panel.add(lblTel);
			}
			{
				Tel = new JTextField();
				Tel.setBounds(126, 211, 143, 25);
				panel.add(Tel);
				Tel.setColumns(10);
			}
			{
				{
					separator = new JSeparator();
					separator.setBounds(10, 285, 283, 2);
					panel.add(separator);
				}
				{
					labelPasswortWied = new JLabel("Passwort wied.");
					labelPasswortWied.setFont(new Font("Calibri", Font.PLAIN, 15));
					labelPasswortWied.setBounds(10, 370, 106, 25);
					panel.add(labelPasswortWied);
				}
				{
					passWied = new JPasswordField();
					passWied.setColumns(10);
					passWied.setBounds(126, 370, 143, 25);
					panel.add(passWied);
				}
				{
					comboBoxAbteilungen = new JComboBox<>(
							daoAbteilung.Abteilungen(GeschaeftDB.getInstance().getCurrentAccountName()));
					comboBoxAbteilungen.setRenderer(new JComboBoxAdapter(new Abteilung()));
					comboBoxAbteilungen.setBounds(10, 406, 259, 25);
					comboBoxAbteilungen.setBackground(Colors.parseColor(Colors.LIGHT_PINK));
					panel.add(comboBoxAbteilungen);
				}
				{
					btnAddMitarbeiter = new JButton("Mitarbeiter hinzuf\u00FCgen");
					btnAddMitarbeiter.setBounds(10, 450, 259, 23);
					Utils.setStandardButtonOptions(btnAddMitarbeiter);
					btnAddMitarbeiter.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							onAddMitarbeiterClicked(e);
						}
					});
					panel.add(btnAddMitarbeiter);
				}
				{
					scrollPane = new JScrollPane();
					scrollPane.setBounds(298, 31, 285, 442);
					panel.add(scrollPane);
					{
						list = new JList<Object>();
						scrollPane.setViewportView(list);
					}
				}
				{
				}
				{
					lblNewLabel_1 = new JLabel("Mitarbeiter hinzufügen");
					Fonts.setCenturySchoolbookFont(lblNewLabel_1, 20);
					lblNewLabel_1.setForeground(Colors.parseColor(Colors.SEXY_BLUE));
					lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);

					lblNewLabel_1.setBounds(123, 11, 335, 25);
					contentPane.add(lblNewLabel_1);
				}
				btnCheck = new JButton(Unicodes.CHECK);
				btnCheck.setBounds(535, 577, 89, 23);
				Utils.setStandardButtonOptions(btnCheck);
				btnCheck.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						onCheckClicked(e);
					}
				});
				contentPane.add(btnCheck);
			}
		}

	}

	private void onCheckClicked(ActionEvent e) {
		this.setVisible(false);
	}

	protected void onAddMitarbeiterClicked(ActionEvent arg0) {
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
			Abteilung currentAbteilung = daoAbteilung.Abteilungen(GeschaeftDB.getInstance().getCurrentAccountName())[comboBoxAbteilungen.getSelectedIndex()];
			mitarbeiter.setNamemitarbeiter(name.getText());
			mitarbeiter.setLohn(Lohn.getText());
			mitarbeiter.setNachname(nachname.getText());
			mitarbeiter.setPass(String.valueOf(pass.getPassword()));
			anschrift.setStadt(Stadt.getText());
			anschrift.setAdressse(Adresse.getText());
			anschrift.setTel(Tel.getText());
			anschrift.setPlz(plz.getText());
			if(String.valueOf(pass.getPassword()).equals(String.valueOf(passWied.getPassword()))) {
				daoMitarbeiter.insert(mitarbeiter, currentAbteilung.getId(), anschrift);
				clearFields();
				values.add(mitarbeiter.getNamemitarbeiter());
				Utils.updateList(list, true, scrollPane, values);
			} else {
				JOptionPane.showMessageDialog(this, "Bitte den Passwort richtig eingeben");
			}
		}

	}
	
	private void clearFields() {
		name.setText("");
		Lohn.setText("");
		nachname.setText("");
		pass.setText("");
		passWied.setText("");
		plz.setText("");
		Stadt.setText("");
		Adresse.setText("");
		Tel.setText("");
		nachname.requestFocus();
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

	protected void btnNewButtonWeiterActionPerformed(ActionEvent e) {
	}
}
