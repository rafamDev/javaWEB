package com.fp.ayudas.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

public class ImpDataSource {
	
	
	private DataSource instance=null;
	
	
	public Connection getConnection() throws SQLException {
		return instance.getConnection();
		
	}
	

}
