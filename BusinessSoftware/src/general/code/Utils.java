package general.code;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import general.design.Colors;

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
		frame.setBounds(0, 0, 900, 600);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Business Software");
		frame.setResizable(false);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(frame.getClass().getResource("/media/shop.png")));
	}

	/**
	 * Created by Omar
	 * 
	 * sets default options excluding the bounds option its location and non
	 * rezisable
	 */
	public static void setSmallFrameOptions(JFrame frame) {
		frame.setBounds(0, 0, 400, 400);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(frame.getClass().getResource("/media/shop.png")));
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

	/**
	 * 
	 * @param tableName
	 * @param tableName2
	 * @param colum
	 * @param colum2
	 * @param colum3
	 * @param bedinungErfullung
	 * @param bedinungErfullung2
	 * @param sqlRecorse
	 * @return
	 * @author Aref
	 */
// diese methode helft di e
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

// diese mithode helft die id von jede Tabele zu wissen
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

	/**
	 * 
	 * @param bedinungErfullung
	 * @param sqlRecorse
	 * @return
	 * @author Aref
	 */
	// dies methode helft um nameGeascheaft zu wissen

	public static String nameGeascheaft(String tableName, String tableName2, String colum, String colum2, String colum3,
			String colum4, String bedinungErfullung, String bedinungErfullung2, String sqlRecorse) {
		Connection conn = null;
		PreparedStatement statmment = null;
		String d = "";
		try {
			conn = DriverManager.getConnection(SQLiteConnection.getSQLiteConnectionString(sqlRecorse));
			String an = "select " + tableName + ".nameAbteilung As gesamt from " + tableName + " inner join "
					+ tableName2 + " on " + tableName + "." + colum + " = " + tableName2 + "." + colum2 + " where "
					+ tableName + "." + colum3 + " = ?  and " + tableName2 + "." + colum4 + " = ?";
			System.out.println("das ist was du" + an);
			statmment = conn.prepareStatement(an);
			System.out.println("das ist was du" + an);
			statmment.setString(1, bedinungErfullung);
			statmment.setString(2, bedinungErfullung2);
			statmment.execute();
			ResultSet resultSet = statmment.executeQuery();

			d = resultSet.getString("gesamt");
			System.out.println("dasdsa" + d);

			resultSet.next();

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
