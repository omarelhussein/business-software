package main.views;

import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import abteilungen.views.JFrameAbteilungAnzeigen;
import abteilungen.views.JFrameAbteilungVerarbeiten;
import abteilungen.views.JFrameAbteilunghinzufuegen;
import artikel.views.JFrameArtikelAnzeigen;
import artikel.views.JFrameArtikelAnzeigenButton;
import artikel.views.JFrameArtikelBearbeiten;
import artikel.views.JFrameArtikelHinzufuegen;
import general.code.Utils;
import general.design.Colors;
import general.design.Fonts;
import mitarbeiter.views.JFrameMitarbeiterAnzeigen;
import mitarbeiter.views.JFrameMitarbeiterBearbeiten;
import mitarbeiter.views.JFrameMitarbeiterHinzufuegen;
import start.register.views.JFrameRegistrieren;
import start.views.JFrameStart;

/**
 * 
 * @author ajab
 *
 */
@SuppressWarnings("serial")
public class JFrameMain extends JFrame {

	private JPanel contentPane;
	private JButton btnAbteilungBearbeiten;
	private JLabel labelMainTitle;
	private JPanel panel;
	private JButton btnMitarbeiterAnzeigen;
	private JMenuBar menuBar;
	private JMenu menuSettings;
	private JMenuItem menuItemLogout;
	private JLabel labelNewLabel;
	private JSeparator separator_horizontal;
	private JSeparator separator_vertical_left;
	private JButton buttonArtikelAnzeigen;
	private JSeparator separator_vertical_right;
	private JButton buttonAbteilungAnzeigen;
	private JButton buttonArtikelVerwalten;
	private JButton buttonMitarbeiterVerwalten;
	private JLabel labelAnzeigenVerwalten;
	private JLabel labelGeschftBereich;
	private JButton buttonAllgemeineDatenAnzeigen;
	private String[] ausgewealtAbteilung;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameMain frame = new JFrameMain();
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
	public JFrameMain() {
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
					menuItemLogout.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							menuItemLogoutActionPerformed(e);
						}
					});
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
			labelMainTitle = new JLabel(JFrameRegistrieren.nameGeascheaft);
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
				btnAbteilungBearbeiten = new JButton("Abteilung verwalten");
				btnAbteilungBearbeiten.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							onManageAbteilungClicked(e);
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				Utils.setStandardButtonOptions(btnAbteilungBearbeiten);
				btnAbteilungBearbeiten.setBounds(337, 262, 199, 46);
				panel.add(btnAbteilungBearbeiten);
				btnAbteilungBearbeiten.setFont(new Font("Tahoma", Font.PLAIN, 16));
			}
			{
				btnMitarbeiterAnzeigen = new JButton("Mitarbeiter anzeigen");
				btnMitarbeiterAnzeigen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						onMitarbeiterAnzeigenClicked(e);
					}
				});
				btnMitarbeiterAnzeigen.setFont(new Font("Tahoma", Font.PLAIN, 16));
				Utils.setStandardButtonOptions(btnMitarbeiterAnzeigen);
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
				separator_horizontal = new JSeparator();
				separator_horizontal.setBounds(0, 47, 864, 1);
				panel.add(separator_horizontal);
				separator_horizontal.setForeground(Color.BLACK);
				separator_horizontal.setBackground(Color.CYAN);
			}
			{
				separator_vertical_left = new JSeparator();
				separator_vertical_left.setOrientation(SwingConstants.VERTICAL);
				separator_vertical_left.setBounds(281, 0, 1, 447);
				panel.add(separator_vertical_left);
			}
			{
				separator_vertical_right = new JSeparator();
				separator_vertical_right.setOrientation(SwingConstants.VERTICAL);
				separator_vertical_right.setBounds(600, 0, 1, 447);
				panel.add(separator_vertical_right);
			}
			{
				buttonArtikelAnzeigen = new JButton("Artikel anzeigen");
				buttonArtikelAnzeigen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						buttonArtikelAnzeigenActionPerformed(e);
					}
				});
				buttonArtikelAnzeigen.setFont(new Font("Tahoma", Font.PLAIN, 16));
				buttonArtikelAnzeigen.setBounds(43, 169, 199, 46);
				Utils.setStandardButtonOptions(buttonArtikelAnzeigen);
				panel.add(buttonArtikelAnzeigen);
			}
			{
				buttonAbteilungAnzeigen = new JButton("Abteilung anzeigen");
				buttonAbteilungAnzeigen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							buttonAbteilungAnzeigenActionPerformed(e);
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				buttonAbteilungAnzeigen.setFont(new Font("Tahoma", Font.PLAIN, 16));
				buttonAbteilungAnzeigen.setBounds(43, 262, 199, 46);
				Utils.setStandardButtonOptions(buttonAbteilungAnzeigen);
				panel.add(buttonAbteilungAnzeigen);
			}
			{
				buttonArtikelVerwalten = new JButton("Artikel verwalten");
				buttonArtikelVerwalten.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							buttonArtikelVerwaltenActionPerformed(e);
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				buttonArtikelVerwalten.setFont(new Font("Tahoma", Font.PLAIN, 16));
				buttonArtikelVerwalten.setBounds(337, 169, 199, 46);
				Utils.setStandardButtonOptions(buttonArtikelVerwalten);
				panel.add(buttonArtikelVerwalten);
			}
			{
				buttonMitarbeiterVerwalten = new JButton("Mitarbeiter verwalten");
				buttonMitarbeiterVerwalten.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							onManageMitarbeiterClicked(arg0);
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
				buttonMitarbeiterVerwalten.setFont(new Font("Tahoma", Font.PLAIN, 16));
				buttonMitarbeiterVerwalten.setBounds(337, 78, 199, 46);
				Utils.setStandardButtonOptions(buttonMitarbeiterVerwalten);
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
				labelGeschftBereich = new JLabel("Gesch\u00E4ftsdaten");
				labelGeschftBereich.setHorizontalAlignment(SwingConstants.CENTER);
				labelGeschftBereich.setForeground(SystemColor.textHighlight);
				labelGeschftBereich.setFont(new Font("Tahoma", Font.PLAIN, 15));
				labelGeschftBereich.setBounds(634, 11, 199, 25);
				panel.add(labelGeschftBereich);
			}
			{
				buttonAllgemeineDatenAnzeigen = new JButton(
						"<html>Allgemeine Daten<br/><center>anzeigen</center></html>");
				buttonAllgemeineDatenAnzeigen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						buttonAllgemeineDatenAnzeigenActionPerformed(e);
					}
				});
				buttonAllgemeineDatenAnzeigen.setFont(new Font("Tahoma", Font.PLAIN, 16));
				buttonAllgemeineDatenAnzeigen.setBounds(634, 78, 199, 72);
				Utils.setStandardButtonOptions(buttonAllgemeineDatenAnzeigen);
				panel.add(buttonAllgemeineDatenAnzeigen);
			}
		}
	}

	/**
	 * Created by Mohammad on 07.01.2020 methode von Ajabnoor 14.1.2020
	 * 
	 * @param arg0 action event Handles the click by Manage Mitarbeiter Click
	 * @throws ClassNotFoundException
	 */
	protected void onManageMitarbeiterClicked(ActionEvent arg0) throws ClassNotFoundException {
		String title = "Mehrfach Optionen zu Mitarbeiter verwalten";
		String[] buttons = { "Mitarbeiter hinzufügen", "Mitarbeiter verwalten" };
		JFrameMitarbeiterHinzufuegen jFrame1 = new JFrameMitarbeiterHinzufuegen();
		JFrameMitarbeiterBearbeiten jFrame2 = new JFrameMitarbeiterBearbeiten();
		verwaltenDialog(title, buttons, jFrame1, jFrame2);
	}

	/**
	 * Created On 04.01.2020 Created By Omar
	 * 
	 * @param e
	 * @throws ClassNotFoundException
	 */
	protected void onManageAbteilungClicked(ActionEvent e) throws ClassNotFoundException {
		String title = "Mehrfach Optionen zu Abteilung verwalten";
		String[] buttons = { "Abteilung hinzufügen", "Abteilung verwalten" };
		JFrameAbteilunghinzufuegen jFrame1 = new JFrameAbteilunghinzufuegen();
		JFrameAbteilungVerarbeiten jFrame2 = new JFrameAbteilungVerarbeiten();
		// methode wieder verwendbar als Dialog
		verwaltenDialog(title, buttons, jFrame1, jFrame2);
	}

	/**
	 * created by Ajabnoor on 11.01.2020
	 * 
	 * @param title   is the title of the dialog
	 * @param buttons the buttons to show in the dialog
	 * @param jFrame1 the jframe to open on click
	 * @param jFrame2 the jframe to open on other click
	 */
	private void verwaltenDialog(String title, String[] buttons, JFrame jFrame1, JFrame jFrame2) {
		int answer = JOptionPane.showOptionDialog(this, "Wählen Sie eins von den beiden Optionen aus.", title,
				JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, buttons, buttons[0]);
		switch (answer) {
		case 0:
			jFrame1.setVisible(true);
			jFrame1.setAlwaysOnTop(true);
			break;
		case 1:
			jFrame2.setVisible(true);
			jFrame2.setAlwaysOnTop(true);
			break;
		}

	}

	/**
	 * Created by Omar on 24.12.2019
	 * 
	 * @param e
	 */
	protected void menuItemLogoutActionPerformed(ActionEvent e) {
		int answer = JOptionPane.showConfirmDialog(this, "Sicher abmelden?", "Abmelden", 2);
		switch (answer) {
		case 0:
			JFrameStart start = new JFrameStart();
			Utils.reviewOldJFrame(this, start);
			break;
		}
	}

	/**
	 * Created by Mohammad on 07.01.2020
	 * 
	 * 
	 */
	protected void onMitarbeiterAnzeigenClicked(ActionEvent e) {
		JFrameMitarbeiterAnzeigen mitarbeiterAnzeigenSeite = new JFrameMitarbeiterAnzeigen();
		mitarbeiterAnzeigenSeite.setVisible(true);
	}

	/**
	 * Created by Mohammad on 07.01.2020
	 */

	protected void buttonArtikelAnzeigenActionPerformed(ActionEvent e) {
		JFrameArtikelAnzeigen artikelAnzeigenSeite = new JFrameArtikelAnzeigen();
		artikelAnzeigenSeite.setVisible(true);
	}

	/**
	 * Created by Mohammad on 07.01.2020
	 * 
	 * @throws ClassNotFoundException
	 * 
	 */

	protected void buttonAbteilungAnzeigenActionPerformed(ActionEvent e) throws ClassNotFoundException {
		JFrameAbteilungAnzeigen abteilungAnzeigenSeite = new JFrameAbteilungAnzeigen();
		abteilungAnzeigenSeite.setVisible(true);

	}

	/**
	 * Created by Mohammad on 07.01.2020
	 * 
	 * @throws ClassNotFoundException edited: methoden hinzufügen von Ajabnoor
	 *                                14.10.2020
	 */
	protected void buttonArtikelVerwaltenActionPerformed(ActionEvent e) throws ClassNotFoundException {
		String title = "Mehrfach Optionen zu Artikel verwalten";
		String[] buttons = { "Artikel hinzufügen", "Artikel verwalten" };

		JFrameArtikelHinzufuegen jFrame1 = new JFrameArtikelHinzufuegen();
		JFrameArtikelBearbeiten jFrame2 = new JFrameArtikelBearbeiten();

		verwaltenDialog(title, buttons, jFrame1, jFrame2);
	}

	/**
	 * Created by Mohammad on 07.01.2020
	 */

	protected void buttonAllgemeineDatenAnzeigenActionPerformed(ActionEvent e) {
		JFrameAllgemeineGeschaeftsDaten geschaeftsDatenAnzeigen = new JFrameAllgemeineGeschaeftsDaten();
		geschaeftsDatenAnzeigen.setVisible(true);
	}
}
