package com.jayesh.touristwebproject.Repository;

// import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jayesh.touristwebproject.Entity.Booking;


public interface BookingRepository extends JpaRepository<Booking,Long>{

   // public List<Booking> findBookingBetweenDate(LocalDate startDate, LocalDate endDate);

//     public List<Booking> findByTourDetailTourID(Long tourID);

//     public List<Booking> findByUserID(Long userID);
 } 
