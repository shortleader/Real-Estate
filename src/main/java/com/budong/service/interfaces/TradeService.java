package com.budong.service.interfaces;

import java.util.List;

import com.budong.model.dto.TradeDTO;

public interface TradeService {

	public int insertTrade(TradeDTO dto);
	public List<TradeDTO> selectTrade();
}
