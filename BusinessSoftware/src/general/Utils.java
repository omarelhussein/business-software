package general;

import javax.swing.JFrame;


/**
 * Created on 09.12.2019
 * @author omar27
 *
 */
public class Utils {
	
	/**
	 * Created by Omar
	 * @param frame set frames layout
	 */
	public static void setMainFrameOptions(JFrame frame) {
		frame.setBounds(100, 100, 900, 600);
		frame.setLocationRelativeTo(null);
	}
	
	public static void startNewJFrame(JFrame oldJFrame, JFrame newJFrame) {
		newJFrame.setVisible(true);
		oldJFrame.setVisible(false);
	}

}
