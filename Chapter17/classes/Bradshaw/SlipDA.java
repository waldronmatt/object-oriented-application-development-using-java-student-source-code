// Slip for Chapter 17
// Same as Chapter 15

package Bradshaw;

import java.sql.*;

public class SlipDA
{
	static Slip aSlip;

	// declare variables for the database connection
	static Connection aConnection;
	static Statement aStatement;

	// declare variables for Slip attribute values
	static int slipNo;
	static int slipWidth;
	static double slipLength;
	static int dockId;

	// establish the database connection
	public static void initialize(Connection c)
	{
		try
 		{
	    	aConnection = c;
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

	public static Slip find(int aSlipNo, int aDockId) throws NotFoundException
	{
		aSlip = null;
		// define the SQL query statement using the phone number key
		String sqlQuery = "SELECT SlipNo, DockId, Width, SlipLength " +
								" FROM SlipTable " +
								" WHERE SlipNo = " + aSlipNo +
								" AND DockId = "   + aDockId ;
	 	// execute the SQL query statement
		try
 		{  // get the dock
	    	ResultSet rs = aStatement.executeQuery(sqlQuery);
			// next method sets cursor & returns true if there is data
			boolean gotIt = rs.next();
	    	if (gotIt)
	    		{	// extract the data
					slipNo = rs.getInt(1);
					dockId = rs.getInt(2);
					slipWidth = rs.getInt(3);
					slipLength = rs.getDouble(4);
 					// create Slip instance
					aSlip = new Slip(slipNo, slipWidth, slipLength, dockId);
				}
			else	// nothing was retrieved
				{throw (new NotFoundException("not found "));}
			rs.close();
   	}
		catch (SQLException e)
			{ System.out.println(e);}
		return aSlip;

	}
}

