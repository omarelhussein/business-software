package general;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	 * sets default options excluding the bounds option its location and non
	 * rezisable
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
		currentFrame.setVisible(false);
		previousFrame.setVisible(true);
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

	/**
	 * 
	 * @param field
	 * @return
	 * @author Aref
	 */
	public static boolean textFullen(JTextField field, JPanel panel) {
		boolean textnichtleher;
		if (field.getText().equals("")) {
			textnichtleher = false;
			field.setBorder(new LineBorder(new Color(237, 19, 11)));
			Toolkit.getDefaultToolkit().beep();
			JLabel jLabel = new JLabel("dsadsa");
			jLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
			jLabel.setBounds(field.getX(), field.getY() - 25, 60, 14);
			panel.add(jLabel);
		} else {
			textnichtleher = true;
			field.setBorder(new LineBorder(new Color(0, 0, 0)));
		}
		return textnichtleher;

	}

	public static void JLabl(JTextField field, JPanel panel, boolean t) {
		if (t == true) {
			JLabel jLabel = new JLabel("dsadsa");
			jLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
			jLabel.setBounds(field.getX(), field.getY() - 25, 60, 14);
			panel.add(jLabel);
		} else if (t == true) {
			JLabel jLabel = new JLabel("");
			jLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
			jLabel.setBounds(field.getX(), field.getY() - 25, 60, 14);
			panel.add(jLabel);
		}
	}

	/**
	 * 
	 * @param field
	 * @return
	 * @author Aref
	 */
	public static boolean textFullen(JTextField field) {
		boolean textnichtleher;
		if (field.getText().equals("")) {
			textnichtleher = false;
			field.setBorder(new LineBorder(Colors.parseColor("#FF0000")));
		} else {
			textnichtleher = true;
			field.setBorder(new LineBorder(Colors.parseColor("#0000")));
		}
		return textnichtleher;

	}

	public static int idBetrefendesache(String tableName, String tableName2, String colum, String colum2, String colum3,
			String bedinungErfullung, String bedinungErfullung2, String sqlRecorse) {
		Connection conn = null;
		PreparedStatement statmment = null;
		int d = 0;
		try {
			conn = DriverManager.getConnection(SQLiteConnection.getSQLiteConnectionString(sqlRecorse));
			String an = "select " + tableName + ".id from " + tableName + " inner join " + tableName2 + " on "
					+ tableName + "." + colum + "=" + tableName2 + ".id where " + tableName2 + "." + colum2
					+ " = ?  and " + tableName + "." + colum3 + " = ?";
			System.out.println(an);
			statmment = conn.prepareStatement(an);
			statmment.setString(1, bedinungErfullung);
			statmment.setString(2, bedinungErfullung2);
			statmment.execute();
			ResultSet resultSet = statmment.executeQuery();
			resultSet.next();
			d = resultSet.getInt("id");
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			try {
				statmment.close();
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return d;
	}

	public static int anzalAnschrift(String tableName, String sqlRecorse) {
		Connection conn = null;
		PreparedStatement statmment = null;
		int d = 0;
		try {
			conn = DriverManager.getConnection(SQLiteConnection.getSQLiteConnectionString(sqlRecorse));
			String an = "select Max (id) As gesamt from " + tableName;
			statmment = conn.prepareStatement(an);

			statmment.execute();
			ResultSet resultSet = statmment.executeQuery();
			resultSet.next();
			d = resultSet.getInt("gesamt");
		} catch (SQLException e) {
			// TODO: handle exception
		} finally {
			try {
				statmment.close();
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return d;
	}

}
