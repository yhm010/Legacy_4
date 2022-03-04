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
	Title : <input type="text" id="title" name="title">
	Writer : <input type="text" id="writer" name="writer">
	Contents: <textarea rows="0" cols="50" name="contents"></textarea>
	
	
	<button type="button" id="but">ADD</button>
	
	</form>
	<script type="text/javascript" src="../resources/js/add.js"></script>
</body>
</html>