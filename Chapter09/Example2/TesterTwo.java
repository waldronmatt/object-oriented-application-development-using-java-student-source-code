// TesterTwo - associate Boat with Customer
// use tellAboutSelf to get boat and customer details

public class TesterTwo
{
	public static void main(String args[])
  	{
		// create several customers		
		Customer firstCustomer = new 
				Customer("Eleanor", "Atlanta", "123-4567"); 	
		Customer secondCustomer = new 
				Customer("JoAnn", "St Louis", "987-6543"); 	
	
		// create boats passing customer references 
		Boat firstBoat = new 
				Boat("MO34561", 28, "Tartan", 2002, firstCustomer);
		Boat secondBoat = new 
				Boat("MO98765", 32, "Catalina", 2001, secondCustomer); 

		// use Boat tellAboutSelf method to get back details
		System.out.println(firstBoat.tellAboutSelf());
		System.out.println(secondBoat.tellAboutSelf());
	}
} 
