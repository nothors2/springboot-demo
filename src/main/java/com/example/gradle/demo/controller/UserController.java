package com.example.gradle.demo.controller;

import java.util.List;

import com.example.gradle.demo.entity.User;
import com.example.gradle.demo.repo.UserJpaRepo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@RestController // 결과값을 JSON으로 출력합니다.
@RequestMapping(value = "/v1")
public class UserController {
  private final UserJpaRepo userJpaRepo;

  @GetMapping(value = "/user")
  public List<User> findAllUser() {
      return userJpaRepo.findAll();
  }

  @PostMapping(value = "/user")
  public User save() {
      User user = User.builder()
              .uid("yumi12@naver.com")
              .name("유미")
              .build();
      return userJpaRepo.save(user);
  }  
}