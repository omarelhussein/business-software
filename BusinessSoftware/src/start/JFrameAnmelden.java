package start;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import general.Colors;
import general.Unicodes;
import general.Utils;
import main.JFrameGeschaeftVerwalten;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public class JFrameAnmelden extends JFrame {

	
	private JPanel contentPane;
	private JLabel labelMeldenSieBitte;
	private JLabel labelBenutzerName;
	private JTextField textField;
	private JLabel labelPasswort;
	private JButton buttonOk;
	private JButton buttonZurck;
	private JPanel panel;
	private JPasswordField passwordField;
	private JLabel labelNewLabel;
	private JLabel label;
	private JButton buttonForgotPassword;

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
				textField = new JTextField();
				textField.setBounds(267, 70, 497, 41);
				panel.add(textField);
				textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
				textField.setColumns(10);
			}
			{
				{
					{
						passwordField = new JPasswordField();
						passwordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
						passwordField.setBounds(267, 183, 497, 41);
						panel.add(passwordField);
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
		}
		buttonZurck = new JButton(Unicodes.BACK_ARROW);
		buttonZurck.setBounds(24, 484, 246, 46);
		Utils.standardButtonOptions(buttonZurck);
		contentPane.add(buttonZurck);
		buttonZurck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				onBack(arg0);
			}
		});
		buttonOk = new JButton(Unicodes.CHECK);
		buttonOk.setBounds(635, 484, 246, 46);
		Utils.standardButtonOptions(buttonOk);
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
	
	protected void onOkClick(ActionEvent e) throws ClassNotFoundException {
		JFrameGeschaeftVerwalten JFrameOK = new JFrameGeschaeftVerwalten() ;
		Utils.startNewJFrame(this,JFrameOK );
		Daomelden daomelden=new Daomelden();
		//daomelden.insert();
	}
	
	protected void onBack(ActionEvent arg0) {
		JFrameStart JFrameBack = new JFrameStart();
		Utils.reviewOldJFrame(this, JFrameBack);
	}
}
