// Chapter 12 Customer with Boat reference 
// In Chapter 12 initialize() added to simulate DBMS 	
import java.util.Vector;
public class Customer
{
	// attribute definitions
 	private String name;
 	private String address;
 	private String phoneNo;
 	// reference variable for Boat instance
	private Boat boat;
		
		// create a Vector instance & populate with 6 new customers
	static Vector customers;
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
		// create 6 boats and assign them to these customers
		Boat.initialize(customers);
	}	
	// simulate a DBMS - return Vector of all customer instances
	public static Vector getAll()
	{ return customers;}

	// constructor with parameters
	public Customer(String aName, String anAddress, String aPhoneNo)
	{
		// invoke accessors to populate attributes
		setName(aName);
		setAddress(anAddress);
		setPhoneNo(aPhoneNo);
		setBoat(null);				// initially no boat 
		customers.add(this);		// simulate add to DBMS
	}
	
	// get accessors
 	public String getName()
 		{ return name;}
	public String getAddress()
 		{ return address;}
	public String getPhoneNo()
 		{ return phoneNo;}
	public Boat getBoat()
 		{ return boat;}


	// set accessors
	public void setName(String newName)
		{ name = newName;}
	public void setAddress(String newAddress)
		{ address = newAddress;}
	public void setPhoneNo(String newPhoneNo)
		{ phoneNo = newPhoneNo;}
	public void setBoat(Boat aBoat)
		{ boat = aBoat;}
} 
