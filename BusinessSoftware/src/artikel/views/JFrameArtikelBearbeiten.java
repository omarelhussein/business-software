package artikel.views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import abteilungen.DaoAbteilung;
import artikel.DaoArtikel;
import artikel.business_classes.Artikel;
import registrierung.JFrameRegistrieren;
import start.views.JFrameStart;

public class JFrameArtikelBearbeiten extends JFrame {

	private JPanel contentPane;
	private JLabel labelArtikelBearbeiten;
	private JTextField nameArtikel;
	private JTextField preisArtikel;
	private JButton buttonSpeichern;
	private JTextField nameKatigore;
	private JComboBox comboBox;
	DaoAbteilung abteilung;
	Artikel artikel;
	DaoArtikel daoArtikel;
	JFrameRegistrieren frameRegistrieren;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameArtikelBearbeiten frame = new JFrameArtikelBearbeiten();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws ClassNotFoundException
	 */
	public JFrameArtikelBearbeiten() throws ClassNotFoundException {
		abteilung = new DaoAbteilung();
		artikel = new Artikel();
		daoArtikel = new DaoArtikel();
		frameRegistrieren = new JFrameRegistrieren();
		initGUI();

	}

	private void initGUI() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			labelArtikelBearbeiten = new JLabel("Artikel Bearbeiten");
			labelArtikelBearbeiten.setBounds(116, 25, 110, 22);
			contentPane.add(labelArtikelBearbeiten);
		}
		{
			nameArtikel = new JTextField();
			nameArtikel.setBounds(116, 176, 116, 22);
			contentPane.add(nameArtikel);
			nameArtikel.setColumns(10);
		}
		{
			preisArtikel = new JTextField();
			preisArtikel.setBounds(116, 228, 116, 22);
			contentPane.add(preisArtikel);
			preisArtikel.setColumns(10);
		}
		{
			buttonSpeichern = new JButton("Speichern");
			buttonSpeichern.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					do_buttonSpeichern_actionPerformed(e);
				}
			});
			buttonSpeichern.setBounds(93, 411, 97, 25);
			contentPane.add(buttonSpeichern);
		}
		{
			nameKatigore = new JTextField();
			nameKatigore.setBounds(77, 114, 184, 20);
			contentPane.add(nameKatigore);
			nameKatigore.setColumns(10);
		}
		{
			comboBox = new JComboBox();
			comboBox.setBounds(418, 151, 127, 20);
			if (!JFrameStart.wegRegistierung) {
				comboBox.setModel(new DefaultComboBoxModel(abteilung.Abteilungen(frameRegistrieren.nameGeascheaft)));
				System.out.println(frameRegistrieren.nameGeascheaft);
			}

			contentPane.add(comboBox);
		}
	}

	protected void do_buttonSpeichern_actionPerformed(ActionEvent e) {
		String katihor;
		artikel.setNameArtikel(nameArtikel.getText());
		artikel.setPreis(preisArtikel.getText());
		katihor = nameKatigore.getText();
		daoArtikel.insertArtkel(artikel, katihor, comboBox.getSelectedItem().toString());

	}
}
