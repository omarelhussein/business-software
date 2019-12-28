package start;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import main.Anschrift;
import main.GeascheaftDao;

public class Daomelden {
	String s = "org.sqlite.JDBC";
	private final String CONNECTIONSTRING = "jdbc:sqlite:Geaschgeaft.db";

	public Daomelden() throws ClassNotFoundException {
		// TODO Auto-generated constructor stub
		Class.forName(s);
	}

	public void insert(Anschrift anschrift, Gescheaft gescheaft) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DriverManager.getConnection(CONNECTIONSTRING);
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
			conn = DriverManager.getConnection(CONNECTIONSTRING);
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
			conn = DriverManager.getConnection(CONNECTIONSTRING);
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
