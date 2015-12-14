package servletsAndFilters;

import java.io.IOException;
import java.sql.Date;
import java.time.Year;
import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateSpecialOffer
 */
@WebServlet("/CreateSpecialOffer")
public class CreateSpecialOffer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateSpecialOffer() {
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
		// TODO Auto-generated method stub
		double quantity = Double.parseDouble(request.getParameter("quantity"));
		Date initDate = Date.valueOf(request.getParameter("initialDate"));
		Date expDate = Date.valueOf(request.getParameter("initialDate"));
		/*
		 * String name = request.getParameter("name");
		 * String description = request.getParameter("description");
		*/
		
		
		if(quantity != 0 && initDate != null && expDate != null)
		{
			entities.Specialoffer newOffer = new entities.Specialoffer();
			Calendar calendar = Calendar.getInstance();
			
			//Generation of the operation code
			String specialCode= new StringBuilder("CUPON")
										.append(Year.now().getValue())
										.append(calendar.get(Calendar.MONTH) + 1)
										.append(calendar.getActualMaximum(Calendar.DAY_OF_MONTH))
										.append(calendar.getActualMaximum(Calendar.HOUR))
										.append(calendar.getActualMaximum(Calendar.SECOND))
										.append(calendar.getActualMaximum(Calendar.MILLISECOND))
										.append(calendar.getActualMaximum(Calendar.AM_PM))
										.append(quantity)
										.toString();
			
			newOffer.genID();
			newOffer.setExpirationDate(expDate);
			newOffer.setInitDate(initDate);
			newOffer.setQuantity(quantity);
			newOffer.setSpecialOfferCode(specialCode);
			/*
			 *newOffer.setName(name);
			 *newOffer.setDescription(description); 
			*/
			
			// 1 Create the factory of Entity Manager
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersistenceJPAProject");
	
			// 2 Create the Entity Manager
			EntityManager em = factory.createEntityManager();
	
			// 3 Get one EntityTransaction and start it
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			
			em.persist(newOffer);
			
			// 4 Commmit the transaction
			tx.commit();
			em.flush();
			// 5 Close the manager
			em.close();
			
		}	
	}
}