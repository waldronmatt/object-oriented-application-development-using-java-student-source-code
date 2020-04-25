// Powerboat -- a subclass of abstract class Boat that
// overrides but also invokes superclass tellAboutSelf method

public class Powerboat extends Boat
{
	// additional attributes beyond those inherited from Boat
	private int noEngines;
	private String fuelType;

	// constructor
	public Powerboat(String aStateRegistrationNo, double aLength,
						String aManufacturer, int aYear, int aNoEngines,
						String aFuelType)
	{
		// invoke super class constructor
		super(aStateRegistrationNo, aLength, aManufacturer, aYear);

		// set subclass attribute values
		setNoEngines(aNoEngines);
		setFuelType(aFuelType);
	}

	// custom method overrides but invokes superclass method
	public String tellAboutSelf()
	{
		// invokes superclass method when overriding then adds to it
		String allDetails; 
		allDetails = "This is a powerboat " 
		+ super.tellAboutSelf() + " "
		+ noEngines + " "
		+ fuelType;
		return allDetails;
	}

	// set accessor methods
	public void setNoEngines(int aNoEngines)
	{	noEngines = aNoEngines; }
	public void setFuelType(String aFuelType)
	{	fuelType = aFuelType; }

	// get accessor methods
	public int getNoEngines()
	{	return noEngines; }
	public String getFuelType()
	{	return fuelType; }
}
