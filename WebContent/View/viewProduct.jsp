<%@ page import="java.util.ArrayList"%>
<%@ page import="Controllers.DaoFacade"%>
<%@ page import="Controllers.productState"%>
<%@ page import="Models.Items"%>

<a href="/SPassignment/View/cart.jsp?mode=redirect">My Cart</a>
</div>
</div>

<%
	int id = Integer.parseInt(request.getParameter("id"));
	DaoFacade df = new DaoFacade();
	productState ps = new productState();
	Items item = (Items) df.readObject("itemIndiv", id, response);
	ArrayList<Items> cart = (ArrayList<Items>) session.getAttribute("cart");
	ArrayList<String> reviews = (ArrayList<String>) ps.checkState("review", id, response);
%>

<title>View Product</title>

<img src="/SPassignment/spAssets/<%=item.getImagePath()%>"
	style="width: 250px; height: 300px;">




<div class="elementor-widget-wrap">
	<div>
		<div>
			<h1
				class="product_title entry-title elementor-heading-title elementor-size-default">
				<%=item.getName()%>
			</h1>
		</div>
	</div>
	&euro;<%=item.getPrice()%>

</div>
<a
	href="/SPassignment/View/viewProduct.jsp?id=<%=item.getSku()%>&mode=Add">
	Add to basket</a>



<form action="addReview" method="POST">
<input type="text" id="id" name="id" size="70" value="<%=request.getParameter("id")%>" hidden readonly>
	<textarea rows="4" cols="50" name="comment" form="usrform" id = "comment">
</textarea>
	<input type="submit">
</form>
<br>




<table id="productTable" align="center" cellpadding="5" cellspacing="5"
		border="1">
		<tr>

		</tr>
		<tr bgcolor="#A52A2A">
			<td><b>Review</b></td>
			
		</tr>

		<%
			for (int i = 0; i < reviews.size(); i++) {
		%>
		<tr bgcolor="#DEB887">

			<td><%=reviews.get(i)%></td>
		</tr>
		<%
			}
		%>
	</table>




<script>
	function updateCart() {
<%String mode = request.getParameter("mode");
			if (mode.equals("Add")) {
				df.updateCart(item, session);
				response.sendRedirect(
						request.getContextPath() + "/View/viewProduct.jsp?id=" + item.getSku() + "&mode=redirect");
			}%>
	}
</script>
<!--

//-->
