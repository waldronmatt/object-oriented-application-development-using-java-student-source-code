public class StringDemo
{
	public static void main(String[] args)
	{	
		// invoke an instance method: length
		String s = new String("Hello Again");
		System.out.println("length of s is " + s.length());

		// convert primitive to String: valueOf class method 
		int i = 5;
		String iString = String.valueOf(i);
		System.out.println("value of iString is " + iString);
		
		// illustrate additional String instance methods
		System.out.println("character at index 6 is " + s.charAt(6));
		System.out.println("uppercase is " + s.toUpperCase());
	}
}





