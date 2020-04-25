// Chapter 6
// illustrate a PD class with a parameterized constructor & tellAboutSelf

public class Slip
{
	// attributes
	private int slipId;
	private int width;
	private double slipLength;

	// constructor with 3 parameters
	public Slip(int anId, int aWidth, double aSlipLength)
  	{
		// invoke setters to populate attributes
		setSlipId(anId);
		setWidth(aWidth);
		setSlipLength(aSlipLength);
  	} 

	// setter methods
 	public void setSlipId(int anId)
 		{ slipId = anId;}
	public void setWidth(int aWidth)
		{ width = aWidth;}
	public void setSlipLength(double aSlipLength)
		{ slipLength = aSlipLength;}

	// getter methods
	public int getSlipId()
		{ return slipId;}
	public int getWidth()
		{ return width;}
	public double getSlipLength()
		{ return slipLength;}

	// custom method tellAboutSelf
	public String tellAboutSelf()
	{
		String info;
		
		info = "Slip: Id = "
				+ getSlipId() + ", Width = "
				+ getWidth() + ", Length = "
				+ getSlipLength();			
		return info;
	} 
} 

