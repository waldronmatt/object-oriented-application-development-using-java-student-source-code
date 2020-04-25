// Chapter 15 AnnualLeaseDA

import java.util.*; 	// Date and Calendar classes
import java.sql.*;
import java.text.*; 	// DateFormat class

public class AnnualLeaseDA
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
		// define the SQL query statement
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
					aLease.setCustomer(aCustomer);	// link lease to customer
					aSlip.setLease(aLease); 		// link slip to lease
					aCustomer.setLease(aLease); 	// link customer to lease
					aLease.setSlip(aSlip);			// link lease to slip
				}
			else	// nothing was retrieved
				{throw (new NotFoundException("not found "));}
			rs.close();
   	}
		catch (SQLException e)
			{ System.out.println(e);}
		return aLease;
	}

	public static void addNew(AnnualLease aLease) throws DuplicateException
	{	// retrieve the lease attribute values
		amount = aLease.getAmount();
		balanceDue = aLease.getBalanceDue();
		payMonthly = aLease.getPayMonthly();
		startDate = aLease.getStartDate();
		// convert date to String for database insert
		DateFormat x = DateFormat.getDateInstance(DateFormat.SHORT);
		String stringStartDate = x.format(startDate);
		aSlip = aLease.getSlip();
		aCustomer = aLease.getCustomer();
		// retrieve the customer's phone no
		phoneNumber = aCustomer.getPhoneNo();
		// retrieve the slip no and dock id from the slip
		slipNo = aSlip.getNo();
		dockId = aSlip.getDockId();
		// convert boolean to integer
		if(payMonthly)
			payMonthlyYesNo = 1;
		else
			payMonthlyYesNo = 0;

		// create the SQL insert statement using attribute values
		String sqlInsert = "INSERT INTO LeaseTable " +
								 "(CustomerPhoneNo, SlipNo, DockId, Amount, " +
								 "StartDate, PayMonthly, BalanceDue ) " +
								 "VALUES ('" 		+
								 phoneNumber + "', '" + slipNo	+ "', '" +
								 dockId + "', '" + amount + "', '" +
								 stringStartDate + "', '" + payMonthlyYesNo +
								 "', '" +	balanceDue + "')";

		// see if this lease already exists in the database
		try
		{
			AnnualLease a = AnnualLease.find(phoneNumber);
			throw (new DuplicateException("Lease Exists "));
		}
		// if NotFoundException, add lease to database
		catch(NotFoundException e)
		{
			try
 			{ // execute the SQL update statement
	   		int result = aStatement.executeUpdate(sqlInsert);
			}
			catch (SQLException ee)
				{ System.out.println(ee);	}
		}
	}
}

