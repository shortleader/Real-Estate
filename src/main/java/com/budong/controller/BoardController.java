package com.budong.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.budong.R;
import com.budong.model.dto.BoardDTO;
import com.budong.model.interfaces.BoardDAO;

@Controller
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	private BoardDAO boardDAO;

	@Autowired
	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}
	
	
	// �۸������ �̵�
	@RequestMapping(value = R.mapping.board_home, method = RequestMethod.GET)
	public ModelAndView list(Locale locale, ModelAndView mav) {

		logger.info("board list: ok", locale);
		mav = new ModelAndView();

		List<BoardDTO> boardList = boardDAO.listboard();

		mav.addObject("list", boardList);
		mav.setViewName(R.path.board_home);
		return mav;
	}

	// �� �� ����
	@RequestMapping(value = R.mapping.board_content, method = RequestMethod.GET)
	public ModelAndView content(HttpServletRequest req, ModelAndView mav) throws Exception {

		logger.info("Board content: ok");

		int num = ServletRequestUtils.getIntParameter(req, "num");

		boardDAO.updateReadCnt(num);

		List<BoardDTO> boardContent = boardDAO.getContent(num);

		mav.addObject("content", boardContent);
		mav.setViewName(R.path.board_content);
		return mav;

	}

	// �� ���� �� �̵�
	@RequestMapping(value = R.mapping.board_writeform, method = RequestMethod.GET)
	public String write() {

		logger.info("Board write: ok");

		return R.path.board_writeform;

	}

	// �� �Է�
	@RequestMapping(value = R.mapping.board_insert, method = RequestMethod.POST)
	public ModelAndView insert(HttpServletRequest req, ModelAndView mav) throws Exception {
		logger.info("Board insert: ok");
		mav = new ModelAndView();

		BoardDTO dto = new BoardDTO();

		dto.setWriter(req.getParameter("writer"));
		dto.setTitle(req.getParameter("title"));
		dto.setContent(req.getParameter("content"));

		boardDAO.insertBoard(dto);

		List<BoardDTO> boardList = boardDAO.listboard();

		mav.addObject("list", boardList);
		mav.setViewName(R.path.board_home);
		return mav;
	}

	// �� ���� �� �̵�
	@RequestMapping(value = R.mapping.board_updateform, method = RequestMethod.GET)
	public ModelAndView updateform(HttpServletRequest req, ModelAndView mav) throws Exception {

		logger.info("Board updateform: ok");

		int num = ServletRequestUtils.getIntParameter(req, "num");
		logger.info("num : " + num);
		List<BoardDTO> boardContent = boardDAO.getContent(num);
//		List<BoardDTO> boardList = boardDAO.listboard();

		mav.addObject("content", boardContent);
		mav.setViewName(R.path.board_updateform);
		return mav; // ���� ������ �̵�
	}

	// �� ����
	@RequestMapping(value = R.mapping.board_update, method = RequestMethod.POST)
	public ModelAndView update(HttpServletRequest req, ModelAndView mav) throws Exception{
		logger.info("Board update: ok");
		
		
		BoardDTO dto = new BoardDTO();
		
		dto.setWriter(req.getParameter("writer"));
		dto.setTitle(req.getParameter("title"));
		dto.setContent(req.getParameter("content"));
		dto.setNum(Integer.parseInt(req.getParameter("num")));
		
		boardDAO.updateBoard(dto);
		
		List<BoardDTO> boardList = boardDAO.listboard();
		mav.addObject("list", boardList);
		
		mav.setViewName(R.path.board_home);
	
		return mav; // �Խñ� ���� �� ������� �̵�
	}

	// �� ����
	@RequestMapping(value = R.mapping.board_delete, method = RequestMethod.GET)
	public ModelAndView delete(HttpServletRequest req, ModelAndView mav) throws Exception {
		logger.info("Board delete: ok");

		int num = ServletRequestUtils.getIntParameter(req, "num");
		
		boardDAO.deleteBoard(num);
	
		List<BoardDTO> boardList = boardDAO.listboard();
		mav.addObject("list", boardList);
		mav.setViewName(R.path.board_home);
		return mav;
	}
	
	// ��۴ޱ�
	@RequestMapping(value = R.mapping.board_replyform, method = RequestMethod.GET)
	public ModelAndView replyform(HttpServletRequest req,ModelAndView mav) throws Exception {
		logger.info("Board replyform: ok");
		int num = ServletRequestUtils.getIntParameter(req, "num");


		List<BoardDTO> boardContent = boardDAO.getContent(num);

		mav.addObject("content", boardContent);
		mav.setViewName(R.path.board_replyform);
		return mav;
	}

}
