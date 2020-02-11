package abteilungen.views;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import abteilungen.DaoAbteilung;
import general.code.GeschaeftDB;
import general.code.Utils;
import general.design.Colors;
import general.design.Fonts;
import general.design.Unicodes;

@SuppressWarnings("serial")
public class JFrameAbteilungAnzeigen extends JFrame {

	private JPanel contentPane;
	private JList<Object> list;
	private JLabel labelNewLabel;
	private JButton btn_abteilung_check;
	private JScrollPane scrollPane;
	private JButton btn_abteilung_anzeigen;
	DaoAbteilung abteilung = null;
	ArrayList<String> value;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameAbteilungAnzeigen frame = new JFrameAbteilungAnzeigen();
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
	public JFrameAbteilungAnzeigen() {
		abteilung = new DaoAbteilung();
		value = new ArrayList<String>();
		initGUI();
	}

	private void initGUI() {
		Utils.setSmallFrameOptions(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 56, 265, 294);
			contentPane.add(scrollPane);
			{
				list = new JList<Object>();
				list.setFont(new Font("Tahoma", Font.PLAIN, 13));
				list.setModel(new AbstractListModel<Object>() {
					String[] values = new String[] {};

					public int getSize() {
						return values.length;
					}

					public Object getElementAt(int index) {
						return values[index];
					}
				});
				scrollPane.setViewportView(list);
			}
		}
		{
			labelNewLabel = new JLabel("Abteilungen Liste");
			labelNewLabel.setBounds(10, 11, 265, 34);
			Fonts.setCenturySchoolbookFont(labelNewLabel, 18);
			labelNewLabel.setForeground(Colors.parseColor(Colors.SEXY_BLUE));
			contentPane.add(labelNewLabel);
		}
		{
			btn_abteilung_check = new JButton(Unicodes.CHECK);
			btn_abteilung_check.setBounds(285, 327, 89, 23);
			Utils.setStandardButtonOptions(btn_abteilung_check);
			contentPane.add(btn_abteilung_check);
		}
		{
			btn_abteilung_anzeigen = new JButton("Anzeigen");

			btn_abteilung_anzeigen.setBounds(285, 293, 89, 23);
			Utils.setStandardButtonOptions(btn_abteilung_anzeigen);
			contentPane.add(btn_abteilung_anzeigen);

			btn_abteilung_check.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					onCheckClicked(arg0);
				}

			});
		}
	}

	protected void btn_abteilung_anzeigenActionPerformed(ActionEvent e) {

		int selectindex = list.getSelectedIndex();
		btn_abteilung_check.setBounds(285, 327, 89, 23);
		Utils.setStandardButtonOptions(btn_abteilung_check);
		contentPane.add(btn_abteilung_check);

		loadAbteilungenList();
	}

	private void loadAbteilungenList() {
		arraytoArrayList();

		list.setModel(new AbstractListModel<Object>() {
			public int getSize() {
				return value.size();
			}

			public Object getElementAt(int index) {
				return value.get(index);
			}
		});
	}

	private void arraytoArrayList() {
		for (int i = 0; i < abteilung.Abteilungen(GeschaeftDB.getInstance().getCurrentAccountName()).length; i++) {
			value.add(abteilung.Abteilungen(GeschaeftDB.getInstance().getCurrentAccountName())[i]);
		}
	}

	protected void onCheckClicked(ActionEvent arg0) {
		this.setVisible(false);
	}

	protected void do_btn_abteilung_anzeigen_actionPerformed(ActionEvent arg0) {
		arraytoArrayList();

		list.setModel(new AbstractListModel() {
			public int getSize() {
				return value.size();
			}

			public Object getElementAt(int index) {
				return value.get(index);
			}
		});
	}

}
