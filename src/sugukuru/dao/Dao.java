package sugukuru.dao;

import java.sql.*;
import org.apache.log4j.Logger;

/**
 *
 * @author k.matui
 *
 */
abstract public class Dao {

	/** 接続先サーバ名 */
	private String serverName = "oracle";
	/** 接続先インスタンス名 */
	private String instanceName = "xe";
	/** 接続先ユーザ名 */
	private String userName = "kouta";
	/** 接続先パスワード */
	private String password = "kouta123";
	/** ロガー */
	private Logger log = Logger.getLogger (Dao.class.getName ());

	protected Connection conn;
	protected PreparedStatement st;
	protected ResultSet rs;

	public Dao() {
		this.conn = null;
		this.st   = null;
		this.rs   = null;
	}

	protected void getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			this.conn = DriverManager.getConnection("jdbc:oracle:thin:@" + serverName + ":1521:" + instanceName, userName, password);
		} catch (SQLException e) {
			e.printStackTrace();
			log.fatal("oracleに接続出来ません");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			log.fatal("オラクルのドライバーが見つかりません");
		}
	}

	/**
	 * 冗長なst.setｺﾞﾆｮｺﾞﾆｮをひとまとめにする。
	 * 使う際には Object... obj　を引数に設定されたものをそのまま渡す
	 * Daoに渡した順でパラメーターが入るので気をつける事
	 *
	 * @param obj インサートする際の配列
	 */
	protected void setInsertParams(Object[] obj){
        for(int i = 0; i < obj.length; i++){
        	try {
				st.setObject(i + 1, obj[i]);
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
        }
    }

	protected void connectionClose(){
		try{
			if(rs != null){
			  rs.close();
			  rs = null;
			}
			if(st != null){
			  st.close();
			  st = null;
			}
			if(conn != null){
				conn.close();
				conn = null;
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
	}
}
