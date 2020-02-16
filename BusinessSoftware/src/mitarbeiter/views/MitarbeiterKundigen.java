package mitarbeiter.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import general.code.GeschaeftDB;
import general.code.Utils;
import general.design.Colors;
import javafx.scene.chart.PieChart.Data;
import mitarbeiter.dao.Printjob;
import mitarbeiter.dao.Printjob;

import javax.swing.JTextArea;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.awt.event.ActionEvent;

public class MitarbeiterKundigen extends JFrame {

	private JPanel contentPane;
	private JTextArea txtrSeherGeheerteFrauherr;
	private JButton btnNewButton;
	static String grundKundigung;
	
	private static String string2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MitarbeiterKundigen frame = new MitarbeiterKundigen(grundKundigung, string2);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param string 
	 * @param string2 
	 */
	public MitarbeiterKundigen(String string, String string2) {
		grundKundigung=string;
		this.string2=string2;
		initGUI();
	}
	private void initGUI() {

		Utils.setSmallFrameOptions(this);
		this.setBounds(0, 0, 464, 400);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Colors.parseColor(Colors.LIGHT_GREY));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			txtrSeherGeheerteFrauherr = new JTextArea();
			txtrSeherGeheerteFrauherr.setToolTipText("Kundigung");
			txtrSeherGeheerteFrauherr.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
			Date date=new Date();
			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy/MM/dd");
				
			txtrSeherGeheerteFrauherr.setText("Seher geheerte Frau/Herr "+string2+"    ,\r\nhermit kundigen wir sie, Datum "+dateFormat.format(date)+"  , da "+grundKundigung                          +"  \r\n\r\nmit freundlichen Grussen ,\n"+GeschaeftDB.getInstance().getCurrentAccountName());
			txtrSeherGeheerteFrauherr.setBounds(10, 47, 376, 276);
			contentPane.add(txtrSeherGeheerteFrauherr);
		}
		{
			btnNewButton = new JButton("kundigung AusDr\u00FCken");
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
			btnNewButton.setBounds(10, 334, 146, 23);
			contentPane.add(btnNewButton);
		}
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent arg0) throws PrinterException {
		Drucken();
	}
	public void Drucken() throws PrinterException {
		PrinterJob job= PrinterJob.getPrinterJob();
		job.setPrintable(new Printjob(grundKundigung,string2));
		if(job.printDialog()) {
			job.print();
		}
	}
}
