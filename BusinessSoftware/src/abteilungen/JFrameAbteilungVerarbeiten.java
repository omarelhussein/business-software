package abteilungen;

import javax.swing.*;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import general.Utils;

import java.awt.Font;

public class JFrameAbteilungVerarbeiten extends JFrame {

	private JPanel contentPane;
	private JList list;
	private JButton buttonNewButton;
	private JButton buttonNewButton_1;
	private JButton buttonNewButton_2;
	private JLabel labelAbteilungBearbeitung;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameAbteilungVerarbeiten frame = new JFrameAbteilungVerarbeiten();
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
	public JFrameAbteilungVerarbeiten() {
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
		
		}
		
		list = new JList();
		list.setFont(new Font("Century Schoolbook", Font.PLAIN, 20));
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Lebensmittel", "Elektronik"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(86, 110, 190, 95);
		contentPane.add(list);
		
		buttonNewButton = new JButton("Artikel");
		buttonNewButton.setFont(new Font("Century Schoolbook", Font.PLAIN, 20));
		buttonNewButton.setBounds(398, 101, 190, 44);
		contentPane.add(buttonNewButton);
		
		buttonNewButton_1 = new JButton("Mitarbeiter");
		buttonNewButton_1.setFont(new Font("Century Schoolbook", Font.PLAIN, 21));
		buttonNewButton_1.setBounds(398, 171, 190, 44);
		contentPane.add(buttonNewButton_1);
		
		buttonNewButton_2 = new JButton("Fertig");
		buttonNewButton_2.setFont(new Font("Century Schoolbook", Font.PLAIN, 18));
		buttonNewButton_2.setBounds(656, 338, 97, 25);
		contentPane.add(buttonNewButton_2);
		
		labelAbteilungBearbeitung = new JLabel("Abteilung Bearbeitung");
		labelAbteilungBearbeitung.setFont(new Font("Century Schoolbook", Font.PLAIN, 22));
		labelAbteilungBearbeitung.setBounds(272, 36, 271, 31);
		contentPane.add(labelAbteilungBearbeitung);
	}

}
