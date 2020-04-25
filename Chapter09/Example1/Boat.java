// Concrete Boat class from Chapter 7 
// with Customer reference attribute and accessors
// plus custom method assignBoatToCustomer

public class Boat
{
	// attributes
	private String stateRegistrationNo; 
	private double length;
	private String manufacturer;
	private int year;
	
	// reference variable points to a Customer instance
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
		setCustomer(aCustomer);	// point Boat to the Customer instance
		customer.setBoat(this); // point Customer to this Boat
	}

	// set accessor methods
	public void setStateRegistrationNo(String aStateRegistrationNo)
		{ stateRegistrationNo = aStateRegistrationNo; }
	public void setLength(double aLength)
		{ length = aLength;}
	public void setManufacturer(String aManufacturer)
		{ manufacturer = aManufacturer; }
	public void setYear(int aYear)
		{	year = aYear;  }
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
} 

