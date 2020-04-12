<%@ page import="java.util.ArrayList"%>
<%@ page import="SPassignment.ItemDAO"%>
<%@ page import="SPassignment.Items"%>

<%
	//ItemDAO fb = new ItemDAO();
	//Items item = fb.readItem(id);
%>

<title>Add a product</title>



<form action="addProduct" method="POST">
	  <label for="name">Product Name:</label> <input type="text" id="name"
		name="name" size="70"><br> <br>   <label for="manu">Manufacturer:</label> <input type="text" id="manu" name="manu" size="70"><br> <br>
	  <label for="price">Price:</label> <input type="text" id="price"
		name="price" size="70"><br> <br>   <label
		for="category">Category:</label> <input type="text" id="category"
		name="category" size="70"> <br> <br> <label
		for="image">Image Path:</label> <input type="text" id="image"
		name="image" size="70"> <br> <br> <input
		type="submit" value="Add Product">
</form>