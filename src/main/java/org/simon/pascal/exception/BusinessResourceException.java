/**
 * 
 */
package org.simon.pascal.exception;

/**
 * @author simon.pascal.ngos
 *
 */
public class BusinessResourceException extends Exception{
 
	private static final long serialVersionUID = 1L;

	public BusinessResourceException() {
		super(); 
	}

	public BusinessResourceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace); 
	}

	public BusinessResourceException(String message, Throwable cause) {
		super(message, cause); 
	}

	public BusinessResourceException(String message) {
		super(message); 
	}

	public BusinessResourceException(Throwable cause) {
		super(cause); 
	}
	
}
