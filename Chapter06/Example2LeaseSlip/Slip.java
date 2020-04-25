// Chapter 6
// illustrate a PD class with a custom method leaseSlip

public class Slip
{
	// attributes
	private int slipId;
	private int width;
	private double slipLength;
	
	// constructor with 3 parameters
	public Slip(int anId, int aWidth, double aSlipLength)
  	{
		// invoke accessors to populate attributes
		setSlipId(anId);
		setWidth(aWidth);
		setSlipLength(aSlipLength);
  	} 

	// custom method to lease a Slip
	public double leaseSlip()
	{
		double fee;
		switch(width)
		{
			case 10: fee = 800;
			break;
			case 12: fee = 900;
			break;
			case 14: fee = 1100;
			break;
			case 16: fee = 1500;
			break;
			default: fee = 0;
		} 
		return fee;
	} 

	// set accessor methods
 	public void setSlipId(int anId) 
		{slipId = anId;}
	public void setWidth(int aWidth)
		{ width = aWidth;}
	public void setSlipLength(double aSlipLength)
		{ slipLength = aSlipLength;}

	// get accessor methods
	public int getSlipId()
		{ return slipId;}
	public int getWidth()
		{ return width;}
	public double getSlipLength()
		{ return slipLength;}

	// tellAboutSelf
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

