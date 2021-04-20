package com.fp.ayudas.configuracion;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Configuration implements Constants {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Properties config = new Properties();

	static Configuration instance;

	Logger logger = LoggerFactory.getLogger(Configuration.class);

	public Configuration() {
		// TODO Auto-generated constructor stub
	}

	public static Configuration getInstance(String ruta) {
		if (instance == null) {
			instance = new Configuration();

			instance.loadProperties(ruta);
		}
		return instance;

	}

	protected void loadProperties(String ruta) {

		InputStream in = null;

		try {

			//String mruta = System.getProperty(APP_CONFIG_FILE_KEY, ruta);
			//logger.info("mruta: " + mruta);
			 String mruta= ruta;

			File jarPath = new File(Configuration.class.getProtectionDomain().getCodeSource().getLocation().getPath());
			String jarDirectory = jarPath.getParent();
			logger.info(" propertiesPath- jarDirectory" + jarDirectory);

			String fs = File.separator;

			logger.info("File.Separator: " + fs);

			String sepMruta = fs + mruta;

			if (new File(jarPath + sepMruta).exists()) {
				logger.info(" load properties from: " + jarPath + sepMruta);
				in = new FileInputStream(jarPath + sepMruta);
			} else if (new File(jarDirectory + sepMruta).exists()) {
				logger.info(" load properties from ext dir: " + jarDirectory + sepMruta);
				in = new FileInputStream(jarDirectory + sepMruta);
			} else {
				logger.info(" load properties from class loader: " + mruta);
				in = Configuration.class.getClassLoader().getResourceAsStream(mruta);
			}

			config.load(in);

		} catch (Exception e) {
			logger.error("Error leyendo ficero propiedades <" + ruta + ">", e);
			//TODO throw--- 

		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					logger.error("Error cerrando fichero propiedades <" + ruta + ">", e);
					//TODO throw
				}
			}
		}
	}

	public String getProperty(String key) {
		return this.config.getProperty(key);
	}

	public String getProperty(String key, String defaultValue) {
		return this.config.getProperty(key, defaultValue);
	}
	
	public Boolean getPropertyBoolean(String key, String defaultValue) {
		String val= this.config.getProperty(key, defaultValue);
		return Boolean.valueOf(val);
			
	}


}
