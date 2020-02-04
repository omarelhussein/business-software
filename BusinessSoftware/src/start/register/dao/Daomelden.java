package start.register.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import general.code.SQLiteConnection;
import main.business_classes.Anschrift;
import main.business_classes.Geschaeft;

public class Daomelden {


	public Daomelden() throws ClassNotFoundException {
		SQLiteConnection.getSQLiteConnectionInstance();
	}

	public boolean insert(Object... objects) {
		// * from here
		int anzahl = 0;
		Geschaeft gescheaft = null;
		Anschrift anschrift = null;
		{
			for (Object object : objects) {
				if (object instanceof Geschaeft) {
					gescheaft = (Geschaeft) object;

				}
				if (object instanceof Anschrift) {
					anschrift = (Anschrift) object;
				}
			}
		} // * until here, created by Omar
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DriverManager.getConnection(SQLiteConnection.getSQLiteConnectionString());
			if(SQLiteConnection.uberBrufname("Geascheaft", "namegaeschaeft", "namegaeschaeft", gescheaft.getNamegeascheaft()).equals(gescheaft.getNamegeascheaft())) {
				// show inputDialog return eine String
				String newnamegeascheft=JOptionPane.showInputDialog(null, "diese Geascheaft ist schon vorhanden Bitte neu ein geben *_*");
				gescheaft.setNamegeascheaft(newnamegeascheft);
				return false;
			}
			String sa = "INSERT into Anschrift VALUES (?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(sa);
			System.out.println("d sadsadsa");

			preparedStatement.setInt(1, anzalAnschrift() + 1);
			preparedStatement.setString(3, anschrift.getStadt());
			preparedStatement.setString(2, anschrift.getAdressse());
			preparedStatement.setString(4, anschrift.getTel());
			preparedStatement.setString(5, anschrift.getPlz());
			System.out.println(anschrift.getPlz());
			System.out.println("dsa");
			preparedStatement.execute();
			String s = "INSERT into Geascheaft VALUES (?,?,?,?,?,?)";
			
			preparedStatement = connection.prepareStatement(s);
			preparedStatement.setInt(1, anzalGeascheaft() + 1);
			preparedStatement.setString(2, gescheaft.getNamegeascheaft());
			preparedStatement.setString(3, gescheaft.getBezeichnung());
			preparedStatement.setString(4, gescheaft.getPass());
			preparedStatement.setInt(5, anzalAnschrift());
			preparedStatement.setString(6, gescheaft.getEmail());
			preparedStatement.execute();
			System.out.println(gescheaft.getBezeichnung());
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return true;
	}
        // diese mithode helft die max id von tabelle zu holen
	public int anzalGeascheaft() {
		Connection conn = null;
		PreparedStatement statmment = null;
		int d = 0;
		try {
			conn = DriverManager.getConnection(SQLiteConnection.getSQLiteConnectionString());
			String an = "select Max (id) As gesamt from Geascheaft  ";
			statmment = conn.prepareStatement(an);
			System.out.println("dsa");
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

	public int anzalAnschrift() {
		Connection conn = null;
		PreparedStatement statmment = null;
		int d = 0;
		try {
			conn = DriverManager.getConnection(SQLiteConnection.getSQLiteConnectionString());
			String an = "select Max (id) As gesamt from Anschrift  ";
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
