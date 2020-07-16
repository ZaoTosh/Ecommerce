package ecommerce.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ecommerce.connection.ConnectionFactory;
import ecommerce.user.model.IndirizzoBean;

public class IndirizzoDaoImpl implements IDaoIndirizzo{

//	final static Logger logger = Logger.getLogger(IndirizzoDaoImpl.class);

	Connection conn = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	public int getSequence() {
		int idInd=0;
		String sequenzaIndirizzo= "select indirizzo_seq.nextval from dual";
		conn = ConnectionFactory.getIstance().getConnection();
		try {
			PreparedStatement pst= conn.prepareStatement(sequenzaIndirizzo);
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
	public boolean addIndirizzo(IndirizzoBean indirizzo) {
		//logger.info("AddIndirizzo caricato");
				String query = "insert into indirizzo values"+"(?,?,?,?,?,?,?)";
				conn = ConnectionFactory.getIstance().getConnection();
				int i=0;
				try {
					preparedStatement = conn.prepareStatement(query);
					preparedStatement.setInt(1,getSequence());
					preparedStatement.setString(2, indirizzo.getVia());
					preparedStatement.setInt(3, indirizzo.getNumero());
					preparedStatement.setString(4, indirizzo.getCitta());
					preparedStatement.setInt(5, indirizzo.getCap());
					preparedStatement.setString(6,indirizzo.getUtente());
					preparedStatement.setString(7, indirizzo.getUltimoIndirizzo());
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
					System.out.println("Indirizzo aggiunto");
					return true;
				}
				else {
					System.out.println("Indirizzo non aggiunto");
					return false;
				}	
		
	}

	@Override
	public boolean deleteIndirizzo(int idIndirizzo) {
		//logger.info("DeleteIndirizzo caricato");
		
				String query = "delete from indirizzo where id_indirizzo = ?";
				conn = ConnectionFactory.getIstance().getConnection();
				int i = 0;
				try {
					preparedStatement = conn.prepareStatement(query);
					preparedStatement.setInt(1, idIndirizzo);
					i = preparedStatement.executeUpdate();

				} catch (SQLException e) {
					//logger.error("Errore nel database", e);
					e.printStackTrace();
				}catch(Exception e) {
					//logger.error("Errore",e);
					e.printStackTrace();
				}

				if (i>0) {
					System.out.println("Indirizzo eliminato");
					return true;
				}
				else {
					System.out.println("Indirizzo non presente");
					return false;
				}
	}

	@Override
	public boolean updateIndirizzo(IndirizzoBean indirizzo) {
		
		//logger.info("UpdateIndirizzo caricato");
				String query =  "update indirizzo  SET  via = ?, numero=?, citta=?, cap=?,utente=?, ultimo_indirizzo=? where id_indirizzo = ?";
				conn = ConnectionFactory.getIstance().getConnection();
				int i = 0;
				try {
					preparedStatement = conn.prepareStatement(query);
					preparedStatement.setString(1, indirizzo.getVia());
					preparedStatement.setInt(2, indirizzo.getNumero());
					preparedStatement.setString(3, indirizzo.getCitta());
					preparedStatement.setInt(4, indirizzo.getCap());
					preparedStatement.setString(5, indirizzo.getUtente());
					preparedStatement.setString(6, indirizzo.getUltimoIndirizzo());
					preparedStatement.setInt(7, indirizzo.getIdIndirizzo());
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
	public IndirizzoBean getIndirizzoById(int idIndirizzo) {
		//logger.info("getIndirizzoById caricato");
				String query = "select * from indirizzo where id_indirizzo= ?";
				conn = ConnectionFactory.getIstance().getConnection();

				IndirizzoBean indirizzoAppoggio = null;

				try {
					preparedStatement = conn.prepareStatement(query);
					preparedStatement.setInt(1, idIndirizzo);
					resultSet = preparedStatement.executeQuery();
					while (resultSet.next()) {

						indirizzoAppoggio = new IndirizzoBean();
						indirizzoAppoggio.setIdIndirizzo(idIndirizzo);
						indirizzoAppoggio.setVia(resultSet.getString(2));
						indirizzoAppoggio.setNumero(resultSet.getInt(3));
						indirizzoAppoggio.setCitta(resultSet.getString(4));
						indirizzoAppoggio.setCap(resultSet.getInt(5));
						indirizzoAppoggio.setUtente(resultSet.getString(6));
						indirizzoAppoggio.setUltimoIndirizzo(resultSet.getString(7));

						//System.out.println(indirizzoAppoggio);
					}
				} catch (SQLException e) {
					//logger.error("Errore nel database", e);
					e.printStackTrace();
				}catch(Exception e) {
					//logger.error("Errore",e);
					e.printStackTrace();
				}

				return indirizzoAppoggio;	

	}

	@Override
	public ArrayList<IndirizzoBean> getAllIndirizzi() {
		//logger.info("getAllIndirizzi caricato");
		
				String query = "select * from indirizzo";

				ArrayList<IndirizzoBean> listaIndirizzi= new ArrayList<IndirizzoBean>();
				conn = ConnectionFactory.getIstance().getConnection();

				try {
					preparedStatement = conn.prepareStatement(query);
					resultSet = preparedStatement.executeQuery();
					while (resultSet.next()) {
						IndirizzoBean indirizzoAppoggio= new IndirizzoBean();
						indirizzoAppoggio.setIdIndirizzo(resultSet.getInt(1));
						indirizzoAppoggio.setVia(resultSet.getString(2));
						indirizzoAppoggio.setNumero(resultSet.getInt(3));
						indirizzoAppoggio.setCitta(resultSet.getString(4));
						indirizzoAppoggio.setCap(resultSet.getInt(5));
						indirizzoAppoggio.setUtente(resultSet.getString(6));
						indirizzoAppoggio.setUltimoIndirizzo(resultSet.getString(7));

						listaIndirizzi.add(indirizzoAppoggio);
					}
				} catch (SQLException e) {
					//logger.error("Errore nel database", e);
					e.printStackTrace();
				}catch(Exception e) {
					//logger.error("Errore",e);
				}
				return listaIndirizzi;
			}

	@Override
	public IndirizzoBean getUltimoIndirizzoByUser(String utente) {
		
		//logger.info("getUltimoIndirizzoByUSer caricato");
		String query = "select * from indirizzo where utente=? and ultimo_indirizzo= 'Y'";
		conn = ConnectionFactory.getIstance().getConnection();

		IndirizzoBean indirizzoAppoggio = null;

		try {
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, utente);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				indirizzoAppoggio = new IndirizzoBean();
				
				indirizzoAppoggio.setIdIndirizzo(resultSet.getInt(1));
				indirizzoAppoggio.setVia(resultSet.getString(2));
				indirizzoAppoggio.setNumero(resultSet.getInt(3));
				indirizzoAppoggio.setCitta(resultSet.getString(4));
				indirizzoAppoggio.setCap(resultSet.getInt(5));
				indirizzoAppoggio.setUtente(utente);
				indirizzoAppoggio.setUltimoIndirizzo(resultSet.getString(7));

			}
		} catch (SQLException e) {
			//logger.error("Errore nel database", e);
			e.printStackTrace();
		}catch(Exception e) {
			//logger.error("Errore",e);
			e.printStackTrace();
		}

		return indirizzoAppoggio;	
	
	}

	@Override
	public ArrayList<IndirizzoBean> getAllIndirizziByUser(String utente) {
		String query = "select * from indirizzo where utente=?";
		conn = ConnectionFactory.getIstance().getConnection();

		ArrayList<IndirizzoBean> arrayIndirizzi = new ArrayList<IndirizzoBean>();
		

		try {
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, utente);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				IndirizzoBean indirizzoAppoggio = new IndirizzoBean();
				
				indirizzoAppoggio.setIdIndirizzo(resultSet.getInt(1));
				indirizzoAppoggio.setVia(resultSet.getString(2));
				indirizzoAppoggio.setNumero(resultSet.getInt(3));
				indirizzoAppoggio.setCitta(resultSet.getString(4));
				indirizzoAppoggio.setCap(resultSet.getInt(5));
				indirizzoAppoggio.setUtente(utente);
				indirizzoAppoggio.setUltimoIndirizzo(resultSet.getString(7));
				arrayIndirizzi.add(indirizzoAppoggio);

			}
		} catch (SQLException e) {
			//logger.error("Errore nel database", e);
			e.printStackTrace();
		}catch(Exception e) {
			//logger.error("Errore",e);
			e.printStackTrace();
		}

		return arrayIndirizzi;	
	}
}

	

