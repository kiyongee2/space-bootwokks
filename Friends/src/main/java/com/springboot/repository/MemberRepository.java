package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{
   //지원 메서드-save(), findAll(), findById(), deleteById()
}
