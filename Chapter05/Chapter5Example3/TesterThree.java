// TesterThree Chapter 5
// illustrate using a parameterized constructor

public class TesterThree
{
	public static void main(String args[])
	{
		// define the reference variables
		Customer firstCustomer, secondCustomer, thirdCustomer; 

		// create three Customer instances with attribute values
		firstCustomer = new Customer("Eleanor", "Atlanta", "123-4567"); 
		secondCustomer = new Customer("Mike", "Boston", "467-1234");    
		thirdCustomer = new Customer("JoAnn", "St. Louis", "765-4321"); 

		// retrieve & display names for all three customers without using variables
		System.out.println("customer 1 name is " + firstCustomer.getName());
		System.out.println("customer 2 name is " + secondCustomer.getName());
		System.out.println("customer 3 name is " + thirdCustomer.getName());
	} 
}
