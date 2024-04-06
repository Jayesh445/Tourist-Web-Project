package com.jayesh.touristwebproject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jayesh.touristwebproject.Entity.Booking;
import com.jayesh.touristwebproject.Entity.User;


public interface BookingRepository extends JpaRepository<Booking,Long>{



     public List<Booking> findByTourDetailsTourId(Long tourID);

     public List<Booking> findByUserUserId(Long userID) ;

    public List<Booking> findByUser(User User);
 } 
