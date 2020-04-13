<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="Controllers.ItemDAO"%>
<%@ page import="Models.Items"%>
<%@ page import="Controllers.Landing"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cart</title>
</head>
<body onLoad="document.forms[0].submit()">
	<%
		session = request.getSession(false);
		ArrayList<Items> cart = (ArrayList<Items>) session.getAttribute("cart");

	%>

	<h1> <%= session.getAttribute("name") %>'s Cart </h1>
	<br>
	
	<%if(session.getAttribute("accountType").equals("admin")){
		%>
		<a href ="Admin.jsp">Admin</a>
	<%}%>


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

	<%for (int i = 0; i < cart.size(); i++){ %>
		<tr bgcolor="#DEB887">
		
			<td><%=cart.get(i).getSku()%></td>
			<td><a href="viewProduct.jsp?id=<%=cart.get(i).getSku()%>"><%=cart.get(i).getName()%></a></td>
			<td><%=cart.get(i).getManufacturer()%></td>
			<td><%=cart.get(i).getPrice()%></td>
			<td><%=cart.get(i).getCategory()%></td>
			<td><img src="C:/Users/whitec/Desktop/spAssets/<%=cart.get(i).getImagePath() %>" style="width:150px;height:150px;"></td> 
		</tr>
<%}%>
	</table>
</body>
</html>