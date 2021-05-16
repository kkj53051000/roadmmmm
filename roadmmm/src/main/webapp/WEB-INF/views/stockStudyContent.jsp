<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>StockStudy Content</title>
	<!-- CSS only -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
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
			flex-direction: column;
		}
		.ssc_content{
			width: 1000px;
			
			display: flex;
			flex-direction: row;
		}
		.ssc_upanddown{
		
			display: flex;
			flex-direction: row;
			justify-content: center;
			align-items: center;
		
			margin-top: 20px;
		}
		.ssc_comment{
			margin-top: 30px;
		
			display: flex;
			flex-direction: column;
			justify-content: center;
			align-items: center;
		}
		.ssc_comment_input{
			width: 400px;
		}
		.ssc_comment_content{
			margin-top: 20px;
			
			display: flex;
			flex-direction: column;
		}
		.disrow{
			display: flex;
			flex-direction: row;
		}
		.comment{
			margin-bottom: 20px;
		}
		.marginl{
			margin-left: 20px;
		}
	</style>
</head>
<body>
	<%@ include file="common/header.jsp" %>
	<div class="ssc_wrap">
		<div class="ssc_main">
			
			<div class="ssc_content">
				<div>
					<%@ include file="common/navList.jsp" %>
				</div>
				
				<div class="ssc_content">
					<div>
						<h1>제목 : ${vo.stockStudy.title}</h1>
						<br/>
						내용 : ${vo.stockStudy.content}
					</div>
					
					
				</div>
			</div>
			
			<div class="ssc_upanddown">
				<a href="/ssrecommendprocess?updown=true&id=${vo.stockStudy.id}"><button type="button" class="btn btn-outline-dark">추천 ${vo.upCount}</button></a>
				<a href="/ssrecommendprocess?updown=false&id=${vo.stockStudy.id}"><button type="button" class="btn btn-outline-dark">비추천 ${vo.downCount}</button></a>
			</div>
			
			<div class="ssc_comment">
				<div class="ssc_comment_input">
					
					<div class="mb-3">
						<h3>댓글</h3>
						<form class="disrow" action="/sscommentprocess?ssid=${vo.stockStudy.id}" method="POST">
						  		
						  		<textarea name = "content" class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
							  	<button type="submit" class="btn btn-warning">등록</button>
						</form>
					</div>
				</div>
				
				<!-- 댓글/답글 부분 -->
				<div class="ssc_comment_content">
					<h2>댓글 목록</h2>
					<c:forEach var = "c" items = "${voc}">
						<div class="comment">
							<c:if test="${c.commentEnum == 'COMMENT'}">
								<hr>
								댓글 : ${c.id}. 내용 : ${c.content} 닉네임 : ${c.user.nickname} | 
								<form action="/ssreplyprocess" method="POST">
									답글 <input name="content"/>
									<input type="hidden" name="ssid" value="${vo.stockStudy.id}"/>
									<input type="hidden" name="sscid" value="${c.id}"/>
									<button type="submit" class="btn btn-dark">등록</button>
								</form>
							</c:if>
							<c:if test="${c.commentEnum == 'REPLY'}">
								<div class="marginl">
									답글 : ${c.id}. 내용 : ${c.content} 닉네임 : ${c.user.nickname}
									<form action="/ssreplyprocess" method="POST">
										답글 <input name="content"/>
										<input type="hidden" name="ssid" value="${vo.stockStudy.id}"/>
										<input type="hidden" name="sscid" value="${c.id}"/>
										<button type="submit" class="btn btn-dark">등록</button>
									</form>
								</div> 
							</c:if>
							
							
						</div>
						
					</c:forEach>
					<hr>
				</div>
				
				 
			</div>
			
		</div>
		
		
	</div>
</body>
</html>