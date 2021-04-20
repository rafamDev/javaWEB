package com.fp.ayudas.dao;

import java.sql.SQLException;

public interface IFactoryDAO {
	
	public IUnidadesConvivenciaDAO getUnidadesConvivenciaDAO() throws SQLException;
	public IAyudasDAO getAyudasDAO() throws SQLException;
	
	

}
