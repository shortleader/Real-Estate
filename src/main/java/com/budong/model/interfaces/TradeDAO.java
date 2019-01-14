package com.budong.model.interfaces;

import java.util.List;

import com.budong.model.dto.TradeDTO;

public interface TradeDAO {
	
	public int insertTrade(TradeDTO dto);
	public List<TradeDTO> selectTrade();

}
