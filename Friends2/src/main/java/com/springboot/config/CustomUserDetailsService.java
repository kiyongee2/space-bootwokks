package com.springboot.config;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springboot.entity.Member;
import com.springboot.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor  //생성자 주입(객체 생성)
public class CustomUserDetailsService implements UserDetailsService{

	private final MemberRepository memberRepo;

	@Override //이메일을 검색해서 사용자 가져오기
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Member member = memberRepo.findByEmail(username)
			.orElseThrow(() -> 
			new UsernameNotFoundException("사용자를 찾을 수 없습니다."));
		return new CustomUserDetails(member);
	}
	
}
