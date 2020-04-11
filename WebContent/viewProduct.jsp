<%@ page import="java.util.ArrayList"%>
<%@ page import="SPassignment.SQLConnection"%>
<%@ page import="SPassignment.Items"%>

<div id="w3lDemoBar" class="w3l-demo-bar">
	<a href="https://w3layouts.com/?p=22079" ga-on="click"
		ga-event-category="Grocery Store Template" ga-event-action="view"
		ga-event-label="Grocery Store - view"> 
	<div class="w3l-template-options">
		</a> <a href="https://w3layouts.com/?p=22079" class="w3l-buy"
			ga-on="click" ga-event-category="Grocery Store Template"
			ga-event-action="Buy Now" ga-event-label="Grocery Store - Buy"
			title="Remove Backlink from template"> <span
			class="w3l-icon -buy"> <svg xmlns="http://www.w3.org/2000/svg"
					width="24" height="24" viewBox="0 0 24 24">
				<path
						d="M7 18c-1.1 0-1.99.9-1.99 2S5.9 22 7 22s2-.9 2-2-.9-2-2-2zM1 2v2h2l3.6 7.59-1.35 2.45c-.16.28-.25.61-.25.96 0 1.1.9 2 2 2h12v-2H7.42c-.14 0-.25-.11-.25-.25l.03-.12.9-1.63h7.45c.75 0 1.41-.41 1.75-1.03l3.58-6.49c.08-.14.12-.31.12-.48 0-.55-.45-1-1-1H5.21l-.94-2H1zm16 16c-1.1 0-1.99.9-1.99 2s.89 2 1.99 2 2-.9 2-2-.9-2-2-2z"></path>
				<path d="M0 0h24v24H0z" fill="none"></path></svg>
		</span> <span class="w3l-text">Cart</span>
		</a>
	</div>
</div>

<%
 	int id = Integer.parseInt(request.getParameter("id"));
	SQLConnection fb = new SQLConnection();
	Items item = fb.getSingleItem(id);
	String test = "test";
%>

<title>asasdfasdf</title>

<img
	src="C:/Users/whitec/Desktop/spAssets/<%=item.getImagePath()%>"
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
	class="single_add_to_cart_button button alt">Add to basket</button>
