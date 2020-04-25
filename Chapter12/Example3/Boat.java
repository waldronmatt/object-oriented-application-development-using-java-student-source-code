// Chapter 12 Boat with Customer reference 
import java.util.Vector;
public abstract class Boat
{
	// attributes
	private String stateRegistrationNo; 
	private double length;
	private String manufacturer;
	private int year;

	// reference variables point to Customer for this boat
	private Customer customer;

	// Vector simulates a database of Boats
	static Vector boats;
	
	public static void initialize(Vector customers)
	{
		boats = new Vector();
		Customer aCustomer;
		Boat aBoat; 
		Sailboat aSailBoat;
		Powerboat aPowerboat;
		// create 3 sailboats & 3 powerboats
		aSailBoat = new Sailboat("MO34561", 28, "Tartan", 1998, 2, 4.11,"Diesel");
		aSailBoat = new Sailboat("MO98765", 28, "J-Boat", 1986, 4, 5.0, "Diesel");
		aSailBoat = new Sailboat("MO12345", 26, "Ranger", 1976, 7, 4.5, "Outboard");
		aPowerboat = new Powerboat("MO445566", 30, "Bayliner", 2001, 2,"Gas");
		aPowerboat = new Powerboat("MO223344", 24, "Tracker", 1996, 1, "Gas");
		aPowerboat = new Powerboat("MO457812", 19, "Ranger", 2001,1, "Gas");
		// assign the boats to the customers		
		for(int i = 0; i < boats.size(); i++)
			{ 	
				aCustomer = (Customer) customers.get(i);	// get next customer
				// note using data type Boat instead of Sailboat/Powerboat
				aBoat = (Boat) boats.get(i); 					// get next boat
				aBoat.assignBoatToCustomer(aCustomer);		// make assignment
			}
	}	
	// simulate DBMS - return Vector of all boat instances
	public static Vector getAll()
	{ return boats;}

	// constructor
	public Boat(String aStateRegistrationNo, double aLength, String aManufacturer, int aYear) 
	{
		setStateRegistrationNo(aStateRegistrationNo);
		setLength(aLength);
		setManufacturer(aManufacturer);
		setYear(aYear);	
		// initially no Customer for this boat - see assignBoatToCustomer
		setCustomer(null);
		boats.add(this); 	// simulate add to DBMS
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
		return (getManufacturer() + ", "
				+ Double.toString(getLength()) + ", " 
				+ Integer.toString(getYear()) + ", "
				+ getStateRegistrationNo());
	}
} 
