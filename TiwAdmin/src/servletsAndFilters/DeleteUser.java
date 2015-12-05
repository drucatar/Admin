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
import beansPackage.UserBean;

/**
 * Servlet implementation class DeleteUser
 */
@WebServlet("/DeleteUser")
public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private DataStore dataStore;
	
	public void init(ServletConfig config) throws ServletException {
		dataStore=new DataStore();
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
		
		String userID = request.getParameter("DeleteUser");
		
		if( userID != null)
		{
			System.out.println("[* INSIDE USER IF *]");
			UserBean course = dataStore.getInfo(userID);
			dataStore.deleteUser(userID , course);
			HttpSession session = request.getSession();
			session.removeAttribute("users");
			List<Object> users = dataStore.getUsers();
			session.setAttribute("users", users);
		}
		
		
		request.getRequestDispatcher("BackOfficeAdmin.jsp").forward(request, response);
	}

}
