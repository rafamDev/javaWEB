package com.gestionAyudas.configuracion;

public class LoaderPath extends Configuracion{
	
	private LoaderPath(){}
	
	 public static String getDirectory(){
		if(directory == null){
			directory = "C:\\Users\\rafam\\Desktop\\repositorios\\javaWeb\\gestionAyudas\\src\\main\\resources\\";
		}
	   return directory;
	 }
	
	 public static String getFile(){
		if(file == null){
			file = "configuracion.properties";
		}
	   return file;
	 }

}
