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
<link href="/static/css/commonui.css" rel="stylesheet">
<script src="/static/js/board/detail.js"></script>
<%
	
%>
</head>
<script>
</script>
<body>
	<jsp:include page="../menu.jsp" flush="false"></jsp:include>	
	<article>
		<div class="container" role="main" id="pageId" data-pageid="${pageId}">
			
			<div class="bg_white rounded shadow-sm">
				<div class="board_title"><c:out value="${boardDetail.board_title}"/></div>
				<div class="board_info_box">
					<span class="board_author">
						<c:out value="${boardDetail.board_num}"/>
						<c:out value="${boardDetail.user_name}"/>
						<c:out value="${boardDetail.board_date}"/>
					</span>
				</div>
				<div class="board_content"><c:out value="${boardDetail.board_txt}"/></div>
				<div class="board_tag">TAG : <c:out value="${boardDetail.board_tag}"/></div>
				
				<div style="margin-top:20px">
					<button id="boardUpdate" class="btn btn-sm btn-primary" value="${boardDetail.board_num}">수정</button>
					<button id="boardDelete" class="btn btn-sm btn-primary" value="${boardDetail.board_num}">삭제</button>
				</div>
			</div>	
		</div>	
		<div align="center">
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
	</article>	
</body>
</html>