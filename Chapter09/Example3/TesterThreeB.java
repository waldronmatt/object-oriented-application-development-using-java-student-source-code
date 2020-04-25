// TesterThreeB
// Dock has Slips with Boat and Customer

import java.util.*;
public class TesterThreeB
{
	public static void main(String args[])
  	{
		// declare reference variables		
		Dock firstDock;
		Slip firstSlip;
		Slip secondSlip;
		Customer firstCustomer;
		Customer secondCustomer;
		Boat firstBoat;
		Boat secondBoat;

		// create a Dock instance
		firstDock = new Dock(1, "Main Cove", true, false);
		
		// create two Slip instances for the Dock
		firstSlip = new Slip(1, 10, 20, firstDock);
		secondSlip = new Slip(2, 12, 25, firstDock);
		
		// create two Customer instances 
		firstCustomer = new 
				Customer("Eleanor", "Atlanta", "123-4567"); 	
		secondCustomer = new 
				Customer("JoAnn", "St Louis", "987-6543"); 	
		
		// create Boats passing Customer references 
		firstBoat = new 
				Boat("MO34561", 28, "Tartan", 2002, firstCustomer);
		secondBoat = new 
				Boat("MO98765", 32, "Catalina", 2001, secondCustomer); 

		// assign the Boats to the Slips
		firstBoat.assignBoatToSlip(firstSlip);
		secondBoat.assignBoatToSlip(secondSlip);
		
		// verify Customer to Boat to Slip to Dock
		System.out.println("Information for customer " 
			+ firstCustomer.getName()
			+ "\n Boat is " + firstCustomer.getBoat().getManufacturer()
			+ "\n Slip is " + firstCustomer.getBoat().getSlip().getNo()
			+ "\n Dock is " 
			+ firstCustomer.getBoat().getSlip().getDock().getId());

		// verify Dock to Slip to Boat association (1 to many):
		// first get the Vector of slips from the Dock
		Vector slips = firstDock.getSlips();
		// next use Vector size method to get number of slips			
		System.out.println("Dock 1 has " + slips.size() + " slips");
		// iterate through Vector to get information on each Slip
		for(int i = 0; i < slips.size(); i++)
		{
			Slip aSlip = (Slip) slips.elementAt(i);
			// verify Slip to Boat to Customer 
			System.out.println(" Slip number " + aSlip.getNo() 
			+ " has width of " + aSlip.getWidth()
			+ " has length of " + aSlip.getSlipLength()
			+ "\n containing " + aSlip.getBoat().tellAboutSelf());
	 	}	
	}
} 
