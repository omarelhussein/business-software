package general;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * Created On 28.12.2019
 * @author omare
 * Makes the JTextField include an error Field below it
 * 
 * 
 * 
 * Assign an already declared JTextField 
 * to a TextErrorField to get the extra 
 * error feature
 */
@SuppressWarnings("serial")
public class TextErrorField extends JTextField {
	
	private JLabel mLabel;
	private JComponent mParent;
	
	/**
	 * @author omare
	 * public constructor to get parents view
	 */
	public TextErrorField(JComponent parent) {
		mLabel = new JLabel();
		mParent = parent;
		parent.add(mLabel);
	}

	public void setErrorMessage(String msg) {
		mLabel = setLabel();
		mLabel.setText(msg);
	}
	
	public void setErrorVisibility(boolean isVisible) {
		try {
			mLabel.setVisible(isVisible);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private JLabel setLabel() {
		mLabel.setBounds(getX(), getY() + ((getY() * 3) / 4), mParent.getWidth() - mLabel.getX(), getHeight());
		mLabel.setVisible(true);
		mLabel.setForeground(Colors.parseColor("#FF0000"));
		return mLabel;
	}

}
