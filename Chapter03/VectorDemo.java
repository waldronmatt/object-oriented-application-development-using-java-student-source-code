import java.util.Vector;
public class VectorDemo
{
	public static void main(String[] args)
	{	
		// declare a Vector instance with 3 elements 
		Vector aVector = new Vector(3);
		// create String instances 
		String s1 = new String("Hello");
		String s2 = new String("World");
		String s3 = new String("Wide");
		String s4 = new String("Web");
		
		// populate the first two elements
		aVector.add(s1);
		aVector.add(s2);
			
		System.out.println("number of elements = " + aVector.capacity()); 
		System.out.println(aVector.size() + " are populated");		
		 
		// search for "Hello"
		System.out.println(aVector.contains("Hello"));
		
		// populate two more elements
		aVector.add(s3);
		aVector.add(s4);
		
		// loop to display contents
		for(int i = 0; i < aVector.size(); i++)
			{ System.out.println(aVector.get(i));}	
	}
}





