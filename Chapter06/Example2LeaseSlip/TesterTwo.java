// Chapter 6
// create 3 instances of Slip and invoke custom method leaseSlip

public class TesterTwo
{
	public static void main(String args[])
  	{
		// create an array to hold three Slip references
		Slip slips[] = new Slip[3];
		// create 3 Slip instances
		slips[0] = new Slip(1, 10, 20);
		slips[1]= new Slip(2, 12, 25);
		slips[2]= new Slip(3, 14, 30);
						
		// compute & display lease fee for each slip instance
		for(int i = 0; i < slips.length; i++)
		{
			double fee = slips[i].leaseSlip();
			System.out.println("Fee is " + fee + " for slip " + slips[i].getSlipId());
		}		
  }
} 
