package servletsAndFilters;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ValidateCourse implements RequestHandler {

	@Override
	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException 
	{
		String courseID = request.getParameter("Validate");
		
		if( courseID != null)
		{
			// 1 Create the factory of Entity Manager
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersistenceJPAProject");
	
			// 2 Create the Entity Manager
			EntityManager em = factory.createEntityManager();
	
			// 3 Get one EntityTransaction and start it
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			
			em.createNamedQuery("Course.validate", entities.Course.class).setParameter("courseID",Integer.parseInt(courseID)).executeUpdate();			
			
			HttpSession session = request.getSession();
			session.removeAttribute("courses");
			
			List<entities.Course> courses = new ArrayList<entities.Course>();
			
			try{
				courses = em.createNamedQuery("Course.findAll", entities.Course.class).getResultList();
			}catch(NoResultException e){
				courses = null;
			}			
			session.setAttribute("courses", courses);
			
			tx.commit();
			em.close();
			factory.close();
		}
		
		return "BackOfficeAdmin.jsp";
	}

}
