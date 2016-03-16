package sugukuru.bean;

/**
 *
 * @author k.yamada
 *
 */
public class Product {
	private String id;
	private String categoryId;
	private String name;
	private int price;
	private int stock;
	private String detail;

	public Product(String id, String categoryId, String name, int price,int stock,String detail) {
		this.id 		= id;
		this.categoryId = categoryId;
		this.name 		= name;
		this.price 		= price;
		this.stock 		= stock;
		this.detail 	= detail;
	}

	public Product(String name, String categoryId, int price, String detail) {
		this.categoryId = categoryId;
		this.name 		= name;
		this.price 		= price;
		this.detail 	= detail;
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

	public int getStock() {
		return stock;
	}

	public String getDetail(){
		return detail;
	}
}
