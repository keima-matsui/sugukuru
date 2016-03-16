package sugukuru.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sugukuru.bean.Supplier;

public class SupplierDao extends Dao{

	public SupplierDao(){
		super();
	}

	@SuppressWarnings("null")
	public List<Supplier> findAll(){
		List<Supplier> suppliers = new ArrayList<Supplier>();
		getConnection();
		try {
			st = conn.prepareStatement("SELECT * FROM DTB_SUPPLIERS");
			rs = st.executeQuery();
			while(rs.next()){
				String id = rs.getString("SUPPLIER_ID");
				String name = rs.getString("SUPPLIER_NAME");
				String readerName = rs.getString("READER_NAME");
				String postAddress = rs.getString("POST_ADDRESS");
				String address = rs.getString("ADDRESS");
				String phoneNumber = rs.getString("PHONE_NUMBER");
				String memo = rs.getString("MEMO");
				String created_at = rs.getString("created_at");
				Supplier s = new Supplier(id,name,readerName,postAddress,address,phoneNumber,memo,created_at);
				suppliers.add(s);
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally{
			connectionClose();
		}
		return suppliers;
	}

	public int insert(Supplier supplier){
		getConnection();
		int result = 0;
		try {
			st = conn.prepareStatement("INSERT INTO DTB_SUPPLIERS VALUES(DTB_SUPPLIERS_SEQ.nextval, ?, ?, ?, ?, ?, ?, SYSDATE)");
			st.setString(1, supplier.getSupplierName());
			st.setString(2, supplier.getReaderName());
			st.setString(3, supplier.getPostAddress());
			st.setString(4, supplier.getAddress());
			st.setString(5, supplier.getPhoneNumber());
			st.setString(6, supplier.getMemo());
			result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally{
			connectionClose();
		}
		return result;
	}
}