package com.gestionAyudas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gestionAyudas.configuracion.ConexionMySQL;
import com.gestionAyudas.modelo.Ayuda;

public class AyudaDaoMySQL extends AyudaMySQL implements AyudaDao {

	public AyudaDaoMySQL(){}
	
    @Override
	public List<Ayuda> listar(){
	  Connection con = null;
	  PreparedStatement ps = null;
	  ResultSet rs = null;
	  List<Ayuda> ayudas = new ArrayList<Ayuda>();
	    try{
			con = ConexionMySQL.getConexion();
			ps =  con.prepareStatement(getSqlSelect());
			rs =  ps.executeQuery();
			while(rs.next()){
	           ayudas.add(new Ayuda(rs.getInt("id"),rs.getString("tipo")));
	        }
	    }catch(SQLException e) {
	    	ConexionMySQL.closeRS(rs);
		    ConexionMySQL.closePS(ps);
		    ConexionMySQL.closeCON(con);
		 }finally {
	    	ConexionMySQL.closeRS(rs);
		    ConexionMySQL.closePS(ps);
		    ConexionMySQL.closeCON(con);
	    }	
	  return ayudas;
	}

	@Override
	public Ayuda encontrar(Ayuda ayuda) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			con = ConexionMySQL.getConexion();
			ps = con.prepareStatement(getSqlSelectById());
			ps.setInt(1, ayuda.getId());
			rs = ps.executeQuery();
			 if(rs.next()){
				 ayuda = new Ayuda(rs.getInt("id"),rs.getString("tipo"));
			 }
		 }catch(SQLException e) {
		     ConexionMySQL.closeRS(rs);
			 ConexionMySQL.closePS(ps);
			 ConexionMySQL.closeCON(con);
		  }finally {
		     ConexionMySQL.closeRS(rs);
		     ConexionMySQL.closePS(ps);
			 ConexionMySQL.closeCON(con);
		  }
	  return ayuda;
	}

	@Override
	public int insertar(Ayuda ayuda) {
	  Connection con = null;
	  PreparedStatement ps = null;
      int rows = 0;
        try{
			con = ConexionMySQL.getConexion();
			ps = con.prepareStatement(getSqlInsert());
			ps.setString(1, ayuda.getTipo());
        }catch(SQLException e) {
		    ConexionMySQL.closePS(ps);
		    ConexionMySQL.closeCON(con);
		 }finally {
		    ConexionMySQL.closePS(ps);
		    ConexionMySQL.closeCON(con);
		 }
      return rows;
	}

	@Override
	public int modificar(Ayuda ayuda) {
	   Connection con = null;
	   PreparedStatement ps = null;
	   int rows = 0;
	      try{
	     	con = ConexionMySQL.getConexion();
			ps = con.prepareStatement(getSqlUpdate());
			ps.setString(1, ayuda.getTipo());
		    ps.setInt(2, ayuda.getId());
	      }catch(SQLException e) {
			    ConexionMySQL.closePS(ps);
			    ConexionMySQL.closeCON(con);
			}finally {
			    ConexionMySQL.closePS(ps);
			    ConexionMySQL.closeCON(con);
			}
	  return rows;
	}

	@Override
	public int eliminar(Ayuda ayuda) {
	   Connection con = null;
	   PreparedStatement ps = null;
	   int rows = 0;
		try{
		   con = ConexionMySQL.getConexion();
		   ps = con.prepareStatement(getSqlDelete());
		   ps.setInt(1, ayuda.getId());
		}catch(SQLException e) {
		    ConexionMySQL.closePS(ps);
		    ConexionMySQL.closeCON(con);
		 }finally {
		    ConexionMySQL.closePS(ps);
		    ConexionMySQL.closeCON(con);
		 }
	  return rows;
	}
}
