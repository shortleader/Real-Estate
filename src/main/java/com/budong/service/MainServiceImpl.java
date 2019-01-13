package com.budong.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.budong.controller.ChatController;
import com.budong.model.dto.MemberDTO;
import com.budong.model.interfaces.MemberDAO;
import com.budong.service.interfaces.MainService;

@Service
public class MainServiceImpl implements MainService {
	
	private final MemberDAO memberDAO;
	private static final Logger logger = LoggerFactory.getLogger(ChatController.class);

	@Autowired
	public MainServiceImpl(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	// 아이디 중복 확인
	@Override
	public boolean isAvailableId(String id) { 
		int res = memberDAO.isAvailableId(id);  
		
		boolean result = (res==0) ?   true : false;
		return result; 
	}

	// 회원 가입
	@Override
	public int insertMember(MemberDTO dto) {
		return memberDAO.insertMember(dto);
	}

	// 로그인
	@Override
	public MemberDTO login(String mem_id, String mem_pw) {
		MemberDTO dto = memberDAO.login(new MemberDTO(mem_id, mem_pw)); 
		
		if (dto == null) {
			return null;
		} else {
			return dto;
		}
	}

}
