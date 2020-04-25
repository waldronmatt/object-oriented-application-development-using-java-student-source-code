// Chapter 7 Sailboat

public class Sailboat extends Boat
{
	//  attributes 
	private double keelDepth;
	private int noSails;
	private String motorType;
    
	// constructor
	public Sailboat(String aStateRegistrationNo, double aLength, String aManufacturer, int aYear, 
		 				double aKeelDepth, int aNoSails, String aMotorType)
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

	// tellAboutSelf returns attributes in a String instance
	public String tellAboutSelf()
		{
			String boatInfo, sailboatInfo;
			boatInfo = "Sailboat: " + super.tellAboutSelf() + ", ";
			sailboatInfo = " Keel depth "  
						+ Double.toString(getKeelDepth()) + ", " 
						+ Integer.toString(getNoSails()) + " sails, " 
						+ getMotorType();
			return boatInfo + sailboatInfo;
		}

} 
