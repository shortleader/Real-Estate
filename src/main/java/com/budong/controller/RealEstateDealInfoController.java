package com.budong.controller;

import java.io.UnsupportedEncodingException;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.budong.R;
import com.budong.util.DistrictCode;
import com.budong.util.DistrictCodeSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.budong.model.dto.RealEstateAPTDealInfoDTO;
import com.budong.service.interfaces.RealEstateDealInfoService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(R.controller.real_estate_deal_info)
public class RealEstateDealInfoController {
	private static final Logger log = LoggerFactory.getLogger(RealEstateDealInfoController.class);

	private final DistrictCodeSet districtCodeSet;
	private final RealEstateDealInfoService realEstateDealInfoService;
	
	@Autowired
	public RealEstateDealInfoController(DistrictCodeSet districtCodeSet, RealEstateDealInfoService realEstateDealInfoService) {
		this.districtCodeSet = districtCodeSet;
		this.realEstateDealInfoService = realEstateDealInfoService;
	}

	@RequestMapping(value="/")
	public String index(HttpServletRequest req) {
		log.info("path [/dealInfo/realState.do] status ok");
		return R.path.real_estate;
	}
	
	@RequestMapping(value= R.mapping.apartment_deal_info)
	public String listInfo(HttpServletRequest  req, HttpServletResponse resp,
			String str_dealYmd, String lawd_name) {	
		
		log.info("path [/dealInfo/apt_dealInfo.do] status ok");
		//Korean 처리
		try {
			req.setCharacterEncoding("utf-8");
			resp.setContentType("utf-8");
			log.info("encoding  : " + req.getCharacterEncoding());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		str_dealYmd = req.getParameter("deal_ymd");
		lawd_name = req.getParameter("lawd_name");
		
	/*	if(str_dealYmd == null) {
			return "";	//return errpage
		}
	*/	
		str_dealYmd = str_dealYmd.replaceAll("-", "");
		
		int deal_ymd = Integer.parseInt(str_dealYmd);
		//법정동  코드
		req.setAttribute("lawd_name", lawd_name);
		log.info("lawd_name : " + lawd_name);
		// 한글  -> code로  변환
		// 법정동  코드  db 접근해서  가져옴..
		String lawd_cd = realEstateDealInfoService.getLawdCode(lawd_name);
		// go service
		List<RealEstateAPTDealInfoDTO> v = realEstateDealInfoService.listAPTDeal(lawd_cd, deal_ymd);

		// page에  아파트  실거래가 정보  dto setAttribute
		req.setAttribute("list", v);
/*
		log.debug("deal_ymd = " + deal_ymd);
		log.debug("lawd_cd = " + lawd_cd);
		log.debug("v size : " + v.size());
*/
		return R.path.apartment_deal_info;
	}

	/** graph test section */
	@RequestMapping(R.mapping.graph_year_avg)
	public String goToTestGraphYear() {
		return R.path.graph_year;
	}

	@RequestMapping(R.mapping.graph_year_month_avg)
	public String goToTestGraphYearMonth() {
		return R.path.graph_year_month;
	}

	@RequestMapping(R.mapping.graph_year_districtCode_avg)
	public ModelAndView goToTestGraphYearDistrict() {
		List<DistrictCode> districtCodeList = new ArrayList<>(districtCodeSet);
		districtCodeList.sort(Comparator.comparing(DistrictCode::getDistrictName));

		Map<String, Object> parameters = new HashMap<>();
		parameters.put("districtCodeList",districtCodeList);

		return new ModelAndView(R.path.graph_year_districtCode_avg, parameters);
	}
}
	/* graph test section end*/