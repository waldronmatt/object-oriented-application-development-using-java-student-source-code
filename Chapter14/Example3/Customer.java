// Customer - Chapter 14 
// illustrate persistence using a Data Access class  

import java.util.Vector;   

public class Customer implements java.io.Serializable 

{
	// attribute definitions
 	private String name;
 	private String address;
 	private String phoneNo;
		
	// constructor with parameters
	public Customer(String aName, String anAddress, String aPhoneNo)
	{
		// invoke accessors to populate attributes
		setName(aName);
		setAddress(anAddress);
		setPhoneNo(aPhoneNo);
	}
	
	// DA static methods *********************************
	public static void initialize()
		{CustomerDA.initialize();}
	public static Customer find(String phoneNo) throws NotFoundException
		{return CustomerDA.find(phoneNo);}	
	public static Vector getAll()
		{return CustomerDA.getAll();}
	public static void terminate()
		{CustomerDA.terminate();}
	
	// DA instance methods *********************************
	public void addNew() throws DuplicateException
		{CustomerDA.addNew(this);}
	public void delete() throws NotFoundException
		{CustomerDA.delete(this);}
	public void update() throws NotFoundException
		{CustomerDA.update(this);}
	
	// get accessors
 	public String getName()
 		{ return name;}
	public String getAddress()
 		{ return address;}
	public String getPhoneNo()
 		{ return phoneNo;}

	// set accessors
	public void setName(String newName)
		{ name = newName;}
	public void setAddress(String newAddress)
		{ address = newAddress;}
	public void setPhoneNo(String newPhoneNo)
		{ phoneNo = newPhoneNo;}
	public String tellAboutSelf()
		{ return (getName() + ", " + getAddress() + ", " + getPhoneNo());}
} 
