package com.jayesh.touristwebproject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jayesh.touristwebproject.Entity.Booking;


public interface BookingRepository extends JpaRepository<Booking,Long>{

} 
