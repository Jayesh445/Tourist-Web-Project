package com.jayesh.touristwebproject.Service;

import java.util.List; 

import com.jayesh.touristwebproject.DTO.TouristDTO;

public interface TouristService {
	TouristDTO createTourist(TouristDTO tourist);

	//TouristDTO updateTourist(TouristDTO tourist, Long touristId);

	List<TouristDTO> getTouristByBId(Long bookingId);

	// List<TouristDTO> getTouristByBookingId(Long bookingId);
	List<TouristDTO> getAllTourist();

	//void deleteTouristById(Long touristId);
}
