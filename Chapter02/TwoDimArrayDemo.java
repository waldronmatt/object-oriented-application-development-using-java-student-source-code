public class TwoDimArrayDemo
{
	public static void main(String[] args)
	{	
		// declare an int array with 5 rows & 2 columns
		int testScoreTable[][] = new int [5][2];
	
		// populate the elements in column 1
		testScoreTable[0][0] = 75;
		testScoreTable[1][0] = 80;
		testScoreTable[2][0] = 70;
		testScoreTable[3][0] = 85;
		testScoreTable[4][0] = 90;
		// populate the elements in column 2
		testScoreTable[0][1] = 80;
		testScoreTable[1][1] = 90;
		testScoreTable[2][1] = 60;
		testScoreTable[3][1] = 95;
		testScoreTable[4][1] = 100;
	
		// compute the average test score using nested for loop
		double average;
		// outer loop goes across the columns
		for(int col = 0; col < 2; col++)			
		{
 			average = 0;
			// inner loop goes down the rows
			for(int row = 0; row < 5; row++)
				{average += testScoreTable[row][col];}
			// compute the column average
			average = average / 5;
			System.out.println("test " + (col + 1) + " average is " + average);
		} // end of outer loop	
	}
}





