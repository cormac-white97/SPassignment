<%@ page import="java.util.ArrayList"%>
<%@ page import="Controllers.DaoFacade"%>
<%@ page import="Models.Users"%>

<%
	int id = Integer.parseInt(request.getParameter("id"));
	DaoFacade df = new DaoFacade();
	Users user = (Users) df.readObject("customerIndiv",id, response);
%>

<title>Update Details</title>



<form action=UpdateCustomer method="POST">
	<label for="id">Customer ID:</label> <input type="text" id="id"
		name="id" size="70" value="<%=user.getId()%>" readonly><br>
	<br>   <label for="name">Customer Name:</label> <input type="text"
		id="name" name="name" size="70" value="<%=user.getName()%>"><br>
	<br>   <label for="email">Email:</label> <input type="text"
		id="email" name="email" size="70" value="<%=user.getEmail()%>"><br>
	<br>   <label for="address">Address:</label> <input type="text"
		id="address" name="address" size="70" value="<%=user.getAddress()%>"><br>
	<br>   <input type="submit" value="Update Customer Details">
</form>
<p>
	<a
		href="/SPassignment/View/updateProduct.jsp?id=<%=user.getId()%>&mode=Delete">
		delete</a>

	<script>
		function deleteFunction(id) {
	<%String mode = request.getParameter("mode");
			if (mode.equals("Delete")) {
				df.delete("user",id, response);
				response.sendRedirect(request.getContextPath() + "/View/viewCustomers.jsp");
			}%>
		}
	</script>