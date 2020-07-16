package ecommerce.ordine.dao;

import java.util.ArrayList;

import ecommerce.ordine.model.OrdineStoricoBean;

public interface IOrdineStoricoDao {
	
	public boolean addOrdineStorico(OrdineStoricoBean ordineStorico);
	public boolean deleteOrdineStorico(int idOrdine,int idProdotto);
	public boolean updateOridnestorico(OrdineStoricoBean ordineStorico);
	public OrdineStoricoBean getOrdineStoricoById(int idOrdine,int idProdotto);
	public ArrayList<OrdineStoricoBean> getAllOrdineStorico();
	
}
