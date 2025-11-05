package com.Spring_JPA2.entity;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString(exclude="member") //순환 참조 오류 방지
@Setter
@Getter
@Entity
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;      //글 번호
	
	@Column(nullable=false)
	private String title; //글 제목
	
	@Column(length=4000, nullable=false)
	private String content; //글 내용
	
	@CreationTimestamp  //자동 생성
	private Timestamp regDate; //작성일
	
	//다대일 (Board(다): Member(일))
	//FetchType.EAGER - 전체출력, FetchType.LAZY - 조회시
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn() //외래키 조인
	private Member member;
}






