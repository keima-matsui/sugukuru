package sugukuru.bean;

public class ProductOrder {
	private String id;
	private String name;
	private int quantity;
	private int price;

	public ProductOrder(String id, String name, int quantity, int price) {
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getPrice() {
		return price;
	}


}
