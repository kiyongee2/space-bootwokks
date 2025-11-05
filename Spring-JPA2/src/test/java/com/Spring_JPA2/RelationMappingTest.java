package com.Spring_JPA2;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.Spring_JPA2.entity.Board;
import com.Spring_JPA2.entity.Member;
import com.Spring_JPA2.repository.BoardRepository;
import com.Spring_JPA2.repository.MemberRepository;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class RelationMappingTest {
	
	@Autowired
	private MemberRepository memberRepo;
	
	@Autowired
	private BoardRepository boardRepo;
	
	/*@Test
	public void insertData() {
		//일반 회원
		Member member1 = new Member();
		member1.setMemberId("member1");
		member1.setPasswd("m1111");
		member1.setName("뽀로로");
		member1.setRole("USER");
		memberRepo.save(member1);
		
		//관리자
		Member member2 = new Member();
		member2.setMemberId("member2");
		member2.setPasswd("m2222");
		member2.setName("아기 상어");
		member2.setRole("ADMIN");
		memberRepo.save(member2);
		
		//일반회원이 작성한 게시글
		for(int i=1; i<=3; i++) {
			Board board = new Board();
			board.setTitle("뽀로로가 등록한 게시글 " + i);
			board.setContent("뽀로로가 등록한 게시글 내용 " + i);
			board.setMember(member1);
			boardRepo.save(board);
		}
		
		//관리자가 작성한 게시글
		for(int i=1; i<=3; i++) {
			Board board = new Board();
			board.setTitle("아기상어가 등록한 게시글 " + i);
			board.setContent("아기상어가 등록한 게시글 내용 " + i);
			board.setMember(member2);
			boardRepo.save(board);
		}
	}*/
	
	//특정 게시글을 작성한 회원 조회
	@Transactional
	@Test
	public void testSelect() {
		Optional<Board> optionalBoard = boardRepo.findById(5L);
		log.info("[" + optionalBoard.get().getId() + "번 게시글 정보]");
		
		if(optionalBoard.isPresent()) {
			Board board = optionalBoard.get();
			log.info("제목: " + board.getTitle());
			log.info("내용: " + board.getContent());
			log.info("글쓴이: " + board.getMember().getName());
		}else {
			log.info("해당 게시글을 찾을 수 없습니다.");
		}
	
		/*log.info("[" + board.getId() + "번 게시글 정보]");
		log.info("제목: " + board.getTitle());
		log.info("내용: " + board.getContent());
		log.info("글쓴이: " + board.getMember().getName());*/
	}
	
	//특정 회원이 작성한 모든 게시글 조회
	/*@Transactional
	@Test
	public void testGetBoardList() {
		//member1 회원 가져오기
		Member member = memberRepo.findByMemberId("member1").get();
		
		log.info(member.getName() + "가(이) 작성한 게시글 목록");
		
		//member1이 작성한 모든 게시글 가져오기
		List<Board> boardList = member.getBoards();
		for(Board board : boardList)
			log.info(board.toString());
	}*/

}









