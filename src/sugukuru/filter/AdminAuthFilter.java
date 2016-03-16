package sugukuru.filter;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author yanagikouta
 * 管理者のログインチェックのみに使用されるフィルター
 */
@WebFilter(filterName="AdminAuthFilter", urlPatterns={"/Admin/*"})
public class AdminAuthFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest) request).getSession(false);
		if(session == null){
			//まだログインしていない
			((HttpServletResponse) response).sendRedirect("/Sugukuru/Auth/Login");
		}else{
			if(session.getAttribute("employee") == null){
				//まだログインしていない
				((HttpServletResponse) response).sendRedirect("/Sugukuru/Auth/Login");
			}else{
				chain.doFilter(request, response);
			}
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {


	}

	@Override
	public void destroy() {
		// TODO 自動生成されたメソッド・スタブ

	}

}
