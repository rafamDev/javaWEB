package com.fp.ayudas.controlador;

import java.io.File;
import java.io.IOException;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListFiles
 */
@WebServlet("/ListFiles")
public class ListFiles extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ListFiles() {
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doProc(request, response);  
		
		
	}

	/**
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void doProc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 final String ROOT_FILE_PATH="D:\\listaFicheros";
		 File f=new File(ROOT_FILE_PATH);
		 //File f=new File(ConfigApplication.getInstance().getPathDirFilesToList());
		 
		 RequestDispatcher rd=request.getRequestDispatcher("listfiles.jsp");  
		 //String jspViewListFile=ConfigApplication.getInstance().getJspViewListFiles();		 
		 //RequestDispatcher rd=request.getRequestDispatcher(jspViewListFile);	     
		 		 
		 
		 //File[] allSubFiles=f.listFiles();
		 File[] allSubFiles=f.listFiles();
		 request.setAttribute("lFiles", allSubFiles);
		 //request.setAttribute(ConfigApplication.KEY_ATTR_LIST_FILES, allSubFiles);
		 
		
		 
		 
		 		 		 		 
		 rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProc(request, response);
	}
}
