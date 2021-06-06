<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>자유게시판</title>
	<style>
		.fl_wrap{
			width: 100%;
			
			display: flex;
			flex-direction: column;
			justify-content: center;
			align-items: center;
			
			margin-top: 50px;
		}
		.fl_main{
			width: 90%;
			
			display: flex;
			flex-direction: row;
		}
		.fl_list{
		
			width: 1000px;
			
			
			display: flex;
			flex-direction: column;
			
		}
		.fl_write_button{
			margin-top: 20px;
		
			display: flex;
			justify-content: flex-end;
		}
		.fl_bar > nav{
			border:2px solid black;
		}
		.fl_bar > nav > a:hover {
		  background-color: black;
		  color: white;
		}
	</style>
</head>
<body>
	<%@ include file="common/header.jsp" %>
	<div class="fl_wrap">
		<h1>자유게시판</h1>
		<div class="fl_main">
			<div>
				<%@ include file="common/navList.jsp" %>
			</div>
			<div class="fl_list">
				<div class="fl_write_button">
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
				  <c:forEach var="p"
				   items="${vo}">
					   <tr>
					      <th scope="row"></th>
					      <td><a href="/sscontent?id="></a></td>
					      <td></td>
					      <td></td>
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