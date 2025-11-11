package com.rest_api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest_api.entity.User;
import com.rest_api.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
public class UserController {

	//서비스 인스턴스 생성
	private final UserService service;
	
	//회원 가입
	//@RequestBody - json 데이터 요청(받기)
	@PostMapping
	public String saveUser(@RequestBody User user) {
		service.save(user);
		return "회원 가입 성공!!";
	}
}







