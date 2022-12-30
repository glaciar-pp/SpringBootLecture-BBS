<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>MBTI Test</title>
</head>
<body style="margin: 40px;">
	<h3>MBTI Test (No. ${num})</h3>
	<hr>
	<form action="/misc/mbti" method="post">
		<input type="hidden" name="num" value="${num}">
		<button type="submit" name="point" value="${point1}">${question1}</button>
		<button type="submit" name="point" value="${point2}">${question2}</button>
	</form>
</body>
</html>