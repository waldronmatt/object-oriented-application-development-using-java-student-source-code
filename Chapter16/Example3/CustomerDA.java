// CustomerDA for Chapter 16 Example 3 - Customer associated with Boat
// from Chapter 15

import java.util.Vector;
import java.io.*;					
import java.sql.*;

public class CustomerDA
{
	// Vector of customers, Customer reference and Boat reference
	static Vector customers = new Vector();	
	static Customer aCustomer;
	static Boat aBoat;
	
	// declare variables for Customer attribute values
	static String name, address, phoneNumber; 

	// declare variables for Boat attribute values
	static String stateRegistrationNo, manufacturer; 
	static double length;
	static int year;
		
	// The Data Source name is "Chapter16CustomerAndBoatDatabase" 
	static String url = "jdbc:odbc:Chapter16CustomerAndBoatDatabase";  	
	static Connection aConnection;
	static Statement aStatement; 				

	// establish the database connection
	public static void initialize()
	{
		try
 		{ 	// load the jdbc - odbc bridge driver for Windows
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	    	// create connection instance   
	    	aConnection = DriverManager.getConnection(url, "", "");
	    	// create statement object instance for this connection
	    	aStatement = aConnection.createStatement();
		}
		catch (ClassNotFoundException e)
			{System.out.println(e);}
		catch (SQLException e)
			{ System.out.println(e);	} 
	}

	// close the database connection
	public static void terminate()
	{
		try
 		{ 	// close everything
    		aStatement.close();
    		aConnection.close();
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
								" Manufacturer, Year " +
								" FROM CustomerTable, BoatTable " +
								" WHERE PhoneNo = '" + key +"'" +
								" AND CustomerPhoneNo = '" + key +"'" ;	
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
	
	public static Vector getAll()
	{	// retrieve Customers and their boats
		// define the SQL query statement for get all
		String sqlQuery = "SELECT CustomerName, Address, PhoneNo, " +
								" StateRegistrationNo, BoatLength, " +
								" Manufacturer, Year " +
								" FROM CustomerTable, BoatTable " +
								" WHERE PhoneNo = CustomerPhoneNo";
		try
 		{  // execute the SQL query statement	 
	    	ResultSet rs = aStatement.executeQuery(sqlQuery);
			boolean moreData = rs.next();
			if (moreData)
				// next method sets cursor & returns true if there is data
	    		while (moreData) 
	    		{	// extract the data 
					name = rs.getString(1); 
					address = rs.getString(2); 
					phoneNumber = rs.getString(3);
					stateRegistrationNo = rs.getString(4);
 					length = rs.getDouble(5);
					manufacturer = rs.getString(6);
					year = rs.getInt(7);
					// create Customer instance
					aCustomer = new Customer(name, address, phoneNumber);
					// create Boat instance
					aBoat = new Boat(stateRegistrationNo, length, 
												manufacturer, year);	
					// assign boat to customer
					aBoat.assignBoatToCustomer(aCustomer);
					// add customer reference to customers Vector
					customers.addElement(aCustomer);
					// set cursor to next record
					moreData = rs.next();
			}
			rs.close();		
		} 
		catch (SQLException e)
			{ System.out.println(e);}
	 	return customers;
	}
	public static void addNew(Customer aCustomer) throws DuplicateException
	{	// retrieve the customer attribute values
		name = aCustomer.getName(); 
		address = aCustomer.getAddress(); 
		phoneNumber = aCustomer.getPhoneNo(); 
		aBoat = aCustomer.getBoat();
		// create the SQL insert statement using attribute values
		String sqlInsert = "INSERT INTO CustomerTable " + 
									"(CustomerName, Address, PhoneNo) " +
								 "	VALUES ('" + 
								 name         + "', '" +
								 address      + "', '" +
								 phoneNumber  + "')";	

		// see if this customer already exists in the database
		try
		{
			Customer c = find(phoneNumber);
			throw (new DuplicateException("Customer Exists "));
		}

		// if NotFoundException, add customer to database
		catch(NotFoundException e)
		{
			try
 			{  // execute the SQL update statement, a 1 return is good update
	    		int result = aStatement.executeUpdate(sqlInsert);
			   try // add the boat
			   	{aBoat.addNew();}
				catch(DuplicateException de)
					{ System.out.println(de);	} 	 
			} 	
			catch (SQLException ee)
				{ System.out.println(ee);	} 
		}
	}
	
	public static void delete(Customer aCustomer) throws NotFoundException
	{	// retrieve the phone no (key)
		phoneNumber = aCustomer.getPhoneNo(); 							
		// create the SQL delete statement 
		String sqlDelete = "DELETE FROM CustomerTable " +
								"WHERE PhoneNo = '" + phoneNumber +"'";	
		// see if this customer already exists in the database
		// NotFoundException is thrown by find method
		try
		{
			Customer c = Customer.find(phoneNumber);
    		// if found, execute the SQL update statement, a 1 return is good delete
    		int result = aStatement.executeUpdate(sqlDelete);
			try // delete the customer's boat
				{aBoat.delete();}
			catch(NotFoundException nfe)
    			{ }// do nothing
	    }

		catch (SQLException e)
			{ System.out.println(e);	} 
	}
	
	public static void update(Customer aCustomer) throws NotFoundException
	{	// retrieve the customer attribute values
		phoneNumber = aCustomer.getPhoneNo(); 						
		name = aCustomer.getName();
		address = aCustomer.getAddress();
		aBoat = aCustomer.getBoat();
		// define the SQL query statement using the phone number key 
		String sqlUpdate = "Update CustomerTable " +
								 " SET CustomerName      = '" + name +"', " +
								 " Address   = '" + address +"' " +
								 " WHERE PhoneNo = '" + phoneNumber +"'";
		// see if this customer exists in the database
		// NotFoundException is thrown by find method
		try
		{
			Customer c = Customer.find(phoneNumber);
    		// if found, execute the SQL update statement, a 1 return is good delete
    		int result = aStatement.executeUpdate(sqlUpdate);
			try // update the boat info
				{aBoat.update();}
			catch (NotFoundException nfe)
				{ throw(nfe);	} 
    	}
		catch (SQLException e)
			{ System.out.println(e);	} 
	}
	
} 

