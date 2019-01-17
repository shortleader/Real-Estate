package com.budong.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.budong.model.dto.ChatDTO;
import com.budong.model.interfaces.ChatDAO;
import com.budong.service.interfaces.ChatService;

@Service
public class ChatServiceImpl implements ChatService {

	private final ChatDAO chatDAO;

	@Autowired
	public ChatServiceImpl(ChatDAO chatDAO) {
		this.chatDAO = chatDAO;
	}

	@Override
	public String updateMemberRoom(ChatDTO dto) {

		int res = chatDAO.updateMemberRoom(dto);
		String result = res > 0 ? dto.getRoom() : "";
		return result;
	}

	@Override
	public String updatePrevRoom(ChatDTO dto) {

		int res = chatDAO.updatePrevRoom(dto);

		String result = res > 0 ? dto.getRoom() : "";
		return result;
	}

	@Override
	public String getMemberRoom(String mem_id) {
		String room = chatDAO.getMemberRoom(mem_id);

		String result = (room == null) ? null : room;
		return result;
	}

	@Override
	public String getPrevRoom(String mem_id) {
		String room = chatDAO.getPrevRoom(mem_id);

		String result = (room == null) ? null : room;
		return result;
	}

}
