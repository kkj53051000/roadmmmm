<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		.ppl_wrap{
			width: 100%;
			
			display: flex;
			flex-direction: column;
			justify-content: center;
			align-items: center;
			
			margin-top: 50px;
		}
		.ppl_main{
			width: 90%;
			
			display: flex;
			flex-direction: row;
		}
		.ppl_list{
		
			width: 1000px;
			
			
			display: flex;
			flex-direction: column;
			
		}
		.ppl_write_button{
			margin-top: 20px;
		
			display: flex;
			justify-content: flex-end;
		}
		.ppl_bar > nav{
			border:2px solid black;
		}
		.ppl_bar > nav > a:hover {
		  background-color: black;
		  color: white;
		}
	</style>
</head>
<body>
	<%@ include file="common/header.jsp" %>
	<div>
		<h1>인기게시글</h1>
		<div class="ppl_main">
			<div>
				<%@ include file="common/navList.jsp" %>
			</div>
			<div class="ppl_list">
				
				<div class="ppl_bar">
					<nav class="nav nav-pills nav-fill">
					  <a class="nav-link" aria-current="page" href="/">실시간</a>
					  <a class="nav-link " href="/">일간</a>
					  <a class="nav-link " href="/">주간</a>
					  <a class="nav-link" href="/">월간</a>
					</nav>
				</div>
				
				<div class="ppl_write_button">
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
				  <c:forEach var="p" items="${vo}">
					   <tr>
					      <th scope="row">${p.boardId}</th>
					      <td><a href="/sscontent?id=">${p.title}</a></td>
					      <td>${p.nickname}</td>
					      <td>${p.date}</td>
					    </tr>
				  </c:forEach>
				  </tbody>
				</table>
				
				<div class="ppl_paging">
					
				</div>
				
			</div>
		</div>
	</div>
</body>
</html>