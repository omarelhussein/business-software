package abteilungen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import general.code.GeschaeftDB;
import general.code.SQLiteConnection;
import general.code.Utils;
import start.register.dao.Daomelden;
import start.register.views.JFrameRegistrieren;

public class DaoAbteilung {
	private Daomelden daoanmelden;
	private final String SQLITE_TABLE = "Geaschgeaft.db";

	public DaoAbteilung() throws ClassNotFoundException {
		// TODO Auto-generated constructor stub
		SQLiteConnection.getSQLiteConnectionInstance();
		daoanmelden = new Daomelden();
	}

	/**
	 * 
	 * @param nameGeascgeaft
	 * @return
	 * @author Aref
	 */

	public void insertAbteilung(String abteilung) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DriverManager.getConnection(SQLiteConnection.getSQLiteConnectionString(SQLITE_TABLE));
			String sql = "INSERT into Abteilung VALUES(?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, SQLiteConnection.anzalAnschrift("Abteilung", SQLITE_TABLE) + 1);
			preparedStatement.setString(2, abteilung);
			preparedStatement.setInt(3, SQLiteConnection.idTabelle("Geascheaft", "namegaeschaeft", GeschaeftDB.getInstance().getCurrentAccountName(), SQLITE_TABLE));
			preparedStatement.execute();
			System.out.println("aref");

		} catch (SQLException e) {
			// TODO: handle exception
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
	 * 
	 * @param nameGeascgeaft
	 * @return
	 * @author Aref
	 */
	public String[] Abteilungen(String nameGeascheaft) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String abteilunge = "";
		String[] abteilungen = null;
		try {
			connection = DriverManager.getConnection(SQLiteConnection.getSQLiteConnectionString(SQLITE_TABLE));
			String sql = "select nameAbteilung from Abteilung inner join Geascheaft on Abteilung.agf=Geascheaft.id where namegaeschaeft =?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, nameGeascheaft); 
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				abteilunge += resultSet.getString("nameAbteilung") + "_";
				System.out.println(resultSet.getFetchSize());
			}
			abteilungen = abteilunge.split("_");
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
		return abteilungen;
	}

	public void AbteilungDelete(String bedinungErfullen) {
		try {
			SQLiteConnection.Delete("Abteilung", "nameAbteilung", "agf", bedinungErfullen, SQLiteConnection.idTabelle(
					"Geascheaft", "namegaeschaeft", GeschaeftDB.getInstance().getCurrentAccountName(), SQLITE_TABLE), SQLITE_TABLE);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
