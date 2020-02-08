package mitarbeiter.views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import general.code.Utils;
import general.design.Colors;
import general.design.Fonts;
import general.design.Unicodes;

public class JFrameMitarbeiterAnzeigen extends JFrame {

	private JPanel contentPane;
	private JList list;
	private JLabel labelListeMitarbeiter;
	private JButton buttonAnzeigen;
	private JScrollPane scrollPane;
	private JButton button;
	private String[] values = new String[]{ "Ajab", "Omri", "Arefi", "Muhammadi" };
	private JPanel panel;

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

		Utils.setSmallFrameOptions(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Colors.parseColor(Colors.LIGHT_GREY));
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 49, 257, 301);
			contentPane.add(scrollPane);
			{
				list = new JList();
				scrollPane.setViewportView(list);
				
				list.setModel(new AbstractListModel() {
					public int getSize() {
						return values.length;
					}

					public Object getElementAt(int index) {
						return values[index];
					}
				});
			}
		}
		{
			labelListeMitarbeiter = new JLabel("Liste Mitarbeiter");
			labelListeMitarbeiter.setBounds(10, 11, 255, 33);
			Fonts.setCenturySchoolbookFont(labelListeMitarbeiter, 18);
			labelListeMitarbeiter.setForeground(Colors.parseColor(Colors.SEXY_BLUE));
			contentPane.add(labelListeMitarbeiter);
		}
		{
			buttonAnzeigen = new JButton("Anzeigen");
			Utils.setStandardButtonOptions(buttonAnzeigen);
			buttonAnzeigen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					onAnzeigen(arg0);
				}
			});
			buttonAnzeigen.setBounds(275, 280, 100, 25);
			contentPane.add(buttonAnzeigen);
		}
		{
			button = new JButton(Unicodes.CHECK);
			button.setBounds(275, 320, 100, 25);
			Utils.setStandardButtonOptions(button);
			contentPane.add(button);
		}
		{
			panel = new JPanel();
			panel.setBounds(277, 49, 129, 200);
			contentPane.add(panel);
		}
	}
	
	/**
	 Created by Mohammad 18.01.2020
	 */

	protected void onAnzeigen(ActionEvent arg0) {
		int selectedindex = list.getSelectedIndex();
		String name = values [selectedindex];
		JFrameMitarbeiterProfile mitarbeiterProfil = new JFrameMitarbeiterProfile(name);
		mitarbeiterProfil.setVisible(true);
	}
}
