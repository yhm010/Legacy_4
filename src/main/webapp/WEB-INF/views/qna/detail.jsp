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
	<h1>QNA detail page</h1>
	
	<h3>Num : ${qna.num}</h3>
	<h3>Title : ${qna.title}</h3>
	<h3>Contents : ${qna.contents}</h3>
	<h3>Writer : ${qna.writer}</h3>
	<h3>RegDate : ${qna.regdate}</h3>
	<h3>Hit : ${qna.hit}</h3>
	<h3>Ref : ${qna.ref}</h3>
	<h3>Step : ${qna.step}</h3>
	<h3>Depth : ${qna.depth}</h3>
	
	<a href="./list">List</a>
	<a href="./update?num=${qna.num}">Update</a>
	<a href="./delete?num=${qna.num}">Delete</a>
</body>
</html>