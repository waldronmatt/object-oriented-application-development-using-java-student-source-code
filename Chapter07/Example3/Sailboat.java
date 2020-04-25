// Sailboat -- a subclass of abstract class Boat that
// overrides tellAboutSelf method in superclass

public class Sailboat extends Boat
{
	// additional attributes beyond those inherited from Boat
	private double keelDepth;
	private int noSails;
	private String motorType;

	// constructor
	public Sailboat(String aStateRegistrationNo, double aLength,
						String aManufacturer, int aYear, double aKeelDepth,
						int aNoSails, String aMotorType)
	{
		// invoke super class constructor
		super(aStateRegistrationNo, aLength, aManufacturer, aYear);

		// set subclass attribute values
		setKeelDepth(aKeelDepth);
		setNoSails(aNoSails);
		setMotorType(aMotorType);
	}

	// custom method overrides superclass method
	public String tellAboutSelf()
	{
		// invokes four superclass get methods 
		String allDetails; 
		allDetails = "This is a sailboat "	 
		+ getStateRegistrationNo() + " "		// invoke Boat method
		+ getLength() + " "						// invoke Boat method
		+ getManufacturer() + " "				// invoke Boat method
		+ getYear() + " "							// invoke Boat method
		+ keelDepth + " "
		+ noSails + " "
		+ motorType;
		return allDetails;
	}
	// set accessor methods
	public void setKeelDepth(double aKeelDepth)
	{	keelDepth = aKeelDepth; }
	public void setNoSails(int aNoSails)
	{	noSails = aNoSails; } 
	public void setMotorType(String aMotorType)
	{	motorType = aMotorType; }

	// get accessor methods
	public double getKeelDepth()
	{	return keelDepth; }
	public int getNoSails()
	{	return noSails; }
	public String getMotorType()
	{	return motorType; }
}
