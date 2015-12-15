package servletsAndFilters;


import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
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

/**
 * Servlet Filter implementation class CheckUserFilter
 */
@WebFilter(filterName = "CheckUserFilter", urlPatterns={"/login"})
public class CheckUserFilter implements Filter {

    public CheckUserFilter() {}

    public void init(FilterConfig fConfig) throws ServletException {
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
		
		Admin administrator = new entities.Admin();
		tx.begin();
		
		try{
			administrator = em.createNamedQuery("Admin.findByName",entities.Admin.class).setParameter("NameAdmin",request.getParameter("username")).getSingleResult();
		}
		catch(NoResultException e){
			administrator = null;
		}
		
		tx.commit();
		em.close();
		
		if(administrator != null)
			if(administrator.getPasswordAdmin().equals(request.getParameter("password")))
				chain.doFilter(request, response);
			else
				((HttpServletResponse) response).sendRedirect("IncorrectPassword.jsp");
		else
			((HttpServletResponse) response).sendRedirect("IncorrectUser.jsp");
	}
}
