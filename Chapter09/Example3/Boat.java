// Boat class (not abstract) with Customer reference variable 
// and Customer parameter in constructor, tellAboutSelf method, 
// Slip reference variable, and assignBoatToSlip method

public class Boat
{
	// attributes
	private String stateRegistrationNo; 
	private double length;
	private String manufacturer;
	private int year;

	// reference variable points to a Customer instance
	private Customer customer;
	// reference variable points to a Slip instance
	private Slip slip;

	// constructor (adding Customer reference)
	public Boat(String aStateRegistrationNo, double aLength,
					String aManufacturer, int aYear, Customer aCustomer)
	{
		setStateRegistrationNo(aStateRegistrationNo);
		setLength(aLength);
		setManufacturer(aManufacturer);
		setYear(aYear);
		// association between boat and customer done here
		assignBoatToCustomer(aCustomer);
		setSlip(null); // boat not in slip yet
	} 
	// custom method to assign a Boat to a Customer
	public void assignBoatToCustomer(Customer aCustomer)
	{ 
		setCustomer(aCustomer);	
		customer.setBoat(this); 
	}
	//	custom method to assign a Boat to Slip
	public void assignBoatToSlip(Slip aSlip)
	{
		setSlip(aSlip);
		slip.setBoat(this);
	}	
	// tellAboutSelf method returning Boat and Customer information
	public String tellAboutSelf()
	{
		String boatDetails = "I am a Boat" +
			" state reg number " + getStateRegistrationNo() +
			" length " + getLength() +
			" Manufacturer " + getManufacturer() +
			" Year " + getYear(); 
		String customerDetails = "\n and Owner is " +
			  customer.getName() +
			" living in " + customer.getAddress() +
			" with phone " + customer.getPhoneNo();
		return boatDetails + customerDetails;	 
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
		{ customer = aCustomer;  }
	public void setSlip(Slip aSlip)
		{ slip = aSlip; }  

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
	public Slip getSlip()
		{ return slip; }
} 

