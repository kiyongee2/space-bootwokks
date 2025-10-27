package com.springboot.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.dto.MemberDTO;
import com.springboot.entity.Member;
import com.springboot.service.MemberService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor  //생성자 주입
@Slf4j
@RequestMapping("/members")
@Controller
public class MemberController {
	
	//서비스 인스턴스 생성
	private MemberService service;

	//회원 가입 페이지
	@GetMapping("/join")
	public String joinForm() {
		return "member/join";
	}
	
	//회원 가입 처리
	@PostMapping("/join")
	public String join(@ModelAttribute MemberDTO memberDTO) {
		log.info("member: " + memberDTO);
		service.save(memberDTO);  //서비스에 있는 save() 호출
		return "redirect:/";
	}
	
	//회원 목록
	@GetMapping
	public String getMemberList(Model model) {
		List<Member> memberList = service.findAll(); //서비스의 findAll() 호출
		//모델로 저장해서 list 보내기
		model.addAttribute("memberList", memberList);
		return "member/list";  //member/list.html
	}
	
	//회원 정보(1명 보기)
	@GetMapping("/{id}") //id - 경로 변수
	public String getMember(@PathVariable Long id,
			Model model) {
		Member member = service.findById(id);
		model.addAttribute("member", member);  //회원 보내기
		return "member/info";
	}
	
	
}





