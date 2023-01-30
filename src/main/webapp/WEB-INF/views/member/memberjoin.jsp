<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/webjars/jquery/3.6.0/jquery.min.js"></script>
<link href ="/webjars/bootstrap/4.6.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link rel="shortcut icon" href="/static/img/favicon.ico">
<link href="/static/css/common.css" rel="stylesheet">
<script src="/static/js/member/memberjoin.js"></script>
</head>
<body>
	<div>
		<h3>회원가입</h3>
		<p>아이디:<input type="text" id="userId"><button id="idChk">중복체크</button></p>
		<p>비밀번호:<input type="text" id="userPw"></p>
		<p>이름:<input type="text" id="userName"></p>
		<p>나이:<input type="text" id="userAge"></p>
		<p>등급:
			<input type="radio" name="userGrade" value="M">어드민
			<input type="radio" name="userGrade" value="U" checked="checked">사용자
		</p>
		<button id="memberJoinBtn">등록</button>
		<button id="cancleBtn">취소</button>
	</div>
</body>
</html>