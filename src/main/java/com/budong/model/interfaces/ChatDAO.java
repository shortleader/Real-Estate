package com.budong.model.interfaces;

import com.budong.model.dto.ChatDTO;

public interface ChatDAO {
	//mem_id 의 현재 채팅방을 mem_room 으로 업데이트. 
	public int updateMemberRoom(ChatDTO dto); 
	
	//mem_id의 이전 채팅방을 mem_room 으로 업데이트. 
	public int updatePrevRoom(ChatDTO dto);
	
	//mem_id의 현재 채팅방 이름을 가져옴. 
	public String getMemberRoom(String mem_id);   
	
	//mem_id의 이전 채팅방 이름을 가져옴
	public String getPrevRoom(String mem_id); 
	
}
