package com.fp.ayudas.controlador.actions;

import java.io.IOException;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fp.ayudas.api.Servicio;
import com.fp.ayudas.modelo.IUnidadesConvivencia;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UcsAction extends BaseAction {

	private static final Logger logger = LoggerFactory.getLogger(UcsAction.class);

	@Override
	public String doAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String vista_resultado = "";

		// calculamos vista
		vista_resultado = "ucs.jsp";

		List<IUnidadesConvivencia> uc = null;
		try {
			Servicio ms = new Servicio();
			uc = ms.getUnidadesConvivencia();

			request.setAttribute("datos", uc);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			logger.error("Fallo en UcsAction", e);

			request.setAttribute("err_msg", "No se pudieron obtener las UCs.");

		}

		return vista_resultado;

	}

}
