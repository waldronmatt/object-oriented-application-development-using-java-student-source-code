// Dock for Chapter 17
// Includes only those DA and other methods necessary

package Bradshaw;

import java.util.*;
import java.sql.Connection;

public class Dock
{
	// attributes
   private int id;
   private String location;
   private boolean electricity;
   private boolean water;

   // constructor
   public Dock(int anId, String aLocation,
   						 boolean anElectricity, boolean aWater)
   {
		setId(anId);
		setLocation(aLocation);
		setElectricity(anElectricity);
		setWater(aWater);
		//slips = new Vector(10); // start with 10 slips
	}

	// DA static methods *********************************
	public static void initialize(Connection c)
		{DockDA.initialize(c);}
	public static Dock find(int key) throws NotFoundException
		{return DockDA.find(key);}
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

	public String tellAboutSelf()
	{
		String hasElectricity = getElectricity()?"Has Electricity":
										"Has No Electricity";
		String hasWater = getWater()?"Has Water":"Has No Water";
		return ("Dock " + getId() +
			" Location is " + getLocation() + ", " +
			hasElectricity + ", " + hasWater);
	}
}





