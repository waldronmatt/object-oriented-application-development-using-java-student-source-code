// Chapter 15 CustomerDA - from project 1
// implements find for Customer leases a Slip

import java.util.Vector;
import java.sql.*;

public class CustomerDA
{
	static Customer aCustomer;

	// declare variables for Customer attribute values
	static String name, address, phoneNumber;

	// declare variables for the database connection
	static Connection aConnection;
	static Statement aStatement;

	// establish the database connection
	public static void initialize(Connection c)
	{
		try
		{
			aConnection = c;
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

	public static Customer find(String key) throws NotFoundException
	{ // retrieve Customer and Boat data
		aCustomer = null;
		// define the SQL query statement using the phone number key
		String sqlQuery = "SELECT CustomerName, Address, PhoneNo " +
								" FROM CustomerTable " +
								" WHERE PhoneNo = '" + key +"'" ;
	 	// execute the SQL query statement
		try
 		{
	    	ResultSet rs = aStatement.executeQuery(sqlQuery);
			// next method sets cursor & returns true if there is data
			boolean gotIt = rs.next();
	    	if (gotIt)
	    		{	// extract the data
					name = rs.getString(1);
					address = rs.getString(2);
					phoneNumber = rs.getString(3);
 					// create Customer instance
					aCustomer = new Customer(name, address, phoneNumber);
				}
			else	// nothing was retrieved
				{throw (new NotFoundException("not found "));}
			rs.close();
   	}
		catch (SQLException e)
			{ System.out.println(e);}
		return aCustomer;
	}
}

