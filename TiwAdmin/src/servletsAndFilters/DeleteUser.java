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

public class DeleteUser implements RequestHandler {

	@Override
	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException 
	{
		int diferentiator = Integer.parseInt(request.getParameter("UserType"));
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
			entities.Student student = new entities.Student();
			
			try{
				student = em.createNamedQuery("Student.findById", entities.Student.class).setParameter("studentID", Integer.parseInt(userID)).getSingleResult();
			}catch(NoResultException e){
				student = null;
			}
			em.createNamedQuery("Student.DeleteById").setParameter("studentID", Integer.parseInt(userID)).executeUpdate();
			em.createNamedQuery("Studentcourse.deleteByStudentNickname").setParameter("nickname", student.getNickname()).executeUpdate();
			
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
		
		tx.commit();
		em.close();
		factory.close();

		return "BackOfficeAdmin.jsp";
	}

}
