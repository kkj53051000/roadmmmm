<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		.list_bar{
			width: 220px;
		}
		.list_bar{
			margin-right: 50px;
		}
	</style>
</head>
<body>

	<div class="navList">
		<div class = "list_bar">
			<div class="list-group">
			  <a href="/sslist?sector=ALL" class="list-group-item list-group-item-action">주식 공부</a>
			  <a href="/pplist?sector=LIVE" class="list-group-item list-group-item-action">인기게시글</a>
			  <a href="/flist" class="list-group-item list-group-item-action">자유게시판</a>
			  <a href="#" class="list-group-item list-group-item-action">종목 스터디</a>
			  <a href="#" class="list-group-item list-group-item-action">증권사 종류</a>
			</div>
		</div>
	</div>
</body>
</html>