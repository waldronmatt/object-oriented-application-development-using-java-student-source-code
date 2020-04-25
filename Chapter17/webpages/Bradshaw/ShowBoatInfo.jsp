<html><head>
	<title>View Boat Information</title>
</head>
<%@ page import="Bradshaw.*" %>
<% ServletContext sc = getServletContext();
   Boat aBoat = (Boat) sc.getAttribute("boat"); %>
<body>
<center>
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
<h2>Your boat is:</h2>
<form>
<table border=0 bgcolor="#FAFADD" cellpadding=2>
<tr>
<td><strong>State Registration Number</strong></td>
<td><input type="text"
     value="<%= aBoat.getStateRegistrationNo() %>" >
</td>
</tr>
<tr>
<td><strong>Length</strong></td>
<td><input type="text"
     value="<%= aBoat.getLength() %>" ></td>
</tr>
<tr>
<td><strong>Manufacturer</strong></td>
<td><input type="text"
     value="<%= aBoat.getManufacturer() %>" ></td>
</tr>
<tr>
 <td><strong>Year</strong></td>
 <td><input type="text"
      value="<%= aBoat.getYear() %>" ></td>
</tr>
<tr>
</table>
<p>Press the <strong>Back</b > button to return to previous page.</p>
</center>
</form>
</p>
</body>
</html>
