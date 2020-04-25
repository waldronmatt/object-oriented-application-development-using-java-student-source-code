// TesterThree to test AnnualLease and DailyLease 
// with LeaseInterface and CompanyInterface 

import java.util.*;
public class TesterThree
{
    public static void main(String args[])
    {
	// create three dates from calendar
	Calendar aCalendar = Calendar.getInstance();	
	aCalendar.set(2003, Calendar.AUGUST, 28);	
	Date date1 = aCalendar.getTime();
	aCalendar.set(2003, Calendar.SEPTEMBER, 3);
	Date date2 = aCalendar.getTime();
	aCalendar.set(2003, Calendar.SEPTEMBER, 7);
	Date date3 = aCalendar.getTime();
	
	// create two AnnualLeases
	AnnualLease firstLease = new AnnualLease(date1, 14, true);
	AnnualLease secondLease = new AnnualLease(date2, 16, false);
		
	// create two DailyLeases
	DailyLease thirdLease = new DailyLease(date1, date2, 14);
	DailyLease fourthLease = new DailyLease(date2, date3, 16);
	
	// retrieve information about the Annual Leases
	System.out.println("AnnualLease 1 information is: \n"
		+ firstLease.getAmount() + " "
		+ firstLease.getStartDate() + " "
		+ firstLease.getEndDate() + " "
		+ firstLease.getBalanceDue() + " " 
		+ firstLease.getPayMonthly());
		
	System.out.println("AnnualLease 2 information is: \n"
		+ secondLease.getAmount() + " "
		+ secondLease.getStartDate() + " "
		+ secondLease.getEndDate() + " "
		+ secondLease.getBalanceDue() + " "
		+ secondLease.getPayMonthly());
	
	// test tellAboutSelf method of DailyLease
	System.out.println(thirdLease.tellAboutSelf());
	System.out.println(fourthLease.tellAboutSelf());

	}
}
