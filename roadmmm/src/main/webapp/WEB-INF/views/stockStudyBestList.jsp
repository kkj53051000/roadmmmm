<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Insert title here</title>
	</head>
	<style>
		.ssb_wrap{
			width: 100%;
			
			display: flex;
			flex-direction: column;
			justify-content: center;
			align-items: center;
			
			margin-top: 50px;
		}
		.ssb_main{
			width: 90%;
			
			display: flex;
			flex-direction: row;
		}
		.ssb_list{
		
			width: 1000px;
			
			
			display: flex;
			flex-direction: column;
			
		}
		.ssb_write_button{
			margin-top: 20px;
		
			display: flex;
			justify-content: flex-end;
		}
		.ssb_bar > nav{
			border:2px solid black;
		}
		.ssb_bar > nav > a:hover {
		  background-color: black;
		  color: white;
		}
	</style>
<body>
	<%@ include file="common/header.jsp" %>
	<div class="ssb_wrap">
		<h1>주식 공부 베스트</h1>
		<div class="ssb_main">
			<div>
				<%@ include file="common/navList.jsp" %>
			</div>
			<div class="ssb_list">
			
				<a href="/sslist"><button type="button" class="btn btn-primary btn-lg">일반글 목록</button></a><br/>
				<div class="ssb_bar">
					<nav class="nav nav-pills nav-fill">
					  <a class="nav-link" aria-current="page" href="/ssbestlist">전체</a>
					  <a class="nav-link " href="/ssbestlist?sector=STOCK">주식</a>
					  <a class="nav-link " href="/ssbestlist?sector=TERM">용어</a>
					  <a class="nav-link" href="/ssbestlist?sector=CHART">차트</a>
					  <a class="nav-link" href="/ssbestlist?sector=INCIDENT">사건</a>
					</nav>
				</div>
				
				<div class="ssb_write_button">
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
						<a href="/ssbestlist?sector=${vo.tag}&page=${vo.beforePageNum}"><span>이전</span></a>
					</c:if>
					
					<c:forEach var="p" items="${vo.pageList}">
						<a href="/ssbestlist?page=${p}"><span>${p} </span></a>
					</c:forEach>
					<c:if test="${vo.afterPage}">
						<a href="/ssbestlist?page=${vo.afterPageNum}"><span>다음</span></a>
					</c:if>
					
				</div>
				
			</div>
		</div>
	</div>
</body>
</html>