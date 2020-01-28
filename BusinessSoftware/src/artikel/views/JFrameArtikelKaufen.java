package artikel.views;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import general.code.Utils;
import general.design.Colors;
import general.design.Fonts;
import general.design.Unicodes;

import javax.swing.JComboBox;
import javax.swing.JSlider;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class JFrameArtikelKaufen extends JFrame {

	private JPanel contentPane;
	private JButton buttonFertig;
	private JPanel panel;
	private JLabel label;
	private JTextField textField;
	private JLabel label_1;
	private JTextField textField_1;
	private JLabel label_2;
	private JTextField textField_2;
	private JLabel label_3;
	private JTextField textField_3;
	private JComboBox comboBox;
	private JButton button;
	private JButton button_1;
	private JLabel lblNewLabelArtikelKaufen;
	private JButton buttonZurueck;

	/**
	 * Created by Mohammad 21.01.2020
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameArtikelKaufen frame = new JFrameArtikelKaufen();
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
	public JFrameArtikelKaufen() {
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Utils.setMiddleFrameOptions(this);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			buttonFertig = new JButton("Fertig");
			buttonFertig.setFont(new Font("Century Schoolbook", Font.PLAIN, 20));
			buttonFertig.setBounds(669, 317, 97, 25);
			contentPane.add(buttonFertig);
		}
		{
			panel = new JPanel();
			panel.setBorder(new LineBorder(new Color(0, 0, 0)));
			panel.setBounds(51, 72, 536, 473);
			contentPane.add(panel);
			panel.setLayout(null);
			{
				label = new JLabel("Anzahl ");
				label.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 15));
				label.setBounds(26, 20, 98, 37);
				
				panel.add(label);
			}
			{
				textField = new JTextField();
				textField.setColumns(10);
				textField.setBounds(243, 25, 156, 31);
				panel.add(textField);
			}
			{
				label_1 = new JLabel("Bezeichnung");
				label_1.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 15));
				label_1.setBounds(26, 75, 146, 51);
				panel.add(label_1);
			}
			{
				textField_1 = new JTextField();
				textField_1.setColumns(10);
				textField_1.setBounds(243, 83, 268, 38);
				panel.add(textField_1);
			}
			{
				label_2 = new JLabel("Gewicht");
				label_2.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 15));
				label_2.setBounds(26, 144, 114, 40);
				panel.add(label_2);
			}
			{
				textField_2 = new JTextField();
				textField_2.setColumns(10);
				textField_2.setBounds(243, 150, 156, 33);
				panel.add(textField_2);
			}
			{
				label_3 = new JLabel("Preis");
				label_3.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 15));
				label_3.setBounds(26, 220, 56, 16);
				panel.add(label_3);
			}
			{
				textField_3 = new JTextField();
				textField_3.setColumns(10);
				textField_3.setBounds(243, 215, 156, 31);
				panel.add(textField_3);
			}
			{
				comboBox = new JComboBox();
				comboBox.setModel(new DefaultComboBoxModel(new String[] {"Samsung Galaxy Not8", "Samsung Galaxy S9+", "Kartoffel", "Msak3a"}));
				comboBox.setSelectedIndex(1);
				comboBox.setBounds(10, 324, 283, 51);
				panel.add(comboBox);
			}
			{
				button_1 = new JButton("Speichern");
				button_1.setForeground(new Color(0, 0, 0));
				button_1.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 18));
				Utils.setStandardButtonOptions(button_1);
				button_1.setBounds(374, 407, 137, 25);
				panel.add(button_1);
			}
		}
		{
			button = new JButton("Weiter");
			button.setForeground(new Color(0, 0, 0));
			button.setBounds(490, 575, 97, 25);
			contentPane.add(button);
			button.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 17));
		}
		{
			lblNewLabelArtikelKaufen = new JLabel("Artikel Kaufen");
			lblNewLabelArtikelKaufen.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabelArtikelKaufen.setBounds(78, 24, 377, 37);
			lblNewLabelArtikelKaufen.setForeground(Colors.parseColor(Colors.SEXY_BLUE));
			Fonts.setCenturySchoolbookFont(lblNewLabelArtikelKaufen, 24);
			contentPane.add(lblNewLabelArtikelKaufen);
		}
		{
			Utils.setStandardButtonOptions(button);
		}
		{
			buttonZurueck = new JButton(Unicodes.BACK_ARROW);
			buttonZurueck.setBounds(31, 575, 86, 21);
			Utils.setStandardButtonOptions(buttonZurueck);
			contentPane.add(buttonZurueck);
		}
	}
}
