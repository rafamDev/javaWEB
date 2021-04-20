package com.fp.ayudas.controlador;

import java.io.IOException;

import com.fp.ayudas.controlador.actions.UcsAction;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public Controller() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		String page = doAction(request, response);

		if (!"".equals(page)) {
			request.getRequestDispatcher(page).forward(request, response);
		} else {
			throw new ServletException("Accion no disponible.");
		}

	}

	private String doAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// return null;

		String res = "";
		String requestUri = (String) request.getRequestURI();

		String key = "";
		key = requestUri.substring(requestUri.lastIndexOf("/") + 1, requestUri.lastIndexOf(".do"));

		switch (key) {
		case "ucs":
			//res = "ficheros";
			//res= "ucs.jsp";
			
			
			res = (new UcsAction()).doAction(request, response);
			break;
			
		default:

			break;
		}

		return res;

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
