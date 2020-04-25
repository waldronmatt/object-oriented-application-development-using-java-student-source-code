// DailyLease -- subclass of Lease class implements two interfaces

import java.util.*;
public class DailyLease extends Lease implements 
		LeaseInterface, CompanyInterface
{
	// attributes in addition to those inherited from Lease 
	private int numberOfDays;
	
	// constructor
	public DailyLease(Date aStartDate, Date anEndDate,	int aSlipWidth)
	{
		// invoke superclass constructor
		super(aStartDate);
		// use calendar to compute and set number of days
		Calendar aCalendar = Calendar.getInstance();
		aCalendar.setTime(aStartDate);
		int day1 = aCalendar.get(Calendar.DAY_OF_YEAR);
		aCalendar.setTime(anEndDate);
		int day2 = aCalendar.get(Calendar.DAY_OF_YEAR);
		setNumberOfDays(day2 - day1);
		// invoke superclass method to set end date
		setEndDate(anEndDate);
		// invoke superclass method after getting fee amount
		setAmount(calculateFee(aSlipWidth));
	}
	// custom method calculateFee
	// required by LeaseInterface
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
	
	// method required by CompanyInterface
	// not complete but tests constants in interface
	public String tellAboutSelf()
	{
		return "This is a daily lease for " + numberOfDays +
		" days for company " + COMPANY_NAME +
		" located at " + COMPANY_ADDRESS;
	}
	
	// set accessor method
	public void setNumberOfDays(int aNumberOfDays)
	{	numberOfDays = aNumberOfDays; }
		
	// get accessor method
	public int getNumberOfDays()
	{	return numberOfDays; }
	

	
}

