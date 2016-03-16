package sugukuru.bean;

import java.util.List;

public class Order {
	private String id;
	private String orderdName;
	private String date;
	private int totalAmount;
	private int status;
	private int postAddress;
	private int ward_id;

	private List<ProductOrder> orderProducts;

	public Order(String id, String orderdName, String date, int totalAmount, int status) {
		super();
		this.id			 = id;
		this.orderdName	 = orderdName;
		this.date		 = date;
		this.totalAmount = totalAmount;
		this.status		 = status;
	}


	public String getId() {
		return id;
	}
	public String getOrderdName() {
		return orderdName;
	}
	public String getDate() {
		return date;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public int getStatus(){
		return status;
	}

	/**
	 * 購入商品一覧にはセッターとゲッターを設ける。※DaoやBeanを使い回すため
	 * @return
	 */
	public List<ProductOrder> getOrderProducts() {
		return orderProducts;
	}
	public void setOrderProducts(List<ProductOrder> orderProducts) {
		this.orderProducts = orderProducts;
	}
}
