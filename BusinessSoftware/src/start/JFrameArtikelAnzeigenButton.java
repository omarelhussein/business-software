package start;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class JFrameArtikelAnzeigenButton extends JFrame {

	private JPanel contentPane;
	private JLabel labelArtikel;
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
					JFrameArtikelAnzeigenButton frame = new JFrameArtikelAnzeigenButton();
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
	public JFrameArtikelAnzeigenButton() {
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
			labelArtikel = new JLabel("Artikel");
			labelArtikel.setBounds(167, 27, 56, 16);
			contentPane.add(labelArtikel);
		}
		{
			textField = new JTextField();
			textField.setBounds(132, 56, 116, 22);
			contentPane.add(textField);
			textField.setColumns(10);
		}
		{
			textField_1 = new JTextField();
			textField_1.setBounds(132, 102, 116, 22);
			contentPane.add(textField_1);
			textField_1.setColumns(10);
		}
		{
			textField_2 = new JTextField();
			textField_2.setBounds(132, 137, 116, 22);
			contentPane.add(textField_2);
			textField_2.setColumns(10);
		}
		{
			buttonSpeichern = new JButton("Speichern");
			buttonSpeichern.setBounds(132, 203, 97, 25);
			contentPane.add(buttonSpeichern);
		}
	}

}
