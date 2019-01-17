package com.budong.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.budong.model.dto.BoardDTO;
import com.budong.model.dto.ReplyDTO;
import com.budong.model.interfaces.BoardDAO;

@Repository
public class BoardDAOImpl implements BoardDAO{

	private final SqlSessionTemplate mybatis;
	private static final String Namespace = "com.budong.model.interfaces.BoardDAO.";
	private static final Logger logger = LoggerFactory.getLogger(BoardDAOImpl.class);
	
	@Autowired
	public BoardDAOImpl(SqlSessionTemplate mybatis) {
		logger.info("DAOImpl : ready..");
		this.mybatis = mybatis;
	}

	@Override
	public List<BoardDTO> listboard() {
		logger.info("listboard : ok ");
		return mybatis.selectList(Namespace + "selectBoardList");
	}

	@Override
	public List<BoardDTO> getContent(int num) {
		return mybatis.selectList(Namespace + "selectContent", num);
	}

	@Override
	public int insertBoard(BoardDTO dto) {
		return mybatis.insert(Namespace + "insertBoard", dto);
	}

	@Override
	public int deleteBoard(int num) {
		return mybatis.delete(Namespace + "deleteBoard", num);
	}

	@Override
	public int updateBoard(BoardDTO dto) {
		return mybatis.update(Namespace + "updateBoard", dto);
	}
	
	@Override
	public int updateReadCnt(int num) {
		return mybatis.update(Namespace + "updateReadCnt", num);
	}
	
	@Override
	public int insertReply(ReplyDTO dto) {
		return mybatis.insert(Namespace + "insertReply", dto);
	}
	
	@Override
	public int checkReply(int num) {
		Object obj;
		try {
			obj = mybatis.selectOne(Namespace + "checkReply", num);
			logger.info(obj.toString());
		} catch (NullPointerException e) {
			logger.error(e.getMessage());
			return 0;
		}
		return (int) obj;
	}
	
	@Override
	public List<ReplyDTO> listreply(int num) {
		logger.info("listreply : ok ");
		return mybatis.selectList(Namespace + "selectReplyList",num);
	}

}
