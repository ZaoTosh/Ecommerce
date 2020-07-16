package ecommerce.prodotto.test;

import java.util.LinkedList;
import java.util.ArrayList;

import javax.swing.plaf.synth.SynthScrollBarUI;

import ecommerce.prodotto.dao.ProdottoDaoImpl;
import ecommerce.prodotto.model.ProdottoBean;

public class TestProdottoDao {

	public static void main(String[] args) {
		
		ProdottoBean pb1=new ProdottoBean();
		ProdottoBean pb2=new ProdottoBean();
		ProdottoBean pb3=new ProdottoBean();
		ProdottoBean pb4=new ProdottoBean();
		ProdottoBean pb5=new ProdottoBean();
		ProdottoBean pb6=new ProdottoBean();
		
		//inserimento di qualche dato
		pb1.setPrezzo(12.50);
		pb1.setQuantitaDisponibile(5);
		pb1.setNome("ciabatte");
		pb1.setDescrizione("ciabatte comode e confortevoli");
		pb1.setUrl("httpS://www.google.com");
		//System.out.println(pb1.toString());
		
		pb2.setPrezzo(1200);
		pb2.setQuantitaDisponibile(1);
		pb2.setNome("smartphone");
		pb2.setDescrizione("ultimo modello smartphone");
		//System.out.println(pb2.toString());
		
		pb3.setPrezzo(1.50);
		pb3.setQuantitaDisponibile(150);
		pb3.setNome("matita");
		pb3.setUrl("httpS://www.google.com");
		//System.out.println(pb3.toString());
		
		pb4.setPrezzo(65.99);
		pb4.setQuantitaDisponibile(10);
		pb4.setNome("felpa");
		//System.out.println(pb4.toString());
		
		pb5.setPrezzo(125);
		pb5.setQuantitaDisponibile(2);
		pb5.setNome("collana");
		pb5.setDescrizione("collana in argento");
		pb5.setUrl("httpS://www.google.com");
		//System.out.println(pb5.toString());
		
		ProdottoDaoImpl pdi=new ProdottoDaoImpl();
		
//		System.out.println("Verifica inserimento");
//		System.out.println(pdi.addProdotto(pb1));
//		System.out.println(pdi.addProdotto(pb2));
//		System.out.println(pdi.addProdotto(pb3));
//		System.out.println(pdi.addProdotto(pb4));
//		System.out.println(pdi.addProdotto(pb5));

//		System.out.println("Verifica cancellazione");
//	
//		System.out.println(pdi.deleteProdotto(1));
//		System.out.println(pdi.deleteProdotto(2));
//		System.out.println(pdi.deleteProdotto(3));
//		System.out.println(pdi.deleteProdotto(4));
//		
//		System.out.println("Verifica update prodotto");
//		pb6.setIdProdotto(26);
//		pb6.setPrezzo(25.99);
//		pb6.setQuantitaDisponibile(15);
//		pb6.setNome("cuffie");
//		pb6.setDescrizione("cuffie wireless");
//		pb6.setUrl("httpS://www.google.com");
//		System.out.println(pb6.toString());
//		System.out.println(pdi.updateProdotto(pb6));
//		
//		System.out.println("verifica chiamata per id");
//		System.out.println(pdi.getProdottoById(6).toString());
//		System.out.println(pdi.getProdottoById(7).toString());
//		
//		
//		System.out.println("verifica tutte le chiamate");
//		LinkedList<ProdottoBean> listaProdotti=new LinkedList<ProdottoBean>();
//		listaProdotti=pdi.getAllProdotto();
//		System.out.println(listaProdotti.size());
//		for (ProdottoBean prodottoBean : listaProdotti) {
//			System.out.println(prodottoBean.toString());
//		}
		
		System.out.println("Test chiamata per categoria");
		ArrayList<ProdottoBean> listaProdotti=pdi.getProdottoByCategoria(1);
		for (ProdottoBean prodottoBean : listaProdotti) {
			System.out.println(prodottoBean.toString());
		}
		listaProdotti=pdi.getProdottoByCategoria(5);
		for (ProdottoBean prodottoBean : listaProdotti) {
			System.out.println(prodottoBean.toString());
		}
//		
	}

}
