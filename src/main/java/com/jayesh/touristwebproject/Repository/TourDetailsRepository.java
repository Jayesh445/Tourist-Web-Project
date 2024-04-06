package com.jayesh.touristwebproject.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jayesh.touristwebproject.Entity.TourDetails;
import com.jayesh.touristwebproject.Entity.TourTypeEnum;

public interface TourDetailsRepository extends JpaRepository<TourDetails,Long>{

    Optional<List<TourDetails>> findByDestinationDestinationName(String destinationName);
	
	Optional<List<TourDetails>> findByTourType(TourTypeEnum tourType);
	
	@Query(value="SELECT * FROM tour_details where tour_start_date >= DATE(NOW())  ORDER BY booking_amount", nativeQuery= true)
	List<TourDetails> findTourByBudget();
	
	@Query(value="SELECT *, tour_end_date - tour_start_date AS duration FROM tour_details where tour_start_date >= DATE(NOW()) ORDER BY duration", nativeQuery= true)
	List<TourDetails> findByDuration();
}
