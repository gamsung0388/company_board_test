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
<script src="/static/js/board/detail.js"></script>
<%
	
%>
</head>
<script>
</script>
<body>
	<header>
		<a id="backPage" href="javascript:void(0);"><img src="/static/img/back.png" width="30px"></a>
	</header>
	<div>
		<table border="1">
			<tr>
				<th>번호</th>
				<td><c:out value="${boardDetail.board_num}"></c:out></td>
				<th>제목</th>
				<td><c:out value="${boardDetail.board_title}"></c:out></td>
				<th>게시자</th>
				<td><c:out value="${boardDetail.user_name}"></c:out></td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="5"><c:out value="${boardDetail.board_txt}"></c:out></td>			
			</tr>
			<tr>
				<th>태그</th>	
				<td colspan="5"><c:out value="${boardDetail.board_tag}"></c:out></td>		
			</tr>
			<tr>
				<th>날짜</th>	
				<td colspan="5"><c:out value="${boardDetail.board_date}"></c:out></td>
			</tr>
			<c:forEach var="fileList" items="${boardFilelist}"> 
				<tr>
					<td colspan="6">
						<c:out value="${fileList.ORIG_NM}"></c:out>
						<a href="/file-download/${fileList.FILE_ID}"><img src="/static/img/download.png" style="width:20px; height:auto; vertical-align: middle; cursor: pointer;"/></a>
					</td>
				</tr>
			</c:forEach>			
		</table>
		<div>
			
			<button id="boardUpdate" value="${boardDetail.board_num}">수정</button>
			<button id="boardDelete" value="${boardDetail.board_num}">삭제</button>
		</div>
		<div>
			
		</div>
	</div>
</body>
</html>