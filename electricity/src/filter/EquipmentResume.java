package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EquipmentResume implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpSession session = ((HttpServletRequest)request).getSession();
		String privilege = "*000203";
			if(((String)session.getAttribute("privilege")).equals("*00"))
				{
					chain.doFilter(request, response);
				}
				else
				{
					if(((String)session.getAttribute("privilege")).contains(privilege))
					{
						chain.doFilter(request, response);
					}
					else
					{
						((HttpServletResponse)response).sendRedirect("../right.jsp?error=error");
					}
				}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}