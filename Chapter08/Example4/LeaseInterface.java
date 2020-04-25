// Interface to use with Lease classes  
// that requires calculateFee method 

public interface LeaseInterface
{
	// method all lease subclasses must include
	public abstract double calculateFee(int aWidth);
		
}
