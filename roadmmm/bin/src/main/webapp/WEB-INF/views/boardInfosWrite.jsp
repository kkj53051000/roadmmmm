<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 정보 수정</title>
</head>
<body>
	<%@ include file="common/header.jsp" %>
	<div>
		<h1>게시판 정보 등록</h1>
		<form action = "/boardsinfoprocess" method = "POST">
			Board Table Name (개발자에게 문의) : <input name = "board"/><br/>
			설명 : <input name = "info"/><br/>
			베스트글 개수 : <input name = "bestStandard"/><br/>
			인기글 개수 : <input name = "popularStandard"/><br/>
			<button type = "submit">입력</button>
		</form>
	</div>
</body>
</html>