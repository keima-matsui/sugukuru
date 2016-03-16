package sugukuru.model;

import java.util.ArrayList;
import java.util.List;

import sugukuru.bean.CartProduct;
import sugukuru.dao.CartDao;
import sugukuru.dao.OrderDao;
import sugukuru.dao.OrderDetailDao;

public class PaymentHelper {

	/**
	 * orderテーブルに注文者の情報を格納する
	 * @param id
	 * @param phoneNumber
	 * @param address
	 * @param ward
	 * @param postAddress
	 * @param firstName
	 * @param lastName
	 * @param firstName2
	 */
	public void orderRegist(String id,String type, String lastName, String firstName, int postAddress, int ward, String address, String phoneNumber){
		OrderDao oDao = new OrderDao();

		//合計金額を計算
		CartDao cDao = new CartDao();
		List<CartProduct> cartInProducts = new ArrayList<CartProduct>();
		cartInProducts = cDao.getToCart(id,"customer");
		int totalAmount = this.getTotalAmount(cartInProducts);

		//orderを追加
		String orderId = oDao.addOrder(id,lastName,firstName,postAddress,ward,address,phoneNumber,totalAmount);

		//orderDetailmを追加
		this.cartToOrderDetail(orderId,id);
	}

	/**
	 * カートの中身を確認してorderdetailテーブルに追加
	 */
	public void cartToOrderDetail(String orderId,String id){
		CartDao cDao = new CartDao();
		List<CartProduct> cartInProducts = new ArrayList<CartProduct>();

		//カートの商品を取得
		cartInProducts = cDao.getToCart(id,"customer");

		//商品の情報をorderDetailに格納
		OrderDetailDao odDao = new OrderDetailDao();
		odDao.addOrderDetail(orderId,cartInProducts);

		//カートを空にする
		cDao.cartClear(id,"customer");
	}

	/**
	 * 合計金額を計算する
	 */
	public int getTotalAmount(List<CartProduct> products){

		int sum = 0;

		for(CartProduct p : products){
			sum += p.getPrice() * p.getQuantity();
		}

		return sum;
	}
}
