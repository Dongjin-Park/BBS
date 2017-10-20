package com.benple.bbs.board.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.benple.bbs.board.domain.BoardVO;
import com.benple.bbs.board.domain.FileVO;
import com.benple.bbs.board.mapper.BoardMapper;

@Service("com.benple.bbs.board.service.BoardService")
public class BoardService {

	@Resource(name="com.benple.bbs.board.mapper.BoardMapper")
	BoardMapper mBoardMapper;
	
	public List<BoardVO> boardListService() throws Exception{
		
		return mBoardMapper.boardList();
	}
	
	public BoardVO boardDetailService(int board_seq) throws Exception{
		
		return mBoardMapper.boardDetail(board_seq);
	}
	
	public int boardInsertService(BoardVO board) throws Exception{
		
		return mBoardMapper.boardInsert(board);
	}
	
    public int boardUpdateService(BoardVO board) throws Exception{
        
        return mBoardMapper.boardUpdate(board);
	}
	
	public int boardDeleteService(int board_seq) throws Exception{
		
		return mBoardMapper.boardDelete(board_seq);
	}
	
	public int fileInsertService(FileVO file) throws Exception{
	    return mBoardMapper.fileInsert(file);
	}

	public FileVO fileDetailService(int board_seq) throws Exception{
		return mBoardMapper.fileDetail(board_seq);
	}
}
