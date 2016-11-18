package HairHairHair;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnector
{
	
	public static Connection con;

	// Constructor
	public JdbcConnector()
	{
		try
		{
			// Accessing driver from jar file
			Class.forName("com.mysql.jdbc.Driver");
			
			// Creating a variable for the connection "con"
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost/exam", "root", "");
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

}