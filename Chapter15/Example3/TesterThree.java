// TesterThree Chapter 15 - Customer has Lease for a Slip

import java.util.*; // for Date and Calendar classes
import java.text.*; // DateFormat class
import java.sql.Connection;

public class TesterThree
{
	public static void main(String args[])
  	{

		AnnualLease aLease = null;
		Customer aCustomer = null;
		Slip aSlip = null;

		// initialize the database
		Connection c = CustomerLeaseSlipConnect.initialize();
		Customer.initialize(c);
		Slip.initialize(c);
		AnnualLease.initialize(c);

		// get a customer and a slip
		try
		{
			aCustomer = Customer.find("123-4567");
			System.out.println("Customer Information:");
			System.out.println("  " + aCustomer.tellAboutSelf());
			aSlip = Slip.find(1, 1);
			System.out.println("\nSlip Information:");
			System.out.println("  " + aSlip.tellAboutSelf());

			// lease the slip to the customer
			Calendar aCalendar = Calendar.getInstance();
			aCalendar.set(2003, Calendar.AUGUST, 26);
			Date aStartDate = aCalendar.getTime();
			boolean payMonthly = false;
			aLease = aSlip.leaseAnnualSlip(aCustomer, aStartDate, payMonthly);
		}
		catch(NotFoundException e)
			{System.out.println(e);}

		// add the new lease to the database
		try
		{
			aLease.addNew();
			System.out.println("\nNew lease record added!");
		}
		catch (DuplicateException e)
			{System.out.println("\nLease already exists!");}

		// find the lease on the database
		try
			{
				aLease = AnnualLease.find("123-4567");
				aCustomer = aLease.getCustomer();
				aSlip = aLease.getSlip();
				System.out.println("\nLease Information:");
				System.out.println(" " + aLease.tellAboutSelf());
				System.out.println(" " + aCustomer.tellAboutSelf());
				System.out.println(" " + aSlip.tellAboutSelf());
			}
		catch(NotFoundException e)
			{System.out.println(e);}

		Customer.terminate();
		Slip.terminate();
		AnnualLease.terminate();
		CustomerLeaseSlipConnect.terminate();
	}
}
