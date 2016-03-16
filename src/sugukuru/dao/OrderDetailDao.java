package sugukuru.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sugukuru.bean.CartProduct;
import sugukuru.bean.Product;
import sugukuru.bean.ProductOrder;

public class OrderDetailDao extends Dao{

	/**
	 * orderDetailに情報を格納
	 */
	public void addOrderDetail(String orderId,List<CartProduct> products){
		getConnection();
		try {
			for(CartProduct p : products){
				st = conn.prepareStatement("INSERT INTO DTB_CUSTOMER_ORDER_DETAIL ("
						+ "CUSTOMER_ORDER_ID,"
						+ " PRODUCT_ID,"
						+ " QUANTITY,"
						+ " PRICE"
						+ ") VALUES (?,?,?,?)");
				st.setString(1, orderId);
				st.setString(2, p.getId());
				st.setInt(3, p.getQuantity());
				st.setInt(4, p.getPrice());
				st.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally{
			connectionClose();
		}
	}

	public List<ProductOrder> getOrderDetail(String type,String orderId){
		getConnection();
		List<ProductOrder> products = new ArrayList<ProductOrder>();
		try {
			st = conn.prepareStatement("SELECT * FROM DTB_"+ type +"_ORDER_DETAIL dod "
					+ "LEFT JOIN DTB_PRODUCTS dp "
					+ "ON (dod.PRODUCT_ID = dp.PRODUCT_ID) "
					+ "WHERE CUSTOMER_ORDER_ID = ?");
			st.setString(1, orderId);
			rs = st.executeQuery();
			while(rs.next()){
				String id		  = rs.getString("product_id");
				String name 	  = rs.getString("product_name");
				int quantity	  = rs.getInt("quantity");
				int price		  = rs.getInt("price");
				ProductOrder p = new ProductOrder(id,name,quantity,price);
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
}
