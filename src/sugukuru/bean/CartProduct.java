package sugukuru.bean;

public class CartProduct {
	private String id;
	private String categoryId;
	private String name;
	private int price;
	private int quantity;

	public CartProduct(String id, String categoryId, String name, int price, int quantity) {
		this.id = id;
		this.categoryId = categoryId;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public String getId() {
		return id;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}
}
