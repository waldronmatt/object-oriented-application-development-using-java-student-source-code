/* LeaseDA for Chapter 17
   Includes only those DA methods necessary
*/

package Bradshaw;

import java.util.*; 	// Date and Calendar classes
import java.sql.*;
import java.text.*; 	// DateFormat class

public class LeaseDA
{
	static Customer aCustomer;
	static Slip aSlip;
	static AnnualLease aLease;
	static int payMonthlyYesNo;
	// declare variables for Customer attribute values
	static String name, address, phoneNumber;
	// declare variables for Slip attribute values
	static int slipNo, slipWidth, dockId;
	static double slipLength;
	// declare variables for Lease attribute values
	static double amount, balanceDue;
	static java.util.Date startDate;
	static boolean payMonthly;

	// references to customer and to slip
	Customer customer;
	Slip slip;

	// declare variables for database connection
	static Connection aConnection;
	static Statement aStatement;

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

	public static AnnualLease find(String key) throws NotFoundException
	{ // retrieve Lease, Customer and Slip data
		aCustomer = null;
		// define the SQL query statement using the phone number key
		String sqlQuery = "SELECT CustomerName, Address, PhoneNo, " +
								" LeaseTable.SlipNo, Amount, StartDate, " +
								" PayMonthly, BalanceDue, " +
								" SlipTable.DockId, Width, SlipLength " +
								" FROM CustomerTable, LeaseTable, SlipTable " +
								" WHERE PhoneNo = '" + key +"'" +
								" And CustomerPhoneNo  = '" + key +"'" +
								" AND LeaseTable.SlipNo = SlipTable.SlipNo" +
								" AND LeaseTable.DockId = SlipTable.DockId" ;

	 	// execute the SQL query statement
		try
 		{
	    	ResultSet rs = aStatement.executeQuery(sqlQuery);
			// next method sets cursor & returns true if there is data
			boolean gotIt = rs.next();
	    	if (gotIt)
	    		{	// extract the customer data
					name = rs.getString(1);
					address = rs.getString(2);
					phoneNumber = rs.getString(3);
					// extract the Lease data
					slipNo = rs.getInt(4);
					amount = rs.getDouble(5);
					startDate = rs.getDate(6);
					int monthlyYesNo = rs.getInt(7);
					if(monthlyYesNo == 1) // convert 0/1 to boolean
						payMonthly = true;
					else
						payMonthly = false;
 					balanceDue = rs.getDouble(8);
					// extract the Slip data
					dockId = rs.getInt(9);
					slipWidth = rs.getInt(10);
					slipLength = rs.getDouble(11);

 					// create Customer, Lease & Slip instances
					aCustomer = new Customer(name, address, phoneNumber);
					aLease = new AnnualLease(startDate, slipWidth, payMonthly);
					aSlip = new Slip(slipNo, slipWidth, slipLength, dockId);
					aLease.setCustomer(aCustomer);// link lease to customer
					aSlip.setLease(aLease); 		// link slip to lease
					aLease.setSlip(aSlip); //
					aCustomer.setLease(aLease); 	// link customer to lease
				}
			else	// nothing was retrieved
				{throw (new NotFoundException("not found "));}
			rs.close();
   	}
		catch (SQLException e)
			{ System.out.println(e);}
		return aLease;
	}
}

