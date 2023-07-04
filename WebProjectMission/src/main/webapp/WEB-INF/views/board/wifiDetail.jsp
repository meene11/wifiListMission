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
  
  <script type="text/javascript">
  function changeFn(){
		var grp  = document.getElementById("grp");
		var value = (grp.options[grp.selectedIndex].value);
		$('input[name=inPutbookmarkNm]').attr('value', value);
	}; 
  </script>
</head>
<body>

<div style="padding:5px;">
	<h3>위치 히스토리 목록 기능 화면</h3>
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
	
	
	<div style="margin-bottom:5px;">
		<form action="/controller/addBookmark">
			<input type="hidden" id="mgrNo" name="mgrNo" value="${wifiVo.mgrNo}">
			<input type="hidden" id="mainNm" name="mainNm" value="${wifiVo.mainNm}">
		  <select name="grp" id="grp" onchange="changeFn()">
		  	<option label="북마크 그룹 이름 선택" ></option>
		  	<c:forEach var="grpList" items="${bkmkGrpList}">
		    	<option value="${grpList.bookmarkNm}" name="bookmarkNm" id="bookmarkNm">${grpList.bookmarkNm}</option>
		  	</c:forEach>
		  </select>
		  <input type="hidden" id="inPutbookmarkNm" name="inPutbookmarkNm" value="">
		<button type="submit">북마크 추가하기</button>
		</form>
		

	</div>
	
	<table style="width:50%">
		<tr>
			<th>거리(km)</th>
			<td>${wifiVo.distance}</td>
		</tr>
		<tr>
			<th>관리번호</th>
			<td>${wifiVo.mgrNo}</td>
		</tr>
		<tr>
			<th>자치구</th>
			<td>${wifiVo.wrdOfc}</td>
		</tr>
		<tr>
			<th>와이파이명</th>
			<td><a href='/controller/wifiDetail/${wifiVo.mgrNo}'>${wifiVo.mainNm}</a></td>
		</tr>
		<tr>
			<th>도로명주소</th>
			<td>${wifiVo.adres1}</td>
		</tr>
		<tr>
			<th>상세주소</th>
			<td>${wifiVo.adres2}</td>
		</tr>
		<tr>
			<th>설치위치(층)</th>
			<td>${wifiVo.instlFloor}</td>
		</tr>
		<tr>
			<th>설치유형</th>
			<td>${wifiVo.instlTy}</td>
		</tr>
		<tr>
			<th>설치기관</th>
			<td>${wifiVo.instlMby}</td>
		</tr>
		<tr>
			<th>서비스구분</th>
			<td>${wifiVo.svcSe}</td>
		</tr>
		<tr>
			<th>망종류</th>
			<td>${wifiVo.cmcwr}</td>
		</tr>
		<tr>
			<th>설치년도</th>
			<td>${wifiVo.cnstcYear}</td>
		</tr>
		<tr>
			<th>실내외구분</th>
			<td>${wifiVo.inoutDoor}</td>
		</tr>
		<tr>
			<th>WIFI접속환경</th>
			<td>${wifiVo.remars3}</td>
		</tr>
		<tr>
			<th>X좌표</th>
			<td>${wifiVo.lnt}</td>
			
		</tr>
		<tr>
			<th>Y좌표</th>
			<td>${wifiVo.lat}</td>
		</tr>
		<tr>
			<th>작업일자</th>
			<td>${wifiVo.workDttm}</td>
		</tr>
		
	</table>
		

</div>

</body>
</html>