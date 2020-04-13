<%@ page import="java.util.ArrayList"%>
<%@ page import="Controllers.ItemDAO"%>
<%@ page import="Models.Items"%>

<%
	int id = Integer.parseInt(request.getParameter("id"));
	ItemDAO fb = new ItemDAO();
	Items item = fb.readItem(id);
%>

<script type="text/javascript" src="Delete.js"></script>
<title>Update Details</title>



<form action="UpdateProduct" method="POST">
	<label for="id">Product SKU:</label> <input type="text" id="id"
		name="id" size="70" value="<%=item.getSku()%>" readonly><br>
	<br>   <label for="name">Product Name:</label> <input type="text"
		id="name" name="name" size="70" value="<%=item.getName()%>"><br>
	<br>   <label for="manu">Manufacturer:</label> <input type="text"
		id="manu" name="manu" size="70" value="<%=item.getManufacturer()%>"><br>
	<br>   <label for="price">Price:</label> <input type="text"
		id="price" name="price" size="70" value="<%=item.getPrice()%>"><br>
	<br>   <label for="category">Category:</label> <input type="text"
		id="category" name="category" size="70"
		value="<%=item.getCategory()%>"><br> <br> <label
		for="stock">Stock:</label> <input type="text" id="stock"
		name="stock" size="70" value="<%=item.getStock()%>"><br><br><label
		for="image">Image Path:</label> <input type="text" id="image"
		name="image" size="70" value="<%=item.getImagePath()%>"><br>
	<br>   <input type="submit" value="Update Product Details">
</form>
<p>
	<a
		href="/SPassignment/View/updateProduct.jsp?id=<%=item.getSku()%>&mode=Delete">
		>delete</a>


	<script>
		function deleteItem() {
	<%String mode = request.getParameter("mode");
			if (request.getParameter("mode").equals("Delete")) {
				fb.delete(id);
				response.sendRedirect(request.getContextPath() + "/View/productSearch.jsp");
			}%>
		}
	</script>