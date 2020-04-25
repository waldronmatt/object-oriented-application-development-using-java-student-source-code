// BoatDA
// illustrate database association - Customer owns Boat

import java.util.Vector;
import java.sql.*;

public class BoatDA
{
	static Vector boats = new Vector();
	static Boat aBoat;

	// declare variables for the database connection
	static Connection aConnection;
	static Statement aStatement;

	// declare variables for Boat attribute values
	static String stateRegistrationNo;
	static double length;
  static String manufacturer;
  static int year;
  static String phoneNo;

	// establish the database connection
	public static void initialize(Connection c)
	{
		try {
			aConnection=c;
			aStatement=aConnection.createStatement();
		}
		catch (SQLException e) {
			 System.out.println(e);
		}
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

	public static void addNew(Boat aBoat) throws DuplicateException
	{	// retrieve the boat attribute values
		stateRegistrationNo = aBoat.getStateRegistrationNo();
		length = aBoat.getLength();
		manufacturer = aBoat.getManufacturer();
		year = aBoat.getYear();
		phoneNo = aBoat.getCustomer().getPhoneNo();

		// create the SQL insert statement using attribute values
		String sqlInsert = "INSERT INTO BoatTable (StateRegistrationNo, "
											 + "BoatLength, Manufacturer, Year, "
											 + "CustomerPhoneNo)" + " VALUES ('"
						 					 + stateRegistrationNo + "', '"
		 									 + length + "', '" + manufacturer + "', '"
		 									 + year + "', '" + phoneNo + "')";
		//System.out.println(sqlInsert); //display the SQL statement

		// see if this boat already exists in the database
		try
		{
			Boat b = find(stateRegistrationNo);
			throw (new DuplicateException("Boat Exists "));
		}

		// if NotFoundException, add boat to database
		catch(NotFoundException e)
		{
			try
 			{
	    		// execute the SQL update statement
	    		int result = aStatement.executeUpdate(sqlInsert);
   		}
			catch (SQLException ee)
				{ System.out.println(ee);	}
		}
	}

	public static Boat find(String key) throws NotFoundException
	{
		aBoat = null;

		// define the SQL query statement using the phone number key
		String sqlQuery = "SELECT StateRegistrationNo, BoatLength, " +
								"Manufacturer, Year, CustomerPhoneNo " +
								"FROM BoatTable " +
								"WHERE StateRegistrationNo = '" + key + "'";

	 	// execute the SQL query statement
		try
 		{
	    	ResultSet rs = aStatement.executeQuery(sqlQuery);

			// next method sets cursor & returns true if there is data
			boolean gotIt = rs.next();
	    	if (gotIt)
	    		{
					// extract the data
					stateRegistrationNo = rs.getString(1);
					length = rs.getDouble(2);
					manufacturer = rs.getString(3);
					year = rs.getInt(4);
					phoneNo = rs.getString(5);

					// create Boat instance
					aBoat = new Boat(stateRegistrationNo, length,
											manufacturer, year);
				}
			else
				{
					// nothing was retrieved
					throw (new NotFoundException("not found "));
				}
			rs.close();
   		}
		catch (SQLException e)
			{ System.out.println(e);}
		return aBoat;
	}

	public static Vector getAll()
	{
		Vector boats = new Vector();
		// define the SQL query statement for get all
		String sqlQuery = "SELECT StateRegistrationNo, BoatLength, Manufacturer, "
						+ "Year, CustomerName, Address, PhoneNo " +
						  "FROM BoatTable, CustomerTable " +
						  "WHERE CustomerPhoneNo = PhoneNo";
		try
 		{
		 	// execute the SQL query statement
	    	ResultSet rs = aStatement.executeQuery(sqlQuery);
			boolean moreData = rs.next();
			if (moreData)
				// next method sets cursor & returns true if there is data
	    		while (moreData)
	    		{
					// extract the boat data
					stateRegistrationNo = rs.getString(1);
					length = rs.getDouble(2);
					manufacturer = rs.getString(3);
					year = rs.getInt(4);

					// create Boat instance
					aBoat = new Boat(stateRegistrationNo, length, manufacturer, year);
					boats.addElement(aBoat);
					moreData = rs.next();
				}

			rs.close();
		}
		catch (SQLException e)
			{ System.out.println(e);}
	 	return boats;
	}

	public static void update(Boat aBoat) throws NotFoundException
	{
		// retrieve the Boat attribute values
		stateRegistrationNo = aBoat.getStateRegistrationNo();
		length = aBoat.getLength();
		manufacturer = aBoat.getManufacturer();
		year = aBoat.getYear();

		// define the SQL query statement using the boat reg number key
		String sqlUpdate = "UPDATE BoatTable "       +
						   " SET BoatLength = "      + length   +
						   " , Manufacturer   = '" + manufacturer +"' " +
						   " , Year           = "  + year         +
						   " WHERE StateRegistrationNo = '" + stateRegistrationNo +"'";
		// see if this boat already exists in the database
		// NotFoundException is thrown by find method
		try
		{
			Boat b = Boat.find(stateRegistrationNo);

    		// if found, execute the SQL update statement
    		int result = aStatement.executeUpdate(sqlUpdate);
    	}
		catch (SQLException e)
			{ System.out.println(e);	}
	}

	public static void delete(Boat aBoat) throws NotFoundException
	{
		// retrieve the state registration no (key)
		stateRegistrationNo = aBoat.getStateRegistrationNo();

		// create the SQL delete statement
		String sqlDelete = "DELETE FROM BoatTable " +
						   "WHERE StateRegistrationNo = '" + stateRegistrationNo +"'";

		// see if this boat already exists in the database
		// NotFoundException is thrown by find method
		try
		{
			Boat b = Boat.find(stateRegistrationNo);

    		// if found, execute the SQL update statement
    		int result = aStatement.executeUpdate(sqlDelete);
    	}
		catch (SQLException e)
			{ System.out.println(e);	}
	}
}

