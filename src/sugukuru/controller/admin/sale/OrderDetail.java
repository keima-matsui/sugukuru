package sugukuru.controller.admin.sale;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sugukuru.bean.Order;
import sugukuru.dao.OrderDao;
import sugukuru.dao.OrderDetailDao;

/**
 * Servlet implementation class OrderDetail
 */
@WebServlet("/Admin/Sale/OrderDetail")
public class OrderDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		OrderDetailDao dao = new OrderDetailDao();
		OrderDao dao2 	   = new OrderDao();
		Order order		   = null;
		if(id.substring(0, 1).equals("4")){
			order = dao2.getCustomerOrder(id);
			order.setOrderProducts(dao.getOrderDetail("CUSTOMER",id));
		} else {
			order = dao2.getCompanyOrder(id);
			order.setOrderProducts(dao.getOrderDetail("COMPANY",id));
		}
		request.setAttribute("order", order);

		// リダイレクト
        ServletContext context = this.getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/admin/sale/orderDetail.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
