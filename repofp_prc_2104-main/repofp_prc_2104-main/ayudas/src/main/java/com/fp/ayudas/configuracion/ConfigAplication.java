/**
 * 
 */
package com.fp.ayudas.configuracion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author jbascoy
 *
 */
public class ConfigAplication extends Configuration {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(ConfigAplication.class);
	
	static ConfigAplication instance;

	/**
	 * 
	 */
	public ConfigAplication() {
		// TODO Auto-generated constructor stub
	}
	
	
	public static final ConfigAplication getInstance () {
		
		logger.debug("Inicio");
		
		if (instance == null ) {
				instance = new ConfigAplication();	
				
				String mruta = System.getProperty(APP_CONFIG_FILE_KEY, PATH_CONFIGURATION);
				logger.info("mruta: " + mruta);
				
				instance.loadProperties(mruta);
		
		}
		
		logger.debug("Final");
		
		return instance;		
	} 
	
	

	public String getDataBaseUserPwd(){
		
		return getProperty(DB_USER_PWD);
	}
	
	
	public String getDataBaseUser(){
		
		return getProperty(DB_USER);
	}
	
	
	public String getDataBaseConnectionURI(){
		
		return getProperty(DB_CONNECTION_URI);
	}


	public boolean isDataBaseWebServerPool() {
		
		return getPropertyBoolean (DB_CONNECTION_WEB_SERVER_DS,"false"); 
	
	}
	
	
}
