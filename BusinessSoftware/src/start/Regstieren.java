package start;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.Anschrift;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

import general.Utils;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.TextField;

public class Regstieren extends JFrame {

	private JPanel contentPane;
	private JTextField namedergeschaeft;
	private JTextField textField_bezeichnung;
	private JLabel lblNameDerGschaeft;
	private JTextField textField_pass;
	private JLabel lblNewLabel;
	private JLabel lblPass;
	private JTextField textField_stadt;
	private JLabel lblNewLabel_1;
	private JTextField textField_Tel;
	private JLabel lblTel;
	private JTextField textField_anschrift;
	private JLabel lblNewLabel_2;
	private JButton btnNewButton;
	private Daomelden daomelden;
	private Anschrift anschrift;
	private Gescheaft gescheaft;
	private JPanel panel;
	private JLabel lblNewLabel_3;
	private boolean textnutz=true;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Regstieren frame = new Regstieren();
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
	public Regstieren() throws ClassNotFoundException {
		initGUI();
		daomelden=new Daomelden();
		gescheaft=new Gescheaft();
		anschrift=new Anschrift();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 723, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		Utils.setMainFrameOptions(this);
		contentPane.setLayout(null);
		{
			panel = new JPanel();
			panel.setBackground(new Color(255, 250, 240));
			panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			panel.setBounds(42, 40, 634, 396);
			contentPane.add(panel);
			panel.setLayout(null);
			{
				btnNewButton = new JButton("Registieren");
				btnNewButton.setBorder(new LineBorder(new Color(0,0,0)));
				btnNewButton.setBackground(new Color(240, 240, 240));
				btnNewButton.setForeground(SystemColor.activeCaptionText);
				btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
				btnNewButton.setBounds(401, 343, 205, 42);
				panel.add(btnNewButton);
				{
					lblNameDerGschaeft = new JLabel("Name der G\u00E4schaeft");
					lblNameDerGschaeft.setFont(new Font("Tahoma", Font.PLAIN, 13));
					lblNameDerGschaeft.setBounds(21, 11, 148, 25);
					panel.add(lblNameDerGschaeft);
				}
				{
					lblNewLabel = new JLabel("Bezeichnung");
					lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
					lblNewLabel.setBounds(21, 66, 99, 25);
					panel.add(lblNewLabel);
				}
				{
					lblPass = new JLabel("pass");
					lblPass.setFont(new Font("Tahoma", Font.PLAIN, 13));
					lblPass.setBounds(21, 107, 79, 17);
					panel.add(lblPass);
				}
				{
					lblNewLabel_1 = new JLabel("stadt");
					lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
					lblNewLabel_1.setBounds(21, 155, 79, 20);
					panel.add(lblNewLabel_1);
				}
				{
					lblTel = new JLabel("Tel ");
					lblTel.setFont(new Font("Tahoma", Font.PLAIN, 13));
					lblTel.setBounds(21, 221, 46, 14);
					panel.add(lblTel);
				}
				{
					lblNewLabel_2 = new JLabel("Anscgrift");
					lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
					lblNewLabel_2.setBounds(21, 271, 79, 20);
					panel.add(lblNewLabel_2);
				}
				{
					namedergeschaeft = new JTextField();
					namedergeschaeft.setBounds(252, 11, 175, 25);
					panel.add(namedergeschaeft);
					namedergeschaeft.setColumns(10);
				}
				{
					textField_stadt = new JTextField();
					textField_stadt.setBounds(252, 153, 177, 25);
					panel.add(textField_stadt);
					textField_stadt.setColumns(10);
				}
				{
					textField_Tel = new JTextField();
					textField_Tel.setBounds(252, 216, 175, 25);
					panel.add(textField_Tel);
					
					textField_Tel.setColumns(10);
				}
				{
					textField_anschrift = new JTextField();
					textField_anschrift.setBackground(new Color(255, 255, 255));
					textField_anschrift.setBounds(252, 266, 175, 25);
					panel.add(textField_anschrift);
					textField_anschrift.setColumns(10);
				}
				{
					textField_pass = new JTextField();
					textField_pass.setBounds(252, 105, 175, 25);
					panel.add(textField_pass);
					textField_pass.setColumns(10);
				}
				{
					textField_bezeichnung = new JTextField();
					textField_bezeichnung.setBounds(252, 63, 175, 25);
					panel.add(textField_bezeichnung);
					textField_bezeichnung.setColumns(10);
				}
				{
					lblNewLabel_3 = new JLabel("Registration");
					lblNewLabel_3.setForeground(SystemColor.textHighlight);
					lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
					lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
					lblNewLabel_3.setBounds(251, 11, 218, 25);
					contentPane.add(lblNewLabel_3);
				}
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						do_btnNewButton_actionPerformed(arg0);
					}
				});
			}
		}
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent arg0) {
		boolean genutzt=true;
		textnutz=true;
		boolean [] textBenutzung=new boolean[6];
		textBenutzung[0]=textFullen(namedergeschaeft);
		textBenutzung[1]=textFullen(textField_pass);
		textBenutzung[2]=textFullen(textField_bezeichnung);
		textBenutzung[3]=textFullen(textField_stadt);
		textBenutzung[4]=textFullen(textField_Tel);
		textBenutzung[5]=textFullen(textField_anschrift);
		genutzt=texteprüfen(textBenutzung);
		
		if(genutzt==false) {
	JOptionPane.showMessageDialog(null, "Bitte fullen si edie rote felder");
		}else if(genutzt==true) {
		gescheaft.setNamegeascheaft(namedergeschaeft.getText()); 
		gescheaft.setBezeichnung(textField_bezeichnung.getText());
		gescheaft.setPass(textField_pass.getText());
		anschrift.setStadt(textField_stadt.getText()); 
		anschrift.setTel(textField_Tel.getText()); 
		anschrift.setAdressse(textField_anschrift.getText()); 
		System.out.println("das ist die"+gescheaft.getBezeichnung());
		
		daomelden.insert(anschrift,gescheaft);
		}
		
	}
	//aref
	private boolean textFullen(JTextField field) {
		boolean textnichtleher;
		if(field.getText().equals("")) {
			textnichtleher=false;
			field.setBorder(new LineBorder(new Color(237,19,11)));         
			
		}else {
			textnichtleher=true;
		}
		return textnichtleher;
		
	}
	//aref
	private boolean texteprüfen(boolean [] textBenutzung) {
		
		for (boolean b : textBenutzung) {
			if (b==false) {
				textnutz=b;	
			}else {
				
			}
			
		}
		return textnutz;
	}
}
