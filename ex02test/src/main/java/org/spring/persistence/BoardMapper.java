package org.spring.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.spring.domain.BoardDTO;

public interface BoardMapper {
	
	@Select("SELECT * FROM board ORDER BY bno DESC")
	public List<BoardDTO> selectAll();
	
	// 게시글 등록
	public void insert(BoardDTO dto);
	
	public Integer insertSelectBno(BoardDTO dto);
	
	// 게시글 조회
	public BoardDTO	select(Integer bno);
	
	// 게시글 수정
	public int update(BoardDTO dto);
	
	// 게시글 삭제
	@Delete("DELETE FROM board WHERE bno = #{bno}")
	public int delete(Integer bno);
}
