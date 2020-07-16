package ecommerce.categoria.controller;

import java.io.IOException;
import java.util.ArrayList;

import ecommerce.categoria.service.*;
import ecommerce.prodotto.model.CategoriaBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class CategoriaServlet
 */
@WebServlet("/CategoriaServlet")
public class CategoriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoriaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoriaService cs = new CategoriaService();
		ArrayList<CategoriaBean> lista = cs.getAllCategoria();
		ObjectMapper mapper = new ObjectMapper();
		response.setContentType("application/json");
		mapper.writeValue(response.getOutputStream(), lista);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private ArrayList<CategoriaBean> caricaBean() {
		CategoriaBean bean1 = new CategoriaBean();
		bean1.setIdCategoria(1);
		bean1.setNome("Tecnologia");
		bean1.setUrlImmagine("img/tecnologia.png");
		CategoriaBean bean2 = new CategoriaBean();
		bean2.setIdCategoria(2);
		bean2.setNome("Gioielli");
		bean2.setUrlImmagine("img/gioeilli.png");
		CategoriaBean bean3 = new CategoriaBean();
		bean3.setIdCategoria(3);
		bean3.setNome("Gioielli2");
		bean3.setUrlImmagine("img/gioeilli.png");
		CategoriaBean bean4 = new CategoriaBean();
		bean4.setIdCategoria(4);
		bean4.setNome("Gioielli3");
		bean4.setUrlImmagine("img/gioeilli.png");
		ArrayList<CategoriaBean> prova = new ArrayList<CategoriaBean>();
		prova.add(bean1);
		prova.add(bean2);
		prova.add(bean3);
		prova.add(bean4);
		
		return prova;
	}
}
