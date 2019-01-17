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
import com.budong.model.dto.ReplyDTO;
import com.budong.model.interfaces.BoardDAO;

@Controller
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	private BoardDAO boardDAO;

	@Autowired
	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}
	
	
	// 글목록으로 이동
	@RequestMapping(value = R.mapping.board_home, method = RequestMethod.GET)
	public ModelAndView list(Locale locale, ModelAndView mav) {

		logger.info("board list: ok", locale);
		mav = new ModelAndView();

		List<BoardDTO> boardList = boardDAO.listboard();

		mav.addObject("list", boardList);
		mav.setViewName(R.path.board_home);
		return mav;
	}

	// 글 상세 보기
	@RequestMapping(value = R.mapping.board_content, method = RequestMethod.GET)
	public ModelAndView content(HttpServletRequest req, ModelAndView mav) throws Exception {

		logger.info("Board content: ok");

		int num = ServletRequestUtils.getIntParameter(req, "num");

		boardDAO.updateReadCnt(num);

		List<BoardDTO> boardContent = boardDAO.getContent(num);
		List<ReplyDTO> replyList = boardDAO.listreply(num);

		mav.addObject("content", boardContent);
		mav.addObject("replyList", replyList);
		mav.setViewName(R.path.board_content);
		return mav;

	}

	// 글 쓰기 폼 이동
	@RequestMapping(value = R.mapping.board_writeform, method = RequestMethod.GET)
	public String write() {

		logger.info("Board write: ok");

		return R.path.board_writeform;

	}

	// 글 입력
	@RequestMapping(value = R.mapping.board_insert, method = RequestMethod.POST)
	public ModelAndView insert(HttpServletRequest req, ModelAndView mav) throws Exception {
		logger.info("Board insert: ok");
		mav = new ModelAndView();

		BoardDTO dto = new BoardDTO();

		dto.setWriter(req.getParameter("writer"));
		dto.setTitle(req.getParameter("title"));
		dto.setContent(req.getParameter("content"));
		dto.setPwd(req.getParameter("pwd"));
		
		boardDAO.insertBoard(dto);

		List<BoardDTO> boardList = boardDAO.listboard();

		mav.addObject("list", boardList);
		mav.setViewName(R.path.board_home);
		return mav;
	}

	// 글 수정 폼 이동
	@RequestMapping(value = R.mapping.board_updateform, method = RequestMethod.GET)
	public ModelAndView updateform(HttpServletRequest req, ModelAndView mav) throws Exception {

		logger.info("Board updateform: ok");

		int num = ServletRequestUtils.getIntParameter(req, "num");
		logger.info("num : " + num);
		List<BoardDTO> boardContent = boardDAO.getContent(num);
//		List<BoardDTO> boardList = boardDAO.listboard();

		mav.addObject("content", boardContent);
		mav.setViewName(R.path.board_updateform);
		return mav; // 수정 폼으로 이동
	}

	// 글 수정
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
	
		return mav; // 게시글 수정 후 목록으로 이동
	}

	// 글 삭제
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
	
	// 댓글폼으로이동
	@RequestMapping(value = R.mapping.board_replyform, method = RequestMethod.GET)
	public ModelAndView replyform(HttpServletRequest req,ModelAndView mav) throws Exception {
		logger.info("Board replyform: ok");
		int num = ServletRequestUtils.getIntParameter(req, "num");


		List<BoardDTO> boardContent = boardDAO.getContent(num);
		List<ReplyDTO> replyList = boardDAO.listreply(num);
		mav.addObject("content", boardContent);
		mav.addObject("replyList", replyList);
		mav.setViewName(R.path.board_replyform);
		return mav;
	}
	
	// 댓글달기
	@RequestMapping(value = R.mapping.board_reply, method = RequestMethod.GET)
	public ModelAndView reply(HttpServletRequest req,ModelAndView mav) throws Exception {
		logger.info("Board reply: ok");
		int num = ServletRequestUtils.getIntParameter(req, "num");
		String replyvalue =req.getParameter("replyvalue");
		ReplyDTO dto = new ReplyDTO();

		//---------------------------번호체크
		int checkReply = boardDAO.checkReply(num);

		
		if(checkReply<=0) {
			dto.setReply_num(1);
		}else {
			dto.setReply_num(checkReply+1);
		}
		
		dto.setcontent_num(num);
		dto.setReply_content(replyvalue);
		boardDAO.insertReply(dto);
		
		List<BoardDTO> boardContent = boardDAO.getContent(num);
		List<ReplyDTO> replyList = boardDAO.listreply(num);
		mav.addObject("content", boardContent);
		mav.addObject("replyList", replyList);

		mav.setViewName(R.path.board_replyform);
		return mav;
	}

}