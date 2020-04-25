// Chapter 6 - Example 4
// create 3 instances of Slip and invoke static method getNumberOfSlips

public class TesterFour
{
	public static void main(String args[])
  	{
		// create an array to hold three Slip references
		Slip slips[] = new Slip[3];
		// create 3 Slip instances & display numberOfSlips for each
		slips[0] = new Slip(1, 10, 20);
		System.out.println("Number of slips " + Slip.getNumberOfSlips());
		slips[1]= new Slip(2, 12, 25);
		System.out.println("Number of slips " + Slip.getNumberOfSlips());
		slips[2]= new Slip(3, 14, 30);
		System.out.println("Number of slips " + Slip.getNumberOfSlips());

		// retrieve & display numberOfSlips using reference variable
		System.out.println("Number of slips (ref var) " + slips[0].getNumberOfSlips());
  }
} 
