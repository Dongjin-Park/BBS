package com.benple.bbs.board.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.benple.bbs.board.domain.CommentVO;
import com.benple.bbs.board.mapper.CommentMapper;

@Service("com.benple.bbs.board.service.CommentService")
public class CommentService {

	@Resource(name="com.benple.bbs.board.mapper.CommentMapper")
	CommentMapper mCommentMapper;
	
	public List<CommentVO> commentListService(int board_seq) throws Exception{
		
		return mCommentMapper.commentList(board_seq);
	}
	
	public int commentInsertService(CommentVO comment) throws Exception{
		
		return mCommentMapper.commentInsert(comment);
	}
	
	public int commentUpdateService(CommentVO comment) throws Exception{
		
		return mCommentMapper.commentUpdate(comment);
	}
	
	public int commentDeleteService(int comment_seq) throws Exception{
		
		return mCommentMapper.commentDelete(comment_seq);
	}
}
