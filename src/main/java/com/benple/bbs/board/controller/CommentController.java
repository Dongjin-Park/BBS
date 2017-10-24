package com.benple.bbs.board.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.benple.bbs.board.domain.CommentVO;
import com.benple.bbs.board.service.CommentService;

@Controller
@RequestMapping("/comment")
public class CommentController {
	
	@Resource(name="com.benple.bbs.board.service.CommentService")
	CommentService mCommentService;

	@RequestMapping("/list/{board_seq}")//댓글 리스트
	@ResponseBody
	private List<CommentVO> mCommentServiceList(@PathVariable int board_seq, Model model) throws Exception{
		
		return mCommentService.commentListService(board_seq);
	}
	
	
	@RequestMapping("/insert")//댓글 작성
	@ResponseBody
	private int mCommentServiceInsert(@RequestParam int board_seq, @RequestParam String content) throws Exception{
		
		CommentVO comment = new CommentVO();
		comment.setBoard_seq(board_seq);
		comment.setContent(content);
		//로그인 기능 구현 혹은 댓글 작성자 입력받는 폼 추가시 추후 값 세팅
		comment.setWriter("tester");
		
		return mCommentService.commentInsertService(comment);
	}
	
	
	@RequestMapping("/update")//댓글 수정
	@ResponseBody
	private int mCommentServiceUpdateProc(@RequestParam int comment_seq, @RequestParam String content) throws Exception{
		
		CommentVO comment = new CommentVO();
		comment.setComment_seq(comment_seq);
		comment.setContent(content);
		
		return mCommentService.commentUpdateService(comment);
	}
	
	@RequestMapping("/delete/{comment_seq}")//댓글 삭제
	@ResponseBody
	private int mCommentserviceDelete(@PathVariable int comment_seq) throws Exception{
		
		return mCommentService.commentDeleteService(comment_seq);
	}
}
