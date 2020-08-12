package com.example.gradle.demo.repo;

import com.example.gradle.demo.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserJpaRepo extends JpaRepository<User, Long> {

  Optional<User> findByUid(String email);

  Optional<User> findByUidAndProvider(String uid, String provider);  
}
   