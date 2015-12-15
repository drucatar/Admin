package servletsAndFilters;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;  
    // Hash table of RequestHandler instances, keyed by request URL
 	private Map<String, Object> handlerHash = new HashMap<String, Object>();

 	
    public ControllerServlet() {
        super();
		// This will read mapping definitions and populate handlerHash
		handlerHash.put("/login",
				new servletsAndFilters.RedirectAfterLogin());
		handlerHash.put("/CreateSpecialOffer",
				new servletsAndFilters.CreateSpecialOffer());
		handlerHash.put("/DeleteCourse",
				new servletsAndFilters.DeleteCourse());
		handlerHash.put("/ValidateCourse",
				new servletsAndFilters.ValidateCourse());
		handlerHash.put("/LogOut",
				new servletsAndFilters.LogOut());
		handlerHash.put("/DeleteUser", 
				new servletsAndFilters.DeleteUser());
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Complete. Retrieve from the HashMap the instance of the class which
		// implements the logic of the requested url
		RequestHandler rh = (RequestHandler) handlerHash.get(request
						.getServletPath());

		System.out.println("Servlet received the request");

		// Complete. If no instance is retrieved redirects to error
		if (rh == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);

		} else {

			System.out.println("Servlet passed the request to a handler");

			// Complete. Call the method handleRequsest of the instance in order
			// to obtain the url
			String viewURL = rh.handleRequest(request, response);
			System.out.println("Servlet sent the response");

			// Complete. Dispatch the request to the url obtained
			if (viewURL != null) {
				request.getRequestDispatcher(viewURL)
						.forward(request, response);
			}
		}
	}

}
