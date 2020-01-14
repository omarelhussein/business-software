package abteilungen.views;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.border.EmptyBorder;

import general.code.Utils;
import general.design.Colors;
import general.design.Fonts;
import general.design.Unicodes;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Cursor;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;
import javax.swing.AbstractListModel;
import javax.swing.JScrollPane;

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
	private JButton button_Mins_abteilung;

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
	 */
	public JFrameAbteilunghinzufuegen() {
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
			button_Mins_abteilung.setBounds(199, 234, 50, 25);
			contentPane.add(button_Mins_abteilung);
		}
	}
	
	/**
	 * Created On 04.01.2020
	 * Created By Omar
	 * @param arg0
	 */
	protected void onActivateCustomAbteilungClicked(ActionEvent arg0) {
		text_field_custom_abteilung.setVisible(true);
		button_add_custom_abteilung.setVisible(true);
		text_field_custom_abteilung.requestFocus();
	}
	
	/**
	 * Created On 04.01.2020
	 * Created By Omar
	 * @param arg0
	 */
	protected void onAddAbteilungClicked(ActionEvent arg0) {
		values.add(comboBox.getSelectedItem().toString());
		updateAbteilungsList();
	}

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
	 * Created On 04.01.2020
	 * Created By Omar
	 * @param arg0
	 */
	protected void onAddCustomAbteilungClicked(ActionEvent arg0) {
		if(text_field_custom_abteilung.getText() != null) {
			values.add(text_field_custom_abteilung.getText().toString());
			updateAbteilungsList();
			text_field_custom_abteilung.setText("");
		} else {
			JOptionPane.showMessageDialog(this, "Bitte einen vollständingen Namen eingeben");
		}
	}
	protected void onMinsAbteilungClicked(ActionEvent arg0) {
		if (list.isSelectedIndex(list.getSelectedIndex())) {
			values.remove(list.getSelectedIndex());
			updateAbteilungsList();
		} else {

		}
	}
}
