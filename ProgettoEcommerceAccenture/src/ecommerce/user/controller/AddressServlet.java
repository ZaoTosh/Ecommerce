package ecommerce.user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import ecommerce.user.model.*;
import ecommerce.user.service.AddressService;
/**
 * Servlet implementation class AddressServlet
 */
@WebServlet("/AddressServlet")
public class AddressServlet extends HttpServlet {
	private static final Logger logger = LogManager.getLogger(AddressServlet.class);
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddressServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("do post address servlet");
		
		IndirizzoBean address = (IndirizzoBean) request.getAttribute("address");
		
		RequestDispatcher rd=null;
				
		AddressService as = new AddressService();
		if(as.addAddress(address)) {
			logger.info("address added");
			rd = request.getRequestDispatcher("index.jsp");
			HttpSession session = request.getSession();
			session.setAttribute("user", address.getUtente());
			rd.forward(request, response);
		}else {
			logger.error("data of address not valid!!");
			rd = request.getRequestDispatcher("registration.jsp");
			request.setAttribute("msg","Impossibile aggiungere l'indirizzo");
			rd.forward(request, response);
		}
		
		
	}

}
