// Chapter 12 Sailboat subclass of Boat

public class Sailboat extends Boat
{
	//  attributes 
	private double keelDepth;
	private int noSails;
	private String motorType;
    
	// constructor
	public Sailboat(String aStateRegistrationNo, double aLength, String aManufacturer, int aYear,
		 				int aNoSails, double aKeelDepth,String aMotorType)
  	{
		// invoke super class constructor
		super(aStateRegistrationNo, aLength, aManufacturer, aYear);
		// set subclass attribute values
		setNoSails(aNoSails);
		setKeelDepth(aKeelDepth);
		setMotorType(aMotorType);
	}

	// set accessor methods
	public void setKeelDepth(double aKeelDepth)
	{ 	keelDepth = aKeelDepth; }   
	public void setNoSails(int aNoSails)
	{ noSails = aNoSails; }   
	public void setMotorType(String aMotorType)
	{ motorType = aMotorType; }
        
	// get accessor methods
	public double getKeelDepth()
		{ return keelDepth; }
	public int getNoSails()
		{ return noSails; }
	public String getMotorType()
		{ return motorType; }
} 
