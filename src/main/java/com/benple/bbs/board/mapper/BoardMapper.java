package com.benple.bbs.board.mapper;

import org.springframework.stereotype.Repository;

@Repository("com.benple.bbs.board.mapper.BoardMapper")
public interface BoardMapper {

	public int boardCount() throws Exception;
}
