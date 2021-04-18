package com.gestionAyudas.configuracion;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import com.gestionAyudas.excepciones.ExcepcionConfiguracion;

public class PropertiesFile {

	private String gestor;
	private String url;
	private String usuario;
	private String password;
	private int numberPool;
	
	public PropertiesFile(String gestor) throws ExcepcionConfiguracion{
		this.gestor = gestor;
		leerFichero();
	}
	
	private void leerFichero() throws ExcepcionConfiguracion{
		Properties propiedades = new Properties();
		try {
			propiedades.load(new FileReader(LoaderPath.getDirectory() + LoaderPath.getFile()));
			this.url = propiedades.getProperty("url_" + this.gestor);
		    this.usuario = propiedades.getProperty("usuario_" + this.gestor);
			this.password = propiedades.getProperty("password_" + this.gestor);
		    this.numberPool = Integer.parseInt(propiedades.getProperty("numberPool_" + this.gestor));
		} catch (IOException e) {
			throw new ExcepcionConfiguracion("No se han registrado los parametros para la conexion principal");
		}
		
	}

	public String getUrl() {
		return url;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getPassword() {
		return password;
	}

	public int getNumberPool() {
		return numberPool;
	}
}
