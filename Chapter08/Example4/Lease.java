// Lease -- an abstact initial Lease class to extend
// No abstract method to override  

import java.util.*; // for Date and Calendar classes
public abstract class Lease
{
	// attributes
	private double amount;
	private Date startDate;
	private Date endDate;
	
	// constructor 
	public Lease(Date aStartDate)
				
	{
		setStartDate(aStartDate);
		setEndDate(null);
		setAmount(0);
	}

	// set accessor methods
	public void setAmount(double anAmount)
	{ amount = anAmount; }
	public void setStartDate(Date aStartDate)
	{ startDate = aStartDate; }
	public void setEndDate(Date anEndDate)
	{ endDate = anEndDate; }
		
	// get accessor methods
	public double getAmount()
	{ return amount; }
	public Date getStartDate()
	{ return startDate; }
	public Date getEndDate()
	{ return endDate; }
}

