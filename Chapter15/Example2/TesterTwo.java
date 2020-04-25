// Chapter 15 TesterTwo - illustrate Dock has Slips association

import java.util.Vector;
import java.sql.*;

public class TesterTwo
{
	static Slip aSlip;
	static Dock aDock;
	static Vector docks, slips;

	public static void main(String args[])
 	{
		// initialize the databases
		Connection c = DockAndSlipDatabaseConnect.initialize();
		Dock.initialize(c);

		// find dock 1 & its slips
		try
		{
			System.out.println("RESULTS of find dock 1:");
			aDock = Dock.find(1);
			printDetails();
		}
		catch(NotFoundException e)
			{System.out.println(e);}

		// find dock 2 & its slips
		try
		{
			System.out.println("\nRESULTS of find dock 2:");
			aDock = Dock.find(2);
			printDetails();
		}
		catch(NotFoundException e)
			{System.out.println(e);}

		// test getAll for docks & slips
		System.out.println("\nRESULTS of getAll:");
		docks = Dock.getAll();
		for(int i = 0; i < docks.size(); i++)
		{  // list slips for this dock
			aDock = (Dock) docks.elementAt(i);
			printDetails();
		}
		// close the database
		Dock.terminate();
		DockAndSlipDatabaseConnect.terminate();
	}

	private static void printDetails()
	{
		System.out.println("\n  " + aDock.tellAboutSelf());
		slips = aDock.getSlips();
		for(int j = 0; j < slips.size(); j++)
		{ // list slips for this dock
		 	aSlip = (Slip) slips.elementAt(j);
			System.out.println("    " + aSlip.tellAboutSelf());
		}
	}
}
