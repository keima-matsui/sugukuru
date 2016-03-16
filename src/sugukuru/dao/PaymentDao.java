package sugukuru.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import sugukuru.bean.Payment;

/**
 *
 * @author e.uehara
 *
 */
public class PaymentDao extends Dao{

	/**
	 *顧客入金確認
	 */
	public ArrayList<Payment> findCustomerAll(String start, String end){
		getConnection();
		ArrayList<Payment> payment = new ArrayList<Payment>();
		try {
			st = conn.prepareStatement("SELECT * FROM DTB_CUSTOMER_ORDER where ORDER_DATE BETWEEN ? AND ?");
			st.setString(1, start);
			st.setString(2, end);
			rs = st.executeQuery();

			while(rs.next()){
				String orderId  = rs.getString("CUSTOMER_ORDER_ID");
				String id = rs.getString("CUSTOMER_ID");
				String name = rs.getString("LAST_NAME");
				String orderDate = rs.getString("ORDER_DATE");
				String totalAmount = rs.getString("TOTAL_AMOUNT");
				Payment p = new Payment(orderId,id,name,orderDate,totalAmount);
				payment.add(p);
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally{
			connectionClose();
		}
		return payment;
	}

	/**
	 * 法人顧客入金確認
	 */
	public ArrayList<Payment> findCompanyAll(String start, String end){
		getConnection();
		ArrayList<Payment> payment = new ArrayList<Payment>();
		try {
			st = conn.prepareStatement("SELECT * FROM DTB_COMPANY_ORDER where ORDER_DATE BETWEEN ? AND ?");
			st.setString(1, start);
			st.setString(2, end);
			rs = st.executeQuery();
			while(rs.next()){
				String orderId  = rs.getString("COMPANY_ORDER_ID");
				String id = rs.getString("COMPANY_ID");
				String name = rs.getString("COMPANY_NAME");
				String orderDate 	  = rs.getString("ORDER_DATE");
				String totalAmount 	  = rs.getString("TOTAL_AMOUNT");
				Payment p = new Payment(orderId,id,name,orderDate,totalAmount);
				payment.add(p);
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally{
			connectionClose();
		}
		return payment;
	}
}
