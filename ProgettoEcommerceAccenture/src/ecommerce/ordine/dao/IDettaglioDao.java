package ecommerce.ordine.dao;

import java.util.ArrayList;
import ecommerce.ordine.model.DettaglioBean;
import ecommerce.prodotto.model.ProdottoBean;

public interface IDettaglioDao {
	
	public boolean addDettaglio(DettaglioBean dettaglio);
	public boolean deleteDettaglio(int idDettaglio);
	public boolean updateDettaglio(DettaglioBean dettaglio);
	public DettaglioBean getDettaglioByIdDettaglio(int idDettaglio);
	public ArrayList<ProdottoBean> getProdottiByIdOrdine(int idOrdine);
	public ArrayList<DettaglioBean> getAllDettaglio();

}
