package com.fp.ayudas.modelo.imp;

import com.fp.ayudas.modelo.IUnidadesConvivencia;

public class UnidadesConvivencia implements IUnidadesConvivencia {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id = null;

	private String nombre = null;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	public void setID(Long pval) {
		id = pval;

	}

	public void setNombre(String pval) {
		nombre = pval;

	}

	@Override
	public String toString() {
		
		String resultado=super.toString();
	
		resultado= resultado + " id: " + getId() + " nombre: " + getNombre();
		
		return resultado;
	}
	
	

}
