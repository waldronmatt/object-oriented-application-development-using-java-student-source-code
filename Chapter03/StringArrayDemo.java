public class StringArrayDemo
{
	public static void main(String[] args)
	{	
		
		// declare an array with 4 elements data type String
		String stringArray[] = new String[4];
		// create String instances and initialize the array elements
		stringArray[0] = new String("Hello");
		stringArray[1] = new String("World");
		stringArray[2] = new String("Wide");
		stringArray[3] = new String("Web");
		
		// display the values using a loop
		for(int i = 0; i < stringArray.length; i++)
			{ System.out.println(stringArray[i]);}
		// display the number of array elements	
		System.out.println(stringArray.length + " elements");
		
		// display the number of characters in Web	
		System.out.println("Web length is " + stringArray[3].length());
				
		// invoke toUpperCase for the first String instance
		System.out.println(stringArray[0].toUpperCase());
		
		// search for the value "Web"
		String searchValue = "Web";
		int i = 0;					
		boolean found = false;
		// loop begins
		while(i < stringArray.length && !found)
		{  
			if (searchValue.equals(stringArray[i]))
				found = true;
			else
				i++;
		} 
		if (found)
			System.out.println("found " + searchValue);
		else
			System.out.println("did not find "+ searchValue);
	}
}





