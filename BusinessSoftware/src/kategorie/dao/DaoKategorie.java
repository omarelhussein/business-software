package kategorie.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import general.code.GeschaeftDB;
import general.code.SQLiteConnection;

/**
 * 13.02.2020
 * 
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

	/**
	 * 
	 * @param nameAbteilung to get the Categories from
	 * @return all the categories for this Abteilung
	 */
	public List<String> loadKategorien(String nameAbteilung) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result;
		List<String> kategorienListe = new ArrayList<>();
		;

		try {
			conn = DriverManager.getConnection(SQLiteConnection.getSQLiteConnection());
			final String SQL = "SELECT * FROM Kategorie INNER JOIN Abteilung ON Kategorie.kaf = Abteilung.id WHERE Abteilung.nameAbteilung = ?";
			ps = conn.prepareStatement(SQL);
			ps.setString(1, nameAbteilung);
			result = ps.executeQuery();

			while (result.next()) {
				String currentKategorie = result.getString("namekategorie");
				kategorienListe.add(currentKategorie);
			}
			return kategorienListe;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void insertKategorie(String kategorie, String currentAbteilung) {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DriverManager.getConnection(SQLiteConnection.getSQLiteConnection());
			final String SQL = "INSERT INTO Kategorie VALUES (?,?,?)";
			ps = conn.prepareStatement(SQL);
			
			// values
			ps.setInt(1, SQLiteConnection.anzalAnschrift("Kategorie") + 1);
			ps.setString(2, kategorie);
			ps.setInt(3, SQLiteConnection.idBetrefendesache("Abteilung", "Geascheaft", "agf", "namegaeschaeft",
					"nameAbteilung", GeschaeftDB.getInstance().getCurrentAccountName(), currentAbteilung));
			ps.execute();
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
	}

}
