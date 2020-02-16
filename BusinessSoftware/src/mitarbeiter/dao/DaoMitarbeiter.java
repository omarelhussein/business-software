package mitarbeiter.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import general.code.GeschaeftDB;
import general.code.SQLiteConnection;
import main.business_classes.Anschrift;
import mitarbeiter.business_classes.Mitarbeiter;

/**
 * @author ajab
 * @author Aref
 *
 */
public class DaoMitarbeiter {

	public DaoMitarbeiter() {
		try {
			SQLiteConnection.getSQLiteConnectionInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * 
	 * @param mitarbeiter
	 * @param aNmae
	 * @param anschrift
	 * @author Aref
	 */
	public void insert(Mitarbeiter mitarbeiter, String aNmae, Anschrift anschrift) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {

			connection = DriverManager.getConnection(SQLiteConnection.getSQLiteConnection());
			String sqlAnschrift = "insert into Anschrift values(?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(sqlAnschrift);
			preparedStatement.setInt(1, SQLiteConnection.anzalAnschrift("Anschrift") + 1);
			preparedStatement.setString(2, anschrift.getAdressse());
			preparedStatement.setString(3, anschrift.getStadt());
			preparedStatement.setString(4, anschrift.getTel());
			preparedStatement.setString(5, anschrift.getPlz());
			preparedStatement.execute();
			String sqlb = "insert into Mitarbeiter values (?,?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(sqlb);
			preparedStatement.setInt(1, SQLiteConnection.anzalAnschrift("Mitarbeiter") + 1);
			preparedStatement.setString(2, mitarbeiter.getNamemitarbeiter());
			preparedStatement.setString(3, mitarbeiter.getNachname());
			preparedStatement.setString(4, mitarbeiter.getLohn());
			preparedStatement.setString(5, mitarbeiter.getPass());
			preparedStatement.setInt(6, SQLiteConnection.idBetrefendesache("Abteilung", "Geascheaft", "agf",
					"namegaeschaeft", "nameAbteilung", GeschaeftDB.getInstance().getCurrentAccountName(), aNmae));

			preparedStatement.setInt(7, SQLiteConnection.anzalAnschrift("Anschrift"));
			preparedStatement.execute();
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			try {
				connection.close();
				preparedStatement.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

	}

	/**
	 * Created On 21.01.2020
	 * 
	 * @author ajab teil davon aref
	 */
	public boolean mitarbeitereinlogen(String name, String password, String nameGeascheaft)
			throws ClassNotFoundException {

		PreparedStatement preparedStatment = null;
		Connection connection = null;

		try {
			connection = DriverManager.getConnection(SQLiteConnection.getSQLiteConnection());
			String sql = "SELECT * FROM  Mitarbeiter inner join Abteilung on Mitarbeiter.maf = Abteilung.id WHERE Abteilung.agf = ? and namemitarbeiter = ? AND pass = ?";
			System.out.println(sql);
			preparedStatment = connection.prepareStatement(sql);
			preparedStatment.setInt(1, SQLiteConnection.idTabelle("Geascheaft", "namegaeschaeft", nameGeascheaft));
			preparedStatment.setString(2, name);
			preparedStatment.setString(3, password);

			ResultSet result = preparedStatment.executeQuery();
			if (result.next()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.out.println("von mit :" + e);
		} finally {
			try {
				connection.close();
				preparedStatment.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	/**
	 * @author Aref
	 * @param nameGeascheaft
	 * @param nameabtei
	 */
	public Mitarbeiter[] loadMitarbeiter(String nameGeascheaft, String nameabtei) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ArrayList<Mitarbeiter> mitarbeiterListe = new ArrayList<>();
		Mitarbeiter[] mitarbeiterArray = null;
		Mitarbeiter currentMitarbeiter;
		try {
			connection = DriverManager.getConnection(SQLiteConnection.getSQLiteConnection());
			String sql = "select Mitarbeiter.id,Mitarbeiter.namemitarbeiter,Mitarbeiter.nachname,Mitarbeiter.lohn,Mitarbeiter.pass from Mitarbeiter inner join Abteilung on Mitarbeiter.maf=Abteilung.id where  Mitarbeiter.maf =?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, SQLiteConnection.idBetrefendesache("Abteilung", "Geascheaft", "agf",
					"namegaeschaeft", "nameAbteilung", nameGeascheaft, nameabtei));
			System.out.println("von hier"+sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				currentMitarbeiter = new Mitarbeiter();
				currentMitarbeiter.setId(resultSet.getInt("id"));
				currentMitarbeiter.setNamemitarbeiter(resultSet.getString("namemitarbeiter"));
				currentMitarbeiter.setNachname(resultSet.getString("nachname"));
				currentMitarbeiter.setLohn(resultSet.getString("lohn"));
				currentMitarbeiter.setPass(resultSet.getString("pass"));
				
System.out.println("von omar");
				mitarbeiterListe.add(currentMitarbeiter);
			}
			mitarbeiterArray = new Mitarbeiter[mitarbeiterListe.size()];

			for (int i = 0; i < mitarbeiterListe.size(); i++) {
				mitarbeiterArray[i] = mitarbeiterListe.get(i);
			}

		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			try {
				connection.close();
				preparedStatement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return mitarbeiterArray;
	}
	
	public void deletMitarbeiter(String abteilung,String namemitarbeiter) {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		try {
			connection=DriverManager.getConnection(SQLiteConnection.getSQLiteConnection());
			String sql="Delete from mitarbeiter where mitarbeiter.namemitarbeiter=? and mitarbeiter.nachname=? ";
			System.out.println("arefii"+sql);
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, namemitarbeiter);
			preparedStatement.setString(2, namchNamemitarbeiter(abteilung, namemitarbeiter));
			

			preparedStatement.execute();
			
		} catch (Exception e) {
			System.out.println("von delet:"+e);
		}finally {
			try {
				connection.close();
				preparedStatement.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	public String namchNamemitarbeiter(String abteilung,String namemitarbeiter) {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		String nachname="";
		try {
			connection=DriverManager.getConnection(SQLiteConnection.getSQLiteConnection());
			String sql="select mitarbeiter.nachname from mitarbeiter inner join Abteilung on Abteilung.id=Mitarbeiter.maf where  Mitarbeiter.namemitarbeiter=? and Abteilung.id=?";
			preparedStatement=connection.prepareStatement(sql);
			
			preparedStatement.setString(1, namemitarbeiter);
			preparedStatement.setInt(2, SQLiteConnection.idBetrefendesache("Abteilung", "Geascheaft", "agf",
					"namegaeschaeft", "nameAbteilung", GeschaeftDB.getInstance().getCurrentAccountName(), abteilung));
		ResultSet resultSet=preparedStatement.executeQuery();
		nachname=resultSet.getString("nachname");
		System.out.println(nachname);
			preparedStatement.execute();
			
		} catch (Exception e) {
			System.out.println("von delet:"+e);
		}finally {
			try {
				connection.close();
				preparedStatement.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return nachname;
	}
}
