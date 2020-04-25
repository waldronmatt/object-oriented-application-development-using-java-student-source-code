// TesterTwo Chapter 5
// create 3 instances of Customer and invoke accessor methods

public class TesterTwo
{
	public static void main(String args[])
	{
		// define the reference variables
		Customer firstCustomer, secondCustomer, thirdCustomer; 
		
		// define variables to contain attribute values retrieved
		String custName1, custName2, custName3; 
		
		// create the 3 instances
		firstCustomer = new Customer(); // create the first instance   
		secondCustomer = new Customer();// create the second instance     
		thirdCustomer = new Customer(); // create the third instance     
		
		// invoke setters to populate 1st instance
		firstCustomer.setName("Eleanor"); 
		firstCustomer.setAddress("Atlanta");
		firstCustomer.setPhoneNo("123-4567");
		
		// invoke setters to populate 2nd instance
		secondCustomer.setName("Mike");   
		secondCustomer.setAddress("Boston");
		secondCustomer.setPhoneNo("467-1234");

		// invoke setters to populate 3rd instance
		thirdCustomer.setName("JoAnn");   
		thirdCustomer.setAddress("St. Louis");
		thirdCustomer.setPhoneNo("765-4321");

		// retrieve & display names for all three customers
		custName1 = firstCustomer.getName();
		custName2 = secondCustomer.getName();
		custName3 = thirdCustomer.getName();
		System.out.println("customer 1 name is " + custName1);
		System.out.println("customer 2 name is " + custName2);
		System.out.println("customer 3 name is " + custName3);

		// retrieve & display phone no without using a variable
		System.out.println("3rd phone is " + thirdCustomer.getPhoneNo());

		// change phone no for 3rd customer & redisplay
		thirdCustomer.setPhoneNo("818-1000"); 
		System.out.println("changed 3rd phone is " + thirdCustomer.getPhoneNo());
	} 
}