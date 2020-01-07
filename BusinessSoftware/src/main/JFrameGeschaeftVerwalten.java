package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import general.Utils;
import start.JFrameAnmelden;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFrameGeschaeftVerwalten extends JFrame {

	private JPanel contentPane;
	private JLabel labelNewLabel;
	private JTextField textField;
	private JLabel labelAbteilungAnzeigen;
	private JTextField textField_1;
	private JLabel labelAllgemeineDaten;
	private JTextField textField_2;
	private JLabel labelAllgemeineDatenVerwalten;
	private JTextField textField_3;
	private JButton buttonNewButton;
	private JButton buttonZurck;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameGeschaeftVerwalten frame = new JFrameGeschaeftVerwalten();
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
	public JFrameGeschaeftVerwalten() {
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Utils.setMainFrameOptions(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			labelNewLabel = new JLabel("Mitarbeiter Anzeigen");
			labelNewLabel.setFont(new Font("Century Schoolbook", Font.PLAIN, 20));
			labelNewLabel.setBounds(49, 43, 211, 63);
			contentPane.add(labelNewLabel);
		}
		{
			textField = new JTextField();
			textField.setBounds(59, 130, 211, 41);
			contentPane.add(textField);
			textField.setColumns(10);
		}
		{
			labelAbteilungAnzeigen = new JLabel("Artikel Anzeigen");
			labelAbteilungAnzeigen.setFont(new Font("Century Schoolbook", Font.PLAIN, 20));
			labelAbteilungAnzeigen.setBounds(365, 43, 211, 63);
			contentPane.add(labelAbteilungAnzeigen);
		}
		{
			textField_1 = new JTextField();
			textField_1.setBounds(365, 130, 211, 41);
			contentPane.add(textField_1);
			textField_1.setColumns(10);
		}
		{
			labelAllgemeineDaten = new JLabel("Allgemeine Daten ");
			labelAllgemeineDaten.setFont(new Font("Century Schoolbook", Font.PLAIN, 20));
			labelAllgemeineDaten.setBounds(61, 252, 199, 25);
			contentPane.add(labelAllgemeineDaten);
		}
		{
			textField_2 = new JTextField();
			textField_2.setBounds(59, 318, 201, 31);
			contentPane.add(textField_2);
			textField_2.setColumns(10);
		}
		{
			labelAllgemeineDatenVerwalten = new JLabel("Allgemeine Daten Verwalten");
			labelAllgemeineDatenVerwalten.setFont(new Font("Century Schoolbook", Font.PLAIN, 20));
			labelAllgemeineDatenVerwalten.setBounds(365, 259, 296, 41);
			contentPane.add(labelAllgemeineDatenVerwalten);
		}
		{
			textField_3 = new JTextField();
			textField_3.setBounds(365, 322, 268, 41);
			contentPane.add(textField_3);
			textField_3.setColumns(10);
		}
		{
			buttonNewButton = new JButton("Abteilung bearbeiten");
			buttonNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
			buttonNewButton.setBounds(588, 65, 199, 41);
			contentPane.add(buttonNewButton);
		}
		{
			buttonZurck = new JButton("Zur\u00FCck");
			buttonZurck.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					onBack(e);
				}
			});
			buttonZurck.setBounds(79, 384, 97, 25);
			contentPane.add(buttonZurck);
		}
	}
	protected void onBack(ActionEvent e) {
	JFrameAnmelden JFrameBack = new JFrameAnmelden();
	Utils.reviewOldJFrame(this, JFrameBack);
	}
	
}
