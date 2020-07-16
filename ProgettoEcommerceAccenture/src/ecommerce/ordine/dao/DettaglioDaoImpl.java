package ecommerce.ordine.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import ecommerce.connection.ConnectionFactory;
import ecommerce.ordine.model.DettaglioBean;
import ecommerce.prodotto.model.ProdottoBean;

public class DettaglioDaoImpl implements IDettaglioDao {
	
	private static final Logger logger = Logger.getLogger(DettaglioDaoImpl.class);

	Connection oggettoConnessione=null;
	PreparedStatement preparedStatement=null;
	ResultSet resultSet=null;

	public int getSequence(){
		int id=0;
		String query= "SELECT DETTAGLIO_SEQ.NEXTVAL FROM DUAL";
		oggettoConnessione = ConnectionFactory.getIstance().getConnection();
		try {
			PreparedStatement preparedStatement= oggettoConnessione.prepareStatement(query);
			synchronized(this) {
				ResultSet resultSet= preparedStatement.executeQuery();
				if (resultSet.next()) {
					id = resultSet.getInt(1);
				}
			}
		}catch (SQLException e){
			logger.error("Errore del database" , e);
		}catch (Exception e) {			
			logger.error("Errore generico " , e);
		}
		return id;
	}
	
	@Override
	public boolean addDettaglio(DettaglioBean dettaglio) {
		dettaglio.setIdDettaglio(getSequence());
		logger.info("add dettaglio " + dettaglio.getIdDettaglio());
		oggettoConnessione=ConnectionFactory.getIstance().getConnection();
		String query="INSERT INTO DETTAGLIO VALUES (?,?,?,?,?)";
		boolean ctrl=false;
		try {
			preparedStatement=oggettoConnessione.prepareStatement(query);
			preparedStatement.setInt(1, dettaglio.getIdDettaglio());
			preparedStatement.setInt(2, dettaglio.getIdOrdine());
			preparedStatement.setInt(3, dettaglio.getIdProdotto());
			preparedStatement.setInt(4, dettaglio.getQuantitaAcquistata());
			preparedStatement.setDouble(5, dettaglio.getPrezzoUnitario());
			int nModifiche=preparedStatement.executeUpdate();
			if (nModifiche==1) {
				ctrl=true;
			}
		}catch (SQLException e){
			System.out.println(e);
			logger.error("Errore del database" , e);
		}catch (Exception e) {		
			System.out.println(e);
			logger.error("Errore generico " , e);
		}
		logger.info("insert dettaglio invoked!!!");
		return ctrl;
	}

	@Override
	public boolean deleteDettaglio(int idDettaglio) {
		logger.info("delete dettaglio " + idDettaglio);
		oggettoConnessione=ConnectionFactory.getIstance().getConnection();
		String query="DELETE FROM DETTAGLIO WHERE ID_DETTAGLIO=?";
		boolean ctrl=false;
		try {
			preparedStatement=oggettoConnessione.prepareStatement(query);
			preparedStatement.setInt(1, idDettaglio);
			int nModifiche=preparedStatement.executeUpdate();
			if (nModifiche==1) {
				ctrl=true;
			}
		}catch (SQLException e){
			logger.error("Errore del database" , e);
		}catch (Exception e) {			
			logger.error("Errore generico " , e);
		}	
		logger.info("delete dettaglio invoked!!!");
		return ctrl;
	}

	@Override
	public boolean updateDettaglio(DettaglioBean dettaglio) {
		logger.info("update dettaglio " + dettaglio.getIdDettaglio());
		oggettoConnessione=ConnectionFactory.getIstance().getConnection();
		String query="UPDATE DETTAGLIO SET ID_DETTAGLIO=?,ID_ORDINE=?,ID_PRODOTTO=?,QUANTITA_ACQUISTATA=?,PREZZO_UNITARIO=? WHERE ID_DETTAGLIO=?";
		boolean ctrl=false;
		try {
			preparedStatement=oggettoConnessione.prepareStatement(query);
			preparedStatement.setInt(1, dettaglio.getIdDettaglio());
			preparedStatement.setInt(2, dettaglio.getIdOrdine());
			preparedStatement.setInt(3, dettaglio.getIdProdotto());
			preparedStatement.setInt(4, dettaglio.getQuantitaAcquistata());
			preparedStatement.setDouble(5, dettaglio.getPrezzoUnitario());
			preparedStatement.setInt(6, dettaglio.getIdDettaglio());
			int nModifiche=preparedStatement.executeUpdate();
			if (nModifiche==1) {
				ctrl=true;
			}
		}catch (SQLException e){
			logger.error("Errore del database" , e);
		}catch (Exception e) {			
			logger.error("Errore generico " , e);
		}	
		logger.info("update dettaglio invoked!!!");
		return ctrl;
	}

	@Override
	public DettaglioBean getDettaglioByIdDettaglio(int idDettaglio) {
		logger.info("get dettaglio " + idDettaglio);
		oggettoConnessione=ConnectionFactory.getIstance().getConnection();
		String query="SELECT * FROM DETTAGLIO WHERE ID_DETTAGLIO=?";
		DettaglioBean dettaglio=null;
		try {
			preparedStatement=oggettoConnessione.prepareStatement(query);
			preparedStatement.setInt(1, idDettaglio);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				dettaglio=new DettaglioBean();
				dettaglio.setIdDettaglio(resultSet.getInt(1));
				dettaglio.setIdOrdine(resultSet.getInt(2));
				dettaglio.setIdProdotto(resultSet.getInt(3));
				dettaglio.setQuantitaAcquistata(resultSet.getInt(4));
				dettaglio.setPrezzoUnitario(resultSet.getDouble(5));
			}
		}catch (SQLException e){
			logger.error("Errore del database" , e);
		}catch (Exception e) {			
			logger.error("Errore generico " , e);
		}	
		logger.info("get dettaglio invoked!!!");
		return dettaglio;
	}
	
	public ArrayList<ProdottoBean> getProdottiByIdOrdine(int idOrdine) {
		logger.info("get dettaglio by idOrdine" + idOrdine);
		oggettoConnessione=ConnectionFactory.getIstance().getConnection();
		String query="SELECT * FROM LISTA_PRODOTTI_ORDINE WHERE ID_ORDINE=?";
		ArrayList<ProdottoBean> listaProdotti=null;
		try {
			listaProdotti=new ArrayList<ProdottoBean>();
			preparedStatement=oggettoConnessione.prepareStatement(query);
			preparedStatement.setInt(1,idOrdine);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				ProdottoBean prodottoAppoggio=new ProdottoBean();
				prodottoAppoggio.setIdProdotto(resultSet.getInt(2));
				prodottoAppoggio.setPrezzo(resultSet.getDouble(3));
				prodottoAppoggio.setQuantitaDisponibile(resultSet.getInt(4));
				prodottoAppoggio.setNome(resultSet.getString(5));
				if (resultSet.getString(6)==null) {
					prodottoAppoggio.setDescrizione(null);
				}else {
					prodottoAppoggio.setDescrizione(resultSet.getString(6));
				}
				if (resultSet.getString(7)==null) {
					prodottoAppoggio.setUrl(null);
				}else {
					prodottoAppoggio.setUrl(resultSet.getString(7));
				}
				listaProdotti.add(prodottoAppoggio);
			}
		}catch (SQLException e){
			logger.error("Errore del database" , e);
		}catch (Exception e) {			
			logger.error("Errore generico " , e);
		}	
		logger.info("get dettaglio invoked!!!");
		return listaProdotti;
	}

	@Override
	public ArrayList<DettaglioBean> getAllDettaglio() {
		logger.info("get all dettagli");
		oggettoConnessione=ConnectionFactory.getIstance().getConnection();
		String query="SELECT * FROM DETTAGLIO";
		ArrayList<DettaglioBean> listaDettagli=null;
		try {
			listaDettagli=new ArrayList<DettaglioBean>();
			preparedStatement=oggettoConnessione.prepareStatement(query);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				DettaglioBean dettaglioAppoggio=new DettaglioBean();
				dettaglioAppoggio.setIdDettaglio(resultSet.getInt(1));
				dettaglioAppoggio.setIdOrdine(resultSet.getInt(2));
				dettaglioAppoggio.setIdProdotto(resultSet.getInt(3));
				dettaglioAppoggio.setQuantitaAcquistata(resultSet.getInt(4));
				dettaglioAppoggio.setPrezzoUnitario(resultSet.getDouble(5));
				listaDettagli.add(dettaglioAppoggio);
			}
		}catch (SQLException e){
			logger.error("Errore del database" , e);
		}catch (Exception e) {			
			logger.error("Errore generico " , e);
		}	
		logger.info("get all prodotti invoked!!!");
		return listaDettagli;
	}

}
