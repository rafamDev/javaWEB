package com.fp.ayudas.dao.imp.mysql;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fp.ayudas.dao.GenericDAO;
import com.fp.ayudas.dao.IAyudasDAO;
import com.fp.ayudas.modelo.IAyudas;

public class MySqlAyudasDAO extends GenericDAO<IAyudas> implements IAyudasDAO {

	private static final Logger logger = LoggerFactory.getLogger(MySqlAyudasDAO.class);

	
	@Override
	public List<IAyudas> find(IAyudas criteria) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void insert(IAyudas val) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete(IAyudas val) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public IAyudas getByID(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<IAyudas> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	}
