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
import general.code.Utils;
import main.dao.DaoGescheaft;
import start.register.views.JFrameRegistrieren;

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
			String katjglbefehl = "insert into Kategorie values (?,?,?)";
			preparedStatement = connection.prepareStatement(katjglbefehl);
			preparedStatement.setInt(1, SQLiteConnection.anzalAnschrift("Kategorie") + 1);
			preparedStatement.setString(2, katig);
			preparedStatement.setInt(3, SQLiteConnection.idBetrefendesache("Abteilung", "Geascheaft", "agf",
					"namegaeschaeft", "nameAbteilung", GeschaeftDB.getInstance().getCurrentAccountName(), abteilung));
			preparedStatement.execute();
			connection.close();
			preparedStatement.close();
			connection = null;
			preparedStatement = null;
			try {
				connection = DriverManager.getConnection(SQLiteConnection.getSQLiteConnection());
				String artikelbefehl = "insert into Artikel values (?,?,?,?)";
				preparedStatement = connection.prepareStatement(artikelbefehl);
				preparedStatement.setInt(1, SQLiteConnection.anzalAnschrift("Artikel") + 1);
				preparedStatement.setString(2, artikel.getNameArtikel());
				preparedStatement.setString(3, artikel.getPreis());
				String nameGeascheaft = SQLiteConnection.nameGeascheaft("Abteilung", "Geascheaft", "agf", "id",
						"nameAbteilung", "namegaeschaeft", abteilung,
						GeschaeftDB.getInstance().getCurrentAccountName());
				preparedStatement.setInt(4, SQLiteConnection.idBetrefendesache("Kategorie", "Abteilung", "kaf",
						"nameAbteilung", "nameKategorie", nameGeascheaft, katig));
				preparedStatement.execute();
				nameGeascheaft = "";
			} catch (SQLException e) {
				System.out.println("e1 :" + e);
			}

		} catch (SQLException e) {
			System.out.println("e2: " + e);
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
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
	 * @return
	 */
	public List<Artikel> artikelLaden(String abteilung) {
		System.out.println("hallo");
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		List<Artikel> artikelList = new ArrayList<Artikel>();
		try {
			connection = DriverManager.getConnection(SQLiteConnection.getSQLiteConnection());
			String sql = "SELECT  * from Artikel INNER JOIN Kategorie on Artikel.akf = Kategorie.id where kategorie.kaf = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, SQLiteConnection.idBetrefendesache("Abteilung", "Geascheaft", "agf", "namegaeschaeft", "nameAbteilung", GeschaeftDB.getInstance().getCurrentAccountName(),abteilung ));
			preparedStatement.execute();
			result = preparedStatement.executeQuery();
			
			while(result.next()) {
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
	public String nameKategorie(String nameAbteilung) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String name="";
		try {
			connection = DriverManager.getConnection(SQLiteConnection.getSQLiteConnection());
			String sql="select namekategorie from kategorie inner join Abteilung on Abteilung.id=kategorie.kaf where   Abteilung.nameAbteilung=? and Abteilung.agf=?";
			preparedStatement = connection.prepareStatement(sql);
			System.out.println("Hallo"+sql);
			preparedStatement.setInt(2, SQLiteConnection.idBetrefendesache("Abteilung", "Geascheaft", "agf", "namegaeschaeft", "nameAbteilung", GeschaeftDB.getInstance().getCurrentAccountName(),nameAbteilung ));
			preparedStatement.setString(1, nameAbteilung);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			name=resultSet.getString("nameAbteilung");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
				preparedStatement.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return name;
		
	}
}
