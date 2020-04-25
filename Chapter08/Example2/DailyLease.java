// DailyLease -- subclass of Lease overrides abstract 
// method calculateFee

import java.util.*;
public class DailyLease extends Lease 
{
	// attributes in addition to those inherited from Lease 
	private int numberOfDays;
	
	// constructor
	public DailyLease(Date aStartDate, Date anEndDate,	
								int aSlipWidth)
	{
		// invoke superclass constructor
		super(aStartDate);
		// use calendar to get day of year of start date
		Calendar aCalendar = Calendar.getInstance();
		aCalendar.setTime(aStartDate);
		int day1 = aCalendar.get(Calendar.DAY_OF_YEAR);
		// use calendar to get day of year of end date
		aCalendar.setTime(anEndDate);
		int day2 = aCalendar.get(Calendar.DAY_OF_YEAR);
		// set number of days
		setNumberOfDays(day2 - day1);
		// invoke superclass method to set end date
		setEndDate(anEndDate);
		// invoke superclass method to set amount after 
		// getting fee amount from calculateFee method
		setAmount(calculateFee(aSlipWidth));
	}
	// custom method calculateFee
	// overrides abstract method in Lease 
	//(different from method in AnnualLease)
	public double calculateFee(int aWidth)
	{
		double fee;
		switch(aWidth)
		{
			case 10: fee = 20 * getNumberOfDays();
			break;
			case 12: fee = 25 * getNumberOfDays();
			break;
			case 14: fee = 30 * getNumberOfDays();
			break;
			case 16: fee = 35 * getNumberOfDays();
			break;
			default: fee = 0;
		} 
		return fee;
	}
	
	// set accessor method
	public void setNumberOfDays(int aNumberOfDays)
	{	numberOfDays = aNumberOfDays; }
		
	// get accessor method
	public int getNumberOfDays()
	{	return numberOfDays; }
}

