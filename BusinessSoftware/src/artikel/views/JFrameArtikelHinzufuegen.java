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
import javax.swing.JSeparator;

public class JFrameArtikelHinzufuegen extends JFrame {
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JComboBox comboBoxAbteilung;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblNewLabel_3;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JComboBox comboBoxKategorie;
	private JButton bestaetigen;
	private JSeparator separator;
	private JSeparator separator_1;
	private JButton aktuallisieren;
	private JButton loeschen;

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
	 * Created by Mohammad on 10.02.2020
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
			panel.setBounds(22, 43, 583, 521);
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
				lblNewLabel_1.setBounds(10, 114, 61, 23);
				panel.add(lblNewLabel_1);
			}
			{
				lblNewLabel_2 = new JLabel("Anzahl");
				lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.ITALIC, 15));
				lblNewLabel_2.setBounds(10, 188, 61, 23);
				panel.add(lblNewLabel_2);
			}
			{
				comboBoxAbteilung = new JComboBox();
				comboBoxAbteilung.setModel(new DefaultComboBoxModel(new String[] {"Lebiensmittel", "Elktronik"}));
				comboBoxAbteilung.setBounds(10, 265, 222, 47);
				comboBoxAbteilung.setBackground(Colors.parseColor(Colors.LIGHT_PINK));
				panel.add(comboBoxAbteilung);
			}
			{
				textField = new JTextField();
				textField.setBounds(132, 26, 189, 28);
				panel.add(textField);
				textField.setColumns(10);
			}
			{
				textField_1 = new JTextField();
				textField_1.setBounds(132, 113, 189, 28);
				panel.add(textField_1);
				textField_1.setColumns(10);
			}
			{
				textField_2 = new JTextField();
				textField_2.setBounds(132, 187, 189, 28);
				panel.add(textField_2);
				textField_2.setColumns(10);
			}
			{
				comboBoxKategorie = new JComboBox();
				comboBoxKategorie.setModel(new DefaultComboBoxModel(new String[] {"Obst", "Gem\u00FCse"}));
				comboBoxKategorie.setBackground(Colors.parseColor(Colors.LIGHT_PINK));
				comboBoxKategorie.setBounds(351, 265, 222, 47);
				panel.add(comboBoxKategorie);
			}
			{
				bestaetigen = new JButton("Best\u00E4tigen");
				Utils.setStandardButtonOptions(bestaetigen);
				bestaetigen.setBounds(446, 487, 127, 23);
				panel.add(bestaetigen);
			}
			{
				separator = new JSeparator();
				separator.setBounds(10, 253, 563, 1);
				panel.add(separator);
			}
			{
				separator_1 = new JSeparator();
				separator_1.setOrientation(SwingConstants.VERTICAL);
				separator_1.setBounds(359, 11, 2, 244);
				panel.add(separator_1);
			}
			{
				aktuallisieren = new JButton("Aktuallisieren");
				aktuallisieren.setBounds(383, 74, 156, 23);
				Utils.setStandardButtonOptions(aktuallisieren);
				panel.add(aktuallisieren);
			}
			{
				loeschen = new JButton("L\u00F6schen");
				loeschen.setBounds(383, 190, 154, 23);
				Utils.setStandardButtonOptions(loeschen);

				panel.add(loeschen);
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
