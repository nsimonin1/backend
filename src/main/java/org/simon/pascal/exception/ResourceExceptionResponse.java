/**
 *
 */
package org.simon.pascal.exception;

import org.springframework.http.HttpStatus;

/**
 * @author simon.pascal.ngos
 *
 */
public class ResourceExceptionResponse {
	private String errorCode;
    private String errorMessage;
    private String requestURL;
    private HttpStatus status;
	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}
	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}
	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	/**
	 * @return the requestURL
	 */
	public String getRequestURL() {
		return requestURL;
	}
	/**
	 * @param requestURL the requestURL to set
	 */
	public void setRequestURL(String requestURL) {
		this.requestURL = requestURL;
	}
	/**
	 * @return the status
	 */
	public HttpStatus getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(HttpStatus status) {
		this.status = status;
	}



}
