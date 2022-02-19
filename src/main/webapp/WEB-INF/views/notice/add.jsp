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
	<h1>Notice add Page</h1>
	
	<form action="./add" method="post">
	Title : <input type="text" name="title">
	Contents: <textarea rows="0" cols="50" name="contents"></textarea>
	Writer : <input type="text" name="writer">
	RegDate : <input type="date" name="regdate">
	Hit : <input type="number" name="hit">
	
	<button type="submit">ADD</button>
	
	</form>
</body>
</html>