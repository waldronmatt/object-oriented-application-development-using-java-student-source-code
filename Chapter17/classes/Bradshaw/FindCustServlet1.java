// Figure 17-4
// FindCustServlet1.java

package Bradshaw;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class FindCustServlet1 extends HttpServlet {

	public void doPost(	HttpServletRequest request,
								HttpServletResponse response )
					throws ServletException, IOException
	{
		String cName,cAddress, cPhone;

		// establish output stream for response to client
		PrintWriter output = response.getWriter();
		response.setContentType( "text/html" );

		// get phone number from HTML page
		cPhone = request.getParameter( "Phone" );
		if (cPhone.equals(""))
		{
			output.println("<h3> Please click the Back button and " +
								"fill in the Phone Number field.</h3>" );
		}
		else
		{
			try
			{	// connect to the database
				Customer aCustomer = null;
				Connection c = CustomerConnect.initialize();
      		Customer.initialize(c);
		      // retrieve the desired record
		      aCustomer = Customer.find(cPhone);
		      // format a response to the client
		      output.print("<h2>Record found!</h2><br>" +
		      				 "Name: " + aCustomer.getName() + "<br>" +
						       "Address: " + aCustomer.getAddress() +
						       "<br>" + "Phone: " + aCustomer.getPhoneNo());
			}
			catch (NotFoundException e) {
				output.println("<h3>Customer not found. " +
									"Please click the Back button and " +
									"try again!</h3>");
			}
		}
		output.close();
 	}
}
