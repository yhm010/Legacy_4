<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/header_css.jsp"></c:import>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<h1>Notice List Page</h1>

	<table>
		<thead>
			<th>글 번호</th>
			<th>글 제목</th>
			<th>글 내용</th>
			<th>작성자</th>
			<th>작성 일자</th>
			<th>조회 수</th>
			</tr>
		</thead>
		<c:forEach items="${list}" var="dto">
			<tr>
				<td><a href="./deteil?num=${dto.num}">${dto.num}</a></td>
				<td>${dto.title}</td>
				<td>${dto.contents}</td>
				<td>${dto.writer}</td>
				<td>${dto.regdate}</td>
				<td>${dto.hit}</td>
			</tr>
		</c:forEach>
	</table>
	<div>
	<c:if test="${pager.pre}">
		<a href="./list?page=${pager.startNum-1}">PREVIEW</a>
	</c:if>
	
		<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" step="1"
			var="i">
			<a href="./list?page=${i}">${i}</a>
		</c:forEach>
		
		<c:if test="${pager.next}">
			<a href="./list?page=${pager.lastNum+1}">NEXT</a>
		</c:if>
	</div>
			<a href="./add">ADD</a>
</body>
</html>