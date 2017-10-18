package com.benple.bbs.board.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.benple.bbs.board.domain.BoardVO;
import com.benple.bbs.board.service.BoardService;

@Controller
public class BoardController {
	
	@Resource(name="com.benple.bbs.board.service.BoardService")
	BoardService mBoardService;
	
	@RequestMapping("/list")//게시판 리스트 화면 호출 
	private String boardList(Model model) throws Exception{
		
		model.addAttribute("list", mBoardService.boardListService());
		
		return "list";//생성할 jsp
	}
	
	@RequestMapping("/detail/{board_seq}")//상세뷰 호출 
	private String boardDetail(@PathVariable int board_seq, Model model) throws Exception{
		
		model.addAttribute("detail", mBoardService.boardDetailService(board_seq));
		
		return "detail";
	}
	
	@RequestMapping("/insert")//게시글 작성폼 호출
	private String boardInsertFrom(){
		
		return "insert";
	}
	
	@RequestMapping("/insertProc")
	private String boardInsertProc(HttpServletRequest request) throws Exception{
		
		BoardVO board = new BoardVO();
		
		board.setSubject(request.getParameter("subject"));
		board.setContent(request.getParameter("content"));
		board.setWriter(request.getParameter("writer"));
		
		mBoardService.boardInsertService(board);
		
		return "redirect:/list";
	}
	
	
	@RequestMapping("/update/{board_seq}")//게시글 수정폼 호출
	private String boardUpdateForm(@PathVariable int board_seq, Model model) throws Exception{
		
		model.addAttribute("detail", mBoardService.boardDetailService(board_seq));
		
		return "update";
	}

	@RequestMapping("/updateProc")
	private String boardUpdateProc(HttpServletRequest request) throws Exception{
		
		BoardVO board = new BoardVO();
		board.setSubject(request.getParameter("subject"));
		board.setContent(request.getParameter("content"));
		board.setBoard_seq(Integer.parseInt(request.getParameter("board_seq")));
		
		mBoardService.boardUpdateService(board);
		
		
		
		return "redirect:/detail/"+request.getParameter("board_seq");
	}
	
	
	@RequestMapping("/delete/{board_seq}")
	private String boardDelete(@PathVariable int board_seq) throws Exception{
		
		mBoardService.boardDeleteService(board_seq);
		
		return "redirect:/list";
	}
	
}
