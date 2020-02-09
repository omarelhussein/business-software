package artikel.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import general.code.Utils;
import general.design.Colors;
import general.design.Unicodes;

import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFrameArtikelHinzufuegen extends JFrame {
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JComboBox comboBox;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblNewLabel_3;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JComboBox comboBox_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameArtikelHinzufuegen frame = new JFrameArtikelHinzufuegen();
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
	 */

	public JFrameArtikelHinzufuegen() {
		initGUI();
		
	}
	private void initGUI() {
		getContentPane().setLayout(null);
	
		
		Utils.setMiddleFrameOptions(this);
		getContentPane().setBackground(Colors.parseColor(Colors.LIGHT_GREY));
		
	 
		{
			panel = new JPanel();
			panel.setBorder(new LineBorder(new Color(0, 0, 0)));
			panel.setBackground(Colors.parseColor(Colors.LIGHT_PINK));
			panel.setBounds(27, 43, 583, 521);
			getContentPane().add(panel);
			panel.setLayout(null);
			{
				lblNewLabel = new JLabel("Name");
				lblNewLabel.setFont(new Font("Trebuchet MS", Font.ITALIC, 15));
				lblNewLabel.setBounds(10, 27, 61, 27);
				panel.add(lblNewLabel);
			}
			{
				lblNewLabel_1 = new JLabel("Preis");
				lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.ITALIC, 15));
				lblNewLabel_1.setBounds(10, 205, 61, 23);
				panel.add(lblNewLabel_1);
			}
			{
				lblNewLabel_2 = new JLabel("Anzahl");
				lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.ITALIC, 15));
				lblNewLabel_2.setBounds(10, 360, 61, 23);
				panel.add(lblNewLabel_2);
			}
			{
				comboBox = new JComboBox();
				comboBox.setModel(new DefaultComboBoxModel(new String[] {"Lebiensmittel", "Elktronik"}));
				comboBox.setBounds(10, 433, 561, 67);
				panel.add(comboBox);
			}
			{
				textField = new JTextField();
				textField.setBounds(132, 26, 189, 28);
				panel.add(textField);
				textField.setColumns(10);
			}
			{
				textField_1 = new JTextField();
				textField_1.setBounds(143, 200, 178, 28);
				panel.add(textField_1);
				textField_1.setColumns(10);
			}
			{
				textField_2 = new JTextField();
				textField_2.setBounds(143, 359, 178, 28);
				panel.add(textField_2);
				textField_2.setColumns(10);
			}
			{
				comboBox_1 = new JComboBox();
				comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Obst", "Gem\u00FCse"}));
				comboBox_1.setBounds(434, 43, 137, 47);
				panel.add(comboBox_1);
			}
		}
		{
			lblNewLabel_3 = new JLabel("Artkel Hinzuf\u00FCgen");
			lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_3.setForeground(Colors.parseColor(Colors.SEXY_BLUE));
			lblNewLabel_3.setBounds(100, 11, 423, 25);
			getContentPane().add(lblNewLabel_3);
		}
		{
			btnNewButton = new JButton(Unicodes.CHECK);
					Utils.setStandardButtonOptions(btnNewButton);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnNewButtonActionPerformed(e);
				}
			});
			btnNewButton.setBounds(521, 575, 89, 23);
			getContentPane().add(btnNewButton);
		}
		{
			btnNewButton_1 = new JButton(Unicodes.BACK_ARROW);
			Utils.setStandardButtonOptions(btnNewButton_1);
			btnNewButton_1.setBounds(22, 575, 89, 23);
			getContentPane().add(btnNewButton_1);
		}
	}
	protected void btnNewButtonActionPerformed(ActionEvent e) {
	}
}
