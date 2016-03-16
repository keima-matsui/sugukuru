package sugukuru.controller.admin.management;

import java.io.IOException;

import sugukuru.model.PasswordUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sugukuru.bean.Employee;
import sugukuru.dao.EmployeesDao;

/**
 * Servlet implementation class registEmployee
 */
@WebServlet("/Admin/RegistEmployee")
public class RegistEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		Employee emp = (Employee)session.getAttribute("employee");

        ServletContext context = this.getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/admin/registEmployee.jsp");
        dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		Employee emp = (Employee)session.getAttribute("employee");

		String lastName = request.getParameter("lastName");
		String firstName = request.getParameter("firstName");
		int postId = emp.getPostId();
		String email = request.getParameter("email");
		String password = PasswordUtil.makePassWord(12);

		EmployeesDao eDao = new EmployeesDao();
		int result = eDao.regist(lastName,firstName,postId,email,password);

		if(result == 1){
			System.out.println("成功");
		}else{
			System.out.println("失敗");
		}
	}

}
