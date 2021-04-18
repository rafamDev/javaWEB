package com.gestionAyudas.modelo;

public class UnidadDeConvivencia {
	
	private int id;
	
	private String dni_conyuge;
	
	private String nombre_conyuge;
	
	private String apellido_conyuge;
	
	private int numero_hijos;

	public UnidadDeConvivencia(int id, String dni_conyuge, String nombre_conyuge, String apellido_conyuge,int numero_hijos) {
		super();
		this.id = id;
		this.dni_conyuge = dni_conyuge;
		this.nombre_conyuge = nombre_conyuge;
		this.apellido_conyuge = apellido_conyuge;
		this.numero_hijos = numero_hijos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDni_conyuge() {
		return dni_conyuge;
	}

	public void setDni_conyuge(String dni_conyuge) {
		this.dni_conyuge = dni_conyuge;
	}

	public String getNombre_conyuge() {
		return nombre_conyuge;
	}

	public void setNombre_conyuge(String nombre_conyuge) {
		this.nombre_conyuge = nombre_conyuge;
	}

	public String getApellido_conyuge() {
		return apellido_conyuge;
	}

	public void setApellido_conyuge(String apellido_conyuge) {
		this.apellido_conyuge = apellido_conyuge;
	}

	public int getNumero_hijos() {
		return numero_hijos;
	}

	public void setNumero_hijos(int numero_hijos) {
		this.numero_hijos = numero_hijos;
	}

}
