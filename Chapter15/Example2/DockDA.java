// Chapter 15  implement Dock has Slips

import java.util.Vector;
import java.sql.*;

public class DockDA
{
	static Vector docks = new Vector();
	static Slip aSlip;
	static Dock aDock;

	static Connection aConnection;
	static Statement aStatement;

	// declare variables for Slip attribute values
	static int slipNo;
	static int width;
	static double slipLength;
	static int dockId; 

	// declare variables for Dock attribute values
	static int id;
	static String location;
	static boolean electricity;
	static boolean water;
	// Yes/No variables needed to convert boolean to text for dbms
	static int electricityYN;
	static int waterYN;

	// establish the database connection
	public static void initialize(Connection c)
	{
		try
 		{
	    	aConnection = c;
	    	// create statement object instance for this connection
	    	aStatement = aConnection.createStatement();
		}
		catch (SQLException e)
			{ System.out.println(e);	}
	}

	// close the database connection
	public static void terminate()
	{
		try
 		{
			aStatement.close();
		}
		catch (SQLException e)
			{ System.out.println(e);	}
	}

	public static Dock find(int key) throws NotFoundException
	{
		aDock = null;
		// define the SQL query statement
		String sqlQuery = "SELECT DockTable.DockId, Location, Electricity, Water, " +
								" SlipNo, Width, SlipLength FROM DockTable, SlipTable " +
								" WHERE DockTable.DockId = " + key +
								" AND SlipTable.DockId = DockTable.DockId" +
								" ORDER BY SlipNo";

	 	// execute the SQL query statement
		try
 		{  // get the dock
	    	ResultSet rs = aStatement.executeQuery(sqlQuery);
			// next method sets cursor & returns true if there is data
			boolean dockCreated = false;
			boolean more = rs.next();
			while(more)  		// loop for each row of result set
		   {
		   	if (dockCreated == false)
					{	// extract the Dock data
						dockId = rs.getInt(1);
						location = rs.getString(2);
						electricityYN = rs.getInt(3);
						waterYN = rs.getInt(4);
						// convert ints to booleans
						electricity = integerToBoolean(electricityYN);
						water = integerToBoolean(waterYN);
						// create Dock instance
						aDock = new Dock(dockId, location, electricity, water);
						dockCreated = true;
					}
				// extract the Slip data
				slipNo	= rs.getInt(5);
				width = rs.getInt(6);
				slipLength = rs.getDouble(7);
				aSlip = new Slip(slipNo, width, slipLength, aDock);
				more = rs.next();	// set cursor to next row
			}
			if(dockCreated == false)
				throw (new NotFoundException("Dock not found "));
		}
		catch (SQLException e)
			{ System.out.println(e);}
		return aDock;
	}

	public static Vector getAll()
	{
		Vector docks = new Vector();
		// define the SQL query statement for get all
		String sqlQuery = "SELECT DockTable.DockId, Location, Electricity, Water," +
								" SlipNo, Width, SlipLength FROM DockTable, SlipTable " +
								" WHERE SlipTable.DockId = DockTable.DockId"+
								" ORDER BY DockTable.DockId, SlipNo";
		try
 		{
		 	// execute the SQL query statement
	    	ResultSet rs = aStatement.executeQuery(sqlQuery);
			// next method sets cursor & returns true if there is data
			boolean moreData = rs.next(); //initialize cursor
			// read initial value of control field
			int thisDockId = rs.getInt(1);

	    	while (moreData)
	    	{
				// store value of control field
				int prevDockId = thisDockId;
				// extract the Dock data
				location = rs.getString(2);
				electricityYN = rs.getInt(3);
				waterYN = rs.getInt(4);
				// convert int to boolean
				electricity = integerToBoolean(electricityYN);
				water = integerToBoolean(waterYN);
				// create Dock instance
				aDock = new Dock(thisDockId, location, electricity, water);
				docks.addElement(aDock);
				// get slips for this dock
				while ( prevDockId == thisDockId && moreData )
				{
					// extract the Slip data
					slipNo	= rs.getInt(5);
					width = rs.getInt(6);
					slipLength = rs.getDouble(7);
					// create Slip instance
					aSlip = new Slip(slipNo, width, slipLength, aDock);
					// set cursor to next row
					moreData = rs.next();
					// get next value of control field
					if (moreData)
						thisDockId = rs.getInt(1);
				}
			}
			rs.close();
		}
		catch (SQLException e)
			{ System.out.println(e);}
	 	return docks;
	}

	private static boolean integerToBoolean(int i)
	{
		boolean b = false;
		if(i == 1)
			b = true;
		return b;
	}
}

