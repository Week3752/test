package org.spring.service;

import java.util.List;

import org.spring.domain.BoardDTO;
import org.spring.persistence.BoardMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor
@Log4j
public class BoardServiceImpl implements BoardService{
	
	private BoardMapper boardMapper;

	@Override
	public List<BoardDTO> listAll() {
		log.info("listAll() 호출");
		return boardMapper.selectAll();
	}

	@Override
	public void register(BoardDTO dto) {
		log.info("dto : " + dto);
		boardMapper.insert(dto);
	}
	
	// 등록한 글번호를 반환하는 메서드
	public Integer registerKey(BoardDTO dto) {
		log.info("dto : " + dto);
		boardMapper.insertSelectBno(dto);
		return dto.getBno();
	}

	@Override
	public BoardDTO get(Integer bno) {
		log.info("bno : " + bno);
		return boardMapper.select(bno);
	}

	@Override
	public int modify(BoardDTO dto) {
		log.info("dto : " + dto);
		boardMapper.update(dto);
		return boardMapper.update(dto); // bno
	}

	@Override
	public int remove(Integer bno) {
		log.info("bno : " + bno);
		return boardMapper.delete(bno);
	}
	

}
