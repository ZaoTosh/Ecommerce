package ecommerce.prodotto.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//import org.apache.log4j.Logger;

import ecommerce.connection.ConnectionFactory;
import ecommerce.prodotto.model.CategoriaBean;

public class CategoriaDaoImpl implements ICategoriaDao{

//	final static Logger logger = Logger.getLogger(CategoriaDaoImpl.class);
	
	Connection conn = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	public int getSequence() {
		int idInd=0;
		String sequenzaCategoria= "select categoria_seq.nextval from dual";
		conn = ConnectionFactory.getIstance().getConnection();
		try {
			PreparedStatement pst= conn.prepareStatement(sequenzaCategoria);
			synchronized(this) {
				ResultSet rs= pst.executeQuery();
				if (rs.next()) {
					idInd = rs.getInt(1);
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return idInd;
	}

	@Override
	public boolean addCategoria(CategoriaBean categoria) {

		//logger.info("AddCategoria caricato");
		String query = "insert into categoria values"+"(?,?,?)";
		conn = ConnectionFactory.getIstance().getConnection();
		int i=0;
		try {
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1,getSequence());
			preparedStatement.setString(2, categoria.getNome());
			preparedStatement.setString(3,categoria.getUrlImmagine());
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
			System.out.println("Categoria aggiunta");
			return true;
		}
		else {
			System.out.println("Categoria non aggiunta");
			return false;
		}	


	}

	@Override
	public boolean deleteCategoria(int idCategoria) {
		//logger.info("DeleteCategoria caricato");

		String query = "delete from categoria where id_categoria = ?";
		conn = ConnectionFactory.getIstance().getConnection();
		int i = 0;
		try {
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, idCategoria);
			i = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			//logger.error("Errore nel database", e);
			e.printStackTrace();
		}catch(Exception e) {
			//logger.error("Errore",e);
			e.printStackTrace();
		}

		if (i>0) {
			System.out.println("Categoria eliminata");
			return true;
		}
		else {
			System.out.println("Categoria non presente");
			return false;
		}
	}

	@Override
	public boolean updateCategoria(CategoriaBean categoria) {
		//logger.info("UpdateCategoria caricato");
		String query =  "update categoria  SET  nome = ?, url_immagine=? where id_categoria = ?";
		conn = ConnectionFactory.getIstance().getConnection();
		int i = 0;
		try {
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, categoria.getNome());
			preparedStatement.setString(2, categoria.getUrlImmagine());
			preparedStatement.setInt(3, categoria.getIdCategoria());
			i = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			//logger.error("Errore nel database", e);
			e.printStackTrace();
		}catch(Exception e) {
			//logger.error("Errore",e);
			e.printStackTrace();
		}
		if (i > 0)
			return true;
		else				

			return false;
	}


	@Override
	public CategoriaBean getCategoriaById(int idCategoria) {
		//logger.info("getCategoriaById caricato");
		String query = "select * from categoria where id_categoria= ?";
		conn = ConnectionFactory.getIstance().getConnection();

		CategoriaBean categoriaAppoggio=null;

		try {
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, idCategoria);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				categoriaAppoggio=new CategoriaBean();
				categoriaAppoggio.setIdCategoria(idCategoria);
				categoriaAppoggio.setNome(resultSet.getString(2));
				categoriaAppoggio.setUrlImmagine(resultSet.getString(3));

			}
		} catch (SQLException e) {
			//logger.error("Errore nel database", e);
			e.printStackTrace();
		}catch(Exception e) {
			//logger.error("Errore",e);
			e.printStackTrace();
		}

		return categoriaAppoggio;	

	}

	@Override
	public ArrayList<CategoriaBean> getAllCategoria() {
		//logger.info("getAllCategoria caricato");
		
		String query = "select * from categoria";

		ArrayList<CategoriaBean> listaCategorie= new ArrayList<CategoriaBean>();
		conn = ConnectionFactory.getIstance().getConnection();

		try {
			preparedStatement = conn.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				CategoriaBean categoriaAppoggio= new CategoriaBean();
				categoriaAppoggio.setIdCategoria(resultSet.getInt(1));
				categoriaAppoggio.setNome(resultSet.getString(2));
				categoriaAppoggio.setUrlImmagine(resultSet.getString(3));
			
				listaCategorie.add(categoriaAppoggio);
			}
		} catch (SQLException e) {
			//logger.error("Errore nel database", e);
			e.printStackTrace();
		}catch(Exception e) {
			//logger.error("Errore",e);
			e.printStackTrace();
		}
		return listaCategorie;
	}

}
