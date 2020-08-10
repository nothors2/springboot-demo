package com.example.gradle.demo.repo;

import com.example.gradle.demo.entity.User;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface UserJpaRepo extends JpaRepositoryImplementation<User, Long> {}
   