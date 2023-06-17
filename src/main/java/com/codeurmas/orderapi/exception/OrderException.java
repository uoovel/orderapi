//Reference as example: https://github.com/KNITS-OS/Spring-Workshops-2022/blob/S220-Crud-UnitTests/S200-SBoot-Basics/src/main/java/com/knits/product/exception/UserException.java

package com.codeurmas.orderapi.exception;

public class OrderException extends AppException {
	
	public OrderException(String message){
        super(message);
    }

    public OrderException(String message,  int code){
        super(message);
        setCode(code);
    }

    public OrderException(Exception e){
        super(e);
    }
}
