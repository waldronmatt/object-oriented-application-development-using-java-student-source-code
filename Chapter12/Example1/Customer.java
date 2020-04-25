// CHapter 12 - Customer simulates Customer dbms using a Vector

import java.util.Vector;
public class Customer
{
	// attribute definitions
 	private String name;
 	private String address;
 	private String phoneNo;
	static Vector customers; 

	// create a Vector instance & populate with 6 new customers
	public static void initialize()
	{
		customers = new Vector();
		Customer aCustomer; 
		aCustomer = new Customer("Eleanor", "Atlanta", "123-4567"); 
		aCustomer = new Customer("Mike", "Boston", "467-1234");    
		aCustomer = new Customer("Joann", "St. Louis", "765-4321"); 
		aCustomer = new Customer("Dave", "Atlanta", "321-4567"); 
		aCustomer = new Customer("Brian", "Los Angeles", "467-1234");    
		aCustomer = new Customer("Dan", "Reston", "587-4321"); 
	}	

	// return vector of customers
	public static Vector getAll()
	{ return customers;}

	// constructor with parameters
	public Customer(String aName, String anAddress, String aPhoneNo)
	{
		// invoke set accessors to populate attributes
		setName(aName);
		setAddress(anAddress);
		setPhoneNo(aPhoneNo);
		customers.add(this);		// simulate add to dbms
	}
	
	// get accessors
 	public String getName()
 		{ return name;}
	public String getAddress()
 		{ return address;}
	public String getPhoneNo()
 		{ return phoneNo;}

	// set accessors
	public void setName(String newName)
		{ name = newName;}
	public void setAddress(String newAddress)
		{ address = newAddress;}
	public void setPhoneNo(String newPhoneNo)
		{ phoneNo = newPhoneNo;}
} 
