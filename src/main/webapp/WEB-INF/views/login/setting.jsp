<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
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
	<div>
		<h3>회원가입</h3>
		<p>아이디:<input type="text" id="userId" value="${memberDTO.user_id}" readonly="readonly"><button id="idChk">중복체크</button></p>
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
		<button id="memberJoinBtn">수정</button>
		<button id="cancleBtn">취소</button>
	</div>
</body>
</html>