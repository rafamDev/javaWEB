package com.gestionAyudas.api;

import com.gestionAyudas.dao.AyudaDao;
import com.gestionAyudas.dao.FactoriaDAO;

public class Servicio {
 
	private static AyudaDao ayudaDao = null;
	
	public static AyudaDao getAyudaDAO() {
		if(ayudaDao == null){
	    	ayudaDao = FactoriaDAO.getAyudaDAO();
	    }
	  return ayudaDao;
	}
}
