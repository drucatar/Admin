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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateSpecialOffer implements RequestHandler {

	@Override
	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException 
	{
		String name = request.getParameter("name");
		double quantity = Double.parseDouble(request.getParameter("quantity"));
		Date initDate = Date.valueOf(request.getParameter("initialDate"));
		Date expDate = Date.valueOf(request.getParameter("expDate"));
		String description = request.getParameter("description");
		
		System.out.println("[*] InitDate: " + initDate + " [*]");
		System.out.println("[*] ExpDate: " + expDate + " [*]");
				
		if(quantity != 0 && initDate != null && expDate != null)
		{
			// 1 Create the factory of Entity Manager
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersistenceJPAProject");
	
			// 2 Create the Entity Manager
			EntityManager em = factory.createEntityManager();
	
			// 3 Get one EntityTransaction and start it
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			
			entities.Specialoffer newOffer = new entities.Specialoffer();
			Calendar calendar = Calendar.getInstance();
			
			//Generation of the operation code
			String specialCode= new StringBuilder("CUPON")
										.append(Year.now().getValue())
										.append(calendar.get(Calendar.MONTH) + 1)
										.append(calendar.get(Calendar.DAY_OF_MONTH))
										.append(calendar.get(Calendar.HOUR))
										.append(calendar.get(Calendar.SECOND))
										.append(calendar.get(Calendar.MILLISECOND))
										.append(calendar.get(Calendar.AM_PM))
										.append(quantity)
										.toString();
			
			newOffer.genID();
			newOffer.setName(name);
			newOffer.setDescription(description);
			newOffer.setExpirationDate(expDate);
			newOffer.setInitDate(initDate);
			newOffer.setQuantity(quantity);
			newOffer.setSpecialOfferCode(specialCode);

			em.persist(newOffer);
	
			// 4 Commmit the transaction
			tx.commit();

			// 5 Close the manager
			em.close();
			
		}	
		return "BackOfficeAdmin.jsp";
	}
}
