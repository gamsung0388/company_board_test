<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<script src="/webjars/jquery/3.6.0/jquery.min.js"></script>
<script src="/static/js/jquery-ui.min.js"></script>
<link href= "stylesheet" href="/static/css/jquery-ui.css" type="text/css">
<link href ="/webjars/bootstrap/4.6.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link rel="shortcut icon" href="/static/img/favicon.ico">
<link href="/static/css/common.css" rel="stylesheet">
<script src="/static/js/board/announcement.js"></script>
<%

	String grade = (String)session.getAttribute("grade");

%>
</head>
<body>
	<jsp:include page="../menu.jsp" flush="false"></jsp:include>	
	<table class="table table-boarderless">
			<thead>
				<tr>
					<th><input type="checkbox" id="allChk"></th>
					<th scope="col">번호</th>
					<th scope="col">카테고리</th>
					<th scope="col">제목</th>
					<th scope="col">글쓴이</th>
					<th scope="col">조회수</th>
					<th scope="col">날짜</th>
				</tr>
			</thead>
			<tbody id="boardHtml">
			</tbody>
		</table>
		<div id="pageHtml" align="center">
			
		</div>		
		
		<div align="center">
			<select id="searchType">
				<option value="username">글쓴이</option>
				<option value="title">제목</option>
			</select>
			<input type="text" id="searchtxt" value=""><button id="searchBtn">검색</button>
		</div>
		<c:if test="${grade=='M'}">
			<div align="right">
				<button id="boardInsert">등록</button>
				<button id="boardDelete">삭제</button>
			</div>
		</c:if>
</body>
</html>