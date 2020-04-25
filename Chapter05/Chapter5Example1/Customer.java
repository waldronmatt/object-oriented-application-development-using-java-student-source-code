// Customer Chapter 5 
// illustrate a class definition with accessor methods

public class Customer
{
	// attribute definitions
	private String name;
	private String address;
	private String phoneNo;
		
	// getters
	public String getName()
		{ return name;}
	public String getAddress()
		{ return address;}
	public String getPhoneNo()
		{ return phoneNo;}

	// setters
	public void setName(String newName)
		{ name = newName;}
	public void setAddress(String newAddress)
		{ address = newAddress;}
	public void setPhoneNo(String newPhoneNo)
		{ phoneNo = newPhoneNo;}
} 

