package org.spring.persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.domain.BoardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MapperTests {

	@Autowired
	private BoardMapper boardMapper;
	
	@Test
	public void testAllBoard() {
		log.info(boardMapper.selectAll());
	}
	
	@Test
	public void testSelect() {
		// bno가 10인 글을 조회하는 테스트
		BoardDTO dto = boardMapper.select(10);
		log.info(dto);
	}
	
	@Test
	public void testUpdate() {
		// bno가 10인 글 수정하는 테스트
		BoardDTO board = new BoardDTO(10, "수정한 제목", "수정한 글 내용");
		boardMapper.update(board);
	}
	
	@Test
	public void testInsert() {
		// bno가 10인 글 생성하는 테스트
		BoardDTO board = new BoardDTO("새로 등록한 제목", "새로 등록한 글 내용", "뉴비");
		boardMapper.insert(board);
	}
	
	@Test
	public void testDelete() {
		// 글 삭제 테스트
		int count = boardMapper.delete(14);
		log.info("삭제된 행의 갯수 : " + count);
	}
	
	@Test
	public void testInsertBno() {
		BoardDTO board = new BoardDTO("새로 등록한 제목", "새로 등록한 글 내용", "뉴비");
		boardMapper.insertSelectBno(board);
		log.info("등록된 글 번호 : " + board.getBno());
	}
}
