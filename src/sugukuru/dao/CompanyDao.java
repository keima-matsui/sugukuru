package sugukuru.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CompanyDao extends Dao{
	public String RegistCompany(Object... obj){
		getConnection();
		String id = "";
		try {
			st = conn.prepareStatement("INSERT INTO DTB_COMPANY ("
					+ "COMPANY_ID,"
					+ "COMPANY_NAME,"
					+ "PHONE_NUMBER,"
					+ "MAIL_ADDRESS,"
					+ "UNDER_ADDRESS,"
					+ "FOUNDING_DATE,"
					+ "CAPITAL,"
					+ "REPRESENTATIVE_NAME,"
					+ "COMPANY_PASSWROD,"
					+ "POST_ADDRESS,"
					+ "WORD_ID"
					+ ") VALUES (DTB_CUSTOMER_SEQ.nextval,?,?,?,?,?,?,?,?,?,?)",new String[]{"COMPANY_ID"});
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

	/**
	 * @param obj : ID　PW
	 * @return ログイン成功 1 ログイン失敗 0
	 */
	public int LoginCheck(Object... obj){
		getConnection();
		try {
			st = conn.prepareStatement("SELECT * FROM DTB_COMPANY WHERE company_id = ? AND COMPANY_PASSWROD = ?");
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
}
