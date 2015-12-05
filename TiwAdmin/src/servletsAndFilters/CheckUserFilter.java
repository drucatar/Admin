package servletsAndFilters;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

import beansPackage.AdminBean;
import beansPackage.DataStore;

/**
 * Servlet Filter implementation class CheckUserFilter
 */
@WebFilter(filterName = "CheckUserFilter", urlPatterns={"/RedirectAfterLogin"})
public class CheckUserFilter implements Filter {

	private DataStore dataStore;
	
    public CheckUserFilter() {}

    public void init(FilterConfig fConfig) throws ServletException {
		dataStore=new DataStore();
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		String name = (String) request.getParameter("username");
		AdminBean bean = dataStore.getAdmin(name);
		
		/*If the bean is "null" it means that the nickname (primary key) was not found in our "DataBase"
		 * and the user is directly incorrect. Otherwise the password associated to the user is checked.*/
		if(bean != null)
			if(bean.getPassword().equals(request.getParameter("password")))
				chain.doFilter(request, response);
			else
				((HttpServletResponse) response).sendRedirect("IncorrectPassword.jsp");
		else
			((HttpServletResponse) response).sendRedirect("IncorrectUser.jsp");
	}
}
