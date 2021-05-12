<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>StockStudy Content</title>
	<style>
		.ssc_wrap{
			width: 100%;
			
			display: flex;
			flex-direction: column;
			justify-content: center;
			align-items: center;
			
			margin-top: 50px;
		}
		.ssc_main{
			width: 90%;
			
			display: flex;
			flex-direction: row;
		}
		.ssc_upanddown{
			margin-top: 20px;
		}
	</style>
</head>
<body>
	<%@ include file="common/header.jsp" %>
	<div class="ssc_wrap">
		<div class="ssc_main">
			<div>
				<%@ include file="common/navList.jsp" %>
			</div>
			
			<div class="ssc_content">
				<div>
					<h1>제목 : ${vo.title}</h1>
					<br/>
					내용 : ${vo.content}
				</div>
				
				<div class="ssc_upanddown">
					<h1>추천 개수 : ${up}</h1>
					<a href="/ssrecommendprocess?updown=true&id=${vo.id}"><button type="button" class="btn btn-outline-dark">추천</button></a>
					<a href="#"><button type="button" class="btn btn-outline-dark">비추천</button></a>
				</div>
				
				
			</div>
		</div>
	</div>
</body>
</html>