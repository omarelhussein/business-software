package start;

import general.SQLiteConnection;

public class Daoanmelden {
<<<<<<< Updated upstream

	public Daoanmelden() throws ClassNotFoundException {
		SQLiteConnection.getSQLiteConnectionInstance();
=======
	
	String s = "org.sqlite.JDBC";
	private final String CONNECTIONSTRING = "jdbc:sqlite:Geaschgeaft.db";

	public Daoanmelden() throws ClassNotFoundException {
		// TODO Auto-generated constructor stub
		Class.forName(s);
>>>>>>> Stashed changes
	}

}
