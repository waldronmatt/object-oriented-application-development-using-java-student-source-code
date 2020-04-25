// TesterFour to test leaseAnnualSlip method of Slip
// that creates AnnualLease and associates everything 

import java.util.*;
public class TesterFour
{
    public static void main(String args[])
    {
	// create and set a date from calendar
	Calendar aCalendar = Calendar.getInstance(); 
	aCalendar.set(2003, Calendar.AUGUST, 28);
	Date date1 = aCalendar.getTime();
	
	Customer firstCustomer; 
	Boat firstBoat;
	Slip firstSlip;
	Lease firstLease;
	
	// create a Customer instance
	firstCustomer = new Customer("Eleanor", "Atlanta", "123-4567"); 	
	// create a Boat instance for customer
	firstBoat = new Boat("MO3456", 28,"Tartan", 2002, firstCustomer);
	// create a Slip instance
	firstSlip = new Slip(1, 12, 20);
	
	// assign the Boat to the Slip
	firstBoat.assignBoatToSlip(firstSlip);

	// lease this Slip to Customer (slip creates new annual lease)
	firstSlip.leaseAnnualSlip(firstCustomer, date1, true); 
	
	// get new AnnualLease reference from Slip
	firstLease = firstSlip.getLease();
	
	// verify Boat to Customer association 
	System.out.print(firstBoat.getCustomer().getName() + " owns ");
	// verify Customer to Boat association 
	System.out.println(firstCustomer.getBoat().getManufacturer() 
				+ " " + firstCustomer.getBoat().getLength());

	// verify Slip to Boat association 
	System.out.print("Boat " + 
			firstSlip.getBoat().getStateRegistrationNo());
	// verify Boat to Slip association  
	System.out.println(" is assigned to Slip no " + 
			firstBoat.getSlip().getNo());

	// verify Customer to Lease to Slip
	System.out.print(firstCustomer.getName() + 
			" has leased slip no ");
	System.out.println(firstCustomer.getLease().getSlip().getNo());
	System.out.println("The lease amount is " + 
			firstCustomer.getLease().getAmount());
	
	// verify Slip to Lease to Customer
	System.out.print("Slip number " + firstSlip.getNo() + 
			" is leased to ");
	System.out.println(firstSlip.getLease().getCustomer().getName()); 
	System.out.println("The lease amount is " + 
			firstSlip.getLease().getAmount());
	
	// verify Slip to Boat to Customer to Lease and back to Slip!!!
	System.out.println("Starting with slip 1 navigating to slip " +
	 firstSlip.getBoat().getCustomer().getLease().getSlip().getNo());
	
	}
} 
