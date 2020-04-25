// LoginServlet - Chapter 17
package Bradshaw;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class LoginServlet extends HttpServlet {

	public void doPost(	HttpServletRequest request,
								HttpServletResponse response) 
					throws ServletException, IOException
	{
		try
		{ // connect to database
			Connection c = CustomerConnect.initialize();
			Customer.initialize(c);
			AnnualLease.initialize(c);
			Dock.initialize(c);

 			try 
			{	// retrieve data from DB
				String phone = request.getParameter( "Phone" );
				Customer aCustomer = Customer.find(phone);
				Boat aBoat = aCustomer.getBoat();
				AnnualLease aLease = AnnualLease.find(phone);
				Slip aSlip = aLease.getSlip();
				int dockId = aSlip.getDockId();
				Dock aDock = Dock.find(dockId);
				// get the ServletContext and set attributes
				ServletContext sc = getServletContext();
				sc.setAttribute("customer", aCustomer);
				sc.setAttribute("boat", aBoat);
				sc.setAttribute("lease", aLease);
				sc.setAttribute("dock", aDock);
				sc.setAttribute("slip", aSlip);
				// redirect the response to a JSP
				response.sendRedirect
					("http://localhost:8080/Bradshaw/VerifyCustInfo.jsp");
			}
			catch( NotFoundException nfe)
			{
				String line1 =	"<h2>The phone number you entered"+
				 					" is not in our database!</h2>";
				String line2 =	"<p>Please press the <strong>BACK" +
				 					"</strong> button and try again.</p>";
      		formatErrorPage(line1, line2, response);
		 	}
		}
   	catch (Exception e) //not connected
 		{
			String line1="<h2>A network error has occurred!</h2>";
			String line2="<p>Please notify your system " +
									"administrator.</p>";
			formatErrorPage(line1, line2,response);
		}
	}

	public void formatErrorPage( String first, String second,
		HttpServletResponse response) throws IOException
	{
	 	PrintWriter output = response.getWriter();
		response.setContentType( "text/html" );
		output.println(first);
		output.println(second);
		output.close();
	}
}