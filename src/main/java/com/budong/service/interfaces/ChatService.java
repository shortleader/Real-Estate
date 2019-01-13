package com.budong.service.interfaces;

import java.util.List;

import com.budong.model.dto.ChatDTO;

public interface ChatService {

	public String updateMemberRoom(ChatDTO dto);

	public String updatePrevRoom(ChatDTO dto);

	public String getMemberRoom(String mem_id);

	public String getPrevRoom(String mem_id);

	public void saveChat(ChatDTO dto);

	public List<ChatDTO> getChatHistory(String room);

}
