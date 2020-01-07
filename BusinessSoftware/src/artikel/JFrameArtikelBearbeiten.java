package artikel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class JFrameArtikelBearbeiten extends JFrame {

	private JPanel contentPane;
	private JLabel labelArtikelBearbeiten;
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
					JFrameArtikelBearbeiten frame = new JFrameArtikelBearbeiten();
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
	public JFrameArtikelBearbeiten() {
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
			labelArtikelBearbeiten = new JLabel("Artikel Bearbeiten");
			labelArtikelBearbeiten.setBounds(116, 25, 110, 22);
			contentPane.add(labelArtikelBearbeiten);
		}
		{
			textField = new JTextField();
			textField.setBounds(116, 56, 116, 22);
			contentPane.add(textField);
			textField.setColumns(10);
		}
		{
			textField_1 = new JTextField();
			textField_1.setBounds(116, 94, 116, 22);
			contentPane.add(textField_1);
			textField_1.setColumns(10);
		}
		{
			textField_2 = new JTextField();
			textField_2.setBounds(116, 129, 116, 22);
			contentPane.add(textField_2);
			textField_2.setColumns(10);
		}
		{
			buttonSpeichern = new JButton("Speichern");
			buttonSpeichern.setBounds(116, 183, 97, 25);
			contentPane.add(buttonSpeichern);
		}
	}

}
