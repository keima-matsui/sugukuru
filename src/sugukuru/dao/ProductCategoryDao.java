package sugukuru.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sugukuru.bean.Category;

public class ProductCategoryDao extends Dao{
	public List<Category> getAllvategory(){
		getConnection();
		List<Category> categorys = new ArrayList<Category>();
		try {
			st = conn.prepareStatement("SELECT * FROM MTB_PRODUCT_CATEGORY");
			rs = st.executeQuery();
			while(rs.next()){
				int id = rs.getInt("category_id");
				String name = rs.getString("category_name");
				Category c = new Category(id,name);
				categorys.add(c);
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally{
			connectionClose();
		}
		return categorys;

	}
}
