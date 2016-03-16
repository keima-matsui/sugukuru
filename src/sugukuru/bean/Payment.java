package sugukuru.bean;

public class Payment {

	private String orderId;
	private String id;
	private String name;
	private String orderDate;
	private String totalAmount;
	
	public Payment(String orderId, String id, String name, String orderDate, String totalAmount) {
		super();
		this.orderId = orderId;
		this.id = id;
		this.name = name;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
	}
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}
	
}
