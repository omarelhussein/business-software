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
import kategorie.business_classes.Kategorie;

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
	public List<Kategorie> loadKategorien(int abteilungID) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result;
		List<Kategorie> kategorienListe = new ArrayList<>();

		try {
			conn = DriverManager.getConnection(SQLiteConnection.getSQLiteConnection());
			final String SQL = "SELECT * FROM Kategorie INNER JOIN Abteilung ON Kategorie.kaf = Abteilung.id WHERE Abteilung.id = ?";
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, abteilungID);
			result = ps.executeQuery();

			while (result.next()) {
				Kategorie currentKategorie = new Kategorie();
				currentKategorie.setNamekategorie(result.getString("namekategorie"));
				currentKategorie.setId(result.getInt(1));
				kategorienListe.add(currentKategorie);
			}
			return kategorienListe;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public void insertKategorie(Kategorie kategorie, int currentAbteilungID) {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DriverManager.getConnection(SQLiteConnection.getSQLiteConnection());
			final String SQL = "INSERT INTO Kategorie VALUES (?,?,?)";
			ps = conn.prepareStatement(SQL);

			// values
			ps.setInt(1, SQLiteConnection.anzalAnschrift("Kategorie") + 1);
			ps.setString(2, kategorie.getNamekategorie());
			ps.setInt(3, getId(currentAbteilungID));
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

	private int getId(int abteilungID) {
		Connection conn = null;
		PreparedStatement ps = null;
		int id = 0;
		try {
			conn = DriverManager.getConnection(SQLiteConnection.getSQLiteConnection());
			final String SQL = "SELECT Abteilung.id FROM Abteilung INNER JOIN Geascheaft on Abteilung.agf = Geascheaft.id WHERE Geascheaft.namegaeschaeft = ? AND Abteilung.id = ?";
			ps = conn.prepareStatement(SQL);
			// values
			ps.setString(1, GeschaeftDB.getInstance().getCurrentAccountName());
			ps.setInt(2, abteilungID);
			ResultSet result = ps.executeQuery();
			if (result.next()) {
				id = result.getInt(1);
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
		return id;
	}

}
