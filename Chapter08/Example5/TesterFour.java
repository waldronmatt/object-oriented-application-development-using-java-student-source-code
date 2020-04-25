// TesterFour to test AnnualLease with custom exception

import java.util.*;
public class TesterFour
{
	public static void main(String args[])
	{
		// create a date from calendar
		Calendar aCalendar = Calendar.getInstance(); 
		aCalendar.set(2003, Calendar.AUGUST, 28);
		Date date1 = aCalendar.getTime();
		
		// create an AnnualLeases with monthly payments
		AnnualLease firstLease = new AnnualLease(date1, 14, true);
	
		// record a lease payment that exceeds balance due that
		// causes the lease to throw an exception		
		try
		{
			firstLease.recordLeasePayment(1200.00);
		}
		catch(LeasePaymentException e)
		{
			System.out.println(e.toString());
		}
	}
}
