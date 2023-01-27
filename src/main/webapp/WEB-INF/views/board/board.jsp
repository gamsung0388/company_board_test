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
		<div>
			<select id="searchVal" >
				<option value="title">제목</option>
				<option value="username">글쓴이</option>
			</select>
			<input id="searchtxt" type="text">
			<button id="searchBtn">검색</button>
		</div>
		<table class="table table-boarderless">
			<tr>
				<th scope="col">번호</th>
				<th scope="col">카테고리</th>
				<th scope="col">제목</th>
				<th scope="col">글쓴이</th>
				<th scope="col">조회수</th>
				<th scope="col">날짜</th>
			</tr>
			<c:forEach var="boardData"  items="${boardList}"> 
				<tr>
					<th scope="row" class="bnum"><c:out value="${boardData.board_num}"></c:out></th>
					<td class="bcate"><c:out value="${boardData.board_cgy_txt}"></c:out></td>
					<td class="btitle">
						<a class="boardDetailGo" data-bnum = "${boardData.board_num}">
							<c:out value="${boardData.board_title}"></c:out>
						</a>
					</td>
					<td>
						<c:out value="${boardData.user_name}"></c:out>
					</td>
					<td class="bcnt"><c:out value="${boardData.board_viewcnt}"></c:out></td>
					<td class="bdate"><c:out value="${boardData.board_date}"></c:out></td>
				</tr>
			</c:forEach>
		</table>
		<div>
			<c:if test="${pagination.existPrevPage==true}">
				<a class="pagecnt" data-cnt="${pagination.startPage-1}" href="javascript:void(0);">이전</a>
			</c:if>
			
			<c:forEach begin="${pagination.startPage}" end="${pagination.endPage}" var="i">
				<a class="pagecnt" data-cnt="${i}" href ="javascript:void(0);">${i}</a>
			</c:forEach>
			
			<c:if test="${pagination.existNextPage==true}">
				<a class="pagecnt" data-cnt="${pagination.endPage+1}" href="javascript:void(0);">다음</a>
			</c:if>
			
		</div>		
		<button id="boardInsert">등록</button>
	</div>
</body>
</html>