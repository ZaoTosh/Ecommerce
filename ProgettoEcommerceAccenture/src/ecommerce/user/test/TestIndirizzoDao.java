package ecommerce.user.test;

import java.util.ArrayList;

import ecommerce.user.dao.IndirizzoDaoImpl;
import ecommerce.user.model.IndirizzoBean;

public class TestIndirizzoDao {

	public static void main(String[] args) {
		
		IndirizzoDaoImpl dao= new IndirizzoDaoImpl();
		
		IndirizzoBean indirizzo1= new IndirizzoBean();
		indirizzo1.setVia("Via Milano");
		indirizzo1.setNumero(3);
		indirizzo1.setCitta("Como");
		indirizzo1.setCap(22100);
		indirizzo1.setUtente("user1");
		indirizzo1.setUltimoIndirizzo("N");
		
		IndirizzoBean indirizzo2= new IndirizzoBean();
		indirizzo2.setVia("Via Roma");
		indirizzo2.setNumero(5);
		indirizzo2.setCitta("Como");
		indirizzo2.setCap(22100);
		indirizzo2.setUtente("user1");
		indirizzo2.setUltimoIndirizzo("Y");
		
		IndirizzoBean indirizzo3= new IndirizzoBean();
		indirizzo3.setVia("Via Michelangelo");
		indirizzo3.setNumero(3);
		indirizzo3.setCitta("Firenze");
		indirizzo3.setCap(20100);
		indirizzo3.setUtente("user2");
		indirizzo3.setUltimoIndirizzo("Y");
		
		boolean esito1=dao.addIndirizzo(indirizzo1);
		System.out.println(esito1);
		
		boolean esito2=dao.addIndirizzo(indirizzo2);
		System.out.println(esito2);
		
		boolean esito3=dao.addIndirizzo(indirizzo3);
		System.out.println(esito3);
		
		//boolean esito4=dao.deleteIndirizzo(11);
		//System.out.println(esito4);
		
		/*IndirizzoBean indirizzo1agg= new IndirizzoBean();
		indirizzo1agg.setIdIndirizzo(indirizzo1.getIdIndirizzo());
		indirizzo1agg.setVia("Via Ferrari");
		indirizzo1agg.setNumero(14);
		indirizzo1agg.setCitta("Como");
		indirizzo1agg.setCap(22100);
		indirizzo1agg.setUtente("user1");
		indirizzo1agg.setUltimoIndirizzo("Y");
		
		boolean esito5=dao.updateIndirizzo(indirizzo1agg);
		System.out.println(esito5);
		System.out.println(indirizzo1agg);
		
		IndirizzoBean getIndirizzo= new IndirizzoBean();
		getIndirizzo= dao.getIndirizzoById(indirizzo2.getIdIndirizzo());
		System.out.println(getIndirizzo);
		
		ArrayList<IndirizzoBean> listaIndirizzi=dao.getAllIndirizzi();
		for (IndirizzoBean indirizzoBean : listaIndirizzi) {
			System.out.println("indirizzo -> " +  indirizzoBean);
			}*/
		IndirizzoBean IndirizzoByUser=dao.getUltimoIndirizzoByUser("user1");
		System.out.println(IndirizzoByUser);
	}
		
	}

