package com.gestionAyudas.configuracion;

import com.gestionAyudas.excepciones.ExcepcionConfiguracion;

public class LoaderProperties extends Configuracion {

	private LoaderProperties() {}
	
	 public static PropertiesFile getMysql(){
		try{
			 if(pf == null) {
				  pf = new PropertiesFile("mysql");
			  }
		}catch(ExcepcionConfiguracion e){
				//logger
		}
	  return pf; 
	}
}
