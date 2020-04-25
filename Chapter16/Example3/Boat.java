// Boat class for Chapter 16 Example 3 
// from Chapter 15 

import java.util.Vector;
public class Boat
{
	// attributes
	private String stateRegistrationNo; 
	private double length;
	private String manufacturer;
	private int year;

	// reference variables point to Customer for this boat
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
		setCustomer(aCustomer);	// point this Boat to the Customer
		customer.setBoat(this); // point the Customer to this Boat
	}
	
	// DA static methods *********************************
	public static void initialize()
		{BoatDA.initialize();}
	public static Boat find(String key) throws NotFoundException
		{return BoatDA.find(key);}	
	public static Vector getAll()
		{return BoatDA.getAll();}
	public static void terminate()
		{BoatDA.terminate();}
	
	// DA instance methods *********************************
	public void addNew() throws DuplicateException
		{BoatDA.addNew(this);}
	public void delete() throws NotFoundException
		{BoatDA.delete(this);}
	public void update() throws NotFoundException
		{BoatDA.update(this);}
	
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
		return "Boat is " + getManufacturer() + " length "
				+ getLength() + " year " 
				+ getYear() + " reg number "
				+ getStateRegistrationNo();
	}
} 
