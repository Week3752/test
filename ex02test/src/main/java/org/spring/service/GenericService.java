package org.spring.service;

// 모든 게시판 또는 회원에 적용되는 인터페이스
public interface GenericService<DTO, K> {
	
	// CRUD 기능 필수
	public void register(DTO dto);
	
	public DTO get(K pk);
	
	public int modify(DTO dto);
	
	public int remove(K pk);
}
