package sugukuru.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import sugukuru.bean.CartProduct;

/**
 * 酷い糞コード見るのも嫌になるほどだよ
 * @author k.yamada
 *
 */
public class CartDao extends Dao{

	private Logger log = Logger.getLogger (CartDao.class.getName ());

	/**
	 * ToDo 責務を２つ持っているのがちょっと．．．　余裕がアレば分解する
	 * @param cId
	 * @param pId
	 * @param quantity
	 * @param type
	 */
	public void addToCart(String cId,String pId,int quantity,String type){
		getConnection();

		//すでにカート内に商品があるかチェック
		int haveQuantity = checkInCart(cId,pId,type);

		//なかったら商品に入れる、あれば商品を足してカートに入れる
		if(haveQuantity == 0){
			try {
				st = conn.prepareStatement("INSERT INTO DTB_"+ type +"_CART VALUES(?,?,?)");
				st.setString(1, cId);
				st.setString(2, pId);
				st.setInt(3, quantity);
				st.executeUpdate();
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			} finally{
				connectionClose();
			}
		}else{
			quantity += haveQuantity;
			try {
				st = conn.prepareStatement("UPDATE DTB_"+ type +"_CART SET quantity = ? WHERE "+ type +"_id = ? AND product_id = ?");
				st.setInt(1, quantity);
				st.setString(2, cId);
				st.setString(3, pId);
				st.executeUpdate();
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			} finally{
				connectionClose();
			}
		}
	}

	public int checkInCart(String cId,String pId,String type){
		int quantity = 0;
		try {
			st = conn.prepareStatement("SELECT quantity FROM DTB_"+ type +"_CART WHERE "+ type +"_id = ? AND product_id = ?");
			st.setString(1, cId);
			st.setString(2, pId);
			rs = st.executeQuery();
			while(rs.next()){
				quantity = rs.getInt("quantity");
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return quantity;
	}

	public List<CartProduct> getToCart(String cId,String type){
		getConnection();
		List<CartProduct> products = new ArrayList<CartProduct>();
		try {
			st = conn.prepareStatement("SELECT * FROM DTB_"+ type +"_CART dcc LEFT JOIN DTB_PRODUCTS dp ON dcc.product_id = dp.product_id WHERE "+ type +"_id = ?");
			st.setString(1, cId);
			rs = st.executeQuery();
			while(rs.next()){
				String id		  = rs.getString("product_id");
				String categoryId = String.format("%02d",rs.getInt("category_id"));
				String name 	  = rs.getString("product_name");
				int price		  = rs.getInt("price");
				int quantity	  = rs.getInt("quantity");
				CartProduct p = new CartProduct(id,categoryId,name,price,quantity);
				products.add(p);
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally{
			connectionClose();
		}
		return products;
	}

	public void cartClear(String id,String type){
		getConnection();
		try {
			st = conn.prepareStatement("DELETE FROM DTB_"+ type +"_CART WHERE "+ type +"_id = ?");
			st.setString(1, id);
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally{
			connectionClose();
		}
	}
}
