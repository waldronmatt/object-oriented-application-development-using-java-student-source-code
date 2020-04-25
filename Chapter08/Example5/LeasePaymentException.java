// LeasePaymentException -- a custom Exception

public class LeasePaymentException extends Exception
{
	// attributes for custom exception
	double paymentAmount;	// the amount of the payment attempted
	AnnualLease theLease;	// reference to the lease involved 
	String exceptionMessage;// text of the message 
	
	// constructor: when instantiated by Lease instance, accepts 
	//	the amount and reference to the lease
	public LeasePaymentException(double anAmount, AnnualLease aLease)
	{
		// invoke superclass constructor 
		super("this is a custom LeasePaymentException \n");
		// assign lease reference and amount to attributes
		theLease = aLease;
		paymentAmount = anAmount;
		// construct message by asking the lease for date and balance
		exceptionMessage = " for lease starting " + 
									theLease.getStartDate() + 
									"\n with amount due " + 
									theLease.getBalanceDue() +
									" but payment made of " + anAmount;		
	}
	// override toString method of Exception to provide 
	// more complete information about the exception
	public String toString()
	{
		return super.toString() + exceptionMessage;
	}
	
	// accessor methods can be included to return 
	// specific exception information if desired
}