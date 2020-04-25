/* Customer class for Chapter 17
   Contains Boat and AnnualLease reference attributes
   Only those DA methods needed are included
*/

package Bradshaw;

import java.sql.*;

public class Customer
{
	// attribute definitions
 	private String name;
 	private String address;
 	private String phoneNo;
 	// reference variable for Boat instance
	private Boat boat;
	// reference variable for Lease instance
	private AnnualLease lease;

	// DA static methods *********************************
	public static void initialize(Connection c)
		{CustomerDA.initialize(c);}
	public static Customer find(String key) throws NotFoundException
		{ return CustomerDA.find(key);}
	public static void terminate()
		{CustomerDA.terminate();}

	// DA instance methods *********************************
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
		setLease(null);				// initially no lease
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
 	public AnnualLease getLease()
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
	public void setLease(AnnualLease aLease)
		{ lease = aLease;}

	public String tellAboutSelf()
		{
			String customerDetails = "Owner is " + name +
					" living in " + address +
					" with phone " + phoneNo;
			return customerDetails;
		}
}
