package com.gestionAyudas.excepciones;

import java.sql.SQLException;

public class ExcepcionConexion extends SQLException {
	private static final long serialVersionUID = -656298439041147610L;
	
	public ExcepcionConexion() {}
	
	public ExcepcionConexion(String mensajeError){
		super(mensajeError);
	}
}
