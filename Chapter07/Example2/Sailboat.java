// Sailboat -- A subclass of abstract class Boat

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
