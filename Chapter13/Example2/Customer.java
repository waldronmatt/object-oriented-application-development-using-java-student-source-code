// Customer Chapter 5
// illustrate class definition with a parameterized constructor

public class Customer
{
	// attribute definitions
 	private String name;
 	private String address;
 	private String phoneNo;
		
	// constructor with parameters
	public Customer(String aName, String anAddress, String aPhoneNo)
	{
		// invoke set accessors to populate attributes
		setName(aName);
		setAddress(anAddress);
		setPhoneNo(aPhoneNo);
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
