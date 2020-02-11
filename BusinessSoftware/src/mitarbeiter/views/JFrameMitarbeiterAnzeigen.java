package mitarbeiter.views;

import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import abteilungen.DaoAbteilung;
import general.code.AutoCompletition;
import general.code.GeschaeftDB;
import general.code.Utils;
import general.design.Colors;
import general.design.Fonts;
import general.design.Unicodes;
import mitarbeiter.business_classes.Mitarbeiter;
import mitarbeiter.dao.DaoMitarbeiter;

@SuppressWarnings("serial")
public class JFrameMitarbeiterAnzeigen extends JFrame {

	private JPanel contentPane;
	private JList<Object> list;
	private JLabel labelListeMitarbeiter;
	private JButton buttonAnzeigen;
	private JScrollPane scrollPane;
	private JButton button;

	private Mitarbeiter[] values = new Mitarbeiter[] {};
	private JComboBox<String> comboBox;
	private String[] abteilungenValues;
	private DaoAbteilung daoAbteilungen;
	private DaoMitarbeiter daoMitarbeiter;
	private Mitarbeiter mitarbeiter;
	private JLabel labelAbteilungen;
	private JTextField textFieldSuchen;
	private JButton buttonNewButton;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameMitarbeiterAnzeigen frame = new JFrameMitarbeiterAnzeigen();
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
	public JFrameMitarbeiterAnzeigen() {
		daoAbteilungen = new DaoAbteilung();
		daoMitarbeiter = new DaoMitarbeiter();
		initGUI();
	}

	private void initGUI() {

		Utils.setSmallFrameOptions(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Colors.parseColor(Colors.LIGHT_GREY));
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 112, 220, 238);
			contentPane.add(scrollPane);
			{
				list = new JList<Object>();
				scrollPane.setViewportView(list);

				list.setModel(new AbstractListModel<Object>() {
					public int getSize() {
						return values.length;
					}

					public Object getElementAt(int index) {
						return values[index];
					}
				});
			}
		}
		{
			labelListeMitarbeiter = new JLabel("Liste Mitarbeiter");
			labelListeMitarbeiter.setBounds(10, 11, 255, 33);
			Fonts.setCenturySchoolbookFont(labelListeMitarbeiter, 18);
			labelListeMitarbeiter.setForeground(Colors.parseColor(Colors.SEXY_BLUE));
			contentPane.add(labelListeMitarbeiter);
		}
		{
			buttonAnzeigen = new JButton("Anzeigen");
			Utils.setStandardButtonOptions(buttonAnzeigen);
			buttonAnzeigen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					onAnzeigen(arg0);
				}
			});
			buttonAnzeigen.setBounds(240, 280, 135, 25);
			contentPane.add(buttonAnzeigen);
		}
		{
			button = new JButton(Unicodes.CHECK);
			button.setBounds(240, 320, 135, 25);
			Utils.setStandardButtonOptions(button);
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					onCheckClicked(e);
				}
			});
			contentPane.add(button);
		}
		{

			comboBox = new JComboBox<String>();
			AutoCompletition.enable(comboBox, abteilungenValues);
			comboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					onItemSelected(arg0);
				}
			});
			abteilungenValues = daoAbteilungen.Abteilungen(GeschaeftDB.getInstance().getCurrentAccountName());
			comboBox.setModel(new DefaultComboBoxModel<String>(abteilungenValues));
			comboBox.setBackground(Colors.parseColor(Colors.LIGHT_PINK));
			comboBox.setBounds(240, 81, 135, 20);
			contentPane.add(comboBox);
		}
		onItemSelected();
		{
			labelAbteilungen = new JLabel("Abteilungen");
			labelAbteilungen.setForeground(SystemColor.textHighlight);
			labelAbteilungen.setBounds(240, 50, 135, 20);
			contentPane.add(labelAbteilungen);
		}
		{
			textFieldSuchen = new JTextField();
			textFieldSuchen.setBounds(10, 80, 125, 25);
			contentPane.add(textFieldSuchen);
			textFieldSuchen.setColumns(10);
			textFieldSuchen.addKeyListener(new KeyListener() {
				
				@Override
				public void keyTyped(KeyEvent e) {
					//nothing todo here
				}
				
				@Override
				public void keyReleased(KeyEvent e) {
					//nothing todo here
				}
				
				@Override
				public void keyPressed(KeyEvent e) {
					onEnterPressed(e);
				}
			});
		}
		{
			buttonNewButton = new JButton("Suchen");
			Utils.setStandardButtonOptions(buttonNewButton);
			buttonNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					onSuchenClicked(arg0);
				}
			});
			buttonNewButton.setBounds(141, 80, 89, 25);
			contentPane.add(buttonNewButton);

		}
	}

	/**
	 * Created by Mohammad 18.01.2020
	 */
	protected void onAnzeigen(ActionEvent arg0) {
		if (!list.isSelectionEmpty()) {
			int selectedindex = list.getSelectedIndex();
			Mitarbeiter mitarbeiter = values[selectedindex];
			JFrameMitarbeiterProfile mitarbeiterProfil = new JFrameMitarbeiterProfile(mitarbeiter);
			mitarbeiterProfil.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(this, "Kein Mitarbeiter wurde ausgewählt zum Anzeigen");
		}
	}

	/**
	 * Created by Omar 09.02.2020
	 * 
	 * ComboBox click
	 */
	protected void onItemSelected(ActionEvent arg0) {
		onItemSelected();
	}

	/**
	 * Created by Omar 09.02.2020
	 * 
	 * Returns the names of the selected comboBox item Updates the list as well
	 */
	private void onItemSelected() {
		String geschaeftName = GeschaeftDB.getInstance().getCurrentAccountName();
		String abteilungName = String.valueOf(comboBox.getSelectedItem());

		values = daoMitarbeiter.loadMitarbeiter(geschaeftName, abteilungName);

		Utils.updateList(list, true, scrollPane, arrayToArrayList(values));
	}

	/**
	 * Created by Omar 09.02.2020
	 * 
	 * @param array which to convert to an arrayList
	 * @return the converted array
	 */
	private ArrayList<String> arrayToArrayList(Object[] array) {
		ArrayList<String> arrayList = new ArrayList<String>();
		for (int i = 0; i < values.length; i++) {
			arrayList.add(values[i].getNamemitarbeiter());
		}
		return arrayList;
	}
	
	protected void onCheckClicked(ActionEvent e) {
		this.setVisible(false);
	}
	
	protected void onEnterPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			onSearchClicked();
		}
	}

	protected void onSuchenClicked(ActionEvent arg0) {
		onSearchClicked();
	}

	private void onSearchClicked() {
		Utils.searchWord(arrayToArrayList(values), textFieldSuchen, list, this);
	}
}
