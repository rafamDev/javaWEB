package com.fp.ayudas.controlador;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fp.ayudas.api.Servicio;
import com.fp.ayudas.dao.IUnidadesConvivenciaDAO;
import com.fp.ayudas.dao.ProducerFactory;
import com.fp.ayudas.modelo.IUnidadesConvivencia;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class UnidadesConvivencia extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Logger logger = LoggerFactory.getLogger(UnidadesConvivencia.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//resp.getWriter().append("Served at Etiquetas: ").append(req.getContextPath());
				 
		
		if(null!=req.getParameter("doErr") && req.getParameter("doErr").equals("1")) {
			
			throw new ServletException("Error por parametere doErr=1");
		}
		
		String title= getClass().getName() + " - " + getServletName() +" - " + getServletContext().getContextPath();
		
		
		resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        

        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html><html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\" />");

        
        out.println("<title>" + title + "</title>");
        out.println("</head>");
        out.println("<body bgcolor=\"white\">");

        out.println("<h1> " + title +" </h1>");
        
        IUnidadesConvivenciaDAO unid=null;
        List<IUnidadesConvivencia> uc=null;
		try {
			Servicio ms= new Servicio();
			uc = ms.getUnidadesConvivencia();
		} catch (Exception e) {
			
			logger.error("Error recuperando unidades convivencia",e);
			req.setAttribute("err_msg", "Se ha producido un error. Intentelo más tarde o contacte con el administrador.");
			req.getRequestDispatcher("error.jsp").forward(req, resp);
			return;
			//throw new ServletException("Se ha producido un error. Intentelo más tarde o contacte con el administrador.",e);			
		}
		//List<IUnidadesConvivencia> uc = unid.getAll();
		
        if( null!=uc &&  uc.size()>0) {
        
        	out.println("<table>");
            
            
            for(IUnidadesConvivencia elemento : uc)
            {
            	out.println("<tr>");
                out.println("<td>");
                out.println("contenido de la celda fila: " + elemento.getNombre() +"(" + elemento.getId() +")");
                out.println("</td>");
                out.println("</tr>");
                
               
            }
            
            
            
            out.println("<tr>");
            out.println("<td>");
            out.println("contenido de la celda de la fila final despues de recorrer bucle");
            out.println("</td>");
            out.println("</tr>");
            
            
            
            out.println("</table>");
    		
        	
        } else {
        	
        	out.println("<h3 color='red'> No se encontraron unidades convivenciales!!</h3>");
        }
               
       
        
        out.println("</body>");
        
        
        
        out.println("</html>");
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
	

	
	
}
