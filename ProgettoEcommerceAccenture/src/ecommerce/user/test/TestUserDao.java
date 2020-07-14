package ecommerce.user.test;

import java.time.LocalDate;
import java.util.ArrayList;

import ecommerce.user.dao.UserDaoImpl;
import ecommerce.user.model.UserBean;



public class TestUserDao {
	public static void main(String[] args) {

		UserBean us1=new UserBean();
		UserBean us2=new UserBean();
		UserBean us3=new UserBean();
		UserBean us4=new UserBean();
		UserBean us5=new UserBean();
		
		us1.setUsername("Alessio");
		us1.setPassword("password1");
		us1.setNome("Nome1");
		us1.setCognome("Cognome1");
		LocalDate data1=LocalDate.of(2020, 12, 28);
		us1.setDataNascita(data1);
		
		us2.setUsername("prova");
		us2.setPassword("password1");
		us2.setNome("Nome1");
		us2.setCognome("Cognome1");
		LocalDate data2=LocalDate.of(2015, 5, 8);
		us2.setDataNascita(data2);
		
		us5.setUsername("prova2");
		us5.setPassword("password1");
		us5.setNome("Nome1");
		us5.setCognome("Cognome1");

		
		UserDaoImpl us=new UserDaoImpl();
//
//		System.out.println("Prova di inserimento");	
//		System.out.println(us.addUser(us1));
//		System.out.println(us.addUser(us2));
//		System.out.println(us5);
//		System.out.println(us.addUser(us5));
//		System.out.println("Prova di cancellazione");
//		System.out.println(us.deleteUser("Alessio"));
//		System.out.println(us.deleteUser("prova"));
//		
//		System.out.println("Prova di variazione");
//		us.addUser(us1);
//		us.addUser(us2);
//		us3.setUsername("prova");
//		us3.setPassword("passwordcambiata");
//		us3.setNome("Nomecambiato");
//		us3.setCognome("Cognomecambiato");
//		LocalDate data3=LocalDate.of(2020, 12, 28);
//		us3.setDataNascita(data3);
//		System.out.println(us.updateUserByUsername(us3));
////		
//		System.out.println("Prova di chiamata");
//		us1=us.getUserByUsername("prova");
//		System.out.println(us1.toString());
//		us1=us.getUserByUsername("Alessio");
//		System.out.println(us1.toString());
//		System.out.println("Prova di chiamata null");
//		us4=us.getUserByUsername("ciao");
//		System.out.println(us4);
//		
//		System.out.println("Prova chiamata tutti user");
//		ArrayList<UserBean> lista=new ArrayList<UserBean>();
//		lista=us.getAllUser();
//		for (UserBean userBean : lista) {
//			System.out.println(userBean.toString());
//		}
//		System.out.println(us.deleteUser("Alessio"));
//		System.out.println(us.deleteUser("prova"));
	}

}
