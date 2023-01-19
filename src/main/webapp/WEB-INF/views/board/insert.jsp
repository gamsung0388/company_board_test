<%@page import="com.test.dev.board.dto.BoardDTO"%>
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
<script src="/static/js/board/insert.js"></script>
<%
%>
</head>
<body>
	<header>
		<a id="backPage" href="javascript:void(0);"><img src="/static/img/back.png" width="30px"></a>
		<h2 id="title"></h2>
	</header>
	<div>
		<p> 카테고리: 
			<select name="board_cgy_num">
				<c:forEach items="${selectCt}" var="categoryData">
					<option value="${categoryData.board_cgy_num}">${categoryData.board_cgy_txt}</option>
				</c:forEach>							
			</select>
		</p>
					
		<c:choose>
			<%-- 수정 --%>
			<c:when test="${boardDetail!=null}">
				<p> 제목: <input type="text" id="board_title" name="board_title" value="${boardDetail.board_title}"></p>
				<p> 내용: <textarea id="board_txt" name="board_txt" cols="22px" rows="5px">${boardDetail.board_txt}</textarea></p>
				<p> 태그: <input type="text" id="board_tag" name="board_tag" value="${boardDetail.board_tag}"></p>
				<button id="board_file">파일등록</button>
				
			</c:when>
			<%-- 등록 --%>
			<c:otherwise>
				<p> 제목: <input type="text" id="board_title" name="board_title" ></p>
				<p> 내용: <textarea id="board_txt" name="board_txt" cols="22px" rows="5px"></textarea></p>
				<p> 태그: <input type="text" id="board_tag" name="board_tag" ></p>
				<button id="board_file">파일등록</button>
			</c:otherwise>
		</c:choose>				
		<input type="hidden" id="board_num" value="${boardDetail.board_num}"></input>
		
		<form id="fileForm" name="fileForm">	
			<input type="file" id="input_file" multiple="multiple" hidden>	
			<div id="data_file_txt">
				<span>첨부 파일</span>
				<br>
				<div id="articleFileChange">
					<c:if test="${boardFilelist!=null}">
						<c:forEach var="fileData" items="${boardFilelist}">
							<div name="files" data-file="${fileData.FILE_ID}">
					       		<font style="font-size:12px">${fileData.ORIG_NM}</font>
					       		<img name="before_file_delete" src="/static/img/delete.png" style="width:20px; height:auto; vertical-align: middle; cursor: pointer;"/>
				       		</div>
						</c:forEach>
					</c:if>
				</div>
			</div>		
		</form>
	</div>
	<div>
		<c:if test="${boardtype=='insert'}">
			<button id="insert" data-btype ="${boardtype}">등록</button>
		</c:if>
		
		<c:if test="${boardtype=='update'}">
			<button id="insert" data-btype ="${boardtype}">수정</button>
		</c:if>				
		
	
		<button id="cancel">취소</button>
	</div>
	
</body>
</html>