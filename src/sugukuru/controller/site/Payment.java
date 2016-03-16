package sugukuru.controller.site;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sugukuru.model.PaymentHelper;

/**
 * Servlet implementation class Payment
 */
@WebServlet("/Payment")
public class Payment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String lastName    = request.getParameter("last_name");
		String firstName   = request.getParameter("first_name");
		int postAddress    = Integer.parseInt(request.getParameter("post_address"));
		int ward		   = Integer.parseInt(request.getParameter("ward"));
		String address     = request.getParameter("address");
		String phoneNumber = request.getParameter("phone");

		// ユーザーのタイプで処理を分ける
		HttpSession session = request.getSession();
		String id 		    = (String) session.getAttribute("userId");
		String type 		= (String) session.getAttribute("userType");

		PaymentHelper ph = new PaymentHelper();
		ph.orderRegist(id,type,firstName,lastName,postAddress,ward,address,phoneNumber);

		// リダイレクト
		request.setAttribute("message", "決済が完了いたしました。");
		ServletContext context = this.getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/result.jsp");
        dispatcher.forward(request, response);
	}

}
