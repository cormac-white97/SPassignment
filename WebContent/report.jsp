<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="SPassignment.SQLConnection"%>
<%@ page import="SPassignment.Items"%>
<%@ page import="SPassignment.Landing"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products</title>
</head>
<body onLoad="document.forms[0].submit()">
	<%
		SQLConnection fb = new SQLConnection();
		ArrayList<Items> items = fb.getItems();
		Landing l = new Landing();
		String name = l.getUsername();
		
		session = request.getSession(false);
		String ass = "ass";
	
	%>

	Session ID : <%= session.getAttribute("email") %>   <br/>


	<table id="productTable" align="center" cellpadding="5" cellspacing="5"
		border="1">
		<tr>

		</tr>
		<tr bgcolor="#A52A2A">
			<td><b>SKU</b></td>
			<td><b>Name</b></td>
			<td><b>Manufacturer</b></td>
			<td><b>Price</b></td>
			<td><b>Category</b></td>
			<td><b>Image</b></td>
		</tr>

	<%for (int i = 0; i < items.size(); i++){ %>
		<tr bgcolor="#DEB887">
		
			<td><%=items.get(i).getSku()%></td>
			<td><a href="viewProduct.jsp?id=<%=items.get(i).getSku()%>"><%=items.get(i).getName()%></a></td>
			<td><%=items.get(i).getManufacturer()%></td>
			<td><%=items.get(i).getPrice()%></td>
			<td><%=items.get(i).getCategory()%></td>
			<td><img src="C:/Users/whitec/Desktop/spAssets/<%=items.get(i).getImagePath() %>" style="width:150px;height:150px;"></td> 
		</tr>
<%}%>
	</table>
</body>
</html>