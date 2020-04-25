/* CustomerDA for Chapter 17
   Customer associated with Boat
   Only those DA methods necessary are included
*/

package Bradshaw;

import java.sql.*;

public class CustomerDA
{
	static Customer aCustomer;
	static Boat aBoat;

	// declare variables for the database connection
	static Connection aConnection;
	static Statement aStatement;

	// declare variables for Customer attribute values
	static String name, address, phoneNumber;

	// declare variables for Boat attribute values
	static String stateRegistrationNo, manufacturer;
	static double length;
	static int year;

	// establish the database connection
	public static void initialize(Connection c)
	{
		try {
			aConnection=c;
			aStatement=aConnection.createStatement();
		}
		catch (SQLException e)
			{ System.out.println(e);	}
	}

	// close the database connection
	public static void terminate()
	{
		try
 		{ 	// close the statement
    		aStatement.close();
		}
		catch (SQLException e)
			{ System.out.println(e);	}
	}

	public static Customer find(String key) throws NotFoundException
	{ // retrieve Customer and Boat data
		aCustomer = null;
		// define the SQL query statement using the phone number key
		String sqlQuery = "SELECT CustomerName, Address, PhoneNo, " +
											" StateRegistrationNo, BoatLength, " +
											" Manufacturer, Year" +
											" FROM CustomerTable, BoatTable " +
											" WHERE PhoneNo = CustomerPhoneNo" +
											" AND PhoneNo = '" + key +"'" ;

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
					stateRegistrationNo = rs.getString(4);
 					length = rs.getDouble(5);
					manufacturer = rs.getString(6);
					year = rs.getInt(7);

					// create Customer & Boat instance
					aCustomer = new Customer(name, address, phoneNumber);
					aBoat = new Boat(stateRegistrationNo, length, manufacturer, year);
					aBoat.assignBoatToCustomer(aCustomer);
				}
			else	// nothing was retrieved
				{throw (new NotFoundException("not found "));}
			rs.close();
	   	}
		catch (SQLException e)
		{ System.out.println(e);}
		return aCustomer;
	}

	public static void update(Customer aCustomer) throws NotFoundException
	{	// retrieve the customer attribute values
		phoneNumber = aCustomer.getPhoneNo();
		name = aCustomer.getName();
		address = aCustomer.getAddress();

		// define the SQL query statement using the phone number key
		String sqlUpdate = "Update CustomerTable " +
								 " SET CustomerName      = '" + name +"', " +
								 " address   = '" + address +"' " +
								 " WHERE PhoneNo = '" + phoneNumber + "'";

		// see if this customer exists in the database
		// NotFoundException is thrown by find method
		try
		{
			Customer c = Customer.find(phoneNumber);
    		// if found, execute the SQL update statement
    		int result = aStatement.executeUpdate(sqlUpdate);
   	}
		catch (SQLException e)
			{ System.out.println(e);	}
	}

}

