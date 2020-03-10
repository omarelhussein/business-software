package mitarbeiter.views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import abteilungen.DaoAbteilung;
import abteilungen.business_classes.Abteilung;
import general.code.GeschaeftDB;
import general.code.JComboBoxAdapter;
import general.code.Utils;
import general.design.Colors;
import mitarbeiter.business_classes.Mitarbeiter;
import mitarbeiter.dao.DaoMitarbeiter;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class MitarbeiterkundigenFormular extends JFrame {

	private JPanel contentPane;
	private JTextPane grundkendigung;
	private JLabel lblDa;
	private JButton btnKundigen;
	private JComboBox<Abteilung> comboBox;
	private JComboBox<Mitarbeiter> comboBox_1;
	DaoAbteilung abteilung;
	DaoMitarbeiter daoMitarbeiter;
	private JLabel lblGrund;
	private JLabel labelNewLabel;
	private JLabel labelNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MitarbeiterkundigenFormular frame = new MitarbeiterkundigenFormular();
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
	public MitarbeiterkundigenFormular() {
		abteilung = new DaoAbteilung();
		daoMitarbeiter = new DaoMitarbeiter();
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
			grundkendigung.setBorder(new LineBorder(new Color(0, 0, 0)));
			grundkendigung.setBounds(32, 36, 209, 314);
			contentPane.add(grundkendigung);
		}
		{
			lblDa = new JLabel("da :");
			lblDa.setBounds(10, 36, 25, 14);
			contentPane.add(lblDa);
		}
		{
			btnKundigen = new JButton("K\u00FCndigen");
			btnKundigen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					do_btnKundigen_actionPerformed(arg0);
				}
			});
			Utils.setStandardButtonOptions(btnKundigen);
			btnKundigen.setBounds(251, 327, 123, 23);
			contentPane.add(btnKundigen);
		}
		{
			comboBox = new JComboBox<>(abteilung.Abteilungen(GeschaeftDB.getInstance().getCurrentAccountName()));
			comboBox.setRenderer(new JComboBoxAdapter(new Abteilung()));
			comboBox.setBackground(Colors.parseColor(Colors.LIGHT_PINK));
			comboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					do_comboBox_actionPerformed(arg0);
				}
			});
			comboBox.setBounds(248, 60, 126, 20);
			contentPane.add(comboBox);
		}
		{
			comboBox_1 = new JComboBox<>(getMitarbeiter());
			comboBox_1.setRenderer(new JComboBoxAdapter(new Mitarbeiter()));
			comboBox_1.setBackground(Colors.parseColor(Colors.LIGHT_PINK));
			comboBox_1.setBounds(251, 113, 125, 20);
			contentPane.add(comboBox_1);
		}
		{
			lblGrund = new JLabel("Grund f\u00FCr die K\u00FCndigung: ");
			lblGrund.setBounds(32, 11, 209, 14);
			contentPane.add(lblGrund);
		}
		{
			labelNewLabel = new JLabel("Abteilung");
			labelNewLabel.setBounds(248, 36, 77, 14);
			contentPane.add(labelNewLabel);
		}
		{
			labelNewLabel_1 = new JLabel("Mitarbeiter");
			labelNewLabel_1.setBounds(251, 91, 88, 14);
			contentPane.add(labelNewLabel_1);
		}
	}

	protected void do_comboBox_actionPerformed(ActionEvent arg0) {
		comboBox_1.setModel(new DefaultComboBoxModel<>(getMitarbeiter()));
	}

	protected void do_btnKundigen_actionPerformed(ActionEvent arg0) {
		Abteilung currentAbteilung = abteilung.Abteilungen(GeschaeftDB.getInstance().getCurrentAccountName())[comboBox.getSelectedIndex()];
		Mitarbeiter currentMitarbeiter = daoMitarbeiter.loadMitarbeiter(currentAbteilung.getId())[comboBox_1.getSelectedIndex()];
		daoMitarbeiter.deletMitarbeiter(currentAbteilung.getId(), currentMitarbeiter.getId());
		System.out.println(comboBox_1.getSelectedItem().toString());

		MitarbeiterKundigenAusdrucken newJFrame = new MitarbeiterKundigenAusdrucken(grundkendigung.getText(),
				currentMitarbeiter.getNamemitarbeiter());
		Utils.startNewJFrame(this, newJFrame);

	}

	private Mitarbeiter[] getMitarbeiter() {
		Abteilung currentAbteilung = abteilung.Abteilungen(GeschaeftDB.getInstance().getCurrentAccountName())[comboBox
				.getSelectedIndex()];
		
		return daoMitarbeiter.loadMitarbeiter(currentAbteilung.getId());
	}
}
