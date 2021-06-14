<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style type="text/css">
	
	</style>
</head>
<body>
	<%@ include file="common/header.jsp" %>
	<div>
		<div>
			아이디 : ${user.userid}<br/>
			닉네임 : ${user.nickname}<br/>
			<br/>
			sub닉네임 추가<br/>
			<form action="/setsubnickname" method="POST">
				<input name="subNickname"/><br/>
				<button>추가</button><br/>
			</form>
			
			<br/>
			<c:if test="${user.subNickname == null}">
				서브 닉네임 없음
			</c:if>
			
		</div>
	</div>
</body>
</html>