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
 * Servlet implementation class Payment
 */
@WebServlet("/Order")
public class Order extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CartDao dao = new CartDao();
		List<CartProduct> cart = new ArrayList<CartProduct>();

		String dispPage = "";

		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("userId");

		//企業か顧客かをチェック
		String type = (String) session.getAttribute("userType");
		if(type.equals("customer")){
			dispPage = "/order.jsp";
			cart = dao.getToCart(id,"customer");
		}else{
			dispPage = "/companyOrder.jsp";
			cart = dao.getToCart(id,"company");
		}

		request.setAttribute("products", cart);
        ServletContext context = this.getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher(dispPage);
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
