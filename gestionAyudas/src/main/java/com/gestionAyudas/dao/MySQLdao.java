package com.gestionAyudas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public interface MySQLdao{

	 public static Connection getConexion(){return null;}
	 
	 public static void closeRS(ResultSet rs){}
	    
	 public static void closePS(PreparedStatement ps){}
	    
	 public static void closeCON(Connection con){}
}
