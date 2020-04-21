package Models;

public class Order {
	int orderID;
	int orderNumber;
	int personID;
	String orderDate;
	public Order(int orderID, int orderNumber, int personID, String orderDate) {
		super();
		this.orderID = orderID;
		this.orderNumber = orderNumber;
		this.personID = personID;
		this.orderDate = orderDate;
	}
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public int getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	public int getPersonID() {
		return personID;
	}
	public void setPersonID(int personID) {
		this.personID = personID;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	



}
