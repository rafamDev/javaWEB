package com.fp.ayudas.dao;

import com.fp.ayudas.dao.imp.mysql.MySqlFactoryDAO;

public class ProducerFactory {
	
	public final static int MySql = 1;
	public final static int POSTGRE = 2;
	
	
	private static MySqlFactoryDAO mysqlfFactoryDAO= null; 
	
		
	public static IFactoryDAO getFactory(int type) throws Exception {
		
				
		 IFactoryDAO resultado=null;
		
		switch (type) {
		case MySql:
			
			if(mysqlfFactoryDAO == null) {
				mysqlfFactoryDAO = new MySqlFactoryDAO();
			}
			
			resultado= mysqlfFactoryDAO;
			break;

		default:
			throw new IllegalArgumentException("Unexpected value: " + type);
			// Podría darse una por defecto
			//break;
		}
		return resultado;
				
	}
	
	 
	public static IFactoryDAO getFactory() throws Exception {
		
		//throw new Exception("error provocado");
		return getFactory(MySql);
	}
		
	

}
