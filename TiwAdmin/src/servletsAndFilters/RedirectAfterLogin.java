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

import entities.Admin;
import entities.Course;
import entities.Student;
import entities.Teacher;


public class RedirectAfterLogin implements RequestHandler {

	@Override
	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// 1 Create the factory of Entity Manager
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("PersistenceJPAProject");

		// 2 Create the Entity Manager
		EntityManager em = factory.createEntityManager();

		// 3 Get one EntityTransaction and start it
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		HttpSession session = request.getSession();
		Admin administrator = new entities.Admin();
		List<Course> courses = new ArrayList<Course>();
		List<Student> students = new ArrayList<Student>();
		List<Teacher> teachers = new ArrayList<Teacher>();

		try {
			administrator = em
					.createNamedQuery("Admin.findByName", entities.Admin.class)
					.setParameter("NameAdmin", request.getParameter("nickname"))
					.getSingleResult();
		} catch (NoResultException e) {
			administrator = null;
		}

		try {
			courses = em.createNamedQuery("Course.findAll",
					entities.Course.class).getResultList();
		} catch (NoResultException e) {
			courses = null;
		}

		try {
			students = em.createNamedQuery("Student.findAll",
					entities.Student.class).getResultList();
		} catch (NoResultException e) {
			students = null;
		}

		try {
			teachers = em.createNamedQuery("Teacher.findAll",
					entities.Teacher.class).getResultList();
		} catch (NoResultException e) {
			teachers = null;
		}

		em.close();
		factory.close();

		session.setAttribute("validated_session", administrator);
		session.setAttribute("courses", courses);
		session.setAttribute("students", students);
		session.setAttribute("teachers", teachers);

		return "BackOfficeAdmin.jsp";
	}

}
