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
  
  <script type="text/javascript">
 
  </script>
</head>
<body>

<div style="padding:5px;">
	<h3>북마크 목록</h3>
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
	
	
	<table>
		<tr>
			<th>ID</th>
			<th>북마크 이름</th>
			<th>와이파이명</th>
			<th>등록일자</th>
			<th>비고</th>
		</tr>
		
		<c:if test="${empty favlist}">
			<tr>
				<td colspan="6" style="text-align: center;">
				정보가 존재하지 않습니다.
				</td>
			</tr>
		</c:if>
		
		
		<c:forEach var="favbkmk" items="${favlist}">
            <tr>
            	<td><c:out value="${favbkmk.favidx}"/></td>
                <td><c:out value="${favbkmk.favBkNm}"/></td>
                <td><c:out value="${favbkmk.favWifiNm}"/></td>
                <td><c:out value="${favbkmk.favAplDate}"/></td>
                <td style="text-align: center;">
                	<a href='/controller/goFavBkDel/${favbkmk.favidx}' style="text-decoration: underline;">삭제</a>
                </td>
            </tr>
        </c:forEach>
		
		
	</table>
		

</div>

</body>
</html>