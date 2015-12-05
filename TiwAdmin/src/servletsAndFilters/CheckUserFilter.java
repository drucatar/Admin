package servletsAndFilters;


import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

import entities.Admin;
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
		
		// 1 Create the factory of Entity Manager
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersistenceJPAProject");

				// 2 Create the Entity Manager
		EntityManager em = factory.createEntityManager();

				// 3 Get one EntityTransaction and start it
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try{
		Admin administrator = em.createNamedQuery("Admin.findByName",entities.Admin.class).setParameter("NameAdmin",request.getParameter("username")).getSingleResult();
		}
		catch()
		/*If the bean is "null" it means that the nickname (primary key) was not found in our "DataBase"
		 * and the user is directly incorrect. Otherwise the password associated to the user is checked.*/
		if(administrator != null)
			if(bean.getPassword().equals(request.getParameter("password")))
				chain.doFilter(request, response);
			else
				((HttpServletResponse) response).sendRedirect("IncorrectPassword.jsp");
		else
			((HttpServletResponse) response).sendRedirect("IncorrectUser.jsp");
	}
}
