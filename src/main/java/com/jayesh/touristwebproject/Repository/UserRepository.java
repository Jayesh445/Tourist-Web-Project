package com.jayesh.touristwebproject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jayesh.touristwebproject.Entity.User;

public interface UserRepository extends JpaRepository<User,Long>{

}
