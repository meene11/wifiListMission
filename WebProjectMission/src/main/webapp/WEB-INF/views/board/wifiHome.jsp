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
	  width: 100%;
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
  function myPosition(){
	  if (navigator.geolocation) {
          //위치 정보를 정기적으로 얻기
          var id = navigator.geolocation.watchPosition(
                  function(pos) {
                      //$('#xLntWi').html(pos.coords.latitude);     // 위도 
                      //$('#yLatGyeong').html(pos.coords.longitude); // 경도 
                      
                      $('input[name=xLntWi]').attr('value',pos.coords.latitude);
                      $('input[name=yLatGyeong]').attr('value',pos.coords.longitude);
          			  //감시를 중지
			          navigator.geolocation.clearWatch(id);
                  });
          
      } else {
          alert("이 브라우저에서는 Geolocation이 지원되지 않습니다.")
      }
  }
  
  </script>
</head>
<body>

<div style="padding:5px;">
	<h3>와이파이 정보 구하기</h3>
	<div>
		<button type="button" class="btn btn-link" style="padding-left:0;">홈</button>
		<span>|</span>
		<button type="button" class="btn btn-link" onclick="location.href='/controller/getHisList'">위치 히스토리 목록</button>
		<span>|</span>
		<button type="button" class="btn btn-link" onclick="location.href='/controller/wifiSave'">Open API 와이파이 정보 가져오기</button>
		<span>|</span>
		<button type="button" class="btn btn-link" onclick="location.href='/controller/favoritesList'">북마크 보기</button>
		<span>|</span>
		<button type="button" class="btn btn-link" onclick="location.href='/controller/bookmarkGroup'">북마크 그룹 관리</button>
	</div>
	
	<div class="grpBtn">
		<form name="form1" id="form1" action="/controller/getNearbyWifi.do" >
			<label for="yLatGyeong">LAT:</label>
			<input type="text" id="yLatGyeong" name="yLatGyeong" value="0.0">,
			<label for="xLntWi">LNT:</label>
			<input type="text" id="xLntWi" name="xLntWi" value="0.0">
			<input type="button" value="내 위치 가져오기" onclick="myPosition()">
			<input type="submit" value="근처 WIFI 정보보기">
			
		</form>
	</div>
	
	<table>
		<tr>
			<th>거리(km)</th>
			<th>관리번호</th>
			<th>자치구</th>
			<th>와이파이명</th>
			<th>도로명주소</th>
			<th>상세주소</th>
			<th>설치위치(층)</th>
			<th>설치유형</th>
			<th>설치기관</th>
			<th>서비스구분</th>
			<th>망종류</th>
			<th>설치년도</th>
			<th>실내외구분</th>
			<th>WIFI접속환경</th>
			<th>X좌표</th>
			<th>Y좌표</th>
			<th>작업일자</th>
		</tr>
		<c:if test="${empty list}">
			<tr>
				<td colspan="17" style="text-align: center;">
				위치 정보를 입력한 후에 조회해 주세요.
				</td>
			</tr>
		</c:if>
		
		<c:forEach var="wfInfo" items="${list}">
            <tr>
            	<td><c:out value="${wfInfo.distance2}"/></td>
                <td><c:out value="${wfInfo.mgrNo}"/></td>
                <td><c:out value="${wfInfo.wrdOfc}"/></td>
                <td><a href='/controller/wifiDetail/${wfInfo.mgrNo}'><c:out value="${wfInfo.mainNm}"/></a></td>
                <td><c:out value="${wfInfo.adres1}"/></td>
                <td><c:out value="${wfInfo.adres2}"/></td>
                <td><c:out value="${wfInfo.instlFloor}"/></td>
                <td><c:out value="${wfInfo.instlTy}"/></td>
                <td><c:out value="${wfInfo.instlMby}"/></td>
                <td><c:out value="${wfInfo.svcSe}"/></td>
                <td><c:out value="${wfInfo.cmcwr}"/></td>
                <td><c:out value="${wfInfo.cnstcYear}"/></td>
                <td><c:out value="${wfInfo.inoutDoor}"/></td>
                <td><c:out value="${wfInfo.remars3}"/></td>
                <td><c:out value="${wfInfo.lat}"/></td>
                <td><c:out value="${wfInfo.lnt}"/></td>
                <td><c:out value="${wfInfo.workDttm}"/></td>
            </tr>
        </c:forEach>
        
		

</div>

</body>
</html>