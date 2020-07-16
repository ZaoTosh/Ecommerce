package ecommerce.ordine.test;

import java.util.ArrayList;

import ecommerce.ordine.dao.DettaglioDaoImpl;
import ecommerce.ordine.model.DettaglioBean;
import ecommerce.prodotto.model.*;

public class TestDettaglioDao {

	public static void main(String[] args) {
		
		DettaglioBean db1=new DettaglioBean();
		DettaglioBean db2=new DettaglioBean();
		DettaglioBean db3=new DettaglioBean();
		
		db1.setIdOrdine(4);
		db1.setIdProdotto(30);
		db1.setQuantitaAcquistata(1);
		db1.setPrezzoUnitario(2.50);
		
		DettaglioDaoImpl ddi=new DettaglioDaoImpl();
		
		System.out.println("prova di inserimento dati");
		System.out.println(ddi.addDettaglio(db1));
//		
//		System.out.println("prova di cancellazione dati");
//		System.out.println(ddi.deleteDettaglio(8));
		
//		System.out.println("prova di update dettaglio");
//		db1.setIdDettaglio(9);
//		db1.setIdOrdine(1);
//		db1.setIdProdotto(27);
//		db1.setQuantitaAcquistata(3);
//		db1.setPrezzoUnitario(2.00);
//		System.out.println(ddi.updateDettaglio(db1));
		
		System.out.println("test chiamata dettaglio");
		db2=ddi.getDettaglioByIdDettaglio(1);
		db3=ddi.getDettaglioByIdDettaglio(8);
		System.out.println(db2.toString());
		System.out.println(db3.toString());
		
		System.out.println("test lista prodotti ordine");
		ArrayList<ProdottoBean> listaProdotti=ddi.getProdottiByIdOrdine(4);
		for (ProdottoBean prodottoBean : listaProdotti) {
			System.out.println(prodottoBean.toString());
		}
		
		System.out.println("test lista dettagli");
		ArrayList<DettaglioBean> listaDettagli=ddi.getAllDettaglio();
		for (DettaglioBean dettaglioBean : listaDettagli) {
			System.out.println(dettaglioBean.toString());
		}
	}

}
