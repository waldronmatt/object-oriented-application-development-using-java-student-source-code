// Chapter 6 Example 5
// illustrate overloaded methods

public class TesterFive
{
	public static void main(String args[])
  	{
		// create 2 Slip instances using different constructors
		// first use original constructor passing 3 arguments
		Slip firstSlip = new Slip(1, 10, 20);

		// next, use 2nd constructor passing only 1 argument
		Slip secondSlip = new Slip(2);

		// retrieve & display info for both slips
		System.out.println(firstSlip.tellAboutSelf());
		System.out.println(secondSlip.tellAboutSelf());
		
		System.out.println("Slip 1 fee is " + firstSlip.leaseSlip());
		System.out.println("with 10% discount is " + firstSlip.leaseSlip(10));
		System.out.println("Slip 2 fee is " + secondSlip.leaseSlip());
		System.out.println("with 20% discount is " + secondSlip.leaseSlip(20));
  } 
} 
