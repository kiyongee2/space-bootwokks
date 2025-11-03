package com.test.dto;

import java.security.Timestamp;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class MemberDTO {
	private Long id;
	
	@NotEmpty(message="이메일은 필수 항목입니다.")
	@Email
	private String email;
	
	@NotEmpty(message="비밀번호는 필수 항목입니다.")
	private String passwd;
	
	@NotEmpty(message="이름은 필수 항목입니다.")
	private String name;
	
	private Timestamp joinDate;
}
