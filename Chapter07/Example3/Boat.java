// Boat -- abstract Boat class with tellAboutSelf method
 
public abstract class Boat
{
	// attributes
	private String stateRegistrationNo;
	private double length;
	private String manufacturer;
	private int year;

	// constructor
	public Boat(String aStateRegistrationNo, double aLength,
					String aManufacturer, int aYear)
	{
		setStateRegistrationNo(aStateRegistrationNo);
		setLength(aLength);
		setManufacturer(aManufacturer);
		setYear(aYear);
	}

	// custom method
	public String tellAboutSelf()
	{
		// returns values of attributes as one string
		String boatDetails; 
		boatDetails = " "
		+ stateRegistrationNo + " "
		+ length + " " 
		+ manufacturer + " "
		+ year; 
		return boatDetails;
	}

	// set accessor methods
	public void setStateRegistrationNo(String aStateRegistrationNo)
		{	stateRegistrationNo = aStateRegistrationNo; }
	public void setLength(double aLength)
		{	length = aLength; }
	public void setManufacturer(String aManufacturer)
		{	manufacturer = aManufacturer; }
	public void setYear(int aYear)
		{	year = aYear; }
	
	// get accessor methods
	public String getStateRegistrationNo()
		{	return stateRegistrationNo; }
	public double getLength()
		{	return length; }
	public String getManufacturer()
		{	return manufacturer; }
	public int getYear()
		{	return year; }
}

