package com.gestionAyudas.dao;

import java.util.List;

import com.gestionAyudas.modelo.Ayuda;

public interface AyudaDao extends Dao<Ayuda> {

    @Override
	public List<Ayuda> listar();

    @Override
   	public Ayuda encontrar(Ayuda obj);
   
    @Override
	public int insertar(Ayuda obj);

	@Override
	public int modificar(Ayuda obj);

	@Override
	public int eliminar(Ayuda obj);

}
