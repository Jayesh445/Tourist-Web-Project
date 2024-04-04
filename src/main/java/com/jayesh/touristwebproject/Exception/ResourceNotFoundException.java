package com.jayesh.touristwebproject.Exception;

import com.jayesh.touristwebproject.Entity.TourTypeEnum;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String msg , String id, Long userId){
        super(msg);
    }

    public ResourceNotFoundException(String msg, String email, String emailid) {
		super(msg);
	}
	public ResourceNotFoundException(String msg, String email, TourTypeEnum tourtype) {
		super(msg);
	}
}
