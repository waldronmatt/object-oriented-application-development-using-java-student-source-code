/* Slip for Chapter 17
	 Same as for Chapter 15, Project 3
*/

package Bradshaw;

import java.util.*;
import java.sql.Connection;

public class Slip
{
	// attributes
	private int no;
	private int width;
	private double slipLength;
	private int dockId;  // added dockId
	private AnnualLease lease;

	// constructor with 3 parameters
	public Slip(int aNo, int aWidth, double aSlipLength, int aDockId)
  	{
		// invoke accessors to populate attributes
		setNo(aNo);			// throws NumberFormatException
		setWidth(aWidth);
		setSlipLength(aSlipLength);
		setDockId(aDockId);
		setLease(null);	// initially no lease for this slip
  	}

	// set accessor methods
 	public void setNo(int aNo)
		{ no = aNo; }
	public void setWidth(int aWidth)
		{ width = aWidth; }
	public void setSlipLength(double aSlipLength)
		{ slipLength = aSlipLength;}
 	public void setDockId(int aDockId)
		{ dockId = aDockId; }
	public void setLease(AnnualLease aLease)
		{ lease = aLease;}

	// get accessor methods
	public int getNo()
		{ return no;}
	public int getWidth()
		{ return width;}
	public double getSlipLength()
		{ return slipLength;}
	public int getDockId()
		{ return dockId;}
	public Lease getLease()
		{ return lease; }

	// DA static methods *********************************
	public static void initialize(Connection c)
		{SlipDA.initialize(c);}
	public static Slip find(int aSlipNo, int aDockId) throws NotFoundException
		{return SlipDA.find(aSlipNo, aDockId);}
	public static void terminate()
		{SlipDA.terminate();}

	// custom method leaseSlip creates AnnualLease instance
	public AnnualLease leaseAnnualSlip(Customer aCustomer, Date aStartDate,
									 boolean isPayMonthly)
	{
		// create AnnualLease instance and assign it to lease attribute
		// width is an attribute of this slip
		lease = new AnnualLease(aStartDate, width, isPayMonthly);
		// tell lease to set its slip to this slip
		lease.setSlip(this);
		// tell lease to set its customer
		lease.setCustomer(aCustomer);
		// tell customer to set its lease
		aCustomer.setLease(lease);
		return (lease);
	}

	public String tellAboutSelf()
	{
		return ("Slip " + getNo() +
					" Width is " + getWidth() + "," +
					" Length is " + getSlipLength());
	}
}


