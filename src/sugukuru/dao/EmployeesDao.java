package sugukuru.dao;

import java.sql.SQLException;

import sugukuru.bean.Employee;

public class EmployeesDao extends Dao{

	/**
	 * Sugukuru社員のLogin処理
	 */
	public Employee login(Object... obj){
		Employee emp = null;
		getConnection();
		try {
			st = conn.prepareStatement("SELECT * FROM DTB_EMPLOYEES WHERE employee_id = ? AND password = ? AND leaving_flag = 0");
			this.setInsertParams(obj);
			rs = st.executeQuery();
			if (!rs.next()) { return null; }

			emp = new Employee(
					rs.getString("employee_id"),
					rs.getString("last_name"),
					rs.getString("first_name"),
					rs.getInt("post_class_id"),
					rs.getInt("position_class_id"),
					rs.getString("mail_address")
			);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			connectionClose();
		}
		return emp;
	}

	/**
	 * 新規社員登録
	 * @return　成功:1 失敗:0
	 */
	public int regist(Object... obj){
		getConnection();
		int result = 0;
		try {
			st = conn.prepareStatement("INSERT INTO DTB_EMPLOYEES ("
					+ "LAST_NAME, "
					+ "FIRST_NAME, "
					+ "POST_CLASS_ID, "
					+ "PASSWORD, "
					+ "MAIL_ADDRESS"
					+ ") VALUES (?,?,?,?,?)");
			this.setInsertParams(obj);
			result = st.executeUpdate();
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			connectionClose();
		}
		return result;
	}
}
