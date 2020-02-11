package abteilungen.views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import abteilungen.DaoAbteilung;
import general.code.GeschaeftDB;
import general.code.Utils;
import general.design.Colors;
import general.design.Fonts;
import general.design.Unicodes;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class JFrameAbteilungVerarbeiten extends JFrame {

	private JPanel contentPane;
	private JList<Object> list;
	private JTextField textField_alterName;
	private JTextField textField_neuerName;
	private JLabel labelAbteilungBearbeitung;
	private JScrollPane scrollPane;
	private JButton button_abteilung_verarbeiten_check;
	private JButton btnNewButton;
	private DaoAbteilung daoAbteilung;
	private ArrayList<String> values;
	private JButton btnndern;
	private JLabel labelNewLabel;
	private JLabel labelNeuerName;
	private JTextField textFieldSuchen;
	private JButton buttonNewButton;
	int loschen=0;

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
	 * 
	 * @throws ClassNotFoundException
	 */
	public JFrameAbteilungVerarbeiten() throws ClassNotFoundException {
		daoAbteilung = new DaoAbteilung();
		initGUI();
	
	}

	private void initGUI() {
		Utils.setSmallFrameOptions(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 162, 210, 188);
		contentPane.add(scrollPane);

		list = new JList<>();
		list.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				onItemClicked(e);
			}
		});
		values = new ArrayList<String>();
		scrollPane.setViewportView(list);
		list.setBorder(new LineBorder(Color.LIGHT_GRAY));
		list.setFont(new Font("Century Schoolbook", Font.PLAIN, 13));
		String[] arrayValues = daoAbteilung.Abteilungen(GeschaeftDB.getInstance().getCurrentAccountName());
		arrayToArrayList(arrayValues);
		list.setModel(new AbstractListModel<Object>() {
			String[] values = arrayValues;

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});

		textField_alterName = new JTextField("");
		textField_alterName.setEditable(false);
		textField_alterName.setBackground(Color.WHITE);
		textField_alterName.setForeground(Color.BLACK);
		Fonts.setCenturySchoolbookFont(textField_alterName, 14);
		textField_alterName.setBounds(230, 91, 143, 30);
		contentPane.add(textField_alterName);

		textField_neuerName = new JTextField("");
		textField_neuerName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				do_textField_neuerName_keyPressed(arg0);
			}
		});
		textField_neuerName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				do_textField_neuerName_mouseEntered(arg0);
			}
		});
	

		Fonts.setCenturySchoolbookFont(textField_neuerName, 14);
		textField_neuerName.setBounds(230, 162, 143, 30);
		contentPane.add(textField_neuerName);

		labelAbteilungBearbeitung = new JLabel("Abteilung bearbeiten");
		labelAbteilungBearbeitung.setHorizontalAlignment(SwingConstants.CENTER);
		Fonts.setCenturySchoolbookFont(labelAbteilungBearbeitung, 20);
		labelAbteilungBearbeitung.setForeground(Colors.parseColor(Colors.SEXY_BLUE));
		labelAbteilungBearbeitung.setBounds(10, 11, 363, 44);
		contentPane.add(labelAbteilungBearbeitung);

		button_abteilung_verarbeiten_check = new JButton(Unicodes.CHECK);
		button_abteilung_verarbeiten_check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onCheckClicked(e);
			}
		});
		button_abteilung_verarbeiten_check.setBounds(284, 327, 89, 23);
		Utils.setStandardButtonOptions(button_abteilung_verarbeiten_check);
		contentPane.add(button_abteilung_verarbeiten_check);
		{
			btnNewButton = new JButton("Löschen");
		
		
			btnNewButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					do_btnNewButton_mouseEntered(arg0);
				}
			});
			Utils.setStandardButtonOptions(btnNewButton);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						onDeleteClicked(arg0);
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
				}
			});
			btnNewButton.setBounds(230, 203, 143, 23);
			contentPane.add(btnNewButton);
		}
		{
			btnndern = new JButton("Aktualisieren");
		
			Utils.setStandardButtonOptions(btnndern);
			btnndern.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					onUpdateClicked(arg0);
				}
			});
			btnndern.setBounds(230, 237, 143, 23);
			contentPane.add(btnndern);
		}
		{
			labelNewLabel = new JLabel("Alter Name");
			labelNewLabel.setBounds(230, 75, 89, 14);
			contentPane.add(labelNewLabel);
		}
		{
			labelNeuerName = new JLabel("Neuer Name");
			labelNeuerName.setBounds(230, 146, 89, 14);
			contentPane.add(labelNeuerName);
		}
		{
			textFieldSuchen = new JTextField();
			textFieldSuchen.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent arg0) {
					try {
						do_textFieldSuchen_keyPressed(arg0);
					} catch (HeadlessException | ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			textFieldSuchen.setBounds(10, 91, 210, 30);
			contentPane.add(textFieldSuchen);
			textFieldSuchen.setColumns(10);
		}
		{
			buttonNewButton = new JButton("Suchen");
			Utils.setStandardButtonOptions(buttonNewButton);
			buttonNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					onSearchClicked(e);
				}
			});
			buttonNewButton.setBounds(10, 128, 210, 23);
			contentPane.add(buttonNewButton);
		}
	}

	private ArrayList<String> arrayToArrayList(String[] values) {
		for (int i = 0; i < values.length; i++) {
			this.values.add(values[i]);
		}
		return this.values;
	}

	protected void onDeleteClicked(ActionEvent arg0) throws ClassNotFoundException {

		if (!daoAbteilung
				.AbteilungDelete(values.get(list.getSelectedIndex()), GeschaeftDB.getInstance().getCurrentAccountName())
				.equals("")) {
			// this.setVisible(false);
			JOptionPane.showMessageDialog(this,
					"dazu sind folgende Mitarbeiter zu geordnet :\n" + daoAbteilung.AbteilungDelete(
							values.get(list.getSelectedIndex()), GeschaeftDB.getInstance().getCurrentAccountName()));
			// JOptionPane.showConfirmDialog(null,abteilung.AbteilungDelete(values.get(list.getSelectedIndex()),
			// GeschaeftDB.getInstance().getCurrentAccountName()) ,"fur diese Abteilung sind
			// schon Mitarbeiter ", 1);
		} else {
			if (list.isSelectedIndex(list.getSelectedIndex())) {
				daoAbteilung.AbteilungDelete(values.get(list.getSelectedIndex()),
						GeschaeftDB.getInstance().getCurrentAccountName());
				values.remove(list.getSelectedIndex());
				Utils.updateList(list, false, null, values);
			}

		}

	}

	protected void onUpdateClicked(ActionEvent arg0) {
		if (list.isSelectedIndex(list.getSelectedIndex())) {
			if (textField_neuerName.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Der neue Name darf nicht leer sein");
				return;
			}
			daoAbteilung.updateAbteilung(textField_neuerName.getText(), values.get(list.getSelectedIndex()));
			values.clear();
			values = arrayToArrayList(daoAbteilung.Abteilungen(GeschaeftDB.getInstance().getCurrentAccountName()));
			Utils.updateList(list, true, scrollPane, values);
			textField_alterName.setText("");
			textField_neuerName.setText("");
			list.clearSelection();
		} else {
			JOptionPane.showMessageDialog(this, "Bitte eine Abteilung markieren");
		}

	}

	protected void onCheckClicked(ActionEvent e) {
		this.setVisible(false);
	}
/*
	protected void do_btnndern_actionPerformed(ActionEvent arg0) throws ClassNotFoundException {
		
		if(list.isSelectedIndex(list.getSelectedIndex())) {
			daoAbteilung.updet(labelNeuerName.getText(),values.get(list.getSelectedIndex()));
			values.remove(list.getSelectedIndex());
			Utils.updateList(list, false, null, values);
		}else {
			JOptionPane.showMessageDialog(null, "Bitte eine Abteilung wählen");

		}
		*/
	protected void onItemClicked(ListSelectionEvent arg0) {
		if (list.isSelectedIndex(list.getSelectedIndex())) {
			textField_alterName.setText(list.getSelectedValue().toString());

		}
	}

	protected void onSearchClicked(ActionEvent e) {
		Utils.searchWord(values, textFieldSuchen, list, this);
	}

	protected void do_btnNewButton_mouseEntered(MouseEvent arg0) {
		btnNewButton.setToolTipText("");
		if(textFieldSuchen.isFocusOwner()) {
			btnNewButton.setToolTipText("Alt+Enter");
			
		}
		
		
	


	}

/**
 * @author Aref
 * @param arg0
 * @throws HeadlessException
 * @throws ClassNotFoundException
 */
	protected void do_textFieldSuchen_keyPressed(KeyEvent arg0) throws HeadlessException, ClassNotFoundException {
		if(arg0.getKeyCode()==18||arg0.getKeyCode()==10) {
			loschen+=arg0.getKeyCode();
			
		}
		
			
		
		 try {
				if(loschen==28) {
					loschen=0;
					if (!daoAbteilung
							.AbteilungDelete(values.get(list.getSelectedIndex()), GeschaeftDB.getInstance().getCurrentAccountName())
							.equals("")) {
						// this.setVisible(false);
						JOptionPane.showMessageDialog(this,
								"dazu sind folgende Mitarbeiter zu geordnet :\n" + daoAbteilung.AbteilungDelete(
										values.get(list.getSelectedIndex()), GeschaeftDB.getInstance().getCurrentAccountName()));
						// JOptionPane.showConfirmDialog(null,abteilung.AbteilungDelete(values.get(list.getSelectedIndex()),
						// GeschaeftDB.getInstance().getCurrentAccountName()) ,"fur diese Abteilung sind
						// schon Mitarbeiter ", 1);
					} else {
						if (list.isSelectedIndex(list.getSelectedIndex())) {
							daoAbteilung.AbteilungDelete(values.get(list.getSelectedIndex()),
									GeschaeftDB.getInstance().getCurrentAccountName());
							values.remove(list.getSelectedIndex());
							Utils.updateList(list, false, null, values);
						}

					}
					
				}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Bitte wählen sie eine Abteilung aus");
		}
		
	}
	protected void do_textField_neuerName_mouseEntered(MouseEvent arg0) {
		btnndern.setToolTipText("strg+Enter");

	}

	protected void do_textField_neuerName_keyPressed(KeyEvent arg0) {
		if(arg0.getKeyCode()==17||arg0.getKeyCode()==10) {
			loschen+=arg0.getKeyCode();
		}
		try {
			if(loschen==27) {
				if (list.isSelectedIndex(list.getSelectedIndex())) {
					if (textField_neuerName.getText().trim().isEmpty()) {
						JOptionPane.showMessageDialog(this, "Der neue Name darf nicht leer sein");
						return;
					}
					daoAbteilung.updateAbteilung(textField_neuerName.getText(), values.get(list.getSelectedIndex()));
					values.clear();
					values = arrayToArrayList(daoAbteilung.Abteilungen(GeschaeftDB.getInstance().getCurrentAccountName()));
					Utils.updateList(list, true, scrollPane, values);
					textField_alterName.setText("");
					textField_neuerName.setText("");
					list.clearSelection();
				} else {
					JOptionPane.showMessageDialog(this, "Bitte eine Abteilung markieren");
				}
				}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	}


