package com.fp.ayudas.api;


import java.util.Iterator;
import java.util.List;

import java.util.stream.Collectors;

import com.fp.ayudas.dao.IUnidadesConvivenciaDAO;
import com.fp.ayudas.dao.ProducerFactory;
import com.fp.ayudas.modelo.IUnidadesConvivencia;



public class Consola {

	public static void main(String[] args) {

		(new Consola()).doAction(args);
		
		
	}

	private void doAction(String[] args) {
		try {
			IUnidadesConvivenciaDAO unid = ProducerFactory.getFactory().getUnidadesConvivenciaDAO();
			List<IUnidadesConvivencia> uc = unid.getAll();
			
			System.out.println("Estilo 1");
			uc.forEach(System.out::println);
			
			System.out.println("Estilo 2");
			System.out.print(uc.stream().map(IUnidadesConvivencia::toString).collect(Collectors.joining("\n\t","\t","\n")));
			
			System.out.println("Estilo 3");
			uc.stream().map(val -> "\t" + val).forEach(System.out::println);
			
			System.out.println("Estilo 4");
			Iterator<IUnidadesConvivencia> it= uc.iterator();			
			while (it.hasNext()) {
				System.out.println("\t" + it.next().toString());
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
