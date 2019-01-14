package com.budong.model.interfaces;

import java.util.List;

import com.budong.model.dto.BoardDTO;

public interface BoardDAO {
	public List<BoardDTO> listboard();

	public List<BoardDTO> getContent(int num);

	public int insertBoard(BoardDTO dto);

	public int deleteBoard(int num);

	public int updateBoard(BoardDTO dto);

	public int updateReadCnt(int num);
	
}
