package mitarbeiter.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created On 21.01.2020
 * @author ajab
 *
 */
public class DaoMitarbeiter {
	
	private final String DATEI = "Geaschgeaft.db";
	private final String URL = "jdbc:sqlite:" + DATEI;
	
	public boolean  mitarbeitereinlogen(String name, String password) throws ClassNotFoundException {
		
		PreparedStatement preparedStatment = null;
		Connection connection = null;
		
		try {
			connection = DriverManager.getConnection(URL);
			String sql = "SELECT * FROM  Mitarbeiter WHERE namemitarbeiter = ? AND pass = ?";
			preparedStatment = connection.prepareStatement(sql);
			preparedStatment.setString(1, name);
			preparedStatment.setString(2, password);
			
			ResultSet result = preparedStatment.executeQuery();
			if (result.next()) {
				return true;
			}
			else {
			return	false;
			}
		} catch (Exception e) {
			
		}
		return false;
		
		
		
	}
	
}
