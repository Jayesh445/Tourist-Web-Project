package com.jayesh.touristwebproject.Service;

import java.util.List;

import com.jayesh.touristwebproject.DTO.TourDetailsDTO;
import com.jayesh.touristwebproject.Entity.TourTypeEnum;

public interface TourDetailsService {
	TourDetailsDTO saveTourDetails(TourDetailsDTO tourDetailsDTO);

	TourDetailsDTO updateTourDetails(TourDetailsDTO tourDetailsDTO, Long tourId);

	TourDetailsDTO getTourDetailsById(Long tourId);

	List<TourDetailsDTO> getAllToursDetails();

	void deleteTourDetailsById(Long tourId);
	
	List<TourDetailsDTO> getToursByDestination(String destination);
	
	List<TourDetailsDTO> getToursByTourType(TourTypeEnum tourType);
	
	List<TourDetailsDTO> findTourByBudget();
	
	List<TourDetailsDTO> findTourByDuration();
	
}
