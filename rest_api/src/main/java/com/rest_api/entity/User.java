package com.rest_api.entity;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "user")
@Entity
public class User {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;      //번호
	
	@Column(nullable=false, unique=true)
	private String userId; //아이디
	
	@Column(nullable=false)
	private String password; //비밀번호
	
	@Column(nullable=false)  //이름
	private String name;   
	
	@CreationTimestamp
	@Column(updatable=false)  //가입시엔 수정일이 입력되면 안됨
	private Timestamp regDate;   //가입일
	
	@UpdateTimestamp
	@Column(insertable=false)  //수정할때 가입일이 입력되면 안됨
	private Timestamp updateDate; //수정일
}
