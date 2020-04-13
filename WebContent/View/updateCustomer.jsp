<%@ page import="java.util.ArrayList"%>
<%@ page import="Controllers.CustomerDAO"%>
<%@ page import="Models.Users"%>

<%
	int id = Integer.parseInt(request.getParameter("id"));
	CustomerDAO fb = new CustomerDAO();
	Users user = fb.readIndividual(id);
%>

<title>Update Details</title>



<form action="UpdateProduct" method="POST">
	<label for="id">Product SKU:</label> <input type="text" id="id"
		name="id" size="70" value="<%=user.getId()%>" readonly><br> <br>  
	<label for="name">Product Name:</label> <input type="text" id="name"
		name="name" size="70" value="<%=user.getName()%>"><br> <br>
	  <label for="manu">Manufacturer:</label> <input type="text" id="manu"
		name="manu" size="70" value="<%=user.getEmail()%>"><br>
	<br>   <label for="price">Price:</label> <input type="text"
		id="price" name="price" size="70" value="<%=user.getAddress()%>"><br>
	<br>   <input type="submit" value="Update Customer Details">
</form>
<p>
<button id = delete onClick="deleteFunction(<%Integer.parseInt(request.getParameter("id"));%>);">Delete Product</button>


<script>
	function deleteFunction(id){
		<%fb.delete(id);%>
		<%response.sendRedirect(request.getContextPath() + "/View/productSearch.jsp");%>
	}
</script>