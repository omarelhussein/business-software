package abteilungen;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import general.Colors;
import general.Fonts;
import general.Unicodes;
import general.Utils;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class JFrameAbteilungVerarbeiten extends JFrame {

	private JPanel contentPane;
	private JList<String> list;
	private JButton button_show_abteilung_artikeln;
	private JButton button_show_abteilung_mitarbeitern;
	private JLabel labelAbteilungBearbeitung;
	private JScrollPane scrollPane;
	private JButton button_abteilung_verarbeiten_check;

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
		this.setBounds(0, 0, 400, 400);
		Utils.setDefaultFrameOptions(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{

		}
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 66, 210, 284);
		contentPane.add(scrollPane);

		list = new JList();
		scrollPane.setViewportView(list);
		list.setBorder(new LineBorder(Color.LIGHT_GRAY));
		list.setFont(new Font("Century Schoolbook", Font.PLAIN, 20));
		list.setModel(new AbstractListModel<String>() {
			ArrayList<String> values = new ArrayList<String>();

			public int getSize() {
				return values.size();
			}

			public String getElementAt(int index) {
				return values.get(index);
			}
		});

		button_show_abteilung_artikeln = new JButton("Artikel");
		Fonts.setCenturySchoolbookFont(button_show_abteilung_artikeln, 14);
		button_show_abteilung_artikeln.setBounds(230, 66, 143, 44);
		Utils.setStandardButtonOptions(button_show_abteilung_artikeln);
		contentPane.add(button_show_abteilung_artikeln);

		button_show_abteilung_mitarbeitern = new JButton("Mitarbeiter");
		Fonts.setCenturySchoolbookFont(button_show_abteilung_mitarbeitern, 14);
		button_show_abteilung_mitarbeitern.setBounds(230, 132, 143, 44);
		Utils.setStandardButtonOptions(button_show_abteilung_mitarbeitern);
		contentPane.add(button_show_abteilung_mitarbeitern);

		labelAbteilungBearbeitung = new JLabel("Abteilung bearbeiten");
		labelAbteilungBearbeitung.setHorizontalAlignment(SwingConstants.CENTER);
		Fonts.setCenturySchoolbookFont(labelAbteilungBearbeitung, 20);
		labelAbteilungBearbeitung.setForeground(Colors.parseColor(Colors.SEXY_BLUE));
		labelAbteilungBearbeitung.setBounds(10, 11, 363, 44);
		contentPane.add(labelAbteilungBearbeitung);
		
		button_abteilung_verarbeiten_check = new JButton(Unicodes.CHECK);
		button_abteilung_verarbeiten_check.setBounds(284, 327, 89, 23);
		Utils.setStandardButtonOptions(button_abteilung_verarbeiten_check);
		contentPane.add(button_abteilung_verarbeiten_check);
	}

}
