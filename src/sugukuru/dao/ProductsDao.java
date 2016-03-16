package sugukuru.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sugukuru.bean.Product;

/**
 *
 * @author e.uehara
 *
 */
public class ProductsDao extends Dao{
	public List<Product> findAll(){
		getConnection();
		List<Product> products = new ArrayList<Product>();
		try {
			st = conn.prepareStatement("SELECT * FROM DTB_PRODUCTS");
			rs = st.executeQuery();
			while(rs.next()){
				String id		  = rs.getString("product_id");
				String categoryId = String.format("%02d",rs.getInt("category_id"));
				String name 	  = rs.getString("product_name");
				int price		  = rs.getInt("price");
				int stock		  = rs.getInt("stock");
				String detail 	  = rs.getString("product_detail");
				Product p = new Product(id,categoryId,name,price,stock,detail);
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

	public List<Product> getRecommend(){
		getConnection();
		List<Product> products = new ArrayList<Product>();
		try {
			st = conn.prepareStatement("SELECT * FROM DTB_RECOMMEND_PRODUCTS drp LEFT JOIN DTB_PRODUCTS dp ON dp.product_id = drp.product_id");
			rs = st.executeQuery();
			while(rs.next()){
				String id		  = rs.getString("product_id");
				String categoryId = String.format("%02d",rs.getInt("category_id"));
				String name 	  = rs.getString("product_name");
				int price		  = rs.getInt("price");
				int stock		  = rs.getInt("stock");
				String detail 	  = rs.getString("product_detail");
				Product p = new Product(id,categoryId,name,price,stock,detail);
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

	public Product getProduct(String id2) {
		getConnection();
		Product p = null;
		try {
			st = conn.prepareStatement("SELECT * FROM DTB_PRODUCTS WHERE product_id = ?");
			st.setString(1, id2);
			rs = st.executeQuery();
			while(rs.next()){
				String id		  = rs.getString("product_id");
				String categoryId = String.format("%02d",rs.getInt("category_id"));
				String name 	  = rs.getString("product_name");
				int price		  = rs.getInt("price");
				int stock		  = rs.getInt("stock");
				String detail 	  = rs.getString("product_detail").replaceAll("\n", "<br>");
				p = new Product(id,categoryId,name,price,stock,detail);
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally{
			connectionClose();
		}
		return p;
	}

	/**
	 * 指定されたカテゴリの商品をすべて取得
	 * @param cId カテゴリID
	 * @return
	 */
	public List<Product> getProductsForCategory(int cId){
		getConnection();
		List<Product> products = new ArrayList<Product>();
		try {
			st = conn.prepareStatement("SELECT * FROM DTB_PRODUCTS WHERE category_id = ?");
			st.setInt(1, cId);
			rs = st.executeQuery();
			while(rs.next()){
				String id		  = rs.getString("product_id");
				String categoryId = String.format("%02d",rs.getInt("category_id"));
				String name 	  = rs.getString("product_name");
				int price		  = rs.getInt("price");
				int stock		  = rs.getInt("stock");
				String detail 	  = rs.getString("product_detail");
				Product p = new Product(id,categoryId,name,price,stock,detail);
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

	public List<Product> getNewProducts(){
		getConnection();
		List<Product> products = new ArrayList<Product>();
		try {
			st = conn.prepareStatement("SELECT * FROM DTB_PRODUCTS WHERE ROWNUM <= 8 ORDER BY product_id DESC");
			rs = st.executeQuery();
			while(rs.next()){
				String id		  = rs.getString("product_id");
				String categoryId = String.format("%02d",rs.getInt("category_id"));
				String name 	  = rs.getString("product_name");
				int price		  = rs.getInt("price");
				int stock		  = rs.getInt("stock");
				String detail 	  = rs.getString("product_detail");
				Product p = new Product(id,categoryId,name,price,stock,detail);
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

	/**
	 * 商品検索
	 * @param word
	 * @return
	 */
	public List<Product> searchProductByWord(String word) {
		getConnection();
		List<Product> products = new ArrayList<Product>();
		try {
			st = conn.prepareStatement("SELECT * FROM DTB_PRODUCTS WHERE product_name LIKE ? ORDER BY product_id DESC");
			st.setString(1, "%" + word + "%");
			rs = st.executeQuery();
			while(rs.next()){
				String id		  = rs.getString("product_id");
				String categoryId = String.format("%02d",rs.getInt("category_id"));
				String name 	  = rs.getString("product_name");
				int price		  = rs.getInt("price");
				int stock		  = rs.getInt("stock");
				String detail 	  = rs.getString("product_detail");
				Product p = new Product(id,categoryId,name,price,stock,detail);
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

	/**
	 * 全期間で一番売れた個数が多い商品を取得
	 * @return
	 */
	public List<Product> getRankingProducts(){
		getConnection();
		List<String> rankingProductsId = new ArrayList<String>();
		try {
			st = conn.prepareStatement("SELECT dcod.product_id, sum(quantity) AS sum "
					+ "FROM DTB_CUSTOMER_ORDER_DETAIL dcod LEFT JOIN "
					+ "DTB_PRODUCTS dp ON dp.product_id = dcod.product_id "
					+ "GROUP BY dcod.product_id "
					+ "ORDER BY sum DESC");
			rs = st.executeQuery();

			//なんか動きが意味不明になるため、手動で行う
			int i = 0;
			while(rs.next() && i < 5){
				String id = rs.getString("product_id");
				rankingProductsId.add(id);
				i++;
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally{
			connectionClose();
		}
		List<Product> products = this.getProductsUtil(rankingProductsId);
		return products;
	}

	/**
	 * Listで商品IDを渡せばそれを全部返してくれる
	 * @return
	 */
	private List<Product> getProductsUtil(List<String> productsIds){
		getConnection();
		List<Product> products = new ArrayList<Product>();
		try {
			for(String pId : productsIds){
				st = conn.prepareStatement("SELECT * FROM DTB_PRODUCTS WHERE product_id = ?");
				st.setString(1, pId);
				rs = st.executeQuery();
				while(rs.next()){
					String id		  = rs.getString("product_id");
					String categoryId = String.format("%02d",rs.getInt("category_id"));
					String name 	  = rs.getString("product_name");
					int price		  = rs.getInt("price");
					int stock		  = rs.getInt("stock");
					String detail 	  = rs.getString("product_detail");
					Product p = new Product(id,categoryId,name,price,stock,detail);
					products.add(p);
				}
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally{
			connectionClose();
		}
		return products;
	}

	/**
	 * 商品追加処理
	 */
	public String setProductAdd(Product p) {
		getConnection();
		String id = "";
		try {
			st = conn.prepareStatement("INSERT INTO DTB_PRODUCTS VALUES (DTB_PRODUCTS_SEQ.NEXTVAL,1,?,?,0,0,?,SYSDATE,SYSDATE)",new String[]{"PRODUCT_ID"});
			//st.setString(1, p.getCategoryId());
			st.setString(1, p.getName());
			st.setInt(2, p.getPrice());
			st.setString(3, p.getDetail());
			st.execute();

			ResultSet keys = st.getGeneratedKeys();
			try {
		        keys.next();
		        id = keys.getString(1);
		    } catch(Exception e) {
		    	e.printStackTrace();
		    } finally {
		        keys.close();
		    }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionClose();
		}
		return id;
	}

	public Boolean stockUpdate(String[] productId, String[] stock) {
		getConnection();
		Boolean result = true;
		try{
			for(int i = 0; i < productId.length; i++){
				st = conn.prepareStatement("UPDATE DTB_PRODUCTS SET stock = ? where product_id = ?");
				st.setString(1,productId[i]);
				st.setString(2,stock[i]);
				st.executeUpdate();
			}
		} catch (SQLException e) {
			result = false;
			e.printStackTrace();
		}finally{
			connectionClose();
		}
		return result;
	}
}
