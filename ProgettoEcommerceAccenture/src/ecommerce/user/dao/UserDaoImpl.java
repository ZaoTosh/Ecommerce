package ecommerce.user.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;

import ecommerce.connection.ConnectionFactory;
import ecommerce.user.model.UserBean;


public class UserDaoImpl implements IDaoUser{

	private static final Logger logger = Logger.getLogger(UserDaoImpl.class);

	Connection oggettoConnessione=null;
	PreparedStatement preparedStatement=null;
	ResultSet resultSet=null;


	@Override
	public boolean addUser(UserBean user) {
		logger.info("add user " + user.getUsername());
		oggettoConnessione=ConnectionFactory.getIstance().getConnection();
		String query="INSERT INTO UTENTE VALUES(?,?,?,?,?)";
		boolean ctrl=false;
		try {
			preparedStatement=oggettoConnessione.prepareStatement(query);
			preparedStatement.setString(1,user.getUsername());
			preparedStatement.setString(2,user.getPassword());
			preparedStatement.setString(3,user.getNome());
			preparedStatement.setString(4,user.getCognome());
			if (user.getDataNascita()==null){
				preparedStatement.setDate(5, null);
			}else {
				preparedStatement.setDate(5,Date.valueOf(user.getDataNascita()));
			}
			int nModifiche=preparedStatement.executeUpdate();
			if (nModifiche==1) {
				ctrl=true;
			}
		}catch (SQLException e){
			logger.error("Errore del database" , e);
		}catch (Exception e) {			
			logger.error("Errore generico " , e);
		}	
		logger.info("add user invoked!!!");
		return ctrl;
	}

	@Override
	public boolean deleteUser(String username) {
		logger.info("delete user " + username);
		oggettoConnessione=ConnectionFactory.getIstance().getConnection();
		String query="DELETE FROM UTENTE WHERE USERNAME=?";
		boolean ctrl=false;
		try {
			preparedStatement=oggettoConnessione.prepareStatement(query);
			preparedStatement.setString(1, username);
			int nModifiche=preparedStatement.executeUpdate();
			if (nModifiche==1) {
				ctrl=true;
			}
		}catch (SQLException e){
			logger.error("Errore del database" , e);
		}catch (Exception e) {			
			logger.error("Errore generico " , e);
		}	
		logger.info("delete user invoked!!!");
		return ctrl;
	}

	@Override
	public boolean updateUserByUsername(UserBean user) {
		logger.info("update user " + user.getUsername());
		oggettoConnessione=ConnectionFactory.getIstance().getConnection();
		String query="UPDATE UTENTE SET USERNAME=?,PASSWORD=?,NOME=?,COGNOME=?,DATA_NASCITA=? WHERE USERNAME=?";
		boolean ctrl=false;
		try {
			preparedStatement=oggettoConnessione.prepareStatement(query);
			preparedStatement.setString(1,user.getUsername());
			preparedStatement.setString(2,user.getPassword());
			preparedStatement.setString(3,user.getNome());
			preparedStatement.setString(4,user.getCognome());
			preparedStatement.setDate(5,Date.valueOf(user.getDataNascita()));
			preparedStatement.setString(6,user.getUsername());
			int nModifiche=preparedStatement.executeUpdate();
			if (nModifiche==1) {
				ctrl=true;
			}
		}catch (SQLException e){
			logger.error("Errore del database" ,e);
		}catch (Exception e) {			
			logger.error("Errore generico " , e);
		}	
		logger.info("update user invoked!!!");
		return ctrl;		
	}



	@Override
	public UserBean getUserByUsername(String username) {
		logger.info("get user " + username);
		oggettoConnessione=ConnectionFactory.getIstance().getConnection();
		String query="SELECT * FROM UTENTE WHERE USERNAME=?";
		UserBean user=null;
		try {
			preparedStatement=oggettoConnessione.prepareStatement(query);
			preparedStatement.setString(1, username);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				user=new UserBean();
				user.setUsername(resultSet.getString(1));
				user.setPassword(resultSet.getString(2));
				user.setNome(resultSet.getString(3));
				user.setCognome(resultSet.getString(4));
				user.setDataNascita(resultSet.getDate(5).toLocalDate());
			}
		}catch (SQLException e){
			logger.error("Errore del database" , e);
		}catch (Exception e) {			
			logger.error("Errore generico " , e);
		}	
		logger.info("get user invoked!!!");
		return user;		
	}

	@Override
	public ArrayList<UserBean> getAllUser() {
		logger.info("get all users");
		oggettoConnessione=ConnectionFactory.getIstance().getConnection();
		String query="SELECT * FROM UTENTE";
		ArrayList<UserBean> listaUser=null;
		try {
			listaUser=new ArrayList<UserBean>();
			preparedStatement=oggettoConnessione.prepareStatement(query);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				UserBean userAppoggio=new UserBean();
				userAppoggio.setUsername(resultSet.getString(1));
				userAppoggio.setPassword(resultSet.getString(2));
				userAppoggio.setNome(resultSet.getString(3));
				userAppoggio.setCognome(resultSet.getString(4));
				userAppoggio.setDataNascita(resultSet.getDate(5).toLocalDate());
				listaUser.add(userAppoggio);
			}
		}catch (SQLException e){
			logger.error("Errore del database" , e);
		}catch (Exception e) {			
			logger.error("Errore generico " , e);
		}	
		logger.info("get all users invoked!!!");
		return listaUser;		
	}

}