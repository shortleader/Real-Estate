package com.budong.model;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.budong.model.dto.Local_LawdCodeDTO;

@Repository
public class Local_LawdCodeDAOImpl implements com.budong.model.interfaces.Local_LawdCodeDAO {

	private final SqlSessionTemplate mybatis;
	private static final String Namespace = "com.budong.model.interfaces.Local_LawdCodeDAO.";

    @Autowired
    public Local_LawdCodeDAOImpl(SqlSessionTemplate mybatis) {
        this.mybatis = mybatis;
    }

	@Override
	public String getLawdCode(Local_LawdCodeDTO dto) {
        return mybatis.selectOne(Namespace + "lawdCode", dto);
	}
}
