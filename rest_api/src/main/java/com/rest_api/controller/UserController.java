package com.rest_api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest_api.entity.User;
import com.rest_api.service.UserService;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:3000") //리엑트의 포트를 설정
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
	
	//회원 목록
	@GetMapping
	public List<User> getAllUsers(){
		List<User> userList = service.findAll();
		return userList;
	}
	
	//회원 정보(상세보기)
	@GetMapping("/{id}")
	public User getUser(@PathVariable Integer id) {
		User user = service.findById(id);
		return user;
	}
	
	//회원 수정
	@PutMapping("/{id}")
	public String updateUser(@PathVariable Integer id,
			@RequestBody User user) {
		service.update(id, user);
		return "회원 수정 완료!";
	}
	
	//회원 삭제
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable Integer id) {
		service.delete(id);
		return "회원 삭제 완료!";
	}
}







