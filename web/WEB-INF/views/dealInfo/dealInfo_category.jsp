<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<head>
	<meta charset="utf-8">
</head>

<!-- dealInfo_category.jsp
	APTDealList.jsp 상단에 붙을 카테고리 페이지
	월별 시세분석만 하기로 결정 -->
<ul class="ul_cate">
	<li class="li_cate"><a class="a_cate" href="<%=request.getContextPath() %>/dealInfo/">실거래가</a></li>
	<li class="li_cate"><a class="a_cate" href="graph/year">월별 시세분석</a></li>
	<!-- <li class="li_cate"><a class="a_cate" href="graph/yearMonth">연별 시세분석</a></li> -->
	<li class="li_cate"><a class="a_cate" href="graph/yearDistrictCode">지역별 시세분석</a></li>
</ul>