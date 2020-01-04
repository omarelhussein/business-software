package abteilungen;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import general.Utils;

@SuppressWarnings("serial")
public class JFrameAbteilungVerarbeiten extends JFrame {

	private JPanel contentPane;
	private JList list;
	private JButton buttonNewButton;
	private JButton buttonNewButton_1;
	private JButton buttonNewButton_2;
	private JLabel labelAbteilungBearbeitung;

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
	 */
	public JFrameAbteilungVerarbeiten() {
		initGUI();
	}

	private void initGUI() {
		this.setBounds(0, 0, 400, 400);
		Utils.setDefaultFrameOptions(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{

		}

		list = new JList();
		list.setFont(new Font("Century Schoolbook", Font.PLAIN, 20));
		list.setModel(new AbstractListModel() {
			String[] values = new String[] { "Lebensmittel", "Elektronik" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(10, 80, 163, 206);
		contentPane.add(list);

		buttonNewButton = new JButton("Artikel");
		buttonNewButton.setFont(new Font("Century Schoolbook", Font.PLAIN, 20));
		buttonNewButton.setBounds(183, 80, 190, 44);
		contentPane.add(buttonNewButton);

		buttonNewButton_1 = new JButton("Mitarbeiter");
		buttonNewButton_1.setFont(new Font("Century Schoolbook", Font.PLAIN, 21));
		buttonNewButton_1.setBounds(183, 134, 190, 44);
		contentPane.add(buttonNewButton_1);

		buttonNewButton_2 = new JButton("Fertig");
		buttonNewButton_2.setFont(new Font("Century Schoolbook", Font.PLAIN, 18));
		buttonNewButton_2.setBounds(276, 261, 97, 25);
		contentPane.add(buttonNewButton_2);

		labelAbteilungBearbeitung = new JLabel("Abteilung Bearbeitung");
		labelAbteilungBearbeitung.setFont(new Font("Century Schoolbook", Font.PLAIN, 22));
		labelAbteilungBearbeitung.setBounds(10, 39, 271, 31);
		contentPane.add(labelAbteilungBearbeitung);
	}

}
