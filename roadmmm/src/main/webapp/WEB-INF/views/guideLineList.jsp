<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>가이드라인</title>
	<style>
		.gll_wrap{
			width: 100%;
			
			display: flex;
			flex-direction: column;
			justify-content: center;
			align-items: center;
			
			margin-top: 50px;
		}
		.gll_main{
			width: 90%;
			
			display: flex;
			flex-direction: row;
		}
		.gll_list{
		
			width: 1000px;
			
			
			display: flex;
			flex-direction: column;
			
		}
		.gll_write_button{
			margin-top: 20px;
		
			display: flex;
			justify-content: flex-end;
		}
		.gll_bar > nav{
			border:2px solid black;
		}
		.gll_bar > nav > a:hover {
		  background-color: black;
		  color: white;
		}
		.gll_contents{
			display: flex;
			flex-direction: row;
			flex-wrap: wrap;
		}
		.gll_content{
			display: flex;
			flex-direction: column;
		}
		
		.content_img{
			height:300px;
			width: 300px;
			margin: 10px;
			border: 3px solid black;
		}
	</style>
</head>
<body>
	<%@ include file="common/header.jsp" %>
	<div class="gll_wrap">
		<h1>가이드라인</h1>
		<div class="gll_main">
		
			<div>
				<%@ include file="common/navList.jsp" %>
			</div>
			<div class="gll_list">
			
				<div class="gll_bar">
					<nav class="nav nav-pills nav-fill">
					  <a class="nav-link " href="/gllist?sector=STOCK">주식</a>
					  <a class="nav-link " href="/gllist?sector=TERM">용어</a>
					  <a class="nav-link" href="/gllist?sector=CHART">차트</a>
					  <a class="nav-link" href="/gllist?sector=INCIDENT">사건</a>
					</nav>
				</div>
				
				<div class="gll_write_button">
					<a href="/glwrite"><button type="button" class="btn btn-dark">글 작성</button></a>
				</div>
				
				<div class="gll_contents">
					<c:forEach var="g" items="${vo.guideLineListForms}">
						<div class="gll_content">
							<img class="content_img" src="${g.titleImg}"/>
							<div class="content_title"><h4>${g.title}</h4></div>
						</div>
					</c:forEach>
				</div>
				
				<div class="gll_paging">
					<c:if test="${vo.pagingForm.beforePage}">
						<a href="gllist?sector=${vo.tag}&page=${vo.pagingForm.beforePageNum}"><span>이전</span></a>
					</c:if>
					
					<c:forEach var="p" items="${vo.pagingForm.pageList}">
						<a href="gllist?sector=${vo.tag}&page=${p}"><span>${p} </span></a>
					</c:forEach>
					<c:if test="${vo.pagingForm.afterPage}">
						<a href="gllist?sector=${vo.tag}&page=${vo.pagingForm.afterPageNum}"><span>다음</span></a>
					</c:if>
				</div>
				
			</div>
		</div>
	</div>
</body>
</html>