package main.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import general.code.SQLiteConnection;
import main.business_classes.Anschrift;

/**
 * Created on 09.02.2020
 * @author omare
 */
public class DaoAnschrift {

	/**
	 * Created by Omar 09.02.2020
	 * Constructer for the class
	 */
	public DaoAnschrift() {
		try {
			SQLiteConnection.getSQLiteConnectionInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Anschrift getMitarbeiterAnschrift(int mitarbeiterId) {
		Connection conn = null;
		PreparedStatement ps = null;
		Anschrift anschrift = new Anschrift();
		final String sql = "SELECT * FROM Anschrift INNER JOIN Mitarbeiter ON Anschrift.id = Mitarbeiter.Manschriftf2 WHERE Mitarbeiter.id = ?";
		try {
			conn = DriverManager.getConnection(SQLiteConnection.getSQLiteConnection());
			ps = conn.prepareStatement(sql);
			ps.setInt(1, mitarbeiterId);
			
			ResultSet result = ps.executeQuery();
			while(result.next()) {
				anschrift.setAdressse(result.getString("Adresse"));
				anschrift.setId(1);
				anschrift.setOrt(result.getString("stadt"));
				anschrift.setTel(result.getString("Tel"));
				anschrift.setPlz(result.getString("Plz"));
			}
			
			return anschrift;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
