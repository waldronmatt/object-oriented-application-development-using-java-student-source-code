<html>
<head>
<%@ page import="Bradshaw.*" %>
<% Customer aCustomer = 
     (Customer) getServletContext().getAttribute("customer"); %>
<title>Bradshaw Marina Customer Options</title>
</head>
<body>
<center>
<h1><em><font color = "red">Bradshaw Marina</font></em></h1>
<hr>
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
<h2>Hello
<%= aCustomer.getName() %>!
</h2>
<p>
<h3><strong>Would you like to:</strong></h3>
<table>
<tr><td><li>
<a href="ShowBoatInfo.jsp">View information about your boat</a>
</li></td></tr>
<tr><td><li>
<a href="ShowLeaseInfo.jsp">View information about your lease</a>
</li></td></tr>
<tr><td><li>
<a href="index.html"> Return to the Bradshaw Marina home page</a>
</li></td></tr>
</table>
</p>
</center>
</body>
</html>


