package com.budong.model.interfaces;

import java.util.List;

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
	
	//채팅 기록을 저장함 
	public int saveChat(ChatDTO dto); 
	
	//room에 있는 채팅 기록을 가져옴
	public List<ChatDTO> getChatHistory(String room); 
	
}
