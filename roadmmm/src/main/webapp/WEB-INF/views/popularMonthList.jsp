<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		.ppm_wrap{
			width: 100%;
			
			display: flex;
			flex-direction: column;
			justify-content: center;
			align-items: center;
			
			margin-top: 50px;
		}
		.ppm_main{
			width: 90%;
			
			display: flex;
			flex-direction: row;
		}
		.ppm_list{
		
			width: 1000px;
			
			
			display: flex;
			flex-direction: column;
			
		}
		.ppm_write_button{
			margin-top: 20px;
		
			display: flex;
			justify-content: flex-end;
		}
		.ppm_bar > nav{
			border:2px solid black;
		}
		.ppm_bar > nav > a:hover {
		  background-color: black;
		  color: white;
		}
		.ppm_day{
			display: flex;
			flex-direction: row;
			justify-content: center;
		}
	</style>
</head>
<body>
	<%@ include file="common/header.jsp" %>
	<div class="ppm_wrap">
		<h1>인기게시글(월간)</h1>
		<div class="ppm_main">
			<div>
				<%@ include file="common/navList.jsp" %>
			</div>
			<div class="ppm_list">
				
				<div class="ppm_bar">
					<nav class="nav nav-pills nav-fill">
					  <a class="nav-link" aria-current="page" href="/ppllist?sector=LIVE">실시간</a>
					  <a class="nav-link " href="/ppdlist">일간</a>
					  <a class="nav-link" href="/ppmlist">월간</a>
					</nav>
				</div>
				
				<div class="ppm_day">
					<form action="/ppmlist">
						<input type="hidden" name="move" value="true">
						<input type="hidden" name="fyear" value="${vo.thisYear}"/>
						<input type="hidden" name="fmonth" value="${vo.thisMonth}"/>
						<button type="submit">전</button>
					</form>
					<input name="year" value="${vo.thisYear}"/>
					<input name="month" value="${vo.thisMonth}"/>
					<form action="/ppmlist">
						<input type="hidden" name="move" value="false">
						<input type="hidden" name="fyear" value="${vo.thisYear}"/>
						<input type="hidden" name="fmonth" value="${vo.thisMonth}"/>
						<button type="submit">후</button>
					</form>
				</div>
				
				<div class="ppm_write_button">
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
				  <c:forEach var="p" items="${vo.popularDays}">
					   <tr>
					      <th scope="row">${p.boardId}</th>
					      <td><a href="/sscontent?id=">${p.title}</a></td>
					      <td>${p.user.nickname}</td>
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