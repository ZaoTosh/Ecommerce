package ecommerce.ordine.test;
import ecommerce.ordine.model.OrdineStoricoBean;

import java.util.ArrayList;

import ecommerce.ordine.dao.OrdineStoricoDaoImpl;

public class TestOrdineStorico {

	public static void main(String[] args) {

		OrdineStoricoDaoImpl osdi=new OrdineStoricoDaoImpl();
		OrdineStoricoBean osb1=new OrdineStoricoBean();
		OrdineStoricoBean osb2=new OrdineStoricoBean();
		OrdineStoricoBean osb3=new OrdineStoricoBean();
		
		osb1.setIdOrdine(1);
		osb1.setIdProdotto(5);
		osb1.setUsername("Utente1");
		osb1.setQuantitaAcquistata(5);
		osb1.setPrezzoTotale(50.58);
		osb2.setIdOrdine(2);
		osb2.setIdProdotto(7);
		osb2.setUsername("Utente2");
		osb2.setQuantitaAcquistata(7);
		osb2.setPrezzoTotale(120.52);
		osb3.setIdOrdine(1);
		osb3.setIdProdotto(8);
		osb3.setUsername("Utente1");
		osb3.setQuantitaAcquistata(15);
		osb3.setPrezzoTotale(10.85);
		
		System.out.println("Prova di inserimento variabili");
		System.out.println(osdi.addOrdineStorico(osb1));
		System.out.println(osdi.addOrdineStorico(osb2));
		System.out.println(osdi.addOrdineStorico(osb3));
		
		System.out.println("Prova di cancellazione dati");
		System.out.println(osdi.deleteOrdineStorico(1, 5));
		System.out.println(osdi.deleteOrdineStorico(2, 7));
		System.out.println(osdi.deleteOrdineStorico(1, 8));

		System.out.println("Prova di chiamata variabili");
		System.out.println(osdi.addOrdineStorico(osb1));
		System.out.println(osdi.addOrdineStorico(osb2));
		System.out.println(osdi.addOrdineStorico(osb3));
		System.out.println(osdi.getOrdineStoricoById(1, 5).toString());
		
		
		
		System.out.println("Prova di chiamata tutti i valori");
		System.out.println(osdi.deleteOrdineStorico(1, 5));
		ArrayList<OrdineStoricoBean> listaOrdiniStorici=new ArrayList<OrdineStoricoBean>();
		listaOrdiniStorici=osdi.getAllOrdineStorico();
		System.out.println(listaOrdiniStorici.size());
		for (OrdineStoricoBean ordineStoricoBean : listaOrdiniStorici) {
			System.out.println(ordineStoricoBean.toString());
		}
		System.out.println(osdi.deleteOrdineStorico(2, 7));
		System.out.println(osdi.deleteOrdineStorico(1, 8));
	}

}
