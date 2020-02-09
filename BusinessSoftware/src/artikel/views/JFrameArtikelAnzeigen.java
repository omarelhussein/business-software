package artikel.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import general.code.Utils;
import general.design.Colors;
import general.design.Fonts;
import general.design.Unicodes;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.SwingConstants;

public class JFrameArtikelAnzeigen extends JFrame {

	private JPanel contentPane;
	private JLabel labelArtikelAnzeigen;
	private JButton buttonAnzeigen;
	private JButton buttonSpeichern;
	private JList list;

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
	
	/**
	 * Created by Mohammad 28.01.2020
	 */
	private void initGUI() {
		
		Utils.setMiddleFrameOptions(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Colors.parseColor(Colors.LIGHT_GREY));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			labelArtikelAnzeigen = new JLabel("Liste Artikeln");
			labelArtikelAnzeigen.setHorizontalAlignment(SwingConstants.CENTER);
			labelArtikelAnzeigen.setBounds(148, 11, 151, 31);
			Fonts.setCenturySchoolbookFont(labelArtikelAnzeigen, 18);
			labelArtikelAnzeigen.setForeground(Colors.parseColor(Colors.RED));
			contentPane.add(labelArtikelAnzeigen);
		}
		{
			buttonAnzeigen = new JButton("Anzeigen");
			buttonAnzeigen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					buttonAnzeigenActionPerformed(e);
				}
			});
			buttonAnzeigen.setBounds(481, 527, 97, 25);
			Utils.setStandardButtonOptions(buttonAnzeigen);
			contentPane.add(buttonAnzeigen);
		}
		{
			buttonSpeichern = new JButton(Unicodes.CHECK);
			buttonSpeichern.setBounds(481, 578, 97, 25);
			Utils.setStandardButtonOptions(buttonSpeichern);
			contentPane.add(buttonSpeichern);
		}
		{
			list = new JList();
			list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			list.setForeground(Color.ORANGE);
			list.setBorder(new LineBorder(new Color(0, 0, 0)));
			list.setModel(new AbstractListModel() {
				String[] values = new String[] {"* Lebensmittel:", "1- Banana", "2- Apfel", "3- Kartofel", "* Elktro:", "1- Handys", "2- TV", "3- Laptops"};
				public int getSize() {
					return values.length;
				}
				public Object getElementAt(int index) {
					return values[index];
				}
			});
			list.setBounds(10, 53, 450, 550);
			contentPane.add(list);
		}
	}
	protected void buttonAnzeigenActionPerformed(ActionEvent e) {
	}
}
