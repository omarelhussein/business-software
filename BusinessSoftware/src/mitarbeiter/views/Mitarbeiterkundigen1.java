package mitarbeiter.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import abteilungen.DaoAbteilung;
import general.code.GeschaeftDB;
import general.code.Utils;
import general.design.Colors;
import mitarbeiter.dao.DaoMitarbeiter;
import mitarbeiter.dao.Printjob;

import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class Mitarbeiterkundigen1 extends JFrame {

	private JPanel contentPane;
	private JTextPane grundkendigung;
	private JLabel lblDa;
	private JButton btnKundigen;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	DaoAbteilung abteilung;
	DaoMitarbeiter daoMitarbeiter;
	private JLabel lblGrund;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mitarbeiterkundigen1 frame = new Mitarbeiterkundigen1();
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
	public Mitarbeiterkundigen1() {
		abteilung=new  DaoAbteilung();
		daoMitarbeiter=new DaoMitarbeiter();
		initGUI();
	}
	private void initGUI() {
		Utils.setSmallFrameOptions(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Colors.parseColor(Colors.LIGHT_GREY));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			grundkendigung = new JTextPane();
			grundkendigung.setBounds(32, 81, 112, 126);
			contentPane.add(grundkendigung);
		}
		{
			lblDa = new JLabel("da :");
			lblDa.setBounds(10, 81, 46, 14);
			contentPane.add(lblDa);
		}
		{
			btnKundigen = new JButton("kundigen");
			btnKundigen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					do_btnKundigen_actionPerformed(arg0);
				}
			});
			btnKundigen.setBounds(280, 211, 89, 23);
			contentPane.add(btnKundigen);
		}
		{
			comboBox = new JComboBox();
			comboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					do_comboBox_actionPerformed(arg0);
				}
			});
			comboBox.setModel(new DefaultComboBoxModel(abteilung.Abteilungen(GeschaeftDB.getInstance().getCurrentAccountName())));
			comboBox.setBounds(244, 22, 126, 20);
			contentPane.add(comboBox);
		}
		{
			comboBox_1 = new JComboBox();
			comboBox_1.setBounds(244, 92, 125, 20);
			comboBox_1.setModel(new DefaultComboBoxModel(arraytoarray()));
			contentPane.add(comboBox_1);
		}
		{
			lblGrund = new JLabel("Grund");
			lblGrund.setBounds(35, 56, 46, 14);
			contentPane.add(lblGrund);
		}
	}
	protected void do_comboBox_actionPerformed(ActionEvent arg0) {
		comboBox_1.setModel(new DefaultComboBoxModel(arraytoarray()));
	}
	protected void do_btnKundigen_actionPerformed(ActionEvent arg0) {
		daoMitarbeiter.deletMitarbeiter(comboBox.getSelectedItem().toString(),comboBox_1.getSelectedItem().toString());
		System.out.println(comboBox_1.getSelectedItem().toString());
		
		MitarbeiterKundigen newJFrame =new MitarbeiterKundigen(grundkendigung.getText(),comboBox_1.getSelectedItem().toString());
		Utils.startNewJFrame(this, newJFrame);
		
	}
	private String[] arraytoarray() {
		String [] mitarbeString=new String[daoMitarbeiter.loadMitarbeiter(GeschaeftDB.getInstance().getCurrentAccountName(), comboBox.getSelectedItem().toString()).length];
		for (int i = 0; i < mitarbeString.length; i++) {
			mitarbeString[i]=daoMitarbeiter.loadMitarbeiter(GeschaeftDB.getInstance().getCurrentAccountName(), comboBox.getSelectedItem().toString())[i].getNamemitarbeiter();
			
		}
		return mitarbeString;
		
	}
 	
}
