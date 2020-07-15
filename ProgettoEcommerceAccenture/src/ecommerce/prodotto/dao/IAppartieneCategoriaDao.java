package ecommerce.prodotto.dao;

import java.util.ArrayList;

import ecommerce.prodotto.model.AppartieneCategoriaBean;


public interface IAppartieneCategoriaDao {

	public boolean addAppartieneCategoria (AppartieneCategoriaBean appartieneCategoria);
	public boolean deleteAppartieneCategoria (int idProdotto, int idCategoria);
	public boolean updateAppartieneCategoria(AppartieneCategoriaBean appartieneCategoria);
	public AppartieneCategoriaBean getAppartieneCategoria (int idProdotto, int idCategoria);
	public ArrayList<AppartieneCategoriaBean> getAllAppartieneCategoria();
	
}
