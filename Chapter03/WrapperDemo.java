public class WrapperDemo
{
	public static void main(String[] args)
	{	   
		// declare a primitive
		double d = 1.1;
		// create wrapper instance from primitive
		Double doubleWrapper = new Double(d); 
		System.out.println("double to wrapper is " + doubleWrapper);      
		// assign wrapper contents to primitive: xxxValue instance method 
		double doublePrimitive = doubleWrapper.doubleValue();
		System.out.println("wrapper to double  is " + doublePrimitive);      
	
		// assign contents of String instance to primitive: parsexxx class method
		String firstString= new String("2.2");
		doublePrimitive = Double.parseDouble(firstString);
		System.out.println("String to primitive is " + doublePrimitive);        
		// create a String from a primitive: toString class method
		String secondString = Double.toString(doublePrimitive);
		System.out.println("primitive to String is " + secondString);
	
		// create wrapper from a String: valueOf class method
		String thirdString = new String("3.3");
		doubleWrapper = Double.valueOf(thirdString);
		System.out.println("String to wrapper is " + doubleWrapper);
		// create a String from wrapper: toString instance method
		String fourthString = doubleWrapper.toString();
		System.out.println("wrapper to String is " + fourthString);
	}
}

