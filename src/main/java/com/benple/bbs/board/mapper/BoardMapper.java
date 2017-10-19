package com.benple.bbs.board.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.benple.bbs.board.domain.BoardVO;
import com.benple.bbs.board.domain.FileVO;


@Repository("com.benple.bbs.board.mapper.BoardMapper")
public interface BoardMapper {

	public int boardCount() throws Exception;

	//게시글 목록
	public List<BoardVO> boardList() throws Exception;
	
	//게시글 상세
	public BoardVO boardDetail(int board_seq) throws Exception;
	
	//게시글 작성
	public int boardInsert(BoardVO board);
	
	//게시글 수정 
	public int boardUpdate(BoardVO board) throws Exception;
	
	//게시글 삭제
	public int boardDelete(int board_seq) throws Exception;

	//파일 업로드
	public int fileInsert(FileVO file) throws Exception;
	
}


