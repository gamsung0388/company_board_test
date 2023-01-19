<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../head.jsp" flush="false"><jsp:param name="pageid" value="login" /></jsp:include>
<h1>로그인</h1>
<div>
	<p>아이디 : <input type="text" id="userid"></p>
	<p>비밀번호 : <input type="password" id="userpw"></p>
	<button id="loginBtn">로그인</button>
</div>

<jsp:include page="../fn.jsp" flush="false"></jsp:include>
