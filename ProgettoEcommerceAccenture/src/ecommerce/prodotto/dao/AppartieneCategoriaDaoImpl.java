package ecommerce.prodotto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList; 
//import org.apache.log4j.Logger;

import ecommerce.connection.ConnectionFactory;
import ecommerce.prodotto.model.AppartieneCategoriaBean;

public class AppartieneCategoriaDaoImpl implements IAppartieneCategoriaDao {
//final static Logger logger = Logger.getLogger(AppartieneCategoriaDaoImpl.class);
	
	Connection conn = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	@Override
	public boolean addAppartieneCategoria(AppartieneCategoriaBean appartieneCategoria) {
		//logger.info("AddAppartieneCategoria caricato");
		String query="insert into appartiene_categoria values (?,?)";
		conn = ConnectionFactory.getIstance().getConnection();
		int i=0;
		try {
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1,appartieneCategoria.getIdProdotto());
			preparedStatement.setInt(2,appartieneCategoria.getIdCategoria());
			i=preparedStatement.executeUpdate();
		}
		catch (SQLException e) {
			//logger.error("Errore nel database", e);
			e.printStackTrace();
		}catch(Exception e) {
			//logger.error("Errore",e);
			e.printStackTrace();
		}
		if (i>0) {
			System.out.println("Prodotto aggiunto alla categoria");
			return true;
		}
		else {
			System.out.println("Prodotto non aggiunto alla categoria");
			return false;
		}	
	}
	@Override
	public boolean deleteAppartieneCategoria(int idProdotto, int idCategoria) {
	//logger.info("DeleteAppartieneCategoria caricato");

		String query = "delete from appartiene_categoria where id_prodotto=? and id_categoria=?";
		conn = ConnectionFactory.getIstance().getConnection();
		int i = 0;
		try {
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, idProdotto);
			preparedStatement.setInt(2, idCategoria);
			i = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			//logger.error("Errore nel database", e);
			e.printStackTrace();
		}catch(Exception e) {
			//logger.error("Errore",e);
		}

		if (i>0) {
			System.out.println("Prodotto eliminato dalla categoria");
			return true;
		}
		else {
			System.out.println("Prodotto non presente alla categoria");
			return false;
		}
	}
	@Override
	public boolean updateAppartieneCategoria(AppartieneCategoriaBean appartieneCategoria) {
		//logger.info("UpdateAppartieneCategoria caricato");
		String query =  "update appartiene_categoria  SET  id_categoria = ? where id_prodotto = ?";
		conn = ConnectionFactory.getIstance().getConnection();
		int i = 0;
		try {
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, appartieneCategoria.getIdCategoria());
			preparedStatement.setInt(2, appartieneCategoria.getIdProdotto());
			i = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			//logger.error("Errore nel database", e);
			e.printStackTrace();
		}catch(Exception e) {
			//logger.error("Errore",e);
		}
		if (i > 0)
			return true;
		else				

			return false;
	}
	@Override
	public AppartieneCategoriaBean getAppartieneCategoria(int idProdotto, int idCategoria) {
		//logger.info("getAppartieneCategoriaById caricato");
		String query = "select * from appartiene_categoria where id_prodotto=? and id_categoria=?";
		conn = ConnectionFactory.getIstance().getConnection();

		AppartieneCategoriaBean appartieneCategoriaAppoggio=null;

		try {
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, idProdotto);
			preparedStatement.setInt(2, idCategoria);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				appartieneCategoriaAppoggio=new AppartieneCategoriaBean();
				appartieneCategoriaAppoggio.setIdProdotto(resultSet.getInt(1));
				appartieneCategoriaAppoggio.setIdCategoria(resultSet.getInt(2));

			}
		} catch (SQLException e) {
			//logger.error("Errore nel database", e);
			e.printStackTrace();
		}catch(Exception e) {
			//logger.error("Errore",e);
		}

		return appartieneCategoriaAppoggio;
	}
	@Override
	public ArrayList<AppartieneCategoriaBean> getAllAppartieneCategoria() {
		//logger.info("getAllCategoria caricato");
		
		String query = "select * from appartiene_categoria";

		ArrayList<AppartieneCategoriaBean> listaAppartieneCategorie= new ArrayList<AppartieneCategoriaBean>();
		conn = ConnectionFactory.getIstance().getConnection();

		try {
			preparedStatement = conn.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				
				AppartieneCategoriaBean appartieneCategoriaAppoggio= new AppartieneCategoriaBean();
				appartieneCategoriaAppoggio.setIdProdotto(resultSet.getInt(1));
				appartieneCategoriaAppoggio.setIdCategoria(resultSet.getInt(2));
			
				
				listaAppartieneCategorie.add(appartieneCategoriaAppoggio);
			}
		} catch (SQLException e) {
			//logger.error("Errore nel database", e);
			e.printStackTrace();
		}catch(Exception e) {
			//logger.error("Errore",e);
			e.printStackTrace();
		}
		return listaAppartieneCategorie;
	}
	}

