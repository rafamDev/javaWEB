package com.fp.ayudas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public abstract class GenericDAO<T> implements ISqlDAO<T> {
	
	DataSource mDataSource = null;	

	@Override
	public void setDataSource(DataSource ds) {
		mDataSource = ds; 
		
	}

	@Override
	public Connection getConnection() throws SQLException {
		return mDataSource.getConnection();
		
	}

	
	
	/**
	 * 
	 * Cierra los parametros pasados
	 * 
	 * @param stmt
	 * @param rs
	 * @param con
	 */
	protected void closeAll(PreparedStatement stmt, ResultSet rs, Connection con) {

		closeResultSet(rs);
		closePreparedStatement(stmt);
		closeConnection(con);

	}

	/**
	 * Cierra los parametros pasados
	 * 
	 * @param stmt
	 * @param rs
	 */
	protected void closeAll(PreparedStatement stmt, ResultSet rs) {

		closeResultSet(rs);
		closePreparedStatement(stmt);

	}

	/**
	 * Cierra los parametros pasados
	 * 
	 * @param stmt
	 */
	protected void closeAll(PreparedStatement stmt) {

		closePreparedStatement(stmt);

	}

	/**
	 * Cierra los parametros pasados
	 * 
	 * @param rs
	 */
	protected void closeResultSet(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
				rs = null;

			}
		} catch (Exception e) {

			System.err.print("No se ha podido cerrar el ResultSet: \n" + e.getLocalizedMessage());

		}

	}

	/**
	 * Cierra los parametros pasados
	 * 
	 * @param stmt
	 */
	protected void closePreparedStatement(PreparedStatement stmt) {

		try {
			if (stmt != null) {
				stmt.close();
				stmt = null;

			}
		} catch (Exception e) {

			System.err.print("No se ha podido cerrar el PreparedStatement: \n" + e.getLocalizedMessage());
		}
	}

	/**
	 * Cierra los parametros pasados
	 * 
	 * @param con
	 */
	protected void closeConnection(Connection con) {
		try {
			if (con != null) {

				if (!con.isClosed()) {
					con.close();
				}

				con = null;
			}
		} catch (Exception e) {
			System.err.print("No se ha podido cerrar la conexion: \n" + e.getLocalizedMessage());
		}

	}

	

	/*
	 * //private String database_connection_string =
	 * "jdbc:postgresql://localhost:5432/ayudas?client_encoding=auto";
	 * 
	 * private String database_connection_string =
	 * "jdbc:mysql://localhost:3306/ayudas";
	 * 
	 * private String database_user_name = "u_ayudas"; private String
	 * database_user_password = "abc123..";
	 * 
	 * public GenericDAO() { // TODO Auto-generated constructor stub }
	 * 
	 * 
	 * 
	 * public Connection getConnection() throws SQLException {
	 * 
	 * Connection conn =null;
	 * 
	 * 
	 * conn = DriverManager.getConnection(database_connection_string,
	 * database_user_name, database_user_password);
	 * 
	 * return conn; }
	 */


	
	
	
	
	
	

}
