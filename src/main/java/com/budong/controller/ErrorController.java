package com.budong.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.budong.R;

@Controller
@RequestMapping(R.controller.err)
public class ErrorController {
	private static final Logger log = LoggerFactory.getLogger(ErrorController.class);

	@RequestMapping(R.mapping.err_err_default)
	public String errDeault(HttpServletRequest req) {	
		log.info("err_default page OK");
		return R.path.err_default;
	}
	
	@RequestMapping(R.mapping.err_err404)
	public String err404(HttpServletRequest req, HttpServletResponse resp) {
		resp.setStatus(HttpServletResponse.SC_OK);
		log.info("err_404 page OK");

		return R.path.err404;
	}
	
	@RequestMapping(R.mapping.err_err500)
	public String err500(HttpServletResponse resp) {
		resp.setStatus(HttpServletResponse.SC_OK);
		log.info("err_500 page OK");

		return R.path.err500;
	}
}
