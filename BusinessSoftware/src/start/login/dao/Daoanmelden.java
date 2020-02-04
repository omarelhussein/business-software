package start.login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import general.code.SQLiteConnection;

public class Daoanmelden {

	private final String DATEI = "Geaschgeaft.db";
	private final String URL = "jdbc:sqlite:" + DATEI;

	public Daoanmelden() throws ClassNotFoundException {
		SQLiteConnection.getSQLiteConnectionInstance();
	}

	/**
	 * Ajabnoor 20.1.2020
	 * 
	 * @param name
	 * @param password
	 * @return
	 * @throws ClassNotFoundException
	 */
	public boolean loginBoss(String name, String password) throws ClassNotFoundException {

		PreparedStatement vorbereitungAussage = null;
		Connection rabita = null;

		try {
			rabita = DriverManager.getConnection(URL);

			String sql = "SELECT  namegaeschaeft, pass, * from Geascheaft WHERE namegaeschaeft = ? AND pass = ? LIMIT 1";

			vorbereitungAussage = rabita.prepareStatement(sql);
			vorbereitungAussage.setString(1, name);
			vorbereitungAussage.setString(2, password);
			
			ResultSet ergebniss = vorbereitungAussage.executeQuery();

				if (ergebniss.next()) {
					return true;					
				} else {
					return false;
				}

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				rabita.close();
				vorbereitungAussage.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
	

}
