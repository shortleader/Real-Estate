package com.budong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.budong.model.dto.TradeDTO;
import com.budong.model.interfaces.TradeDAO;
import com.budong.service.interfaces.TradeService;

@Service
public class TradeServiceImpl implements TradeService{

	
	private TradeDAO tradeDAO;

	@Autowired
	public TradeServiceImpl(TradeDAO tradeDAO) {
		this.tradeDAO = tradeDAO;
	}

	@Override
	public int insertTrade(TradeDTO dto) {
		return tradeDAO.insertTrade(dto);
	}

	@Override
	public List<TradeDTO> selectTrade() {
		return tradeDAO.selectTrade();
	}
	
	

}
