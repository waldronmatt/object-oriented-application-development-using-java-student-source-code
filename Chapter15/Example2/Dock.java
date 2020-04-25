// Chapter 15 - implement Dock has Slips

import java.util.*;
import java.sql.Connection;

public class Dock
{
	// attributes
   private int id;
   private String location;
   private boolean electricity;
   private boolean water;

   // implement slip association with Vector class
   private Vector slips;

   // constructor
   public Dock(int anId, String aLocation,
   						 boolean anElectricity, boolean aWater)
   {
		setId(anId);
		setLocation(aLocation);
		setElectricity(anElectricity);
		setWater(aWater);
		slips = new Vector(10); // start with 10 slips
	}

	// DA static methods *********************************
	public static void initialize(Connection c)
		{DockDA.initialize(c);}
	public static Dock find(int key) throws NotFoundException
		{return DockDA.find(key);}
	public static Vector getAll()
		{return DockDA.getAll();}
	public static void terminate()
		{DockDA.terminate();}

	// set accessor methods
	public void setId(int anId)
		{ id = anId;}
	public void setLocation(String aLocation)
		{ location = aLocation;}
	public void setElectricity(boolean anElectricity)
		{ electricity = anElectricity;}
	public void setWater(boolean aWater)
		{ water = aWater;}

	// get accessor methods
	public int getId()
		{ return id;}
	public String getLocation()
		{ return location;}
	public boolean getElectricity()
		{ return electricity;}
	public boolean getWater()
		{ return water;}
	public Vector getSlips()
		{ return slips;}

	public String tellAboutSelf()
	{
		String hasElectricity = getElectricity()?"Has Electricity":
										"Has No Electricity";
		String hasWater = getWater()?"Has Water":"Has No Water";
		return ("Dock " + getId() +
			" Location is " + getLocation() + ", " +
			hasElectricity + ", " + hasWater);
	}

	// custom method addSlipToDock
	public void addSlipToDock(Slip aSlip)
	{
		slips.addElement(aSlip); // connect dock to slip
		aSlip.setDock(this);		 // connect slip to dock
	}
}





