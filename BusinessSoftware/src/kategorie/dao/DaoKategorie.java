package kategorie.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import general.code.SQLiteConnection;
import kategorie.business_classes.Kategorie;

/**
 * 13.02.2020
 * @author omare
 *
 */
public class DaoKategorie {
	
	public DaoKategorie() {
		try {
			SQLiteConnection.getSQLiteConnectionInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public List<Kategorie> loadKategorien(String nameAbteilung) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DriverManager.getConnection(SQLiteConnection.getSQLiteConnection());
			final String SQL = "SELECT * FROM Kategorie INNER JOIN Abteilung ON Kategorie.kaf = Abteilung.id WHERE Abteilung.nameAbteilung = ?";
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
