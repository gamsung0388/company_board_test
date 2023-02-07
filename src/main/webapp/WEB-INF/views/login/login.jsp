<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<script src="/webjars/jquery/3.6.0/jquery.min.js"></script>
<link href ="/webjars/bootstrap/4.6.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link rel="shortcut icon" href="/static/img/favicon.ico">
<link href="/static/css/common.css" rel="stylesheet">
<script src="/static/js/login/login.js"></script>
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
<%
	
%>
</head>
<body>
<div>
	<h1>로그인</h1>
	<p>아이디 : <input type="text" id="loginId"></p>
	<p>비밀번호 : <input type="password" id="loginPw"></p>
	<button id="loginBtn">로그인</button>
	<button id="memberJoinBtn">회원가입</button>
	
	<div id="naver_id_login">
		
	</div>
</div>
<jsp:include page="../fn.jsp" flush="false"></jsp:include>
