package com.budong.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.budong.model.dto.ChatDTO;
import com.budong.model.interfaces.ChatDAO;

/**
 *
 * @author wjddp 채팅에 관련된 모든 메소드를 정의
 *
 */
@Repository
public class ChatDAOImpl implements ChatDAO {

	private final SqlSessionTemplate mybatis;
	private static final String Namespace = "com.budong.model.interfaces.ChatDAO.";

	@Autowired
	public ChatDAOImpl(SqlSessionTemplate mybatis) {
		this.mybatis = mybatis;
	}

	@Override
	public int updateMemberRoom(ChatDTO dto) {

		return mybatis.update(Namespace + "updateMemberRoom", dto);
	}

	@Override
	public int updatePrevRoom(ChatDTO dto) {
		return mybatis.update(Namespace + "updatePrevRoom", dto);
	}

	@Override
	public String getMemberRoom(String mem_id) {
		return mybatis.selectOne(Namespace + "getMemberRoom", mem_id);
	}

	@Override
	public String getPrevRoom(String mem_id) {
		return mybatis.selectOne(Namespace + "getPrevRoom", mem_id);
	}

	@Override
	public int saveChat(ChatDTO dto) {
		return mybatis.insert(Namespace + "saveChat", dto);
	}

	@Override
	public List<ChatDTO> getChatHistory(String room) {
		return mybatis.selectList(Namespace + "getChatHistory", room);
	}

}
