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
	<h1>Notice Add Page</h1>

	<table>
		<thead>
			<tr>
				<th>글 번호</th>
				<th>글 제목</th>
				<th>글 내용</th>
				<th>작성자</th>
				<th>작성 일자</th>
				<th>조회 수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="dto">
			<td>${dto.num}</td>
			<td><a href="./deteil?num=${dto.num}">${dto.title}</a></td>
			<td>${dto.contents}</td>
			<td>${dto.wrier}</td>
			<td>${dto.regdate}</td>
			<td>${dto.hit}</td>
			</c:forEach>
			<a href="./add">ADD</a>
		</tbody>


	</table>
</body>
</html>