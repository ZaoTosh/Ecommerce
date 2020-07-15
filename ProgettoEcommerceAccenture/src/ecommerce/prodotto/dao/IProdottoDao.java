package ecommerce.prodotto.dao;

import java.util.ArrayList;
import java.util.LinkedList;

import ecommerce.prodotto.model.ProdottoBean;

public interface IProdottoDao {
	
	public boolean addProdotto(ProdottoBean prodotto);
	public boolean deleteProdotto(int id);
	public boolean updateProdotto(ProdottoBean prodotto);
	public ProdottoBean getProdottoById(int id);
	public LinkedList<ProdottoBean> getAllProdotto();
	public ArrayList<ProdottoBean> getProdottoByCategoria(int idCategoria);

}