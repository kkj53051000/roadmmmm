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
		.join_form{
			width: 350px;
		}
	</style>
</head>
<body>
	<%@ include file="common/header.jsp" %>
	<div class="join_wrap">
		<div>
			<h1><Strong>Join</Strong></h1>
		</div>
		<div class="join_form">
			<form action="/joinprocess" method="POST">
				<div class="form-floating mb-3">
				  <input name="userid" type="text" class="form-control" id="floatingInput" placeholder="id">
				  <label for="floatingInput">아이디</label>
				</div>
				<div class="form-floating mb-3">
				  <input name="userpw" type="password" class="form-control" id="floatingPassword" placeholder="Password">
				  <label for="floatingPassword">비밀번호</label>
				</div>
				<div class="form-floating mb-3">
				  <input name="nickname" type="text" class="form-control" id="floatingInput" placeholder="nickname">
				  <label for="floatingInput">닉네임</label>
				</div>
				<div class="form-floating">
				  <input name="email" type="email" class="form-control" id="floatingInput" placeholder="name@example.com">
				  <label for="floatingInput">이메일</label>
				</div><br/>
				<button type="button" class="btn btn-dark">회원가입</button>
			</form>
		</div>
	</div>
</body>
</html>