package com.rest_api.service;

import java.util.List;
import java.util.Optional;

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

	//회원 목록
	public List<User> findAll() {
		return repository.findAll();
	}

	//회원 정보(1명 보기)
	public User findById(Integer id) {
		Optional<User> user = repository.findById(id);
		return user.get();
	}

	//회원 수정
	public void update(Integer id, User updateUser) {
		// 수정할 회원 가져오기
		User user = findById(id);
		// 수정(변경) 처리
		user.setUserId(updateUser.getUserId());
		user.setPassword(updateUser.getPassword());
		user.setName(updateUser.getName());
		repository.save(user);
	}

	//회원 삭제
	public void delete(Integer id) {
		repository.deleteById(id);
	}
}











