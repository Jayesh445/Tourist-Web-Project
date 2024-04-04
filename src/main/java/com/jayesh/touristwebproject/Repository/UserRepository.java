package com.jayesh.touristwebproject.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jayesh.touristwebproject.Entity.User;

public interface UserRepository extends JpaRepository<User,Long>{

    public Optional<User> findByEmailAndPassword(String email,String password);
}
