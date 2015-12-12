package servletsAndFilters;


import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ValidateCourse
 */
@WebServlet("/ValidateCourse")
public class ValidateCourse extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
    public ValidateCourse() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig config) throws ServletException {
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String courseID = request.getParameter("Validate");
		
		if( courseID != null){
			// 1 Create the factory of Entity Manager
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersistenceJPAProject");
	
			// 2 Create the Entity Manager
			EntityManager em = factory.createEntityManager();
	
			// 3 Get one EntityTransaction and start it
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			
			entities.Course course = new entities.Course();
			course = em.createNamedQuery("Course.findByID", entities.Course.class).getSingleResult();
			course.setValidated(1);
			
			em.close();
			factory.close();
		}
		request.getRequestDispatcher("BackOfficeAdmin.jsp").forward(request, response);
	}

}
