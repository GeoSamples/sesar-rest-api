package org.earthchem.sesarrestapi.errorhandler;

public class CustomizedApiResponse {

	private String error;

    public CustomizedApiResponse() {

    }

    public CustomizedApiResponse(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

}