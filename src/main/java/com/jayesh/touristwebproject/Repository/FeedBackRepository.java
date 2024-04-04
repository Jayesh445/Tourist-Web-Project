package com.jayesh.touristwebproject.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jayesh.touristwebproject.Entity.FeedBack;

public interface FeedBackRepository extends JpaRepository<FeedBack,Long>{

    public Optional<List<FeedBack>> findByUserID(Long userID);
}
