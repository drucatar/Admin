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
 * Servlet implementation class DeleteUser
 */
@WebServlet("/DeleteUser")
public class DeleteUser extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
	}
	
    public DeleteUser() {
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
		
		int diferentiator = Integer.parseInt(request.getParameter("user_type"));
		String userID = request.getParameter("DeleteUser");
		
		// 1 Create the factory of Entity Manager
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersistenceJPAProject");

		// 2 Create the Entity Manager
		EntityManager em = factory.createEntityManager();

		// 3 Get one EntityTransaction and start it
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		if( diferentiator == 0 && userID != null)
		{
			em.createNamedQuery("Student.Delete").setParameter("idStudent", userID);
			em.createNamedQuery("Studentcourse.Delete").setParameter("idStudent", userID);
			
			HttpSession session = request.getSession();
			session.removeAttribute("students");
			List<entities.Student> students = new ArrayList<entities.Student>();
			
			try{
				students = em.createNamedQuery("Student.findAll", entities.Student.class).getResultList();
			}catch(NoResultException e){
				students = null;
			}
			session.setAttribute("students", students);
		
		}else if(diferentiator == 1 && userID != null)
		{
			em.createNamedQuery("Studentcourse.DeleteByTeacherID").setParameter("idTeacher", userID);
			em.createNamedQuery("Teacher.Delete").setParameter("idTeacher", userID);
			em.createNamedQuery("Teachercourse.DeleteByTeacherID").setParameter("idTeacher", userID);
			
			HttpSession session = request.getSession();
			session.removeAttribute("teachers");
			List<entities.Teacher> teachers = new ArrayList<entities.Teacher>();
			
			try{
				teachers = em.createNamedQuery("Teachers.findAll", entities.Teacher.class).getResultList();
			}catch(NoResultException e){
				teachers = null;
			}
			session.setAttribute("teachers", teachers);
			
			session.removeAttribute("courses");
			
			List<entities.Course> courses = new ArrayList<entities.Course>();
			
			try{
				courses = em.createNamedQuery("Course.findAll", entities.Course.class).getResultList();
			}catch(NoResultException e){
				courses = null;
			}
				
			session.setAttribute("courses", courses);
		}
		
		em.close();
		factory.close();
			
		request.getRequestDispatcher("BackOfficeAdmin.jsp").forward(request, response);
	}

}
