<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>유저 칭호</title>
</head>
<body>
	<%@ include file="common/header.jsp" %>
	<div>
		<h1>유저 칭호 등록</h1>
		<form action="/admin/usersubnicknameprocess" method="POST">
			<input name = "subNickname"/><br/>
			<button>등록</button>
		</form>
		
		<h1>유저 칭호 목록</h1>
		<c:forEach var="n" items="${vo}">
			<h3>${n.subNickname}</h3>
		</c:forEach>
	</div>
</body>
</html>