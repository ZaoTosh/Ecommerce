package ecommerce.cart.service;
import ecommerce.user.dao.*;

import java.util.ArrayList;
import java.util.HashMap;

import ecommerce.prodotto.dao.*;
import ecommerce.prodotto.model.*;
import ecommerce.user.model.*;
public class CartService {
	private IndirizzoDaoImpl addressDao = new IndirizzoDaoImpl();
	private ProdottoDaoImpl prodottoDao = new ProdottoDaoImpl();
	 public HashMap<IndirizzoBean,ArrayList<ProdottoBean>> getCartDetails(String username, HashMap<Integer,Integer> mappa){
		 ArrayList<ProdottoBean> resultProdotti = new ArrayList<ProdottoBean>();
		 for(Integer idProdotto : mappa.keySet()) {
			 ProdottoBean prodotto = prodottoDao.getProdottoById(idProdotto);
			 prodotto.setQuantitaDisponibile(mappa.get(idProdotto));
			 resultProdotti.add(prodotto);
		 }
		 IndirizzoBean indirizzo = addressDao.getUltimoIndirizzoByUser(username);
		 HashMap<IndirizzoBean,ArrayList<ProdottoBean>> result = new  HashMap<IndirizzoBean,ArrayList<ProdottoBean>>();
		 result.put(indirizzo, resultProdotti);
		 return result;
		 
	 }
}
