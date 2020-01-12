package dialogs;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import net.miginfocom.swing.MigLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class TwoChoiceDialog extends JFrame {

	private JPanel contentPane;
	private JButton buttonNewButton;
	private JButton buttonNewButton_1;
	private JLabel labelNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TwoChoiceDialog frame = new TwoChoiceDialog();
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
	public TwoChoiceDialog() {
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			buttonNewButton_1 = new JButton("New button");
			buttonNewButton_1.setBounds(10, 76, 176, 74);
			contentPane.add(buttonNewButton_1);
		}
		{
			buttonNewButton = new JButton("New button");
			buttonNewButton.setBounds(198, 76, 176, 74);
			contentPane.add(buttonNewButton);
		}
		{
			labelNewLabel = new JLabel("<html>some dummy text written here as always ...................................................................................................................................................");
			labelNewLabel.setBounds(10, 11, 364, 54);
			contentPane.add(labelNewLabel);
		}
	}
}
