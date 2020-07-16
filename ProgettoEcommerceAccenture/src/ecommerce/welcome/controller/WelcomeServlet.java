package ecommerce.welcome.controller;


import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import ecommerce.prodotto.model.ProdottoBean;
import ecommerce.prodotto.service.ProdottoService;

/**
 * Servlet implementation class WelcomeServlet
 */
@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(WelcomeServlet.class);   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WelcomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("metodo get della WelcomeServlet");
		RequestDispatcher rd = request.getRequestDispatcher("listaprodotti.jsp");
		int idCategoria = Integer.parseInt(request.getParameter("id"));
		ProdottoService ps = new ProdottoService();
		ArrayList<ProdottoBean> listaProdotti = ps.getProdottoByCategoria(idCategoria);
		if(listaProdotti==null || listaProdotti.isEmpty()) {
			request.setAttribute("msg", "non ci sono prodotti in questa categoria");
			rd.forward(request, response);
		}
		else {
			request.setAttribute("listaprodotti", listaProdotti);
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
