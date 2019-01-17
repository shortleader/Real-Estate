package com.budong.model.interfaces;

import java.util.List;

import com.budong.model.dto.BoardDTO;
import com.budong.model.dto.ReplyDTO;

public interface BoardDAO {
	public List<BoardDTO> listboard();

	public List<BoardDTO> getContent(int num);

	public int insertBoard(BoardDTO dto);

	public int deleteBoard(int num);

	public int updateBoard(BoardDTO dto);

	public int updateReadCnt(int num);
	
	public int insertReply(ReplyDTO dto);

	public int checkReply(int num);
	
	public List<ReplyDTO> listreply(int num);
	
	
}
