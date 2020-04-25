// TesterOne Chapter 5
// create instance of Customer and invoke accessor methods

public class TesterOne
{
	public static void main(String args[])
	{
 		Customer firstCustomer = new Customer(); 	// create instance
		
		// invoke set accessors to populate attributes
		firstCustomer.setName("Eleanor");
		firstCustomer.setAddress("Atlanta");
		firstCustomer.setPhoneNo("123-4567");
		
		// define variables to contain attribute values retrieved
		String customerName, customerAddress, customerPhoneNo;
		
		// invoke get accessors to retrieve attribute values 
		customerName = firstCustomer.getName();
		customerAddress = firstCustomer.getAddress();
		customerPhoneNo = firstCustomer.getPhoneNo();
		
		// display the retrieved attribute values
		System.out.println("The name is " + customerName);
		System.out.println("The address is " + customerAddress);
		System.out.println("The phone is " + customerPhoneNo);
	} 
} 
