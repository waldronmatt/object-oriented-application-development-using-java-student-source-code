// TesterOneA - associate Customer with Boat
// Customer class is modified but not Boat class

public class TesterOneA
{
	public static void main(String args[])
  	{
		// create a Customer instance
		Customer firstCustomer = new 
					Customer("Eleanor", "Atlanta", "123-4567"); 	
		
		// create a Boat instance
		Boat firstBoat = new Boat("MO34561", 28, "Tartan", 2002);
			
		// set the Boat for the customer
		firstCustomer.setBoat(firstBoat);
		
		// you can get the Boat reference from Customer
		// then use it to get Boat information
		Boat aBoat = firstCustomer.getBoat();
		System.out.println("Customer boat information is "
				+ aBoat.getStateRegistrationNo() + " "
				+ aBoat.getManufacturer() + " "
				+ aBoat.getLength() + " "
				+ aBoat.getYear());

		// you can also verify Customer to Boat association
		// by navigating directly, asking Customer for its Boat 
		// reference then using it with boat accessor
		System.out.println("Again, customer boat information is "
				+ firstCustomer.getBoat().getStateRegistrationNo() + " "
				+ firstCustomer.getBoat().getManufacturer() + " "
				+ firstCustomer.getBoat().getLength() + " "
				+ firstCustomer.getBoat().getYear());
	}
} 
