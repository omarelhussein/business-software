package abteilungen.views;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import general.code.Utils;
import general.design.Colors;
import general.design.Fonts;
import general.design.Unicodes;
import start.register.views.JFrameRegistrieren;

import javax.swing.border.LineBorder;

import abteilungen.DaoAbteilung;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class JFrameAbteilungVerarbeiten extends JFrame {

	private JPanel contentPane;
	private JList<Object> list;
	private JTextField textField_abteilungVerwalten_name;
	private JTextField textField_abteilungVerarbeiten_kategorie;
	private JLabel labelAbteilungBearbeitung;
	private JScrollPane scrollPane;
	private JButton button_abteilung_verarbeiten_check;
	private JButton btnNewButton;
	private DaoAbteilung  abteilung;
	ArrayList<String> values ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameAbteilungVerarbeiten frame = new JFrameAbteilungVerarbeiten();
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
	public JFrameAbteilungVerarbeiten() throws ClassNotFoundException {
		abteilung=new DaoAbteilung();
		initGUI();
	}

	private void initGUI() {
		Utils.setSmallFrameOptions(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{

		}
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 66, 210, 284);
		contentPane.add(scrollPane);

		list = new JList();
		values = new ArrayList<String>();
		scrollPane.setViewportView(list);
		list.setBorder(new LineBorder(Color.LIGHT_GRAY));
		list.setFont(new Font("Century Schoolbook", Font.PLAIN, 20));
		String[] arrayValues = abteilung.Abteilungen(JFrameRegistrieren.nameGeascheaft);
		arrayToArrayList(arrayValues);
		list.setModel(new AbstractListModel() {
			public int getSize() {
				return values.size();
			}
			public Object getElementAt(int index) {
				return values.get(index);
			}
		});

		textField_abteilungVerwalten_name = new JTextField("Name");
		textField_abteilungVerwalten_name.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				onNameVerarbeitenFocused(arg0);
			}
			@Override
			public void focusLost(FocusEvent e) {
				onNameVerarbeitenFocusLost(e);
			}
		});
		Fonts.setCenturySchoolbookFont(textField_abteilungVerwalten_name, 14);
		textField_abteilungVerwalten_name.setBounds(230, 66, 143, 44);
		contentPane.add(textField_abteilungVerwalten_name);

		textField_abteilungVerarbeiten_kategorie = new JTextField("Kategorie");
		textField_abteilungVerarbeiten_kategorie.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				onKategorieVerarbeitenFocused(e);
			}
			@Override
			public void focusLost(FocusEvent e) {
				onKategorieVerarbeitenFocusLost(e);
			}
		});
		Fonts.setCenturySchoolbookFont(textField_abteilungVerarbeiten_kategorie, 14);
		textField_abteilungVerarbeiten_kategorie.setBounds(230, 132, 143, 44);
		contentPane.add(textField_abteilungVerarbeiten_kategorie);

		labelAbteilungBearbeitung = new JLabel("Abteilung bearbeiten");
		labelAbteilungBearbeitung.setHorizontalAlignment(SwingConstants.CENTER);
		Fonts.setCenturySchoolbookFont(labelAbteilungBearbeitung, 20);
		labelAbteilungBearbeitung.setForeground(Colors.parseColor(Colors.SEXY_BLUE));
		labelAbteilungBearbeitung.setBounds(10, 11, 363, 44);
		contentPane.add(labelAbteilungBearbeitung);
		
		button_abteilung_verarbeiten_check = new JButton(Unicodes.CHECK);
		button_abteilung_verarbeiten_check.setBounds(284, 327, 89, 23);
		Utils.setStandardButtonOptions(button_abteilung_verarbeiten_check);
		contentPane.add(button_abteilung_verarbeiten_check);
		{
			btnNewButton = new JButton("-");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					do_btnNewButton_actionPerformed(arg0);
				}
			});
			btnNewButton.setBounds(247, 217, 89, 23);
			contentPane.add(btnNewButton);
		}
	}
	
	private void arrayToArrayList(String[] values) {
		for (int i = 0; i < values.length; i++) {
			this.values.add(values[i]);
		}
	}

	protected void onNameVerarbeitenFocused(FocusEvent arg0) {
		textField_abteilungVerwalten_name.setText("");
	}
	
	protected void onKategorieVerarbeitenFocused(FocusEvent e) {
		textField_abteilungVerarbeiten_kategorie.setText("");
	}
	
	protected void onNameVerarbeitenFocusLost(FocusEvent e) {
		if(textField_abteilungVerwalten_name.getText().isEmpty()) {
			textField_abteilungVerwalten_name.setText("Name");
		}
	}
	
	protected void onKategorieVerarbeitenFocusLost(FocusEvent e) {
		if(textField_abteilungVerarbeiten_kategorie.getText().isEmpty()) {
			textField_abteilungVerarbeiten_kategorie.setText("Kategorie");
		}
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent arg0) {
		if(list.isSelectedIndex(list.getSelectedIndex())) {
			abteilung.AbteilungDelete(values.get(list.getSelectedIndex()));
			values.remove(list.getSelectedIndex());
			Utils.updateList(list, false, null, values);
		}
		
	}
}
