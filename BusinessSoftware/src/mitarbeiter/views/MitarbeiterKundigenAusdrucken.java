package mitarbeiter.views;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import general.code.GeschaeftDB;
import general.code.Utils;
import general.design.Colors;
import general.design.Fonts;
import mitarbeiter.dao.Printjob;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class MitarbeiterKundigenAusdrucken extends JFrame {

	private JPanel contentPane;
	private JTextArea txtrSeherGeheerteFrauherr;
	private JButton btnNewButton;
	static String grundKundigung;

	private static String string2;
	private JLabel labelNewLabel;
	private JScrollPane scrollPane;

	/**
	 * Create the frame.
	 * 
	 * @param string
	 * @param string2
	 */
	public MitarbeiterKundigenAusdrucken(String string, String string2) {
		grundKundigung = string;
		MitarbeiterKundigenAusdrucken.string2 = string2;
		initGUI();
	}

	private void initGUI() {
		this.setAlwaysOnTop(true);
		Utils.setSmallFrameOptions(this);
		this.setBounds(0, 0, 464, 400);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Colors.parseColor(Colors.LIGHT_GREY));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			Date date = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			{
				scrollPane = new JScrollPane();
				scrollPane.setBounds(10, 47, 428, 276);
				contentPane.add(scrollPane);
				txtrSeherGeheerteFrauherr = new JTextArea();
				scrollPane.setViewportView(txtrSeherGeheerteFrauherr);
				txtrSeherGeheerteFrauherr.setToolTipText("Kundigung");
				txtrSeherGeheerteFrauherr.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));

				txtrSeherGeheerteFrauherr.setText("Seher geheerte Frau/Herr " + string2
						+ "    ,\r\nhermit kundigen wir sie, Datum " + dateFormat.format(date) + "  , da "
						+ grundKundigung + "  \r\n\r\nmit freundlichen Grussen ,\n"
						+ GeschaeftDB.getInstance().getCurrentAccountName());
			}
		}
		{
			btnNewButton = new JButton("K\u00FCndigung Ausdrucken");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						do_btnNewButton_actionPerformed(arg0);
					} catch (PrinterException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			Utils.setStandardButtonOptions(btnNewButton);
			btnNewButton.setBounds(221, 327, 217, 23);
			contentPane.add(btnNewButton);
		}
		{
			labelNewLabel = new JLabel("Formular \u00DCbersicht");
			labelNewLabel.setBounds(10, 11, 376, 25);
			Fonts.setCenturySchoolbookFont(labelNewLabel, 20);
			labelNewLabel.setForeground(Colors.parseColor(Colors.SEXY_BLUE));
			contentPane.add(labelNewLabel);
		}
	}

	protected void do_btnNewButton_actionPerformed(ActionEvent arg0) throws PrinterException {
		Drucken();
	}

	public void Drucken() throws PrinterException {
		PrinterJob job = PrinterJob.getPrinterJob();
		job.setPrintable(new Printjob(grundKundigung, string2));
		if (job.printDialog()) {
			job.print();
		}
	}
}
