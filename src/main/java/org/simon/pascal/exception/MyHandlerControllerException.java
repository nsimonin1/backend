/**
 *
 */
package org.simon.pascal.exception;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

/**
 * @author simon.pascal.ngos
 *
 */
@ControllerAdvice(basePackages = {"org.simon.pascal.controller"} )
public class MyHandlerControllerException extends DefaultHandlerExceptionResolver{
	private final Logger log=LoggerFactory.getLogger(getClass());
	
	@InitBinder
    public void dataBinding(WebDataBinder binder) {
        //Vous pouvez initialiser toute autre donnée ici
    }

    @ModelAttribute //la variable "technicalError" pourra être exploité n'importe où dans l'application
    public void globalAttributes(Model model) {
        model.addAttribute("technicalError", "Une erreur technique est survenue !");
    }

     
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResourceExceptionResponse> unknowError(HttpServletRequest req, Exception ex) {
    	 final ResourceExceptionResponse response = new ResourceExceptionResponse();
         response.setErrorCode("Technical Error");
         response.setErrorMessage(ex.getMessage());
         response.setRequestURL(req.getRequestURL().toString());
         log.error(ex.getMessage(),ex);
         return new ResponseEntity<ResourceExceptionResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

     

    @ExceptionHandler(BusinessResourceException.class)
    public ResponseEntity<ResourceExceptionResponse> resourceNotFound(HttpServletRequest req, BusinessResourceException ex) {
    	final ResourceExceptionResponse response = new ResourceExceptionResponse();
        response.setStatus(HttpStatus.BAD_REQUEST);
        response.setErrorCode("N/A");
        response.setErrorMessage(ex.getMessage());
        response.setRequestURL(req.getRequestURL().toString());
        log.error("Error status: {} Error code: {} message: {}",
        		HttpStatus.BAD_REQUEST,"N/A",ex.getMessage());
        return new ResponseEntity<ResourceExceptionResponse>(response, HttpStatus.BAD_REQUEST);

    }

}
