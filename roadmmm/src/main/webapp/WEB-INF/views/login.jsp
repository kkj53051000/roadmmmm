<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login</title>
	<style>
		.login_wrap{
			width: 100%;
			
			display: flex;
			flex-direction: column;
			justify-content: center;
			align-items: center;
		}
	</style>
</head>
<body>
	<%@ include file="common/header.jsp" %>
	<div class="login_wrap">
		<div>
			<h1>Login Page!</h1>
		</div>
		<div>
			<form action="loginprocess" method="POST">
				아이디 : <input name="userid"/><br/>
				비밀번호 : <input name="userpw"/><br/>
				<button>로그인</button>
			</form>
		</div>
	</div>
</body>
</html>