// TesterThreeA
// Dock has Slips (ignores Boat and Customer for now)

import java.util.*;
public class TesterThreeA
{
	public static void main(String args[])
  	{
		// declare Dock and Slip reference variables 
		Dock firstDock;
		Slip firstSlip;
		Slip secondSlip;
		Slip thirdSlip;

		// create a Dock instance
		firstDock = new Dock(1, "Main Cove", true, false);
		
		// create three Slip instances for the Dock
		firstSlip = new Slip(1, 10, 20, firstDock);
		secondSlip = new Slip(2, 12, 25, firstDock);
		thirdSlip = new Slip(3, 14, 25, firstDock);
	
		// verify Dock to Slip association (1 to many):
		// first get the Vector of slips from the Dock
		Vector slips = firstDock.getSlips();
		// next use Vector size method to get number of slips			
		System.out.println("Dock 1 has " + slips.size() + " slips");
		// iterate through Vector to get information on each slip
		for(int i = 0; i < slips.size(); i++)
		{
			// get slip reference variable from slips Vector of Dock
			Slip aSlip = (Slip) slips.elementAt(i);
			// verify slip information 
			System.out.println("  Slip number " + aSlip.getNo() 
			+ " has width of " + aSlip.getWidth()
			+ " has length of " + aSlip.getSlipLength());
	 	}	
		
		// verify slip to dock association (1:1)	
		System.out.println("First slip is on Dock " 
		+   firstSlip.getDock().getId()
		+ " with location " + firstSlip.getDock().getLocation()
		+ " with electricity " + firstSlip.getDock().getElectricity()
		+ " and water " + firstSlip.getDock().getWater());
	}
} 
