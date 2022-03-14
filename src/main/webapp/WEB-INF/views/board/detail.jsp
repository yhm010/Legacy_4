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
		<%-- <a href="../resources/upload/${board}/${f.fileName}">${f.oriName}</a> --%> // 사진보이기
		<a href="./fileDown?fileNum=${f.fileNum}">${f.oriName}</a> // 파일다운
		</c:forEach>
	</div>
	
	<a href="./list">List</a>
	<a href="./update?num=${dto.num}">Update</a>
	<a href="./delete?num=${dto.num}">Delete</a>
	<c:if test="${board ne 'notice'}">
	<a href="./reply?num=${dto.num}">Reply</a>
	</c:if>
</body>
</html>