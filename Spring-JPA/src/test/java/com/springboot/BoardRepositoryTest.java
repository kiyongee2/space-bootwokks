package com.springboot;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springboot.entity.Board;
import com.springboot.repository.BoardRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j  //로그 사용
@SpringBootTest
public class BoardRepositoryTest {
	
	@Autowired  //자동 주입(객체 생성)
	private BoardRepository repository;
	
	//게시글 추가(등록)
	@Test
	public void insertBoard() {
		/*Board board = new Board();
		//id, createDate는 자동 입력
		board.setTitle("가입 인사");
		board.setWriter("박신입");
		board.setContent("안녕하세요~ 잘 부탁드려요!");
		
		repository.save(board);  //board 객체 저장*/
		
		/*Board board = Board.builder()
				.title("안녕하세요~")
				.writer("이신입")
				.content("만나서 반갑습니다..")
				.build();
		repository.save(board);*/
	}
	
	//게시글 수정
	/*@Test
	public void updateBoard() {
		log.info("=== 2번 게시글 조회 ===");
		Board board = repository.findById(2).get();
		
		log.info("=== 2번 게시글 제목 수정 ===");
		board.setTitle("제목을 수정합니다.");
		
		//수정후 저장
		repository.save(board);
	}*/
	
	//게시글 상세 보기(1건 보기)
	/*@Test
	public void getBoard() {
		log.info("=== 2번 게시글 조회 ===");
		Optional<Board> board = repository.findById(2);
		log.info("--->" + board.toString());
	}*/
	
	//게시글 삭제
	/*@Test
	public void deleteBoard() {
		log.info("=== 1번 게시글 삭제 ===");
		repository.deleteById(1);
	}*/
	
	//게시글 목록
	@Test
	public void getBoardList() {
		List<Board> boardList = repository.findAll();
		
		for(Board board : boardList) {
			//System.out.println(board.toString());
			log.info("--->" + board.toString());
		}
	}
	
	
}







