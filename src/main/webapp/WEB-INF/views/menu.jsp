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
			<h1>
				 게시판
			</h1>
			<ul class="main_menu">
				<li class="menu_lit"><a id="home" href="javascript:void(0);">홈</a></li>
				<li class="menu_lit"><a id="announcement" href="javascript:void(0);">공지사항</a></li>
				<li class="menu_lit"><a id="board" href="javascript:void(0);">게시글</a></li>
				<li class="menu_lit"><a id="event" href="javascript:void(0);">이벤트</a></li>
				<li class="menu_lit"><a id="question" href="javascript:void(0);">고객문의</a></li>
				<li class="menu_lit"><a id="api" href="javascript:void(0);">api</a></li>
				<li class="menu_lit"><a id="logout" href="javascript:void(0);">로그아웃</a></li>
				<li class="menu_lit"><a id="memberUpdate" href="javascript:void(0);">개인수정</a></li>
				<c:if test="${grade=='M'}">
					<li class="menu_lit"><a id="memberManage" href="javascript:void(0);">회원관리</a></li>
				</c:if>
<!-- 				<li class="menu_lit"><a href=""></a></li> -->
			</ul>
		</div>
		<div >
			
		</div>
	</div>
</body>
</html>	