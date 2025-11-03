package com.springboot.dto;

import java.sql.Timestamp;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class BoardDTO {
	private Long id;      //글 번호
	
	@NotEmpty(message = "제목은 필수 항목입니다.")
	private String title; //글 제목
	
	@NotEmpty(message = "내용은 필수 항목입니다.")
	private String content; //글 내용
	
	private Integer hits;  //조회수
	private String writer;  //글쓴이
	private Timestamp regDate; //작성일
}
