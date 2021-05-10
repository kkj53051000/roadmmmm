<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>주식 공부</title>
	<style>
		.ss_wrap{
			width: 100%;
			
			display: flex;
			flex-direction: column;
			justify-content: center;
			align-items: center;
			
			margin-top: 50px;
		}
		.ss_main{
			width: 90%;
			
			display: flex;
			flex-direction: row;
		}
		.ss_list{
		
			width: 1000px;
			
			
			display: flex;
			flex-direction: column;
			
		}
		.ss_write_button{
			margin-top: 20px;
		
			display: flex;
			justify-content: flex-end;
		}
		.ss_bar > nav{
			border:2px solid black;
		}
		.ss_bar > nav > a:hover {
		  background-color: black;
		  color: white;
		}
	</style>
</head>
<body>
	<%@ include file="common/header.jsp" %>
	<div class="ss_wrap">
		<div class="ss_main">
			<div>
				<%@ include file="common/navList.jsp" %>
			</div>
			
			<div class="ss_list">
				
				<div class="ss_bar">
					<nav class="nav nav-pills nav-fill">
					  <a class="nav-link" aria-current="page" href="/sslist?sector=all">전체</a>
					  <a class="nav-link " href="/sslist?sector=STOCK">주식</a>
					  <a class="nav-link " href="/sslist?sector=TERM">용어</a>
					  <a class="nav-link" href="/sslist?sector=CHART">차트</a>
					  
					</nav>
				</div>
				
				<div class="ss_write_button">
					<a href="/sswrite"><button type="button" class="btn btn-dark">글 작성</button></a>
				</div>
				
				<table class="table">
				  <thead>
				    <tr>
				      <th scope="col">글 번호</th>
				      <th scope="col">제목</th>
				      <th scope="col">닉네임</th>
				      <th scope="col">작성일시</th>
				    </tr>
				  </thead>
				  <tbody>
				  <c:forEach var="s" items="${stockStudys}">
					   <tr>
					      <th scope="row">${s.id}</th>
					      <td>${s.title}</td>
					      <td>${s.content}</td>
					      <td>${s.date}</td>
					    </tr>
				  </c:forEach>
				  </tbody>
				</table>
				
			</div>
		</div>
	</div>
</body>
</html>