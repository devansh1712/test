package com.BlogApp_With_Mircroservices.exception;

public class ResourceNotFound extends RuntimeException{

    public  ResourceNotFound(String message){
        super(message);

    }
}
