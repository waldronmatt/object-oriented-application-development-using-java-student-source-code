// TesterOneB - associate Boat with Customer

public class TesterOneB
{
	public static void main(String args[])
  	{
		// create a Customer instance
		Customer firstCustomer = new 
					Customer("Eleanor", "Atlanta", "123-4567"); 	
		
		// create a Boat instance
		Boat firstBoat = new Boat("MO34561", 28, "Tartan", 2002);
			
		// assign the Boat to the Customer
		firstBoat.assignBoatToCustomer(firstCustomer);

		// verify Boat to Customer association:
		// ask boat for its Customer reference 
		// then use it with Customer accessor
		System.out.println("Boat owner information is "
				+ firstBoat.getCustomer().getName() + " "
				+ firstBoat.getCustomer().getAddress() + " " 
				+ firstBoat.getCustomer().getPhoneNo());
							
		// verify Customer to Boat association:
		// ask Customer for its Boat reference
		// then use it with Boat accessor
		System.out.println("Customer boat information is "
				+ firstCustomer.getBoat().getStateRegistrationNo() + " "
				+ firstCustomer.getBoat().getManufacturer() + " "
				+ firstCustomer.getBoat().getLength() + " "
				+ firstCustomer.getBoat().getYear());
	}
} 
