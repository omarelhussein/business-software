package artikel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import artikel.business_classes.Artikel;
import general.code.GeschaeftDB;
import general.code.SQLiteConnection;

public class DaoArtikel {

	public DaoArtikel() {
		try {
			SQLiteConnection.getSQLiteConnectionInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param artikel
	 * @param katig
	 * @param abteilung
	 * @author Aref
	 */
	public void insertArtkel(Artikel artikel, String katig, String abteilung) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DriverManager.getConnection(SQLiteConnection.getSQLiteConnection());
			String artikelbefehl = "insert into Artikel values (?,?,?,?)";
			preparedStatement = connection.prepareStatement(artikelbefehl);
			preparedStatement.setInt(1, SQLiteConnection.anzalAnschrift("Artikel") + 1);
			preparedStatement.setString(2, artikel.getNameArtikel());
			preparedStatement.setString(3, artikel.getPreis());
			String nameGeascheaft = SQLiteConnection.nameGeascheaft("Abteilung", "Geascheaft", "agf", "id",
					"nameAbteilung", "namegaeschaeft", abteilung, GeschaeftDB.getInstance().getCurrentAccountName());
			preparedStatement.setInt(4, SQLiteConnection.idBetrefendesache("Kategorie", "Abteilung", "kaf",
					"nameAbteilung", "nameKategorie", nameGeascheaft, katig));
			preparedStatement.execute();
			nameGeascheaft = "";
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	/**
	 * 
	 * @param bedinung1
	 * @param name
	 * @param tableName
	 * @return
	 * @author Aref
	 */
	public int anzalAnschrift(String bedinung1, String name, String tableName) {
		Connection conn = null;
		PreparedStatement statmment = null;
		int d = 0;
		try {
			conn = DriverManager.getConnection(SQLiteConnection.getSQLiteConnection());
			String an = "select  id  from " + tableName + " where " + name + " = ?";
			statmment = conn.prepareStatement(an);
			statmment.setString(1, bedinung1);
			statmment.execute();
			ResultSet resultSet = statmment.executeQuery();
			resultSet.next();
			d = resultSet.getInt("id");
		} catch (SQLException e) {
			System.out.println("hier ist die " + e);
			System.out.println(d);
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

	/**
	 * Ajab
	 * 
	 * @return liste von artikeln der Abteilung
	 */
	public List<Artikel> loadAbteilungArtikeln(String abteilung) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		List<Artikel> artikelList = new ArrayList<Artikel>();
		try {
			connection = DriverManager.getConnection(SQLiteConnection.getSQLiteConnection());
			String sql = "SELECT  * from Artikel INNER JOIN Kategorie on Artikel.akf = Kategorie.id where kategorie.kaf = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, SQLiteConnection.idBetrefendesache("Abteilung", "Geascheaft", "agf",
					"namegaeschaeft", "nameAbteilung", GeschaeftDB.getInstance().getCurrentAccountName(), abteilung));
			preparedStatement.execute();
			result = preparedStatement.executeQuery();

			while (result.next()) {
				Artikel artikel = new Artikel();
				artikel.setId(result.getInt(1));

				artikel.setNameArtikel(result.getString("nameartikel"));
				artikel.setPreis(result.getString("preis"));
				artikelList.add(artikel);
			}
			return artikelList;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return null;
	}

	/**
	 * load list articles from the categorie stored in the DB
	 * 
	 * @param kategorie to get the articles from
	 * @return the list of all articles found in the kategorie
	 */
	public List<Artikel> loadKategorienArtikeln(String kategorie) {
		Connection conn = null;
		PreparedStatement ps = null;
		Artikel currentArtikel;
		List<Artikel> artikelList = new ArrayList<>();
		try {
			conn = DriverManager.getConnection(SQLiteConnection.getSQLiteConnection());
			final String SQL = "SELECT * FROM Artikel INNER JOIN Kategorie ON Artikel.akf = Kategorie.id WHERE Kategorie.namekategorie = ?";
			ps = conn.prepareStatement(SQL);
			ps.setString(1, kategorie);
			ResultSet result = ps.executeQuery();
			while (result.next()) {
				currentArtikel = new Artikel();
				currentArtikel.setId(result.getInt(1));
				currentArtikel.setNameArtikel(result.getString("nameartikel"));
				currentArtikel.setPreis(result.getString("preis"));
				artikelList.add(currentArtikel);
			}
			return artikelList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void deleteArtikel(int id) {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DriverManager.getConnection(SQLiteConnection.getSQLiteConnection());
			final String SQL = "DELETE FROM Artikel WHERE id = ?";
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, id);
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

	public void updateArtikel(Artikel artikel) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = DriverManager.getConnection(SQLiteConnection.getSQLiteConnection());
			final String SQL = "UPDATE Artikel SET nameartikel = ?, preis = ? WHERE id = ?";
			ps = conn.prepareStatement(SQL);
			if(artikel == null) {
				return;
			}
			ps.setString(1, artikel.getNameArtikel());
			ps.setString(2, artikel.getPreis());
			ps.setInt(3, artikel.getId());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
