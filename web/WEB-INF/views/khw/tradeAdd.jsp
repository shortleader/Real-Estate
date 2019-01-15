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
<title>여기 부동산 어떄</title>

<!-- Bootstrap core CSS -->
<link href="resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="resources/css/4-col-portfolio.css" rel="stylesheet">

    <style>
        table {
            border: 1px solid #000;
            border-collapse: collapse;
        }
        tbody {
            border-top: 1px solid #000;
            border-bottom: 1px solid #000;
        }

        table tr {
            border: 1px solid #969696;
        }
        table th {
            padding : 8px;  
            background-color: #C9DFF0;
            color: #585858;
        } 

         table td {
             padding : 8px; 
             margin-bottom: 2em;
         }
        input[type="text"] {
            width: 90%;  
            padding: 5px; 
            color : #A1A1A1; 
        }

        .td-btn-center {
            text-align: center; 
        }
        
        .frm-btn {
            padding: 10px; 
            border-radius: 3px; 
            margin-right: 10px;
            width: 80px;
            color:white;
            border: 0;
            font-size: 1em;
        }

        input[type="submit"] { 
            background-color: #2A8A85;
        }

        input[type="reset"] {
            background-color: #F47E7E;

        }
        .trade-container{
        	padding:20px;
        }
    </style>

</head>
<body>

<c:import url="../top.jsp"></c:import>

	<div align="center" class="trade-container">
        <form name="f" action="tradeAdd.do" method="post" enctype="multipart/form-data">
            <table id="tradeTable">
                <tr>
                    <th>매물유형</th>
                    <td colspan="2"><input type="text" name="type"></td>
                </tr>
                <tr>
                    <th>거래형태</th>
                    <td colspan="2"><input type="text" name="trade_type"></td>
                </tr>
                <tr>
                    <th>지역</th>
                    <td colspan="2"><input type="text" name="location"></td>
                </tr>
                <tr>
                    <th>면적</th>
                    <td colspan="2"><input type="text" name="area"></td>
                </tr>
                <tr>
                    <th>해당 동/호 수</th>
                    <td><input type="text" name="dong"></td>
                    <td><input type="text" name="ho"></td>
                </tr>
                <tr>
                    <th>해당 층/총 층</th>
                    <td><input type="text" name="level"></td>
                    <td><input type="text" name="max_level"></td>
                </tr>
                <tr>
                    <th>희망 매매가</th>
                    <td colspan="2"><input type="text" name="price"></td>
                </tr>
                <tr>
                    <th>사진</th>
                    <td colspan="2"><input type="file" name="image"></td>
                </tr>
                <tr>
                    <th>연락처</th>
                    <td colspan="2"><input type="text" name="phone"></td>
                </tr>
                <tr>
                    <td colspan="3" class="td-btn-center">
                        <input type="submit" value="등록" class="frm-btn">
                        <input type="reset" value="취소" class="frm-btn">
                    </td>
                </tr>
            </table>
        </form>

    </div>

	
	
<c:import url="../bottom.jsp"></c:import>

</body>

</html>