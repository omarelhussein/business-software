package general;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 * Created on 09.12.2019
 * 
 * @author omar27
 *
 */
public class Utils {

	/**
	 * Created by Omar
	 * 
	 * @param frame set frames layout options
	 */
	public static void setMainFrameOptions(JFrame frame) {
		frame.setBounds(120, 100, 900, 600);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Business Software");
		frame.setResizable(false);
	}
	
	/**
	 * Created by Omar
	 * 
	 * @param panel set internal panel options
	 */
	public static void setMainInternalFrameOptions(JPanel panel) {
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
//		panel.setBounds(50, 110, 800, 400);
	}

	/**
	 * Created by Omar
	 * 
	 * @param oldJFrame set old frame to close
	 * @param newJFrame set new frame to open
	 */
	public static void startNewJFrame(JFrame oldJFrame, JFrame newJFrame) {
		newJFrame.setVisible(true);
		oldJFrame.setVisible(false);
	}

	/**
	 * Created by Ajabnoor
	 * 
	 * @param neueJFrame sets the current frame to close
	 * @param alteJFrame sets the previous frame to reopen
	 */
	public static void reviewOldJFrame(JFrame currentFrame, JFrame previousFrame) {
		currentFrame.setVisible(false);
		previousFrame.setVisible(true);
	}
	
	/**
	 * Created by Omar
	 * 
	 * @param button sets the standard options for the button
	 */
	public static void standardButtonOptions(JButton button) {
		button.setBorder(new LineBorder(new Color(0, 0, 0)));
		button.setBackground(new Color(255, 228, 225));
		button.setFocusable(false);
		button.setRolloverEnabled(false);
	}
	/**
	 * 
	 * @param field
	 * @return
	 * @author Aref
	 */
	public static boolean textFullen(JTextField field,JPanel panel) {
		boolean textnichtleher;
		if(field.getText().equals("")) {
			textnichtleher=false;
			field.setBorder(new LineBorder(new Color(237,19,11)));  
			Toolkit.getDefaultToolkit().beep();
			JLabel jLabel=new JLabel("dsadsa");
			jLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
			jLabel.setBounds(field.getX(),field.getY()-25,60,14);
			panel.add(jLabel);
		}else {
			textnichtleher=true;
			field.setBorder(new LineBorder(new Color(0,0,0)));
		}
		return textnichtleher;
		
	}
	public static void JLabl(JTextField field,JPanel panel,boolean t) {
		if(t==true) { 
			JLabel jLabel=new JLabel("dsadsa");
			jLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
			jLabel.setBounds(field.getX(),field.getY()-25,60,14);
			panel.add(jLabel);
		}else if (t==true) {
			JLabel jLabel=new JLabel("");
			jLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
			jLabel.setBounds(field.getX(),field.getY()-25,60,14);
			panel.add(jLabel);
		}
		}
		
	

}
