package ecommerce.ordine.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import ecommerce.connection.ConnectionFactory;
import ecommerce.ordine.model.OrdineStoricoBean;

public class OrdineStoricoDaoImpl implements IOrdineStoricoDao {

	private static final Logger logger = Logger.getLogger(OrdineStoricoDaoImpl.class);

	Connection oggettoConnessione=null;
	PreparedStatement preparedStatement=null;
	ResultSet resultSet=null;

	@Override
	public boolean addOrdineStorico(OrdineStoricoBean ordineStorico) {
		logger.info("add Ordine storico");
		oggettoConnessione=ConnectionFactory.getIstance().getConnection();
		String query="INSERT INTO ORDINESTORICO VALUES (?,?,?,?,?)";
		boolean ctrl=false;
		try{
			preparedStatement=oggettoConnessione.prepareStatement(query);
			preparedStatement.setInt(1,ordineStorico.getIdOrdine());
			preparedStatement.setInt(2,ordineStorico.getIdProdotto());
			preparedStatement.setString(3,ordineStorico.getUsername());
			preparedStatement.setInt(4,ordineStorico.getQuantitaAcquistata());
			preparedStatement.setDouble(5,ordineStorico.getPrezzoTotale());
			int nModifiche=preparedStatement.executeUpdate();
			if (nModifiche==1) {
				ctrl=true;
			}
		}catch(SQLException e) {
			System.out.println(e);
			logger.error("Errore del database"+e);
		}catch(Exception e) {
			System.out.println(e);
			logger.error("Errore generico "+e);
		}
		logger.info("insert ordine storico invoked!!!");
		return ctrl;
	}

	@Override
	public boolean deleteOrdineStorico(int idOrdine, int idProdotto) {
		logger.info("delete ordine storico");
		oggettoConnessione=ConnectionFactory.getIstance().getConnection();
		String query="DELETE FROM ORDINESTORICO WHERE ID_ORDINE=? AND ID_PRODOTTO=?";
		boolean ctrl=false;
		try {
			preparedStatement=oggettoConnessione.prepareStatement(query);
			preparedStatement.setInt(1, idOrdine);
			preparedStatement.setInt(2, idProdotto);
			int nModifiche=preparedStatement.executeUpdate();
			if (nModifiche==1) {
				ctrl=true;
			}
		}catch(SQLException e) {
			System.out.println(e);
			logger.error("Errore del database"+e);
		}catch(Exception e) {
			System.out.println(e);
			logger.error("Errore generico "+e);
		}
		logger.info("delete ordine storico invoked!!!");
		return ctrl;
	}

	@Override
	public boolean updateOridnestorico(OrdineStoricoBean ordineStorico) {
		logger.info("update ordine storico");
		oggettoConnessione=ConnectionFactory.getIstance().getConnection();
		String query="UPDATE ORDINESTORICO SET ID_ORDINE=?,ID_PRODOTTO=?,USERNAME=?,QUANTITA_ACQUISTATA=?,PREZZO_TOTALE=? WHERE ID_ORDINE=? AND ID_PRODOTTO=?";
		boolean ctrl=false;
		try {
			preparedStatement=oggettoConnessione.prepareStatement(query);
			preparedStatement.setInt(1, ordineStorico.getIdOrdine());
			preparedStatement.setInt(2, ordineStorico.getIdProdotto());
			preparedStatement.setString(3, ordineStorico.getUsername());
			preparedStatement.setInt(4, ordineStorico.getQuantitaAcquistata());
			preparedStatement.setDouble(5, ordineStorico.getPrezzoTotale());
			preparedStatement.setInt(6, ordineStorico.getIdOrdine());
			preparedStatement.setInt(7, ordineStorico.getIdProdotto());
			int nModifiche=preparedStatement.executeUpdate();
			if (nModifiche==1) {
				ctrl=true;
			}
		}catch(SQLException e) {
			System.out.println(e);
			logger.error("Errore del database"+e);
		}catch(Exception e) {
			System.out.println(e);
			logger.error("Errore generico "+e);
		}
		logger.info("delete ordine storico invoked!!!");
		return ctrl;
	}

	@Override
	public OrdineStoricoBean getOrdineStoricoById(int idOrdine, int idProdotto) {
		logger.info("get Ordine storico by Id");
		oggettoConnessione=ConnectionFactory.getIstance().getConnection();
		String query="SELECT * FROM ORDINESTORICO WHERE ID_ORDINE=? AND ID_PRODOTTO=?";
		OrdineStoricoBean ordineStorico=null;
		try{
			preparedStatement=oggettoConnessione.prepareStatement(query);
			preparedStatement.setInt(1, idOrdine);
			preparedStatement.setInt(2,idProdotto);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				ordineStorico=new OrdineStoricoBean();
				ordineStorico.setIdOrdine(resultSet.getInt(1));
				ordineStorico.setIdProdotto(resultSet.getInt(2));
				ordineStorico.setUsername(resultSet.getString(3));
				ordineStorico.setQuantitaAcquistata(resultSet.getInt(4));
				ordineStorico.setPrezzoTotale(resultSet.getInt(5));
			}
		}catch(SQLException e) {
			System.out.println(e);
			logger.error("Errore del database"+e);
		}catch(Exception e) {
			System.out.println(e);
			logger.error("Errore generico "+e);
		}
		logger.info("get Ordine storico invoked!!!");
		return ordineStorico;
	}

	@Override
	public ArrayList<OrdineStoricoBean> getAllOrdineStorico() {
		logger.info("get All Ordine Storico");
		String query="SELECT * FROM ORDINESTORICO";
		oggettoConnessione=ConnectionFactory.getIstance().getConnection();
		ArrayList<OrdineStoricoBean> listaOrdiniStorico=null;
		try {
			listaOrdiniStorico=new ArrayList<OrdineStoricoBean>();
			preparedStatement=oggettoConnessione.prepareStatement(query);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				OrdineStoricoBean ordineAppoggio=new OrdineStoricoBean();
				ordineAppoggio.setIdOrdine(resultSet.getInt(1));
				ordineAppoggio.setIdProdotto(resultSet.getInt(2));
				ordineAppoggio.setUsername(resultSet.getString(3));
				ordineAppoggio.setQuantitaAcquistata(resultSet.getInt(4));
				ordineAppoggio.setPrezzoTotale(resultSet.getInt(5));
				listaOrdiniStorico.add(ordineAppoggio);
			}
		}catch(SQLException e) {
			System.out.println(e);
			logger.error("Errore del database"+e);
		}catch(Exception e) {
			System.out.println(e);
			logger.error("Errore generico "+e);
		}
		logger.info("get all Ordine Storico invoked!!!");
		return listaOrdiniStorico;
	}

}
