<%@ page import="java.util.ArrayList"%>
<%@ page import="Controllers.ItemDAO"%>
<%@ page import="Models.Items"%>

<a href="cart.jsp">My Cart </a>
</div>
</div>

<%
	int id = Integer.parseInt(request.getParameter("id"));
	ItemDAO fb = new ItemDAO();
	Items item = fb.readItem(id);
	ArrayList<Items> cart = (ArrayList<Items>) session.getAttribute("cart");
%>

<title>View Product</title>

<img src="C:/Users/whitec/Desktop/spAssets/<%=item.getImagePath()%>"
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
<button type="submit" name="add-to-cart" value="23908"
	class="single_add_to_cart_button button alt" onClick="updateCart()">Add
	to basket</button>


<script type="text/javascript">
	function updateCart() {
<%fb.updateCart(item, session);%>
	}
</script>
<!--

//-->
</script>
