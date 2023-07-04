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
  
  
 
</head>
<body>

<div style="text-align:center;">
	<h3> ${cnt}개의 WIFI 정보를 정상적으로 저장하였습니다.</h3>
	
	<button type="button" class="btn btn-link" onclick="location.href='/controller/home.do'">홈으로가기</button>

</div>

</body>
</html>