// Chapter 14 TesterOne - object persistence 

import java.util.Vector;		
public class TesterOne
{
	public static void main(String args[])
  	{
		// create two customers
		Customer firstCustomer = new Customer("Eleanor", "Atlanta", "123-4567"); ;
		Customer secondCustomer = new Customer("Mike", "Boston", "467-1234");
		
		Customer.initialize();	
		try	// test addNew
		{
			firstCustomer.addNew();
			secondCustomer.addNew();
			System.out.println("added two customers");		
		}
		catch(DuplicateException e)
			{System.out.println(e);}	
		
		try	// test find
		{ 
			firstCustomer = Customer.find("123-4567");			
			System.out.println("find " + firstCustomer.tellAboutSelf());
		}
		catch(NotFoundException e)
			{System.out.println(e);}
	
		// test getAll
		Vector allCustomers = Customer.getAll();
		for(int i = 0; i < allCustomers.size(); i++) 
		{	// display attributes for each customer retrieved
			firstCustomer = (Customer) allCustomers.elementAt(i);	 
			System.out.println("getAll " + firstCustomer.tellAboutSelf());
 		}

		try	// test delete
		{  // delete Mike
			secondCustomer.delete();
			System.out.println("delete " + secondCustomer.tellAboutSelf());
			// try to find the customer just deleted
			secondCustomer = Customer.find("467-1234");
			System.out.println("find " + secondCustomer.tellAboutSelf());
		}
		catch(NotFoundException e)
			{System.out.println(e);}
	
		try	// test update
		{		// change address for Eleanor
			firstCustomer = Customer.find("123-4567");
			firstCustomer.setAddress("Clayton"); 
			firstCustomer.update();
			// display address after change
			firstCustomer = Customer.find("123-4567");
			System.out.println("update " + firstCustomer.tellAboutSelf());
		}
		catch(NotFoundException e)
			{System.out.println(e);}
		 
		Customer.terminate();	
	}
} 
