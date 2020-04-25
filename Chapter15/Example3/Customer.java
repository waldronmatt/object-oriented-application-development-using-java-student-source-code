// Customer with lease attribute added

import java.sql.Connection;

public class Customer
{
	// attribute definitions
 	private String name;
 	private String address;
 	private String phoneNo;

	// reference variable for Lease instance
	private AnnualLease lease;

	// constructor with parameters
	public Customer(String aName, String anAddress, String aPhoneNo)
	{
		// invoke accessors to populate attributes
		setName(aName);
		setAddress(anAddress);
		setPhoneNo(aPhoneNo);
		setLease(null);	// initially no lease
	}

	// DA static methods *********************************
	public static void initialize(Connection c)
		{CustomerDA.initialize(c);}
	public static Customer find(String key) throws NotFoundException
		{return CustomerDA.find(key);}
	public static void terminate()
		{CustomerDA.terminate();}

	// get accessors
 	public String getName()
 		{ return name;}
	public String getAddress()
 		{ return address;}
	public String getPhoneNo()
 		{ return phoneNo;}
	public AnnualLease getLease()
 		{ return lease;}

	// set accessors
	public void setName(String newName)
		{ name = newName;}
	public void setAddress(String newAddress)
		{ address = newAddress;}
	public void setPhoneNo(String newPhoneNo)
		{ phoneNo = newPhoneNo;}
	public void setLease(AnnualLease aLease)
		{ lease = aLease;}

	// tellAboutSelf
	public String tellAboutSelf()
	{
		String customerDetails = "Owner is " + name +
					" living in " + address +
					" with phone " + phoneNo;
		return customerDetails;
	}
}
