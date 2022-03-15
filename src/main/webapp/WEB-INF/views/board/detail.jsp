<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<body>
	<h1>${board} detail Page</h1>
	
	<h3>Num : ${dto.num}</h3>
	<h3>Title : ${dto.title}</h3>
	<h3>Contents : ${dto.contents} </h3>
	<h3>Writer : ${dto.writer}</h3>
	<h3>RegDate : ${dto.regDate}</h3>
	<h3>Hit : ${dto.hit} </h3>
	
	<div>
		<c:forEach items="${dto.fileDTOs}" var="f">
		<%-- <a href="../resources/upload/${board}/${f.fileName}">${f.oriName}</a> --%>
		<a href="./fileDown?fileNum=${f.fileNum}">${f.oriName}</a>
		</c:forEach>
	</div>
	
	<a href="./list">List</a>
	
	<!-- 작성자만 가능 -->
	<c:if test="${member.id eq dto.writer}">
	<a href="./update?num=${dto.num}">Update</a>
	<a href="./delete?num=${dto.num}">Delete</a>
	</c:if>
	
	<c:if test="${board ne 'notice'}">
	<a href="./reply?num=${dto.num}">Reply</a>
	</c:if>
</body>
</html>