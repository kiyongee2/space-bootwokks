package com.Spring_JPA2.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString(exclude="boards") //순환 참조 오류 방지
@Setter
@Getter
@Entity
public class Member {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;  //번호
	
	@Column(unique = true)  //중복 방지
	private String memberId; //회원 아이디
	
	@Column(nullable=false) //필수 입력
	private String passwd; //비밀번호
	
	@Column(length=30, nullable=false)
	private String name;  //이름
	
	@Column(nullable=false)
	private String role;  //권한
	
	@CreationTimestamp  //자동 생성
	private Timestamp joinDate; //가입일
	
	//참조 관계(Member(1) : Board(다))
	//mappedBy - 다쪽이 아니고 일쪽이라는 의미
	@OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
	private List<Board> boards = new ArrayList<>();
}





