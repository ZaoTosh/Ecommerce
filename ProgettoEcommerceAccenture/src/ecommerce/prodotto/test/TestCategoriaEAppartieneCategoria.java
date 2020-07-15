package ecommerce.prodotto.test;

import java.util.ArrayList;

import ecommerce.prodotto.dao.AppartieneCategoriaDaoImpl;
import ecommerce.prodotto.dao.CategoriaDaoImpl;
import ecommerce.prodotto.model.AppartieneCategoriaBean;
import ecommerce.prodotto.model.CategoriaBean;

public class TestCategoriaEAppartieneCategoria {

	public static void main(String[] args) {
	
		//test categoria		
		
		/*CategoriaDaoImpl daoCategoria=new CategoriaDaoImpl();

		CategoriaBean cat1= new CategoriaBean();
		cat1.setNome("Musica");

		CategoriaBean cat2= new CategoriaBean();
		cat2.setNome("Cancelleria");

		CategoriaBean cat3= new CategoriaBean();
		cat3.setNome("Tecnologia");

		boolean esito1= daoCategoria.addCategoria(cat1);
		System.out.println(esito1);
		
		boolean esito2= daoCategoria.addCategoria(cat2);
		System.out.println(esito2);
		
		boolean esito3= daoCategoria.addCategoria(cat3);
		System.out.println(esito3);
		
		boolean esito4=daoCategoria.deleteCategoria(2);
		System.out.println(esito4);
		
		CategoriaBean getCat= new CategoriaBean();
		getCat=daoCategoria.getCategoriaById(4);
		System.out.println(getCat);
		
		ArrayList<CategoriaBean> listaCat=daoCategoria.getAllCategoria();
		for (CategoriaBean categoriaBean : listaCat) {
			System.out.println("categoria: " +  categoriaBean);
			}*/
		
		//test Appartiene Categoria
		
		AppartieneCategoriaDaoImpl dao=new AppartieneCategoriaDaoImpl();
				
		/*AppartieneCategoriaBean appCat1= new AppartieneCategoriaBean();
		appCat1.setIdCategoria(1);
		appCat1.setIdProdotto(3);

		AppartieneCategoriaBean appCat2= new AppartieneCategoriaBean();
		appCat2.setIdCategoria(10);
		appCat2.setIdProdotto(1);
		
		AppartieneCategoriaBean appCat3= new AppartieneCategoriaBean();
		appCat3.setIdCategoria(9);
		appCat3.setIdProdotto(2);*/
		
		
//		boolean app1= dao.addAppartieneCategoria(appCat1);
//		System.out.println(app1);
		
		/*boolean app2= dao.addAppartieneCategoria(appCat2);
		System.out.println(app2);
		
		boolean app3= dao.addAppartieneCategoria(appCat3);
		System.out.println(app3);*/
		
		boolean deleteApp= dao.deleteAppartieneCategoria(2, 9);
		System.out.println(deleteApp);
		
		AppartieneCategoriaBean getAppCat= new AppartieneCategoriaBean();
		getAppCat=dao.getAppartieneCategoria(1, 10);
		System.out.println(getAppCat);
		
		ArrayList<AppartieneCategoriaBean> listaAppCat=dao.getAllAppartieneCategoria();
		for (AppartieneCategoriaBean appcategoriaBean : listaAppCat) {
			System.out.println("Appartiene categoria: " +  appcategoriaBean);
			}
		
	}

}
