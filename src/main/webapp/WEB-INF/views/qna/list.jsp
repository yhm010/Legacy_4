<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/header_css.jsp"></c:import>
<link href="../resources/css/table.css" rel="styleSheet" />
<link href="../resources/css/list.css" rel="styleSheet" />
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<h1>QNA list page</h1>
	<table>
		<thead>
			<tr>
				<th>글번호</th>
				<th>글제목</th>
				<th>글내용</th>
				<th>작성자</th>
				<th>작성일자</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="qna">
				<tr>
					<td><a href="./detail?num=${qna.num}">${qna.num}</a></td>
					<td>${qna.title}</td>
					<td>${qna.contents}</td>
					<td>${qna.writer}</td>
					<td>${qna.regdate}</td>
					<td>${qna.hit}</td>
				</tr>
			</c:forEach>
			<a href="./add">ADD</a>
		</tbody>
	</table>

</body>
</html>