package com.gestionAyudas.excepciones;

import java.io.IOException;

public class ExcepcionConfiguracion extends IOException{
   private static final long serialVersionUID = -6218455176734659099L;
   
   public ExcepcionConfiguracion(){}
	
	public ExcepcionConfiguracion(String mensajeError){
		super(mensajeError);
	}
   
}
