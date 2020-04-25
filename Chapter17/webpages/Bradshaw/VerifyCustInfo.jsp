<html><head>
	<title>Customer Information Update</title>
	<script language="JavaScript1.2">
		function verify() {
			if (document.Input.Name.value == "") 
			{
				alert("You must enter a name!!");
				return false;
			}
			if (document.Input.Address.value == "") 
			{
				alert("You must enter an address!!");
				return false;
			}
			return true;
		}
	</script>
</head>
<%@ page import = "Bradshaw.*" %>
<% Customer aCustomer = 
		(Customer) getServletContext().getAttribute("customer"); %>
<body><center><hr>
<img src = "images/sabtart_07.gif">
<img src = "images/stardrag_04.gif">
<img src = "images/sabtart_22.gif">
<img src = "images/sabtart_01.gif">
<img src = "images/sabtart_04.gif">
<img src = "images/sabtart_06.gif">
<img src = "images/sabtart_19.gif">
<img src = "images/stardrag_01.gif">
<img src = "images/sabtart_32.gif">
<img src = "images/stardrag_08.gif">
<hr>
<h2>Customer Information Update</h2>
<p>Please confirm the information below. Make changes if needed, then
press <strong>Submit</strong>.<br>If you are not a customer, please 
return to the <a href="index.html">Bradshaw Marina</a> home page.</p>
<form name="Input" method="post" action=
	"http://localhost:8080/servlet/Bradshaw.UpdateCustomerServlet">
	<table border=0 bgcolor="#FAFADD" cellpadding=5>
	<tr>
		<td><strong>Name</strong></td>
		<td><input type="text" name = "Name" 
					value="<%= aCustomer.getName() %>"></td>
	</tr>
	<tr>
		<td><strong>Address</strong></td>
		<td><input type="text" name = "Address" 
					value="<%= aCustomer.getAddress() %>"></td>
	</tr>
	</table>
<p><input type="button" value="Submit"
	onClick = "if (verify() == true) submit();"></p>
</center></form></body></html>
