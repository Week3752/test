package org.spring.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class BoardDTO {
	private Integer bno;
	private String title, content, writer;
	private Timestamp regdate;
	private Integer viewcnt;
	
	public BoardDTO() {}

	public BoardDTO(int bno, String title, String content) {
		super();
		this.bno = bno;
		this.title = title;
		this.content = content;
	}

	public BoardDTO(String title, String content, String writer) {
		super();
		this.title = title;
		this.content = content;
		this.writer = writer;
	}
	
}
