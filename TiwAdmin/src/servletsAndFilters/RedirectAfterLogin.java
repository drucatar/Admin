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

import beansPackage.AdminBean;
import beansPackage.DataStore;
import beansPackage.UserBean;

/**
 * Servlet implementation class RedirectAfterLogin
 */
@WebServlet("/RedirectAfterLogin")
public class RedirectAfterLogin extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	private DataStore dataStore;
	
    public RedirectAfterLogin() {
        super();
    }
    
	public void init(ServletConfig config) throws ServletException {
		dataStore=new DataStore();
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String beanName = (String) request.getParameter("username");	
		AdminBean bean = dataStore.getAdmin(beanName);
		List<Object> courses = dataStore.getCourses();
		List<Object> users = dataStore.getUsers();
		
		HttpSession session = request.getSession();
		session.setAttribute("validated_bean_session", bean);
		session.setAttribute("courses", courses);
		session.setAttribute("users", users);
		
		request.getRequestDispatcher("BackOfficeAdmin.jsp").forward(request, response);
	}

}
