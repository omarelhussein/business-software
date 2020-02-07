package abteilungen.views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import abteilungen.DaoAbteilung;
import general.code.GeschaeftDB;
import general.code.Utils;
import general.design.Colors;
import general.design.Fonts;
import general.design.Unicodes;

/**
 * 
 * @author ajab
 *
 */
@SuppressWarnings("serial")
public class JFrameAbteilunghinzufuegen extends JFrame {

	private JPanel contentPane;
	private JLabel labelNewLabel;
	private JButton button_add_abteilung;
	private JComboBox comboBox;
	private JButton btn_activate_custom_abteilung;
	private JButton btn_check_abteilung;
	private JTextField text_field_custom_abteilung;
	private JButton button_add_custom_abteilung;
	private JList<Object> list;
	private ArrayList<String> values;
	private JScrollPane scrollPane;
	private DaoAbteilung daoabteilung;
	public static String[] abteilung;
	private JButton button_Mins_abteilung;
	private JTextField textFieldSuchen;
	private JButton buttonSuchen;
	String nameabteilung;

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
	 * 
	 * @throws ClassNotFoundException
	 */
	public JFrameAbteilunghinzufuegen() throws ClassNotFoundException {
		initGUI();
		daoabteilung = new DaoAbteilung();
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
			labelNewLabel = new JLabel("Abteilung hinzuf\u00FCgen");
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
					onAddAbteilungClicked(arg0);
				}
			});
			button_add_abteilung.setFont(new Font("Century Schoolbook", Font.PLAIN, 13));
			button_add_abteilung.setBounds(287, 92, 52, 27);
			Utils.setStandardButtonOptions(button_add_abteilung);
			contentPane.add(button_add_abteilung);
		}
		{
			comboBox = new JComboBox();
			comboBox.setFocusable(false);
			comboBox.setFont(new Font("Century Schoolbook", Font.PLAIN, 13));
			comboBox.setBackground(Colors.parseColor(Colors.LIGHT_PINK));
			comboBox.setModel(new DefaultComboBoxModel(new String[] { "Lebensmittel", "Elektronik" }));
			comboBox.setBounds(20, 92, 257, 27);
			contentPane.add(comboBox);
		}
		{
			btn_activate_custom_abteilung = new JButton("Custom Abteilung hinzuf\u00FCgen");
			btn_activate_custom_abteilung.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent arg0) {
					onActivateCustomAbteilungClicked(arg0);
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
					try {
						do_btn_check_abteilung_actionPerformed(arg0);
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			btn_check_abteilung.setBounds(285, 327, 89, 23);
			Utils.setStandardButtonOptions(btn_check_abteilung);
			contentPane.add(btn_check_abteilung);
		}

		{
			text_field_custom_abteilung = new JTextField();
			text_field_custom_abteilung.setVisible(false);
			text_field_custom_abteilung.setBounds(20, 177, 167, 26);
			contentPane.add(text_field_custom_abteilung);
			text_field_custom_abteilung.setColumns(10);
		}
		{
			button_add_custom_abteilung = new JButton("+");
			button_add_custom_abteilung.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					onAddCustomAbteilungClicked(arg0);
				}
			});
			button_add_custom_abteilung.setVisible(false);
			button_add_custom_abteilung.setFont(new Font("Century Schoolbook", Font.PLAIN, 13));
			button_add_custom_abteilung.setBounds(197, 177, 52, 26);
			Utils.setStandardButtonOptions(button_add_custom_abteilung);
			contentPane.add(button_add_custom_abteilung);
		}
		{
			values = new ArrayList<String>();
			{
				scrollPane = new JScrollPane();
				scrollPane.setBounds(20, 229, 167, 121);
				contentPane.add(scrollPane);
				list = new JList();
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
					onMinsAbteilungClicked(arg0);
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
	protected void onActivateCustomAbteilungClicked(ActionEvent arg0) {
		text_field_custom_abteilung.setVisible(true);
		button_add_custom_abteilung.setVisible(true);
		text_field_custom_abteilung.requestFocus();
	}

	/**
	 * Created On 04.01.2020 Created By Omar
	 * 
	 * @param arg0
	 */
	protected void onAddAbteilungClicked(ActionEvent arg0) {
		values.add(comboBox.getSelectedItem().toString());
		Utils.updateList(list, true, scrollPane, values);
	}

	/**
	 * Created On 04.01.2020 Created By Omar
	 * 
	 */
	private void updateAbteilungsList() {
		list.setModel(new AbstractListModel<Object>() {

			@Override
			public Object getElementAt(int index) {
				return values.get(index);
			}

			@Override
			public int getSize() {
				return values.size();
			}
		});

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				JScrollBar verticalScroll = scrollPane.getVerticalScrollBar();
				verticalScroll.setValue(verticalScroll.getMaximum());
			}
		});
	}

	/**
	 * Created On 04.01.2020 Created By Omar
	 * adds a custom abteilung after the button was clicked
	 * @param arg0
	 */
	protected void onAddCustomAbteilungClicked(ActionEvent arg0) {
		if (text_field_custom_abteilung.getText() != null) {
			values.add(text_field_custom_abteilung.getText().toString());
			Utils.updateList(list, true, scrollPane, values);
			text_field_custom_abteilung.setText("");
		} else {
			JOptionPane.showMessageDialog(this, "Bitte einen vollständingen Namen eingeben");
		}
	}

	/**
	 * @author Aref
	 * @param arg0
	 * @throws ClassNotFoundException
	 */
	protected void do_btn_check_abteilung_actionPerformed(ActionEvent arg0) throws ClassNotFoundException {
		String[] abteilungen = new String[values.size()];
		String bteilung;
		for (int i = 0; i < abteilungen.length; i++) {
			abteilungen[i] = values.get(i).toString();
			bteilung = abteilungen[i];
			daoabteilung.insertAbteilung(bteilung);
			bteilung = "";
		}
		abteilung = new String[abteilungen.length];
		abteilung = abteilungen;
		System.out.println(abteilungen[0]);
		this.setVisible(false);
	}

	/**
	 * 15.01.2020 Ajabnoor
	 * removes the selected abteilung
	 * @param arg0
	 */
	protected void onMinsAbteilungClicked(ActionEvent arg0) {
		if (list.isSelectedIndex(list.getSelectedIndex())) {
			String abteilung = list.getSelectedValue().toString();
			// daoabteilung.AbteilungDelet(abteilung);
			values.remove(list.getSelectedIndex());
			Utils.updateList(list, true, scrollPane, values);
		} else {
			System.out.println("sad");

		}
	}

	/**
	 * 15.01.2020 Ajabnoor
	 * searches the abteilung
	 * @param arg0
	 */
	protected void buttonSuchenActionPerformed(ActionEvent arg0) {

		for (String  string : values) {
			if (textFieldSuchen.getText().equals(string)) {
				list.setSelectionInterval(values.indexOf(string), values.lastIndexOf(string));
				nameabteilung=string;
				return;
				
			}


		}
		JOptionPane.showMessageDialog(this, "Suchwort wurde nicht gefunden");

	}
}
