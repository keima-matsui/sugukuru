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
 * ユーザーのログインチェックのみに使用されるフィルター
 */
@WebFilter(filterName="AuthFilter", urlPatterns={"/Cart","/Order/*"})
public class AuthFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest) request).getSession(false);

		if(session == null){
			//まだログインしていない
			((HttpServletResponse) response).sendRedirect("Login");
		}else{
			String id = (String) session.getAttribute("userId");
			if(id == null){
				//まだログインしていない
				((HttpServletResponse) response).sendRedirect("Login");
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
