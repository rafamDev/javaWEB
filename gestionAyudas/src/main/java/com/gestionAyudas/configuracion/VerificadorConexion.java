package com.gestionAyudas.configuracion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.GenericServlet;

import com.gestionAyudas.excepciones.ExcepcionConexion;

public abstract class VerificadorConexion {
	
	public static void verificarRS(ResultSet rs) throws ExcepcionConexion{
		try {
			if(rs != null && !rs.isClosed()){
				rs.close();
			}
		} catch (SQLException e) {
			throw new ExcepcionConexion("El resultset no esta cerrado");
			//Logger esta abierto
		}
	}
	    
	public static void verificarPS(PreparedStatement ps)throws ExcepcionConexion{
		try {
			if(ps != null && !ps.isClosed()){
				ps.close();
			}
		} catch (SQLException e) {
			throw new ExcepcionConexion("El preparedStatement no esta cerrado");
			//Logger esta abierto
		}
	}
	    
	public static void verificarCON(Connection con) throws ExcepcionConexion{
		try {
			if(con != null && !con.isClosed()){
				con.close();
			}
		} catch (SQLException e) {
			throw new ExcepcionConexion("La conexion no esta cerrada");
			//Logger esta abierto
		}
	}

}
