// Chapter 6
// illustrate formatted output

import java.text.*;
public class TesterThree
{
	public static void main(String args[])
  	{
		// create a Slip instance
		Slip aSlip = new Slip(3, 14, 30);

		// compute lease fee 
		double fee = aSlip.leaseSlip();
						
		// illustrate currency format 
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
		System.out.println("Currency: " + currencyFormat.format(fee));	

		// illustrate DecimalFormat
		DecimalFormat decimalFormat = new DecimalFormat("##,##0.00");
		System.out.println("Decimal: " + decimalFormat.format(fee));	

		// illustrate number format
		NumberFormat noDollarFormat = NumberFormat.getInstance();
		System.out.println("number: " + noDollarFormat.format(fee));	
	
		// illustrate escape sequences
		System.out.println("Before tab \t after tab");
		System.out.println("Before new line \n after new line");	
		System.out.println("Display double quote \" ");	
  }
} 
