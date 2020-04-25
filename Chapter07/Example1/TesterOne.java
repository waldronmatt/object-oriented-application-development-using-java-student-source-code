// TesterOne to test initial Boat class (not abstract)

public class TesterOne
{
    public static void main(String args[])
    {
	// create three boats
	Boat firstBoat = new Boat("MO34561", 28, "Tartan", 1998);
	Boat secondBoat = new Boat("MO45678", 27, "S2 Yachts", 1994);
	Boat thirdBoat = new Boat("MO56789", 30, "Catalina", 2001);

	// retrieve information about the boats
	System.out.println("Boat 1 information is: "
		+ firstBoat.getStateRegistrationNo() + " "
		+ firstBoat.getLength() + " "
		+ firstBoat.getManufacturer() + " "
		+ firstBoat.getYear());

	System.out.println("Boat 2 information is: "
		+ secondBoat.getStateRegistrationNo() + " "
		+ secondBoat.getLength() + " "
		+ secondBoat.getManufacturer() + " "
		+ secondBoat.getYear());

	System.out.println("Boat 3 information is: "
		+ thirdBoat.getStateRegistrationNo() + " "
		+ thirdBoat.getLength() + " "
		+ thirdBoat.getManufacturer() + " "
		+ thirdBoat.getYear());
	}
}
