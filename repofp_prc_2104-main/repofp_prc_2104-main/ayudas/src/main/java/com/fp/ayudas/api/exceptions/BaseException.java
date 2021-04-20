package com.fp.ayudas.api.exceptions;

public class BaseException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer codeException=null;

	public BaseException(Integer code, String message, Throwable cause) {
		super(message, cause);
	    codeException=code;
	}

	public BaseException(Integer code, String message) {
		super(message);		
		codeException=code;
	}

	/**
	 * @return the codeException
	 */
	public Integer getCodeException() {
		return codeException;
	}

	/**
	 * @param codeException the codeException to set
	 */
	public void setCodeException(Integer codeException) {
		this.codeException = codeException;
	}

	
	

	
}
