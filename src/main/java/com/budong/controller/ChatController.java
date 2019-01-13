package com.budong.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.budong.R;
import com.budong.model.dto.ChatDTO;
import com.budong.model.dto.MemberDTO;
import com.budong.service.interfaces.ChatService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author wjddp
 * 채팅 컨트롤러
 */
@Controller
public class ChatController {
	
	private static final Logger logger = LoggerFactory.getLogger(ChatController.class);
	private ChatService chatService; 

	@Autowired
	public ChatController(ChatService chatService) {
		this.chatService = chatService;
	}

	// 채팅 홈 화면 
	@RequestMapping(value = R.mapping.chat_home, method = RequestMethod.GET)
	public String home(Locale locale, Model model) { 
		
		logger.info("Welcome home! The client locale is {}.", locale);  
		return R.path.chat_home;
	} 
	
	
	//채팅 방 이동 
	@RequestMapping(value = R.mapping.move_chat_room, method = RequestMethod.POST)
	@ResponseBody
	public String  moveChatRoom(HttpServletRequest req,HttpServletResponse resp	) {
		resp.setContentType("text/html; charset=UTF-8");

		HttpSession session = req.getSession();  
		MemberDTO dto = (MemberDTO) session.getAttribute("login");
		
		//이동하기 이전 방 DB에 저장
		String prevRoom  = chatService.getMemberRoom(dto.getMem_id()); 
		chatService.updatePrevRoom(new ChatDTO(dto.getMem_id(),prevRoom,""));

		//이동한 방 DB에 저장
		String updatedRoomName = 
				chatService.updateMemberRoom(new ChatDTO(dto.getMem_id(),
						req.getParameter("roomName"),""));
		
		return updatedRoomName; 
	}
}
