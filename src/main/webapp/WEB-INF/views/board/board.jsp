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
<script src="/static/js/board/board.js"></script>
<%
	
%>
</head>
<body>
	<jsp:include page="../menu.jsp" flush="false"></jsp:include>	
	<div>
		<table>
				<tr>
					<th>번호</th>
					<th>카테고리</th>
					<th>제목</th>
					<th>조회수<th>
					<th>날짜</th>
				</tr>
  				<c:forEach var="boardData"  items="${boardList}"> 
					<tr>
						<td class="bnum"><c:out value="${boardData.board_num}"></c:out></td>
						<td class="bcate"><c:out value="${boardData.board_cgy_txt}"></c:out></td>
						<td class="btitle"><button name="boardDetailGo" data-bnum = "${boardData.board_num}"><c:out value="${boardData.board_title}"></c:out></button></td>
						<td class="bcnt"><c:out value="${boardData.board_viewcnt}"></c:out></td>
						<td class="bdate"><c:out value="${boardData.board_date}"></c:out></td>
					</tr>
				</c:forEach>
		</table>
		<button id="boardInsert">등록</button>
	</div>
</body>
</html>