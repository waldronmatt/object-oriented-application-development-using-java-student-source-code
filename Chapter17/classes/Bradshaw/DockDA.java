/* DockDA for Chapte 17
   Only those DA and other methods necessary are included
   This version of DockDA includes a find method that
   returns Dock attributes only
*/

package Bradshaw;

import java.sql.*;

public class DockDA
{

	static Dock aDock;
	static Connection aConnection;
	static Statement aStatement;

	// declare variables for Dock attribute values
	static int dockId;
	static String location;
	static boolean electricity;
	static boolean water;
	// Yes/No variables needed to convert boolean to text for dbms
	static int electricityYN;
	static int waterYN;

	// establish the database connection
	public static void initialize(Connection c)
	{
		try
 		{
	    	aConnection = c;
	    	// create statement object instance for this connection
	    	aStatement = aConnection.createStatement();
		}
		catch (SQLException e)
			{ System.out.println(e);	}
	}

	// close the database connection
	public static void terminate()
	{
		try
 		{
			aStatement.close();
		}
		catch (SQLException e)
			{ System.out.println(e);	}
	}

	public static Dock find(int key) throws NotFoundException
	{
		aDock = null;
		// define the SQL query statement using the phone number key
		String sqlQuery = "SELECT DockId, Location, Electricity, Water " +
								 			" FROM DockTable " +
											" WHERE DockId = " + key;

	 	// execute the SQL query statement
	 	try
 		{
			// get the dock
	    	ResultSet rs = aStatement.executeQuery(sqlQuery);
	    	boolean gotIt = rs.next();
	    	if (gotIt)
	    	{
				// extract the Dock data
						dockId = rs.getInt(1);
						location = rs.getString(2);
						electricityYN = rs.getInt(3);
						waterYN = rs.getInt(4);
						// convert ints to booleans
						electricity = integerToBoolean(electricityYN);
						water = integerToBoolean(waterYN);
						// create Dock instance
						aDock = new Dock(dockId, location, electricity, water);
				}
				else	// nothing was retrieved
								{throw (new NotFoundException("not found "));}
		rs.close();
		}

		catch (SQLException e)
			{ System.out.println(e);}
		return aDock;
	}

	private static boolean integerToBoolean(int i)
	{
		boolean b = false;
		if(i == 1)
			b = true;
		return b;
	}
}
