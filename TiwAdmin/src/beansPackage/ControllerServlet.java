package beansPackage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beansPackage.UserBean;

public class ControllerServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	ServletContext context;
	
    public ControllerServlet() {
        super();
    }
    
	public void init(ServletConfig config) throws ServletException {
		context = config.getServletContext();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	PrintWriter out = response.getWriter();
	out.print("doget");
	out.flush();
	out.close();
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		out.print("dopost");
		out.flush();
		out.close();
		
		/*
		String beanName = "user_"+request.getAttribute("name");
		UserBean user = (UserBean)context.getAttribute(beanName);
		request.setAttribute("category",user.getCategory());
		request.getRequestDispatcher("BackOffice.jsp").forward(request, response);
	 	*/
	}

}
