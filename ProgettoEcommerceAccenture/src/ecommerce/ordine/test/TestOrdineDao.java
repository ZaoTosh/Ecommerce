package ecommerce.ordine.test;

import java.time.LocalDate;
import java.util.ArrayList;

import ecommerce.ordine.dao.OrdineDaoImpl;
import ecommerce.ordine.model.OrdineBean;

public class TestOrdineDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		OrdineDaoImpl dao= new OrdineDaoImpl();
		
		/*OrdineBean ord1= new OrdineBean();
		LocalDate data1=LocalDate.of(2020, 07, 14);
		ord1.setDataOrdine(data1);
		ord1.setPrezzoTotale(20.5);
		ord1.setIndirizzo(3);
		ord1.setUtente("Utente1");
		boolean add1= dao.addOrdine(ord1);
		System.out.println(add1);
		
		OrdineBean ord2= new OrdineBean();
		LocalDate data2=LocalDate.of(2020, 07, 13);
		ord2.setDataOrdine(data2);
		ord2.setPrezzoTotale(100);
		ord2.setIndirizzo(2);
		ord2.setUtente("Utente2");
		
		boolean add2=dao.addOrdine(ord2);
		System.out.println(add2);
		
		
		OrdineBean ord3= new OrdineBean();
		LocalDate data3=LocalDate.of(2020, 06, 30);
		ord3.setDataOrdine(data3);
		ord3.setPrezzoTotale(100);
		ord3.setIndirizzo(6);
		ord3.setUtente("Utente3");
		
		boolean add3=dao.addOrdine(ord3);
		System.out.println(add3);
		
		OrdineBean ord4= new OrdineBean();
		LocalDate data4=LocalDate.of(2020, 07, 16);
		ord4.setDataOrdine(data4);
		ord4.setPrezzoTotale(50.75);
		ord4.setIndirizzo(3);
		ord4.setUtente("Utente1");

		boolean add4=dao.addOrdine(ord4);
		System.out.println(add4);
		
		boolean del1= dao.deleteOrdine(8);
		System.out.println(del1);*/
		
		/*OrdineBean getOrdine= new OrdineBean();
		getOrdine=dao.getOrdineById(9);
		System.out.println(getOrdine);*/
		
		ArrayList<OrdineBean> listaOrdini=new ArrayList<OrdineBean>();
		listaOrdini=dao.getAllOrdini();
		for(OrdineBean ordine:listaOrdini) {
			System.out.println("Ordine: " +  ordine);
		}
		
	}

}
