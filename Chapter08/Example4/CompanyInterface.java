// Interface to use for all Bradshaw PD classes  
// Requires tellAboutSelf method
// Plus constants for basic company information

public interface CompanyInterface
{
	// all classes must implement this method
	public abstract String tellAboutSelf();
	
	// constants with values all classes might need
	public static final String COMPANY_NAME = 
					"Bradshaw Marina"; 
	public static final String COMPANY_ADDRESS = 
					"PO Box 101 Lake Clinton"; 
	public static final String COMPANY_PHONE = 
					"(419) 555-8765"; 
}
