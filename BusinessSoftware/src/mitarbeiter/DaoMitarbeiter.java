 package mitarbeiter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import general.SQLiteConnection;
import general.Utils;
import main.Anschrift;
import registrierung.JFrameRegistrieren;

public class DaoMitarbeiter {
	
	final String sqlresors="Geaschgeaft.db";
	
	public DaoMitarbeiter() throws ClassNotFoundException {
		SQLiteConnection.getSQLiteConnectionInstance();
	}
	public void insert(Mitarbeiter mitarbeiter,String aNmae,Anschrift anschrift) {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		try {
	
			connection=DriverManager.getConnection(SQLiteConnection.getSQLiteConnectionString(sqlresors));
			String sqlAnschrift="insert into Anschrift values(?,?,?,?)";
			preparedStatement=connection.prepareStatement(sqlAnschrift);
			preparedStatement.setInt(1, Utils.anzalAnschrift("Anschrift", sqlresors)+1);
			preparedStatement.setString(2, anschrift.getAdressse());
			preparedStatement.setString(3, anschrift.getStadt());
			preparedStatement.setString(4, anschrift.getTel());
			preparedStatement.execute();
		    String sqlb="insert into Mitarbeiter values (?,?,?,?,?,?,?)";
			preparedStatement =connection.prepareStatement(sqlb);
			preparedStatement.setInt(1,Utils.anzalAnschrift("Mitarbeiter", sqlresors)+1);
			preparedStatement.setString(2, mitarbeiter.getName());
			preparedStatement.setString(3, mitarbeiter.getNachname());
			preparedStatement.setString(4, mitarbeiter.getLohn());
			preparedStatement.setInt(6, Utils.idBetrefendesache("Abteilung","Geascheaft","agf","namegaeschaeft","nameAbteilung",JFrameRegistrieren.nameGeascheaft,aNmae,sqlresors));
			
			preparedStatement.setInt(7, Utils.anzalAnschrift("Anschrift", sqlresors));
			preparedStatement.execute();
		} catch (SQLException e) {
			System.out.println(e);
		}finally {
			try {
				connection.close();
				preparedStatement.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
	}

}
