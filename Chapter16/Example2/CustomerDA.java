// CustomerDA for Chapter 16 Example 1 and 2  
// Same as Chapter 14 Example 4

import java.util.Vector;	// for Vector of customers
import java.io.*;				// needed for file i/o
import java.sql.*;			// for SQL

public class CustomerDA
{
	static Customer aCustomer;
	
	// The Data Source name is "Chapter16CustomerDatabase" 
	static String url = "jdbc:odbc:Chapter16CustomerDatabase"; 
	static Connection aConnection;
	static Statement aStatement; 

	// declare variables for Customer attribute values
	static String name; 
	static String address; 
	static String phoneNumber; 						

	// Implement the four static methods in Customer ************
	// initialize, find, getAll, and terminate
	
	// establish the database connection
	public static void initialize()
	{
		try
 		{   
			// load the jdbc - odbc bridge driver for Windows
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
	
	// find an instance in the database
	public static Customer find(String key) throws NotFoundException
	{    
		aCustomer = null;	
	
		// define the SQL query statement using the phone number key 
		String sqlQuery = "SELECT Name, Address, PhoneNo " +
								"FROM CustomerTable " +
								"WHERE PhoneNo = '" + key +"'";	

		// execute the SQL query statement	 
		try
 		{   
			ResultSet rs = aStatement.executeQuery(sqlQuery);

			// next method sets cursor & returns true if there is data
			boolean gotIt = rs.next();
			if (gotIt) 
				{
					// extract the data 
					String name = rs.getString(1); 
					String address = rs.getString(2); 
					String phoneNumber = rs.getString(3); 
				
					// create Customer instance
					aCustomer = new Customer(name, address, phoneNumber);	
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

		return aCustomer;
	}
	
	// get all instances from the database
	public static Vector getAll()
	{
		Vector customers = new Vector();	
		// define the SQL query statement for get all
		String sqlQuery = "SELECT Name, Address, PhoneNo " + 
								"FROM CustomerTable ";	
		try
		{
			// execute the SQL query statement	 
			ResultSet rs = aStatement.executeQuery(sqlQuery);
			boolean moreData = rs.next();
		if (moreData)
			// next method sets cursor & returns true if there is data
			while (moreData) 
			{
				// extract the data 
				name = rs.getString(1); 
				address = rs.getString(2); 
				phoneNumber = rs.getString(3); 
				// create Customer instance
				aCustomer = new Customer(name, address, phoneNumber);
				customers.addElement(aCustomer);
				moreData = rs.next();
			}
			rs.close();		
		} 

		catch (SQLException e)
			{ System.out.println(e);}

		return customers;
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
	
	// Implement the three instance methods in Customer *************
	// addNew, delete, update

	// add new instance to database
	public static void addNew(Customer aCustomer) 
				throws DuplicateException
	{
		// retrieve the customer attribute values
		name = aCustomer.getName(); 
		address = aCustomer.getAddress(); 
		phoneNumber = aCustomer.getPhoneNo(); 						
		
		// create the SQL insert statement using attribute values
		String sqlInsert = "INSERT INTO CustomerTable " +
								"(Name, Address, PhoneNo)" + 
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
 			{   	    
			 	// execute the SQL update statement, a 1 return good
				int result = aStatement.executeUpdate(sqlInsert);
			} 

			catch (SQLException ee)
				{ System.out.println(ee);	} 
		}
	}
	
	// delete an instance from the database
	public static void delete(Customer aCustomer) 
				throws NotFoundException
	{	
		// retrieve the phone no (key)
		phoneNumber = aCustomer.getPhoneNo(); 
		
		// create the SQL delete statement 
		String sqlDelete = "DELETE FROM CustomerTable " +
								"WHERE PhoneNo = '" + phoneNumber +"'";

		// see if this customer already exists in the database
		// NotFoundException is thrown by find method
		try
		{
			Customer c = Customer.find(phoneNumber);

			// if found, execute the SQL update statement, a 1 return
			// is good delete
			int result = aStatement.executeUpdate(sqlDelete);
		}

		catch (SQLException e)
			{ System.out.println(e);	} 
	}

	// update instance in the database
	public static void update(Customer aCustomer) throws 
				NotFoundException
	{
		// retrieve the customer attribute values
		phoneNumber = aCustomer.getPhoneNo(); 	
		name = aCustomer.getName();
		address = aCustomer.getAddress();

		// define the SQL query statement using the phone number key 
		String sqlUpdate = "UPDATE CustomerTable " +
								 " SET Name      = '" + name +"', " +
								 " Address   = '" + address +"' " +
								 " WHERE PhoneNo = '" + phoneNumber +"'";	

		// see if this customer already exists in the database
		// NotFoundException is thrown by find method
		try
		{
			Customer c = Customer.find(phoneNumber);

			// if found, execute the SQL update statement, a 1 return 
			// is good delete
				int result = aStatement.executeUpdate(sqlUpdate);
		}

		catch (SQLException ee)
			{ System.out.println(ee);	} 
	}
} 

