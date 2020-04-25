// Chapter 6 Example 6
// illustrate exceptions and data validation

public class Slip
{
	// attributes
	private int slipId;
	private int width;
	private double slipLength;

	// static attribute variable
	private static int numberOfSlips = 0;

	// static constants for default attribute values
	private static final int DEFAULT_WIDTH = 12;
	private static final int DEFAULT_SLIP_LENGTH = 25;

	// static constants for data validation
	private static final int MAXIMUM_NUMBER_OF_SLIPS = 50;
	private static final int VALID_SLIP_WIDTHS[] = {10,12,14,16};
	
	// constructor with 3 parameters
	public Slip(int anId, int aWidth, double aSlipLength)throws Exception

  	{
		// invoke setters to populate attributes
		setSlipId(anId);
		setWidth(aWidth);
		setSlipLength(aSlipLength);
		numberOfSlips++;
  	} 

	// constructor with 1 parameter
	public Slip(int anId)throws Exception
  	{  // invoke 3-parameter constructor with default width & slip values
		this(anId,DEFAULT_WIDTH,DEFAULT_SLIP_LENGTH);
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
 
	// override leaseSlip
	public double leaseSlip(double aDiscountPercent)
	{
		double fee = this.leaseSlip();
		double discountedFee = fee * (100 - aDiscountPercent)/100;
		return discountedFee ;
	}

	// setter methods
 	public void setSlipId(int anId) throws Exception
	{  // reject slip Id if < 0 or > maximum
		if (anId < 1 || anId > MAXIMUM_NUMBER_OF_SLIPS)
			{ 
				Exception e = new Exception("Slip ID not between 1 & " + MAXIMUM_NUMBER_OF_SLIPS); 
				throw e;		
			}
		else
			slipId = anId;
	} 

	public void setWidth(int aWidth)throws Exception
	{ 
		boolean validWidth = false;
		for(int i = 0; i < VALID_SLIP_WIDTHS.length && !validWidth;i++)
		{ 
			if(aWidth == VALID_SLIP_WIDTHS[i])
				validWidth = true;
		}	
		if(validWidth) 
			width = aWidth;
		else
			{
				Exception e = new Exception("Invalid Slip Width"); 
				throw e;		
			}
		}

	public void setSlipLength(double aSlipLength)
		{ slipLength = aSlipLength;}

	// getter methods
	public int getSlipId()
		{ return slipId;}
	public int getWidth()
		{ return width;}
	public double getSlipLength()
		{ return slipLength;}

	// static method
	public static int getNumberOfSlips()
		{ return numberOfSlips;}

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

