// Customer Chapter 5
// illustrate class definition with tellAboutSelf method

public class Customer
{
	// attribute definitions
 	private String name;
 	private String address;
 	private String phoneNo;
		
	// constructor with parameters
	public Customer(String aName, String anAddress, String aPhoneNo)
	{
		// invoke setters to populate attributes
		setName(aName);
		setAddress(anAddress);
		setPhoneNo(aPhoneNo);
	}
	
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
	
	public String tellAboutSelf()
		{
			String info;
			info = "Customer name = "
					+ getName() + ", Address = "
					+ getAddress() + ", Phone Number = "
					+ getPhoneNo();
			return info;
		}
} 
