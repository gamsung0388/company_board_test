<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<script src="/webjars/jquery/3.6.0/jquery.min.js"></script>
<link href ="/webjars/bootstrap/4.6.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link href ="/static/css/login.css" rel="stylesheet">
<link rel="shortcut icon" href="/static/img/favicon.ico">
<link href="/static/css/common.css" rel="stylesheet">
<script src="/static/js/login/login.js"></script>
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
<%
	
%>
</head>
<body>
	<div>
		<form class="form-signin">
		  <img class="mb-4" src="/static/img/favicon.ico" alt="" width="72" height="72">
		  <h1 class="h3 mb-3 font-weight-normal">로그인</h1>
		  <label for="inputEmail" class="sr-only">Email address</label>
		  <input type="email" id="loginId" class="form-control" placeholder="Email address" required="" autofocus="">
		  <label for="inputPassword" class="sr-only">Password</label>
		  <input type="password" id="loginPw" class="form-control" placeholder="Password" required="">
		  <div class="checkbox mb-3">
		    <label>
		      <input type="checkbox" value="remember-me"> Remember me
		    </label>
		  </div>
		  <button class="btn btn-lg btn-primary btn-block" id="loginBtn" type="submit">Sign in</button>
		  <button class="btn btn-lg btn-primary btn-block" id="memberJoinBtn" type="submit">회원가입</button>
		  <p class="mt-5 mb-3 text-muted">© 2017-2019</p>
		</form>
		
		<div id="naver_id_login">
			
		</div>
	</div>
<jsp:include page="../fn.jsp" flush="false"></jsp:include>
