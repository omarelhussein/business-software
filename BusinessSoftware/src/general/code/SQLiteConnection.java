package general.code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLiteConnection {

	private static String CONNECTION_STRING = "jdbc:sqlite:";
	private static final String SQLITE_LIBRARY_CONNECTION = "org.sqlite.JDBC";
	private static final String DB_FILE = "Geaschgeaft.db";

	public static String getSQLiteConnection() {
		return CONNECTION_STRING + DB_FILE;
	}

	public static Class<?> getSQLiteConnectionInstance() throws ClassNotFoundException {
		return Class.forName(SQLITE_LIBRARY_CONNECTION);
	}

	/**
	 * 
	 * @param tableName
	 * @param tableName2
	 * @param colum
	 * @param colum2
	 * @param colum3
	 * @param bedinungErfullung
	 * @param bedinungErfullung2
	 * @param sqlRecorse
	 * @return
	 * @author Aref
	 */
// diese methode helft die mit andere Tabelle verbunden sind also unter bedinung
	public static int idBetrefendesache(String tableName, String tableName2, String colum, String colum2, String colum3,
			String bedinungErfullung, String bedinungErfullung2) {
		Connection conn = null;
		PreparedStatement statmment = null;
		int d = 0;
		try {
			conn = DriverManager.getConnection(SQLiteConnection.getSQLiteConnection());
			String an = "select " + tableName + ".id from " + tableName + " inner join " + tableName2 + " on "
					+ tableName + "." + colum + "=" + tableName2 + ".id where " + tableName2 + "." + colum2
					+ " = ?  and " + tableName + "." + colum3 + " = ?";
			System.out.println("hier"+an);
			statmment = conn.prepareStatement(an);
			statmment.setString(1, bedinungErfullung);
			statmment.setString(2, bedinungErfullung2);
			statmment.execute();
			ResultSet resultSet = statmment.executeQuery();
			resultSet.next();
			d = resultSet.getInt("id");
		} catch (SQLException e) {
			System.out.println(e);
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
	 * @param tableName
	 * @param sqlRecorse
	 * @return
	 * @author Aref
	 * 
	 * diese mithode helft die id von jede Tabele zu wissen
	 */
	public static int anzalAnschrift(String tableName) {
		Connection conn = null;
		PreparedStatement statmment = null;
		int d = 0;
		try {
			conn = DriverManager.getConnection(SQLiteConnection.getSQLiteConnection());
			String an = "select Max (id) As gesamt from " + tableName;
			statmment = conn.prepareStatement(an);

			statmment.execute();
			ResultSet resultSet = statmment.executeQuery();
			resultSet.next();
			d = resultSet.getInt("gesamt");
		} catch (SQLException e) {
			// TODO: handle exception
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
	 * 
	 * @param bedinungErfullung
	 * @param sqlRecorse
	 * @return
	 * @author Aref
	 */
	// dies methode helft um nameabteilung damit wir wissen zu welche Abteilung
	// gehort muss die mit arbeiter gehoren

	public static String nameGeascheaft(String tableName, String tableName2, String colum, String colum2, String colum3,
			String colum4, String bedinungErfullung, String bedinungErfullung2) {
		Connection conn = null;
		PreparedStatement statmment = null;
		String d = "";
		try {
			conn = DriverManager.getConnection(SQLiteConnection.getSQLiteConnection());
			String an = "select " + tableName + ".nameAbteilung As gesamt from " + tableName + " inner join "
					+ tableName2 + " on " + tableName + "." + colum + " = " + tableName2 + "." + colum2 + " where "
					+ tableName + "." + colum3 + " = ?  and " + tableName2 + "." + colum4 + " = ?";
			System.out.println("das ist was du" + an);
			statmment = conn.prepareStatement(an);
			System.out.println("das ist was du" + an);
			statmment.setString(1, bedinungErfullung);
			statmment.setString(2, bedinungErfullung2);
			statmment.execute();
			ResultSet resultSet = statmment.executeQuery();

			d = resultSet.getString("gesamt");
			System.out.println("dasdsa" + d);

			resultSet.next();

		} catch (SQLException e) {
			// TODO: handle exception
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

	public static void Delete(String tabelName, String colum1, String colum2, String bedinungErfullen, int i) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {

			connection = DriverManager.getConnection(getSQLiteConnection());
			String sqlBefehl = "Delete from " + tabelName + " where " + tabelName + "." + colum1 + " = ? and "
					+ tabelName + "." + colum2 + " = " + i;
			System.out.println(sqlBefehl);
			preparedStatement = connection.prepareStatement(sqlBefehl);
			preparedStatement.setString(1, bedinungErfullen);
			preparedStatement.execute();
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

	// die helft die id von die sache zu holen
	public static int idTabelle(String tabelleName, String colum, String bedinungErfullen) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int id = 0;
		try {
			connection = DriverManager.getConnection(getSQLiteConnection());
			String sqlbefehl = "select id from " + tabelleName + " where  " + tabelleName + "." + colum + " = ?";
			preparedStatement = connection.prepareStatement(sqlbefehl);
			preparedStatement.setString(1, bedinungErfullen);
			ResultSet resultSet = preparedStatement.executeQuery();
			id = resultSet.getInt("id");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				preparedStatement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return id;

	}

	// diese methode helft name von sache zu uberpruphen
	public static String uberBrufname(String tabeleName, String colum, String colum2, String bedinung) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String name = "";
		try {
			connection = DriverManager.getConnection(getSQLiteConnection());
			String sqlBefehl = " select " + colum + " from " + tabeleName + " where  " + colum2 + " = ? ";
			preparedStatement = connection.prepareStatement(sqlBefehl);
			preparedStatement.setString(1, bedinung);
			ResultSet resultSet = preparedStatement.executeQuery();
			name = resultSet.getString(colum);

		} catch (SQLException e) {
			// TODO: handle exception
		} finally {
			try {
				connection.close();
				preparedStatement.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return name;
	}
	/**
	 * 
	 * @param tableName
	 * @param forigkey
	 * @param tableName2
	 * @param colum
	 * @param bedinungErfullung
	 * @param bedinungErfullung2
	 * @param sqlRecorse
	 * @return
	 * @author Aref
	 */
	public static int forigkeyBetrefendesache(String tableName,String forigkey, String tableName2, String colum,
			String bedinungErfullung,int bedinungErfullung2) {
		Connection conn = null;
		PreparedStatement statmment = null;
		int d = 0;
		try {
			conn = DriverManager.getConnection(SQLiteConnection.getSQLiteConnection());
			String an = "select " + tableName +"."+forigkey+" from " + tableName + " inner join " + tableName2 +" on "
					+ tableName +"."+ forigkey+ " = " + tableName2 +".id where " + tableName2 +"."+ colum
					+ " = ? and  "+tableName2+".id = ?";
			System.out.println(an);
			statmment = conn.prepareStatement(an);
			statmment.setString(1, bedinungErfullung);
			statmment.setInt(2, bedinungErfullung2);
			System.out.println("ich bin hier von SQlite klasse vor Result");
			ResultSet resultSet = statmment.executeQuery();
		while(resultSet.next()) {
			
			d = resultSet.getInt(forigkey);
		
		}
			
			System.out.println("ich bin hier von SQlite klasse :"+d);
		} catch (SQLException e) {
			System.out.println(e);
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
