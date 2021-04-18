package com.gestionAyudas.modelo;

public class Ayuda {

	private int id;
	
	private String tipo;

	public Ayuda(int id,String tipo) {
		super();
		this.id = id;
		this.tipo = tipo;
	}

	public int getId() {
		return id;
	}

	public String getTipo() {
		return tipo;
	}

}
