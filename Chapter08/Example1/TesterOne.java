// TesterOne to test initial Lease class 
// with various start dates 

import java.util.*; //for Date and Calendar classes
public class TesterOne
{
   public static void main(String args[])
    {
	// create a Calendar instance set to the current date
	Calendar aCalendar = Calendar.getInstance(); 
	
	// set the calendar to a specific date and assign to date1 
	aCalendar.set(2003, Calendar.FEBRUARY, 4);
	Date date1 = aCalendar.getTime();
			
	// add one month to the calendar and assign to date2
	aCalendar.add(Calendar.MONTH, 1);
	Date date2 = aCalendar.getTime();
	
	// add 10 days to the calendar and assign to date3
	aCalendar.add(Calendar.DATE, 10); 
	Date date3 = aCalendar.getTime();
	
	// create three leases
	Lease firstLease = new Lease(date1);
	Lease secondLease = new Lease(date2);
	Lease thirdLease = new Lease(date3);
		
	// retrieve information about the Leases
	System.out.println("Lease 1 information is: "
		+ firstLease.getAmount() + " "
		+ firstLease.getStartDate() + " "
		+ firstLease.getEndDate());
		
	System.out.println("Lease 2 information is: "
		+ secondLease.getAmount() + " "
		+ secondLease.getStartDate() + " "
		+ secondLease.getEndDate());
		
	System.out.println("Lease 3 information is: "
		+ thirdLease.getAmount() + " "
		+ thirdLease.getStartDate() + " "
		+ thirdLease.getEndDate());
	}
}
