<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
	<style>
		.login_wrap{
			width: 100%;
			
			display: flex;
			flex-direction: column;
			justify-content: center;
			align-items: center;
		}
		.login_form{
			width: 350px;
		}
	</style>
</head>
<body>
	<%@ include file="common/header.jsp" %>
	<div class="login_wrap">
		<div>
			<h1><strong>Login</strong></h1>
		</div>
		<div class="login_form">
			<form action="loginprocess" method="POST">
				<div class="form-floating mb-3">
				  <input name="userid" type="text" class="form-control" id="floatingInput" placeholder="id">
				  <label for="floatingInput">아이디</label>
				</div>
				<div class="form-floating">
				  <input name="userpw" type="password" class="form-control" id="floatingPassword" placeholder="Password">
				  <label for="floatingPassword">비밀번호</label>
				</div><br/>
				<button type="submit" class="btn btn-dark">로그인</button>
			</form>
		</div>
	</div>
</body>
</html>