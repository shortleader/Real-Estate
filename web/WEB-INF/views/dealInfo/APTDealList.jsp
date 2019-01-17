<%@ page import="com.budong.R" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon" href="<%=request.getContextPath()%>/resources/icon/main.ico">
<title>부동산 여기어때 | ${lawd_name} 거래내역</title>

<!-- Bootstrap core CSS -->
<link href="resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="resources/css/4-col-portfolio.css" rel="stylesheet">

	<!-- APTDealInfoList.jsp CSS -->
	<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/dealInfo/more_list.js'/>"></script>
	<link type="text/css" rel="stylesheet" href="<c:url value='/resources/css/dealInfo/list_item.css'/>" media="screen" />
	
	<script type="text/javascript" src="<c:url value='/resources/js/dealInfo/raphael_min.js'/>"></script>
	<script src="<c:url value='/resources/js/dealInfo/seoul-local.js'/>" type="text/javascript" charset="UTF-8"></script>
	<link type="text/css" rel="stylesheet" href="<c:url value='/resources/css/dealInfo/local.css'/>" />
</head>
<body>

	<%-- <c:import url="<%=request.getContextPath() %>/top.jsp"></c:import> --%>
	<!-- nav -->
		<div class="contents" align="center">
		<!-- 카테고리  나타내기 -->
		<%@ include file="dealInfo_category.jsp" %>
		<!-- end 카테고리   -->
	
		<form name="f" method="post" action="apt_dealInfo.do">
				
			<div class="mapArea">
			    <div id="locName"></div>
			    <div id="paper"></div>
			</div>
			
			<br><br>
						
			<input type="text" class="txt_tag" name="lawd_name" value="${lawd_name}">			
			<br/>
			<input type="month" class="month_tag" name="deal_ymd" value="2019-01">	<br/>
			
			<input type="submit" value="ok">
				
		</form>
		<div id="js-load" class="main">
			<ul class="lists">
				<c:choose>
					<c:when test="${!empty list}">
						<c:forEach var="item" items="${list}" varStatus="status">
							<!-- item list 뿌리기 -->
							<li class="lists__item js-load">
								<table border="0" class="table_trade">
									<tr class="tr_items m1">
										<td width="100">
											<span>${item.apartment }</span><br>
										</td>
										
										<td rowspan="2" width="70">
											<em class="em_item1"> 
												<span class="span_circle m1">거래일<br>
												${item.year}.${item.month}.${item.day }.
												</span>
											</em>
										</td>
										
										<td>
											<strong>건축년일</strong> ${item.build_year }년  
										</td>

										<td>
											<strong>Info</strong> ${item.exclusive_area}㎡  ${item.layer}층
										</td>
									</tr>

									<tr class="tr_items m2">
										<td>
											<em	class="em_item2"> <span class="span_circle m2">거래가</span>
												${item.transaction_amount}만
											</em>
										</td>
										<td>서울시 ${lawd_name} ${item.legal_dong}<br></td>
									</tr>
								</table>
							</li>
							<%-- <li class="lists__item js-load">
								<table border="1">
									<tr>
										<td>${status.count }</td>
										<td>${item.build_year }</td>
										<td>${item.year }</td>
										<td>${item.legal_dong }</td>
										<td>${item.apartment }</td>
										<td>${item.month }</td>
										<td>${item.day }</td>
										<td>${item.exclusive_area }</td>
										<td>${item.area_code}</td>
										<td>${item.layer }</td>
										<td>${item.transaction_amount }</td>
									</tr>
								</table>							
							</li> --%>
						</c:forEach>
					</c:when>
					<%-- 가져온 값이 없을때  --%> 
					<c:otherwise>
						<p>정보가  없습니다...</p>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
			
		<!-- 더보기 버튼 -->	
		<br>
   		<div id="js-btn-wrap" class="btn-wrap"> <a href="javascript:;" class="button">더보기</a> </div>
	</div>
	
<%-- 	<c:import url="<%=request.getContextPath() %>bottom.jsp"></c:import> --%>


	<!-- Bootstrap core JavaScript -->
	<script src="resources/vendor/jquery/jquery.min.js"></script>
	<script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="resources/js/news.js"></script>

</body>
</html>