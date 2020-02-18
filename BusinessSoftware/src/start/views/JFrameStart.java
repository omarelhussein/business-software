package start.views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import general.code.Utils;
import general.design.Colors;
import general.design.Fonts;
import mitarbeiter.dao.DaoMitarbeiter;
import start.login.dao.Daoanmelden;
import start.login.views.JFrameAnmelden;
import start.register.views.JFrameRegistrieren;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created on 25.11.2019
 * 
 * @author ajab, omar
 *
 */
public class JFrameStart extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel labelGeschftErstellen;
	private JButton btnStartGeschaeft;
	private JButton btnWeiterAlsGast;
	private JButton buttonI;
	private JButton btnAnmelden;
	public static boolean wegRegistierung = false;
	Daoanmelden daoanmelden;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameStart frame = new JFrameStart();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ClassNotFoundException 
	 */
	public JFrameStart() {
		daoanmelden=new Daoanmelden();
		initGUI();
	}

	private void initGUI() {
		setTitle("Business Software");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// position in center
		Utils.setMainFrameOptions(this);
		contentPane = new JPanel();
		contentPane.setBackground(Colors.parseColor(Colors.LIGHT_GREY));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			panel = new JPanel();
			Utils.setMainInternalFrameOptions(panel);
			panel.setBounds(50, 110, 800, 400);
			panel.setBackground(Colors.parseColor(Colors.LIGHT_PINK));
			contentPane.add(panel);
			panel.setLayout(null);
			{
				btnStartGeschaeft = new JButton("Starte dein Gesch\u00E4ft");
			
				btnStartGeschaeft.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							do_btnStartGeschaeft_actionPerformed(arg0);
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
				btnStartGeschaeft.setBorder(new LineBorder(new Color(0, 0, 0)));
				btnStartGeschaeft.setBackground(new Color(255, 228, 225));
				btnStartGeschaeft.setFocusable(false);
				btnStartGeschaeft.setRolloverEnabled(false);
				btnStartGeschaeft.setFont(new Font("Century Schoolbook", Font.PLAIN, 18));
				btnStartGeschaeft.setBounds(198, 82, 368, 47);
				panel.add(btnStartGeschaeft);
			}
			{
				btnWeiterAlsGast = new JButton("Weiter als Gast");
				btnWeiterAlsGast.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						btnWeiterAlsGast(arg0);
					}
				});
				btnWeiterAlsGast.setBorder(new LineBorder(new Color(0, 0, 0)));
				btnWeiterAlsGast.setBackground(new Color(255, 228, 225));
				btnWeiterAlsGast.setFocusable(false);
				btnWeiterAlsGast.setRolloverEnabled(false);
				btnWeiterAlsGast.setFont(new Font("Century Schoolbook", Font.PLAIN, 18));
				btnWeiterAlsGast.setBounds(198, 164, 368, 47);
				panel.add(btnWeiterAlsGast);
			}
			{
				buttonI = new JButton("i");
				buttonI.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						onInfoClicked(arg0);
					}
				});
				Utils.setStandardButtonOptions(buttonI);
				Fonts.setCenturySchoolbookFont(buttonI, 24);
				buttonI.setBounds(578, 82, 52, 47);
				panel.add(buttonI);
			}
			{
				btnAnmelden = new JButton("Anmelden");
				btnAnmelden.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							onAnmeldenClicked(arg0);
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
				btnAnmelden.setRolloverEnabled(false);
				btnAnmelden.setFont(new Font("Century Schoolbook", Font.PLAIN, 18));
				btnAnmelden.setFocusable(false);
				btnAnmelden.setBorder(new LineBorder(new Color(0, 0, 0)));
				btnAnmelden.setBackground(new Color(255, 228, 225));
				btnAnmelden.setBounds(198, 246, 368, 47);
				panel.add(btnAnmelden);
			}
		}
		{
			labelGeschftErstellen = new JLabel("Gesch\u00E4ft Erstellen");
			labelGeschftErstellen.setForeground(SystemColor.textHighlight);
			labelGeschftErstellen.setFont(new Font("Century Schoolbook", Font.PLAIN, 28));
			labelGeschftErstellen.setHorizontalAlignment(SwingConstants.CENTER);
			labelGeschftErstellen.setBounds(48, 38, 800, 58);
			contentPane.add(labelGeschftErstellen);
		}
	}

	/**
	 * @author omar
	 * @param arg0 action event
	 */
	protected void btnWeiterAlsGast(ActionEvent arg0) {
		BesuchAlsGast newJFrame=new BesuchAlsGast();
		Utils.startNewJFrame(this, newJFrame);
	}

	/**
	 * @author omar
	 * @param msg message output in the pane
	 */
	private void showPane(String msg) {
		JOptionPane.showMessageDialog(this, msg);
	}
	/**
	 * created by Omar on 12.01.2020
	 * teil davon aref
	 * @param arg0
	 */

	protected void onAnmeldenClicked(ActionEvent arg0) throws ClassNotFoundException {
		if(daoanmelden.nameGeascheaft()[0].equals("")) {
			JOptionPane.showMessageDialog(null, "leider keine Gäschäfte vorhanden");
			return;
		}
		JFrameAnmelden jFrameAnmelden = new JFrameAnmelden();
		Utils.startNewJFrame(this, jFrameAnmelden);
	}

	protected void do_btnStartGeschaeft_actionPerformed(ActionEvent arg0) throws ClassNotFoundException {
		wegRegistierung = false;
		JFrameRegistrieren regstieren = new JFrameRegistrieren();
		regstieren.setVisible(true);
		this.setVisible(false);
	}

	/**
	 * created by Omar on 12.01.2020
	 * 
	 * @param arg0
	 */
	protected void onInfoClicked(ActionEvent arg0) {
		showPane(
				"Falls Sie noch kein eigenes Geschنft erstellt haben, kِnnen Sie auf \"Starte dein Geschنft\" klicken und den Prozess durchführen, "
						+ "\num Ihre Organisation zu erstellen. Ansonsten melden Sie sich an");
	}

}
