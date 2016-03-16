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
import javax.servlet.http.HttpSession;

import sugukuru.bean.CartProduct;
import sugukuru.dao.CartDao;

/**
 * Servlet implementation class Cart
 */
@WebServlet("/Cart")
public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);

		String id = (String) session.getAttribute("userId");
		CartDao dao = new CartDao();
		List<CartProduct> cart = new ArrayList<CartProduct>();

		//企業か顧客かをチェック
		String type = (String) session.getAttribute("userType");

		//カートの中身を取得
		cart = dao.getToCart(id,type);

		request.setAttribute("products", cart);

		// リダイレクト
		ServletContext context = this.getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/cart.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		String id = (String) session.getAttribute("userId");

		CartDao dao = new CartDao();

		String customerId = id;
		String productId = request.getParameter("product_id");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		//顧客か起業かを判別
		String type = (String) session.getAttribute("userType");

		dao.addToCart(customerId,productId,quantity,type);

		//カートの中身へリダイレクト
		response.sendRedirect("Cart");
	}

}
