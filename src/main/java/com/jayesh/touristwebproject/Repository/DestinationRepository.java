package com.jayesh.touristwebproject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jayesh.touristwebproject.Entity.Destination;
import java.util.List;

@Repository
public interface DestinationRepository extends JpaRepository<Destination,Long> {

    public List<Destination> findByDestinationName(String destinationName);
}
