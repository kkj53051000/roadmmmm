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
	</style>
<body>
	<%@ include file="common/header.jsp" %>
	<div class="ssb_wrap">
		<div class="ssb_main">
			<div>
				<%@ include file="common/navList.jsp" %>
			</div>
			<div class="ssb_list">
				
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