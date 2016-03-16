package sugukuru.controller.admin.purchasing;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sugukuru.bean.Supplier;
import sugukuru.dao.SupplierDao;

/**
 * Servlet implementation class AddSuppliers
 */
@WebServlet("/Admin/Purchasing/AddSuppliers")
public class AddSuppliers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リダイレクト
        ServletContext context = this.getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/admin/purchasing/addSuppliers.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SupplierDao dao = new SupplierDao();

		String SupplierName = request.getParameter("supplierName");
		String readerName = request.getParameter("readerName");
		String postAddress = request.getParameter("postAddress");
		String address = request.getParameter("address");
		String phoneNumber = request.getParameter("phoneNumber");
		String memo = request.getParameter("memo");
		Supplier s = new Supplier(SupplierName,readerName,postAddress,address,phoneNumber,memo);

		String dispPage = "";
		if(dao.insert(s) == 1){
			dispPage = "/admin/result.jsp";
		}else{
			dispPage = "/admin/purchasing/addSuppliers.jsp";
		}

		ServletContext context = this.getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher(dispPage);
        dispatcher.forward(request, response);
	}
}
