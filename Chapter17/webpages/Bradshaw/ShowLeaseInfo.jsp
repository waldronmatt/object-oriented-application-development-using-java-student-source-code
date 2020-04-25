<html>
<head>
	<title>View Lease Information</title>
</head>
<%@ page import="Bradshaw.*" %>
<%@ page import="java.text.*" %>
<% ServletContext sc = getServletContext();
   AnnualLease aLease = (AnnualLease) sc.getAttribute( "lease" ); 
   Slip aSlip = (Slip) sc.getAttribute( "slip" );
   Dock aDock = (Dock) sc.getAttribute( "dock" );
   boolean electricity = aDock.getElectricity();
   boolean water = aDock.getWater();
   String services = electricity?"Electricity":"No Electricity";
   services += ", ";
   services += water?"Water":"No Water";
   DecimalFormat twoDigits = new DecimalFormat("$#,##0.00");
   DateFormat x = DateFormat.getDateInstance(DateFormat.MEDIUM);
%>
<body>
<center>
<hr>
<img src = "images/sabtart_07.gif">
<img src = "images/stardrag_04.gif">
<img src = "images/sabtart_22.gif">
<Img src = "images/sabtart_01.gif">
<img src = "images/sabtart_04.gif">
<img src = "images/sabtart_06.gif">
<img src = "images/sabtart_19.gif">
<img src = "images/stardrag_01.gif">
<img src = "images/sabtart_32.gif">
<Img src = "images/stardrag_08.gif">
<hr>
<h2>Your lease is for Slip <%= aSlip.getNo() %>, Dock <%= aDock.getId() %>.</h2>
<form>
<table border=0 bgcolor="#FAFADD" cellpadding=2>

<tr>
<td><strong>Start Date</strong></td>
<td><input type="text"
     value="<%= x.format(aLease.getStartDate()) %>"  size=25>
     </td>
</tr>
<tr>
<td><strong>Lease Amount</strong></td>
<td><input type="text"
     value="<%= twoDigits.format(aLease.getAmount()) %>" size = 25>
</td>
</tr>
<tr>
<td><strong>Balance Due</strong></td>
<td><input type="text"
     value="<%= twoDigits.format(aLease.getBalanceDue()) %>" size = 25>
</td>
</tr>
<tr>
<td><strong>Slip Width</strong></td>
<td><input type="text"
      value="<%= aSlip.getWidth() %>"  size = 25>
</td>
</tr>
<tr>
  <td><strong>Slip Length</strong></td>
   <td><input type="text"
        value="<%= aSlip.getSlipLength() %>" size = 25 >
        </td>
 </tr>
 <tr>
   <td><strong>Dock Location</strong></td>
   <td><input type="text"
        value="<%= aDock.getLocation() %>" size = 25>
        </td>
 </tr>
 <tr>
    <td><strong>Dock Services</strong></td>
    <td><input type="text"
         value="<%= services %>" size = 25>
         </td>
 </tr>
 </table>
<p>Press the <strong>Back</strong> button to return to previous page.</p>
</center>
</form>
</p>
</body>
</html>

