package start;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import general.Utils;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class JFrameAbteilunghinzufuegen extends JFrame {

	private JPanel contentPane;
	private JLabel labelNewLabel;
	private JButton buttonHinzufgen;
	private JButton buttonFertig;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameAbteilunghinzufuegen frame = new JFrameAbteilunghinzufuegen();
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
	public JFrameAbteilunghinzufuegen() {
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Utils.setOriginalBackgroundSize(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			labelNewLabel = new JLabel("Abteilung");
			labelNewLabel.setFont(new Font("Century Schoolbook", Font.PLAIN, 24));
			labelNewLabel.setBounds(240, 31, 142, 50);
			contentPane.add(labelNewLabel);
		}
		{
			buttonHinzufgen = new JButton("Hinzuf\u00FCgen");
			buttonHinzufgen.setFont(new Font("Century Schoolbook", Font.PLAIN, 20));
			buttonHinzufgen.setBounds(65, 329, 174, 50);
			contentPane.add(buttonHinzufgen);
		}
		{
			buttonFertig = new JButton("Fertig");
			buttonFertig.setFont(new Font("Century Schoolbook", Font.PLAIN, 20));
			buttonFertig.setBounds(550, 345, 163, 34);
			contentPane.add(buttonFertig);
		}
		{
			comboBox = new JComboBox();
			comboBox.setFont(new Font("Century Schoolbook", Font.PLAIN, 20));
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"Lebensmittel", "Elektronik"}));
			comboBox.setBounds(218, 154, 251, 50);
			contentPane.add(comboBox);
		}
	}
}
