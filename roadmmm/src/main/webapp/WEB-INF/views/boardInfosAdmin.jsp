<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 관리</title>
</head>
<body>
	<%@ include file="common/header.jsp" %>
	<div>
		<h1>게시판 관리</h1><br/><br/>
		
		<h3>게시판 리스트</h3><br/>
		<c:forEach var="b" items="${vo}">	
			<table class="table">
			  <thead>
			    <tr>
			      <th scope="col">No</th>
			      <th scope="col">게시판 이름 (Server Table name)</th>
			      <th scope="col">베스트글 기준</th>
			      <th scope="col">게시판 정보</th>
			    </tr>
			  </thead>
			  <tbody>
			    <tr>
			      <th scope="row">${b.id}</th>
			      <td>${b.board}</td>
			      <td>${b.bestStandard}</td>
			      <td>${b.info}</td>
			    </tr>
			  </tbody>
			</table>
		</c:forEach>
		<br/>
		
		<a href="/biwirte"><button>게시판 등록</button></a>
	</div>
</body>
</html>