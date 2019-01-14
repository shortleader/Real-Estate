<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
	<script type="text/javascript"    src="<c:url value='/resources/js/dealInfo/more_list.js'/>"></script>
	<link type="text/css" rel="stylesheet" href="<c:url value='/resources/css/dealInfo/list_item.css'/>" media="screen" />
	
	<script type="text/javascript" src="<c:url value='/resources/js/dealInfo/raphael_min.js'/>"></script>
	<script src="<c:url value='/resources/js/dealInfo/seoul-local.js'/>" type="text/javascript" charset="UTF-8"></script>
	<link type="text/css" rel="stylesheet" href="<c:url value='/resources/css/dealInfo/local.css'/>" />	
<meta charset="EUC-KR">
<title>부동산 여기어때 | ${lawd_name} 거래내역</title>
</head>
<body>
	<div class="contents" align="center">
		<form name="f" method="post" action="apt_dealInfo.do">
				
			<div class="mapArea">
			    <div id="locName"></div>
			    <div id="paper"></div>
			</div>
			
			<br><br>
						
			지역  : <input type="text" name="lawd_name" value="금천구" >
			
			<br/>
			기간  : <input type="month" name="deal_ymd">	<br/>
			
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
										<td width="150" rowspan="2">
											<span>${item.apartment }</span><br>
											<em	class="em_item2"> <span class="span_circle m2">거래가</span>
												${item.transaction_amount }만
											</em>
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
	
		<br>
		<a href="realEstate.do">돌아가기</a>
		<br>
	</div>
</body>
</html>