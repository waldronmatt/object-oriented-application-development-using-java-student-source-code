import java.util.*;
import java.text.*;

public class DateDemo
{
   public static void main(String[] args)
   {
		// create a Calendar instance
	  	Calendar aCalendar = Calendar.getInstance();

		// get today's date
		Date today = aCalendar.getTime();

		// illustrate arithmetic - add 1 to MONTH and YEAR
		aCalendar.add(Calendar.MONTH, 1);
		aCalendar.add(Calendar.YEAR, 1);
		Date aYearAndMonthLater = aCalendar.getTime();   

		// create a specific date 
		aCalendar.set(1998, Calendar.DECEMBER, 15);
		Date eleanorsBirthday = aCalendar.getTime();
	
		// get DateFormat instances in each format
		DateFormat longFormat = DateFormat.getDateInstance(DateFormat.LONG);
		DateFormat mediumFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
		DateFormat shortFormat = DateFormat.getDateInstance(DateFormat.SHORT);

		// display dates using various formats
		System.out.println("long format: today is " + longFormat.format(today));
		System.out.println("medium format: today is " + mediumFormat.format(today));
		System.out.println("short format: today is " + shortFormat.format(today));
		System.out.println("A year and month later is " + longFormat.format(aYearAndMonthLater));
		System.out.println("Eleanor's birthday is " + mediumFormat.format(eleanorsBirthday));

		// illustrate date comparison 
		if (aYearAndMonthLater.after(today))
			System.out.println("aYearAndMonthLater is after today");
		if (today.before(aYearAndMonthLater))
			System.out.println("today is before aYearAndMonthLater");
   }
}

