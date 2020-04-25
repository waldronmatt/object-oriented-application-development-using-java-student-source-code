// Customer class 
// with Boat reference attribute and accessors
// and Lease reference attribute and accessors

public class Customer
{
	// attribute definitions
 	private String name;
 	private String address;
 	private String phoneNo;
 	// reference variable for Boat instance
	private Boat boat;
	// reference variable for Lease instance
	private Lease lease;
	
	// constructor with parameters
	public Customer(String aName, String anAddress, String aPhoneNo)
	{
		// invoke accessors to populate attributes
		setName(aName);
		setAddress(anAddress);
		setPhoneNo(aPhoneNo);
		// initially no Boat
		setBoat(null);
		// initially no lease
		setLease(null);			
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
	public Lease getLease()
 		{ return lease;}

	// set accessors
	public void setName(String newName)
		{ name = newName;}
	public void setAddress(String newAddress)
		{ address = newAddress;}
	public void setPhoneNo(String newPhoneNo)
		{ phoneNo = newPhoneNo;}
	public void setBoat(Boat aBoat)
		{ boat = aBoat;}
	public void setLease(Lease aLease)
		{ lease = aLease;}
} 
