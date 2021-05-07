<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>join</title>
	<style>
		.join_wrap{
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
	<div class="join_wrap">
		<div>
			<h1>JoinPage</h1>
		</div>
		<div>
			<form action="/joinprocess" method="POST">
				아이디 : <input name="userid"/><br/>
				비밀번호 : <input name="userpw"/><br/>
				닉네임 : <input name="nickname"/><br/>
				이메일 : <input name="email"/><br/>
				<button>회원가입</button>
			</form>
		</div>
	</div>
</body>
</html>