package com.fp.ayudas.controlador;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Ficheros extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//resp.getWriter().append("Served at Etiquetas: ").append(req.getContextPath());
		
		 final String ROOT_FILE_PATH="D:\\listaFicheros";
		 File f=new File(ROOT_FILE_PATH);
		
		String title= "Título Servlet Etiquetas";
		
		
		resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        

        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html><html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\" />");

        
        out.println("<title>" + title + "</title>");
        out.println("</head>");
        out.println("<body bgcolor=\"white\">");
        
        
        
        out.println("<table>");
        
        
        for(String elemento : f.list())
        {
        	out.println("<tr>");
            out.println("<td>");
            out.println("contenido de la celdafdadfa: " + elemento);
            out.println("</td>");
            out.println("</tr>");
            
           
        }
        
        
        
        out.println("<tr>");
        out.println("<td>");
        out.println("contenido de la celda fila 2");
        out.println("</td>");
        out.println("</tr>");
        
        
        
        out.println("</table>");
		
        
        out.println("<h3>" + title + "aaaa07_04" + "</h3>");
        
        out.println("</body>");
        
        
        
        out.println("</html>");
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
	

	
	
}
