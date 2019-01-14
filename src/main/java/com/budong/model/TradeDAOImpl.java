package com.budong.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.budong.model.dto.TradeDTO;
import com.budong.model.interfaces.TradeDAO;

@Repository
public class TradeDAOImpl implements TradeDAO {
	
	
	private final SqlSessionTemplate mybatis;
	private static final String Namespace = "com.budong.model.interfaces.TradeDAO.";
	
	@Autowired
	public TradeDAOImpl(SqlSessionTemplate mybatis) {
		this.mybatis = mybatis;
	}


	@Override
	public int insertTrade(TradeDTO dto) {
		return mybatis.insert(Namespace+"insertTrade", dto);	
	}


	@Override
	public List<TradeDTO> selectTrade() {
		return mybatis.selectList("selectTrade");
	}
	
	

}
