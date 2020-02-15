package kategorie.views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import general.code.Utils;
import general.design.Colors;
import general.design.Fonts;
import general.design.Unicodes;
import kategorie.dao.DaoKategorie;


@SuppressWarnings("serial")
public class JFrameKategorieHinzufuegen extends JFrame {

	private JPanel contentPane;
	private JLabel labelNewLabel;
	private JButton button_add_abteilung;
	private JComboBox<String> comboBox;
	private JButton btn_activate_custom_abteilung;
	private JButton btn_check_abteilung;
	private JTextField text_field_custom_kategorie;
	private JButton button_add_custom_kategorie;
	private JList<Object> list;
	private ArrayList<String> values;
	private JScrollPane scrollPane;
	private DaoKategorie daoKategorie;
	public static String[] kategorie;
	private JButton button_Mins_abteilung;
	private JTextField textFieldSuchen;
	private JButton buttonSuchen;
	private String currentAbteilung;

	/**
	 * Create the frame.
	 */
	public JFrameKategorieHinzufuegen(String currentAbteilung) {
		this.currentAbteilung = currentAbteilung;
		daoKategorie = new DaoKategorie();
		initGUI();
	}
	private void initGUI() {
		contentPane = new JPanel();
		setTitle("Abteilung hinzufügen");
		Utils.setSmallFrameOptions(this);
		contentPane.setBackground(Colors.parseColor(Colors.LIGHT_GREY));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			labelNewLabel = new JLabel();
			labelNewLabel.setText("<html><body>Kategorie hinzufügen<br><center>(" + currentAbteilung + ")</center></body></html>");
			labelNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			Fonts.setCenturySchoolbookFont(labelNewLabel, 20);
			labelNewLabel.setBounds(10, 31, 364, 50);
			labelNewLabel.setForeground(Colors.parseColor(Colors.SEXY_BLUE));
			contentPane.add(labelNewLabel);
		}
		{
			button_add_abteilung = new JButton("+");
			button_add_abteilung.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					onAddKategorieClicked(arg0);
				}
			});
			button_add_abteilung.setFont(new Font("Century Schoolbook", Font.PLAIN, 13));
			button_add_abteilung.setBounds(290, 92, 52, 27);
			Utils.setStandardButtonOptions(button_add_abteilung);
			contentPane.add(button_add_abteilung);
		}
		{
			comboBox = new JComboBox<>();
			comboBox.setFocusable(false);
			comboBox.setFont(new Font("Century Schoolbook", Font.PLAIN, 13));
			comboBox.setBackground(Colors.parseColor(Colors.LIGHT_PINK));
			comboBox.setModel(new DefaultComboBoxModel<>(new String[] {"Gem\u00FCse", "Obst", "Smartphones"}));
			comboBox.setBounds(30, 92, 257, 27);
			contentPane.add(comboBox);
		}
		{
			btn_activate_custom_abteilung = new JButton("Custom Kategorie hinzuf\u00FCgen");
			btn_activate_custom_abteilung.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent arg0) {
					onActivateCustomKategorieClicked(arg0);
				}
			});
			btn_activate_custom_abteilung.setHorizontalAlignment(SwingConstants.LEFT);
			btn_activate_custom_abteilung.setBorderPainted(false);
			btn_activate_custom_abteilung.setContentAreaFilled(false);
			btn_activate_custom_abteilung.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btn_activate_custom_abteilung.setFocusable(false);
			btn_activate_custom_abteilung.setRequestFocusEnabled(false);
			btn_activate_custom_abteilung.setRolloverEnabled(false);
			btn_activate_custom_abteilung.setBounds(10, 152, 247, 14);
			btn_activate_custom_abteilung.setForeground(Colors.parseColor(Colors.SEXY_BLUE));
			contentPane.add(btn_activate_custom_abteilung);
		}
		{
			btn_check_abteilung = new JButton(Unicodes.CHECK);
			btn_check_abteilung.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					onCheckClicked(arg0);
				}
			});
			btn_check_abteilung.setBounds(285, 327, 89, 23);
			Utils.setStandardButtonOptions(btn_check_abteilung);
			contentPane.add(btn_check_abteilung);
		}

		{
			text_field_custom_kategorie = new JTextField();
			text_field_custom_kategorie.setVisible(false);
			text_field_custom_kategorie.setBounds(20, 177, 167, 26);
			contentPane.add(text_field_custom_kategorie);
			text_field_custom_kategorie.setColumns(10);
		}
		{
			button_add_custom_kategorie = new JButton("+");
			button_add_custom_kategorie.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					onAddCustomKategorieClicked(arg0);
				}
			});
			button_add_custom_kategorie.setVisible(false);
			button_add_custom_kategorie.setFont(new Font("Century Schoolbook", Font.PLAIN, 13));
			button_add_custom_kategorie.setBounds(197, 177, 52, 26);
			Utils.setStandardButtonOptions(button_add_custom_kategorie);
			contentPane.add(button_add_custom_kategorie);
		}
		{
			values = new ArrayList<String>();
			{
				scrollPane = new JScrollPane();
				scrollPane.setBounds(20, 229, 167, 121);
				contentPane.add(scrollPane);
				list = new JList<>();
				scrollPane.setViewportView(list);
				list.setBorder(new LineBorder(Color.LIGHT_GRAY));
			}
		}
		{
			button_Mins_abteilung = new JButton("-");
			button_Mins_abteilung.setFont(new Font("Century Schoolbook", Font.PLAIN, 13));
			Utils.setStandardButtonOptions(button_Mins_abteilung);
			button_Mins_abteilung.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					onMinsKategorieClicked(arg0);
				}
			});
			button_Mins_abteilung.setBounds(200, 235, 50, 25);
			contentPane.add(button_Mins_abteilung);
		}
		{
			textFieldSuchen = new JTextField();
			textFieldSuchen.setToolTipText("Aus der Liste Suchen");
			textFieldSuchen.setBounds(197, 270, 177, 27);
			contentPane.add(textFieldSuchen);
			textFieldSuchen.setColumns(10);
		}
		{
			buttonSuchen = new JButton("Suchen");
			Utils.setStandardButtonOptions(buttonSuchen);
			buttonSuchen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					buttonSuchenActionPerformed(arg0);
				}
			});
			buttonSuchen.setBounds(255, 235, 115, 25);
			contentPane.add(buttonSuchen);
		}
	}
	
	/**
	 * Created On 04.01.2020 Created By Omar
	 * 
	 * @param arg0
	 */
	protected void onActivateCustomKategorieClicked(ActionEvent arg0) {
		text_field_custom_kategorie.setVisible(true);
		button_add_custom_kategorie.setVisible(true);
		text_field_custom_kategorie.requestFocus();
	}

	/**
	 * Created On 04.01.2020 Created By Omar
	 * 
	 * @param arg0
	 */
	protected void onAddKategorieClicked(ActionEvent arg0) {
		values.add(comboBox.getSelectedItem().toString());
		Utils.updateList(list, true, scrollPane, values);
	}

	/**
	 * Created On 04.01.2020 Created By Omar adds a custom kategorie after the
	 * button was clicked
	 * 
	 * @param arg0
	 */
	protected void onAddCustomKategorieClicked(ActionEvent arg0) {
		if (text_field_custom_kategorie.getText() != null) {
			values.add(text_field_custom_kategorie.getText().toString());
			Utils.updateList(list, true, scrollPane, values);
			text_field_custom_kategorie.setText("");
		} else {
			JOptionPane.showMessageDialog(this, "Bitte einen vollständingen Namen eingeben");
		}
	}

	/**
	 * @author Aref
	 * @param arg0
	 * @throws ClassNotFoundException
	 */
	protected void onCheckClicked(ActionEvent arg0) {
		if(currentAbteilung.trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Die Kategorien können nicht zu einer Abteilung zugeordnet werden. \nSicher, dass Sie mind. eine Abteilung hinzugefügt haben?");
			return;
		}
		String[] kategorien = new String[values.size()];
		if (kategorien.length == 0 || kategorien == null) {
			JOptionPane.showMessageDialog(this,
					"Keine Kategorie konnten gespeichert werden\nÜberprüfen Sie Ihre eingaben");
			return;
		}
		for (int i = 0; i < kategorien.length; i++) {
			kategorien[i] = values.get(i).toString();
			daoKategorie.insertKategorie(kategorien[i], currentAbteilung);
		}
		kategorie = new String[kategorien.length];
		kategorie = kategorien;
		this.setVisible(false);
	}

	/**
	 * 15.01.2020 Ajabnoor removes the selected kategorie
	 * 
	 * @param arg0
	 */
	protected void onMinsKategorieClicked(ActionEvent arg0) {
		if (list.isSelectedIndex(list.getSelectedIndex())) {
			values.remove(list.getSelectedIndex());
			Utils.updateList(list, true, scrollPane, values);
		} else {
			System.out.println("sad");
		}
	}

	/**
	 * 15.01.2020 Ajabnoor searches the kategorie
	 * 
	 * @param arg0
	 */
	protected void buttonSuchenActionPerformed(ActionEvent arg0) {
		Utils.searchWord(values, textFieldSuchen, list, this);
	}

}
