package main.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import abteilungen.DaoAbteilung;
import artikel.DaoArtikel;
import general.code.GeschaeftDB;
import mitarbeiter.business_classes.Mitarbeiter;
import mitarbeiter.dao.DaoMitarbeiter;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JLabel;

public class JFrameAllgemeineGeschaeftsDaten extends JFrame {

	private JPanel contentPane;
	private JTextPane textPane;
	private JButton buttonAnzeigen;
	DaoMitarbeiter daoMitarbeiter;
	DaoAbteilung abteilung;
	DaoArtikel artikel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameAllgemeineGeschaeftsDaten frame = new JFrameAllgemeineGeschaeftsDaten();
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
	public JFrameAllgemeineGeschaeftsDaten() {
		daoMitarbeiter=new DaoMitarbeiter();
		abteilung =new DaoAbteilung();
		artikel = new DaoArtikel();
		initGUI();
	}
	private void initGUI() {
		
		setBounds(100, 100, 764, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			textPane = new JTextPane();
			textPane.setBounds(22, 10, 678, 393);
			contentPane.add(textPane);
			textPane.setVisible(false);
		}
		{
			buttonAnzeigen = new JButton("Anzeigen");
			buttonAnzeigen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					buttonAnzeigenActionPerformed(e);
				}
			});
			buttonAnzeigen.setBounds(20, 426, 117, 36);
			contentPane.add(buttonAnzeigen);
		}
	}
	protected void buttonAnzeigenActionPerformed(ActionEvent e) {
		textPane.setVisible(true);
		textPane.setText("\n Geschäft Liste "+GeschaeftDB.getInstance().getCurrentAccountName()+"\n\n\nAbteilungen:"+arraytoString()+"\n\n\tMitarbeiter"+mitarbeiter()+"Artikel Name \n\n "+Artikel());
		
	}
	
	private String mitarbeiter() {
		String mitarbeiter="";
		int y=0;
		for (int i = 0; i < daoMitarbeiter.loadMitarbeiter(GeschaeftDB.getInstance().getCurrentAccountName(),Abteilung()[y]).length; i++) {
			mitarbeiter+=daoMitarbeiter.loadMitarbeiter(GeschaeftDB.getInstance().getCurrentAccountName(),Abteilung()[y])[i].getNamemitarbeiter()+"\n";
			if(i==daoMitarbeiter.loadMitarbeiter(GeschaeftDB.getInstance().getCurrentAccountName(),Abteilung()[y]).length&& y!=Abteilung().length) {
				y++;
			}
		}
		return mitarbeiter;
		
	}
	
	private String [] Abteilung() {
		String [] name=new String [abteilung.Abteilungen(GeschaeftDB.getInstance().getCurrentAccountName()).length];
		for (int i = 0; i < abteilung.Abteilungen(GeschaeftDB.getInstance().getCurrentAccountName()).length; i++) {
			name[i]=abteilung.Abteilungen(GeschaeftDB.getInstance().getCurrentAccountName())[i].getNameAbteilung();
		}
		
		return name;
	}
	private String arraytoString() {
		String Abteilungen="";
		for (int i = 0; i < Abteilung().length; i++) {
			Abteilungen+=Abteilung()[i]+"\n";
		}
		return Abteilungen;
	}
	private String Artikel () {
		int y=0;
		String artike="";
		for (int i = 0; i <  artikel.loadAbteilungArtikeln(Abteilung()[y]).size(); i++) {
			artike+=artikel.loadAbteilungArtikeln(Abteilung()[y]).get(i).getNameArtikel()+"\n";
			if(i==artikel.loadAbteilungArtikeln(Abteilung()[y]).size()&&y!=Abteilung().length) {
				y++;
			}
			
			
			
		}
		return artike;
		
	}

		
	}

