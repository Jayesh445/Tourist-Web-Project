package com.jayesh.touristwebproject.Exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String msg , String id, Long userId){
        super(msg);
    }
}
