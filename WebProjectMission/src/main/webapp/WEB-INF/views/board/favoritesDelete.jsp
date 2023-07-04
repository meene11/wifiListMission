<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>   


<!DOCTYPE html>
<html lang="en">
<head>
  <title>와이파이 정보구하기</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <style>
	table {
	  font-family: arial, sans-serif;
	  border-collapse: collapse;
	  font-size: 10px;
	  width: 100%;
	}
	
	td {
	  border: 1px solid #dddddd;
	  text-align: left;
	  padding: 8px;
	}
	
	tr:nth-child(even) {
	  background-color: #eaeaea;
	}
	
	th {
		background-color: #00AB6F;
		border: 1px solid #fff;
    	color: #fff;
    	text-align: center;
    	padding: 8px;
	}
	
	.grpBtn {
	    margin-top: 10px;
    	margin-bottom: 10px;
	}
  </style>
  
</head>
<body>
	<script type = "text/javascript">
    	var message = "${msg}";
    	var url = "${url}";
        
        if(message != null && message != ""){
        	 alert(message);
        	 location.href = url;
             
        } 
        
    </script>

<div style="padding:5px;">
	<h3>북마크 삭제</h3>
	<div>
		<button type="button" class="btn btn-link" style="padding-left:0;" onclick="location.href='/controller/home.do'">홈</button>
		<span>|</span>
		<button type="button" class="btn btn-link">위치 히스토리 목록</button>
		<span>|</span>
		<button type="button" class="btn btn-link" onclick="location.href='/controller/wifiSave'">Open API 와이파이 정보 가져오기</button>
		<span>|</span>
		<button type="button" class="btn btn-link" onclick="location.href='/controller/favoritesList'">북마크 보기</button>
		<span>|</span>
		<button type="button" class="btn btn-link" onclick="location.href='/controller/bookmarkGroup'">북마크 그룹 관리</button>
	</div>
	
	<div>
		<p>
			북마크를 삭제하시겠습니까?
		</p>
	</div>
	
	<form name="formdel" id="form2del" action="/controller/favBkmkDelete" >
		
		
		<table>
			<tr>
				<th>북마크 이름</th>
				<td style="text-aling:left;">
					${favDetail.favBkNm}
				</td>
			</tr>
			<tr>
				<th>와이파이명</th>
				<td style="text-align:left;">
					${favDetail.favWifiNm}
				</td>
			</tr>
			<tr>
				<th>등록일자</th>
				<td style="text-align:left;">
					${favDetail.favAplDate}
				</td>
			</tr>
			
			<tr style="display:none;">
				<td>
					<input type="text" id="favidx" name="favidx" value="${favDetail.favidx}">
				</td>
			</tr>
		
			<tr style="text-align:center;">
				<td colspan="2" style="text-align:center;">
					<a href='/controller/addBookmark' style="text-decoration:underline;">돌아가기</a>
					<span>	|	</span>
					<button type="submit">삭제</button>
				</td>
			</tr>		
		</table>
	</form>	

</div>

</body>
</html>