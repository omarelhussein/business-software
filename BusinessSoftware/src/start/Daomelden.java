package start;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import general.SQLiteConnection;
import main.Anschrift;

public class Daomelden {
	

	private final String SQLITE_TABLE = "Geaschgeaft.db";

	public Daomelden() throws ClassNotFoundException {
		SQLiteConnection.getSQLiteConnectionInstance();
	}

	public void insert(Object... objects) {
		//* from here 
		Gescheaft gescheaft = null;
		Anschrift anschrift = null;
		{
			for (Object object : objects) {
				if (object instanceof Gescheaft) {
					gescheaft = (Gescheaft) object;

				}
				if (object instanceof Anschrift) {
					anschrift = (Anschrift) object;
				}
			}
		}//* until here, created by Omar
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DriverManager.getConnection(SQLiteConnection.getSQLiteConnectionString(SQLITE_TABLE));
			String sa = "INSERT into Anschrift VALUES (?,?,?,?)";
			preparedStatement = connection.prepareStatement(sa);
			System.out.println("dsadsadsa");
			preparedStatement.setInt(1, anzalAnschrift() + 1);
			preparedStatement.setString(3, anschrift.getStadt());
			preparedStatement.setString(2, anschrift.getAdressse());
			preparedStatement.setString(4, anschrift.getTel());
			preparedStatement.execute();
			String s = "INSERT into Geascheaft VALUES (?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(s);
			preparedStatement.setInt(1, anzalGeascheaft() + 1);
			preparedStatement.setString(2, gescheaft.getNamegeascheaft());
			preparedStatement.setString(3, gescheaft.getBezeichnung());
			preparedStatement.setString(4, gescheaft.getPass());
			preparedStatement.setInt(5, anzalAnschrift() + 1);
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
	}

	public int anzalGeascheaft() {
		Connection conn = null;
		PreparedStatement statmment = null;
		int d = 0;
		try {
			conn = DriverManager.getConnection(SQLiteConnection.getSQLiteConnectionString(SQLITE_TABLE));
			String an = "select Max (id) As gesamt from Geascheaft  ";
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

	public int anzalAnschrift() {
		Connection conn = null;
		PreparedStatement statmment = null;
		int d = 0;
		try {
			conn = DriverManager.getConnection(SQLiteConnection.getSQLiteConnectionString(SQLITE_TABLE));
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
