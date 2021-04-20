package com.fp.ayudas.modelo;

import java.io.Serializable;

public interface IAyudas extends Serializable {
	
	
	
	public Long getId();

	public String getNombre();

	public void setID(Long pval);
	
	public void setNombre(String pval);
	
}
