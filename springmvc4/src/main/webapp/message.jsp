<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>message</title>
</head>
<body>
이름 : <spring:message code="name" />
나이 : <spring:message code="age" />
</body>
</html>