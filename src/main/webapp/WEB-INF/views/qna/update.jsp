<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>QNA update page</h1>
	
	<form action="./update" method="post">
	<input type="hidden" readonly name="num" value="${qna.num}">
	Title : <input type="text" name="title" value="${qna.title}">
	Contents : <textarea rows="0" cols="50" name="contents"></textarea>
	
	<button type="submit">ADD</button>
	</form>

</body>
</html>