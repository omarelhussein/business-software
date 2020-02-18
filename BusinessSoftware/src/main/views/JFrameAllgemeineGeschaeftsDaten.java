package main.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import abteilungen.DaoAbteilung;
import abteilungen.business_classes.Abteilung;
import artikel.DaoArtikel;
import general.code.GeschaeftDB;
import general.code.Utils;
import general.design.Colors;
import general.design.Fonts;
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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.SwingConstants;

public class JFrameAllgemeineGeschaeftsDaten extends JFrame {

	private JPanel contentPane;
	private JButton buttonAnzeigen;
	DaoMitarbeiter daoMitarbeiter;
	DaoAbteilung abteilung;
	DaoArtikel artikel;
	private JTextPane textPane;
	private JScrollPane scrollPane;
	private JLabel labelNewLabel;

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
		daoMitarbeiter = new DaoMitarbeiter();
		abteilung = new DaoAbteilung();
		artikel = new DaoArtikel();
		initGUI();
	}

	private void initGUI() {
		Utils.setMiddleFrameOptions(this);
		contentPane = new JPanel();

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			buttonAnzeigen = new JButton("Anzeigen");
			Utils.setStandardButtonOptions(buttonAnzeigen);
			buttonAnzeigen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					buttonAnzeigenActionPerformed(e);
				}
			});
			buttonAnzeigen.setBounds(10, 567, 616, 36);
			contentPane.add(buttonAnzeigen);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 76, 616, 481);
			contentPane.add(scrollPane);
			{
				textPane = new JTextPane();
				textPane.setEditable(false);
				scrollPane.setViewportView(textPane);
			}
		}
		{
			labelNewLabel = new JLabel(GeschaeftDB.getInstance().getCurrentAccountName());
			labelNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			Fonts.setCenturySchoolbookFont(labelNewLabel, 20);
			labelNewLabel.setForeground(Colors.parseColor(Colors.SEXY_BLUE));
			labelNewLabel.setBounds(10, 10, 616, 56);
			contentPane.add(labelNewLabel);
		}
	}

	protected void buttonAnzeigenActionPerformed(ActionEvent e) {
		textPane.setVisible(true);
		textPane.setText("\nGeschäft Liste >>>" + GeschaeftDB.getInstance().getCurrentAccountName()
				+ "\n\n\nAbteilungen>>>\n" + arraytoString() + "\n\nMitarbeiter Namen>>>\n" + mitarbeiter()
				+ "\n\nArtikel Namen>>>\n" + Artikel());
	}

	private String mitarbeiter() {
		int y = 0;
		String mitarbeiter = "";
		for (int i = 0; i < daoMitarbeiter.loadMitarbeiter(abteilungID()[y]).length; i++) {
			mitarbeiter += daoMitarbeiter.loadMitarbeiter(abteilungID()[y])[i].getNamemitarbeiter() + "\n";
			if (i == daoMitarbeiter.loadMitarbeiter(abteilungID()[y]).length && y != abteilungID().length) {
				y++;
			}
		}
		return mitarbeiter;

	}

	private int[] abteilungID() {
		int[] IDs = new int[abteilung.Abteilungen(GeschaeftDB.getInstance().getCurrentAccountName()).length];
		for (int i = 0; i < IDs.length; i++) {
			IDs[i] = abteilung.Abteilungen(GeschaeftDB.getInstance().getCurrentAccountName())[i].getId();
		}
		return IDs;
	}

	private String arraytoString() {
		String Abteilungen = "";
		for (int i = 0; i < abteilungID().length; i++) {
			Abteilungen += abteilung.Abteilungen(GeschaeftDB.getInstance().getCurrentAccountName())[i]
					.getNameAbteilung() + "\n";
		}
		return Abteilungen;
	}

	private String Artikel() {
		String artike = "";
		int length = abteilung.Abteilungen(GeschaeftDB.getInstance().getCurrentAccountName()).length;
		for (int i = 0; i < length; i++) {
			int categorieLength = artikel.loadAbteilungArtikeln(
					abteilung.Abteilungen(GeschaeftDB.getInstance().getCurrentAccountName())[i].getId()).size();
			for (int j = 0; j < categorieLength; j++) {
				artike += artikel.loadAbteilungArtikeln(abteilungID()[i]).get(j).getNameArtikel() + "\n";
			}
		}
		return artike;
	}
}
