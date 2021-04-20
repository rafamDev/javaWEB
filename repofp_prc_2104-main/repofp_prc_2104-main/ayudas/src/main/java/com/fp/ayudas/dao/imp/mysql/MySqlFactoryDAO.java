package com.fp.ayudas.dao.imp.mysql;

import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fp.ayudas.configuracion.ConfigAplication;
import com.fp.ayudas.dao.IAyudasDAO;
import com.fp.ayudas.dao.IFactoryDAO;
import com.fp.ayudas.dao.IUnidadesConvivenciaDAO;
import com.mysql.cj.jdbc.MysqlDataSource;
import com.mysql.cj.jdbc.MysqlDataSourceFactory;

public class MySqlFactoryDAO implements IFactoryDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(MySqlFactoryDAO.class);

	private String database_connection_string = "jdbc:mysql://localhost:3306/ayudas";

	private String database_user_name = "u_ayudas";
	private String database_user_password = "abc123..";

	private static DataSource dataSource = null;

	public DataSource getDataSource() throws SQLException {
		if (dataSource == null) {
			dataSource = doDataSource();
		}
		return dataSource;
	}

	private DataSource doDataSource() throws SQLException {

		
		DataSource ds=null;
		
		if(ConfigAplication.getInstance().isDataBaseWebServerPool()) {

			try {
	    		Context ctx = new InitialContext();
	    		ds = (DataSource)ctx.lookup("java:comp/env/jdbc/ayudas");
	    		
	    	  } catch (NamingException e) {
	    		logger.error("No se ha podido obtener info. para conectar a la BD", e);
	    		throw new SQLException("No se ha podido obtener info. para conectar a la BD", e);
	    	  }
		  
		}else {
		
		
		
			MysqlDataSource dsm = new MysqlDataSource();
		

			dsm.setUrl(database_connection_string);
			dsm.setUser(ConfigAplication.getInstance().getDataBaseUser());
			dsm.setPassword(database_user_password);
		
			ds=dsm;
		}
		return ds;

		/*
		 * BasicDataSource ds = new BasicDataSource();
		 * ds.setDriverClassName("org.postgresql.Driver");
		 * 
		 * 
		 * ds.setUrl(ConfigAplication.getInstance().getDataBaseConnectionURI());
		 * ds.setUsername(ConfigAplication.getInstance().getDataBaseUser());
		 * ds.setPassword(ConfigAplication.getInstance().getDataBaseUserPwd());
		 */

	}

	@Override
	public IUnidadesConvivenciaDAO getUnidadesConvivenciaDAO() throws SQLException {
		// TODO Auto-generated method stub

		IUnidadesConvivenciaDAO unidconv = new MySqlUnidadesConvivenciaDAO();
		unidconv.setDataSource(getDataSource());

		return unidconv;

		// unidconv.setconeccion(adfafa);
	}

	@Override
	public IAyudasDAO getAyudasDAO() throws SQLException {
		IAyudasDAO unidconv = new MySqlAyudasDAO();
		unidconv.setDataSource(getDataSource());

		return unidconv;
	}

}
