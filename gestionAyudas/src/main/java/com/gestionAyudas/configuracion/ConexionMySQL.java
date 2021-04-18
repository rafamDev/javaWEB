package com.gestionAyudas.configuracion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import com.gestionAyudas.dao.MySQLdao;
import com.gestionAyudas.excepciones.ExcepcionConexion;

public class ConexionMySQL extends VerificadorConexion implements MySQLdao {
	
	public static DataSource getDataSource(){
		PropertiesFile properties = LoaderProperties.getMysql();
		BasicDataSource ds = new BasicDataSource();
		ds.setUrl(properties.getUrl());
     	ds.setUsername(properties.getUsuario());
    	ds.setPassword(properties.getPassword()); 
    	ds.setInitialSize(properties.getNumberPool()); 
	 return ds;
	}

	public static Connection getConexion() throws ExcepcionConexion{
		try {
			return getDataSource().getConnection();
		} catch (SQLException e) {
			throw new ExcepcionConexion("No se ha podido establecer la conexion Principal");
		}
	}
	
	public static void closeRS(ResultSet rs){
		try {
			verificarRS(rs);
		} catch (ExcepcionConexion e) {
			
			//Logger rs abierto
		}
	}
	    
	public static void closePS(PreparedStatement ps){
		try {
			verificarPS(ps);
		} catch (ExcepcionConexion e) {
			//Logger rs abierto
		}
	}
	    
	public static void closeCON(Connection con){
		try {
			verificarCON(con);
		} catch (ExcepcionConexion e) {
			//Logger rs abierto
		}
	}
	
}
