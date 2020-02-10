package utils;

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

@WebFilter(filterName = "AuthFilter", urlPatterns = { "*.xhtml" })
public class AuthorizationFilter implements Filter {

	public AuthorizationFilter() {
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		try {

			HttpServletRequest reqt = (HttpServletRequest) request;
			HttpServletResponse resp = (HttpServletResponse) response;
			HttpSession ses = reqt.getSession(false);

			String reqURI = reqt.getRequestURI();

			if (reqURI.indexOf("/publicas/") >= 0
					|| (ses != null && ses.getAttribute("user") != null && ses.getAttribute("rol") == null)
					|| reqURI.contains("javax.faces.resource"))

				chain.doFilter(request, response);

			else if (reqURI.indexOf("/admin/") >= 0
					&& (ses != null && ses.getAttribute("user") != null && ((int) ses.getAttribute("rol")) == 2))

				chain.doFilter(request, response);

			else if (reqURI.indexOf("/medico/") >= 0
					&& (ses != null && ses.getAttribute("user") != null && ((int) ses.getAttribute("rol")) == 3))

				chain.doFilter(request, response);

			else if (reqURI.indexOf("/paciente/") >= 0
					&& (ses != null && ses.getAttribute("user") != null && ((int) ses.getAttribute("rol")) == 4))
				chain.doFilter(request, response);
			else

				resp.sendRedirect(reqt.getContextPath() + "/publicas/principal.xhtml");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void destroy() {

	}
}