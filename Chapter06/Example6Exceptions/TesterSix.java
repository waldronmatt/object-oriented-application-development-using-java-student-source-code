// Chapter 6 Example 6
// illustrate exception handling & data validation

public class TesterSix
{
	public static void main(String args[])
	{
		Slip firstSlip = null;		
		try 	// force exception with invalid slip Id
		{	
			firstSlip = new Slip(150, 10, 25);
			System.out.println(firstSlip.tellAboutSelf());
		} 
		catch (Exception n) // display exception message
		{ System.out.println(n); }

		try 	// force exception with invalid width
		{	
			firstSlip = new Slip(1, 15, 25);
			System.out.println(firstSlip.tellAboutSelf());
		}   
		catch (Exception n) // display exception message
			{ System.out.println(n); }
		finally
			{System.out.println("finally block is always executed");}
		
		try 	// create a slip using valid id & width
		{	
			firstSlip = new Slip(2, 10, 25);
			System.out.println(firstSlip.tellAboutSelf());
		}
		catch (Exception n) 
			{ System.out.println(n); }
		finally
			{System.out.println("finally block is always executed");}
	} 
} 
