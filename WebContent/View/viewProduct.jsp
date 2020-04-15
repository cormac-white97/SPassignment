<%@ page import="java.util.ArrayList"%>
<%@ page import="Controllers.ItemDAO"%>
<%@ page import="Models.Items"%>

<a href="/SPassignment/View/cart.jsp?mode=redirect">My Cart</a>
</div>
</div>

<%
	int id = Integer.parseInt(request.getParameter("id"));
	ItemDAO fb = new ItemDAO();
	Items item = fb.readItem(id);
	ArrayList<Items> cart = (ArrayList<Items>) session.getAttribute("cart");
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



<script>
	function updateCart() {
<%String mode = request.getParameter("mode");
			if (mode.equals("Add")) {
				fb.updateCart(item, session);
				response.sendRedirect(request.getContextPath() + "/View/viewProduct.jsp?id=" + item.getSku() + "&mode=redirect");
			}%>
	}
</script>
<!--

//-->
