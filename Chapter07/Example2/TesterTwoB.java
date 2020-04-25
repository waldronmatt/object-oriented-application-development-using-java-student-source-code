// TesterTwoB -- to test both Sailboat and Powerboat subclasses

public class TesterTwoB
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

	// get information about two sailboats (seven attributes)
	System.out.println("This boat is a " + firstBoat.toString()
		+ firstBoat.getStateRegistrationNo() + " "
		+ firstBoat.getLength() + " "
		+ firstBoat.getManufacturer() + " "
		+ firstBoat.getYear() + " "
		+ firstBoat.getKeelDepth() + " "
		+ firstBoat.getNoSails() + " "
		+ firstBoat.getMotorType());

	System.out.println("This boat is a " + secondBoat.toString()
		+ secondBoat.getStateRegistrationNo() + " "
		+ secondBoat.getLength() + " "
		+ secondBoat.getManufacturer() + " "
		+ secondBoat.getYear() + " "
		+ secondBoat.getKeelDepth() + " "
		+ secondBoat.getNoSails() + " "
		+ secondBoat.getMotorType());

	// get information about two powerboats (six attributes)
	System.out.println("This boat is a " + thirdBoat.toString()
		+ thirdBoat.getStateRegistrationNo() + " "
		+ thirdBoat.getLength() + " "
		+ thirdBoat.getManufacturer() + " "
		+ thirdBoat.getYear() + " "
		+ thirdBoat.getNoEngines() + " "
		+ thirdBoat.getFuelType());

	System.out.println("This boat is a " + fourthBoat.toString()
		+ fourthBoat.getStateRegistrationNo() + " "
		+ fourthBoat.getLength() + " "
		+ fourthBoat.getManufacturer() + " "
		+ fourthBoat.getYear() + " "
		+ fourthBoat.getNoEngines() + " "
		+ fourthBoat.getFuelType());
	}
}
