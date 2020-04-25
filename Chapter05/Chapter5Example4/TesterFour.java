// TesterFour Chapter 5
// illustrate tellAboutSelf

public class TesterFour
{
	public static void main(String args[])
	{
		// define the reference variables
		Customer firstCustomer, secondCustomer, thirdCustomer; 

		// create three Customer instances with attribute values
		firstCustomer = new Customer("Eleanor", "Atlanta", "123-4567"); 
		secondCustomer = new Customer("Mike", "Boston", "467-1234");    
		thirdCustomer = new Customer("JoAnn", "St. Louis", "765-4321"); 

		// invoke tellAbutSelf for all three customers & display
		System.out.println(firstCustomer.tellAboutSelf());
		System.out.println(secondCustomer.tellAboutSelf());
		System.out.println(thirdCustomer.tellAboutSelf());
	} 
}
