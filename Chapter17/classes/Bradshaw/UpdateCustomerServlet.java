// Figure 17-21
// UpdateCustomerServlet.java


package Bradshaw;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class UpdateCustomerServlet extends HttpServlet
{
	public void doPost(	HttpServletRequest request,
								HttpServletResponse response )
					throws ServletException, IOException
   {
	try 
	{ /* 	retrieve the customer attribute from the ServletContext
			and cast it to an object of type Customer */

			Customer aCust =
				(Customer) getServletContext().getAttribute( "customer");

			// get the name and address values from the HTML page
			String name = request.getParameter("Name");
			String addr = request.getParameter("Address");

			/* if name or address from HTML page does not match
				info in DB, update DB */
			if (!name.equals(aCust.getName()) ||
										!addr.equals(aCust.getAddress())) 
			{
				aCust.setName(name);
				aCust.setAddress(addr);
				aCust.update();
			}
			// invoke the CustomerOptions.jsp program
			response.sendRedirect
				("http://localhost:8080/Bradshaw/CustomerOptions.jsp");
		}
		catch (NotFoundException e)
		{	} //do nothing
	}
}


