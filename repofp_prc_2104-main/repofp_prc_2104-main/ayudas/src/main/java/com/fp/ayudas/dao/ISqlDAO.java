package com.fp.ayudas.dao;

import java.sql.Connection;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;



public interface ISqlDAO<T> extends IDAO{

	/**
	 * 
	 * @param ds
	 */
	public void setDataSource(DataSource ds);
	
	/**
	 * 	
	 * @return conexion
	 * @throws SQLException
	 */
	 public Connection getConnection() throws SQLException;
	 
	 
	 public List<T> find(T criteria);
	 public void insert(T val);
	 public void delete(T val);
	 public T getByID(Long id);
	 public List<T> getAll();

	
	 
	
}
