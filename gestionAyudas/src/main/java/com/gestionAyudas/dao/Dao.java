package com.gestionAyudas.dao;

import java.util.List;

import com.gestionAyudas.modelo.Ayuda;

public interface Dao<T> {

	 List<T> listar();
	 
	 T encontrar(T obj);
	 
	 int insertar(T obj);
	 
	 int modificar(T obj);
	 
	 int eliminar(T obj);
}
