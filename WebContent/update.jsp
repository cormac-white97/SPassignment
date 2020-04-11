<%@ page import="java.util.ArrayList"%>
<%@ page import="SPassignment.SQLConnection"%>
<%@ page import="SPassignment.Items"%>

<%
	int id = Integer.parseInt(request.getParameter("id"));
	SQLConnection fb = new SQLConnection();
	Items item = fb.getSingleItem(id);
	String test = "test";
%>

<title>Update Details</title>



<form action="update"  method="POST">
	  <label for="name">Product Name:</label> <input type="text" id="name"
		name="name" size="70" value="<%=item.getName()%>"><br>
	<br>   <label for="manu">Manufacturer:</label> <input type="text"
		id="manu" name="manu" size="70" value="<%=item.getManufacturer()%>"><br>
	<br>   <label for="price">Price:</label> <input type="text"
		id="price" name="price" size="70" value="<%=item.getPrice()%>"><br>
	<br>   <label for="category">Category:</label> <input type="text"
		id="category" name="category" size="70"
		value="<%=item.getCategory()%>"><br>
	<br> <label for="image">Image Path:</label> <input type="text"
		id="image" name="image" size="70" value="<%=item.getImagePath()%>"><br>
	<br>   <input type="submit" value="Update Product Details">
</form>
