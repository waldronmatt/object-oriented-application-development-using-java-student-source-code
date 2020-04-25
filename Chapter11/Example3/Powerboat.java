// Chapter 7 Powerboat 

public class Powerboat extends Boat
{
	// attributes 
	private int noEngines;
	private String fuelType;
        
	// constructor
	public Powerboat(String aStateRegistrationNo, double aLength, String aManufacturer, int aYear, 
		    		int aNoEngines, String aFuelType)
	{
		// invoke super class constructor
		super(aStateRegistrationNo, aLength, aManufacturer, aYear);
		// set subclass attribute values
		setNoEngines(aNoEngines);
		setFuelType(aFuelType);
	}

	// set accessor methods
	public void setNoEngines(int aNoEngines)
		{ noEngines = aNoEngines; }
	public void setFuelType(String aFuelType)
		{ fuelType = aFuelType; }
	        
	// get accessor methods
	public int getNoEngines()
		{ return noEngines; }
	public String getFuelType()
		{ return fuelType; }

	// tellAboutSelf returns attributes in a String instance
	public String tellAboutSelf()
		{
			String boatInfo, powerboatInfo;
			boatInfo = "Powerboat: " + super.tellAboutSelf() + ", ";
			powerboatInfo = Integer.toString(getNoEngines()) + " engines, "  
						+ getFuelType();
			return boatInfo + powerboatInfo;
		}
} 