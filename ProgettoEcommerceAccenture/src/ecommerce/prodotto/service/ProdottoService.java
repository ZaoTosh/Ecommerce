package ecommerce.prodotto.service;

import java.util.ArrayList;
import java.util.LinkedList;

import ecommerce.prodotto.dao.ProdottoDaoImpl;
import ecommerce.prodotto.model.ProdottoBean;

public class ProdottoService {
	private ProdottoDaoImpl pd;
	public ProdottoService() {
		pd=new ProdottoDaoImpl();
	}
	public int getSequence(){
		return pd.getSequence();
	}
	public boolean addProdotto(ProdottoBean prodotto) {
		return pd.addProdotto(prodotto);
	}
	public boolean deleteProdotto(int id) {
		return pd.deleteProdotto(id);
	}
	public boolean updateProdotto(ProdottoBean prodotto) {
		return pd.updateProdotto(prodotto);
	}
	public ProdottoBean getProdottoById(int id) {
		return pd.getProdottoById(id);
	}
	public LinkedList<ProdottoBean> getAllProdotto() {
		return pd.getAllProdotto();
	}
	public ArrayList<ProdottoBean> getProdottoByCategoria(int idCategoria){
		return pd.getProdottoByCategoria(idCategoria);
	}
	public ProdottoDaoImpl getProdottoDaoImpl() {
		return pd;
	}
	public void setProdottoDaoImpl(ProdottoDaoImpl prodottoDaoImpl) {
		this.pd = prodottoDaoImpl;
	}
	@Override
	public String toString() {
		return "ProdottoService [pd=" + pd + "]";
	}

}
