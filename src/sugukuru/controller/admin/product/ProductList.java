package sugukuru.controller.admin.product;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sugukuru.bean.Payment;
import sugukuru.bean.Product;
import sugukuru.dao.PaymentDao;
import sugukuru.dao.ProductsDao;

/**
 * Servlet implementation class Customer
 */
@WebServlet("/Admin/ProductManagement/ProductList")
public class ProductList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductsDao dao = new ProductsDao();
		List<Product> products = dao.findAll();
		request.setAttribute("products", products);

		ServletContext context = this.getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/admin/product/productList.jsp");
        dispatcher.forward(request, response);
	}
}
