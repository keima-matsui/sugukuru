package sugukuru.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sugukuru.bean.Order;

/**
 *
 * @author k.shimazaki
 *
 */
public class OrderDao extends Dao{
	/**
	 * 決済処理
	 */
	public String addOrder(Object... obj){
		getConnection();
		String id = "";
		try {
			st = conn.prepareStatement("INSERT INTO DTB_CUSTOMER_ORDER("
					+ "CUSTOMER_ORDER_ID,"
					+ "CUSTOMER_ID,"
					+ " FIRST_NAME,"
					+ " LAST_NAME,"
					+ " POST_ADDRESS,"
					+ " WARD_ID,"
					+ " UNDER_ADDRESS,"
					+ " PHONE_NUMBER,"
					+ " TOTAL_AMOUNT"
					+ ") VALUES(DTB_CUSTOMER_ORDER_SEQ.nextval,?,?,?,?,?,?,?,?)",new String[]{"CUSTOMER_ORDER_ID"});
			this.setInsertParams(obj);
			st.execute();

			ResultSet keys = st.getGeneratedKeys();
		    try {
		        // ResultSetと同じ感じに値を取得する。
		        // ただし、カラム名指定でのアクセスは出来ないので、
		        // インデックス指定でアクセスする必要がある。
		        keys.next();
		        id = keys.getString(1);
		    } finally {
		        keys.close();
		    }
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally{
			connectionClose();
		}
		return id;
	}

	public List<Order> getCustomerOrderList(){
		getConnection();
		List<Order> orders = new ArrayList<Order>();
		try {
			st = conn.prepareStatement("SELECT * FROM DTB_CUSTOMER_ORDER ORDER BY CUSTOMER_ORDER_ID DESC");
			rs = st.executeQuery();
			while(rs.next()){
				String id 		   = rs.getString("CUSTOMER_ORDER_ID");
				String orderedName = rs.getString("LAST_NAME") + " " + rs.getString("FIRST_NAME");
				String date		   = rs.getString("ORDER_DATE");
				int totalAmount    = rs.getInt("TOTAL_AMOUNT");
				int status		   = rs.getInt("STATUS");
				Order o = new Order(id,orderedName,date,totalAmount,status);
				orders.add(o);
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally{
			connectionClose();
		}
		return orders;
	}

	public List<Order> getCompanyOrderList(){
		getConnection();
		List<Order> orders = new ArrayList<Order>();
		try {
			st = conn.prepareStatement("SELECT * FROM DTB_COMPANY_ORDER dco "
					+ "LEFT JOIN DTB_COMPANY dc "
					+ "ON (dco.company_id = dc.company_id)"
					+ "ORDER BY dco.COMPANY_ORDER_ID DESC");
			rs = st.executeQuery();
			while(rs.next()){
				String id 		   = rs.getString("COMPANY_ORDER_ID");
				String orderedName = rs.getString("COMPANY_NAME");
				String date		   = rs.getString("ORDER_DATE");
				int totalAmount    = rs.getInt("TOTAL_AMOUNT");
				int status		   = rs.getInt("STATUS");
				Order o = new Order(id,orderedName,date,totalAmount,status);
				orders.add(o);
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally{
			connectionClose();
		}
		return orders;
	}

	public Order getCustomerOrder(String orderId){
		getConnection();
		Order order = null;
		try {
			st = conn.prepareStatement("SELECT * FROM DTB_CUSTOMER_ORDER WHERE CUSTOMER_ORDER_ID = ?");
			st.setString(1, orderId);
			rs = st.executeQuery();
			rs.next();
			String id 		   = rs.getString("CUSTOMER_ORDER_ID");
			String orderedName = rs.getString("LAST_NAME") + " " + rs.getString("FIRST_NAME");
			String date		   = rs.getString("ORDER_DATE");
			int totalAmount    = rs.getInt("TOTAL_AMOUNT");
			int status		   = rs.getInt("STATUS");
			order = new Order(id,orderedName,date,totalAmount,status);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally{
			connectionClose();
		}
		return order;
	}

	public Order getCompanyOrder(String orderId){
		getConnection();
		Order order = null;
		try {
			st = conn.prepareStatement("SELECT * FROM DTB_COMPANY_ORDER dco "
					+ "LEFT JOIN DTB_COMPANY dc "
					+ "ON (dco.company_id = dc.company_id)"
					+ "WHERE CUSTOMER_ORDER_ID = ?");
			st.setString(1, orderId);
			rs = st.executeQuery();
			rs.next();
			String id 		   = rs.getString("CUSTOMER_ORDER_ID");
			String orderedName = rs.getString("LAST_NAME") + " " + rs.getString("FIRST_NAME");
			String date		   = rs.getString("ORDER_DATE");
			int totalAmount    = rs.getInt("TOTAL_AMOUNT");
			int status		   = rs.getInt("STATUS");
			order = new Order(id,orderedName,date,totalAmount,status);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally{
			connectionClose();
		}
		return order;
	}
}
