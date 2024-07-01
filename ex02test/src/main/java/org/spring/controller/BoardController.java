package org.spring.controller;

import java.util.List;

import org.spring.domain.BoardDTO;
import org.spring.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board/*")
@Log4j
public class BoardController {

	private final BoardService boardService;
	private static final String REDIRECT_MAIN = "redirect:/board/list";

// 전체 게시글 목록 화면 이동
// void -> list.jsp 이동
	@GetMapping("/list")
	public void listAll() {
		log.info("list >>>");
	}

// 전체 게시글 목록 DB테이블 정보 반환
	@ResponseBody // AJAX 호출
	@PostMapping("/getlist")
	public List<BoardDTO> getList() {
		log.info("Ajax로 전체 게시물 조회 >>>");
		return boardService.listAll();

	}

// void -> register.jsp 이동
	@GetMapping("/register")
	public void registerGet() {
		log.info("registerGet >>>");
	}

// 실제로 글을 등록하는 비즈니스 로직
	@PostMapping("/register")
	public String register(BoardDTO board, RedirectAttributes rttr) {
		log.info("register >>>");
		Integer bno = boardService.registerKey(board);
		rttr.addAttribute("result", bno);
// URL이 바뀌어야함.
		return REDIRECT_MAIN;
	}

// 글 상세보기, 수정화면으로 이동
	@GetMapping({ "/get", "/modify" })
	public void read(@RequestParam("bno") Integer bno, Model model) {
		log.info("read >>>");
		model.addAttribute("dto", boardService.get(bno));
	}

// 실제로 글을 수정하는 비즈니스 로직
	@PostMapping("/modify")
	public String modify(BoardDTO board, RedirectAttributes rttr) {
		log.info("modify >>>");
		int row = boardService.modify(board);
		if (row == 1) {
			rttr.addAttribute("result", "success");
		}
		return REDIRECT_MAIN;
	}

	@PostMapping("/remove")
	public String remove(Integer bno, RedirectAttributes rttr) {
		log.info("remove >>>");
		int row = boardService.remove(bno);
		if (row == 1) {
			rttr.addAttribute("result", "success");
		}

		boardService.remove(bno);
		return REDIRECT_MAIN;
	}

}