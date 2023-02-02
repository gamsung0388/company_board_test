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
	<jsp:include page="../menu.jsp" flush="false"></jsp:include>	
	<div>
		<table border="1" >
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
			<input type="text" id="comment_add_value"><button id="comment_add">등록</button>
			<input type="hidden" id="bnum" value="${boardDetail.board_num}">
			<div id="comment_html">
				<c:if test="${commentList!=null}">
					<c:forEach items="${commentList}" var="commentData">
<%-- 						${commentData} --%>
						<div class ="comment" style="border:2px solid; padding:10px" data-commentnum="${commentData.coment_num}" data-commentclass = "${commentData.comment_class}" data-commentorder = "${commentData.comment_order}">
							<b>${commentData.user_name}</b>
							<button class = "comment_delete">삭제</button>
							<button class = "comment_answer_div">답글</button>
							<div>
								${commentData.comment_txt}
							</div>							
							<c:forEach items="${commentData.answerList}" var="answerData">
								<div data-commentnum="${answerData.coment_num}" data-commentclass = "${answerData.comment_class}" data-commentorder = "${answerData.comment_order}">
									<img src="/static/img/turn.png" style="width: 20px;">
									<b>${answerData.user_name}</b>
									<button class = "comment_delete">삭제</button>
									<button class = "comment_answer_div">답글</button>
									<div>
										${answerData.comment_txt}
									</div>
								</div>
							</c:forEach>
						</div>
					</c:forEach>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>