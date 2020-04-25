public class IfDemo
{
  	public static void main(String[] args)
   	{   
		int i = 1;
		// simple if		
		if (i < 10)
			{
				System.out.println("i < 10");
			}
		if (i > 0)
			System.out.println("i > 0");
		
		// if using a block of code
		if (i == 1)
			{
				System.out.println("i equals 1");
				System.out.println("Use a code block to");
				System.out.println("execute more than 1 statement");
			}
		
		// if - else
		if (i == 2)
			System.out.println("i equals 2");
		else
			{  // a block contains multiple statements 
				System.out.println("i does not equal 2");
				System.out.println("We can execute more");
				System.out.println("than one statement in");
				System.out.println("an if");
			}
		
		// compound logical expressions
		if (i == 1 || i == 2)	
			System.out.println("i equals 1 or 2");
		if (i > 0 && i < 3 )		// 
			System.out.println("i is > 0 and < 3");

		// nested if can replace compound logical expressions
		if (i > 0)
			if (i < 3)
				System.out.println("i is > 0 and < 3");

		// conditional operator
		int j = (i == 1)? 5: 6;
			  System.out.println("i equals " + i);
  	}
}	

