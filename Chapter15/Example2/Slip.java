//  Chapter 15 Slip with dock attribute

import java.util.Vector;
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
		setNo(aNo);			// throws NumberFormatException
		setWidth(aWidth);
		setSlipLength(aSlipLength);
		// assign slip to an existing dock
		setDock(aDock);
		// tell dock to associate with this slip
		dock.addSlipToDock(this);
		setBoat(null);
  }

	public String tellAboutSelf()
	{
		return ("Slip " + getNo() +
			" Width is " + getWidth() + "," +
			" Length is " + getSlipLength());
	}

	// set accessor methods
 	public void setNo(int aNo) throws NumberFormatException
		{ no = aNo;	}
	public void setWidth(int aWidth) throws NumberFormatException
		{width = aWidth;}
	public void setSlipLength(double aSlipLength)
		{ slipLength = aSlipLength;}
  public void setBoat(Boat aBoat)
  	{ boat = aBoat;}
	public void setDock(Dock aDock)
		{ dock = aDock;}

	// get accessor methods
	public int getNo()
		{ return no;}
	public int getWidth()
		{ return width;}
	public double getSlipLength()
		{ return slipLength;}
	public Boat getBoat()
		{ return boat;}
	public Dock getDock()
		{ return dock; }
}

