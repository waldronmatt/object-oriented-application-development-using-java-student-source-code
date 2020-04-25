// Slip with Boat reference and accessors
// and Dock reference variable and accessors

public class Slip
{
	// attributes
	private int no;
	private int width;
	private double slipLength;
	private Boat boat;
	private Dock dock;
	
	// constructor with 3 parameters plus dock reference
	public Slip(int aNo, int aWidth, double aSlipLength, Dock aDock) 
  	{
		// invoke accessors to populate attributes
		setNo(aNo);		
		setWidth(aWidth);
		setSlipLength(aSlipLength);
		// assign slip to an existing dock
		setDock(aDock);
		// tell dock to associate with this slip
		dock.addSlipToDock(this);
		// initially no boat in slip
		setBoat(null);		
  	} 

	// set accessor methods
 	public void setNo(int aNo) 
		{ no = aNo; }
	public void setWidth(int aWidth) 
		{ width = aWidth; }
	public void setSlipLength(double aSlipLength)
		{ slipLength = aSlipLength;}
	public void setBoat(Boat aBoat)
		{ boat = aBoat;}
	public void setDock(Dock aDock)
		{ dock = aDock; }

	// get accessor methods
	public int getNo()
		{ return no;}
	public int getWidth()
		{ return width;}
	public double getSlipLength()
		{ return slipLength;}
	public Boat getBoat()
		{ return boat; }
	public Dock getDock()
		{ return dock; }
} 

