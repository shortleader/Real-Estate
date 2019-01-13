package com.budong.model;

import com.budong.model.dto.MemberDTO;
import com.budong.model.interfaces.MemberDAO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Repository
public class MemberDAOImpl implements MemberDAO {

	private final SqlSessionTemplate mybatis;
	private static final String Namespace = "com.budong.model.interfaces.MemberDAO.";

	@Autowired
	public MemberDAOImpl(SqlSessionTemplate mybatis) {
		this.mybatis = mybatis;
	}

	@Override
	public MemberDTO login(MemberDTO dto) {
		return mybatis.selectOne(Namespace + "login", dto);
	}
	
	@Override
	public int isAvailableId(String mem_id) { 
		return mybatis.selectOne(Namespace+"checkId",mem_id);
	}

	public int insertMember(MemberDTO dto) {
		return mybatis.insert(Namespace + "insertMember", dto);
	}
}
