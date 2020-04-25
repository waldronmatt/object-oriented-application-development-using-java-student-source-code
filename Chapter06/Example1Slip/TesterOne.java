// Chapter 6
// create 3 instances of Slip and invoke accessors

public class TesterOne
{
	public static void main(String args[])
  	{
		// create an array to hold three Slip references
		Slip slips[] = new Slip[3];
		// create 3 Slip instances
		slips[0] = new Slip(1, 10, 20);
		slips[1]= new Slip(2, 12, 25);
		slips[2]= new Slip(3, 14, 30);

		// retrieve & display attribute values
		for(int i = 0; i < slips.length; i++)
			{System.out.println(slips[i].tellAboutSelf());}
  } 
} 
