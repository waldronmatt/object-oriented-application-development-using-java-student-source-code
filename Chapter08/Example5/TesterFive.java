// TesterFive to test AnnualLease with custom exception
// for batch of multiple payment transactions

import java.util.*;
public class TesterFive
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
	
	// create three AnnualLeases with monthly payments
	AnnualLease firstLease = new AnnualLease(date1, 14, true);
	AnnualLease secondLease = new AnnualLease(date2, 16, true);
	AnnualLease thirdLease = new AnnualLease(date3, 12, true);
	
	// invoke processPayment method of TesterFive to process
	// a batch of payments
	System.out.println("Processing three payments:");
	processPayment(firstLease, 200);		// a valid payment
	processPayment(secondLease, 2000);	// an invalid payment
	processPayment(thirdLease, 400);		// a valid payment
	
	}
	
	// private method of TesterFive to process batch of payments
	private static void processPayment(AnnualLease aLease, 
									double aPayment)
	{
		try
		{
			// invoke method of the lease referenced in aLease
			aLease.recordLeasePayment(aPayment);
			System.out.println("Payment transaction successful " + 
									"for lease " +
									aLease.getStartDate().toString());
		}
		catch(LeasePaymentException e)
		{
			// show LeasePaymentException if caught
			System.out.println(e.toString());
		}
		catch(Exception e)
		{
			// show any other Exception if caught
			System.out.println(e.toString());
		}
	}
}
