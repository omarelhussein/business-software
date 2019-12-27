package start;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;

import general.Colors;
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
				buttonI.setFocusable(false);
				buttonI.setBackground(Color.GRAY);
				buttonI.setFont(new Font("Century Schoolbook", Font.PLAIN, 24));
				buttonI.setForeground(Color.RED);
				buttonI.setAlignmentY(Component.BOTTOM_ALIGNMENT);
				buttonI.setBounds(578, 82, 52, 47);
				panel.add(buttonI);
			}
			{
				btnAnmelden = new JButton("Anmelden");
				btnAnmelden.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						onAnmeldenClicked(arg0);
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
		showPane("Feature kommt irgendwann...");
	}

	/**
	 * @author omar
	 * @param msg message output in the pane
	 */
	private void showPane(String msg) {
		JOptionPane.showMessageDialog(this, msg);
	}
	
	protected void onAnmeldenClicked(ActionEvent arg0) {
		JFrameAnmelden jFrameAnmelden = new JFrameAnmelden();
		Utils.startNewJFrame(this, jFrameAnmelden);
	}
	protected void do_btnStartGeschaeft_actionPerformed(ActionEvent arg0) throws ClassNotFoundException {
		Regstieren regstieren=new Regstieren();
		regstieren.setVisible(true);
		this.setVisible(false);
	}
}
