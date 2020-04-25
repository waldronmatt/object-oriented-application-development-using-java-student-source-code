// CustomerDA - data access class using object serialization
// Chapter 14 - example 3

import java.util.Vector;
import java.io.*;					// needed for file i/o

public class CustomerDA 
{
	static Vector customers; 		// contains customer references
	static File customerFile = new File("A:/Customer.obj");	// file spec

	public static void initialize()
	{
		// create Vector instance to hold customer reference variables
		customers = new Vector();

		boolean eof = false;		// end of file   
	   if(customerFile.exists()&& customerFile.length() != 0) // if no file, don't try to read
   	{ 
	   	try 
   		{
				ObjectInputStream in = new ObjectInputStream(new FileInputStream (customerFile));	
				// read all customer objects in & populate Vector 
				while(!eof) // loop until end of file
				{
					try
						{ customers.addElement(in.readObject()); }
					catch(EOFException e)
						{eof = true;}
				}	
			}	
			catch (Exception e)
				{System.out.println (e);}
		}	
 	}

	public static void terminate()
	{
		// write customer data 
   	try 
   	{
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream (customerFile));
			for(int i = 0; i < customers.size(); i++)
			{
				if(customers.elementAt(i) != null)	
					out.writeObject(customers.elementAt(i)); // retrieve customer and write to file
			}
			out.close();
		}
		catch (Exception e)
			{System.out.println (e + "I/O error during write to CustomerFile");}
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
		{return (customers);}

	public static void update(Customer aCustomer) throws NotFoundException
		{}

	public static void delete(Customer  aCustomer) throws NotFoundException
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

