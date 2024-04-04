package com.jayesh.touristwebproject.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jayesh.touristwebproject.Entity.Tourist;

public interface TouristRepository extends JpaRepository<Tourist,Long>{

    Optional<List<Tourist>> findByBookingBookingId (Long bookingId);
}
