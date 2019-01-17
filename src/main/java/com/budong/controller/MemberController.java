package com.budong.controller;

import java.io.File;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.budong.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.budong.model.dto.MemberDTO;
import com.budong.service.interfaces.MainService;

/**
 * 
 * @author wjddp 회원 가입 및 로그인 페이지
 */
@Controller
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(ChatController.class);

	private MainService service;

	@Autowired
	public MemberController(MainService service) {
		this.service = service;
	}

	// 회원 가입
	@RequestMapping(value = R.mapping.insert_member, method = RequestMethod.POST)
	public String insertMember(HttpServletRequest req) throws Exception {
		logger.info("InsertMember");

		MultipartHttpServletRequest mr = (MultipartHttpServletRequest) req;
		MultipartFile mf = mr.getFile("mem_img");
		String filename = mf.getOriginalFilename();
		String upPath = req.getSession().getServletContext().getRealPath("/resources/images");

		File file = new File(upPath, filename);
		mf.transferTo(file);

		MemberDTO dto = new MemberDTO();
		dto.setMem_id(req.getParameter("mem_id"));
		dto.setMem_img(filename);
		dto.setMem_name(req.getParameter("mem_name"));
		dto.setMem_pw(req.getParameter("mem_pw"));
		dto.setMem_region(req.getParameter("mem_region"));

		service.insertMember(dto);
		return "redirect:" + R.mapping.INDEX;
	}
	
	//아이디 중복 체크 
	@RequestMapping(value= R.mapping.check_id , method = RequestMethod.POST)
	@ResponseBody
	public String isAvailableId(HttpServletRequest req) {
		String id = req.getParameter("id");  
		logger.info("id: " +id);
		boolean available = service.isAvailableId(id);
		
		if(available) { 
			return "valid"; 
		}else {
			return "invalid"; 
		}
	} 
	
	// 로그인 페이지 이동
	@RequestMapping(value = R.mapping.login_home)
	public String loginHome() {
		return R.path.login_home;
	}

	// 로그인
	@RequestMapping(value = R.mapping.login, method = RequestMethod.POST)
	public String login(HttpServletRequest req, HttpServletResponse resp, MemberDTO dto) {

		HttpSession session = req.getSession();

		logger.info("session login : " + session.getAttribute("login"));
		MemberDTO memberDTO = service.login(dto.getMem_id(), dto.getMem_pw());

		/*if (session.getAttribute("login") != null) {
			session.removeAttribute("login");
		}*/

		if (memberDTO == null) { // 로그인 실패
			logger.info("로그인 실패");
			return "redirect:" + R.path.INDEX;
		} else {
			// 로그인 성공
			logger.info("로그인 성공");

			// 사용자정보를 세션에 저장
			session.setAttribute("login", memberDTO);
			session.setAttribute("roomName", null); 
			
			MemberDTO cdto = (MemberDTO) session.getAttribute("login");
			logger.info(cdto.getMem_id());
			return "redirect:" + R.mapping.INDEX;
		}
	}

	// 로그아웃
	@RequestMapping(value = R.mapping.logout)
	public String logout(HttpServletRequest req) {
		logger.info("로그아웃");
		HttpSession session = req.getSession();
		session.removeAttribute("login");
		session.invalidate();

		return "redirect:" + R.mapping.INDEX;
	}
}
