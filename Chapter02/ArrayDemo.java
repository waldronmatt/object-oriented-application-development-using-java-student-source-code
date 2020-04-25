public class ArrayDemo
{
	public static void main(String[] args)
	{	// declare an int array with 5 elements
		int testScores[] = new int [5];
			
		// populate the elements
		testScores[0] = 75;
		testScores[1] = 80;
		testScores[2] = 70;
		testScores[3] = 85;
		testScores[4] = 90;
		
		// display the element contents 
		System.out.println("test score 1 = " + testScores[0]);
		System.out.println("test score 2 = " + testScores[1]);
		System.out.println("test score 3 = " + testScores[2]);
		System.out.println("test score 4 = " + testScores[3]);
		System.out.println("test score 5 = " + testScores[4]);
			
		// compute average using length attribute
		double average = 0;
		for(int i = 0; i < testScores.length; i++)
			{average += testScores[i];}
		average = average / 5;
		System.out.println("average score is " + average);
	}
}





