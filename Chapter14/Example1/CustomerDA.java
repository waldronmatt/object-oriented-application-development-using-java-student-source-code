// CustomerDA - Chapter 14 Example 1
// data access class using a sequential file

import java.util.Vector;  	 
import java.io.*;				// needed for file i/o

public class CustomerDA 
{
	static Vector customers; 	// contains customer references
	static File customerFile = new File("A:/Customer.dat");	// file spec

	public static void initialize()
	{
	// create Vector instance to hold customer reference variables
	customers = new Vector();
   if(customerFile.exists() && customerFile.length() != 0) // if no file, don't try to read
   { // read all customer in, create instances, populate Vector 
   	try 
   	{
	   	BufferedReader in = new BufferedReader(new FileReader(customerFile));
			String name, address, phoneNo;
			do
			{
				name = in.readLine();
				address = in.readLine();
				phoneNo = in.readLine();
			
				// create customer instance and add reference to Vector customers
				if(name != null)	
					customers.addElement(new Customer(name, address, phoneNo));
			} while(phoneNo != null);

		}

		catch (Exception e)
			{System.out.println (e);}
 	}
 }

	public static void terminate()
	{
	// write customer data to the sequential file
   try 
   {
		// create PrintStream for output
		PrintStream out = new PrintStream(new FileOutputStream (customerFile));

		for(int i = 0; i < customers.size(); i++)
		{	// retrieve customer reference from customers Vector and store in aCustomer
			Customer aCustomer = (Customer) customers.elementAt(i);	 
			out.println(aCustomer.getName());
			out.println(aCustomer.getAddress());
			out.println(aCustomer.getPhoneNo());
 		}
	}
	catch (Exception e)
		{System.out.println (e);}
	}
	
	public static void addNew(Customer aCustomer) throws DuplicateException
	{
		boolean duplicate = false;

		// see if this customer exists
		for(int i = 0; i < customers.size() && !duplicate; i++)
		{	// retrieve customer reference from customers Vector and store in existingCustomer
			Customer existingCustomer = (Customer) customers.elementAt(i);	 
			
			if(existingCustomer.getPhoneNo().equals(aCustomer.getPhoneNo()))
				duplicate = true;
 		}
		if(duplicate)
			throw (new  DuplicateException(" Customer Already Exists "));
		else
			customers.addElement(aCustomer);	
	}

	public static Customer find(String phoneNo) throws NotFoundException
	{
		Customer  aCustomer = null;
		boolean foundIt = false;

		// iterate customers until found or end of Vector
		for(int i = 0; i < customers.size() && !foundIt; i++)
			{	// retrieve customer reference from customers Vector and store in aCustomer
				aCustomer = (Customer) customers.elementAt(i);	 
				if(phoneNo.equals(aCustomer.getPhoneNo()))
					foundIt = true;
			}
		if(foundIt)
			return aCustomer;
		else
			throw (new  NotFoundException("not found "));		
	}	
	public static Vector getAll()
		{return customers;}

	public static void update(Customer aCustomer) throws NotFoundException		
		{}// update is done to the instance so no code needed here
	
	public static void delete(Customer aCustomer) throws NotFoundException
	{
		String phoneNo = aCustomer.getPhoneNo();
		boolean foundIt = false;
		
		// iterate customers until found or end of Vector
		for(int i = 0; i < customers.size() && !foundIt; i++)
			{	// retrieve customer reference from customers Vector and store in aCustomer
				aCustomer = (Customer) customers.elementAt(i);	 
				if(phoneNo.equals(aCustomer.getPhoneNo()))
					{
						foundIt = true;
						customers.removeElementAt(i); // remove this reference
					}
			}
	
		if(!foundIt)
			throw (new NotFoundException("not found "));		
	}	
} 