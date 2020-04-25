// CustomerDA - demo object persistence with a random access file
// Chapter 14 Example 2

import java.util.Vector;  
import java.io.*;					// needed for file i/o

public class CustomerDA 
{
	static Vector customers; 	// contains customer references
	static File customerFile = new File("A:/Customer.ran");	// file spec

	public static void initialize()
	{
	// create Vector instance to hold customer reference variables
	customers = new Vector();
   if(customerFile.exists()&& customerFile.length() != 0) // if no file, don't try to read
   { 
	   // read all customer in, create instances, populate Vector 
   	try 
  		{
		RandomAccessFile in = new RandomAccessFile(customerFile,"r");
		String name = in.readLine();
		String address = in.readLine();
		String phoneNo = in.readLine();
		while(phoneNo != null)
			{
				customers.addElement(new Customer(name, address, phoneNo));
				name = in.readLine();
				address = in.readLine();
				phoneNo = in.readLine();
			}	
		}

		catch (Exception e)
			{System.out.println (e);}
 	}
 }

	public static void terminate()
	{
	// write customer data to the random file
   try 
   {
		RandomAccessFile out = new RandomAccessFile(customerFile, "rw");

		for(int i = 0; i < customers.size(); i++)
		{
			if(customers.elementAt(i) != null)	
			{	
				// retrieve the customer reference, get attribute values, and write to file
				// '\r' is carriage return character used by readLine method as delimiter
				Customer aCustomer = (Customer) customers.elementAt(i);	 
				out.writeBytes(aCustomer.getName()+'\r');
				out.writeBytes(aCustomer.getAddress()+'\r');
				out.writeBytes(aCustomer.getPhoneNo()+'\r');
	  		}
		}
		out.close();
	}
	catch (Exception e)
		{System.out.println (e);}
	}
	
	public static void addNew(Customer newCustomer) throws DuplicateException
	{
		boolean duplicate = false;
		// see if this customer exists
		for(int i = 0; i < customers.size() && !duplicate; i++)
		{
			Customer existingCustomer = (Customer) customers.elementAt(i);	 
			
			if(existingCustomer.getPhoneNo().equals(newCustomer.getPhoneNo()))
				duplicate = true;
 		}
		
		if(duplicate)
			throw (new DuplicateException("Customer Exists "));
		else
			customers.addElement(newCustomer);	
	}

	public static Customer find(String key) throws NotFoundException
	{
		Customer  aCustomer = null;
		boolean foundIt = false;
		// iterate customers until found or end of Vector
		for(int i = 0; i < customers.size() && !foundIt; i++)
			{
				aCustomer = (Customer) customers.elementAt(i);	 
				if(key.equals(aCustomer.getPhoneNo()))
					foundIt = true;
			}
		if(foundIt)
			return aCustomer;
		else
			throw (new NotFoundException("not found "));		
	}	
	public static Vector getAll()
		{return customers;}

	public static void update(Customer aCustomer) throws NotFoundException

		{}
	public static void delete(Customer aCustomer) throws NotFoundException
	{
		String key = aCustomer.getPhoneNo();
		boolean foundIt = false;
		
		// iterate customers until found or end of Vector
		for(int i = 0; i < customers.size() && !foundIt; i++)
			{
				aCustomer = (Customer) customers.elementAt(i);	 
				if(key.equals(aCustomer.getPhoneNo()))
					{
						foundIt = true;
						customers.removeElementAt(i); // remove this reference
					}
			}
		if(!foundIt)
			throw (new NotFoundException("not found "));		
	}	
} 

