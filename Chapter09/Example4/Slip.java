// Slip with Lease reference 
// plus leaseAnnualSlip method that does
// much processing to create an AnnualLease

import java.util.*;
public class Slip
{
	// attributes
	private int no;
	private int width;
	private double slipLength;
	private Boat boat;
	private Lease lease;

	// constructor with 3 parameters
	public Slip(int aNo, int aWidth, double aSlipLength) 
  	{
		// invoke accessors to populate attributes
		setNo(aNo);	
		setWidth(aWidth);
		setSlipLength(aSlipLength);
		setBoat(null);	// initially no boat is assigned to this slip
		setLease(null);// initially no lease for this slip
  	} 

	// custom method leaseSlip creates AnnualLease instance
	// note: slip takes responsibility for much processing 
	public void leaseAnnualSlip(Customer aCustomer, Date aStartDate,
								boolean isPayMonthly)
	{
		// create AnnualLease instance and assign it to lease 
		// which is an attribute of this slip
		lease = new AnnualLease(aStartDate, width, isPayMonthly);
		// tell lease to set it's slip to this slip
		lease.setSlip(this);
		// tell lease to set its customer
		lease.setCustomer(aCustomer);
		// tell customer to set its lease
		aCustomer.setLease(lease);
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
	public void setLease(Lease aLease)
		{ lease = aLease;}

	// get accessor methods
	public int getNo()
		{ return no;}
	public int getWidth()
		{ return width;}
	public double getSlipLength()
		{ return slipLength;}
	public Boat getBoat()
		{ return boat; }
	public Lease getLease()
		{ return lease; }
} 

