package artikel.views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import abteilungen.DaoAbteilung;
import artikel.DaoArtikel;
import artikel.business_classes.Artikel;
import general.code.GeschaeftDB;
import general.code.Utils;
import general.design.Colors;
import general.design.Fonts;
import general.design.Unicodes;

@SuppressWarnings("serial")
public class JFrameArtikelAnzeigen extends JFrame {

	private JPanel contentPane;
	private JLabel labelArtikelAnzeigen;
	private JScrollPane scrollPane;
	
	private Artikel[] artikelList;
	private DaoArtikel daoArtikel;
	private JComboBox<String> comboBoxAbteilung;
	private DaoAbteilung daoAbteilung;
	private JButton buttonAnzeigen;
	private JButton buttonSpeichern;
	private JList<Object> list;
	private JLabel labelNewLabel;
	private JLabel labelKategorieAuswhlen;
	private JComboBox<String> comboBoxKategorie;
	private JTextField textField;
	private JButton button;

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
		daoArtikel = new DaoArtikel();
		daoAbteilung = new DaoAbteilung();
		initGUI();
		
	}
	
	/**
	 * Created by Mohammad 28.01.2020
	 */
	private void initGUI() {
		
		Utils.setSmallFrameOptions(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Colors.parseColor(Colors.LIGHT_GREY));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			labelArtikelAnzeigen = new JLabel("Liste Artikeln");
			labelArtikelAnzeigen.setHorizontalAlignment(SwingConstants.CENTER);
			labelArtikelAnzeigen.setBounds(10, 11, 350, 31);
			Fonts.setCenturySchoolbookFont(labelArtikelAnzeigen, 18);
			labelArtikelAnzeigen.setForeground(Colors.parseColor(Colors.SEXY_BLUE));
			contentPane.add(labelArtikelAnzeigen);
		}
		{
			comboBoxAbteilung = new JComboBox<>();
			comboBoxAbteilung.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					onAbteilungSelected(e);
				}
			});
			comboBoxAbteilung.setBackground(Colors.parseColor(Colors.LIGHT_PINK));
			comboBoxAbteilung.setModel(new DefaultComboBoxModel<>(daoAbteilung.Abteilungen(GeschaeftDB.getInstance().getCurrentAccountName())));
			comboBoxAbteilung.setBounds(240, 121, 135, 21);
			contentPane.add(comboBoxAbteilung);
		}

		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 93, 220, 258);
			contentPane.add(scrollPane);
			{
				list = new JList<>();
				scrollPane.setViewportView(list);
				List<Artikel> artikeln = daoArtikel.artikelLaden(comboBoxAbteilung.getSelectedItem().toString());
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
			buttonAnzeigen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					buttonAnzeigenActionPerformed(e);
				}
			});
			buttonAnzeigen.setBounds(240, 289, 134, 25);
			Utils.setStandardButtonOptions(buttonAnzeigen);
			contentPane.add(buttonAnzeigen);
		}
		{
			buttonSpeichern = new JButton(Unicodes.CHECK);
			buttonSpeichern.setBounds(240, 325, 134, 25);
			Utils.setStandardButtonOptions(buttonSpeichern);
			contentPane.add(buttonSpeichern);
		}
		{
			labelNewLabel = new JLabel("Abteilung ausw\u00E4hlen");
			labelNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			labelNewLabel.setBounds(240, 96, 135, 14);
			contentPane.add(labelNewLabel);
		}
		{
			labelKategorieAuswhlen = new JLabel("Kategorie ausw\u00E4hlen");
			labelKategorieAuswhlen.setHorizontalAlignment(SwingConstants.CENTER);
			labelKategorieAuswhlen.setBounds(240, 153, 135, 14);
			contentPane.add(labelKategorieAuswhlen);
		}
		{
			comboBoxKategorie = new JComboBox<String>();
			comboBoxKategorie.setBackground(new Color(255, 250, 250));
			comboBoxKategorie.setBounds(240, 172, 135, 21);
			contentPane.add(comboBoxKategorie);
		}
		{
			textField = new JTextField();
			textField.setColumns(10);
			textField.setBounds(10, 57, 125, 25);
			contentPane.add(textField);
		}
		{
			button = new JButton("Suchen");
			Utils.setStandardButtonOptions(button);
			button.setBounds(145, 57, 89, 25);
			contentPane.add(button);
		}
	}
	protected void buttonAnzeigenActionPerformed(ActionEvent e) {
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
	
	private ArrayList<String> arrayToArrayList(String[] array) {
		ArrayList<String> listNames = new ArrayList<>();
		for (int i = 0; i < array.length; i++) {
			listNames.add(array[i]);
		}
		return listNames;
	}
	
	protected void onAbteilungSelected(ActionEvent e) {
		String[] values = loadArtikelNames(arrayListToArray(daoArtikel.artikelLaden(comboBoxAbteilung.getSelectedItem().toString())));
		ArrayList<String> valuesList = arrayToArrayList(values);
		Utils.updateList(list, true, scrollPane, valuesList);
	}
}
