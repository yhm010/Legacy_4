<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${board} Reply Page</h1>
	<form action="./reply" method="post">
	<input type="hidden" value="${dto.num}" name="num">	
	Title : <input type="text" name="title">
	Contents: <textarea rows="0" cols="50" name="contents"></textarea>
	Writer : <input type="text" name="writer">
	
	<button type="submit">Reply</button>
	
	</form>
</body>
</html>