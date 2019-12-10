package start;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import general.Utils;

import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFrameMitarbeiterAnzeigen extends JFrame {

	private JPanel contentPane;
	private JList list;
	private JLabel labelListeMitarbeiter;
	private JButton buttonAnzeigen;
	private JButton buttonBearbeiten;
	private JButton buttonFertig;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameMitarbeiterAnzeigen frame = new JFrameMitarbeiterAnzeigen();
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
	public JFrameMitarbeiterAnzeigen() {
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
			list = new JList();
			list.setModel(new AbstractListModel() {
				String[] values = new String[] {"Z.B ", "Ajab", "Omri", "Arefi", "Muhammadi"};
				public int getSize() {
					return values.length;
				}
				public Object getElementAt(int index) {
					return values[index];
				}
			});
			list.setBounds(56, 49, 239, 325);
			contentPane.add(list);
		}
		{
			labelListeMitarbeiter = new JLabel("Liste Mitarbeiter");
			labelListeMitarbeiter.setBounds(63, 13, 129, 33);
			contentPane.add(labelListeMitarbeiter);
		}
		{
			buttonAnzeigen = new JButton("Anzeigen");
			buttonAnzeigen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					onAnzeigen(arg0);
				}
			});
			buttonAnzeigen.setBounds(397, 46, 97, 25);
			contentPane.add(buttonAnzeigen);
		}
		{
			buttonBearbeiten = new JButton("Bearbeiten");
			buttonBearbeiten.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					buttonBearbeitenActionPerformed(e);
				}
			});
			buttonBearbeiten.setBounds(397, 129, 97, 25);
			contentPane.add(buttonBearbeiten);
		}
		{
			buttonFertig = new JButton("Fertig");
			buttonFertig.setBounds(454, 364, 97, 25);
			contentPane.add(buttonFertig);
		}
	}
	protected void onAnzeigen(ActionEvent arg0) {
		JFrameMitarbeiterAnzeigenButtonGeklikt JFrame = new JFrameMitarbeiterAnzeigenButtonGeklikt();
		Utils.startNewJFrame(this, JFrame);
		
		
	}
	protected void buttonBearbeitenActionPerformed(ActionEvent e) {
		JFrameDatenAnzeigenBearbeiten JFrame = new JFrameDatenAnzeigenBearbeiten();
		Utils.startNewJFrame(this, JFrame);
	}
	
}
