package com.jayesh.touristwebproject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jayesh.touristwebproject.Entity.TourDetails;

public interface TourDetailsRepository extends JpaRepository<TourDetails,Long>{

}
