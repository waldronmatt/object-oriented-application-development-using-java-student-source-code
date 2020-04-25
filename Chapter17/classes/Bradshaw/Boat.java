/* Boat for Chapter 17
   with Customer reference - from chapter 9
   DA methods not needed
*/
package Bradshaw;

import java.sql.*;

public class Boat
{
	// attributes
	private String stateRegistrationNo;
	private double length;
	private String manufacturer;
	private int year;

	// reference variable point to Customer for this boat
	private Customer customer;

	// constructor
	public Boat(String aStateRegistrationNo, double aLength,
							String aManufacturer, int aYear)
	{
		setStateRegistrationNo(aStateRegistrationNo);
		setLength(aLength);
		setManufacturer(aManufacturer);
		setYear(aYear);
		// initially no Customer for this boat
		setCustomer(null);
	}

	// custom method to assign a Boat to a Customer
	public void assignBoatToCustomer(Customer aCustomer)
	{
		setCustomer(aCustomer);		// point this Boat to the Customer instance
		customer.setBoat(this);  	// point the Customer to the Boat instance
	}

	// set accessor methods
	public void setStateRegistrationNo(String aStateRegistrationNo)
		{ stateRegistrationNo = aStateRegistrationNo; }
	public void setLength(double aLength)
		{ length = aLength;}
	public void setManufacturer(String aManufacturer)
		{ manufacturer = aManufacturer; }
	public void setYear(int aYear)
		{ year = aYear;  }
	public void setCustomer(Customer aCustomer)
   	{	customer = aCustomer;  }

	// get accessor methods
	public String getStateRegistrationNo()
		{ return stateRegistrationNo; }
	public double getLength()
		{ return length; }
	public String getManufacturer()
		{ return manufacturer; }
	public int getYear()
	{ return year; }
   public Customer getCustomer()
   	{ return customer; }

	// tellAboutSelf returns attributes in a String instance
	public String tellAboutSelf()
		{
			String boatDetails = "Boat is State reg number " + getStateRegistrationNo() +
					" length " + getLength() +
					" Manufacturer " + getManufacturer() +
					" Year " + getYear();
			return boatDetails;
		}
}
