// TesterOne Chapter 15 - Customer associated with Boat

import java.util.Vector;
import java.sql.Connection;

public class TesterOne
{
	static Customer aCustomer;

	public static void main(String args[])
  	{
		Vector customers;
		Boat aBoat;

		// initialize the databases
		Connection c = CustomerAndBoatDatabaseConnect.initialize();
		Customer.initialize(c);
		Boat.initialize(c);

		try // get a customer & their boat
		{
			aCustomer = Customer.find("123-4567");
			printDetails();
		}
		catch(NotFoundException e)
			{	System.out.println(e);}

		try // try to get a non-existent customer & their boat
		{
			aCustomer = Customer.find("000-0000");
			printDetails();
		}
		catch(NotFoundException e)
			{	System.out.println("Did not find 000-0000\n");}

		// get all customers & their boats
		customers = Customer.getAll();
		for(int i = 0; i < customers.size(); i++)
			{
				// get customer reference
				aCustomer = (Customer) customers.get(i);
				printDetails();
			}

		// add a new customer and their boat
		aCustomer = new Customer("Ed", "KC", "339-4990");
		aBoat = new Boat("MO112233", 25, "S-2",1984);
		aBoat.assignBoatToCustomer(aCustomer);

		try
			{
				aCustomer.addNew();
				System.out.println("Ed and his boat added\n");
			}
		catch(DuplicateException e)
			{	System.out.println(e);}

		try // now, find the new customer & their boat
		{
			aCustomer = Customer.find("339-4990");
			printDetails();
		}
		catch(NotFoundException e)
			{	System.out.println("Did not find 339-4990\n");}

		try // now, delete the new customer & their boat
		{
			aCustomer.delete();
			System.out.println("Ed deleted\n");
		}
		catch(NotFoundException e)
			{	System.out.println(e);}

		try // now, try to find the deleted customer & their boat
		{
			aCustomer = Customer.find("339-4990");
			printDetails();
		}
		catch(NotFoundException e)
		{	System.out.println("Did not find 339-4990\n");}

		// change Eleanor's address to Miami and her boat length to 40

		try
		{
			aCustomer = Customer.find("123-4567");
			printDetails();
			//change customer address
			aCustomer.setAddress("Miami");
			aCustomer.update();
			//change boat length
			aCustomer.getBoat().setLength(40);
			aCustomer.getBoat().update();
			System.out.println("Eleanor updated\n");
		}
		catch (NotFoundException e)
			{System.out.println(e);}

		try // now, try to find the Eleanor & her boat
			{
				aCustomer = Customer.find("123-4567");
				printDetails();
			}
		catch(NotFoundException e)
			{
					System.out.println("Eleanor not found");
			}

		// close the database
		Customer.terminate();
		Boat.terminate();
		CustomerAndBoatDatabaseConnect.terminate();
	}

	private static void printDetails() {
		System.out.println("Found " + aCustomer.getName() + " and associated boat:");
		System.out.println("   " + aCustomer.tellAboutSelf());
		System.out.println("   " + aCustomer.getBoat().tellAboutSelf() + "\n");
	}
}
