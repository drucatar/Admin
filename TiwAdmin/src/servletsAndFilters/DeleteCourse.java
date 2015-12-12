package servletsAndFilters;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DeleteCourse
 */
@WebServlet("/DeleteCourse")
public class DeleteCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void init(ServletConfig config) throws ServletException {
	}
	
    public DeleteCourse() {
        super();
        // TODO Auto-generated constructor stub
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
		
		String courseID = request.getParameter("Delete");
		
		if( courseID != null)
		{
			// 1 Create the factory of Entity Manager
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersistenceJPAProject");

			// 2 Create the Entity Manager
			EntityManager em = factory.createEntityManager();

			// 3 Get one EntityTransaction and start it
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			
			em.createNamedQuery("Course.deleteByID").setParameter("courseID", courseID);
			em.createNamedQuery("Studentcourse.DeleteByCourseID").setParameter("courseID", courseID);
			em.createNamedQuery("Teachercourse.deleteByCourseID").setParameter("courseID", courseID);
			
			HttpSession session = request.getSession();
			session.removeAttribute("courses");
			
			List<entities.Course> courses = new ArrayList<entities.Course>();
			
			try{
				courses = em.createNamedQuery("Course.findAll", entities.Course.class).getResultList();
			}catch(NoResultException e){
				courses = null;
			}
			session.setAttribute("courses", courses);
			
			em.close();
			factory.close();
		}
	
		request.getRequestDispatcher("BackOfficeAdmin.jsp").forward(request, response);
	}

}
