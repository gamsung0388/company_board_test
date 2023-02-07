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
<script src="/static/js/board/board.js"></script>
<%

String grade = (String)session.getAttribute("grade");

%>
</head>
<body>
	<jsp:include page="../menu.jsp" flush="false"></jsp:include>

</body>
</html>