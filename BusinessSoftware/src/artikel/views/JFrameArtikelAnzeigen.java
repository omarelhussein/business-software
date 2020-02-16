package artikel.views;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import abteilungen.DaoAbteilung;
import artikel.DaoArtikel;
import artikel.business_classes.Artikel;
import general.code.GeschaeftDB;
import general.code.Utils;
import general.design.Colors;
import general.design.Fonts;
import general.design.Unicodes;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class JFrameArtikelAnzeigen extends JFrame {

	private JPanel contentPane;
	private JLabel labelArtikelAnzeigen;
	private JList<Object> list;
	private JButton buttonAnzeigen;
	private JButton buttonSpeichern;
	private JScrollPane scrollPane;
	
	private Artikel[] artikelList;
	private DaoArtikel daoArtikel;
	private JComboBox comboBox;
	private DaoAbteilung daoAbteilung;
	private Artikel[] value = new Artikel[] {};
	Artikel artikel;
	private JLabel lblNewLabel;
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
		artikel=new Artikel();
		daoArtikel = new DaoArtikel();
		daoAbteilung = new DaoAbteilung();
		initGUI();
	}

	private void initGUI() {

		Utils.setSmallFrameOptions(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Colors.parseColor(Colors.LIGHT_GREY));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			labelArtikelAnzeigen = new JLabel("Liste Artikeln");
			labelArtikelAnzeigen.setBounds(10, 11, 151, 31);
			Fonts.setCenturySchoolbookFont(labelArtikelAnzeigen, 18);
			labelArtikelAnzeigen.setForeground(Colors.parseColor(Colors.SEXY_BLUE));
			contentPane.add(labelArtikelAnzeigen);
		}
		{
			comboBox = new JComboBox();
			comboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					do_comboBox_actionPerformed(arg0);
				}
			});
			comboBox.setModel(new DefaultComboBoxModel(daoAbteilung.Abteilungen(GeschaeftDB.getInstance().getCurrentAccountName())));
			comboBox.setBounds(277, 42, 83, 21);
			contentPane.add(comboBox);
		}

		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 44, 257, 306);
			contentPane.add(scrollPane);
			{
				list = new JList<>();
				scrollPane.setViewportView(list);
				List<Artikel> artikeln = daoArtikel.artikelLaden(comboBox.getSelectedItem().toString());
				artikelList = arrayListToArray(artikeln);
				list.setModel(new AbstractListModel<Object>() {
					String[] values = loadArtikelNames(artikelList);

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
			buttonAnzeigen = new JButton("Anzeigen");
			buttonAnzeigen.setBounds(277, 289, 97, 25);
			Utils.setStandardButtonOptions(buttonAnzeigen);
			contentPane.add(buttonAnzeigen);
		}
		{
			buttonSpeichern = new JButton(Unicodes.CHECK);
			buttonSpeichern.setBounds(277, 325, 97, 25);
			Utils.setStandardButtonOptions(buttonSpeichern);
			contentPane.add(buttonSpeichern);
		}
		{
			lblNewLabel = new JLabel("New label");
			lblNewLabel.setForeground(Color.BLUE);
			lblNewLabel.setFont(new Font("Lucida Sans", Font.PLAIN, 11));
			lblNewLabel.setBounds(289, 106, 46, 14);
			lblNewLabel.setText(daoArtikel.nameKategorie(comboBox.getSelectedItem().toString()));
			contentPane.add(lblNewLabel);
		}
	}


	private String[] loadArtikelNames(Artikel[] artikels) {
		String[] artikelNames = new String[artikels.length];
		for (int i = 0; i < artikels.length; i++) {
			artikelNames[i] = artikels[i].getNameArtikel();
		}
		return artikelNames;
	}
	
	
	private Artikel[] arrayListToArray(List<Artikel> artikelList) {
		Artikel[] artikelArray = new Artikel[artikelList.size()];
		for (int i = 0; i < artikelList.size(); i++) {
			artikelArray[i] = artikelList.get(i);
		}
		return artikelArray;
	}
	
	protected void do_comboBox_actionPerformed(ActionEvent arg0) {
		onItemSelected();
		
	}
	private ArrayList<String> arrayToArrayList(Object[] array) {
		ArrayList<String> arrayList = new ArrayList<String>();
		for (int i = 0; i < value.length; i++) {
			arrayList.add(value[i].getNameArtikel());
		}
		return arrayList;
	}
	/**
	 * @author Aref
	 */
	private void onItemSelected() {
		String abteilungName = String.valueOf(comboBox.getSelectedItem());
		artikel.setNameArtikel(daoArtikel.nameKategorie(comboBox.getSelectedItem().toString()));
		lblNewLabel.setText(daoArtikel.nameKategorie(comboBox.getSelectedItem().toString()));
		
		value =arrayListToArray(daoArtikel.artikelLaden(abteilungName)) ;
		Utils.updateList(list, true, scrollPane, arrayToArrayList(value));
	}
}
