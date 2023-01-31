<%@page import="com.test.dev.board.dto.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리</title>
<script src="/webjars/jquery/3.6.0/jquery.min.js"></script>
<link href ="/webjars/bootstrap/4.6.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link rel="shortcut icon" href="/static/img/favicon.ico">
<link href="/static/css/common.css" rel="stylesheet">
<script src="/static/js/member/memberManage.js"></script>
<%
%>
</head>
<body>
	<jsp:include page="../menu.jsp" flush="false"></jsp:include>	
	<hr>
	<div>
		<table class="table table-boarderless">
			<tr>
				<th scope="col">유저 아이디</th>
				<th scope="col">유저 이름</th>
				<th scope="col">유저 나이</th>
				<th scope="col">게시글 수</th>
				<th scope="col">댓글 수</th>
				<th scope="col">등급</th>
			</tr>
			<c:forEach items="${memberList}" var="memberData">
				<tr>
					<td scope="row"><a href="/memberSetting?userId=${memberData.user_id}">${memberData.user_id}</a></td>
					<td><a href="/memberSetting?userId=${memberData.user_id}">${memberData.user_name}</a></td>
					<td>${memberData.user_age}</td>
					<td>${memberData.board_cnt}</td>
					<td>${memberData.comment_cnt}</td>
					<td>${memberData.grade}</td>
				</tr>
			</c:forEach>
			
		</table>
	</div>
</body>
</html>