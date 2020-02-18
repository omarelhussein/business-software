package mitarbeiter.views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import abteilungen.DaoAbteilung;
import abteilungen.business_classes.Abteilung;
import general.code.GeschaeftDB;
import general.code.JComboBoxAdapter;
import general.code.Utils;
import general.design.Colors;
import general.design.Fonts;
import general.design.Unicodes;
import main.business_classes.Anschrift;
import main.dao.DaoAnschrift;
import mitarbeiter.business_classes.Mitarbeiter;
import mitarbeiter.dao.DaoMitarbeiter;

import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.AbstractListModel;

@SuppressWarnings("serial")
public class JFrameMitarbeiterBearbeiten extends JFrame {

	private JPanel contentPane;
	private JButton buttonSpeichern;
	private JLabel labelNachname;
	private JLabel labelOrt;
	private JLabel labelPlz;
	private JLabel labelTel;
	private JLabel labelVorname;
	private JTextField textFieldPlz;
	private JTextField textFieldStrasse;
	private JTextField textFieldOrt;
	private JTextField textFieldVorname;
	private JTextField textFieldNachname;
	private JPanel panel;
	private JButton btnCheck;
	private JLabel labelNewLabel;
	private JLabel labelNewLabel_1;
	private JTextField textFieldTel;
	private JSeparator separator;
	private JLabel labelNewLabel_2;
	private JTextField textFieldLohn;
	private JTextField textFieldPass;
	private JTextField textFieldPassWied;
	private JLabel labelPasswort;
	private JLabel labelPasswortWied;
	private JComboBox<Abteilung> comboBoxAbteilung;
	private JButton btnUpdate;
	private JButton buttonNewButton;
	private DaoAbteilung daoAbteilung;
	private DaoMitarbeiter daoMitarbeiter;
	private JList<Object> list;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameMitarbeiterBearbeiten frame = new JFrameMitarbeiterBearbeiten();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Created by Mohammad on 06.02.2020
	 */
	public JFrameMitarbeiterBearbeiten() {
		daoAbteilung = new DaoAbteilung();
		daoMitarbeiter = new DaoMitarbeiter();
		initGUI();
		if (comboBoxAbteilung.getItemCount() > 0) {
			loadMitarbeiterForSelectedAbteilung();
		}
	}

	private void initGUI() {
		Utils.setMiddleFrameOptions(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			buttonSpeichern = new JButton("speichern");
			buttonSpeichern.setFont(new Font("Century Schoolbook", Font.PLAIN, 21));
			buttonSpeichern.setBounds(692, 215, 141, 58);
			Utils.setStandardButtonOptions(buttonSpeichern);
			contentPane.add(buttonSpeichern);
		}
		{
			panel = new JPanel();
			panel.setBorder(new LineBorder(new Color(0, 0, 0)));
			panel.setBackground(Colors.parseColor(Colors.LIGHT_PINK));
			panel.setBounds(10, 57, 614, 509);
			contentPane.add(panel);
			panel.setLayout(null);
			{
				labelNachname = new JLabel("Nachname");
				labelNachname.setBounds(20, 36, 97, 25);
				panel.add(labelNachname);
				labelNachname.setFont(new Font("Calibri", Font.PLAIN, 15));
			}
			{
				textFieldNachname = new JTextField();
				textFieldNachname.setBounds(137, 36, 152, 25);
				panel.add(textFieldNachname);
				textFieldNachname.setColumns(10);
			}
			{
				labelOrt = new JLabel("Ort");
				labelOrt.setBounds(20, 108, 97, 25);
				panel.add(labelOrt);
				labelOrt.setFont(new Font("Calibri", Font.PLAIN, 15));
			}
			{
				textFieldVorname = new JTextField();
				textFieldVorname.setBounds(137, 72, 152, 25);
				panel.add(textFieldVorname);
				textFieldVorname.setColumns(10);
			}
			{
				labelPlz = new JLabel("PLZ");
				labelPlz.setBounds(20, 180, 97, 25);
				panel.add(labelPlz);
				labelPlz.setFont(new Font("Calibri", Font.PLAIN, 15));
			}
			{
				textFieldOrt = new JTextField();
				textFieldOrt.setBounds(137, 108, 152, 25);
				panel.add(textFieldOrt);
				textFieldOrt.setColumns(10);
			}
			{
				labelTel = new JLabel("Tel");
				labelTel.setBounds(20, 216, 97, 25);
				panel.add(labelTel);
				labelTel.setFont(new Font("Calibri", Font.PLAIN, 15));
			}
			{
				textFieldStrasse = new JTextField();
				textFieldStrasse.setBounds(137, 144, 152, 25);
				panel.add(textFieldStrasse);
				textFieldStrasse.setColumns(10);
			}
			{
				labelVorname = new JLabel("Vorname");
				labelVorname.setBounds(20, 72, 97, 25);
				panel.add(labelVorname);
				labelVorname.setFont(new Font("Calibri", Font.PLAIN, 15));
			}
			{
				textFieldPlz = new JTextField();
				textFieldPlz.setBounds(137, 180, 152, 25);
				panel.add(textFieldPlz);
				textFieldPlz.setColumns(10);
			}
			{
				labelNewLabel_1 = new JLabel("Stra\u00DFe/ HausNr.");
				labelNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 15));
				labelNewLabel_1.setBounds(20, 144, 107, 25);
				panel.add(labelNewLabel_1);
			}
			{
				textFieldTel = new JTextField();
				textFieldTel.setColumns(10);
				textFieldTel.setBounds(137, 216, 152, 25);
				panel.add(textFieldTel);
			}
			{
				separator = new JSeparator();
				separator.setBounds(10, 284, 303, 1);
				panel.add(separator);
			}
			{
				labelNewLabel_2 = new JLabel("Lohn");
				labelNewLabel_2.setFont(new Font("Calibri", Font.PLAIN, 15));
				labelNewLabel_2.setBounds(20, 296, 107, 25);
				panel.add(labelNewLabel_2);
			}
			{
				textFieldLohn = new JTextField();
				textFieldLohn.setColumns(10);
				textFieldLohn.setBounds(137, 298, 152, 25);
				panel.add(textFieldLohn);
			}
			{
				textFieldPass = new JTextField();
				textFieldPass.setColumns(10);
				textFieldPass.setBounds(137, 334, 152, 25);
				panel.add(textFieldPass);
			}
			{
				textFieldPassWied = new JTextField();
				textFieldPassWied.setColumns(10);
				textFieldPassWied.setBounds(137, 370, 152, 25);
				panel.add(textFieldPassWied);
			}
			{
				labelPasswort = new JLabel("Passwort");
				labelPasswort.setFont(new Font("Calibri", Font.PLAIN, 15));
				labelPasswort.setBounds(20, 334, 107, 25);
				panel.add(labelPasswort);
			}
			{
				labelPasswortWied = new JLabel("Passwort wied.");
				labelPasswortWied.setFont(new Font("Calibri", Font.PLAIN, 15));
				labelPasswortWied.setBounds(20, 370, 107, 25);
				panel.add(labelPasswortWied);
			}
			{
				comboBoxAbteilung = new JComboBox<>(
						daoAbteilung.Abteilungen(GeschaeftDB.getInstance().getCurrentAccountName()));
				comboBoxAbteilung.setRenderer(new JComboBoxAdapter(new Abteilung()));
				comboBoxAbteilung.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						onAbteilungSelected(e);
					}
				});
				comboBoxAbteilung.setBackground(Colors.parseColor(Colors.LIGHT_PINK));
				comboBoxAbteilung.setBounds(20, 406, 269, 25);
				panel.add(comboBoxAbteilung);
			}
			{
				btnUpdate = new JButton("Daten Pflegen");
				btnUpdate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						onUpdateClicked(arg0);
					}
				});
				Utils.setStandardButtonOptions(btnUpdate);
				btnUpdate.setBounds(20, 442, 269, 23);
				panel.add(btnUpdate);
			}
			{
				buttonNewButton = new JButton("Mitarbeiter K\u00FCndigen");
				buttonNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						onDeleteClicked(e);
					}
				});
				Utils.setStandardButtonOptions(buttonNewButton);
				buttonNewButton.setBounds(20, 475, 269, 23);
				panel.add(buttonNewButton);
			}
			{
				scrollPane = new JScrollPane();
				scrollPane.setBounds(323, 11, 281, 487);
				panel.add(scrollPane);
				{
					list = new JList<>();
					list.setModel(new AbstractListModel<Object>() {
						String[] values = new String[] { "" };

						public int getSize() {
							return values.length;
						}

						public Object getElementAt(int index) {
							return values[index];
						}
					});
					scrollPane.setViewportView(list);
					list.addListSelectionListener(new ListSelectionListener() {
						
						@Override
						public void valueChanged(ListSelectionEvent e) {
							if(!list.isSelectionEmpty()) {
								fillFields();								
							} else {
								clearFields();
							}
						}
					});
				}
			}
		}
		{
			btnCheck = new JButton(Unicodes.CHECK);
			Utils.setStandardButtonOptions(btnCheck);
			btnCheck.setBounds(535, 577, 89, 23);
			btnCheck.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					onCheckClicked(e);
				}
			});
			contentPane.add(btnCheck);
		}
		{
			labelNewLabel = new JLabel("Mitarbeitern Bearbeiten");
			labelNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			labelNewLabel.setBounds(10, 11, 614, 35);
			Fonts.setCenturySchoolbookFont(labelNewLabel, 20);
			labelNewLabel.setForeground(Colors.parseColor(Colors.SEXY_BLUE));
			contentPane.add(labelNewLabel);
		}
	}

	protected void onCheckClicked(ActionEvent e) {
		this.setVisible(false);
	}

	protected void onUpdateClicked(ActionEvent arg0) {
		
	}

	protected void onDeleteClicked(ActionEvent e) {

	}

	protected void onAbteilungSelected(ActionEvent e) {
		loadMitarbeiterForSelectedAbteilung();
	}
	
	private void fillFields() {
		DaoAnschrift daoAnschrift = new DaoAnschrift();
		
		Mitarbeiter mitarbeiter = daoMitarbeiter.loadMitarbeiter(getAbteilungID().getId())[list.getSelectedIndex()];
		textFieldNachname.setText(mitarbeiter.getNachname());
		textFieldVorname.setText(mitarbeiter.getNamemitarbeiter());
		textFieldLohn.setText(mitarbeiter.getLohn());
		textFieldPass.setText(mitarbeiter.getPass());
		Anschrift anschriftMitarbeiter = daoAnschrift.getMitarbeiterAnschrift(mitarbeiter.getId());
		mitarbeiter.setAnschrift(anschriftMitarbeiter);
		textFieldStrasse.setText(mitarbeiter.getAnschrift().getAdressse());
		textFieldOrt.setText(mitarbeiter.getAnschrift().getOrt());
		textFieldPlz.setText(mitarbeiter.getAnschrift().getPlz());
		textFieldTel.setText(mitarbeiter.getAnschrift().getTel());
	}
	
	private void clearFields() {
		textFieldNachname.setText("");
		textFieldVorname.setText("");
		textFieldLohn.setText("");
		textFieldPass.setText("");
		textFieldStrasse.setText("");
		textFieldOrt.setText("");
		textFieldPlz.setText("");
		textFieldTel.setText("");
	}

	private void loadMitarbeiterForSelectedAbteilung() {
		Abteilung abteilung = getAbteilungID();
		Mitarbeiter[] mitarbeiter = daoMitarbeiter.loadMitarbeiter(abteilung.getId());
		ArrayList<String> names = new ArrayList<>();
		for (int i = 0; i < mitarbeiter.length; i++) {
			names.add(mitarbeiter[i].getNamemitarbeiter());
		}
		Utils.updateList(list, true, scrollPane, names);
	}

	private Abteilung getAbteilungID() {
		Abteilung abteilung = daoAbteilung
				.Abteilungen(GeschaeftDB.getInstance().getCurrentAccountName())[comboBoxAbteilung.getSelectedIndex()];
		return abteilung;
	}
}
