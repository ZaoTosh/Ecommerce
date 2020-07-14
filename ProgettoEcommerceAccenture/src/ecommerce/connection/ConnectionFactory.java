package ecommerce.connection;

import java.sql.*;
import org.apache.log4j.Logger;

public class ConnectionFactory {
	private static final Logger logger = Logger.getLogger(ConnectionFactory.class);
	String driverClassName ="oracle.jdbc.driver.OracleDriver";
	String connectionURL = "jdbc:oracle:thin:@marte.etlforma.com:8521:xe";
	////////////////////////////////////////
	////inserire username e password!!!!////
	////////////////////////////////////////
	String dbUser = "";
	String dbPWD = "";

	private static ConnectionFactory connectionFactory = null;
	private ConnectionFactory() {

		try {
			Class.forName(driverClassName);
		} catch (ClassNotFoundException e) {

			logger.error("errore nel stabilire la connessione al database ",e);
		}
	}
	public Connection getConnection() {

		Connection conn = null;  
		try {
			conn=DriverManager.getConnection(connectionURL,dbUser,dbPWD);
		} catch (SQLException e) {
			
			logger.error("errore nel stabilire la connessione al database ",e);
			
		}
		return conn; 

	}
public static ConnectionFactory getIstance() {
		
		if (connectionFactory == null) {
			
			connectionFactory = new ConnectionFactory();
		}
		
		return connectionFactory;
	}

}
