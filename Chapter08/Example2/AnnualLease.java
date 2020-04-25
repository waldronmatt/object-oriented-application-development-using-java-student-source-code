// AnnualLease -- subclass of Lease overrides abstract 
// method calculateFee. 

import java.util.*; 
public class AnnualLease extends Lease
{
	// attribute in addition to those inherited from Lease
	private double balanceDue;
	private boolean payMonthly;
	
	// constructor
	public AnnualLease(Date aStartDate,
				int aSlipWidth, boolean isPayMonthly)
	{
		// invoke superclass constructor
		super(aStartDate);
		// use calendar to add 1 year to start date 
		Calendar aCalendar = Calendar.getInstance();
		aCalendar.setTime(aStartDate);
		aCalendar.add(Calendar.YEAR, 1);
		// invoke superclass method to set end date
		setEndDate(aCalendar.getTime());
		// invoke superclass setAmount method after getting 
		// fee amount from calculateFee method
		setAmount(calculateFee(aSlipWidth));
		// invoke AnnualLease methods
		setPayMonthly(isPayMonthly);
		if (payMonthly)
			setBalanceDue(getAmount() - getAmount()/12);
		else
			setBalanceDue(0);
	}
	// custom method calculateFee
	// overrides abstract method in Lease 
	public double calculateFee(int aWidth)
	{
		double fee;
		switch(aWidth)
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
	public void setPayMonthly(boolean isPayMonthly)
	{	payMonthly = isPayMonthly; }
	public void setBalanceDue(double anAmount)
	{	balanceDue = anAmount; }
		
	// get accessor methods
	public boolean getPayMonthly()
	{	return payMonthly; }
	public double getBalanceDue()
	{	return balanceDue; }
}

