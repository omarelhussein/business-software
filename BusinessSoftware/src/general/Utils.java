package general;

import java.awt.Color;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import general.Colors;

import javax.swing.JButton;
import javax.swing.JFrame;
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
	 * sets default options excluding the bounds option
	 * its location and non rezisable
	 */
	public static void setDefaultFrameOptions(JFrame frame) {
		frame.setLocationRelativeTo(null);
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
		previousFrame.setVisible(true);
		currentFrame.setVisible(false);
	}
	
	public static boolean isEmailValid(String email) {
		Pattern p = Pattern.compile("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$");
		Matcher m = p.matcher(email);
		
		return m.matches();
	}
	
	/**
	 * Created by Omar
	 * 
	 * @param button sets the standard options for the button
	 */
	public static void setStandardButtonOptions(JButton button) {
		button.setBorder(new LineBorder(new Color(0, 0, 0)));
		button.setBackground(new Color(255, 228, 225));
		button.setFocusable(false);
		button.setRolloverEnabled(false);
	}
	
	public static void setErrorBorder(ArrayList<JTextField> list) {
		for (JTextField jTextField : list) {
			if(jTextField.getText().trim().equals("")) {
				jTextField.setBorder(new LineBorder(Colors.parseColor(Colors.RED)));				
			} else {
				jTextField.setBorder(new LineBorder(Colors.parseColor(Colors.DARK_GREY)));	
			}
		}
	}
	
}
