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
		handlerHash.put("/highlight", new servletsAndFilters.Higlited());
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestHandler rh = (RequestHandler) handlerHash.get(request
						.getServletPath());

		if (rh == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);

		} else {
			String viewURL = rh.handleRequest(request, response);

			if (viewURL != null) {
				request.getRequestDispatcher(viewURL)
						.forward(request, response);
			}
		}
	}

}
