package com.fp.ayudas.controlador;

import java.io.IOException;
import java.io.PrintWriter;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ErrorHandler
 */

public class ErrorHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ErrorHandler() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		request.getRequestDispatcher("/error.jsp").forward(request, response);
		
		/*
		 * String title= "Servlet error handler";
		 * 
		 * 
		 * 
		 * response.setContentType("text/html"); response.setCharacterEncoding("UTF-8");
		 * 
		 * 
		 * PrintWriter out = response.getWriter(); out.println("<!DOCTYPE html>\n");
		 * 
		 * out.println("<html>"); out.println("<head>");
		 * out.println("<meta charset=\"UTF-8\" />");
		 * 
		 * 
		 * out.println("<title>" + title + "</title>"); out.println("</head>");
		 * 
		 * 
		 * out.println("<body bgcolor=\"white\">");
		 * 
		 * 
		 * out.println("<h1> SERVLET ERROR PAGE </h2>");
		 * 
		 * out.println("<h3> MSG detalle </h3>");
		 * 
		 * out.println("</body>");
		 * 
		 * 
		 * 
		 * out.println("</html>");
		 * 
		 * out.flush();
		 * 
		 * out.close();
		 * 
		 * return;
		 */
        
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
