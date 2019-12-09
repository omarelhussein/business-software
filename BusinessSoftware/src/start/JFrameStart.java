package start;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;

import general.Colors;
import general.Fonts;
import general.Utils;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Created on 25.11.2019
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
	 */
	public JFrameStart() {
		initGUI();
	}
	private void initGUI() {
		setTitle("Business Software");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//position in center
		Utils.setMainFrameOptions(this);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			panel = new JPanel();
			panel.setForeground(Color.decode(Colors.LIGHT_YELLOW));
			panel.setBorder(new LineBorder(new Color(0, 0, 0)));
			panel.setBackground(new Color(255, 250, 250));
			panel.setBounds(48, 109, 800, 400);
			contentPane.add(panel);
			panel.setLayout(null);
			{
				btnStartGeschaeft = new JButton("Starte dein Gesch\u00E4ft");
				btnStartGeschaeft.setBorder(new LineBorder(new Color(0, 0, 0)));
				btnStartGeschaeft.setBackground(new Color(255, 228, 225));
				btnStartGeschaeft.setFocusable(false);
				btnStartGeschaeft.setRolloverEnabled(false);
				Fonts.setCenturySchoolbookFont(btnStartGeschaeft, 18);
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
				Fonts.setCenturySchoolbookFont(btnWeiterAlsGast, 18);
				btnWeiterAlsGast.setBounds(198, 164, 368, 47);
				panel.add(btnWeiterAlsGast);
			}
			{
				buttonI = new JButton("i");
				buttonI.setFocusable(false);
				buttonI.setBackground(Color.GRAY);
				Fonts.setCenturySchoolbookFont(buttonI, 18);
				buttonI.setForeground(Color.RED);
				buttonI.setAlignmentY(Component.BOTTOM_ALIGNMENT);
				buttonI.setBounds(578, 82, 52, 47);
				panel.add(buttonI);
			}
			{
				btnAnmelden = new JButton("Anmelden");
				btnAnmelden.setRolloverEnabled(false);
				Fonts.setCenturySchoolbookFont(btnAnmelden, 18);
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
		showPane("Feature kommt irgendwann...");
	}

	/**
	 * @author omar
	 * @param msg message output in the pane
	 */
	private void showPane(String msg) {
		JOptionPane.showMessageDialog(this, msg);
	}
}
