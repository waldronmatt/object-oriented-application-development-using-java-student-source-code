// Customer class for Chapter 16 Example 3
// from Chapter 15

import java.util.Vector;
public class Customer
{
	// attribute definitions
 	private String name;
 	private String address;
 	private String phoneNo;
 	// reference variable for Boat instance
	private Boat boat;

	// DA static methods *********************************
	public static void initialize()
		{CustomerDA.initialize();}
	public static Customer find(String key) throws NotFoundException
		{return CustomerDA.find(key);}	
	public static Vector getAll()
		{return CustomerDA.getAll();}
	public static void terminate()
		{CustomerDA.terminate();}
	
	// DA instance methods *********************************
	public void addNew() throws DuplicateException
		{CustomerDA.addNew(this);}
	public void delete() throws NotFoundException
		{CustomerDA.delete(this);}
	public void update() throws NotFoundException
		{CustomerDA.update(this);}

	// constructor with parameters
	public Customer(String aName, String anAddress, String aPhoneNo)
	{
		// invoke accessors to populate attributes
		setName(aName);
		setAddress(anAddress);
		setPhoneNo(aPhoneNo);
		setBoat(null);				// initially no boat 
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
	// tellAboutSelf
	public String tellAboutSelf()
	{ return (getName() + ", " + getAddress() + ", " + getPhoneNo());}
} 
