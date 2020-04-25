// TesterThreeB -- demonstrates overriding using tellAboutSelf()
// method with both Sailboat and Powerboat subclasses

public class TesterThreeB
{
	public static void main(String args[])
	{
	// create two sailboats (7 agruments)
	Sailboat firstBoat = new Sailboat("MO34561", 28, "Tartan",
									1998, 4.11, 2, "Inboard Diesel");
	Sailboat secondBoat = new Sailboat("MO45678", 27, "S2 Yachts",
									1994, 3.9, 4,"Outboard Gas");

	// create two powerboats (6 arguments)
	Powerboat thirdBoat = new Powerboat("MO67891", 30, "Bayliner",
									2001, 2, "Gas");
	Powerboat fourthBoat = new Powerboat("MO78910", 27, "Slickcraft",
									1995, 1, "Gas");

	// get information about sailboats using tellAboutSelf method
	System.out.println(firstBoat.tellAboutSelf());
	System.out.println(secondBoat.tellAboutSelf());
	
	// get information about powerboats using tellAboutSelf method
	System.out.println(thirdBoat.tellAboutSelf());
	System.out.println(fourthBoat.tellAboutSelf());
		
	}
}