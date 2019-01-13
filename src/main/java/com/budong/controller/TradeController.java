package com.budong.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.budong.model.dto.MemberDTO;
import com.budong.model.dto.TradeDTO;
import com.budong.service.interfaces.TradeService;

@Controller
public class TradeController {
	private static final Logger logger = LoggerFactory.getLogger(TradeController.class);

	private TradeService service;
	@Autowired
    public TradeController(TradeService service) {
		this.service = service;
	}
	
	@RequestMapping("/testTrade.do")
    public String goToTradeAddPage() {
    	return "khw/tradeAdd";
    }
	@RequestMapping("/TradeList.do")
    public ModelAndView goToTradeList() {
		ModelAndView mav = new ModelAndView("khw/trade");
		mav.addObject("list", service.selectTrade());
		
    	return mav;
    }

	@RequestMapping("tradeAdd.do")
    public String goToTradeAdd(HttpServletRequest req) throws IllegalStateException, IOException {
		
		MultipartHttpServletRequest mr = (MultipartHttpServletRequest) req;
		MultipartFile mf = mr.getFile("image");
		String filename = mf.getOriginalFilename();
		String upPath = req.getSession().getServletContext().getRealPath("/resources/images");
				
		File file = new File(upPath, filename);
		mf.transferTo(file);
		TradeDTO dto = new TradeDTO();
		dto.setType(req.getParameter("type"));
		dto.setTrade_type(req.getParameter("trade_type"));
		dto.setLocation(req.getParameter("location"));
		dto.setArea(Integer.parseInt(req.getParameter("area")));
		dto.setDong(Integer.parseInt(req.getParameter("dong")));
		dto.setHo(Integer.parseInt(req.getParameter("ho")));
		dto.setFloor(Integer.parseInt(req.getParameter("floor")));
		dto.setMax_floor(Integer.parseInt(req.getParameter("max_floor")));
		dto.setPrice(Integer.parseInt(req.getParameter("price")));
		dto.setImage(filename);
		dto.setPhone(req.getParameter("phone"));
		
    	service.insertTrade(dto);
    	return "index";
    }
	
}
