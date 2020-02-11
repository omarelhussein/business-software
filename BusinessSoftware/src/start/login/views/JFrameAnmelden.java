package start.login.views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import general.code.AutoCompletition;
import general.code.GeschaeftDB;
import general.code.Utils;
import general.design.Colors;
import general.design.Fonts;
import general.design.Unicodes;
import main.dao.DaoGescheaft;
import main.views.JFrameMain;
import mitarbeiter.dao.DaoMitarbeiter;
import start.login.dao.Daoanmelden;
import start.views.JFrameStart;

@SuppressWarnings("serial")
public class JFrameAnmelden extends JFrame {

	private JPanel contentPane;
	private JLabel labelMeldenSieBitte;
	private JLabel labelBenutzerName;
	private JTextField textFieldNameInput;
	private JLabel labelPasswort;
	private JButton buttonOk;
	private JButton buttonZurck;
	private JPanel panel;
	private JPasswordField textFieldPasswordInput;
	private JRadioButton radioButtonMitarbeiter;
	private JRadioButton radioButtonGeschftfhrer;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	DaoMitarbeiter mitarbeiterEinlogen;
	Daoanmelden daoanmelden;
	private JLabel labelNewLabel;
	private JComboBox<String> comboBox;
	private ArrayList<String> namesList;
	private JLabel labelNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameAnmelden frame = new JFrameAnmelden();
					frame.setVisible(true);
					frame.setResizable(false);// das Fenszter wird nicht gross
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
	public JFrameAnmelden() throws ClassNotFoundException {
		mitarbeiterEinlogen = new DaoMitarbeiter();
		daoanmelden = new Daoanmelden();
		initGUI();
		namesList = new ArrayList<String>();
	}

	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Utils.setMainFrameOptions(this);
		contentPane = new JPanel();
		contentPane.setBackground(Color.decode(Colors.LIGHT_GREY));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			labelMeldenSieBitte = new JLabel("Anmeldung ^_^");
			labelMeldenSieBitte.setBounds(50, 31, 800, 58);
			labelMeldenSieBitte.setHorizontalAlignment(SwingConstants.CENTER);
			labelMeldenSieBitte.setFont(new Font("Century Schoolbook", Font.PLAIN, 21));
			labelMeldenSieBitte.setForeground(Colors.parseColor(Colors.SEXY_BLUE));
			contentPane.add(labelMeldenSieBitte);
		}
		{
			panel = new JPanel();
			panel.setBounds(50, 100, 800, 352);
			contentPane.add(panel);
			panel.setBackground(Colors.parseColor(Colors.LIGHT_PINK));
			panel.setBorder(new LineBorder(new Color(0, 0, 0)));
			panel.setLayout(null);
			{
				labelBenutzerName = new JLabel("Benutzername");
				labelBenutzerName.setBounds(404, 37, 138, 41);
				panel.add(labelBenutzerName);
				labelBenutzerName.setFont(new Font("Century Schoolbook", Font.PLAIN, 18));
			}
			{
				labelPasswort = new JLabel("Passwort");
				labelPasswort.setBounds(404, 134, 138, 41);
				panel.add(labelPasswort);
				labelPasswort.setFont(new Font("Century Schoolbook", Font.PLAIN, 18));
			}
			{
				textFieldNameInput = new JTextField();
				textFieldNameInput.setBounds(404, 79, 359, 41);
				panel.add(textFieldNameInput);
				textFieldNameInput.setFont(new Font("Tahoma", Font.PLAIN, 18));
				textFieldNameInput.setColumns(10);
			}
			{
				{
					{
						textFieldPasswordInput = new JPasswordField();
						textFieldPasswordInput.setFont(new Font("Tahoma", Font.PLAIN, 18));
						textFieldPasswordInput.setBounds(404, 176, 359, 41);
						panel.add(textFieldPasswordInput);
					}
				}
			}
			{
				radioButtonMitarbeiter = new JRadioButton("Mitarbeiter");
				radioButtonMitarbeiter.setContentAreaFilled(false);
				buttonGroup.add(radioButtonMitarbeiter);
				radioButtonMitarbeiter.setBounds(533, 282, 199, 25);
				panel.add(radioButtonMitarbeiter);
			}
			{
				radioButtonGeschftfhrer = new JRadioButton("Gesch\u00E4ftsf\u00FChrer");
				radioButtonGeschftfhrer.setContentAreaFilled(false);
				buttonGroup.add(radioButtonGeschftfhrer);
				radioButtonGeschftfhrer.setBounds(404, 282, 127, 25);
				panel.add(radioButtonGeschftfhrer);
			}
			{

				labelNewLabel = new JLabel("Bitte ausw\u00E4hlen: ");
				labelNewLabel.setForeground(Colors.parseColor(Colors.SEXY_BLUE));
				labelNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
				labelNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				labelNewLabel.setBounds(404, 261, 206, 14);
				panel.add(labelNewLabel);
			}
			{
				comboBox = new JComboBox<String>();
				comboBox.setBackground(Colors.parseColor(Colors.LIGHT_PINK));
				comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
				setComboBoxAdapter();
				comboBox.setBounds(108, 135, 244, 41);
				panel.add(comboBox);
			}
			{
				labelNewLabel_1 = new JLabel("Gesch\u00E4ft ausw\u00E4hlen:");
				labelNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
				labelNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
				labelNewLabel_1.setBounds(108, 79, 244, 41);
				labelNewLabel_1.setForeground(Colors.parseColor(Colors.SEXY_BLUE));
				Fonts.setCenturySchoolbookFont(labelNewLabel_1, 16);
				panel.add(labelNewLabel_1);
			}
		}
		buttonZurck = new JButton(Unicodes.BACK_ARROW);
		buttonZurck.setBounds(24, 484, 246, 46);
		Utils.setStandardButtonOptions(buttonZurck);
		contentPane.add(buttonZurck);
		buttonZurck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					onBack(arg0);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		buttonOk = new JButton(Unicodes.CHECK);
		buttonOk.setBounds(635, 484, 246, 46);
		Utils.setStandardButtonOptions(buttonOk);
		contentPane.add(buttonOk);
		buttonOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					onOkClick(e);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}

	private void setComboBoxAdapter() {
		DaoGescheaft dao = new DaoGescheaft();
		namesList = dao.getAllNames();

		String[] arrayNames = new String[namesList.size()];
		for (int i = 0; i < namesList.size(); i++) {
			arrayNames[i] = namesList.get(i);
		}
		comboBox.setModel(new DefaultComboBoxModel<String>(arrayNames));
		AutoCompletition.enable(comboBox, arrayNames);
	}

	/**
	 * Ajabnoor 20.1.2020
	 * 
	 * @param e
	 * @throws ClassNotFoundException
	 */
	protected void onOkClick(ActionEvent e) throws ClassNotFoundException {

		Daoanmelden login = new Daoanmelden();

		if (textFieldNameInput.getText().trim().equals("")
				&& String.valueOf(textFieldPasswordInput.getPassword()).equals("")) {
			JOptionPane.showMessageDialog(this, "Bitte fühlen Sie die Felder ein");
			return;
		}

		if (!radioButtonGeschftfhrer.isSelected() && !radioButtonMitarbeiter.isSelected()) {
			JOptionPane.showMessageDialog(this, "Bitte einen von den Oberen Knöpfe auswählen");
			return;
		}

		System.out.println(textFieldNameInput.getText());
		System.out.println(String.valueOf(textFieldPasswordInput.getPassword()));

		if (radioButtonGeschftfhrer.isSelected() && login.loginBoss(textFieldNameInput.getText(),
				String.valueOf(textFieldPasswordInput.getPassword()))) {
			GeschaeftDB.getInstance().setCurrentAccountName(textFieldNameInput.getText());
			JFrameMain JFrameOK = new JFrameMain();
			Utils.startNewJFrame(this, JFrameOK);
			System.out.println("" + textFieldNameInput.getText());
			return;
		}

		if (radioButtonMitarbeiter.isSelected() && mitarbeiterEinlogen.mitarbeitereinlogen(textFieldNameInput.getText(),
				String.valueOf(textFieldPasswordInput.getPassword()), comboBox.getSelectedItem().toString())) {
			GeschaeftDB.getInstance().setCurrentAccountName(comboBox.getSelectedItem().toString());
			JFrameMain JFrameOK = new JFrameMain();
			Utils.startNewJFrame(this, JFrameOK);

		} else {
			JOptionPane.showMessageDialog(this, "Bitte geben Sie den richtigen Name und Password ein");
		}
	}

	protected void onBack(ActionEvent arg0) throws ClassNotFoundException {
		JFrameStart JFrameBack = new JFrameStart();
		Utils.reviewOldJFrame(this, JFrameBack);
	}
}
