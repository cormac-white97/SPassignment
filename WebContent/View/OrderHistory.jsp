<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="Controllers.DaoFacade"%>
<%@ page import="Models.Items"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Oder History</title>
</head>
<body>
	<%
		int id = Integer.parseInt(request.getParameter("id"));
		DaoFacade df = new DaoFacade();
		ArrayList<Items> history =(ArrayList<Items>) df.readObject("itemAll", id, response);

	%>
	
	
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
			<td><b>Stock:</b></td>
		</tr>

		<%
			for (int i = 0; i < history.size(); i++) {
		%>
		<tr bgcolor="#DEB887">

			<td><%=history.get(i).getSku()%></td>
			<td><a
				href="viewProduct.jsp?id=<%=history.get(i).getSku()%>&mode=redirect';"><%=history.get(i).getName()%></a></td>
			<td><%=history.get(i).getManufacturer()%></td>
			<td><%=history.get(i).getPrice()%></td>
			<td><%=history.get(i).getCategory()%></td>
			<td><img
				src="/SPassignment/spAssets/<%=history.get(i).getImagePath()%>"
				style="width: 150px; height: 150px;"></td>
			<td><%=history.get(i).getStock()%></td>

		</tr>
		<%
			}
		%>
	</table>
</body>
</html>