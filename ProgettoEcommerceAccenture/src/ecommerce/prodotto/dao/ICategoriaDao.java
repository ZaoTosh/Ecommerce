package ecommerce.prodotto.dao;

import java.util.ArrayList;

import ecommerce.prodotto.model.CategoriaBean;

public interface ICategoriaDao {

	public boolean addCategoria (CategoriaBean categoria);
	public boolean deleteCategoria (int idCategoria);
	public boolean updateCategoria(CategoriaBean categoria);
	public CategoriaBean getCategoriaById (int idCategoria);
	public ArrayList<CategoriaBean> getAllCategoria();
}
