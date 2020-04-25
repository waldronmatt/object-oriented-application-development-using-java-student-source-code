// TesterThreeA -- demonstrates overriding using tellAboutSelf()
// method for Sailboat

public class TesterThreeA
{
	public static void main(String args[])
	{
	// create two sailboats (7 agruments)
	Sailboat firstBoat = new Sailboat("MO34561", 28, "Tartan",
									1998, 4.11, 2, "Inboard Diesel");
	Sailboat secondBoat = new Sailboat("MO45678", 27, "S2 Yachts",
									1994, 3.9, 4,"Outboard Gas");

	// get informnation about sailboats using tellAboutSelf method
	System.out.println(firstBoat.tellAboutSelf());
	System.out.println(secondBoat.tellAboutSelf());
	}
}