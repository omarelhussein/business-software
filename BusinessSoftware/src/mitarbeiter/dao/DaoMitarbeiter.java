package mitarbeiter.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import general.code.GeschaeftDB;
import general.code.SQLiteConnection;
import main.business_classes.Anschrift;
import mitarbeiter.business_classes.Mitarbeiter;
import start.register.views.JFrameRegistrieren;

/**
 * @author ajab
 * @author Aref
 *
 */
public class DaoMitarbeiter {

	final String sqlresors = "Geaschgeaft.db";

	public DaoMitarbeiter() throws ClassNotFoundException {
		SQLiteConnection.getSQLiteConnectionInstance();
	}

	/**
	 * 
	 * 
	 * @param mitarbeiter
	 * @param aNmae
	 * @param anschrift
	 * @author Aref
	 */

	public void insert(Mitarbeiter mitarbeiter, String aNmae, Anschrift anschrift) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {

			connection = DriverManager.getConnection(SQLiteConnection.getSQLiteConnectionString(sqlresors));
			String sqlAnschrift = "insert into Anschrift values(?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(sqlAnschrift);
			preparedStatement.setInt(1, SQLiteConnection.anzalAnschrift("Anschrift", sqlresors) + 1);
			preparedStatement.setString(2, anschrift.getAdressse());
			preparedStatement.setString(3, anschrift.getStadt());
			preparedStatement.setString(4, anschrift.getTel());
			preparedStatement.setString(5, anschrift.getPlz());
			preparedStatement.execute();
			String sqlb = "insert into Mitarbeiter values (?,?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(sqlb);
			preparedStatement.setInt(1, SQLiteConnection.anzalAnschrift("Mitarbeiter", sqlresors) + 1);
			preparedStatement.setString(2, mitarbeiter.getNamemitarbeiter());
			preparedStatement.setString(3, mitarbeiter.getNachname());
			preparedStatement.setString(4, mitarbeiter.getLohn());
			preparedStatement.setInt(6, SQLiteConnection.idBetrefendesache("Abteilung", "Geascheaft", "agf",
					"namegaeschaeft", "nameAbteilung", GeschaeftDB.getInstance().getCurrentAccountName(), aNmae, sqlresors));

			preparedStatement.setInt(7, SQLiteConnection.anzalAnschrift("Anschrift", sqlresors));
			preparedStatement.execute();
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			try {
				connection.close();
				preparedStatement.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

	}

	/**
	 * Created On 21.01.2020
	 * 
	 * @author ajab
	 *
	 */
	private final String DATEI = "Geaschgeaft.db";
	private final String URL = "jdbc:sqlite:" + DATEI;

	public boolean mitarbeitereinlogen(String name, String password) throws ClassNotFoundException {

		PreparedStatement preparedStatment = null;
		Connection connection = null;

		try {
			connection = DriverManager.getConnection(URL);
			String sql = "SELECT * FROM  Mitarbeiter WHERE namemitarbeiter = ? AND pass = ?";
			preparedStatment = connection.prepareStatement(sql);
			preparedStatment.setString(1, name);
			preparedStatment.setString(2, password);

			ResultSet result = preparedStatment.executeQuery();
			if (result.next()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				preparedStatment.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}
