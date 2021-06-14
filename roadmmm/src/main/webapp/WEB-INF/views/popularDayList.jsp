<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		.ppd_wrap{
			width: 100%;
			
			display: flex;
			flex-direction: column;
			justify-content: center;
			align-items: center;
			
			margin-top: 50px;
		}
		.ppd_main{
			width: 90%;
			
			display: flex;
			flex-direction: row;
		}
		.ppd_list{
		
			width: 1000px;
			
			
			display: flex;
			flex-direction: column;
			
		}
		.ppd_write_button{
			margin-top: 20px;
		
			display: flex;
			justify-content: flex-end;
		}
		.ppd_bar > nav{
			border:2px solid black;
		}
		.ppd_bar > nav > a:hover {
		  background-color: black;
		  color: white;
		}
		.ppd_day{
			display: flex;
			flex-direction: row;
			justify-content: center;
		}
	</style>
</head>
<body>
	<%@ include file="common/header.jsp" %>
	<div class="ppd_wrap">
		<h1>인기게시글(일간)</h1>
		<div class="ppd_main">
			<div>
				<%@ include file="common/navList.jsp" %>
			</div>
			<div class="ppd_list">
				
				<div class="ppd_bar">
					<nav class="nav nav-pills nav-fill">
					  <a class="nav-link" aria-current="page" href="/ppllist?sector=LIVE">실시간</a>
					  <a class="nav-link " href="/ppdlist">일간</a>
					  <a class="nav-link" href="/ppmlist">월간</a>
					</nav>
				</div>
				
				<div class="ppd_day">
					<form action="/ppdlist">
						<input type="hidden" name="move" value="true">
						<input type="hidden" name="fyear" value="${vo.thisYear}"/>
						<input type="hidden" name="fmonth" value="${vo.thisMonth}"/>
						<input type="hidden" name="fday" value="${vo.thisDay}"/>
						<button type="submit">전</button>
					</form>
					<input name="year" value="${vo.thisYear}"/>
					<input name="month" value="${vo.thisMonth}"/>
					<input name="day" value="${vo.thisDay}"/>
					<form action="/ppdlist">
						<input type="hidden" name="move" value="false">
						<input type="hidden" name="fyear" value="${vo.thisYear}"/>
						<input type="hidden" name="fmonth" value="${vo.thisMonth}"/>
						<input type="hidden" name="fday" value="${vo.thisDay}"/>
						<button type="submit">후</button>
					</form>
				</div>
				
				<div class="ppd_write_button">
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
				  <c:forEach var="p" items="${vo.popularListForm.popularInfoForms}">
					   <tr>
					      <th scope="row">${p.boardId}</th>
					      <td><a href="/sscontent?id=">${p.title}</a></td>
					      <td>${p.user.nickname}</td>
					      <td>${p.date}</td>
					    </tr>
				  </c:forEach>
				  </tbody>
				</table>
				
				<div class="ppd_paging">
					<c:if test="${vo.popularListForm.beforePage}">
						<a href="ppdlist?page=${vo.popularListForm.beforePageNum}"><span>이전</span></a>
					</c:if>
					
					<c:forEach var="p" items="${vo.popularListForm.pageList}">
						<!-- 날짜마다 페이징 처리 안됨 -->
						<a href="ppdlist?page=${p}"><span>${p} </span></a>
					</c:forEach>
					<c:if test="${vo.popularListForm.afterPage}">
						<a href="ppdlist?page=${vo.afterPageNum}"><span>다음</span></a>
					</c:if>
				</div>
				
			</div>
		</div>
	</div>
</body>
</html>