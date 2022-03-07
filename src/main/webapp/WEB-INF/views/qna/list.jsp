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
	<div>
		<h1>QNA list page</h1>
	</div>
	<table class="table-basic">
		<div>
			<form action="./list" method="get">
				<fieldset>
					<select name="kind">
						<option value="col1">제목</option>
						<option value="col2">본문</option>
						<option value="col3">작성자</option>
					</select> <input type="text" name="search" value="${pager.search}">
					<button type="submit">검색</button>
				</fieldset>
			</form>
		</div>
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
		<c:if test="${pager.pre}">
			<a href="./list?page=${pager.startNum-1}">이전 페이지</a>
		</c:if>
		<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
			<a href="./list?page=${i}&kind=${pager.kind}&search={pager.search}">${i}</a>
		</c:forEach>
		<c:if test="${pager.next}">
			<a href="./list?page=${pager.lastNum+1}">다음 페이지</a>
		</c:if>
		
</body>
</html>