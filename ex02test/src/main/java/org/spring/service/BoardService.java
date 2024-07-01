package org.spring.service;

import java.util.List;

import org.spring.domain.BoardDTO;

public interface BoardService extends GenericService<BoardDTO, Integer> {
	
	// 전체 회원 보기
	public List<BoardDTO> listAll();
	
	public Integer registerKey(BoardDTO dto);
}
