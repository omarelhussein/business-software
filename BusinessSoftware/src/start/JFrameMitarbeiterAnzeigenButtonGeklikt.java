package start;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class JFrameMitarbeiterAnzeigenButtonGeklikt extends JFrame {

	private JPanel contentPane;
	private JLabel labelDaten;
	private JButton buttonSpeichern;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameMitarbeiterAnzeigenButtonGeklikt frame = new JFrameMitarbeiterAnzeigenButtonGeklikt();
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
	public JFrameMitarbeiterAnzeigenButtonGeklikt() {
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
			labelDaten = new JLabel("Daten");
			labelDaten.setBounds(156, 13, 56, 16);
			contentPane.add(labelDaten);
		}
		{
			buttonSpeichern = new JButton("Speichern");
			buttonSpeichern.setBounds(125, 204, 97, 25);
			contentPane.add(buttonSpeichern);
		}
		{
			textField = new JTextField();
			textField.setBounds(106, 53, 116, 22);
			contentPane.add(textField);
			textField.setColumns(10);
		}
		{
			textField_1 = new JTextField();
			textField_1.setBounds(106, 87, 116, 22);
			contentPane.add(textField_1);
			textField_1.setColumns(10);
		}
		{
			textField_2 = new JTextField();
			textField_2.setBounds(106, 135, 116, 22);
			contentPane.add(textField_2);
			textField_2.setColumns(10);
		}
	}
}
