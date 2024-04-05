package com.jayesh.touristwebproject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jayesh.touristwebproject.Entity.Destination;
import java.util.List;


public interface DestinationRepository extends JpaRepository<Destination,Integer> {

    public List<Destination> findByDestinationName(String destinationName);
}
