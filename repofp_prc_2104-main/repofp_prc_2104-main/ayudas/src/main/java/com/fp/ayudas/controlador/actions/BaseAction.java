package com.fp.ayudas.controlador.actions;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * 
 *  BaseAction para acciones servlet controlador
 * @author jbascoy
 *
 */
public abstract class BaseAction {
	
	
	/**
	 * Metodo debe realizar calculos para la vista (devolver la ruta a ella) y a ver realizado las
	 * operaciones necesarias con/en el servicio/API...
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public abstract String doAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;

}
