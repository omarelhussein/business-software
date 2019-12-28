package general;

public class SQLiteConnection {

	
	private static String CONNECTION_STRING = "jdbc:sqlite:";
	private static final String SQLITE_LIBRARY_CONNECTION = "org.sqlite.JDBC";
	
	public static String getSQLiteConnectionString(String sqliteTableName) {
		return CONNECTION_STRING + sqliteTableName;
	}

	public static Class<?> getSQLiteConnectionInstance() throws ClassNotFoundException {
		return Class.forName(SQLITE_LIBRARY_CONNECTION);
	}
	
	

}
