<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
	<style>
		.headerWrap{
			width: 100%;
			height: 150px;
			
			border: 1px solid black;
			display: flex;
			flex-direction: column;
			justify-content: center;
		}
		.main_logo{
			display: flex;
			flex-direction: row;
			justify-content: center;
			align-items: center;
		}
		.nav_link{
			display: flex;
			flex-direction: row;
			justify-content: flex-end;
			margin-left: 20px;
		}
		a { text-decoration:none }
		a:link { color: black; text-decoration: none;}
	    a:visited { color: black; text-decoration: none;}
	    a:hover { color: black; text-decoration: underline;}

	</style>
</head>
<body>
	<div class="headerWrap">
		<div class="main_logo">
			<h1><strong><a href="/">Road To Millio</a></strong></h1>
		</div>
		
		<div class="nav_link">
			<c:if test="${user == null}">
				<a href="/"><button type="button" class="btn btn-outline-secondary">메인</button></a>&nbsp;
				<a href="/login"><button type="button" class="btn btn-outline-dark">로그인</button></a>&nbsp;
				<a href="/join"><button type="button" class="btn btn-outline-dark">회원가입</button></a>&nbsp;
				
			</c:if>
			<c:if test="${user != null}">
				<strong>${user.subNickname.subNickname}</strong>${user.nickname}님&nbsp;&nbsp;
				<a href="/">main</a>&nbsp;&nbsp;
				<a href="/logout">logout</a>&nbsp;&nbsp;
				<a href="/adminpage">관리자 페이지</a>&nbsp;&nbsp;
				<a href="/mypage">마이페이지</a>
			</c:if>
		</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
</body>
</html>