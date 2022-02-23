<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Member join page</h1>

	<div>
		<form action="./join" method="post">
			<fieldset>
				<legend>ID</legend>
				<input type="text" name="id">
			</fieldset>

			<fieldset>
				<legend>PassWord</legend>
				<input type="password" name="pw">
			</fieldset>

			<fieldset>
				<legend>NAME</legend>
				<input type="text" name="name">
			</fieldset>

			<fieldset>
				<legend>Phone</legend>
				<input type="number" name="phone">
			</fieldset>

			<fieldset>
				<legend>Email</legend>
				<input type="email" name="email">
			</fieldset>
			
			<fieldset>
			<button type="submit">JOIN</button>
			</fieldset>
		</form>
	</div>

</body>
</html>