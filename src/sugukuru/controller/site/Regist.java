package sugukuru.controller.site;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sugukuru.dao.CustomerDao;
import sugukuru.model.Mail;

/**
 * Servlet implementation class SendInquiry
 */
@WebServlet("/Regist")
public class Regist extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// リダイレクト
        ServletContext context = this.getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/regist.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	CustomerDao cDao = new CustomerDao();

        request.setCharacterEncoding("UTF-8");
        String pass = request.getParameter("password");
        String id = cDao.RegistCustomer(pass);

        String email = request.getParameter("email");
        String title = "Sugukuru新規登録ありがとうございます";
        String message = "IDは"+ id +"\r\nパスワードは自身が設定したものです。";

        Mail m = new Mail();
        m.SendMail(response, title, message, email);

        request.setAttribute("message", "入力したメールアドレス宛にIDを送付いたしました");
        ServletContext context = this.getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/result.jsp");
        dispatcher.forward(request, response);
    }
}