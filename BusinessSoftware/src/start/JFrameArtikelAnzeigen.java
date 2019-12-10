package start;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import general.Utils;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFrameArtikelAnzeigen extends JFrame {

	private JPanel contentPane;
	private JLabel labelArtikelAnzeigen;
	private JList list;
	private JButton buttonAnzeigen;
	private JButton buttonNewButton;
	private JButton buttonSpeichern;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameArtikelAnzeigen frame = new JFrameArtikelAnzeigen();
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
	public JFrameArtikelAnzeigen() {
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
			labelArtikelAnzeigen = new JLabel("Artikel Anzeigen");
			labelArtikelAnzeigen.setBounds(72, 13, 151, 31);
			contentPane.add(labelArtikelAnzeigen);
		}
		{
			list = new JList();
			list.setModel(new AbstractListModel() {
				String[] values = new String[] {"Banana", "Appfel"};
				public int getSize() {
					return values.length;
				}
				public Object getElementAt(int index) {
					return values[index];
				}
			});
			list.setBounds(59, 70, 272, 301);
			contentPane.add(list);
		}
		{
			buttonAnzeigen = new JButton("Anzeigen");
			buttonAnzeigen.setBounds(401, 67, 97, 25);
			contentPane.add(buttonAnzeigen);
		}
		{
			buttonNewButton = new JButton("Bearbeiten");
			buttonNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					buttonNewButtonActionPerformed(arg0);
				}
			});
			buttonNewButton.setBounds(401, 193, 97, 25);
			contentPane.add(buttonNewButton);
		}
		{
			buttonSpeichern = new JButton("Speichern");
			buttonSpeichern.setBounds(401, 320, 97, 25);
			contentPane.add(buttonSpeichern);
		}
	}

	protected void buttonNewButtonActionPerformed(ActionEvent arg0) {
	}
}
