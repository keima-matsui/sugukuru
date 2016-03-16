package sugukuru.controller.site;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sugukuru.dao.CompanyDao;
import sugukuru.model.Mail;

/**
 * Servlet implementation class CompanyRegist
 */
@WebServlet("/CompanyRegist")
public class CompanyRegist extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リダイレクト
        ServletContext context = this.getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/companyRegist.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String companyName  	  = request.getParameter("company_name");
		String phoneNumber  	  = request.getParameter("phone_number");
		String email 	    	  = request.getParameter("email");
		int postAddress     	  = Integer.parseInt(request.getParameter("post_address"));
		int ward		    	  = Integer.parseInt(request.getParameter("ward"));
		String underAddress 	  = request.getParameter("under_address");
		String foundingDate 	  = request.getParameter("fonding_date").substring(2);
		int capital 			  = Integer.parseInt(request.getParameter("capital"));
		String representativeName = request.getParameter("representative_name");
		String password 		  = request.getParameter("password");

		CompanyDao cDao = new CompanyDao();
		String id = cDao.RegistCompany(companyName,phoneNumber,email,postAddress,ward,underAddress,foundingDate,capital,representativeName,password);

        String title = "Sugukuru新規登録ありがとうございます";
        String message = "企業登録が完了しました\r\nIDは"+ id +"\r\nパスワードは自身が設定したものです。";

        Mail m = new Mail();
        m.SendMail(response, title, message, email);


	}

}
