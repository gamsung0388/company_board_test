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
<script src="/static/js/main/menu.js"></script>
<%

String grade = (String)session.getAttribute("grade");

%>
</head>
<body>

	<div class="page_body" align="center">
		<div class="header_menu">
			<nav class="navbar navbar-expand-lg navbar-light bg-light">
			  <button class="navbar-toggler collapsed" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
			    <span class="navbar-toggler-icon"></span>
			  </button>
			  <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
			    <a class="navbar-brand" href="/">게시판</a>
			    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
			    
<!-- 					<li class="nav-item active"> -->
<!-- 				    	<a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a> -->
<!-- 				    </li> -->
<!-- 				    <li class="nav-item"> -->
<!-- 				    	<a class="nav-link" href="#">Link</a> -->
<!-- 				    </li> -->
<!-- 				    <li class="nav-item"> -->
<!-- 				    	<a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a> -->
<!-- 				    </li> -->
				      
			      	<li class="nav-item"><a class="nav-link" id="home" href="javascript:void(0);">홈</a></li>
					<li class="nav-item"><a class="nav-link" id="announcement" href="javascript:void(0);">공지사항</a></li>
					<li class="nav-item"><a class="nav-link" id="board" href="javascript:void(0);">게시글</a></li>
					<li class="nav-item"><a class="nav-link" id="event" href="javascript:void(0);">이벤트</a></li>
					<li class="nav-item"><a class="nav-link" id="question" href="javascript:void(0);">고객문의</a></li>
					<li class="nav-item"><a class="nav-link" id="api" href="javascript:void(0);">api</a></li>
					<li class="nav-item"><a class="nav-link" id="logout" href="javascript:void(0);">로그아웃</a></li>
					<li class="nav-item"><a class="nav-link" id="memberUpdate" href="javascript:void(0);">개인수정</a></li>
					<c:if test="${grade=='M'}">
						<li class="nav-item"><a class="nav-link" id="memberManage" href="javascript:void(0);">회원관리</a></li>
					</c:if>
			      
			    </ul>
			    
			  </div>
			</nav>
			
		</div>
		<div >
			
		</div>
	</div>
</body>
</html>	