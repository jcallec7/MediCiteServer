package utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class PageFilter implements Filter {
	
	public void destroy() {
		
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException{
		
		HttpSession session = ((HttpServletRequest) request).getSession(true);
		
		String newCurrentPage = ((HttpServletRequest) request).getServletPath();
		
		if (session.getAttribute("currentPage")==null) {
			session.setAttribute("lastPage", newCurrentPage);
			session.setAttribute("currentPage", newCurrentPage);
		} else {
			String oldCurrentPage = session.getAttribute("currentPage").toString();
			if(!oldCurrentPage.equals(newCurrentPage)) {
				session.setAttribute("lastPage", oldCurrentPage);
				session.setAttribute("currentPage", newCurrentPage);
			}
		}
		
		chain.doFilter(request, response);
		
	}
	
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
