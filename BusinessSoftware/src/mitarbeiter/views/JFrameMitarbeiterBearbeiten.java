package mitarbeiter.views;

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
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFrameMitarbeiterBearbeiten extends JFrame {

	private JPanel contentPane;
	private JButton buttonSpeichern;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JPanel panel;
	private JButton btnNewButtonPflegen;
	private JButton btnNewButton;
	private JButton btnNewButtonZurueck;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameMitarbeiterBearbeiten frame = new JFrameMitarbeiterBearbeiten();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Created by Mohammad on 06.02.2020
	 */
	public JFrameMitarbeiterBearbeiten() {
		initGUI();
	}
	private void initGUI() {
		Utils.setMiddleFrameOptions(this);
		setBounds(100, 100, 650, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			buttonSpeichern = new JButton("speichern");
			buttonSpeichern.setFont(new Font("Century Schoolbook", Font.PLAIN, 21));
			buttonSpeichern.setBounds(692, 215, 141, 58);
			contentPane.add(buttonSpeichern);
		}
		{
			panel = new JPanel();
			panel.setBorder(new LineBorder(new Color(0, 0, 0)));
			panel.setBackground(Colors.parseColor(Colors.LIGHT_PINK));
			panel.setBounds(61, 57, 530, 502);
			contentPane.add(panel);
			panel.setLayout(null);
			{
				label = new JLabel("Name");
				label.setBounds(20, 46, 97, 19);
				panel.add(label);
				label.setFont(new Font("Trebuchet MS", Font.ITALIC, 20));
			}
			{
				textField_4 = new JTextField();
				textField_4.setBounds(188, 36, 162, 33);
				panel.add(textField_4);
				textField_4.setColumns(10);
			}
			{
				label_1 = new JLabel("Geburtsdatum");
				label_1.setBounds(20, 134, 154, 22);
				panel.add(label_1);
				label_1.setFont(new Font("Trebuchet MS", Font.ITALIC, 20));
			}
			{
				textField_3 = new JTextField();
				textField_3.setBounds(188, 132, 162, 33);
				panel.add(textField_3);
				textField_3.setColumns(10);
			}
			{
				label_2 = new JLabel("E-Mail");
				label_2.setBounds(20, 250, 110, 19);
				panel.add(label_2);
				label_2.setFont(new Font("Trebuchet MS", Font.ITALIC, 20));
			}
			{
				textField_2 = new JTextField();
				textField_2.setBounds(188, 230, 162, 34);
				panel.add(textField_2);
				textField_2.setColumns(10);
			}
			{
				label_3 = new JLabel("Gehalt");
				label_3.setBounds(20, 335, 137, 38);
				panel.add(label_3);
				label_3.setFont(new Font("Trebuchet MS", Font.ITALIC, 20));
			}
			{
				textField_1 = new JTextField();
				textField_1.setBounds(188, 335, 162, 33);
				panel.add(textField_1);
				textField_1.setColumns(10);
			}
			{
				label_4 = new JLabel("ID");
				label_4.setBounds(20, 434, 56, 16);
				panel.add(label_4);
				label_4.setFont(new Font("Trebuchet MS", Font.ITALIC, 20));
			}
			{
				textField = new JTextField();
				textField.setBounds(188, 429, 162, 33);
				panel.add(textField);
				textField.setColumns(10);
			}
		}
		{
			btnNewButtonPflegen = new JButton("Pflegen");
			btnNewButtonPflegen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnNewButtonPflegenActionPerformed(e);
				}
			});
			btnNewButtonPflegen.setFont(new Font("Trebuchet MS", Font.ITALIC, 15));
			btnNewButtonPflegen.setBounds(153, 23, 294, 23);
			Fonts.setCenturySchoolbookFont(btnNewButtonPflegen,24);
			btnNewButtonPflegen.setForeground(Colors.parseColor(Colors.SEXY_BLUE));
			contentPane.add(btnNewButtonPflegen);
		}
		{
			btnNewButton = new JButton("Fertig");
			btnNewButton.setFont(new Font("Sitka Subheading", Font.BOLD | Font.ITALIC, 14));
			btnNewButton.setBounds(502, 577, 89, 23);
			Utils.setStandardButtonOptions(btnNewButton);
			contentPane.add(btnNewButton);
		}
		{
			btnNewButtonZurueck = new JButton(Unicodes.BACK_ARROW);
			Utils.setStandardButtonOptions(btnNewButtonZurueck);
			btnNewButtonZurueck.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnNewButton_1ActionPerformed(e);
				}
			});
			btnNewButtonZurueck.setBounds(61, 577, 89, 23);
			contentPane.add(btnNewButtonZurueck);
		}
	}
	protected void btnNewButton_1ActionPerformed(ActionEvent e) {
	}
	protected void btnNewButtonPflegenActionPerformed(ActionEvent e) {
	}
}
