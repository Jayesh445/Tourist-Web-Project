package com.jayesh.touristwebproject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jayesh.touristwebproject.Entity.Tourist;

public interface TouristRepository extends JpaRepository<Tourist,Long>{

}
