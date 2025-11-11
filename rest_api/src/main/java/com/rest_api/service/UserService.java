package com.rest_api.service;

import org.springframework.stereotype.Service;

import com.rest_api.entity.User;
import com.rest_api.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
	//저장소 객체 생성
	private final UserRepository repository;

	//회원 가입
	public void save(User user) {
		repository.save(user);
	}
}
