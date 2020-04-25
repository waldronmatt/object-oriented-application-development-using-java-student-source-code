public class ComputationDemo
{
	public static void main(String[] args)
	{  
		// illustrate arithmetic operators 
		int a = 11;
		int b = 2;
		int c = 4;
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.out.println("c = " + c);
		System.out.println("a + b = " + (a + b));
		System.out.println("a - b = " + (a - b));
		System.out.println("a * b = " + (a * b));
		System.out.println("integer division a / b = " + (a / b));
		// cast a & b to double before divide
		System.out.println("double division a / b = " + (double) a / (double) b);
		System.out.println("a % b = " + (a % b));
      
		// illustrate Math class methods 
		System.out.println("c to b power = " + Math.pow(c,b));
		System.out.println("square root of c = " + Math.sqrt(c));
	}
}

