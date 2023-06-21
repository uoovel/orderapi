package com.codeurmas.orderapi.exception;

public class AppException extends RuntimeException {
	private int code;

    public AppException(String message){
        super(message);
    }

    public AppException(Exception e){
        super(e);
    }

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}  
}
