// FindCustomerServlet2.java
// Three-Tier Example

package Bradshaw;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class FindCustomerServlet2 extends HttpServlet {

   public void doPost( HttpServletRequest req,
		HttpServletResponse res )throws ServletException, IOException
   {
      String cName,cAddress, cPhone;

		// establish output stream for response to client
      PrintWriter output = res.getWriter();
      res.setContentType( "text/html" );

		// get phone number from HTML page
      cPhone = req.getParameter( "Phone" );

		try {
			// connect to the database
			Customer aCustomer = null;
			Connection c = CustomerConnect.initialize();
      	Customer.initialize(c);
      	// retrieve the desired record
      	aCustomer = Customer.find(cPhone);
      	//format response to the client
			output.print("<H2>Record found.</H2><BR>" +
							"Name:    " + aCustomer.getName() + "<BR>" +
							"Address: " + aCustomer.getAddress() + "<BR>" +
							"Phone:   " + aCustomer.getPhoneNo());
		}
		catch (NotFoundException e) {
			output.println("<H3>Customer not found. " +
								"Please click the Back button and " +
								"try again!</H3>");
		}
		output.close();
 	}
}

