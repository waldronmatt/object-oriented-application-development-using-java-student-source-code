// TesterTwoA -- to test Sailboat subclass

public class TesterTwoA
{
	public static void main(String args[])
	{

	// create three sailboats (7 arguments)
	Sailboat firstBoat = new Sailboat("MO34561", 28, "Tartan", 
									1998, 4.11, 2, "Inboard Diesel");
	Sailboat secondBoat = new Sailboat("MO45678", 27, "S2 Yachts",
									1994, 3.9, 4,"Outboard Gas");
	Sailboat thirdBoat = new Sailboat("MO56789", 30, "Catalina",
									2001, 5.5, 3,"Inboard Diesel");

	// retrieve information about the sailboats
	System.out.println("Boat 1 information is: "
		+ firstBoat.getStateRegistrationNo() + " "
		+ firstBoat.getLength() + " "
		+ firstBoat.getManufacturer() + " "
		+ firstBoat.getYear() + " "
		+ firstBoat.getKeelDepth() + " "
		+ firstBoat.getNoSails() + " "
		+ firstBoat.getMotorType());

	System.out.println("Boat 2 information is: "
		+ secondBoat.getStateRegistrationNo() + " "
		+ secondBoat.getLength() + " "
		+ secondBoat.getManufacturer() + " "
		+ secondBoat.getYear() + " "
		+ secondBoat.getKeelDepth() + " "
		+ secondBoat.getNoSails() + " "
		+ secondBoat.getMotorType());

	System.out.println("Boat 3 information is: "
		+ thirdBoat.getStateRegistrationNo() + " "
		+ thirdBoat.getLength() + " "
		+ thirdBoat.getManufacturer() + " "
		+ thirdBoat.getYear() + " "
		+ thirdBoat.getKeelDepth() + " "
		+ thirdBoat.getNoSails() + " "
		+ thirdBoat.getMotorType());
	}
}
