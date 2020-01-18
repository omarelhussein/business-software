package artikel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import general.SQLiteConnection;
import general.Utils;
import registrierung.JFrameRegistrieren;

public class DaoArtikel {
	final String sql ="Geaschgeaft.db";
	
	public DaoArtikel() throws ClassNotFoundException {
		SQLiteConnection.getSQLiteConnectionInstance();
	}
	/**
	 * 
	 * @param artikel
	 * @param katig
	 * @param abteilung
	 * @author Aref
	 */
	public void insertArtkel(Artikel artikel,String katig,String abteilung) {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		try {
			connection=DriverManager.getConnection(SQLiteConnection.getSQLiteConnectionString(sql));
			String katjglbefehl="insert into Kategorie values (?,?,?)";
			preparedStatement=connection.prepareStatement(katjglbefehl);
			preparedStatement.setInt(1, Utils.anzalAnschrift("Kategorie", sql)+1);
			preparedStatement.setString(2,katig);
			preparedStatement.setInt(3,Utils.idBetrefendesache("Abteilung","Geascheaft","agf","namegaeschaeft","nameAbteilung",JFrameRegistrieren.nameGeascheaft,abteilung,sql));
			preparedStatement.execute();
			connection.close();
			preparedStatement.close();
			connection=null;
			preparedStatement=null;
			try {
			connection=DriverManager.getConnection(SQLiteConnection.getSQLiteConnectionString(sql));
			String artikelbefehl="insert into Artikel values (?,?,?,?)";
			preparedStatement=connection.prepareStatement(artikelbefehl);
			preparedStatement.setInt(1, Utils.anzalAnschrift("Artikel", sql)+1);
			preparedStatement.setString(2,artikel.getNameArtikel());
			preparedStatement.setString(3, artikel.getPreis());
			String nameGeascheaft=Utils.nameGeascheaft("Abteilung","Geascheaft","agf","id","nameAbteilung","namegaeschaeft",abteilung,JFrameRegistrieren.nameGeascheaft, sql);
			preparedStatement.setInt(4, Utils.idBetrefendesache("Kategorie","Abteilung","kaf","nameAbteilung","nameKategorie",nameGeascheaft,katig,sql));
			preparedStatement.execute();
			nameGeascheaft="";
			} catch (SQLException e) {
				System.out.println("e1 :"+e);
			}
			
		} catch (SQLException e) {
			System.out.println("e2: "+e);
		}finally {
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
	public int anzalAnschrift(String bedinung1,String name,String tableName) {
		Connection conn = null;
		PreparedStatement statmment = null;
		int d = 0;
		try {
			conn = DriverManager.getConnection(SQLiteConnection.getSQLiteConnectionString(sql));
			String an = "select  id  from "+tableName+" where "+name+" = ?";
			statmment = conn.prepareStatement(an);
			statmment.setString(1, bedinung1);
			statmment.execute();
			ResultSet resultSet = statmment.executeQuery();
			resultSet.next();
			d = resultSet.getInt("id");
		} catch (SQLException e) {
			System.out.println("hier ist die "+e);
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

}
