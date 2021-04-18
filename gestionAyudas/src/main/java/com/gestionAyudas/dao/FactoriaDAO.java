package com.gestionAyudas.dao;

public class FactoriaDAO {
	
	private static AyudaDao ayudaDao = null;

	public static AyudaDao getAyudaDAO(){
	    if(ayudaDao == null){
	    	ayudaDao = new AyudaDaoMySQL();
	    }
	  return ayudaDao;
	}
	
}
