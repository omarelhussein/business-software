package main.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import general.code.SQLiteConnection;

public class DaoGescheaft {

	public DaoGescheaft() {
		try {
			SQLiteConnection.getSQLiteConnectionInstance();
		} catch (ClassNotFoundException e) {
			// TODO show error message
			e.printStackTrace();
		}
	}

	public ArrayList<String> getAllNames() {
		ArrayList<String> namesList = new ArrayList<String>();
		PreparedStatement ps = null;
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(SQLiteConnection.getSQLiteConnection());

			String sql = "SELECT namegaeschaeft from Geascheaft";

			ps = conn.prepareStatement(sql);

			ResultSet result = ps.executeQuery();

			while (result.next()) {
				namesList.add(result.getString("namegaeschaeft"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return namesList;
	}

}
