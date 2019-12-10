package start;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class JFrameDatenAnzeigenBearbeiten extends JFrame {

	private JPanel contentPane;
	private JLabel labelDatenbearbeiten;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton buttonSpeichern;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameDatenAnzeigenBearbeiten frame = new JFrameDatenAnzeigenBearbeiten();
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
	public JFrameDatenAnzeigenBearbeiten() {
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			labelDatenbearbeiten = new JLabel("Datenbearbeiten");
			labelDatenbearbeiten.setBounds(157, 28, 131, 28);
			contentPane.add(labelDatenbearbeiten);
		}
		{
			textField = new JTextField();
			textField.setBounds(157, 80, 116, 22);
			contentPane.add(textField);
			textField.setColumns(10);
		}
		{
			textField_1 = new JTextField();
			textField_1.setBounds(157, 115, 116, 22);
			contentPane.add(textField_1);
			textField_1.setColumns(10);
		}
		{
			textField_2 = new JTextField();
			textField_2.setBounds(157, 150, 116, 22);
			contentPane.add(textField_2);
			textField_2.setColumns(10);
		}
		{
			buttonSpeichern = new JButton("Speichern");
			buttonSpeichern.setBounds(157, 215, 97, 25);
			contentPane.add(buttonSpeichern);
		}
	}

}
