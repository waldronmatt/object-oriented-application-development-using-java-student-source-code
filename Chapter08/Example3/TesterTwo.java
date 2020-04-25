// TesterTwo to test AnnualLease and DailyLease subclasses 

import java.util.*;
public class TesterTwo
{
    public static void main(String args[])
    {
	// create and set three dates from calendar
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

	// retrieve information about daily leases
	System.out.println("DailyLease 1 information is: \n"
		+ thirdLease.getAmount() + " "
		+ thirdLease.getStartDate() + " "
		+ thirdLease.getEndDate() + " "
		+ thirdLease.getNumberOfDays());
	
	System.out.println("DailyLease 2 information is: \n"
		+ fourthLease.getAmount() + " "
		+ fourthLease.getStartDate() + " "
		+ fourthLease.getEndDate() + " "
		+ fourthLease.getNumberOfDays());
	}
}
