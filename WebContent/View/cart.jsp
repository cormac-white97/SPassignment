<%@ page import="java.util.ArrayList"%>
<%@ page import="Controllers.CustomerDAO"%>
<%@ page import="Controllers.Buy"%>
<%@ page import="java.util.ArrayList"%>

<%@ page import="Models.Items"%>
<%@ page import="Models.Users"%>

<%
	session = request.getSession(false);
	ArrayList<Items> cart = (ArrayList<Items>) session.getAttribute("cart");

	int id = (int) session.getAttribute("id");
	CustomerDAO fb = new CustomerDAO();
	Users user = fb.readIndividual(id);
	Buy b = new Buy();
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
			<td><b>Quantity</b></td>

		</tr>

		<%
			for (int i = 0; i < cart.size(); i++) {
		%>
		<tr bgcolor="#DEB887">

			<td><%=cart.get(i).getSku()%></td>
			<td><a href="viewProduct.jsp?id=<%=cart.get(i).getSku()%>"><%=cart.get(i).getName()%></a></td>
			<td><%=cart.get(i).getManufacturer()%></td>
			<td><%=cart.get(i).getPrice()%></td>
			<td><%=cart.get(i).getCategory()%></td>
			<td><img
				src="/SPassignment/spAssets/<%=cart.get(i).getImagePath()%>"
				style="width: 150px; height: 150px;"></td>
			<td><input id="number" type="number"></td>

		</tr>
		<%
			}
		%>
	</table>
	
		<a
		href="/SPassignment/View/cart.jsp?mode=purchase">
		Purchase</a>
	
		<script>
		function deleteItem() {
	<%String mode = request.getParameter("mode");
			if (mode.equals("purchase")) {
				int purchaserId = (int) session.getAttribute("id");
				b.makePayment(cart, purchaserId);
				response.sendRedirect(request.getContextPath() + "/View/report.jsp");
			}%>
		}
	</script>


