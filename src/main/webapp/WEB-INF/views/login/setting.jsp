<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.security.SecureRandom" %>
<%@ page import="java.math.BigInteger" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
<script src="/webjars/jquery/3.6.0/jquery.min.js"></script>
<link href ="/webjars/bootstrap/4.6.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link rel="shortcut icon" href="/static/img/favicon.ico">
<link href="/static/css/common.css" rel="stylesheet">
<script src="/static/js/login/setting.js"></script>
</head>
<body>
	<jsp:include page="../menu.jsp" flush="false"></jsp:include>	
	<div>
		<p style="font-size: 25px">개인 정보 변경</p>
		<div style="border: 3px solid gold">
			<p>아이디:<input type="text" id="userId" value="${memberDTO.user_id}" readonly="readonly"></p>
			<p>비밀번호:<input type="text" id="userPw" value="${memberDTO.user_pw}"></p>
			<p>이름:<input type="text" id="userName" value="${memberDTO.user_name}"></p>
			<p>나이:<input type="text" id="userAge" value="${memberDTO.user_age}"></p>
			<p>등급:
				<c:if test="${memberDTO.grade=='M'}">
					<input type="radio" name="userGrade" value="M" checked="checked">어드민
					<input type="radio" name="userGrade" value="U">사용자
				</c:if>
				<c:if test="${memberDTO.grade=='U'}">
					<input type="radio" name="userGrade" value="M">어드민
					<input type="radio" name="userGrade" value="U" checked="checked">사용자
				</c:if>
			</p>
		</div>		 		 
		<button id="memberJoinBtn">수정</button>
		<button id="cancleBtn">취소</button>
	</div>
</body>
</html>