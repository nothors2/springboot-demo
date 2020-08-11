package com.example.gradle.demo.controller;
 
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.example.gradle.demo.entity.User;
import com.example.gradle.demo.model.response.*;
import com.example.gradle.demo.repo.UserJpaRepo;
import com.example.gradle.demo.service.ResponseService;

@Api(tags = {"1. User"})
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1")
public class UserController {

  private final UserJpaRepo userJpaRepo;
  private final ResponseService responseService; // 결과를 처리할 Service

  @ApiOperation(value = "회원 조회", notes = "모든 회원을 조회한다")
  @GetMapping(value = "/user")
  public ListResult<User> findAllUser() {
    // 결과데이터가 여러건인경우 getListResult를 이용해서 결과를 출력한다.
    return responseService.getListResult(userJpaRepo.findAll());
    //return userJpaRepo.findAll();
  }

  @ApiOperation(value = "회원 단건 조회", notes = "userId로 회원을 조회한다")
  @GetMapping(value = "/user/{msrl}")
  public SingleResult<User> findUserById(@ApiParam(value = "회원ID", required = true) @PathVariable long msrl) {
    // 결과데이터가 단일건인경우 getBasicResult를 이용해서 결과를 출력한다.
    return responseService.getSingleResult(userJpaRepo.findById(msrl).orElse(null));
  }
  
  @ApiOperation(value = "회원 입력", notes = "회원을 입력한다.")
  @PostMapping(value = "/user")
  public SingleResult<User> save(@ApiParam(value = "회원아이디", required = true) @RequestParam String uid,
                   @ApiParam(value = "회원이름", required = true) @RequestParam String name) {
    User user = User.builder()
            .uid(uid)
            .name(name)
            .build();
    //return userJpaRepo.save(user);
    return responseService.getSingleResult(userJpaRepo.save(user));
  }

  @ApiOperation(value = "회원 삭제", notes = "userId로 회원정보를 삭제한다")
  @DeleteMapping(value = "/user/{msrl}")
  public CommonResult delete(
          @ApiParam(value = "회원번호", required = true) @PathVariable long msrl) {
      userJpaRepo.deleteById(msrl);
      // 성공 결과 정보만 필요한경우 getSuccessResult()를 이용하여 결과를 출력한다.
      return responseService.getSuccessResult();
  }
}