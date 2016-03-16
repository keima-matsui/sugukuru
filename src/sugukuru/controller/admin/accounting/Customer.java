package sugukuru.controller.admin.accounting;

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
import sugukuru.dao.PaymentDao;

/**
 * Servlet implementation class Customer
 */
@WebServlet("/Admin/Accounting/PaymentCheck/Customer")
public class Customer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 面倒なので、エラーがアレば握りつぶす
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int year = 0;
		int month = 0;
		Calendar calendar = Calendar.getInstance();

		if(request.getParameter("year") == null || request.getParameter("month") == null){
			year = calendar.get(Calendar.YEAR);
			month = calendar.get(Calendar.MONTH);
		}else{
			try{
				year = Integer.parseInt(request.getParameter("year"));
				month = Integer.parseInt(request.getParameter("month"));
			}catch(NumberFormatException e){
				e.printStackTrace();
				year = calendar.get(Calendar.YEAR);
				month = 1;
			}
		}
		request.setAttribute("year", year);
		request.setAttribute("month", month);

		String start = year + "-" + (month - 2) + "-" + 16;
	    String end = year + "-" + (month - 1) + "-" + 15;
		PaymentDao dao = new PaymentDao();
		List<Payment> payments = dao.findCustomerAll(start, end);

		request.setAttribute("payments", payments);

		ServletContext context = this.getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/admin/accounting/customer.jsp");
        dispatcher.forward(request, response);
	}
}
