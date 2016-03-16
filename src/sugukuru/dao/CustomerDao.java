package sugukuru.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDao extends Dao{

	/**
	 *
	 * @param password
	 * @param id
	 * @return ログイン成功 1 ログイン失敗 0
	 */
	public int LoginCheck(Object... obj){
		getConnection();
		try {
			st = conn.prepareStatement("SELECT * FROM DTB_CUSTOMER WHERE customer_id = ? AND customer_password = ?");
			this.setInsertParams(obj);
			rs = st.executeQuery();
			if (!rs.next()) { return 0; }
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return 0;
		} finally{
			connectionClose();
		}
		return 1;
	}

	public String RegistCustomer(String password){
		getConnection();
		String id = "";
		try {
			st = conn.prepareStatement("INSERT INTO DTB_CUSTOMER("
					+ "CUSTOMER_ID,"
					+ "CUSTOMER_PASSWORD"
					+ ") VALUES(DTB_CUSTOMER_SEQ.nextval,?)",new String[]{"CUSTOMER_ID"});
			st.setString(1, password);
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
}
