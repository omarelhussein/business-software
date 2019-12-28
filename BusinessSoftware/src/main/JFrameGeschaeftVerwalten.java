package main;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import general.Colors;
import general.Fonts;
import general.Unicodes;
import general.Utils;
import start.JFrameAnmelden;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JSeparator;
import java.awt.SystemColor;

public class JFrameGeschaeftVerwalten extends JFrame {

	private JPanel contentPane;
	private JButton btnAbteilungBearbeiten;
	private JLabel labelMainTitle;
	private JPanel panel;
	private JButton btnMitarbeiterAnzeigen;
	private JMenuBar menuBar;
	private JMenu menuSettings;
	private JMenuItem menuItemLogout;
	private JLabel labelNewLabel;
	private JSeparator separator;
	private JSeparator separator_1;
	private JButton buttonArtikelAnzeigen;
	private JSeparator separator_2;
	private JButton buttonAbteilungAnzeigen;
	private JButton buttonArtikelVerwalten;
	private JButton buttonMitarbeiterVerwalten;
	private JLabel labelAnzeigenVerwalten;
	private JLabel labelGeschftBereich;
	private JButton buttonAllgemeineDatenAnzeigen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameGeschaeftVerwalten frame = new JFrameGeschaeftVerwalten();
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
	public JFrameGeschaeftVerwalten() {
		initGUI();
	}

	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Utils.setMainFrameOptions(this);
		{
			menuBar = new JMenuBar();
			setJMenuBar(menuBar);
			{
				menuSettings = new JMenu("Settings");
				menuBar.add(menuSettings);
				{
					menuItemLogout = new JMenuItem("Abmelden");
					menuSettings.add(menuItemLogout);
				}
			}
		}
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Colors.parseColor(Colors.LIGHT_GREY));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			labelMainTitle = new JLabel("Real.-");
			labelMainTitle.setForeground(Colors.parseColor(Colors.SEXY_BLUE));
			labelMainTitle.setHorizontalAlignment(SwingConstants.CENTER);
			Fonts.setCenturySchoolbookFont(labelMainTitle, 42);
			labelMainTitle.setBounds(30, 5, 800, 66);
			contentPane.add(labelMainTitle);
		}
		{
			panel = new JPanel();
			panel.setBounds(10, 71, 864, 458);
			panel.setBackground(Colors.parseColor(Colors.LIGHT_PINK));
			Utils.setMainInternalFrameOptions(panel);
			contentPane.add(panel);
			panel.setLayout(null);
			{
				btnAbteilungBearbeiten = new JButton("Abteilung bearbeiten");
				Utils.standardButtonOptions(btnAbteilungBearbeiten);
				btnAbteilungBearbeiten.setBounds(337, 262, 199, 46);
				panel.add(btnAbteilungBearbeiten);
				btnAbteilungBearbeiten.setFont(new Font("Tahoma", Font.PLAIN, 16));
			}
			{
				btnMitarbeiterAnzeigen = new JButton("Mitarbeiter Anzeigen");
				btnMitarbeiterAnzeigen.setFont(new Font("Tahoma", Font.PLAIN, 16));
				Utils.standardButtonOptions(btnMitarbeiterAnzeigen);
				btnMitarbeiterAnzeigen.setBounds(43, 78, 199, 46);
				panel.add(btnMitarbeiterAnzeigen);
			}
			{
				labelNewLabel = new JLabel("Anzeigen - Berechtigung");
				labelNewLabel.setForeground(Colors.parseColor(Colors.SEXY_BLUE));
				labelNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				labelNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
				labelNewLabel.setBounds(43, 11, 199, 25);
				panel.add(labelNewLabel);
			}
			{
				separator = new JSeparator();
				separator.setBounds(0, 47, 864, 1);
				panel.add(separator);
				separator.setForeground(Color.CYAN);
				separator.setBackground(Color.CYAN);
			}
			{
				separator_1 = new JSeparator();
				separator_1.setOrientation(SwingConstants.VERTICAL);
				separator_1.setBounds(281, 0, 1, 447);
				panel.add(separator_1);
			}
			{
				separator_2 = new JSeparator();
				separator_2.setOrientation(SwingConstants.VERTICAL);
				separator_2.setBounds(600, 0, 1, 447);
				panel.add(separator_2);
			}
			{
				buttonArtikelAnzeigen = new JButton("Artikel Anzeigen");
				buttonArtikelAnzeigen.setFont(new Font("Tahoma", Font.PLAIN, 16));
				buttonArtikelAnzeigen.setBounds(43, 169, 199, 46);
				Utils.standardButtonOptions(buttonArtikelAnzeigen);
				panel.add(buttonArtikelAnzeigen);
			}
			{
				buttonAbteilungAnzeigen = new JButton("Abteilung Anzeigen");
				buttonAbteilungAnzeigen.setFont(new Font("Tahoma", Font.PLAIN, 16));
				buttonAbteilungAnzeigen.setBounds(43, 262, 199, 46);
				Utils.standardButtonOptions(buttonAbteilungAnzeigen);
				panel.add(buttonAbteilungAnzeigen);
			}
			{
				buttonArtikelVerwalten = new JButton("Artikel Verwalten");
				buttonArtikelVerwalten.setFont(new Font("Tahoma", Font.PLAIN, 16));
				buttonArtikelVerwalten.setBounds(337, 169, 199, 46);
				Utils.standardButtonOptions(buttonArtikelVerwalten);
				panel.add(buttonArtikelVerwalten);
			}
			{
				buttonMitarbeiterVerwalten = new JButton("Mitarbeiter Verwalten");
				buttonMitarbeiterVerwalten.setFont(new Font("Tahoma", Font.PLAIN, 16));
				buttonMitarbeiterVerwalten.setBounds(337, 78, 199, 46);
				Utils.standardButtonOptions(buttonMitarbeiterVerwalten);
				panel.add(buttonMitarbeiterVerwalten);
			}
			{
				labelAnzeigenVerwalten = new JLabel("Anzeigen & Verwalten - Berechtigung");
				labelAnzeigenVerwalten.setHorizontalAlignment(SwingConstants.CENTER);
				labelAnzeigenVerwalten.setForeground(SystemColor.textHighlight);
				labelAnzeigenVerwalten.setFont(new Font("Tahoma", Font.PLAIN, 15));
				labelAnzeigenVerwalten.setBounds(318, 11, 240, 25);
				panel.add(labelAnzeigenVerwalten);
			}
			{
				labelGeschftBereich = new JLabel("Gesch\u00E4ft Verwalten");
				labelGeschftBereich.setHorizontalAlignment(SwingConstants.CENTER);
				labelGeschftBereich.setForeground(SystemColor.textHighlight);
				labelGeschftBereich.setFont(new Font("Tahoma", Font.PLAIN, 15));
				labelGeschftBereich.setBounds(634, 11, 199, 25);
				panel.add(labelGeschftBereich);
			}
			{
				buttonAllgemeineDatenAnzeigen = new JButton("<html>Allgemeine Daten<br/><center>Anzeigen</center></html>");
				buttonAllgemeineDatenAnzeigen.setFont(new Font("Tahoma", Font.PLAIN, 16));
				buttonAllgemeineDatenAnzeigen.setBounds(634, 78, 199, 72);
				Utils.standardButtonOptions(buttonAllgemeineDatenAnzeigen);
				panel.add(buttonAllgemeineDatenAnzeigen);
			}
		}
	}
}
