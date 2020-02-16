package start.login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import general.code.SQLiteConnection;

public class Daoanmelden {

	public Daoanmelden() {
		try {
			SQLiteConnection.getSQLiteConnectionInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Ajabnoor 20.1.2020
	 * 
	 * @param name
	 * @param password
	 * @return
	 * @throws ClassNotFoundException
	 */
	public boolean loginBoss(String name, String password) {

		PreparedStatement vorbereitungAussage = null;
		Connection rabita = null;

		try {
			rabita = DriverManager.getConnection(SQLiteConnection.getSQLiteConnection());

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

	/**
	 * @author Aref
	 * @return
	 */
	public String[] nameGeascheaft() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String abteilunge = "";
		String[] abteilungen = null;
		try {
			connection = DriverManager.getConnection(SQLiteConnection.getSQLiteConnection());
			String sql = "select namegaeschaeft from Geascheaft";

			preparedStatement = connection.prepareStatement(sql);
			System.out.println("SDa");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				abteilunge += resultSet.getString("namegaeschaeft") + "_";
				System.out.println(resultSet.getFetchSize());
			}
			abteilungen = abteilunge.split("_");
		} catch (SQLException e) {
			System.out.println("von an :" + e);
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

}
