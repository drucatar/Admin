package servletsAndFilters;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Higlited implements RequestHandler {

	@Override
	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException 
	{
		
		// 1 Create the factory of Entity Manager
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersistenceJPAProject");

		// 2 Create the Entity Manager
		EntityManager em = factory.createEntityManager();

		// 3 Get one EntityTransaction and start it
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		/*
		 * @UPDATE Course c SET c.highlighted = 1 WHERE c.idCourse = :courseID*/
		int courseID = Integer.parseInt(request.getParameter("idCourse"));
		em.createNamedQuery("Course.highlight").setParameter("courseID", courseID).executeUpdate();
		
		tx.commit();
		em.close();
		
		return null;
	}

}
