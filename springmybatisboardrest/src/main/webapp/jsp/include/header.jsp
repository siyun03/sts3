<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang='ko'>
<head>
<meta charset="UTF-8">
<title>MyBatis게시판</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@4.0.1/reset.min.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/board.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/dayjs/1.11.9/dayjs.min.js"></script>
<script defer src="${pageContext.request.contextPath}/js/member.js"></script>
<script defer src="${pageContext.request.contextPath}/js/board.js"></script>
<script defer src="${pageContext.request.contextPath}/js/article.js"></script>
<script defer src="${pageContext.request.contextPath}/js/reply.js"></script>
</head>
<body>
<div id="wrapper">
<header>
	<h1 class="badge rounded-pill text-bg-light text-center fs-2 mt-4 w-100">
		Spring MyBatis Rest Board
	</h1>
	<div id="loginArea">
		<c:if test="${empty sessionScope.ss_mid}">
		<form name="loginForm" action="/member/login" method="post">
			아이디 <input type="text" name="mid">&nbsp;
			비밀번호 <input type="password" name="mpass">&nbsp;
			<input type="submit" value="로그인" class="btn btn-primary">&nbsp;
			<input type="button" value="회원가입" onclick="location.href='/member/insertMemberForm';" class="btn btn-secondary">
		</form>
		</c:if>
		<c:if test="${!empty sessionScope.ss_mid}">
			${sessionScope.ss_mid}님 로그인 중!&nbsp;
			<input type="button" value="로그아웃" onclick="location.href='/member/logout';" class="btn btn-dark">
		</c:if>
	</div>
	<%@ include file="/jsp/include/nav.jsp" %>	
</header>