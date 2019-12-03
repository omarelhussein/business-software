package start;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFrameStartDeinGeschaeft extends JFrame {

	private JPanel contentPane;
	private JLabel labelGeschftErstellen;
	private JLabel labelName;
	private JTextField textField;
	private JLabel labelAbteilungen;
	private JButton buttonNewButton;
	private JButton buttonNewButton_1;
	private JButton buttonNewButton_2;
	private JButton buttonErstellen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameStartDeinGeschaeft frame = new JFrameStartDeinGeschaeft();
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
	public JFrameStartDeinGeschaeft() {
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 893, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			labelGeschftErstellen = new JLabel("Gesch\u00E4ft erstellen ");
			labelGeschftErstellen.setFont(new Font("Century Schoolbook", Font.PLAIN, 21));
			labelGeschftErstellen.setBounds(238, 33, 263, 85);
			contentPane.add(labelGeschftErstellen);
		}
		{
			labelName = new JLabel("Name");
			labelName.setFont(new Font("Century Schoolbook", Font.PLAIN, 21));
			labelName.setBounds(102, 138, 109, 48);
			contentPane.add(labelName);
		}
		{
			textField = new JTextField();
			textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
			textField.setBounds(256, 150, 295, 48);
			contentPane.add(textField);
			textField.setColumns(10);
		}
		{
			labelAbteilungen = new JLabel("Abteilungen");
			labelAbteilungen.setFont(new Font("Century Schoolbook", Font.PLAIN, 21));
			labelAbteilungen.setBounds(83, 278, 128, 42);
			contentPane.add(labelAbteilungen);
		}
		{
			buttonNewButton = new JButton("Lebensmittel");
			buttonNewButton.setFont(new Font("Century Schoolbook", Font.PLAIN, 18));
			buttonNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					buttonNewButtonActionPerformed(arg0);
				}
			});
			buttonNewButton.setBounds(246, 273, 305, 48);
			contentPane.add(buttonNewButton);
		}
		{
			buttonNewButton_1 = new JButton("Elektronic");
			buttonNewButton_1.setFont(new Font("Century Schoolbook", Font.PLAIN, 18));
			buttonNewButton_1.setBounds(249, 343, 302, 48);
			contentPane.add(buttonNewButton_1);
		}
		{
			buttonNewButton_2 = new JButton("+");
			buttonNewButton_2.setFont(new Font("Century Schoolbook", Font.PLAIN, 23));
			buttonNewButton_2.setBounds(579, 277, 54, 42);
			contentPane.add(buttonNewButton_2);
		}
		{
			buttonErstellen = new JButton("Erstellen");
			buttonErstellen.setFont(new Font("Century Schoolbook", Font.PLAIN, 18));
			buttonErstellen.setBounds(682, 419, 144, 31);
			contentPane.add(buttonErstellen);
		}
	}
	protected void buttonNewButtonActionPerformed(ActionEvent arg0) {
	}
}
