package com.springboot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.dto.MemberDTO;
import com.springboot.entity.Member;
import com.springboot.repository.MemberRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor  //매개변수를 모두 가진 생성자
@Service  //스프링에 빈(bean) 등록
public class MemberService {
	
	//객체(인스턴스) 생성 방식 - 생성자 주입 방식
	private MemberRepository repository;
	
	//회원 가입(추가)
	public void save(MemberDTO dto) {
		//dto를 entity로 변환하는 메서드를 호출
		Member member = Member.toSaveEntity(dto);
		repository.save(member);
	}
	
	//회원 목록
	public List<Member> findAll(){
		return repository.findAll();
	}
	
	//회원 정보
	public Member findById(Long id) {
		Member member = repository.findById(id).get();
		return member;
	}
}








