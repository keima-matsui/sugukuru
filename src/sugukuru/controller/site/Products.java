package sugukuru.controller.site;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sugukuru.bean.Product;
import sugukuru.dao.ProductsDao;

/**
 * Servlet implementation class Products
 */
@WebServlet("/Products")
public class Products extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product> products = new ArrayList<Product>();
		String mode = "";
		if(request.getParameter("mode") != null){
			mode = request.getParameter("mode");
		}

		ProductsDao pDao = new ProductsDao();
		switch(mode){
			case "search":
				request.setAttribute("title", "検索結果");
				String word = request.getParameter("word");
				products = pDao.searchProductByWord(word);
				request.setAttribute("word", word);
				break;
			case "new":
				request.setAttribute("title", "新商品");
				products = pDao.getNewProducts();
				break;
			case "category":
				request.setAttribute("title", "カテゴリ");
				int id = Integer.parseInt(request.getParameter("id"));
				products = pDao.getProductsForCategory(id);
				break;
			case "recommend":
				request.setAttribute("title", "オススメ商品");
				products = pDao.getRecommend();
				break;
			case "popular":
				request.setAttribute("title", "人気商品");
				products = pDao.getRankingProducts();
				break;
			case "selling":
				request.setAttribute("title", "売れ筋商品");
				break;
			default:
				request.setAttribute("title", "全商品");
				products = pDao.findAll();
				break;
		}
		request.setAttribute("products", products);

		// リダイレクト
        ServletContext context = this.getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/products.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//ログを吐き出す
	}

}
