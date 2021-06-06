<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>주식 공부</title>
	<style>
		.ssl_wrap{
			width: 100%;
			
			display: flex;
			flex-direction: column;
			justify-content: center;
			align-items: center;
			
			margin-top: 50px;
		}
		.ssl_main{
			width: 90%;
			
			display: flex;
			flex-direction: row;
		}
		.ssl_list{
		
			width: 1000px;
			
			
			display: flex;
			flex-direction: column;
			
		}
		.ssl_write_button{
			margin-top: 20px;
		
			display: flex;
			justify-content: flex-end;
		}
		.ssl_bar > nav{
			border:2px solid black;
		}
		.ssl_bar > nav > a:hover {
		  background-color: black;
		  color: white;
		}
		.ssl_paging{
			display: flex;
			flex-direction: row;
			justify-content: center;
			align-items: center;
			
		}
		.ssl_paging > a{
			margin: 5px;
		}
	</style>
</head>
<body>
	<%@ include file="common/header.jsp" %>
	<div class="ssl_wrap">
		<h1>주식 공부</h1>
		<div class="ssl_main">
		
			<div>
				<%@ include file="common/navList.jsp" %>
			</div>
			<div class="ssl_list">
				
				<a href="/ssbestlist"><button type="button" class="btn btn-primary btn-lg">베스트글 목록</button></a><br/>
				<div class="ssl_bar">
					<nav class="nav nav-pills nav-fill">
					  <a class="nav-link" aria-current="page" href="/sslist?sector=ALL">전체</a>
					  <a class="nav-link " href="/sslist?sector=STOCK">주식</a>
					  <a class="nav-link " href="/sslist?sector=TERM">용어</a>
					  <a class="nav-link" href="/sslist?sector=CHART">차트</a>
					  <a class="nav-link" href="/sslist?sector=INCIDENT">사건</a>
					</nav>
				</div>
				
				<div class="ssl_write_button">
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
				  <c:forEach var="s" items="${vo.stockStudys}">
					   <tr>
					      <th scope="row">${s.id}</th>
					      <td><a href="/sscontent?id=${s.id}">${s.title}</a></td>
					      <td>${s.user.nickname}</td>
					      <td>${s.date}</td>
					    </tr>
				  </c:forEach>
				  </tbody>
				</table>
				
				<div class="ssl_paging">
					<c:if test="${vo.beforePage}">
						<a href="/sslist?sector=${vo.tag}&page=${vo.beforePageNum}"><span>이전</span></a>
					</c:if>
					
					<c:forEach var="p" items="${vo.pageList}">
						<a href="/sslist?sector=${vo.tag}&page=${p}"><span>${p} </span></a>
					</c:forEach>
					<c:if test="${vo.afterPage}">
						<a href="/sslist?sector=${vo.tag}&page=${vo.afterPageNum}"><span>다음</span></a>
					</c:if>
					
				</div>
				
			</div>
		</div>
	</div>
</body>
</html>