<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Member Update Page</h1>
	
	<form action="./update" method="post"></form>
	ID :<input type="test" readonly="readonly" name="num" value="${dto.id}">
	Name : <input type="text" name="name" value="${dto.name}">
	Phone :<input type="number" name="phone" value="${dto.phone}">
	Email : <input type="email" name="email" value="${dto.email}">
	
	<input type="submit" value="update">

</body>
</html>