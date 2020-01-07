package mitarbeiter;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;

public class JFrameMitarbeiterHinzufuegen extends JFrame {

	private JPanel contentPane;
	private JLabel labelNewLabel;
	private JTextField textField;
	private JLabel labelGeburtsdatum;
	private JTextField textField_1;
	private JLabel labelEmail;
	private JTextField textField_2;
	private JLabel labelGehalt;
	private JTextField textField_3;
	private JLabel labelId;
	private JTextField textField_4;
	private JButton buttonSpeichern;

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
	 */
	public JFrameMitarbeiterHinzufuegen() {
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
			textField = new JTextField();
			textField.setBounds(209, 39, 116, 22);
			contentPane.add(textField);
			textField.setColumns(10);
		}
		{
			labelGeburtsdatum = new JLabel("Geburtsdatum");
			labelGeburtsdatum.setFont(new Font("Century Schoolbook", Font.PLAIN, 21));
			labelGeburtsdatum.setBounds(33, 96, 116, 22);
			contentPane.add(labelGeburtsdatum);
		}
		{
			textField_1 = new JTextField();
			textField_1.setBounds(209, 96, 116, 22);
			contentPane.add(textField_1);
			textField_1.setColumns(10);
		}
		{
			labelEmail = new JLabel("E-Mail");
			labelEmail.setFont(new Font("Century Schoolbook", Font.PLAIN, 21));
			labelEmail.setBounds(39, 151, 110, 19);
			contentPane.add(labelEmail);
		}
		{
			textField_2 = new JTextField();
			textField_2.setBounds(209, 148, 116, 22);
			contentPane.add(textField_2);
			textField_2.setColumns(10);
		}
		{
			labelGehalt = new JLabel("Gehalt");
			labelGehalt.setFont(new Font("Century Schoolbook", Font.PLAIN, 21));
			labelGehalt.setBounds(39, 186, 137, 38);
			contentPane.add(labelGehalt);
		}
		{
			textField_3 = new JTextField();
			textField_3.setBounds(209, 197, 116, 22);
			contentPane.add(textField_3);
			textField_3.setColumns(10);
		}
		{
			labelId = new JLabel("ID");
			labelId.setFont(new Font("Century Schoolbook", Font.PLAIN, 21));
			labelId.setBounds(39, 244, 56, 16);
			contentPane.add(labelId);
		}
		{
			textField_4 = new JTextField();
			textField_4.setBounds(209, 241, 116, 22);
			contentPane.add(textField_4);
			textField_4.setColumns(10);
		}
		{
			buttonSpeichern = new JButton("speichern");
			buttonSpeichern.setFont(new Font("Century Schoolbook", Font.PLAIN, 21));
			buttonSpeichern.setBounds(692, 215, 141, 58);
			contentPane.add(buttonSpeichern);
		}
	}

}
