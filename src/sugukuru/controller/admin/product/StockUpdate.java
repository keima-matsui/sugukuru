package sugukuru.controller.admin.product;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sugukuru.dao.ProductsDao;

/**
 * Servlet implementation class StockUpdate
 */
@WebServlet("/StockUpdate")
public class StockUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リダイレクト
        ServletContext context = this.getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/admin/top.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] productId = request.getParameterValues("productId");
		String[] stock = request.getParameterValues("stock");

		ProductsDao dao = new ProductsDao();
		Boolean result = dao.stockUpdate(productId,stock);

		// 結果がtrueの時は結果を表示
		if(result){

		} else {

		}

		request.getRequestDispatcher("stock.jsp").forward(request, response);
	}
}
