package abteilungen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sound.midi.MidiDevice.Info;
import javax.swing.JOptionPane;

import abteilungen.views.JFrameAbteilungVerarbeiten;
import general.code.GeschaeftDB;
import general.code.SQLiteConnection;
import general.code.Utils;
import mitarbeiter.dao.DaoMitarbeiter;
import start.register.dao.Daomelden;
import start.register.views.JFrameRegistrieren;

public class DaoAbteilung {
	private Daomelden daoanmelden;
	private final String SQLITE_TABLE = "Geaschgeaft.db";

	public DaoAbteilung() throws ClassNotFoundException {
		// TODO Auto-generated constructor stub
		SQLiteConnection.getSQLiteConnectionInstance();
		daoanmelden = new Daomelden();
	}

	/**
	 * 
	 * @param nameGeascgeaft
	 * @return
	 * @author Aref
	 */

	public void insertAbteilung(String abteilung) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DriverManager.getConnection(SQLiteConnection.getSQLiteConnectionString(SQLITE_TABLE));
			String sql = "INSERT into Abteilung VALUES(?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, SQLiteConnection.anzalAnschrift("Abteilung", SQLITE_TABLE) + 1);
			preparedStatement.setString(2, abteilung);
			preparedStatement.setInt(3, SQLiteConnection.idTabelle("Geascheaft", "namegaeschaeft", GeschaeftDB.getInstance().getCurrentAccountName(), SQLITE_TABLE));
			preparedStatement.execute();
			System.out.println("aref");

		} catch (SQLException e) {
			// TODO: handle exception
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
	 * 
	 * @param nameGeascgeaft
	 * @return
	 * @author Aref
	 */
	public String[] Abteilungen(String nameGeascheaft) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String abteilunge = "";
		String[] abteilungen = null;
		try {
			connection = DriverManager.getConnection(SQLiteConnection.getSQLiteConnectionString(SQLITE_TABLE));
			String sql = "select nameAbteilung from Abteilung inner join Geascheaft on Abteilung.agf=Geascheaft.id where namegaeschaeft =?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, nameGeascheaft); 
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				abteilunge += resultSet.getString("nameAbteilung") + "_";
				System.out.println(resultSet.getFetchSize());
			}
			abteilungen = abteilunge.split("_");
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
		return abteilungen;
	}
	/**
	 * @author Aref
	 * @param bedinungErfullen
	 * @param nameGeascheaft
	 * @return
	 * @throws ClassNotFoundException
	 */

	public String  AbteilungDelete(String bedinungErfullen,String nameGeascheaft) throws ClassNotFoundException {
		DaoMitarbeiter daomit=new DaoMitarbeiter();
		JFrameAbteilungVerarbeiten frame =new JFrameAbteilungVerarbeiten();
		String mitarbeiter="";
		try {
			if(SQLiteConnection.forigkeyBetrefendesache("Mitarbeiter", "maf", "Abteilung", "nameAbteilung",bedinungErfullen,SQLiteConnection.idBetrefendesache("Abteilung", "Geascheaft", "agf", "namegaeschaeft", "nameAbteilung", nameGeascheaft
					, bedinungErfullen, SQLITE_TABLE), SQLITE_TABLE)!=0) {
				for (int i = 0; i <daomit.nameMitarbeiter(nameGeascheaft,bedinungErfullen) .length; i++) {
					mitarbeiter+=" < "+daomit.nameMitarbeiter(nameGeascheaft,bedinungErfullen)[i]+" >";
				}
				System.out.println("hallo"+ mitarbeiter);
				//JOptionPane.showConfirmDialog(frame, mitarbeiter,"fur diese Abteilung sind schon Mitarbeiter ", 1);
				return mitarbeiter;
				
				
			}
			SQLiteConnection.Delete("Abteilung", "nameAbteilung", "agf", bedinungErfullen, SQLiteConnection.idTabelle(
					"Geascheaft", "namegaeschaeft", GeschaeftDB.getInstance().getCurrentAccountName(), SQLITE_TABLE), SQLITE_TABLE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";

	}
	/**
	 * @author Aref
	 * @param nameNeu
	 * @param nameAlte
	 */
	public  void updet(String nameNeu,String nameAlte) {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		try {
			connection=DriverManager.getConnection(SQLiteConnection.getSQLiteConnectionString(SQLITE_TABLE));
			String sql ="UPDATE Abteilung set nameAbteilung=? where Abteilung.id =(SELECT Abteilung.id from Abteilung INNER join Geascheaft on Abteilung.agf=Geascheaft.id where Abteilung.nameAbteilung=? )";
			
			
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, nameNeu);
			preparedStatement.setString(2, nameAlte);
		    System.out.println(sql);
			
			preparedStatement.execute();
			
			
		} catch (SQLException e) {
			// TODO: handle exception
		}finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

}
