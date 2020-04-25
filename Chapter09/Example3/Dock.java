// Dock class to illustrate 1 to many association with Slip

import java.util.*;
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
		slips = new Vector(10); // start with Vector for 10 slips
	}

	// custom method addSlipToDock
	public void addSlipToDock(Slip aSlip)
	{
		slips.addElement(aSlip); // connect dock to slip (1..*)
		aSlip.setDock(this);		 // connect slip to dock (1..1)
	}
	// custom method to return vector of slips 
	public Vector getSlips()
		{ return slips;}

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
}