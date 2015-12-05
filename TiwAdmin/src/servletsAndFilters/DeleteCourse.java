package servletsAndFilters;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beansPackage.CourseBean;
import beansPackage.DataStore;

/**
 * Servlet implementation class DeleteCourse
 */
@WebServlet("/DeleteCourse")
public class DeleteCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private DataStore dataStore;
	
	public void init(ServletConfig config) throws ServletException {
		dataStore=new DataStore();
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
			CourseBean course = dataStore.getCourse(courseID);
			dataStore.deleteCourse(courseID , course);
			HttpSession session = request.getSession();
			session.removeAttribute("courses");
			List<Object> courses = dataStore.getCourses();
			session.setAttribute("courses", courses);
		}
		
		
		request.getRequestDispatcher("BackOfficeAdmin.jsp").forward(request, response);
	}

}
