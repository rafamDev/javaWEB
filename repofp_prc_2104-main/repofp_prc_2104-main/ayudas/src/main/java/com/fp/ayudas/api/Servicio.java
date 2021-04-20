package com.fp.ayudas.api;

import java.util.List;

import com.fp.ayudas.dao.IUnidadesConvivenciaDAO;
import com.fp.ayudas.dao.ProducerFactory;
import com.fp.ayudas.modelo.IUnidadesConvivencia;

public class Servicio {

	public List<IUnidadesConvivencia> getUnidadesConvivencia() {
		
		IUnidadesConvivenciaDAO unid = null;
		List<IUnidadesConvivencia> uc = null;
		try {
			unid = ProducerFactory.getFactory().getUnidadesConvivenciaDAO();
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		uc = unid.getAll();

		return uc;
	}
	
	
}
