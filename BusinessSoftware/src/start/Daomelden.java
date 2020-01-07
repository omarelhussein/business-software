package start;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Daomelden {
	String s="org.sqlite.JDBC";
	private final String CONNECTIONSTRING = "jdbc:sqlite:Geaschgeaft.db";
	
		  public Daomelden() throws  ClassNotFoundException {
			// TODO Auto-generated constructor stub
			  Class.forName(s);
		}
		  
		  
		  public void insert() {
			  Connection connection=null;
			  PreparedStatement preparedStatement=null;
			  try {
				  
				  connection=DriverManager.getConnection(CONNECTIONSTRING);
				 String sa="INSERT into Abteilung VALUES (?,?,?)";
				  preparedStatement=connection.prepareStatement(sa);
				  System.out.println("dsadsadsa");
				  preparedStatement.setInt(1, 4);
				  preparedStatement.setString(2, "mohamed");
				  preparedStatement.setInt(3, 1);
				  preparedStatement.execute();
				  
				  
				
			} catch (SQLException e) {
				System.out.println(e);
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
	
