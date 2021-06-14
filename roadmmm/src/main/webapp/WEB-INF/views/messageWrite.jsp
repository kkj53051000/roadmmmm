<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="common/header.jsp" %>
	<div>
		<h1>쪽지 보내기</h1>
		<form>
			받는 유저 이메일 : <input name="email"/><br/>
			제목 : <input name="title"/><br/>
			내용 : <input name="content"/><br/>
			<button type="submit">전송</button>
		</form>
	</div>
</body>
</html>