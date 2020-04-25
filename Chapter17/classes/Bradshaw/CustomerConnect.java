// Connect to CustomerDatabase
package Bradshaw;

import java.sql.*;

public class CustomerConnect
{
	// The Data Source name is "BradshawDatabase"
	static String url = "jdbc:odbc:BradshawDatabase";
	static Connection aConnection;

	// establish the database connection
	public static Connection initialize()
	{
		try
 		{ 	// load the jdbc - odbc bridge driver for Windows
			  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	    	// create connection instance
	    	aConnection = DriverManager.getConnection(url, "", "");
	 	}
		catch (ClassNotFoundException e)
			{System.out.println(e);}
		catch (SQLException e)
			{ System.out.println(e); }
		return aConnection;
	}

	// close the database connection
	public static void terminate()
	{
		try
 		{
    		aConnection.close();
		}
		catch (SQLException e)
			{ System.out.println(e);	}
	}
}