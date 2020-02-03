package start.login.views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
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

import general.code.GeschaeftDB;
import general.code.Utils;
import general.design.Colors;
import general.design.Unicodes;
import main.business_classes.Geschaeft;
import main.views.JFrameMain;
import mitarbeiter.dao.DaoMitarbeiter;
import start.login.dao.Daoanmelden;
import start.register.views.JFrameRegistrieren;
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
	private JLabel labelNewLabel;
	private JLabel label;
	private JButton buttonForgotPassword;
	private JRadioButton radioButtonMitarbeiter;
	private JRadioButton radioButtonGeschftfhrer;
	private final ButtonGroup buttonGroup = new ButtonGroup();

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
	 */
	public JFrameAnmelden() {
		initGUI();
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
				labelBenutzerName.setBounds(50, 62, 206, 55);
				panel.add(labelBenutzerName);
				labelBenutzerName.setFont(new Font("Century Schoolbook", Font.PLAIN, 21));
			}
			{
				labelPasswort = new JLabel("Passwort");
				labelPasswort.setBounds(50, 175, 206, 55);
				panel.add(labelPasswort);
				labelPasswort.setFont(new Font("Century Schoolbook", Font.PLAIN, 21));
			}
			{
				textFieldNameInput = new JTextField();
				textFieldNameInput.setBounds(268, 70, 497, 41);
				panel.add(textFieldNameInput);
				textFieldNameInput.setFont(new Font("Tahoma", Font.PLAIN, 18));
				textFieldNameInput.setColumns(10);
			}
			{
				{
					{
						textFieldPasswordInput = new JPasswordField();
						textFieldPasswordInput.setFont(new Font("Tahoma", Font.PLAIN, 18));
						textFieldPasswordInput.setBounds(267, 183, 497, 41);
						panel.add(textFieldPasswordInput);
					}
				}
			}
			{
				labelNewLabel = new JLabel("some instructions to show here");
				labelNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
				labelNewLabel.setBounds(277, 122, 487, 26);
				panel.add(labelNewLabel);
			}
			{
				label = new JLabel("some instructions to show here");
				label.setFont(new Font("Tahoma", Font.PLAIN, 12));
				label.setBounds(277, 235, 487, 26);
				panel.add(label);
			}
			{
				buttonForgotPassword = new JButton("Passwort vergessen? ");
				buttonForgotPassword.setBounds(579, 272, 185, 41);
				buttonForgotPassword.setBackground(Colors.parseColor("#00FFFFFF"));
				buttonForgotPassword.setForeground(Colors.parseColor(Colors.SEXY_BLUE));
				panel.add(buttonForgotPassword);
			}
			{
				radioButtonMitarbeiter = new JRadioButton("Mitarbeiter");
				radioButtonMitarbeiter.setContentAreaFilled(false);
				buttonGroup.add(radioButtonMitarbeiter);
				radioButtonMitarbeiter.setBounds(267, 28, 199, 25);
				panel.add(radioButtonMitarbeiter);
			}
			{
				radioButtonGeschftfhrer = new JRadioButton("Gesch\u00E4ftsf\u00FChrer");
				radioButtonGeschftfhrer.setContentAreaFilled(false);
				buttonGroup.add(radioButtonGeschftfhrer);
				radioButtonGeschftfhrer.setBounds(560, 28, 127, 25);
				panel.add(radioButtonGeschftfhrer);
			}
		}
		buttonZurck = new JButton(Unicodes.BACK_ARROW);
		buttonZurck.setBounds(24, 484, 246, 46);
		Utils.setStandardButtonOptions(buttonZurck);
		contentPane.add(buttonZurck);
		buttonZurck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				onBack(arg0);
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

		if (login.loginBoss(textFieldNameInput.getText(), String.valueOf(textFieldPasswordInput.getPassword()))
				&& radioButtonGeschftfhrer.isSelected()) {
			GeschaeftDB.getInstance().setCurrentAccountName(textFieldNameInput.getText());
			JFrameMain JFrameOK = new JFrameMain();
			Utils.startNewJFrame(this, JFrameOK);
			System.out.println("" + textFieldNameInput.getText());
			return;
		}

		DaoMitarbeiter mitarbeiterEinlogen = new DaoMitarbeiter();

		if (mitarbeiterEinlogen.mitarbeitereinlogen(textFieldNameInput.getText(),
				String.valueOf(textFieldPasswordInput.getPassword())) && radioButtonMitarbeiter.isSelected()) {
			JFrameMain JFrameOK = new JFrameMain();
			Utils.startNewJFrame(this, JFrameOK);
		} else {
			JOptionPane.showMessageDialog(this, "Bitte geben Sie den richtigen Name und Password ein");
		}
	}

	protected void onBack(ActionEvent arg0) {
		JFrameStart JFrameBack = new JFrameStart();
		Utils.reviewOldJFrame(this, JFrameBack);
	}

}
