package com.Spring_JPA2.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Spring_JPA2.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{
	
	Optional<Member> findByMemberId(String memberId);
}
