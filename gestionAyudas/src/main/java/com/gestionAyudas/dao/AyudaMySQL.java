package com.gestionAyudas.dao;

public abstract class AyudaMySQL{

	private static final String SQL_SELECT = "SELECT * FROM ayuda";
	
	private static final String SQL_SELECT_BY_ID = "SELECT * FROM ayuda WHERE id=?";
		
	private static final String SQL_INSERT = "INSERT INTO ayuda(nombre,tipo)"
				+ "VALUES (?,?)";
				
	private static final String SQL_UPDATE = "UPDATE ayuda SET tipo=? WHERE id=?";
	
				
	private static final String SQL_DELETE = "DELETE FROM ayuda WHERE id=?";

	
	public static String getSqlSelect() {
		return SQL_SELECT;
	}

	public static String getSqlSelectById() {
		return SQL_SELECT_BY_ID;
	}

	public static String getSqlInsert() {
		return SQL_INSERT;
	}

	public static String getSqlUpdate() {
		return SQL_UPDATE;
	}

	public static String getSqlDelete() {
		return SQL_DELETE;
	}

		
}
