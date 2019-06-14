package org.earthchem.sesarrestapi.errorhandler;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomizedApiRestErrorHandler  extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomizedApiException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public CustomizedApiResponse processApiError(CustomizedApiException ex) {
    	CustomizedApiResponse response = new CustomizedApiResponse(ex.getMessage());
        return response;
    }
    
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public CustomizedApiResponse processConstraintError(ConstraintViolationException ex) {
    	CustomizedApiResponse response = new CustomizedApiResponse(ex.getMessage() + " (constraint voilation)");
        return response;
    } 
    
}