package start;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import general.Colors;
import general.Utils;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class JFrameAnmelden extends JFrame {

	
	private JPanel contentPane;
	private JLabel labelMeldenSieBitte;
	private JLabel labelBenutzerName;
	private JTextField textField;
	private JLabel labelPasswort;
	private JTextField textField_1;
	private JButton buttonOk;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameAnmelden frame = new JFrameAnmelden();
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
	public JFrameAnmelden() {
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Utils.setMainFrameOptions(this);
		contentPane = new JPanel();
		contentPane.setBackground(Color.decode(Colors.LIGHT_YELLOW));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			labelMeldenSieBitte = new JLabel("Melden Sie bitte an ");
			labelMeldenSieBitte.setForeground(Color.BLACK);
			labelMeldenSieBitte.setFont(new Font("Century Schoolbook", Font.PLAIN, 21));
			labelMeldenSieBitte.setBounds(262, 44, 284, 55);
			contentPane.add(labelMeldenSieBitte);
		}
		{
			labelBenutzerName = new JLabel("Benutzer name");
			labelBenutzerName.setFont(new Font("Century Schoolbook", Font.PLAIN, 21));
			labelBenutzerName.setBounds(116, 126, 195, 55);
			contentPane.add(labelBenutzerName);
		}
		{
			textField = new JTextField();
			textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
			textField.setBounds(356, 126, 229, 55);
			contentPane.add(textField);
			textField.setColumns(10);
		}
		{
			labelPasswort = new JLabel("Password");
			labelPasswort.setFont(new Font("Century Schoolbook", Font.PLAIN, 21));
			labelPasswort.setBounds(116, 232, 206, 55);
			contentPane.add(labelPasswort);
		}
		{
			textField_1 = new JTextField();
			textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
			textField_1.setBounds(356, 237, 229, 50);
			contentPane.add(textField_1);
			textField_1.setColumns(10);
		}
		{
			buttonOk = new JButton("OK");
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
			buttonOk.setBounds(611, 327, 97, 25);
			contentPane.add(buttonOk);
		}
	}
	protected void onOkClick(ActionEvent e) throws ClassNotFoundException {
		JFrameGeschaeftVerwalten JFrameOK = new JFrameGeschaeftVerwalten() ;
		Utils.startNewJFrame(this,JFrameOK );
		Daomelden daomelden=new Daomelden();
		daomelden.insert();
	}
}
