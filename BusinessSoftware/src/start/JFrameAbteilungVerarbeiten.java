package start;

import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

public class JFrameAbteilungVerarbeiten extends JFrame {

	private JPanel contentPane;
	private JList list;
	private final JList list_1 = new JList();

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 822, 459);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
		
		}
		list = new JList();
	
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Lebensmittel", "Elektronik"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		list.setSelectedIndex(1);
		list.setBounds(75, 393, 142, -376);
		contentPane.add(list);
		list_1.setModel(new AbstractListModel() {
			String[] values = new String[] {"rhjfidhhfu", "dfngfgjkrenek"};
			public int getSize() {
				return values.length;
			}
			
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list_1.setBounds(358, 137, 203, 156);
		contentPane.add(list_1);
	}

}
