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
	<h1>${board} add Page</h1>
	
	<form action="./add" method="post" enctype="multipart/form-data">
		Title : <input type="text" id="title" name="title">
	Writer : <input type="text" id="writer" name="writer" value="${member.id}"readonly>
	Contents: <textarea rows="0" cols="50" name="contents"></textarea>
	
	<div id="fileResult">
		<!--
			<div>
				<input type="file" name="files"><button type="button">DEL</button>
			</div>
			<input type="file" name="files">
			<input type="file" name="files">
		-->
	</div>
	<div>
		<button type="button" id="fileAdd">FileAdd</button>
		<button type="button" class="del">Sample DEL</button>
		
	</div>
	
	
	<button type="submit" id="but">ADD</button>
	
</form>
<script type="text/javascript" src="../resources/js/add.js"></script>
<script src="../resources/js/file.js"></script>

</body>
</html>