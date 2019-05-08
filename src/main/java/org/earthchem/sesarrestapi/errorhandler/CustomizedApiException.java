package org.earthchem.sesarrestapi.errorhandler;

public class CustomizedApiException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4182677936810306684L;

    private String message;

    public CustomizedApiException() {
    }

    public CustomizedApiException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
