package com.budong.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.budong.controller.ChatController;
import com.budong.model.dto.ChatDTO;
import com.budong.model.interfaces.ChatDAO;
import com.budong.service.interfaces.ChatService;

@Service
public class ChatServiceImpl implements ChatService {

	private final ChatDAO chatDAO;

	private static final Logger logger = LoggerFactory.getLogger(ChatController.class);

	@Autowired
	public ChatServiceImpl(ChatDAO chatDAO) {
		this.chatDAO = chatDAO;
	}

	@Override
	public String updateMemberRoom(ChatDTO dto) {

		int res = chatDAO.updateMemberRoom(dto); 
		String result = res >0 ? dto.getRoom() : null; 
		return result; 
	}

	@Override
	public String updatePrevRoom(ChatDTO dto) {

		int res = chatDAO.updatePrevRoom(dto);

		String result = res > 0 ? dto.getRoom() : null; 
		return result; 
	}

	@Override
	public String getMemberRoom(String mem_id) {
		String roomName = chatDAO.getMemberRoom(mem_id);
		return roomName;
	}

	@Override
	public String getPrevRoom(String mem_id) {
		String roomName = chatDAO.getPrevRoom(mem_id);
		return roomName;
	}
	
}
