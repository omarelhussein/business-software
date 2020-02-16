package abteilungen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.sound.midi.MidiDevice.Info;
import javax.swing.JOptionPane;

import abteilungen.business_classes.Abteilung;
import abteilungen.views.JFrameAbteilungVerarbeiten;
import general.code.GeschaeftDB;
import general.code.SQLiteConnection;
import general.code.Utils;
import mitarbeiter.dao.DaoMitarbeiter;
import start.register.dao.Daomelden;
import start.register.views.JFrameRegistrieren;

public class DaoAbteilung {

	public DaoAbteilung() {
		try {
			SQLiteConnection.getSQLiteConnectionInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
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
			connection = DriverManager.getConnection(SQLiteConnection.getSQLiteConnection());
			String sql = "INSERT into Abteilung VALUES(?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, SQLiteConnection.anzalAnschrift("Abteilung") + 1);
			preparedStatement.setString(2, abteilung);
			preparedStatement.setInt(3, SQLiteConnection.idTabelle("Geascheaft", "namegaeschaeft",
					GeschaeftDB.getInstance().getCurrentAccountName()));
			preparedStatement.execute();
			System.out.println("aref");

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
	}

	/**
	 * 
	 * @param nameGeascgeaft
	 * @return
	 * @author Aref
	 */
	public Abteilung[] Abteilungen(String nameGeascheaft) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Abteilung[] abteilungen = null;
		List<Abteilung> abteilungenList = new ArrayList<>();
		try {
			connection = DriverManager.getConnection(SQLiteConnection.getSQLiteConnection());
			String sql = "SELECT * FROM Abteilung INNER JOIN Geascheaft ON Abteilung.agf = Geascheaft.id WHERE namegaeschaeft = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, nameGeascheaft);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Abteilung currentAbteilung = new Abteilung();
				currentAbteilung.setId(resultSet.getInt(1));
				currentAbteilung.setNameAbteilung(resultSet.getString("nameAbteilung"));
				abteilungenList.add(currentAbteilung);
			}
			abteilungen = abteilungenList.toArray(new Abteilung[abteilungenList.size()]);
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
		return abteilungen;
	}

	/**
	 * @author Aref
	 * @param bedinungErfullen
	 * @param nameGeascheaft
	 * @return
	 * @throws ClassNotFoundException
	 */
	public String AbteilungDelete(String bedinungErfullen, String nameGeascheaft) throws ClassNotFoundException {
		DaoMitarbeiter daomit = new DaoMitarbeiter();
		String mitarbeiter = "";
		try {
			if (SQLiteConnection.forigkeyBetrefendesache("Mitarbeiter", "maf", "Abteilung", "nameAbteilung",
					bedinungErfullen, SQLiteConnection.idBetrefendesache("Abteilung", "Geascheaft", "agf",
							"namegaeschaeft", "nameAbteilung", nameGeascheaft, bedinungErfullen)) != 0) {
				for (int i = 0; i < daomit.loadMitarbeiter(nameGeascheaft, bedinungErfullen).length; i++) {
					mitarbeiter += " < "
							+ daomit.loadMitarbeiter(nameGeascheaft, bedinungErfullen)[i].getNamemitarbeiter() + " >";
				}
				System.out.println("hallo" + mitarbeiter);
				return mitarbeiter;
			}
			SQLiteConnection.Delete("Abteilung", "nameAbteilung", "agf", bedinungErfullen, SQLiteConnection
					.idTabelle("Geascheaft", "namegaeschaeft", GeschaeftDB.getInstance().getCurrentAccountName()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public void updateAbteilung(String nameNeu, String nameAlte) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DriverManager.getConnection(SQLiteConnection.getSQLiteConnection());
			String sql = "UPDATE Abteilung set nameAbteilung=? where Abteilung.id =(SELECT Abteilung.id from Abteilung INNER join Geascheaft on Abteilung.agf=Geascheaft.id where Abteilung.nameAbteilung=? )";

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, nameNeu);
			preparedStatement.setString(2, nameAlte);
			System.out.println(sql);

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

}
