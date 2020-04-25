// Abstact initial Lease class to extend with abstract method
// plus Slip and Customer reference attributes and accessors

import java.util.*; // for Date and Calendar classes
public abstract class Lease
{
	// attributes
	private double amount;
	private Date startDate;
	private Date endDate;
	// references to customer and to slip 
	Customer customer;
	Slip slip;
	
	// constructor 
	public Lease(Date aStartDate)
				
	{
		setStartDate(aStartDate);
		setEndDate(null);
		setAmount(0);
		// no customer or slip yet
		setCustomer(null);
		setSlip(null);
	}
	
	// abstract method subclasses must override
	public abstract double calculateFee(int aLength);
	
	// set accessor methods
	public void setAmount(double anAmount)
		{ amount = anAmount; }
	public void setStartDate(Date aStartDate)
		{ startDate = aStartDate; }
	public void setEndDate(Date anEndDate)
		{ endDate = anEndDate; }
	public void setCustomer(Customer aCustomer)
		{ customer = aCustomer; }
	public void setSlip(Slip aSlip)
		{ slip = aSlip; }
		
	// get accessor methods
	public double getAmount()
		{ return amount; }
	public Date getStartDate()
		{ return startDate; }
	public Date getEndDate()
		{ return endDate; }
	public Customer getCustomer()
		{ return customer; }
	public Slip getSlip()
		{ return slip; }
}

