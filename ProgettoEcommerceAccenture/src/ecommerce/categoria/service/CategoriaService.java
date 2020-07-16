package ecommerce.categoria.service;

import java.util.ArrayList;

import ecommerce.prodotto.dao.CategoriaDaoImpl;
import ecommerce.prodotto.model.CategoriaBean;

public class CategoriaService {
	private CategoriaDaoImpl dao = new CategoriaDaoImpl();
	
	public ArrayList<CategoriaBean> getAllCategoria(){
		ArrayList<CategoriaBean> lista = dao.getAllCategoria();
		return lista;
	}
	
	public boolean addCategoria(CategoriaBean categoria) {
		if(dao.addCategoria(categoria))
			return true;
		else
			return false;
	}
	public boolean updateCategoria(CategoriaBean categoria) {
		if(dao.updateCategoria(categoria))
			return true;
		else
			return false;
	}
	public boolean deleteCategoria(int idCategoria) {
		if(dao.deleteCategoria(idCategoria))
			return true;
		else
			return false;
	}
}
