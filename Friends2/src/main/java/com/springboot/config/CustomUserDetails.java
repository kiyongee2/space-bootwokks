package com.springboot.config;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.springboot.entity.Member;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor  //생성자 주입
public class CustomUserDetails implements UserDetails{
	
	//Member 인스턴스 선언
	private final Member member;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.singletonList(new SimpleGrantedAuthority(member.getRole()));
	}

	@Override
	public String getPassword() {
		return member.getPasswd();
	}

	@Override
	public String getUsername() {
		return member.getEmail();
	}
	
	//추가로 Member 정보 접근 getter
	public Long getId() {
		return member.getId();
	}
	
	public String getName() {
		return member.getName();
	}

}
